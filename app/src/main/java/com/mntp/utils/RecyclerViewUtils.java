package com.mntp.utils;

import android.support.v7.widget.RecyclerView;

/**
 * @author  afei
 * created at 2017/3/6 0006 17:27
 *      RecyclerView工具类
 */
public class RecyclerViewUtils {

    public static boolean isSlideToBottom(RecyclerView recyclerView) {
        if (recyclerView == null) return false;
        if (recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset() >= recyclerView.computeVerticalScrollRange())
            return true;
        return false;
    }
}
