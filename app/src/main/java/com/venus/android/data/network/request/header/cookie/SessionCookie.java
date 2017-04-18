//package com.venus.android.data.network.request.header.cookie;
//
//import android.content.Context;
//
//
//public class SessionCookie implements HeaderCookie {
//    public String key() {
//        return Sp.SESSIONID;
//    }
//
//    public String value(Context context) {
//        String str = "";
//        UserCache instance = UserCache.getInstance(context);
//        if (instance.hasLogin()) {
//            return instance.getCacheUser().getSessionid();
//        }
//        return str;
//    }
//}
