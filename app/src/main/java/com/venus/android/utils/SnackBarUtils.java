package com.venus.android.utils;

import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;

import com.venus.android.custom.listener.SnackBarClick;

public class SnackBarUtils {
    public static void showLongSnackBar(View view, String str, String str2) {
        Snackbar.make(view, (CharSequence) str, 0).setAction((CharSequence) str2, new SnackBarClick()).show();
    }

    public static void showShortSnackBar(View view, String str, String str2) {
        Snackbar.make(view, (CharSequence) str, -1).setAction((CharSequence) str2, new SnackBarClick()).show();
    }

    public static void showClickSnackBar(View view, String str, String str2, OnClickListener onClickListener) {
        Snackbar.make(view, (CharSequence) str, 0).setAction((CharSequence) str2, onClickListener).show();
    }

    public static void showClickSnackBarAlways(View view, String str, String str2, OnClickListener onClickListener) {
        Snackbar.make(view, (CharSequence) str, 0).setAction((CharSequence) str2, onClickListener).show();
    }

    public static void showShortSnackBar(View view, String str) {
        showShortSnackBar(view, str, "我知道了");
    }
}
