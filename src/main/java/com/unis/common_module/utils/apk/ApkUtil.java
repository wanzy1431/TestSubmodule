package com.unis.common_module.utils.apk;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;

import com.unis.common_module.bean.BaseBean;
import com.unis.common_module.config.Constants;
import com.unis.common_module.net.HttpAPI;
import com.unis.common_module.net.ICallback;
import com.unis.common_module.net.IRequest;
import com.unis.common_module.net.ISubscriber;
import com.unis.common_module.net.RxSchedulers;
import com.unis.common_module.utils.LogUtil;
import com.unis.common_module.utils.RxManager;
import com.unis.common_module.utils.permission.RxPermissions;
import com.unis.common_module.widget.DialogUtils;
import com.unis.common_module.widget.IToast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import okhttp3.ResponseBody;
import rx.Observable;

public class ApkUtil {
    private volatile static ApkUtil mSingleton = null;
    private Context mContext;
    private String downUrl;
    private RxPermissions rxPermissions;
    private RxManager rxManager;

    private ApkUtil() {

    }

    public static ApkUtil getInstance() {
        if (mSingleton == null) {
            synchronized (ApkUtil.class) {
                if (mSingleton == null) {
                    mSingleton = new ApkUtil();
                }
            }
        }
        return mSingleton;
    }

    public void initView(Context context) {
        this.mContext = context;
        rxPermissions = new RxPermissions((FragmentActivity) mContext);
        rxManager = new RxManager();
    }

    public void downApk() {
        //ProgressDialogUtil.getInstance().init(mContext,"正在下载");
        IToast.getIToast().show("正在下载~");
        rxManager.add(download(downUrl).subscribe(new ISubscriber<>(new ICallback<ResponseBody>() {
            @Override
            public void onResponse(String str, ResponseBody result) {
                FileOutputStream outputStream = null;
                InputStream inputStream = null;
                try {
                    File folder = new File(Constants.TEACHING_APK);
                    if (!folder.exists()) {
                        folder.mkdirs();
                    }
                    String suf = ".apk";
                    //文件的名字
                    String fileName = System.currentTimeMillis() / 1000 + "";
                    String saveFileName = Constants.TEACHING_APK + File.separator + fileName + suf;
                    long total = result.contentLength();
                    inputStream = result.byteStream();
                    File destinationFile = new File(saveFileName);
                    if (destinationFile.exists()) {
                        destinationFile.delete();
                    }
                    //创建字节流
                    int num = (int) (total / 100);
                    byte[] bs = new byte[1024];
                    int len;
                    outputStream = new FileOutputStream(destinationFile);
                    int mSize = 0;
                    int oldProgress = -1;
                    //写数据
                    while ((len = inputStream.read(bs)) != -1) {
                        //已下载数据大小
                        mSize += len;
//                        int progress = (int) (mSize * 1.0f / total * 100);
//                        if (oldProgress != progress) {
//                            oldProgress = progress;
//                            ProgressDialogUtil.getInstance().setProgress(oldProgress);
//                        }
                        outputStream.write(bs, 0, len);
                    }
                    //ProgressDialogUtil.getInstance().cancelPb();
                    File file = new File(saveFileName);
                    if (file != null) {
                        AppUpdateUtils.installApp((FragmentActivity) mContext, file);
                    }
                } catch (IOException e) {
                    //如果下载失败了，就会打印日志
                    LogUtil.e("download：" + "下载文件异常msg:" + e.getMessage());
                    e.printStackTrace();
                } finally {
                    //不管有没有下载成功都要把流关掉
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void onFailure(String str, String string, BaseBean baseBean) {

            }
        }, "downApk")));
    }

    private Observable<ResponseBody> download(String url) {
        return IRequest.getAPI(HttpAPI.class)
                .download(url)
                .compose(RxSchedulers.io_main());
    }


    /**
     * 检查是否安装了某应用
     *
     * @param packageName 包名
     * @return
     */
    public boolean isInstall(String packageName, Context mContext) {
        final PackageManager packageManager = mContext.getPackageManager();
        // 获取所有已安装程序的包信息
        List<PackageInfo> pInfo = packageManager.getInstalledPackages(0);
        for (int i = 0; i < pInfo.size(); i++) {
            if (pInfo.get(i).packageName.equalsIgnoreCase(packageName))
                return true;
        }
        return false;
    }

    public void showHintDialog(String appName, String downAppUrl) {
        this.downUrl = downAppUrl;
        DialogUtils.getInstance().showHintDialog(mContext, DialogUtils.getInstance().BOTH, "是否下载" + appName, "", new DialogUtils.OnBtClick() {
            @Override
            public void onConfirm(String content) {
                rxPermissions
                        .requestEach(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        .subscribe(permission -> { // will emit 2 Permission objects
                            if (permission.granted) {
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    setInstallPermission();
                                } else {
                                    downApk();
                                }
                            } else if (permission.shouldShowRequestPermissionRationale) {
                                DialogUtils.getInstance().showHintDialog(mContext, DialogUtils.getInstance().BOTH, "您拒绝了app下载的相关权限", "去授予", new DialogUtils.OnBtClick() {
                                    @Override
                                    public void onConfirm(String content) {
                                        toPermissionSetting(50009);
                                    }
                                });
                            } else {
                                // Denied permission with ask never again
                                // Need to go to the settings
                                toPermissionSetting(50009);
                            }
                        });
            }
        });
    }


    public void toPermissionSetting(int code) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= 9) {
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", ((FragmentActivity) mContext).getPackageName(), null));
        } else if (Build.VERSION.SDK_INT <= 8) {
            intent.setAction(Intent.ACTION_VIEW);
            intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
            intent.putExtra("com.android.settings.ApplicationPkgName", ((FragmentActivity) mContext).getPackageName());
        }
        ((FragmentActivity) mContext).startActivityForResult(intent, code);
    }

    /**
     * 8.0以上系统设置安装未知来源权限
     */
    public void setInstallPermission() {
        boolean haveInstallPermission;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //先判断是否有安装未知来源应用的权限
            haveInstallPermission = ((FragmentActivity) mContext).getPackageManager().canRequestPackageInstalls();
            if (!haveInstallPermission) {
                //弹框提示用户手动打开
                DialogUtils.getInstance().showHintDialog(mContext, DialogUtils.getInstance().BOTH, "允许来自此来源的应用", "去授予", new DialogUtils.OnBtClick() {
                    @Override
                    public void onConfirm(String content) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            //此方法需要API>=26才能使用
                            toInstallPermissionSettingIntent();
                        } else {
                            downApk();
                        }
                    }
                });
            } else {
                downApk();
            }
        }
    }


    /**
     * 开启安装未知来源权限
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void toInstallPermissionSettingIntent() {
        Uri packageURI = Uri.parse("package:" + ((FragmentActivity) mContext).getPackageName());
        Intent intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES, packageURI);
        ((FragmentActivity) mContext).startActivityForResult(intent, 50008);
    }

}
