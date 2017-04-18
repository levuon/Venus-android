package com.venus.android.data.network;

import com.squareup.okhttp.OkHttpClient;
import com.venus.android.custom.Factory.CheckClient;
import com.venus.android.custom.Factory.CheckHost;
import com.venus.android.data.common.ConstValue;

import org.apache.http.conn.ssl.AllowAllHostnameVerifier;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;


/**
 * Created by lev on 5/29/16.
 */
public class OkHttpCreator {
    private static final AllowAllHostnameVerifier allowAllHostnameVerifier = new AllowAllHostnameVerifier();
    private static OkHttpClient okHttpClient;
    private static X509TrustManager x509TrustManager = new CheckClient();
    private static X509TrustManager[] x509TrustManagersList = new X509TrustManager[]{x509TrustManager};

    //TODO  okHttpSingleInstance 设置connect timeout  retryOnConnectionFailure(true)(方法为设置出现错误进行重新连接)
    //TODO okHttpSingleInstance 设置TOKEN
    public static OkHttpClient getOkHttpSingleInstance() {
        if (okHttpClient != null) {
            return okHttpClient;
        }
        okHttpClient = new OkHttpClient();
        if (ConstValue.DEBUG_MODE) {
            okHttpClient.setHostnameVerifier(CheckHost.check());
        } else {
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init(new KeyManager[0], x509TrustManagersList, new SecureRandom());
                okHttpClient.setSslSocketFactory(instance.getSocketFactory());
                okHttpClient.setHostnameVerifier(allowAllHostnameVerifier);
            } catch (KeyManagementException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            }
        }
        okHttpClient.setConnectTimeout(5, TimeUnit.SECONDS);
        okHttpClient.setReadTimeout(5, TimeUnit.SECONDS);
        return okHttpClient;
    }
}
