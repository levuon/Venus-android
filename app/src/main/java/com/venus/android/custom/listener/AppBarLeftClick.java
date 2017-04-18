package com.venus.android.custom.listener;

import android.view.View;

import com.venus.android.custom.AppBar;
import com.venus.android.custom.AppBar.OnLeftClickListener;

/**
 * Created by lev on 5/30/16.
 */
public class AppBarLeftClick implements View.OnClickListener {
    private final AppBar.OnLeftClickListener a;

    private AppBarLeftClick(OnLeftClickListener onLeftClickListener) {
        this.a = onLeftClickListener;
    }

    public static View.OnClickListener getLeftClickListener(OnLeftClickListener onLeftClickListener) {
        return new AppBarLeftClick(onLeftClickListener);
    }

    public void onClick(View view) {
        this.a.onClick(view);
    }
}
