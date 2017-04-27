package com.mntp.ui.main.page;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.administrator.afeimntp.R;
import com.mntp.ui.base.BaseFragment;
import com.mntp.widget.custom.rv.SpacesItemDecoration;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;

/**
 * Created by afei on 2017/4/27 0027.
 */
public class ImagesFragment extends BaseFragment<ImagesPresenter> implements ImagesContract.View {

    @BindView(R.id.id_images_rv)
    RecyclerView idImagesRv;

    int ImgType; //默认全部显示

    public ImagesFragment() {}

    public ImagesFragment(int ImgType) {
        this.ImgType = ImgType;
    }

    /**
     * 子类必须实现的初始化
     */
    @Override
    public int getLayoutId() {
        return R.layout.fragment_images;
    }

    /**
     * 初始化数据
     */
    @Override
    public void initData() {
        idImagesRv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        //设置item之间的间隔
        int SDh = AutoUtils.getPercentHeightSizeBigger(16);
        SpacesItemDecoration decoration = new SpacesItemDecoration(SDh);
        idImagesRv.addItemDecoration(decoration);
    }

    /**
     * loading界面
     */
    @Override
    public void loading() {

    }

    /**
     * 内容显示界面
     */
    @Override
    public void showContent() {

    }

    /**
     * 提示
     *
     * @param msg
     */
    @Override
    public void toastShow(String msg) {

    }
}
