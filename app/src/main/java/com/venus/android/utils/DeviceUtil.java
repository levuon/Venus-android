package com.venus.android.utils;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;


public class DeviceUtil {
    private static String c;
    private TelephonyManager a;
    private Context b;

    public static DeviceUtil getInstance(Context context) {
        return new DeviceUtil(context);
    }

    private DeviceUtil(Context context) {
        this.a = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
    }

    public static String getDeviceID(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (TextUtils.isEmpty(c)) {
            c = telephonyManager.getDeviceId();
        }
        if (TextUtils.isEmpty(c)) {
//            c = MessageViewModel.NO_ACTION;
        }
        return c;
    }

    public static String getDeviceName() {
        return Build.BRAND + " " + Build.MODEL;
    }

    public static String getOsVersionStr() {
        return VERSION.RELEASE;
    }

    public static int getOsVersion() {
        return VERSION.SDK_INT;
    }

    public static void setDeviceId(String str) {
        c = str;
    }

//    public String getNetworkAccessMode() {
//        try {
//            if (this.b.getPackageManager().checkPermission(UpdateConfig.g, this.b.getPackageName()) != 0) {
//                return f.c;
//            }
//            ConnectivityManager connectivityManager = (ConnectivityManager) this.b.getSystemService("connectivity");
//            if (connectivityManager == null) {
//                return f.c;
//            }
//            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
//            String toLowerCase = activeNetworkInfo.getTypeName().toLowerCase();
//            if (!toLowerCase.equals("wifi")) {
//                toLowerCase = activeNetworkInfo.getExtraInfo().toLowerCase();
//            }
//            if (toLowerCase == null) {
//                return f.c;
//            }
//            return toLowerCase;
//        } catch (Exception e) {
//            return f.c;
//        }
//    }
}
