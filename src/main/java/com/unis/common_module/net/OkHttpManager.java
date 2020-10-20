package com.unis.common_module.net;

import com.unis.common_module.utils.AppContextUtil;
import com.unis.common_module.utils.LogUtil;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class OkHttpManager {
    private static final int DEFAULT_TIMEOUT = 20;
    static private OkHttpManager mOkhttpManager = null;
    private InputStream mTrustrCertificate;
    private String baseUrl = "";

    private static class VersionNested {
        static String version;

        static {
            try {
                version = AppContextUtil.getContext().getPackageManager().getPackageInfo(AppContextUtil.getContext().getPackageName(), 0).versionName;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static public OkHttpManager getInstance() {
        if (mOkhttpManager == null) {
            mOkhttpManager = new OkHttpManager();
        }
        return mOkhttpManager;
    }

    private KeyStore newEmptyKeyStore(char[] password) throws GeneralSecurityException {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            InputStream in = null; // By convention, 'null' creates an empty key store.
            keyStore.load(in, password);
            return keyStore;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    private X509TrustManager trustManagerForCertificates()
            throws GeneralSecurityException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        Collection<? extends Certificate> certificates = null;
        LogUtil.e("start generateCertificates");
//        try {
//            certificates = certificateFactory.generateCertificates(AppContextUtil.getContext().getAssets().open(IRequest.getCrt()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (certificates.isEmpty()) {
//            Log.d(TAG, "is empty");
//            throw new IllegalArgumentException("expected non-empty set of trusted certificates");
//        }
        LogUtil.e("not empty");
        // Put the certificates a key store.
        char[] password = "password".toCharArray(); // Any password will work.
        KeyStore keyStore = newEmptyKeyStore(password);
        int index = 0;
        for (Certificate certificate : certificates) {
            String certificateAlias = Integer.toString(index++);
            keyStore.setCertificateEntry(certificateAlias, certificate);
        }

        // Use it to build an X509 trust manager.
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, password);
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        }
        return (X509TrustManager) trustManagers[0];
    }

    //获取TrustManager
    private static TrustManager[] getDefaultTrustManager() {
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(X509Certificate[] chain, String authType) {
                        //Just bypass fireline check
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] chain, String authType) {
                        //Just bypass fireline check
                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[]{};
                    }
                }
        };
        return trustAllCerts;
    }


    public void setTrustrCertificates(InputStream in) {
        mTrustrCertificate = in;
    }

    public InputStream getTrustrCertificates() {
        return mTrustrCertificate;
    }

    public OkHttpClient build() {
        OkHttpClient okHttpClient = null;

//        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
//            @Override
//            public void log(@NotNull String s) {
//                Log.e("MO_XIN_OKHttp-----", "log: " + s);
//            }
//        });
//        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(chain -> {
                    Request.Builder builder = getBuilder(chain);
                    Request request = builder.build();
                    Response response = chain.proceed(request);
                    return response;
                });
        okHttpClient = okHttpClientBuilder.build();
        return okHttpClient;
    }


    private static Request.Builder getBuilder(Interceptor.Chain chain) {
        Request org = chain.request();
//        String lang = (String) SpUtils.getParam("f_TronKey", AppContextUtil.getContext(),
//                AppContextUtil.getContext().getString(R.string.language_key), "1");
//
//        String chainName = (String) SpUtils.getParam("f_Tron", AppContextUtil.getContext(),
//                AppContextUtil.getContext().getString(R.string.chain_name_key), "MainChain");
//        String macAddress;
//        try {
//            macAddress = MobileInfoUtil.getMacAddress();
//        } catch (SocketException e) {
//            e.printStackTrace();
//            macAddress = "null_Imei_Android";
//        }
//
//        String packageName;
//
//        try {
//            packageName = AppContextUtil.getContext().getPackageName();
//        } catch (Exception e) {
//            e.printStackTrace();
//            packageName = AppContextUtil.mIsGooGlePlay ? "com.tronlinkpro.wallet" : "com.tronlink.wallet";
//        }
        Request.Builder builder = org.newBuilder();
        if (!SpAPI.THIS.getToken().equals("")) {
            builder.addHeader("uniedu-sso-token", SpAPI.THIS.getToken());
        }
        LogUtil.e("token " + SpAPI.THIS.getToken());
//                .addHeader("Version", VersionNested.version)
//                .addHeader("DeviceID", macAddress)
//                .addHeader("Lang", lang)
//                .addHeader("chain", chainName)
//                .addHeader("packageName", packageName);


//        String baseUrl = org.url().toString();
////        AppContextUtil.getContext().getSharedPreferences();

//        baseUrl.replaceAll("base&url","");
        return builder;
    }
}
