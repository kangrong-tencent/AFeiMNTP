package com.mntp.ui.main.page.browse;

import com.mntp.entity.ImageInfo;
import com.mntp.model.HtmlModel;
import com.mntp.ui.main.page.ImagesFragment;
import com.mntp.utils.URLTool;

import rx.android.schedulers.AndroidSchedulers;

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
        new HtmlModel()
                .getInfoImgUrl(url)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(imgs -> {
                    for(ImageInfo img:imgs){
                        fragments.add(new BrowseFragment(img.getImgUrl()));
                    }
                    mView.setPager(fragments);
                });

    }

    @Override
    void setUrl(String url) {
        this.url = url;
    }
}
