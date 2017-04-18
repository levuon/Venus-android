package com.venus.android.presenter.register;

import android.content.Context;

import com.venus.android.R;
import com.venus.android.custom.Fun1.BooleanFun;
import com.venus.android.custom.integretion.impl.checkIsSign;
import com.venus.android.custom.integretion.impl.sendSmsCode;
import com.venus.android.data.entity.RegisterInfo;
import com.venus.android.data.reactive.ReactiveExecutor;
import com.venus.android.data.repository.UserDataRepository;
import com.venus.android.presenter.BasePresenter;
import com.venus.android.utils.ValidateUtil;
import com.venus.android.view.register.PhoneNumberRegisterView;

import javax.inject.Inject;


public class PhoneNumberRegisterPresenter extends BasePresenter {
    private PhoneNumberRegisterView phoneNumberRegisterView;
    private UserDataRepository userDataRepository;
    public Context getContext() {
        return context;
    }

    private Context context;

    @Inject
    public PhoneNumberRegisterPresenter(UserDataRepository userDataRepository, Context context) {
        this.userDataRepository = userDataRepository;
        this.context = context;
    }

    public PhoneNumberRegisterView getPhoneNumberRegisterView() {
        return phoneNumberRegisterView;
    }
    public void setView(PhoneNumberRegisterView phoneNumberRegisterView) {
        this.phoneNumberRegisterView = phoneNumberRegisterView;
    }

    public void checkIsAlreadySigned(String phoneNum) {
        RegisterInfo.getInstance().setUsername(phoneNum);
        addSubscription(this.userDataRepository.checkIsSigned(phoneNum).compose(ReactiveExecutor.asycTransformer())
                .map(BooleanFun.getCheckBoolean())
                .subscribe(new checkIsSign(this, phoneNum)));
    }

    public void validateForm(String str) {
        if (!ValidateUtil.isMobileNum(str)) {
            this.phoneNumberRegisterView.showError(this.phoneNumberRegisterView.getContext().getString(R.string.hint_please_enter_correct_phone_num));
        } else {
            RegisterInfo.getInstance().setUsername(str);
            if (str.equals(RegisterInfo.getInstance().getSmscodeCheckePhoneNumber())) {
                this.phoneNumberRegisterView.navigateToVerificationFragment();
            } else {
                checkIsAlreadySigned(str);
            }
        }
    }

    public void smsCodeVerification(String str) {
        RegisterInfo.getInstance().setUsername(str);
//        this.phoneNumberRegisterView.showLoading(this.context.getString(R.string.loading_hint_checking_sms_code));
        addSubscription(this.userDataRepository
                .sendSmsCode(str)
                .compose(ReactiveExecutor.asycTransformer())
                .map(BooleanFun.getCheckBoolean())
                .subscribe(new sendSmsCode(this, str)));
    }
}
