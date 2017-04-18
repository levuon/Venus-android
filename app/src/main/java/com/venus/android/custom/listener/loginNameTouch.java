package com.venus.android.custom.listener;

import android.view.MotionEvent;
import android.view.View;

import com.venus.android.ui.fragment.LoginFragment;

/**
 * Created by lev on 5/30/16.
 */
public class loginNameTouch implements View.OnTouchListener {
    final /* synthetic */ LoginFragment a;

    public loginNameTouch(LoginFragment loginFragment) {
        this.a = loginFragment;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.a.delayShow();
        return false;
    }
}
