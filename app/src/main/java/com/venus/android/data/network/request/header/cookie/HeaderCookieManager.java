package com.venus.android.data.network.request.header.cookie;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class HeaderCookieManager {
    private Context mContext;

    public HeaderCookieManager(Context context) {
        this.mContext = context;
    }

    public String getCookie(boolean z) {
        List arrayList = new ArrayList();
        if (z) {
            arrayList.add(new DebugModeCookie());
        }
//        if (UserCache.getInstance(this.mContext).hasLogin()) {
//            arrayList.add(new SessionCookie());
//        }
        StringBuilder stringBuilder = new StringBuilder("");
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                HeaderCookie headerCookie = (HeaderCookie) arrayList.get(i);
                stringBuilder.append(headerCookie.key());
                stringBuilder.append("=");
                stringBuilder.append(headerCookie.value(this.mContext));
                stringBuilder.append(";");
            }
        }
        return stringBuilder.toString();
    }
}
