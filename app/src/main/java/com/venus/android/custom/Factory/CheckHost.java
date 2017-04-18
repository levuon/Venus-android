package com.venus.android.custom.Factory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * Created by lev on 5/30/16.
 */
public class CheckHost implements HostnameVerifier {
    private static final CheckHost checkHost = new CheckHost();

    private CheckHost() {
    }

    public static HostnameVerifier check() {
        return checkHost;
    }

    public boolean verify(String str, SSLSession sSLSession) {
        return true;
    }
}
