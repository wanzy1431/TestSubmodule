package com.unis.common_module.net;

import com.unis.common_module.bean.BaseBean;

public interface ICallback<T> {

    void onResponse(String str, T result);

    void onFailure(String str, String string, BaseBean baseBean);
}
