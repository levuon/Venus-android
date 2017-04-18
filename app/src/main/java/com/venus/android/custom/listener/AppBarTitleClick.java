package com.venus.android.custom.listener;

import android.view.View;

import com.venus.android.custom.AppBar.OnTitleClickListener;

/**
 * Created by lev on 5/30/16.
 */
public class AppBarTitleClick  implements View.OnClickListener {
    private final OnTitleClickListener a;

    private AppBarTitleClick(OnTitleClickListener onTitleClickListener) {
        this.a = onTitleClickListener;
    }

    public static View.OnClickListener getTitleClickListner(OnTitleClickListener onTitleClickListener) {
        return new AppBarTitleClick(onTitleClickListener);
    }

    public void onClick(View view) {
        this.a.onClick(view);
    }
}
