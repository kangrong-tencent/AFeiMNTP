package com.mntp.ui.base;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mntp.utils.TUtils;

import butterknife.ButterKnife;

/**
 * 父类
 * 作者：kc on 2017/02/04.
 * qq：742174283.
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    public T mPresenter; // p

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 禁止横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // 设置布局
        setContentView(getLayoutId());
        getActivity().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        // 绑定butterknife
        ButterKnife.bind(this);
        // 子类p层
        mPresenter = TUtils.getT(this);
        // mvp实例化
        if (this instanceof BaseView) mPresenter.setVM(this);
        // 初始化
        this.initData();
    }

    /**
     * 销毁
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.onDestroy();
    }

    /**
     * Activity实例
     */
    protected abstract Activity getActivity();

    /**
     * xml布局文件
     */
    protected abstract int getLayoutId();

    /**
     * 初始化，代替onCreate
     */
    protected abstract void initData();

    /**
     * 回退
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
