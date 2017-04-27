package com.mntp.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mntp.utils.TUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<T extends BasePresenter> extends Fragment  {
    public T mPresenter; // p
    private Unbinder unbinder;
    public Activity mActivity;
    View view;
    /**
     * Fragment被创建
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();// 获取所在的activity对象
    }

    /**
     * 初始化Fragment布局
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutId(), null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    /**
     * activity创建结束
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = TUtils.getT(this);
        // mvp实例化
        if (this instanceof BaseView) mPresenter.setVM(this);
        initData();
    }

    /**
     * 销毁
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.onDestroy();
        unbinder.unbind();
    }

    /**
     * 子类必须实现的初始化
     */
    public abstract int getLayoutId();

    /**
     * 初始化数据
     */
    public abstract void initData();

    public View getLayoutView(){
        return view;
    }
}
