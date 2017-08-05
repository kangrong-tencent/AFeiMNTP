package com.mntp.ui.main.page.browse;

import com.mntp.ui.main.page.ImagesFragment;
import com.mntp.utils.URLTool;

public class BrowsePresenter extends BrowseContract.Presenter {


    /**
     * 页面开启时加载
     */
    @Override
    protected void onStart() {

    }

    /**
     * 初始化图片页面
     */
    @Override
    void loadPager() {
        fragments.add(new ImagesFragment(URLTool.CID_SUOYOU));
        mView.setPager(fragments);
    }

    @Override
    void setUrl(String url) {
        this.url = url;
    }
}
