package com.unis.common_module.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.unis.common_module.R;
import com.unis.common_module.bean.SelectSessionBean;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SelectCommonSessionAdapter extends BaseQuickAdapter<SelectSessionBean, BaseViewHolder> {

    public SelectCommonSessionAdapter(int layoutResId, @Nullable List<SelectSessionBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, SelectSessionBean sessionBean) {
        Glide.with(getContext()).load(sessionBean.getUserPhoto()).placeholder(R.mipmap.default_head).circleCrop().into((ImageView) baseViewHolder.getView(R.id.iv_dialog_common_select_session_head));
    }

}
