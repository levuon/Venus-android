package com.venus.android.utils;

import android.content.ClipData;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.ClipboardManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import timber.log.Timber;

public class InputTypeUtil {
    public static void saveClipBoard(Context context, String str) {
        if (context != null) {
            if (VERSION.SDK_INT < 11) {
                ((ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE)).setText(str);
            } else {
                ((android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("honey", str));
            }
        }
    }

    public static void openSoftKeyBoard(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (view != null) {
            Timber.i("-----打开软键盘------", new Object[0]);
            inputMethodManager.showSoftInput(view, 2);
        }
    }

    public static void closeSoftKeyBoard(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (view != null && view.getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
        }
    }
}
