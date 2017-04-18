package com.venus.android.custom.listener;

import android.view.View;

import com.venus.android.custom.AppBar;

/**
 * Created by lev on 5/30/16.
 */
public class AppBarClick implements View.OnClickListener {
    private static final AppBarClick a = new AppBarClick();

    private AppBarClick() {
    }

    public static View.OnClickListener onClick() {
        return a;
    }

    public void onClick(View view) {
        AppBar.setView(view);
    }
}
