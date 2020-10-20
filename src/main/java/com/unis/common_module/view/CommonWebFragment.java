package com.unis.common_module.view;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.widget.LinearLayout;

import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.BridgeWebViewClient;
import com.github.lzyzsd.jsbridge.DefaultHandler;
import com.google.gson.Gson;
import com.unis.common_module.R;
import com.unis.common_module.R2;
import com.unis.common_module.base.BaseFragment;
import com.unis.common_module.base.EmptyModel;
import com.unis.common_module.base.EmptyPresenter;
import com.unis.common_module.bean.MoxinAccount;
import com.unis.common_module.bean.WebData;
import com.unis.common_module.utils.ARouterUtils;
import com.unis.common_module.utils.AccountUtils;

import butterknife.BindView;

public class CommonWebFragment extends BaseFragment<EmptyPresenter, EmptyModel> {
    @BindView(R2.id.commont_web_layout)
    LinearLayout mainLayout;
    private BridgeWebView mWebView;
    private String url;

    @Override
    protected void processData() {
        Bundle bundle = getArguments();
        url = bundle.getString("url");
        initWeb();
    }

    @Override
    protected int setLayout() {
        setType(TYPE_NORMAL);
        return R.layout.common_activity_web;
    }

    //初始化webview
    private void initWeb() {
        if (mWebView == null)
            mWebView = new BridgeWebView(getActivity());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        mWebView.setLayoutParams(params);
        mWebView.setHorizontalScrollBarEnabled(false);
        mWebView.setVerticalScrollBarEnabled(false);
        mWebView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        mainLayout.addView(mWebView);
        WebSettings settings = mWebView.getSettings();
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);//缓存模式
        settings.setJavaScriptEnabled(true);//允许js交互
        settings.setJavaScriptCanOpenWindowsAutomatically(true);//允许弹窗
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setBlockNetworkImage(false);                           //把图片放在最后渲染
        //允许webview对文件的操作
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.setDefaultHandler(new DefaultHandler());
        mWebView.setWebViewClient(new MyWebViewClient(mWebView));//使用jsbridge必须

        mWebView.loadUrl(url);
        //js调用客户端方法
        mWebView.registerHandler("JsCallApp", (data, function) -> {
            if ("".equals(data))
                return;
            WebData webData = new Gson().fromJson(data, WebData.class);
            switch (webData.getType()) {
                case "userInfo":
                    WebData functionData = new WebData();
                    functionData.setType("userInfo");
                    MoxinAccount selectAccount = AccountUtils.getSelectAccount();
                    WebData.AppToJs appToJs = new WebData.AppToJs();
                    appToJs.setUserInfo(selectAccount);
                    functionData.setAppToJs(appToJs);
                    function.onCallBack(new Gson().toJson(functionData));
                    break;
                case "newView":
                    if (webData.getJsToApp()!=null){
                        String newUrl = webData.getJsToApp().getUrl();
                        if (newUrl!=null){
                            ARouterUtils.goWebViewActivity(newUrl);
                        }
                    }
                    break;
                default:
                    toast("type:" + webData.getType() + "web:" + data);
            }
        });
        //客户端调用js方法
        mWebView.callHandler("AppCallJs", "需要传递的参数", data -> {
            // data返回的参数
        });
    }

    class MyWebViewClient extends BridgeWebViewClient {

        public MyWebViewClient(BridgeWebView webView) {
            super(webView);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
            mWebView.goBack();//返回上个页面
            return true;
        }
        return false;
    }

    @Override
    public void onDestroy() {
        if (mWebView != null) {
            mWebView.destroy();
            mWebView = null;
        }
        mainLayout.removeAllViews();
        super.onDestroy();
    }
}
