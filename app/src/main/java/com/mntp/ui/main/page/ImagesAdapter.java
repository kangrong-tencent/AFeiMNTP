package com.mntp.ui.main.page;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.afeimntp.R;
import com.mntp.entity.ImageInfo;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.BillViewHolder> {

    private Context mContext;
    private List<ImageInfo> lists;

    /**
     * 构造方法
     */
    public ImagesAdapter(Context mContext, List<ImageInfo> lists) {
        this.mContext = mContext;
        this.lists = lists;
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
     * 设值
     */
    @Override
    public void onBindViewHolder(BillViewHolder holder, int position) {
        ImageInfo imageInfo = getItem(position);
        Glide.with(mContext)
                .load(imageInfo.getImgUrl())
                .placeholder(Color.parseColor("#87CEFA"))
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
    public class BillViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_img)
        ImageView img; // 图标

        public BillViewHolder(View itemView) {
            super(itemView);
            AutoUtils.auto(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}