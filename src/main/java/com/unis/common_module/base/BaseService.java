package com.unis.common_module.base;

import android.app.Service;
import android.content.Context;

import com.unis.common_module.utils.TypeUtil;


public abstract class BaseService<T extends BasePresenter, E extends BaseModel> extends Service {
    public T mPresenter;
    protected Context mContext;
    public E mModel;

    protected BaseService() {
        mContext = this;
    }
    //public E mModel;

    protected abstract void processData();


    public Context getIContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        mPresenter = TypeUtil.getT(this, 0);
        mModel = TypeUtil.getT(this, 1);
        if (mPresenter != null) mPresenter.setVM(this, mModel);
        processData();
    }


}