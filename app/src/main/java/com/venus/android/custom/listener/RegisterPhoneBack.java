package com.venus.android.custom.listener;

import android.view.View;

import com.venus.android.custom.AppBar;
import com.venus.android.ui.fragment.register.PhoneNumRegisterFragment;

/**
 * Created by lev on 5/30/16.
 */
public class RegisterPhoneBack implements AppBar.OnLeftClickListener {
    final /* synthetic */ PhoneNumRegisterFragment phoneNumRegisterFragment;

    public RegisterPhoneBack(PhoneNumRegisterFragment phoneVerificationCodeFragment) {
        this.phoneNumRegisterFragment = phoneVerificationCodeFragment;
    }

    public void onClick(View view) {
//        this.phoneNumRegisterFragment.getActivity().getSupportFragmentManager().popBackStack();
        this.phoneNumRegisterFragment.backToLoginActivity();
    }
}
