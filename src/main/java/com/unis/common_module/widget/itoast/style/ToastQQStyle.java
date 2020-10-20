package com.unis.common_module.widget.itoast.style;

import android.content.Context;


public class ToastQQStyle extends BaseToastStyle {

    public ToastQQStyle(Context context) {
        super(context);
    }

    @Override
    public int getZ() {
        return 0;
    }

    @Override
    public int getCornerRadius() {
        return dp2px(4);
    }

    @Override
    public int getBackgroundColor() {
        return 0XFF333333;
    }

    @Override
    public int getTextColor() {
        return 0XFFE3E3E3;
    }

    @Override
    public float getTextSize() {
        return sp2px(12);
    }

    @Override
    public int getPaddingStart() {
        return dp2px(16);
    }

    @Override
    public int getPaddingTop() {
        return dp2px(14);
    }
}