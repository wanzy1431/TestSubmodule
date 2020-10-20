package com.unis.common_module.widget;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.unis.common_module.R;

//import com.unis.teacher.R;


public class LoadingDialog {
    private Context context;
    private Dialog dialog;
    private ImageView iv_loading;
    private TextView tv;

    public LoadingDialog(Context context) {
        this.context = context;
        View v = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null);
        iv_loading = (ImageView) v.findViewById(R.id.iv_loading);
        tv = (TextView) v.findViewById(R.id.tv_loading);
        dialog = new Dialog(context, R.style.loading_dialog_no_bg);
        dialog.setContentView(v);
    }


    /**
     * @param b false 为不可关闭
     */
    public void setCanceledOnTouchOutside(boolean b) {
        if (null != dialog) dialog.setCanceledOnTouchOutside(b);
    }

    public void setCancelable(boolean b) {
        if (null != dialog) dialog.setCancelable(b);
    }

    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        if (null != dialog) dialog.setOnCancelListener(onCancelListener);
    }

    public boolean isShowing() {
        return null != dialog && dialog.isShowing();
    }

    public Context getContext() {
        return context;
    }

    public void show() {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv_loading, "rotation", 0F, -360F);
        objectAnimator.setDuration(1000);
        objectAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        objectAnimator.setRepeatMode(ObjectAnimator.RESTART);
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.start();
        dialog.show();
    }

    public void show(String loading) {
        tv.setText(loading);
        show();
    }

    public void show(int textResId) {
        tv.setText(textResId);
        show();
    }

    public void dismiss() {
        if (dialog != null)
            dialog.dismiss();
    }
}
