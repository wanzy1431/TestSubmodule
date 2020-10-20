package com.unis.common_module.widget.itoast;

import android.widget.Toast;


public class ToastInterceptor implements IToastInterceptor {

    @Override
    public boolean intercept(Toast toast, CharSequence text) {
        // 如果是空对象或者空文本就进行拦截
        return text == null || "".equals(text.toString());
    }
}