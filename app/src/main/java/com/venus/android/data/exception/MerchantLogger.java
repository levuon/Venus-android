package com.venus.android.data.exception;

import android.util.Log;

import com.venus.android.data.common.ConstValue;


public class MerchantLogger {
    public static void log(Throwable th) {
        if (ConstValue.DEBUG_MODE) {
            th.printStackTrace();
        }
    }

    public static void i(String str, String str2) {
        if (ConstValue.DEBUG_MODE) {
            Log.i(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (ConstValue.DEBUG_MODE) {
            Log.e(str, str2);
        }
    }
}
