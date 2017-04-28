package com.mntp.ui.base;


import com.mntp.model.HtmlModel;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;

/**
 * Presenter父类
 * 作者：kc on 2016/11/16.
 * qq：742174283.
 */
public abstract class BasePresenter<T> {
    protected T mView; // view层

    protected List<Subscription> mRxManage = new ArrayList<>(); // rx管理器

    protected HtmlModel htmlModel = new HtmlModel();//爬虫网络层

    /**
     * 设置view和model
     */
    public void setVM(T v) {
        this.mView = v;
        this.onStart();
    }

    /**
     * 页面开启时加载
     */
    protected abstract void onStart();

    /**
     * 添加事件到控制器
     *
     * @param subscription
     */
    public void addRX(Subscription subscription) {
        mRxManage.add(subscription);
    }

    public void onDestroy() {
        if (mRxManage != null)
            for (Subscription subscription : mRxManage) {
                subscription.unsubscribe();
            }
    }

}
