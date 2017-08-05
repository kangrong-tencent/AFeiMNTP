package com.mntp.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/9/23
 *     desc  : 意图相关工具类
 * </pre>
 */
public class IntentUtils {

    private IntentUtils() {
        throw new UnsupportedOperationException("u can't fuck me...");
    }

    public static final String INTENT_KEY = "intent";


    /**
     * 普通跳转
     *
     * @param context 传入content而不是activity是为了fragment返回
     */
    public static <T> void intoIntent(Context context, Class<T> mClass) {
        intoIntent(context, mClass, null);
    }

    /**
     * 带参数跳转
     *
     * @param value 跳转时带的参数
     */
    public static <T, E> void intoIntent(Context context, Class<T> mClass, E value) {
        intoIntent(context, mClass, value, 0);
    }


    /**
     * 返回跳转
     *
     * @param value   跳转时带的参数
     * @param request 跳转返回的标识
     */
    public static <T, E> void intoIntent(Context context, Class<T> mClass, E value, int request) {
        Intent intent = new Intent(context, mClass);
        setIntent(intent, value); // value为空则不会传任何值
        if (request == 0) { // 跳转标识为0即不会进行返回操作
            context.startActivity(intent);
        } else {
            ((Activity) context).startActivityForResult(intent, request);
        }
    }


    /**
     * 返回
     *
     * @param requestCode 返回标识
     */
    public static void backIntent(Context context, int requestCode) {
        backIntent(context, requestCode, null);
    }

    /**
     * 返回
     *
     * @param requestCode 返回标识
     * @param value       返回值
     */
    public static <T> void backIntent(Context context, int requestCode, T value) {
        Intent intent = ((Activity) context).getIntent();
        setIntent(intent, value);// value为空则不会传任何值
        ((Activity) context).setResult(requestCode, intent);
        ((Activity) context).onBackPressed();
    }


    /**
     * 设置Intent的值
     */
    private static <E> void setIntent(Intent intent, E value) {
        if (value != null) {
            if (value instanceof Bundle) {
                intent.putExtra(INTENT_KEY, (Bundle) value);
            } else if (value instanceof String) {
                intent.putExtra(INTENT_KEY, (String) value);
            } else if (value instanceof Integer) {
                intent.putExtra(INTENT_KEY, (Integer) value);
            } else if (value instanceof Long) {
                intent.putExtra(INTENT_KEY, (Long) value);
            } else if (value instanceof Boolean) {
                intent.putExtra(INTENT_KEY, (Boolean) value);
            } else if (value instanceof Double) {
                intent.putExtra(INTENT_KEY, (Double) value);
            } else if (value instanceof Float) {
                intent.putExtra(INTENT_KEY, (Float) value);
            }
        }
    }

}
