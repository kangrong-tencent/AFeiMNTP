package com.mntp.ui.main.page.browse;


import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BaseTarget;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.example.administrator.afeimntp.R;
import com.mntp.ui.base.BaseFragment;
import com.mntp.utils.SaveImgUtils;
import com.shizhefei.view.largeimage.LargeImageView;
import com.shizhefei.view.largeimage.factory.FileBitmapDecoderFactory;

import java.io.File;

import butterknife.BindView;

/**
 * Created by afei on 2017/8/7 0027.
 */
public class BrowseFragment extends BaseFragment {

    @BindView(R.id.id_browse_img)
    LargeImageView browseImg;//图片显示控件

    String imgUrl;//图片路径
    File file; //图片文件
    public BrowseFragment() {
        super();
    }

    @SuppressLint("ValidFragment")
    public BrowseFragment(String imgUrl) {
        super();
        this.imgUrl = imgUrl;
    }
    /**
     * 子类必须实现的初始化
     */
    @Override
    public int getLayoutId() {
        return R.layout.fragment_browse;
    }

    /**
     * 初始化数据
     */
    @Override
    public void initData() {
        Glide.with(getActivity()).load(imgUrl).downloadOnly(new SimpleTarget<File>() {
            @Override
            public void onResourceReady(File resource, GlideAnimation<? super File> glideAnimation) {
                browseImg.setImage(new FileBitmapDecoderFactory(resource));
                file=resource;
            }
        });
    }

    public void saveImg(){
        if(file==null) return;
        SaveImgUtils.saveImgToGallery(file);
    }

}
