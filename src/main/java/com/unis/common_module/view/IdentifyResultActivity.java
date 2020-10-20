package com.unis.common_module.view;

import android.os.Bundle;
import android.widget.TextView;

import com.unis.common_module.R;
import com.unis.common_module.R2;
import com.unis.common_module.base.BaseActivity;
import com.unis.common_module.base.EmptyModel;
import com.unis.common_module.base.EmptyPresenter;
import com.unis.common_module.config.Event;
import com.unis.common_module.utils.RxManager;

import butterknife.BindView;

//识别结果
public class IdentifyResultActivity extends BaseActivity<EmptyPresenter, EmptyModel> {
    @BindView(R2.id.tv_identify_result_show)
    TextView tvShow;

    private RxManager rxManager;
    private String result;

    @Override
    protected void setLayout() {
        setView(R.layout.activity_identify_result, TYPE_HEADER);
        setHeaderBar("识别结果");

    }

    @Override
    protected void processData() {
        rxManager = new RxManager();
        Bundle bundle = getIntent().getExtras();
        result = bundle.getString("result");
        tvShow.setText(result);
    }

    @Override
    protected void back() {
        rxManager.post(Event.FINISH_CAPTURE, true);
        finish();
    }

    @Override
    protected void onDestroy() {
        rxManager.clear();
        super.onDestroy();
    }
}