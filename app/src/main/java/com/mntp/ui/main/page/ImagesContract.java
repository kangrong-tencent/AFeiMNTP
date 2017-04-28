package com.mntp.ui.main.page;

import com.mntp.entity.ImageInfo;
import com.mntp.ui.base.BasePresenter;
import com.mntp.ui.base.BaseView;

import java.util.List;

public interface ImagesContract {

    interface View extends BaseView {

        /**
         * 设置图片列表
         * @param list
         */
        void setImsData(List<ImageInfo> list);
    }

    abstract class Presenter extends BasePresenter<View> {

        int typeIMGs,pager;

        /////////////////////////////  网络操作  /////////////////////////////

        /**
         * 初始化图片  下拉
         */
        abstract void loadImgs();

        /**
         * 刷新图片 上拉
         */
        abstract void refreshImgs();

        /////////////////////////////  本地操作  /////////////////////////////

        /**
         * 设置图片类型
         * @param typeIMGs
         */
        abstract void setTypeIMGs(int typeIMGs);

        /**
         * 将页数置0
         */
        abstract void loadPager();

        /**
         * 将页数加 1
         */
        abstract void increasePager();
    }

}
