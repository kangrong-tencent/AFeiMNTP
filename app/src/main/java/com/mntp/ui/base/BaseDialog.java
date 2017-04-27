package com.mntp.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.zhy.autolayout.utils.AutoUtils;

/**
 * dialog父类
 * 作者：kc on 2016/7/27.
 * qq：742174283
 */
public abstract class BaseDialog extends Dialog {
    private Context context;

    public BaseDialog(Context context) {
        super(context);
        this.context = context;
    }

    public BaseDialog(Context context, int theme) {
        super(context, theme);
        this.context = context;
    }

    protected BaseDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.context = context;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = LayoutInflater.from(context).inflate(getLayout(), null);
        AutoUtils.auto(view);
        setContentView(view);
        initView();
        initWindow();
        initData();
    }

    protected void initWindow() {
        Window window = this.getWindow();
        window.setLayout(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        window.setGravity(initGravity());
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager m =  ((Activity)context).getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = window.getAttributes(); // 获取对话框当前的参数值
//        p.width = d.getWidth();
        p.width = AutoUtils.getPercentWidthSizeBigger(980);
        window.setAttributes(p);
    }


    /**
     * 显示dialog
     */
    public void dialogShow() {
        if (!isShowing()) {
            show();
        }
    }

    /**
     * 关闭dialog
     */
    public void dialogDismiss() {
        if (isShowing()) {
            dismiss();
        }
    }

    /**
     * 子类layout
     */
    public abstract int getLayout();

    /**
     * 实例化
     */
    protected abstract void initView();

    /**
     * 实现居中
     */
    protected abstract int initGravity();

    /**
     * 数据处理
     */
    protected abstract void initData();


}
