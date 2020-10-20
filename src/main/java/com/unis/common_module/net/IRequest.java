package com.unis.common_module.net;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class IRequest {

    /**
     * 腾讯云 SDKAppId，需要替换为您自己账号下的 SDKAppId。
     * <p>
     * 进入腾讯云云通信[控制台](https://console.cloud.tencent.com/avc ) 创建应用，即可看到 SDKAppId，
     * 它是腾讯云用于区分客户的唯一标识。
     */
    public static final int SDKAPPIDTX_DEV = 1400386142;
    public static final int SDKAPPIDTX_TEST = 1400429612;

    public static String UNIS_RELEASE = "https://dev.api.ckmooc.com";

    public static String UNIS_DEV = "https://dev.web.ckmooc.com";

    public static String UNIS_TEST = "https://test.web.ckmooc.com";

    public static String UNIS_EXTRANET = "http://dev.web.ckmooc.com";

    public static final String HOST = getHost(2); //1 正式 2 测试 3 外网 4 dev

    //1 正式 2 测试
    public static String getHost(int type) {
        String host = "";
        switch (type) {
            case 1:
                host = UNIS_RELEASE;
                break;
            case 2:
                host = UNIS_TEST;
                break;
            case 3:
                host = UNIS_EXTRANET;
                break;
            case 4:
                host = UNIS_DEV;
                break;
        }
        return host;
    }

    public static int getAppId() {
        if (HOST.equals(UNIS_TEST)) {
            return SDKAPPIDTX_TEST;
        } else {
            return SDKAPPIDTX_DEV;
        }
    }

    public static Retrofit getInstance() {
        return RetrofitNested.retrofit;
    }


    public static <T> T getAPI(Class<T> serviceapi) {
        return getInstance().create(serviceapi);
    }


    private static class RetrofitNested {
        private static final Retrofit retrofit = getRetrofit();
    }

    private static Retrofit getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder().client(OkHttpManager.getInstance().build())
                .baseUrl(HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }


}
