package com.mntp.ui.main;

import com.mntp.ui.main.page.ImagesFragment;
import com.mntp.utils.URLTool;

public class MainPresenter extends MainContract.Presenter {


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
        strings.add("全部");
        fragments.add(new ImagesFragment(URLTool.CID_SUOYOU));

        strings.add("大胸脯");
        fragments.add(new ImagesFragment(URLTool.CID_DAXIONG));

        strings.add("美腿儿");
        fragments.add(new ImagesFragment(URLTool.CID_MEITUI));

        strings.add("清新风");
        fragments.add(new ImagesFragment(URLTool.CID_QINGXIN));

        strings.add("大杂烩");
        fragments.add(new ImagesFragment(URLTool.CID_ZHAHUI));

        strings.add("小翘臀");
        fragments.add(new ImagesFragment(URLTool.CID_QIAOTUN));

        strings.add("黑丝袜");
        fragments.add(new ImagesFragment(URLTool.CID_SIWA));
        mView.setTab(strings);
        mView.setPager(fragments);
    }
}
