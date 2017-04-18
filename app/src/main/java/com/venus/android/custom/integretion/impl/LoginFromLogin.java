package com.venus.android.custom.integretion.impl;

import android.text.TextUtils;

import com.venus.android.data.cache.UserCache;
import com.venus.android.data.entity.RegisterInfo;
import com.venus.android.data.entity.User;
import com.venus.android.data.reactive.DefaultSubscriber;
import com.venus.android.presenter.LoginPresenter;

/**
 * Created by lev on 6/2/16.
 */
public class LoginFromLogin extends DefaultSubscriber<User> {
    final /* synthetic */ LoginPresenter loginPresenter;

    public LoginFromLogin(LoginPresenter LoginPresenter) {
        this.loginPresenter = LoginPresenter;
    }

    public /* synthetic */ void onNext(User obj) {
        loginFromRegister( obj);
    }

    public void onCompleted() {
        super.onCompleted();
        this.loginPresenter.getLoginLogicView().hideLoading();
    }

    public void onError(Throwable th) {
        super.onError(th);
        this.loginPresenter.getLoginLogicView().showError(th.getMessage());
    }

    public void loginFromRegister(User user) {
        super.onNext(user);
        RegisterInfo.clearInstance();
        if (user == null || TextUtils.isEmpty(user.getSessionId())) {
            return;
        }
        UserCache.getInstance(this.loginPresenter.getContext()).cacheUser(user);
        this.loginPresenter.goMainActivity();
    }
}
