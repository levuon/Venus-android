package com.venus.android.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


/**
 *
 * 存储数据 工具类
 */

public class SPUtil {
    private static volatile SPUtil spUtil;
    private static SharedPreferences sharedPreferences;

    public static SPUtil getInstance(Context context) {
        if (spUtil == null) {
            synchronized (SPUtil.class) {
                if (spUtil == null) {
                    spUtil = new SPUtil();
                    sharedPreferences = context.getApplicationContext().getSharedPreferences("shared", 7);
                }
            }
        }
        return spUtil;
    }

    public void save(String str, String str2) {
        Editor edit = sharedPreferences.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public void save(String str, long j) {
        Editor edit = sharedPreferences.edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public void save(String str, int i) {
        Editor edit = sharedPreferences.edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public void save(String str, float f) {
        Editor edit = sharedPreferences.edit();
        edit.putFloat(str, f);
        edit.apply();
    }

    public void save(String str, boolean z) {
        Editor edit = sharedPreferences.edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public void remove(String str) {
        Editor edit = sharedPreferences.edit();
        if (sharedPreferences.contains(str)) {
            edit.remove(str);
            edit.apply();
        }
    }

    public boolean hasValue(String str) {
        return sharedPreferences.contains(str);
    }

    public boolean getBoolean(String str, boolean z) {
        return sharedPreferences.getBoolean(str, z);
    }

    public String getString(String str, String str2) {
        return sharedPreferences.getString(str, str2);
    }

    public int getInt(String str, int i) {
        return sharedPreferences.getInt(str, i);
    }

    public long getLong(String str, long j) {
        return sharedPreferences.getLong(str, j);
    }

    public float getFloat(String str, float f) {
        return sharedPreferences.getFloat(str, f);
    }
}
