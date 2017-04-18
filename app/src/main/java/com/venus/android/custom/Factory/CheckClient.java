package com.venus.android.custom.Factory;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

import timber.log.Timber;

/**
 * Created by lev on 5/30/16.
 */
public class CheckClient implements X509TrustManager {
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        Timber.i("cert: " + x509CertificateArr[0].toString() + ", authType: " + str, new Object[0]);
    }
}
