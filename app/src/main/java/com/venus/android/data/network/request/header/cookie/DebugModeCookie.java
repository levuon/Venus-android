package com.venus.android.data.network.request.header.cookie;

import android.content.Context;

public class DebugModeCookie implements HeaderCookie {
    public String key() {
        return "mmfct";
    }

    public String value(Context context) {
        return "1";
    }
}
