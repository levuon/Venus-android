package com.venus.android.custom.integretion.impl;

import com.venus.android.data.entity.RegisterInfo;
import com.venus.android.data.reactive.DefaultSubscriber;
import com.venus.android.presenter.register.PhoneNumberRegisterPresenter;

/**
 * Created by lev on 5/30/16.
 */
public class checkIsSign extends DefaultSubscriber<Boolean> {
    final /* synthetic */ PhoneNumberRegisterPresenter phoneNumberRegisterPresenter;
    private String phoneNum;

    public /* synthetic */ void onNext(Boolean obj) {
        a(obj);
    }

    public checkIsSign(PhoneNumberRegisterPresenter phoneNumberRegisterPresenter, String str) {
        this.phoneNumberRegisterPresenter = phoneNumberRegisterPresenter;
        this.phoneNum = str;
    }

    public void onError(Throwable th) {
        super.onError(th);
        this.phoneNumberRegisterPresenter.getPhoneNumberRegisterView().showError(th.getMessage());
    }

    public void a(Boolean bool) {
        super.onNext(bool);
        if (bool.booleanValue()) {
            RegisterInfo.getInstance().setUsername(this.phoneNum);
            this.phoneNumberRegisterPresenter.getPhoneNumberRegisterView().navigateToLoginFragment();
        }
        this.phoneNumberRegisterPresenter.getPhoneNumberRegisterView().showVerificationCodeDialog(this.phoneNum);
    }
}
