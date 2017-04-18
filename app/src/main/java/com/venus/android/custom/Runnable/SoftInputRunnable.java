package com.venus.android.custom.Runnable;

import com.venus.android.custom.AdjustSoftInputLinearLayout;

import timber.log.Timber;

/**
 * Created by lev on 5/30/16.
 */
public class SoftInputRunnable implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ AdjustSoftInputLinearLayout adjustSoftInputLinearLayout;

    public SoftInputRunnable(AdjustSoftInputLinearLayout adjustSoftInputLinearLayout, int i, int i2) {
        this.adjustSoftInputLinearLayout = adjustSoftInputLinearLayout;
        this.a = i;
        this.b = i2;
    }

    public void run() {
        if (this.a - this.b > 50) {
            Timber.i("state show", new Object[0]);
            this.adjustSoftInputLinearLayout.getKeyBoardStateListener().stateChange(1);
        } else if (this.adjustSoftInputLinearLayout.getKeyBoardStateListener() != null) {
            Timber.i("state hide", new Object[0]);
            this.adjustSoftInputLinearLayout.getKeyBoardStateListener().stateChange(0);
        }
    }
}
