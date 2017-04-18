package com.venus.android.data.network.request.header;

import android.content.Context;

import com.venus.android.data.network.request.header.cookie.HeaderCookieManager;

import java.util.ArrayList;
import java.util.List;


public class HeaderManager {
    private boolean isDebug;
    private Context mContext;

    public void setIsDebug(boolean z) {
        this.isDebug = z;
    }

    public HeaderManager(Context context) {
        this.mContext = context;
    }

    public List<RequestHeader> getRequestHeaders() {
        List<RequestHeader> arrayList = new ArrayList();
        RequestCookieHeader requestCookieHeader = new RequestCookieHeader(new HeaderCookieManager(this.mContext));
        requestCookieHeader.setIsDebug(this.isDebug);
        arrayList.add(requestCookieHeader);
//        arrayList.add(new RequestUserAgentHeader(this.mContext));
        return arrayList;
    }
}
