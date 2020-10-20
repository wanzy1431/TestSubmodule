package com.unis.common_module.fileupload;

import com.google.gson.Gson;
import com.unis.common_module.utils.LogUtil;

import java.io.File;
import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Copyright (C), 2020-2020, by UNIS company
 * FileName: UploadManager
 * Author: zhangyibin
 * Date: 2020/8/19 17:19
 * Description:
 */
public class UploadManager<T> implements UploadProgressListener {
    private File file;
    private UploadFileAPI uploadFileAPI;
    private UploadInfo mUploadInfo;
    private int mUploadStatus = UploadConfig.STATUS_DEFAULT;
    private Subscription subscription;
    private ArrayDeque<String> mDeque;//消息队列
    private String uploadUrl;//上传地址
    private UploadListener mUploadListener;//上传监听
    private T bean;
    private Gson gson;
    private String biztype = "";//上传页面

    private UploadManager(String uploadUrl, UploadListener uploadListener, T bean) {
        gson = new Gson();
        mDeque = new ArrayDeque<>();//初始化队列
        this.uploadUrl = uploadUrl;
        this.mUploadListener = uploadListener;
        OkHttpClient mClient = new OkHttpClient.Builder()//初始化client
                .connectTimeout(3, TimeUnit.SECONDS)
                .addInterceptor(new HeaderInterceptor())
                .build();
        Retrofit mRetrofit = new Retrofit.Builder()//初始化retrofit
                .client(mClient)
                .baseUrl(UploadConfig.UPLOAD_BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        this.uploadFileAPI = mRetrofit.create(UploadFileAPI.class);//初始化API;
        this.bean = bean;
    }

    public void setBizType(String type) {
        this.biztype = type;
    }

    /*
     *
     * 构造者模式创建对象
     * */
    public static final class Builder<T> {
        private String uploadUrl;
        private UploadListener mUploadListener;
        private T bean;

        public Builder<T> uploadUrl(String uploadUrl) {
            this.uploadUrl = uploadUrl;
            return this;
        }

        public Builder<T> listener(UploadListener<T> listener) {
            this.mUploadListener = listener;
            return this;
        }

        public Builder<T> initClass(Class aClass) {
            try {
                bean = (T) aClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return this;
        }

        public UploadManager<T> builder() {
            return new UploadManager<>(uploadUrl, mUploadListener, bean);
        }
    }


    /*
     * 开始上传
     * */
    public void start(String url) {
        if (null == url || "".equals(url)) {
            LogUtil.e("uploadmanager-start：" + "url为空");
            return;
        }
        //生成file
        file = new File(url);
        //file = new File(SDCardUtils.getSDCardPathByEnvironment() + "/HitvAppStore/download/7294871597489361178.apk");
        if (!file.exists()) {
            LogUtil.e("uploadmanager-start：" + "文件不存在");
            return;
        }
        if (mUploadStatus == UploadConfig.STATUS_DOWING) {
            LogUtil.e("uploadmanager-start：" + "文件上传中");
            return;
        }
        if (mUploadInfo == null) {
            mUploadInfo = new UploadInfo();
        }
        //数据组装
        mUploadInfo.setComplete(false);
        mUploadInfo.setContentLength(file.length());
        mUploadInfo.setFilePath(url);
        mUploadInfo.setReadLength(0);
        lastTimeStamp = System.currentTimeMillis();
        //设置当前上传状态-开始
        mUploadStatus = UploadConfig.STATUS_START;
        //start状态接口回调
        mUploadListener.start(mUploadInfo.getFilePath());
        //组装上传body
        MultipartBody.Builder builder = new MultipartBody.Builder();
        FileRequestBody requestBody = new FileRequestBody(file, "multipart/form-data", this);
        builder.addFormDataPart("file", file.getName(), requestBody);
        builder.setType(MultipartBody.FORM);
        MultipartBody build = builder.build();
        //开启轮询 1秒一获取
        delayProgress();
        //开始调用上传接口
        uploadFileAPI.uploadFile(uploadUrl, biztype, build)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mUploadStatus = UploadConfig.STATUS_ERROR;
                        mUploadListener.error(mUploadInfo.getFilePath(), e.toString());
                        lastRead = 0;
                        if (0 != mDeque.size()) {
                            start(mDeque.poll());
                        }
                    }

                    @Override
                    public void onNext(Object fileUploadBean) {
                        mUploadStatus = UploadConfig.STATUS_COMPLETE;
                        LogUtil.e(fileUploadBean.toString());
                        bean = (T) gson.fromJson(gson.toJson(fileUploadBean), bean.getClass());
                        mUploadListener.complete(mUploadInfo.getFilePath(), bean);
                        mUploadInfo.setComplete(true);
                        lastRead = 0;
                        if (0 != mDeque.size()) {
                            start(mDeque.poll());
                        }
                    }
                });

    }

    /*
     * 批量任务开始
     * */
    public void start(List<String> mList) {
        if (mList.isEmpty()) return;
        for (String str : mList) {
            mDeque.add(str);
        }
        start(mDeque.poll());
    }

    /*
     * 文件上传中
     * */
    @Override
    public void progress(long read) {
        mUploadInfo.setReadLength(read);
        mUploadInfo.setComplete(false);
        mUploadStatus = UploadConfig.STATUS_DOWING;
    }


    /*
     * 轮询获取进度，一秒一获取，直到状态改变
     * */
    private void delayProgress() {
        subscription = Observable.interval(UploadConfig.SPEED_REFRESH_UI_TIME, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> {
                    if (mUploadStatus == UploadConfig.STATUS_DOWING) {
                        /*
                         * 下载中：
                         * 1.计算速率
                         * 2.接口回调
                         * */
                        getSpeed();
                        mUploadListener.progress(mUploadInfo.getReadLength(), mUploadInfo.getContentLength(), mUploadInfo.getFilePath(), speed);
                    } else {
                        //除了下载中，其他全部情况停止轮询
                        if (null != subscription) {
                            subscription.unsubscribe();
                        }
                    }
                });
    }

    /*
     * 计算下载速度
     * */
    // 最近一次计算时间
    long lastTimeStamp;
    // 上次读写的数据
    long lastRead;
    // 下载速度
    long speed;

    protected void getSpeed() {
        long nowTimeStamp = System.currentTimeMillis();
        if (nowTimeStamp - lastTimeStamp < UploadConfig.SPEED_REFRESH_UI_TIME * 1000) return;
        speed = ((mUploadInfo.getReadLength() - lastRead) / ((nowTimeStamp - lastTimeStamp) / 1000));
        lastTimeStamp = nowTimeStamp;
        lastRead = mUploadInfo.getReadLength();
    }

}
