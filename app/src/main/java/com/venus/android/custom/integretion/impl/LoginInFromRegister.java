package com.venus.android.custom.integretion.impl;

import android.text.TextUtils;

import com.venus.android.data.cache.UserCache;
import com.venus.android.data.entity.RegisterInfo;
import com.venus.android.data.entity.User;
import com.venus.android.data.reactive.DefaultSubscriber;
import com.venus.android.presenter.register.PhoneVerificationCodePresenter;

/**
 * Created by lev on 6/2/16.
 */
public class LoginInFromRegister extends DefaultSubscriber<User> {
    final /* synthetic */ PhoneVerificationCodePresenter phoneVerificationCodePresenter;

    public LoginInFromRegister(PhoneVerificationCodePresenter phoneVerificationCodePresenter) {
        this.phoneVerificationCodePresenter = phoneVerificationCodePresenter;
    }

    public /* synthetic */ void onNext(User obj) {
        loginFromRegister( obj);
    }

    public void onError(Throwable th) {
        super.onError(th);
        this.phoneVerificationCodePresenter.getPhoneVerificationCodeView().showError(th.getMessage());
    }

    public void loginFromRegister(User user) {
        super.onNext(user);
        RegisterInfo.clearInstance();
        if (user == null || TextUtils.isEmpty(user.getSessionId())) {
            this.phoneVerificationCodePresenter.getPhoneVerificationCodeView().goLoginActivity();
            return;
        }
        UserCache.getInstance(this.phoneVerificationCodePresenter.getContext()).cacheUser(user);
        this.phoneVerificationCodePresenter.getPhoneVerificationCodeView().navigateToMainActivity();
    }
}
