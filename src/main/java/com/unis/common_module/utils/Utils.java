package com.unis.common_module.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public class Utils {

    public static String getPhoneNum(String pNumber) {
        String phoneNum = pNumber;
        if (!TextUtils.isEmpty(pNumber) && pNumber.length() > 6) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < pNumber.length(); i++) {
                char c = pNumber.charAt(i);
                if (i >= 3 && i <= 6) {
                    sb.append('*');
                } else {
                    sb.append(c);
                }
            }
            phoneNum = sb.toString();
        }
        return phoneNum;
    }

    public static String SubString(String contentStr) {
        if (!TextUtils.isEmpty(contentStr)) {
            contentStr = contentStr.replace("\\", "");
        }
        if (contentStr.startsWith("\"")) {
            contentStr = contentStr.substring(1, contentStr.length());
        }
        if (contentStr.endsWith("\"")) {
            contentStr = contentStr.substring(0, contentStr.length() - 1);
        }
        return contentStr;
    }

    public static boolean isBackground(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        boolean isBackground = true;
        String processName = "empty";
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(context.getPackageName())) {
                processName = appProcess.processName;
                if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_CACHED) {
                    isBackground = true;
                } else if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND
                        || appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_VISIBLE) {
                    isBackground = false;
                } else {
                    isBackground = true;
                }
            }
        }
        if (isBackground) {
            LogUtil.e("后台:" + processName);
        } else {
            LogUtil.e("前台+" + processName);
        }
        return isBackground;
    }

}
