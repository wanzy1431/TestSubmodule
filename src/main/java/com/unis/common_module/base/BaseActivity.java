package com.unis.common_module.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.unis.common_module.R;
import com.unis.common_module.config.Constants;
import com.unis.common_module.config.Event;
import com.unis.common_module.interfaces.OnBackground;
import com.unis.common_module.interfaces.OnHeaderClickListener;
import com.unis.common_module.interfaces.OnMainThread;
import com.unis.common_module.utils.ActivityUtils;
import com.unis.common_module.utils.ExitUtil;
import com.unis.common_module.utils.RxManager;
import com.unis.common_module.utils.StatusBarUtils;
import com.unis.common_module.utils.StringUnisUtil;
import com.unis.common_module.utils.ThreadPoolManager;
import com.unis.common_module.utils.TypeUtil;
import com.unis.common_module.utils.Utils;
import com.unis.common_module.widget.DialogUtils;
import com.unis.common_module.widget.HeaderLayout;
import com.unis.common_module.widget.IToast;
import com.unis.common_module.widget.LoadingDialog;

import butterknife.ButterKnife;
import rx.functions.Action1;


public abstract class BaseActivity<T extends BasePresenter, E extends BaseModel> extends AppCompatActivity implements BaseView {
    protected Context mContext;
    private HeaderLayout headerLayout;
    private RxManager rxManager;

    // 监听做成静态可以让每个子类重写时都注册相同的一份。
//    private static IMEventListener mIMEventListener = new IMEventListener() {
//        @Override
//        public void onForceOffline() {
//            ToastUtil.toastLongMessage("您的帐号已在其它终端登录");
//            logout(UnisApplication.instance());
//        }
//    };


    public LoadingDialog getLoadingDialog() {
        return loadingDialog;
    }

    protected LoadingDialog loadingDialog;
    protected static final int TYPE_NORMAL = 0; //什么都没有
    protected static final int TYPE_HEADER = 1;//有头
    protected static final int TYPE_PROGRESS = 2;//有加载动画
    protected static final int TYPE_HEADER_PROGRESS = 3;//有头有加载动画
    protected static final int TYPE_NOHEADER_STATUABAR = 4;//无头有bar
    protected static final int TYPE_NOHEADER_STATUABAR_LIGHT = 5;//无头有bar 白色字体
    protected static final int TYPE_BLUE_HEADER = 6;//沉浸式 蓝色背景头部
    protected static final int TYPE_HEADER_BLACK = 7;//沉浸式 蓝色背景头部

    public T mPresenter;
    public E mModel;

    protected BaseActivity() {
        mContext = this;
    }

    protected abstract void setLayout();

    protected abstract void processData();

    // 返回按钮返回 虚拟键返回
    protected abstract void back();
//    public static void logout(Context context) {
//        UserInfo.getInstance().setToken("");
//        UserInfo.getInstance().setAutoLogin(false);
//
//        Intent intent = new Intent(context, LoginActivity.class);
//        intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
//        intent.putExtra(Constants.LOGOUT, true);
//        context.startActivity(intent);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.getString("chat") != null
                && savedInstanceState.getString("chat").equals("chat")) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                getWindow().setStatusBarColor(Color.WHITE);
                getWindow().setNavigationBarColor(getResources().getColor(R.color.white));
                int vis = getWindow().getDecorView().getSystemUiVisibility();
                vis |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                vis |= View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
                getWindow().getDecorView().setSystemUiVisibility(vis);
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
            }
            StatusBarUtils.setLightStatusBar(this, true);
        }
        ActivityUtils.addActivity(this);
        onCreate1(savedInstanceState);
        mContext = this;
//        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        setLayout();
        ButterKnife.bind(this);
        mPresenter = TypeUtil.getT(this, 0);
        mModel = TypeUtil.getT(this, 1);
        if (this instanceof BaseView && mPresenter != null) mPresenter.setVM(this, mModel);
        onCreate2(savedInstanceState);
//        TUIKit.addIMEventListener(mIMEventListener);
        processData();
//        PushAgent.getInstance(this).onAppStart();
        rxManager = new RxManager();
        rxManager.on(Event.IS_HAVE_LOGIN, new Action1<Object>() {
            @Override
            public void call(Object o) {
                boolean isExit = (boolean) o;
                Constants.IS_CLEAR_DATA = true;
                if (isExit) {
                    if (Utils.isBackground(BaseActivity.this)) {
                        ExitUtil.getInstance().loginOut();
                    } else {
                        ExitUtil.getInstance().loginOut();
                        DialogUtils.getInstance().showExitDialog(BaseActivity.this);
                    }
                }
            }
        });
    }

    public void onCreate2(Bundle savedInstanceState) {
    }

    public void onCreate1(Bundle savedInstanceState) {
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (Constants.IS_CLEAR_DATA) {
            Constants.IS_CLEAR_DATA = false;
            DialogUtils.getInstance().showExitDialog(BaseActivity.this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //MobclickAgent.onResume(this);
//        mFirebaseAnalytics.setCurrentScreen(this, "CurrentScreen: " + getClass().getSimpleName(), null);
    }

    @Override
    protected void onStart() {
//        DemoLog.i(TAG, "onStart");

        super.onStart();
        SharedPreferences shareInfo = getSharedPreferences(Constants.USERINFO, Context.MODE_PRIVATE);
        boolean login = shareInfo.getBoolean(Constants.AUTO_LOGIN, false);
//        if (!login) {
//            logout(UnisApplication.instance(), false);
//            Log.e("onstart", "onStart: "+"退出了");
//        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        //MobclickAgent.onPause(this);
    }

    protected void setView(int layoutResId, int type) {
        switch (type) {
            case TYPE_NORMAL:
                setContentView(layoutResId);
                break;
            default:
                headerLayout = new HeaderLayout(this, layoutResId, type);
                setContentView(headerLayout);
                break;
        }
        if (null != headerLayout) {
            headerLayout.setHeaderClickListener(onHeaderClickListener);
        }
    }

    public void setTitle(String title) {
        if (null != headerLayout) {
            headerLayout.setTitle(title);
        }
    }

    public void setIvRight2(int imageRes) {
        if (null != headerLayout) {
            headerLayout.setIvRight2(imageRes);
        }
    }

    public void setMiddleTtitle(String title) {
        if (null != headerLayout) {
            headerLayout.setMiddleTitle(title);
        }
    }

    public void setRightBold() {
        if (null != headerLayout) {
            headerLayout.setRightBold();
        }
    }

    public void setCommonTitle2(String text) {
        if (null != headerLayout) {
            headerLayout.setCommonTitle2(text);
        }
    }

    public void setCommonRight2(String text) {
        if (null != headerLayout) {
            headerLayout.setCommonRightTitle2(text);
        }
    }

    public void showOrHideHeader(boolean isShow) {
        if (headerLayout == null) return;
        if (isShow)
            headerLayout.showOrHideHeader(true);
        else
            headerLayout.showOrHideHeader(false);
    }

    private OnHeaderClickListener onHeaderClickListener = new OnHeaderClickListener() {
        @Override
        public void onClickLeftButton() {
            back();
            //子类选择性实现
            finish();
        }

        @Override
        public void onClickRightButton() {
            onRightButtonClick();
        }

        @Override
        public void onClickReLoadButton() {
            onReLoadButtonClick();
        }

        @Override
        public void onClickCloseButton() {
            onCloseButtonClick();
        }

        @Override
        public void onClickRefreshButton() {
            onRefreshButtonClick();
        }

        @Override
        public void onClickRightTv() {
            onRightTextClick();
        }

        @Override
        public void onClickCommonRight() {
            onCommonRightClick();
        }

        @Override
        public void onClickCommonRight2() {
            onCommonRightClick2();
        }
    };


    protected void onRightButtonClick() {
        //子类选择性实现
    }

    public void onReLoadButtonClick() {
        //子类选择性实现
    }

    protected void onCloseButtonClick() {
        //子类选择性实现
    }

    protected void onRefreshButtonClick() {
        //子类选择性实现
    }

    protected void onRightTextClick() {
        //子类选择性实现
    }

    protected void onCommonRightClick() {

    }

    protected void onCommonRightClick2() {

    }


    /**
     * 显示“返回”按钮和title
     *
     * @param titleText
     */
    public void setHeaderBar(String titleText) {
        if (null != headerLayout) {
            headerLayout.setHeaderBar(titleText);
        }
    }

    /**
     * 获取右侧文字按钮
     */
    public TextView getRightTextView() {
        if (null != headerLayout) {
            return headerLayout.getRightTextView();
        } else {
            return null;
        }
    }

    /**
     * 显示“刷新”按钮
     *
     * @param res
     */
    public void setRefreshBar(int res) {
        if (null != headerLayout) {
            headerLayout.setRightBar(res);
        }
    }


    /**
     * 显示“跳过”文字
     *
     * @param title
     * @param rightContent
     */
    public void setHeaderBarAndRightTv(String title, String rightContent) {
        if (null != headerLayout) {
            headerLayout.setHeaderBarAndRightTv(title, rightContent);
        }
    }

    /**
     * 是否显示“跳过”文字
     *
     * @param isShow
     */
    public void setRightTextShow(boolean isShow) {
        if (null != headerLayout) {
            headerLayout.setRightTextShow(isShow);
        }
    }

    /**
     * 显示左侧“关闭”按钮
     *
     * @param res
     */
    public void setCloseBar(int res) {
        if (null != headerLayout) {
            headerLayout.setLeftBar(res);
        }
    }


    /**
     * 显示“返回”按钮和title加右侧从相册选择
     *
     * @param titleText
     */
    public void setHeaderBarAndRight(String titleText) {
        if (null != headerLayout) {
            headerLayout.setHeaderBar(titleText, "");
        }
    }

    /**
     * 显示“返回”按钮和title加右侧扫一扫
     *
     * @param titleText
     */
    public void setHeaderBarAndRightImage(String titleText) {
        if (null != headerLayout) {
            headerLayout.setHeaderBar(titleText, 0);
        }
    }


    /**
     * 显示“返回”按钮和 右侧图片
     *
     * @param titleText
     */
    public void setHeaderBarAndRightImage(String titleText, int res) {
        if (null != headerLayout) {
            headerLayout.setHeaderBar(titleText, res);
        }
    }


    /**
     * 显示“返回”按钮和 右侧图片
     *
     * @param titleText
     */
    public void setHeaderBarAndRightImageSpe(String titleText, int res) {
        if (null != headerLayout) {
            headerLayout.setHeaderBarSpe(titleText, res);
        }
    }


    /**
     * 显示“返回”按钮、title、右边按钮。
     *
     * @param titleText
     * @param rightText
     */
    public void setHeaderBar(String titleText, String rightText) {
        if (null != headerLayout) {
            headerLayout.setHeaderBar(titleText, rightText);
        }
    }

    /**
     * 显示“返回”按钮、title、右边按钮。
     *
     * @param titleText
     * @param rightText
     */
    public void setWhiteHeaderBar(String titleText, String rightText) {
        if (null != headerLayout) {
            headerLayout.setHeaderBar(titleText, rightText);
        }
    }


    /**
     * 显示左边按钮、title、右边按钮
     *
     * @param leftText
     * @param titleText
     * @param rightText
     */
    public void setHeaderBar(String leftText, String titleText, String rightText) {
        if (null != headerLayout) {
            headerLayout.setHeaderBar(leftText, titleText, rightText);
        }
    }

    /**
     * 获取headerBar
     */
    public View getHeaderBar() {
        if (null != headerLayout)
            return headerLayout.getHeadBar();
        return null;
    }

    /**
     * 获取HeaderHolder
     */
    public HeaderLayout.HeaderHolder getHeaderHolder() {
        return headerLayout.getHeaderHolder();
    }

    /**
     * 隐藏左边箭头
     */
    public void hideHeaderLeftArrow() {
        if (null != headerLayout) {
//            headerLayout.hideHeaderLeftArrow();
        }
    }

    /**
     * 隐藏左边按钮
     */
    public void hideHeaderLeftButton() {
        if (null != headerLayout) {
            headerLayout.hideHeaderLeftButton();
        }
    }

    /**
     * 展示正在加载...
     */
    public void showLoadingPage() {
        if (null != headerLayout) {
            headerLayout.showLoadingPage();
        }
    }

    /**
     * 展示正在加载界面。
     *
     * @param loadingText
     */
    public void showLoadingPage(String loadingText) {
        if (null != headerLayout) {
            headerLayout.showLoadingPage(loadingText);
        }
    }

    public void hideLoadingPageDialog() {
        if (null != headerLayout) {
            headerLayout.hideLoadingPageDialog();
        }
    }

    /**
     * 加载成功，隐藏加载页
     */
    public void dismissLoadingPage() {
        if (null != headerLayout) {
            headerLayout.dismissLoadingPage();
        }
    }

    /**
     * 网络异常，展示重新加载按钮。
     */
    public void showErrorPage() {
        if (null != headerLayout) {
            headerLayout.showErrorPage();
        }
    }

    public void showErrorPage(String errorText) {
        if (null != headerLayout) {
            headerLayout.showErrorPage(0, errorText);
        }
    }

    public void showErrorPage(int imgResID, String errorText) {
        if (null != headerLayout) {
            headerLayout.showErrorPage(imgResID, errorText);
        }
    }

    /**
     * 返回无数据，展示未找到相关数据
     */
    public void showNoDatasPage() {
        if (null != headerLayout) {
            headerLayout.showNoDatasPage();
        }
    }


    public void showNoDatasPage(String noDatasText) {
        if (null != headerLayout) {
            headerLayout.showNoDatasPage(0, noDatasText);
        }
    }

    /**
     * 返回无数据，展示空数据页。
     *
     * @param noDatasText
     */
    public void showNoDatasPage(int imgResID, String noDatasText) {
        if (null != headerLayout) {
            headerLayout.showNoDatasPage(imgResID, noDatasText);
        }
    }

    /**
     * 弹出"正在加载..."对话框。
     */
    public void showLoadingDialog() {
        if (loadingDialog == null || loadingDialog.getContext() != mContext) {
            loadingDialog = new LoadingDialog(mContext);
        }
        try {
            loadingDialog.show(getString(R.string.loading));
        } catch (WindowManager.BadTokenException e) {
            //use a log message
        }
    }

    /**
     * 弹出正在加载...对话框。
     */
    public void showLoadingDialog(String text) {
        if (loadingDialog == null || loadingDialog.getContext() != mContext) {
            loadingDialog = new LoadingDialog(mContext);
        }
        try {
            loadingDialog.show(text);
        } catch (WindowManager.BadTokenException e) {
            //use a log message
        }
    }

    protected void dismissLoadingDialog() {
        if (null != loadingDialog && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    protected void Toast(final String text) {
        if (StringUnisUtil.isNullOrEmpty(text)) {
            return;
        }
        runOnUiThread(() -> IToast.getIToast().setImage(R.mipmap.toast_warn).show(text));
    }

    protected void Toast(final int resId) {
        runOnUiThread(() -> IToast.getIToast().setImage(R.mipmap.toast_warn).show(resId));
    }

    public void ToastAsBottom(final int resId) {
        runOnUiThread(() -> IToast.getIToast().setImage(R.mipmap.toast_warn).showAsBottomn(resId));
    }

    protected void ToastAsBottom(final int resId, final int resId2) {
        runOnUiThread(() -> IToast.getIToast().setImage(R.mipmap.toast_warn).showAsBottomnDouble(resId, resId2));
    }

    public void ToastSuc(final String txt) {
        runOnUiThread(() -> IToast.getIToast().show(txt));

    }

    public void ToastSuc(final int txtResId) {
        runOnUiThread(() -> IToast.getIToast().show(txtResId));

    }

    @Override
    public void toastError() {
        toastError(R.string.network_busy);
    }

    @Override
    public void toastError(final String txt) {
        runOnUiThread(() -> IToast.getIToast().setIcon(R.mipmap.yellow_warn).show(txt));
    }

    @Override
    public void toastError(final int txtResId) {
        runOnUiThread(() -> IToast.getIToast().setIcon(R.mipmap.toast_error).show(txtResId));
    }

    public void ToastWar(final int txtResId) {
        runOnUiThread(() -> IToast.getIToast().setIcon(R.mipmap.toast_warn).show(txtResId));
    }

    @Override
    public void showLoading(String dialogs) {
        showLoadingDialog(dialogs);
    }

    @Override
    public void dismissLoading() {
        dismissLoadingDialog();
    }

    @Override
    public void go(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    @Override
    public void go(Class clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void go(Intent intent) {
        startActivity(intent);
    }

    @Override
    public void goForResult(Class clazz, int requestCode) {
        Intent intent = new Intent(this, clazz);
        startActivityForResult(intent, requestCode);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void goForResult(Class clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        intent.putExtras(bundle);
        startActivityForResult(intent, requestCode, bundle);
    }

    @Override
    public void exit() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityUtils.removeActivity(this);
        dismissLoadingDialog();
        if (null != mPresenter) {
            mPresenter.onDestroy();
            mPresenter = null;
        }
    }

    @Override
    public void goForResult(Intent intent, int requestCode) {
        startActivityForResult(intent, requestCode);
    }

    @Override
    public void toast(String toast) {
        if (StringUnisUtil.isNullOrEmpty(toast)) {
            return;
        }
        runOnUiThread(() -> IToast.getIToast().show(toast));
    }

    @Override
    public void go(Intent intent, Class clazz) {
        intent.setClass(this, clazz);
        startActivity(intent);
    }

    @Override
    public void goForResult(Intent intent, Class clazz, int requestCode) {
        intent.setClass(this, clazz);
        startActivityForResult(intent, requestCode);
    }

    @Override
    public void noCancleDialog(boolean b) {
        loadingDialog.setCanceledOnTouchOutside(b);
    }

    @Override
    public Context getIContext() {
        return mContext;
    }

    @Override
    public void setEmptyView(int layoutResId, ViewGroup viewGroup) {

    }

    public void doHuWeiToastCovered() {
        if (Build.MANUFACTURER.equalsIgnoreCase("huawei")) {
            View focus = getWindow().getDecorView().findFocus();
            if (focus instanceof EditText) {
                EditText et = (EditText) focus;
                if (et.getInputType() == (InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT) || et.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                    InputMethodManager methodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    methodManager.hideSoftInputFromWindow(et.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                }
            }
        }
    }

    @Override
    public void runOnUIThread(OnMainThread onMainThread) {
        runOnUiThread(() -> {
            if (onMainThread != null) onMainThread.doInUIThread();
        });
    }

    @Override
    public void runOnThreeThread(OnBackground onBackground) {
        ThreadPoolManager.newInstance().addExecuteTask(() -> {
            if (onBackground != null) onBackground.doOnBackground();
        }, true);
    }

    @Override
    public void onBackPressed() {
        back();
        finish();
        super.onBackPressed();
    }
}