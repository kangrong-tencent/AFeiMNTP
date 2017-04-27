package com.mntp.ui.main;

import android.app.Activity;

import com.example.administrator.afeimntp.R;
import com.mntp.ui.base.BaseActivity;

public class MainActivity extends BaseActivity<MainPresenter> {

    /**
     * Activity实例
     */
    @Override
    protected Activity getActivity() {
        return this;
    }

    /**
     * xml布局文件
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    /**
     * 初始化，代替onCreate
     */
    @Override
    protected void initData() {

    }
}
