package com.unis.common_module.service;


import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.unis.common_module.receiver.TimeChangeReceiver;


public class UpdateTimeService extends Service {

    private TimeChangeReceiver timeChangeReceiver;

    @Override
    public void onCreate() {
        super.onCreate();
        //组册广播
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_TIME_TICK);
        timeChangeReceiver = new TimeChangeReceiver();
        registerReceiver(timeChangeReceiver, filter);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(timeChangeReceiver);
    }
}
