package com.venus.android.custom.listener;

import android.view.View;

import com.venus.android.custom.AppBar.OnRightClickListener;

/**
 * Created by lev on 5/30/16.
 */
public class AppBarRightClick  implements View.OnClickListener {
    private final OnRightClickListener a;

    private AppBarRightClick(OnRightClickListener onRightClickListener) {
        this.a = onRightClickListener;
    }

    public static View.OnClickListener getRightClickListener(OnRightClickListener onRightClickListener) {
        return new AppBarRightClick(onRightClickListener);
    }

    public void onClick(View view) {
        this.a.onClick(view);
    }
}
