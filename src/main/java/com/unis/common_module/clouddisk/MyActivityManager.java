package com.unis.common_module.clouddisk;

import android.app.Activity;

import java.lang.ref.WeakReference;

public class MyActivityManager {

    private static MyActivityManager mInstance = new MyActivityManager();

    private WeakReference<Activity> sCurrentActivityWeakRef;

    public MyActivityManager() {

    }

    public static MyActivityManager getInstance() {
        return mInstance;
    }

    public Activity getCurrentActivity() {
        Activity currentActivity = null;
        if (sCurrentActivityWeakRef != null) {
            currentActivity = sCurrentActivityWeakRef.get();
        }
        return currentActivity;
    }

    public void setCurrentActivity(Activity activity) {
        sCurrentActivityWeakRef = new WeakReference<Activity>(activity);
    }

}
