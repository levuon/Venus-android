package com.venus.android.data.network.request.header;


import com.venus.android.data.network.request.header.cookie.HeaderCookieManager;

public class RequestCookieHeader implements RequestHeader {
    private HeaderCookieManager headerCookieManager;
    private boolean isDebug;

    public RequestCookieHeader(HeaderCookieManager headerCookieManager) {
        this.headerCookieManager = headerCookieManager;
    }

    public void setIsDebug(boolean z) {
        this.isDebug = z;
    }

    public String key() {
        return "Cookie";
    }

    public String value() {
        return this.headerCookieManager.getCookie(this.isDebug);
    }
}
