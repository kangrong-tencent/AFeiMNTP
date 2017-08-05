package com.mntp.ui.main.page.browse;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.example.administrator.afeimntp.R;
import com.mntp.entity.ImageInfo;
import com.mntp.ui.base.BaseFragment;
import com.mntp.ui.main.page.ImagesAdapter;
import com.mntp.ui.main.page.ImagesContract;
import com.mntp.ui.main.page.ImagesPresenter;
import com.mntp.utils.IntentUtils;
import com.mntp.utils.RecyclerViewUtils;
import com.mntp.widget.custom.rv.SpacesItemDecoration;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

import butterknife.BindView;

/**
 * Created by afei on 2017/4/27 0027.
 */
public class BrowseFragment extends BaseFragment {

    @BindView(R.id.id_images_rv)
    RecyclerView imagesRv;//图片显示控件

    ImagesAdapter imagesAdapter;//图片数据源

    int ImgType; //默认全部显示

    public BrowseFragment() {
        super();
    }

    @SuppressLint("ValidFragment")
    public BrowseFragment(int ImgType) {
        super();
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

    }

}
