package com.unis.common_module.base;


import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BaseHolder extends RecyclerView.ViewHolder {

    private Unbinder bind;

    public BaseHolder(View view) {
        super(view);
        if (null != view)
            bind = ButterKnife.bind(this, view);
    }

    public void unBind() {
        if (null != bind) bind.unbind();
    }
}
