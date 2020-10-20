package com.unis.common_module.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.unis.common_module.R;
import com.unis.common_module.bean.ImageContentBean;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ImageContentAdapter extends BaseQuickAdapter<ImageContentBean, BaseViewHolder> {

    public ImageContentAdapter(int layoutResId, @Nullable List<ImageContentBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, ImageContentBean imageContentBean) {
        Glide.with(getContext()).load(imageContentBean.getThumb()).placeholder(R.mipmap.default_img).into((ImageView) baseViewHolder.getView(R.id.iv_dialog_common_select_session_head));
    }
}
