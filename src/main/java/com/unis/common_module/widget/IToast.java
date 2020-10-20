package com.unis.common_module.widget;

import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.unis.common_module.R;
import com.unis.common_module.utils.AppContextUtil;
import com.unis.common_module.utils.StringUnisUtil;
import com.unis.common_module.widget.itoast.ToastUtils;


public class IToast {
    private static IToast iToast;
    public LinearLayout llRoot;
    private Toast toast;
    public ImageView iv_img;
    private TextView tv, tvTop;
    private View v;

    public IToast() {
        v = View.inflate(AppContextUtil.getmApplication(), R.layout.toast, null);
        iv_img = (ImageView) v.findViewById(R.id.iv_img);
        llRoot = v.findViewById(R.id.ll_root);
        tvTop = (TextView) v.findViewById(R.id.tv_toast_top);

    }

    public static IToast getIToast() {
        if (null == iToast) {
            iToast = new IToast();
        }
//        iToast.llRoot.setBackgroundResource(R.drawable.shape_toast_success);
        iToast.iv_img.setImageResource(R.mipmap.white_corrcet);
        iToast.iv_img.setVisibility(View.VISIBLE);
        return iToast;
    }

    public IToast setImage(int resId) {
        if (null == iToast) {
            iToast = new IToast();
        }
//        iv_img.setImageResource(resId);
        return iToast;
    }

    public IToast setIcon(int resId) {
        if (null == iToast) {
            iToast = new IToast();
        }
        iToast.iv_img.setImageResource(resId);
        iToast.iv_img.setVisibility(View.VISIBLE);
        return iToast;
    }

    public void show(String text) {
        tvTop.setVisibility(View.GONE);
        ToastUtils.setView(v);
        ToastUtils.setGravity(Gravity.CENTER, 0, 0);
        ToastUtils.show(text);
    }

    public void showLongBottom(int res) {
        if (res == 0) return;
        try {
            String text = StringUnisUtil.getResString(res);
            tvTop.setVisibility(View.GONE);
            ToastUtils.setView(v);
            ToastUtils.setGravity(Gravity.BOTTOM, 0, dip2px(130));
            ToastUtils.getToast().setDuration(Toast.LENGTH_LONG);
            ToastUtils.show(text);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void showLong(String text) {

        tvTop.setVisibility(View.GONE);
        ToastUtils.setView(v);
        ToastUtils.setGravity(Gravity.CENTER, 0, 0);
        ToastUtils.getToast().setDuration(Toast.LENGTH_LONG);
        ToastUtils.show(text);
    }


    public void showLongBottom(String text) {

        tvTop.setVisibility(View.GONE);
        ToastUtils.setView(v);
        ToastUtils.setGravity(Gravity.BOTTOM, 0, dip2px(130));
        ToastUtils.getToast().setDuration(Toast.LENGTH_LONG);
        ToastUtils.show(text);

    }

    public void show(int resId) {
        tvTop.setVisibility(View.GONE);
        ToastUtils.setView(v);
        ToastUtils.setGravity(Gravity.CENTER, 0, 0);
        ToastUtils.show(resId);

    }

    public void showAsBottomn(int resId) {
        tvTop.setVisibility(View.GONE);
        ToastUtils.setView(v);
        ToastUtils.setGravity(Gravity.BOTTOM, 0, dip2px(130));
        ToastUtils.show(resId);
    }

    public void showAsBottomn(String resId) {
        tvTop.setVisibility(View.GONE);
        ToastUtils.setView(v);
        ToastUtils.setGravity(Gravity.BOTTOM, 0, dip2px(130));
        ToastUtils.show(resId);
    }

    public void showAsBottomnDouble(int resId, int resId2) {

        tvTop.setVisibility(View.VISIBLE);
        tvTop.setText(resId);
        ToastUtils.setView(v);
        ToastUtils.setGravity(Gravity.BOTTOM, 0, dip2px(130));
        ToastUtils.show(resId2);
    }

    public void cancleToast() {
        if (toast != null) {
            toast.cancel();
        }
    }


    /**
     * dip转换px
     */
    private int dip2px(float dip) {
        final float scale = AppContextUtil.getContext().getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }
}
