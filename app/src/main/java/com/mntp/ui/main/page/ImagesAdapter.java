package com.mntp.ui.main.page;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapper;
import com.example.administrator.afeimntp.R;
import com.mntp.entity.ImageInfo;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;

import java.io.OutputStream;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.BillViewHolder> {

    private Context mContext;
    private List<ImageInfo> lists;
    private ItemOnClickListener listener;
    int wide,hight;
    /**
     * 构造方法
     */
    public ImagesAdapter(Context mContext, List<ImageInfo> lists) {
        this.mContext = mContext;
        this.lists = lists;
        wide = AutoUtils.getPercentWidthSizeBigger(500);
        hight = AutoUtils.getPercentHeightSizeBigger(800);
    }

    public void addLists(List<ImageInfo> lists) {
        this.lists.addAll(lists);
    }

    /**
     * 绑定layout
     */
    @Override
    public BillViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(mContext).inflate(R.layout.item_images, parent, false);
        return new BillViewHolder(inflatedView);
    }

    /**
     * 点击事件
     */
    public void setOnItemClickListener(ItemOnClickListener listener) {
        this.listener = listener;
    }

    /**
     * 设值
     */
    @Override
    public void onBindViewHolder(BillViewHolder holder, int position) {
        ImageInfo imageInfo = getItem(position);
        Glide.with(mContext)
                .load(imageInfo.getImgUrl())
                .placeholder(Color.parseColor("#87CEFA"))
                .error(R.color.color_4a95ea)
                .override(wide, hight)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(holder.img);
    }

    /**
     * item数量
     */
    @Override
    public int getItemCount() {
        return lists.size();
    }


    /**
     * 根据position获取lists里面的值
     *
     * @param position 位置
     */
    public ImageInfo getItem(int position) {
        return lists.get(position);
    }


    /**
     * 自定义的ViewHolder
     */
    public class BillViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.item_img)
        ImageView img; // 图标

        private ItemOnClickListener mlistener;

        public BillViewHolder(View itemView) {
            super(itemView);
            AutoUtils.auto(itemView);
            ButterKnife.bind(this, itemView);
            this.mlistener=listener;
        }


        @Override
        public void onClick(View v) {
            if (mlistener != null) {
                mlistener.click(v, getPosition());
            }
        }
    }

    public interface ItemOnClickListener{
        void click(View view,int position);
    }
}