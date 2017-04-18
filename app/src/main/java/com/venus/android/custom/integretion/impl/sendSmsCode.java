package com.venus.android.custom.integretion.impl;

import com.venus.android.R;
import com.venus.android.data.entity.RegisterInfo;
import com.venus.android.data.reactive.DefaultSubscriber;
import com.venus.android.presenter.register.PhoneNumberRegisterPresenter;

/**
 * Created by lev on 5/31/16.
 */
public class sendSmsCode extends DefaultSubscriber<Boolean> {
    final /* synthetic */ PhoneNumberRegisterPresenter phoneNumberRegisterPresenter;
    private String str;

    public /* synthetic */ void onNext(Boolean obj) {
        sendCodeResult(obj);
    }

    public sendSmsCode(PhoneNumberRegisterPresenter phoneNumberRegisterPresenter, String str) {
        this.phoneNumberRegisterPresenter = phoneNumberRegisterPresenter;
        this.str = str;
    }

    public void onError(Throwable th) {
        super.onError(th);
        this.phoneNumberRegisterPresenter.getPhoneNumberRegisterView().hideLoading();
        this.phoneNumberRegisterPresenter.getPhoneNumberRegisterView().showError(th.getMessage());
    }

    public void sendCodeResult(Boolean bool) {
        super.onNext(bool);
        this.phoneNumberRegisterPresenter.getPhoneNumberRegisterView().hideLoading();
        if (bool.booleanValue()) {
            RegisterInfo.getInstance().setUsername(this.str);
            this.phoneNumberRegisterPresenter.getPhoneNumberRegisterView().navigateToVerificationFragment();
            return;
        }
        this.phoneNumberRegisterPresenter
                .getPhoneNumberRegisterView()
                .showError(this.phoneNumberRegisterPresenter
                        .getContext()
                        .getString(R.string.presenter_hint_get_sms_code_error));
    }
}
