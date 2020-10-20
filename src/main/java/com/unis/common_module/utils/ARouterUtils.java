package com.unis.common_module.utils;

import android.app.Activity;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.unis.common_module.router.RouterPath;

public class ARouterUtils {

    public static void goLogin() {
        ARouter.getInstance().build(RouterPath.LOGIN_LOGINACTIVITY).navigation();
    }

    public static void goSelectionWidget(Activity activity, int from, int requestCode) {
        Bundle bundle = new Bundle();
        bundle.putInt("intent_param_from", from);
        ARouter.getInstance().build(RouterPath.MSG_COMMONSELECTIONWIDGETACTIVITY)
                .with(bundle)
                .navigation(activity, requestCode);
    }

    public static void goWebViewActivity(String url) {
        goWebViewActivity(url, null);
    }

    public static void goWebViewActivity(String url, Bundle bundle) {
        if (bundle == null) {
            ARouter.getInstance().build(RouterPath.APP_WEBACTIVITY)
                    .withString("url", url)
                    .navigation();
        } else {
            ARouter.getInstance().build(RouterPath.APP_WEBACTIVITY)
                    .with(bundle)
                    .withString("url", url)
                    .navigation();
        }
    }

    public static void goStudentMain() {
        ARouter.getInstance().build(RouterPath.STUDENT_STUDENTACTIVITY).navigation();
    }


}
