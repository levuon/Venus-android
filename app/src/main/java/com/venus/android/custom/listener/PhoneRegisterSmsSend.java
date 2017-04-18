package com.venus.android.custom.listener;


import com.venus.android.custom.Dialog.DoubleBtnConfirmDialog;
import com.venus.android.presenter.register.PhoneNumberRegisterPresenter;
import com.venus.android.ui.fragment.register.PhoneNumRegisterFragment;

/**
 * Created by lev on 5/25/16.
 */
public class PhoneRegisterSmsSend implements DoubleBtnConfirmDialog.Builder.DoubleBtnClickListener {
    final /* synthetic */ String str;
    final /* synthetic */ PhoneNumRegisterFragment phoneNumRegisterFragment;

    public PhoneRegisterSmsSend(PhoneNumRegisterFragment phoneNumRegisterFragment, String str) {
        this.phoneNumRegisterFragment = phoneNumRegisterFragment;
        this.str = str;
    }

    public void onConfirm() {
        ((PhoneNumberRegisterPresenter) this.phoneNumRegisterFragment.presenter).smsCodeVerification(this.str);
    }

    public void onCancel() {
    }
}
