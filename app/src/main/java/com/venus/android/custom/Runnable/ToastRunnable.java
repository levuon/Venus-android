package com.venus.android.custom.Runnable;

import android.app.Activity;

import com.venus.android.utils.Toaster;

/**
 * Created by lev on 6/6/16.
 */
public class ToastRunnable implements Runnable {
    final /* synthetic */ Activity a;
    final /* synthetic */ String b;

    public ToastRunnable(Activity activity, String str) {
        this.a = activity;
        this.b = str;
    }

    public void run() {
        Toaster.longShow(this.a, this.b);
    }
}
