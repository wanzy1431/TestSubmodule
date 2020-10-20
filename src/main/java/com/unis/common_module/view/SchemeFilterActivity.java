package com.unis.common_module.view;

import android.net.Uri;

import com.alibaba.android.arouter.launcher.ARouter;
import com.unis.common_module.R;
import com.unis.common_module.base.BaseActivity;
import com.unis.common_module.base.EmptyModel;
import com.unis.common_module.base.EmptyPresenter;

public class SchemeFilterActivity extends BaseActivity<EmptyPresenter, EmptyModel> {

    @Override
    protected void setLayout() {
        setView(R.layout.activity_scheme_filter, TYPE_NORMAL);

    }

    @Override
    protected void processData() {
        Uri uri = getIntent().getData();
        ARouter.getInstance().build(uri).navigation();
        finish();
    }

    @Override
    protected void back() {

    }
}