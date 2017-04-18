package com.venus.android.custom.listener;

import android.view.View;

import com.venus.android.custom.AppBar;
import com.venus.android.ui.fragment.register.PhoneVerificationCodeFragment;

/**
 * Created by lev on 5/31/16.
 */
public class PhoneRegisterLeftClick implements AppBar.OnLeftClickListener {
    final /* synthetic */ PhoneVerificationCodeFragment phoneVerificationCodeFragment;

    public PhoneRegisterLeftClick(PhoneVerificationCodeFragment phoneVerificationCodeFragment) {
        this.phoneVerificationCodeFragment = phoneVerificationCodeFragment;
    }

    public void onClick(View view) {
        this.phoneVerificationCodeFragment.getActivity().getSupportFragmentManager().popBackStack();
    }
}
