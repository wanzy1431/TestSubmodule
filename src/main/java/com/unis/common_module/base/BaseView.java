package com.unis.common_module.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;

import com.unis.common_module.interfaces.OnBackground;
import com.unis.common_module.interfaces.OnMainThread;

//import com.unis.teacher.interfaces.OnBackground;
//import com.unis.teacher.interfaces.OnMainThread;


public interface BaseView {

    Context getIContext();

    void showLoading(String dialogs);

    void dismissLoading();

    /**
     * 跳转activity
     */
    void go(Class clazz);

    /**
     * 跳转activity带参数
     *
     * @param clazz
     * @param bundle
     */
    void go(Class clazz, Bundle bundle);

    void go(Intent intent);

    /**
     * 跳转activity
     */
    void goForResult(Class clazz, int requestCode);

    /**
     * 跳转activity带参数
     *
     * @param clazz
     * @param bundle
     */
    void goForResult(Class clazz, int requestCode, Bundle bundle);

    /**
     * 关闭activity
     */
    void exit();

    //警告
    void toast(String toast);

    void ToastWar(int resId);

    void ToastAsBottom(final int resId);

    /**
     * 跳转activity
     */
    void goForResult(Intent intent, int requestCode);

    void goForResult(Intent intent, Class clazz, int requestCode);

    void go(Intent intent, Class clazz);

    void noCancleDialog(boolean b);

    /*
     * 统一添加数据展示相关界面
     * */
    void showLoadingPage(String loadingText);

    void showNoDatasPage(int imgResID, String noDatasText);

    void showNoDatasPage(String noDatasText);

    void showNoDatasPage();

    void showErrorPage(int imgResID, String errorText);

    void showErrorPage(String errorText);

    void showErrorPage();

    void dismissLoadingPage();

    void hideLoadingPageDialog();

    void ToastSuc(final String txt);

    void ToastSuc(final int txtResId);

    void toastError();

    void toastError(final String txt);

    void toastError(final int txtResId);

    void setEmptyView(int layoutResId, ViewGroup viewGroup);

    void runOnUIThread(OnMainThread onMainThread);

    void runOnThreeThread(OnBackground onBackground);
}
