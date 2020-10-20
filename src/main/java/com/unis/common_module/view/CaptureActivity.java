package com.unis.common_module.view;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.unis.common_module.R;
import com.unis.common_module.R2;
import com.unis.common_module.base.BaseActivity;
import com.unis.common_module.base.EmptyModel;
import com.unis.common_module.base.EmptyPresenter;
import com.unis.common_module.config.Event;
import com.unis.common_module.router.RouterPath;
import com.unis.common_module.utils.RxManager;

import butterknife.BindView;
import cn.bingoogolapple.qrcode.core.BarcodeType;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;
import rx.functions.Action1;


@Route(path = RouterPath.MSG_COMMON_CAPTUREACTIVITY)
public class CaptureActivity extends BaseActivity<EmptyPresenter, EmptyModel> implements QRCodeView.Delegate {
    @BindView(R2.id.ll_common_capture_back)
    LinearLayout lyBack;
    @BindView(R2.id.zing_common_capture)
    ZXingView mZXingView;
    private RxManager rxManager;

    @Override
    protected void setLayout() {
        setView(R.layout.common_activity_capture, TYPE_NORMAL);
    }

    @Override
    protected void processData() {
        rxManager = new RxManager();
        initView();
    }

    private void initView() {
        mZXingView.setDelegate(this);
        mZXingView.getScanBoxView().setOnlyDecodeScanBoxArea(true); // 识别整个屏幕中的码
        mZXingView.changeToScanQRCodeStyle(); // 切换成扫描二维码样式
        mZXingView.setType(BarcodeType.TWO_DIMENSION, null); // 只识别二维条码
        mZXingView.startSpotAndShowRect(); // 显示扫描框，并开始识别

        lyBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });
        rxManager.on(Event.FINISH_CAPTURE, new Action1<Object>() {
            @Override
            public void call(Object o) {
                boolean isFinish = (boolean) o;
                if (isFinish) {
                    back();
                }
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        mZXingView.startCamera(); // 打开后置摄像头开始预览，但是并未开始识别
//        mZXingView.startCamera(Camera.CameraInfo.CAMERA_FACING_FRONT); // 打开前置摄像头开始预览，但是并未开始识别
    }

    @Override
    protected void onResume() {
        super.onResume();
        mZXingView.startSpotAndShowRect(); // 显示扫描框，并开始识别
    }

    @Override
    protected void onPause() {
        mZXingView.stopSpotAndHiddenRect(); // 停止识别，并且隐藏扫描框
        super.onPause();
    }

    @Override
    protected void onStop() {
        mZXingView.stopCamera(); // 关闭摄像头预览，并且隐藏扫描框
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        rxManager.clear();
        mZXingView.onDestroy(); // 销毁二维码扫描控件
        super.onDestroy();
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        toast(result);
        Bundle bundle = new Bundle();
        bundle.putString("result", result);
        //ARouter.getInstance().build(RouterPath.MSG_PCLOGINACTIVITY).with(bundle).withTransition(R.anim.enteralpha, R.anim.exitalpha).navigation();
        go(IdentifyResultActivity.class, bundle);
    }

    @Override
    public void onCameraAmbientBrightnessChanged(boolean isDark) {
        // 这里是通过修改提示文案来展示环境是否过暗的状态，接入方也可以根据 isDark 的值来实现其他交互效果
        String tipText = mZXingView.getScanBoxView().getTipText();
        String ambientBrightnessTip = "\n环境过暗，请打开闪光灯";
        if (isDark) {
            if (!tipText.contains(ambientBrightnessTip)) {
                mZXingView.getScanBoxView().setTipText(tipText + ambientBrightnessTip);
            }
        } else {
            if (tipText.contains(ambientBrightnessTip)) {
                tipText = tipText.substring(0, tipText.indexOf(ambientBrightnessTip));
                mZXingView.getScanBoxView().setTipText(tipText);
            }
        }
    }

    @Override
    public void onScanQRCodeOpenCameraError() {

    }

    @Override
    protected void back() {
        mZXingView.stopSpotAndHiddenRect(); // 停止识别，并且隐藏扫描框
        finish();
    }
}
