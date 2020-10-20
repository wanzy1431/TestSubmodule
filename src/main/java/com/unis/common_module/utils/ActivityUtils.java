package com.unis.common_module.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityUtils {

    public static List<Activity> activities = new ArrayList<Activity>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    //com.unis.module_msg.view.SettingActivity
    public static void finishAllNoLogin() {
        for (Activity activity : activities) {
            if (!activity.isFinishing() && !activity.getComponentName().getClassName().equals("com.unis.module_login.login.view.LoginActivity")) {
                activity.finish();
            }
        }
    }

    public static Activity getTopActivity() {
        if (activities.isEmpty())
            return null;
        final int size = activities.size();
        if (size >= 1) {
            return activities.get(size - 1);
        } else {
            return null;
        }
    }
}
