package com.venus.android.custom.integretion.impl;

import android.text.TextUtils;

import com.venus.android.data.cache.UserCache;
import com.venus.android.data.common.ConstValue;
import com.venus.android.data.entity.RegisterInfo;
import com.venus.android.data.entity.User;
import com.venus.android.data.reactive.DefaultSubscriber;
import com.venus.android.presenter.register.PhoneVerificationCodePresenter;
import com.venus.android.utils.SPUtil;
import com.venus.android.utils.SecurityUtil;

/**
 * Created by lev on 5/31/16.
 */
public class RegisterInfoView extends DefaultSubscriber<User> {
    final  PhoneVerificationCodePresenter phoneVerificationCodePresenter;

    public RegisterInfoView(PhoneVerificationCodePresenter phoneVerificationCodePresenter) {
        this.phoneVerificationCodePresenter = phoneVerificationCodePresenter;
    }

    public void onNext(User obj) {
        register(obj);
    }

    public void onError(Throwable th) {
        super.onError(th);
        this.phoneVerificationCodePresenter.getPhoneVerificationCodeView().showError(th.getMessage());
    }

    public void register(User user) {
        super.onNext(user);
        if (user == null || TextUtils.isEmpty(user.getSessionId())) {
            this.phoneVerificationCodePresenter.login();
            return;
        }
        UserCache.getInstance(this.phoneVerificationCodePresenter.getContext()).cacheUser(user);
        save(user);
        RegisterInfo.clearInstance();
        //查询merchant 资产
        this.phoneVerificationCodePresenter.queryUserAsset();
    }

    private void save(User user) {
        SPUtil instance = SPUtil.getInstance(this.phoneVerificationCodePresenter.getContext());
        instance.save(ConstValue.Sp.USERNAME, user.getMobileNo());
        instance.save(ConstValue.Sp.SESSIONID, user.getSessionId());
        instance.save(ConstValue.Sp.ENCRPT, SecurityUtil.encodeBase64(this.phoneVerificationCodePresenter.getRegisterInfo().getPassword()));
        instance.save(ConstValue.Sp.REMENBER_PASS_CHECKED, false);
    }
}
