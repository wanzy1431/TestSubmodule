package com.unis.common_module.net;

import com.google.gson.Gson;
import com.unis.common_module.bean.BaseBean;
import com.unis.common_module.utils.LogUtil;

import retrofit2.HttpException;
import rx.Subscriber;


public class ISubscriber<T> extends Subscriber<T> {

    public ICallback<T> iCallback;
    public String TAG;

    public ISubscriber(ICallback<T> iCallback, String TAG) {
        this.iCallback = iCallback;
        this.TAG = TAG;
    }


    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        LogUtil.e(e.getMessage());
        String errMsg = e.getMessage();
//        if (errMsg.contains("500") || errMsg.contains("501") || errMsg.contains("502") || errMsg.contains("503")) {
//            errMsg = "服务器异常";
//        } else if (errMsg.contains("400") || errMsg.contains("401") || errMsg.contains("402") || errMsg.contains("403") || errMsg.contains("404") || errMsg.contains("407") || errMsg.contains("415")) {
//            errMsg = "请求异常" + e.getMessage();
//        }
        BaseBean baseBean = null;
        if (e instanceof HttpException) {
            try {
                Gson gson = new Gson();
                baseBean = gson.fromJson(((HttpException) e).response().errorBody().string(), BaseBean.class);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (baseBean == null) {
            baseBean = new BaseBean();
            baseBean.setMsg(errMsg);
        }
        if (baseBean.getMsg() == null || baseBean.getMsg().equals("")) {
            baseBean.setMsg(errMsg);
        }
        LogUtil.e(errMsg);
        iCallback.onFailure(TAG, e.toString(), baseBean);
    }

    @Override
    public void onNext(T t) {
        iCallback.onResponse(TAG, t);
    }
}
