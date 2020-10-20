package com.unis.common_module.widget.itoast;

import android.widget.Toast;


public interface IToastInterceptor {

    /**
     * 根据显示的文本决定是否拦截该 Toast
     */
    boolean intercept(Toast toast, CharSequence text);
}