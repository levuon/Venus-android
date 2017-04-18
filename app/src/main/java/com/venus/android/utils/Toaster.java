package com.venus.android.utils;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.venus.android.custom.Runnable.ToastRunnable;

public class Toaster {
    private static Toast a;
    public static boolean isShowToast = true;

    public static void longShow(Context context, String str) {
        if (isShowToast) {
            if (a == null) {
                a = Toast.makeText(context.getApplicationContext(), str, Toast.LENGTH_LONG);
            } else {
                a.setDuration(Toast.LENGTH_LONG);
                a.setText(str);
            }
            a.show();
        }
    }

    public static void shortShow(Context context, String str) {
        if (isShowToast) {
            if (a == null) {
                a = Toast.makeText(context.getApplicationContext(), str, Toast.LENGTH_SHORT);
            } else {
                a.setDuration(Toast.LENGTH_SHORT);
                a.setText(str);
            }
            a.show();
        }
    }

    public static void showToastOnUiThread(Activity activity, String str) {
        if (activity != null) {
            activity.runOnUiThread(new ToastRunnable(activity, str));
        }
    }
}
