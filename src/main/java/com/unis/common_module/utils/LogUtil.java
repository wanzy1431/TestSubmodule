package com.unis.common_module.utils;

import android.text.TextUtils;
import android.util.Log;

import com.unis.common_module.config.MoxinConfig;

public class LogUtil {
    public static boolean isDebug = MoxinConfig.DEBUG;

    private final static String APP_TAG = "MO_XIN";

    /**
     * 获取相关数据:类名,方法名,行号等.用来定位行<br>
     * 就是用來定位行的代碼<br>
     *
     * @return [ Thread:main, at
     * cn.utils.MainActivity.onCreate(MainActivity.java:17)]
     */
    private static String getFunctionName() {
        StackTraceElement[] sts = Thread.currentThread().getStackTrace();
        if (sts != null) {
            for (StackTraceElement st : sts) {
                if (st.isNativeMethod()) {
                    continue;
                }
                if (st.getClassName().equals(Thread.class.getName())) {
                    continue;
                }
                if (st.getClassName().equals(LogUtil.class.getName())) {
                    continue;
                }
                return "[" + st.getClassName() + "." + st.getMethodName()
                        + "(" + st.getFileName() + ":" + st.getLineNumber() + ")" + " ]";
            }
        }
        return null;
    }

    public static void e(String msg) {
        if (isDebug) {
            if (!TextUtils.isEmpty(msg) && !"null".equals(msg)) {
                printJson(msg, getFunctionName());
            }
        }
    }

    public static void printJson(String msg, String headString) {
        if (!TextUtils.isEmpty(msg) && !"null".equals(msg)) {
            if (true == isDebug) {
                Log.e(APP_TAG, "═══════════════════════════════start════════════════════════════════");
                Log.e(APP_TAG, headString);
                Log.e(APP_TAG, msg);
                Log.e(APP_TAG, "═══════════════════════════════end══════════════════════════════════");
            }
        }
    }


}

