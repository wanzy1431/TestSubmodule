package com.unis.common_module.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.unis.common_module.config.Event;
import com.unis.common_module.utils.RxBus;


public class TimeChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_TIME_TICK)) {
            setTimeChange();
        }
    }

    private void setTimeChange() {
        RxBus.getInstance().post(Event.TIME_CHANGE, "");
    }
}
