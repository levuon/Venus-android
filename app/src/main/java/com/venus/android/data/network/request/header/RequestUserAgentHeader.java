//package com.venus.android.data.network.request.header;
//
//import android.content.Context;
//import android.os.Build;
//import android.os.Build.VERSION;
//
//import in.haojin.nearbymerchant.data.utils.ApkUtil;
//
//public class RequestUserAgentHeader implements RequestHeader {
//    private Context context;
//
//    public RequestUserAgentHeader(Context context) {
//        this.context = context;
//    }
//
//    public String key() {
//        return "User-Agent";
//    }
//
//    public String value() {
//        String str = "model:" + Build.MODEL + ";release:" + VERSION.RELEASE;
//        String str2 = "version_name:" + ApkUtil.getVersionName(this.context) + ";version_code:" + ApkUtil.getVersionCode(this.context);
//        return "Near-Merchant-Android;" + str2 + ";" + ("channel:" + ApkUtil.getMetaData(this.context)) + ";" + str;
//    }
//}
