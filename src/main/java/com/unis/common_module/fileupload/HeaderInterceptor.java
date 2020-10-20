package com.unis.common_module.fileupload;
/*
 *create by zhangyibin
 *create on 2020/7/1
 *description: 头字段拦截器
 */

import com.unis.common_module.net.SpAPI;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class HeaderInterceptor implements Interceptor {
    @NotNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder();
        requestBuilder.addHeader("uniedu-sso-token", SpAPI.THIS.getToken());
        Request build = requestBuilder.build();
        Response response = chain.proceed(build);
        ResponseBody responseBody = response.peekBody(Integer.MAX_VALUE);
      /*  if (!NetworkUtils.isConnected()) {
            ToastUtils.showLong("network error");
        }
        if (BuildConfig.IS_DEBUG) {
            LogUtils.d("request");
            LogUtils.d("Requesturl: responseJson" + responseBody.string());
        }
        try {
            String str = responseBody.string();
            if (str != null && !"".equals(str)) {
                JSONObject jsonObject = new JSONObject(str);
                if (jsonObject.has("status")) {
                    int status = jsonObject.getInt("status");
                    LogUtils.i("status" + status);
                }
            }

        } catch (JSONException e) {
            LogUtils.e(e);
        }*/
        return response;
    }

}
