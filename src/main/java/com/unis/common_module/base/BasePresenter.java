package com.unis.common_module.base;


import com.unis.common_module.utils.RxManager;

public abstract class BasePresenter<M, V> {
    public M mModel;
    public V mView;
    public RxManager mRxManager = new RxManager();

    public void setVM(V v, M m) {
        this.mView = v;
        this.mModel = m;
        this.onStart();
    }

    protected abstract void onStart();

    public void onDestroy() {
        mRxManager.clear();
    }

}

