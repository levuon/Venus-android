package com.venus.android.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;

public class ApkUtil {
    public static final String IS_FIRST_LAUNCH = "is_first_launch";

    public static boolean isFirstPublish(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA).metaData.getBoolean("FIRST_LAUNCHER");
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static boolean isFirstInstall(Context context) {
        if (SPUtil.getInstance(context).getBoolean(IS_FIRST_LAUNCH, true) && TextUtils.isEmpty(SPUtil.getInstance(context).getString("username", ""))) {
            return true;
        }
        return false;
    }

    public static void setAlredyInstalled(Context context) {
        SPUtil.getInstance(context).save(IS_FIRST_LAUNCH, false);
    }

    public static String getMetaData(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA).metaData;
            if (bundle != null) {
                return bundle.getString("UMENG_CHANNEL", "");
            }
            return "";
        } catch (NameNotFoundException e) {
            return "";
        }
    }

    public static String getVersionName(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo.versionName.startsWith("V") || packageInfo.versionName.startsWith("v")) {
                return packageInfo.versionName;
            }
            return "v" + packageInfo.versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "1.x";
        }
    }

    public static int getVersionCode(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }
}
