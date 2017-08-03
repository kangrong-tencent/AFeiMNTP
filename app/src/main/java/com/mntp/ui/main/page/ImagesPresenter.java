package com.mntp.ui.main.page;

import com.mntp.utils.URLTool;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class ImagesPresenter extends ImagesContract.Presenter {


    /**
     * 页面开启时加载
     */
    @Override
    protected void onStart() {

    }

    /**
     * 初始化图片  下拉
     */
    @Override
    void loadImgs() {
        loadPager();
        getImgs();
    }


    /**
     * 刷新图片 上拉
     */
    @Override
    void refreshImgs() {
        increasePager();
        getImgs();
    }

    /**
     * 获取图片
     */
    private void getImgs() {
        subscriptions.add(htmlModel.getImgUrl(URLTool.getUrl(typeIMGs, pager))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> {
                    if (list.size() > 0) {
                        if (pager != 1) {
                            mView.refreshImsData(list);
                        } else {
                            mView.setImsData(list);
                        }
                    }
                }, throwable -> mView.toastShow(throwable.getMessage())));
    }

    /**
     * 设置图片类型
     *
     * @param typeIMGs
     */
    @Override
    void setTypeIMGs(int typeIMGs) {
        this.typeIMGs = typeIMGs;
    }

    /**
     * 将页数置0
     */
    @Override
    void loadPager() {
        pager = 1;
    }

    /**
     * 将页数加 1
     */
    @Override
    void increasePager() {
        pager++;
    }

    @Override
    void unsubscribe() {
        for(Subscription subscriber:subscriptions){
            subscriber.unsubscribe();
        }
    }
}
