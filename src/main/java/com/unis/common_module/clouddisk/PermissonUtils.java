package com.unis.common_module.clouddisk;

import android.content.Context;

import com.unis.common_module.R;
import com.unis.common_module.utils.ToastUtil;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;

public class PermissonUtils {

    private final static int CODE_REQUERST_SETTING = 4410;

    public interface GrantedResult {
        void onSuccess();

        void onFail();
    }

    public static void grantStoragePermission(Context context, GrantedResult grantedResult) {
        AndPermission.with(context)
                .runtime()
                .permission(Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE).onGranted(data -> {
            grantedResult.onSuccess();
        }).onDenied(data -> {
            grantedResult.onFail();
            ToastUtil.toastShortMessage(context.getString(R.string.cloud_no_permission_storage));
            AndPermission.with(context).runtime().setting().start(CODE_REQUERST_SETTING);
        }).start();
    }

    public static void grantCameraPermission(Context context, GrantedResult grantedResult) {
        AndPermission.with(context)
                .runtime()
                .permission(Permission.CAMERA).onGranted(data -> {
            grantedResult.onSuccess();
        }).onDenied(data -> {
            grantedResult.onFail();
            ToastUtil.toastShortMessage(context.getString(R.string.cloud_no_permission_storage));
            AndPermission.with(context).runtime().setting().start(CODE_REQUERST_SETTING);
        }).start();
    }
}
