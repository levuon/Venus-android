package com.venus.android.custom.Runnable;

import com.venus.android.ui.fragment.LoginFragment;

/**
 * Created by lev on 5/30/16.
 */
public class loginFragmentRunnable implements Runnable {
    final /* synthetic */ LoginFragment loginFragment;

    public loginFragmentRunnable(LoginFragment loginFragment) {
        this.loginFragment = loginFragment;
    }

    public void run() {
        if (this.loginFragment.scrollView != null) {
            this.loginFragment.scrollView.scrollTo(0, this.loginFragment.scrollView.getHeight());
        }
    }
}
