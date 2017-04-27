package com.mntp.ui.base;

/**
 * view父类
 * 作者：kc on 2016/11/16.
 * qq：742174283.
 */
public interface BaseView {

    /**
     * loading界面
     */
    void loading();

    /**
     * 内容显示界面
     */
    void showContent();

    /**
     * 提示
     */
    void toastShow(String msg);

}
