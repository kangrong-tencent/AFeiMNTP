package com.mntp.ui.main;

import android.support.v4.app.Fragment;

import com.mntp.ui.base.BasePresenter;
import com.mntp.ui.base.BaseView;

import java.util.ArrayList;
import java.util.List;

public interface MainContract {

    interface View extends BaseView {


        /**
         * 设置标题
         * @param tab
         */
        void setTab(List<String> tab);

        /**
         * 设置页面
         * @param lists
         */
        void setPager(List<Fragment> lists);
    }

    abstract class Presenter extends BasePresenter<View> {

        List<String> strings = new ArrayList<>();
        List<Fragment> fragments = new ArrayList<>();

        /////////////////////////////  网络操作  /////////////////////////////


        /////////////////////////////  本地操作  /////////////////////////////

        /**
         * 初始化图片页面
         */
        abstract void loadPager();
    }

}
