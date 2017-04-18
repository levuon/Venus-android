package com.venus.android.custom.integretion.impl;

import android.text.TextUtils;

import com.venus.android.data.entity.BaseInfo;
import com.venus.android.data.entity.UserTotalAsset;
import com.venus.android.data.reactive.DefaultSubscriber;
import com.venus.android.presenter.register.PhoneVerificationCodePresenter;

/**
 * Created by lev on 6/2/16.
 */
public class queryAsset extends DefaultSubscriber<UserTotalAsset> {
    final /* synthetic */ PhoneVerificationCodePresenter phoneVerificationCodePresenter;

    public queryAsset(PhoneVerificationCodePresenter phoneVerificationCodePresenter) {
        this.phoneVerificationCodePresenter = phoneVerificationCodePresenter;
    }

    public /* synthetic */ void onNext(UserTotalAsset obj) {
        queryAsset(obj);
    }

    public void onError(Throwable th) {
        super.onError(th);
        this.phoneVerificationCodePresenter.getPhoneVerificationCodeView().showError(th.getMessage());
    }

    public void queryAsset(UserTotalAsset uta) {
        super.onNext(uta);
        if (uta == null || TextUtils.isEmpty(uta.getTotalAssert())) {
            this.phoneVerificationCodePresenter.getPhoneVerificationCodeView().goLoginActivity();
            return;
        }else if(Double.parseDouble(uta.getTotalAssert()) != 0.0) {
            BaseInfo.getInstance().setIsAsset(true);
            //TODO 获取用户信息, 银行卡 等等。
        }else {
            BaseInfo.getInstance().setIsAsset(false);
            this.phoneVerificationCodePresenter.getPhoneVerificationCodeView().navigateToMainActivity();
        }

    }
}
