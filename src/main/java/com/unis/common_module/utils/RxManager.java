package com.unis.common_module.utils;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.subjects.Subject;
import rx.subscriptions.CompositeSubscription;


public class RxManager {

    private RxBus mRxBus = RxBus.getInstance();
    private Map<String, Observable<?>> mObservables = new HashMap<String, Observable<?>>();// 管理观察源
    private CompositeSubscription mCompositeSubscription = new CompositeSubscription();// 管理订阅者者


    public void on(String eventName, Action1<Object> action1) {
        Observable<?> mObservable = mRxBus.register(eventName);
        mObservables.put(eventName, mObservable);
        mCompositeSubscription.add(mObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(action1, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                        on(eventName, action1);
                    }
                }));

    }

    public void onSticky(String eventName, Action1<Object> action1) {
        Observable<Object> mObservable = mRxBus.register(eventName);
        Subscription subscription = mRxBus.registerSticky(eventName, action1, (Subject) mObservable);
        if (null != mObservable)
            mObservables.put(eventName, mObservable);
        if (null != subscription)
            mCompositeSubscription.add(subscription);
    }

    public void add(Subscription m) {
        mCompositeSubscription.add(m);
    }

    public void clear() {
        mCompositeSubscription.unsubscribe();// 取消订阅
        for (Map.Entry<String, Observable<?>> entry : mObservables.entrySet())
            mRxBus.unregister(entry.getKey(), entry.getValue());// 移除观察
    }

    public void post(Object tag, Object content) {

        mRxBus.post(tag, content);
    }

    public void postSticky(Object tag, Object content) {
        mRxBus.postSticky(tag, content);
    }

    public void cancle() {
        mCompositeSubscription.clear();
    }

}
