package com.venus.android.custom;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.venus.android.custom.Runnable.SoftInputRunnable;

import timber.log.Timber;

public class AdjustSoftInputLinearLayout extends LinearLayout {
    public static final int KEYBOARD_HIDE = 0;
    public static final int KEYBOARD_SHOW = 1;
    private Handler a = new Handler();

    public KeyBoardStateListener getKeyBoardStateListener() {
        return keyBoardStateListener;
    }

    private KeyBoardStateListener keyBoardStateListener;

    public interface KeyBoardStateListener {
        void stateChange(int i);
    }

    public AdjustSoftInputLinearLayout(Context context) {
        super(context);
    }

    public AdjustSoftInputLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Timber.i("w--" + i + " h--" + i2 + "  oldw--" + i3 + "  oldh--" + i4, new Object[0]);
        Timber.i("oldh - h =" + (i4 - i2), new Object[0]);
        this.a.post(new SoftInputRunnable(this, i4, i2));
    }

    public void setKeyBoardStateListener(KeyBoardStateListener keyBoardStateListener) {
        this.keyBoardStateListener = keyBoardStateListener;
    }
}
