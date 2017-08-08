package com.mntp.ui.main.page.browse;

import android.support.v4.app.Fragment;

import com.mntp.ui.base.BasePresenter;
import com.mntp.ui.base.BaseView;

import java.util.ArrayList;
import java.util.List;

public interface BrowseContract {

    interface View extends BaseView {

        /**
         * 设置页面
         * @param lists
         */
        void setPager(List<BrowseFragment> lists);
    }

    abstract class Presenter extends BasePresenter<View> {

        String url=null;
        List<BrowseFragment> fragments = new ArrayList<>();

        /////////////////////////////  网络操作  /////////////////////////////


        /////////////////////////////  本地操作  /////////////////////////////

        /**
         * 初始化
         */
        abstract void loadPager();

        /**
         * 设置图片浏览地址
         */
        abstract void setUrl(String url);
    }

}
