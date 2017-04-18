package com.venus.android.presenter.register;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;

import com.venus.android.R;
import com.venus.android.custom.Factory.SmsCodeVerify;
import com.venus.android.custom.Fun1.RegisterInfoFun;
import com.venus.android.custom.Fun1.UserAssetFun;
import com.venus.android.custom.integretion.impl.LoginInFromRegister;
import com.venus.android.custom.integretion.impl.RegisterInfoView;
import com.venus.android.custom.integretion.impl.queryAsset;
import com.venus.android.data.cache.UserCache;
import com.venus.android.data.entity.RegisterInfo;
import com.venus.android.data.reactive.DefaultSubscriber;
import com.venus.android.data.reactive.ReactiveExecutor;
import com.venus.android.data.repository.UserDataRepository;
import com.venus.android.presenter.BasePresenter;
import com.venus.android.utils.ValidateUtil;
import com.venus.android.view.register.PhoneVerificationCodeView;

import javax.inject.Inject;

/**
 * Created by lev on 5/31/16.
 */
public class PhoneVerificationCodePresenter extends BasePresenter {


    private PhoneVerificationCodeView phoneVerificationCodeView;
    private RegisterInfo registerInfo;
    private CountDownTimer b;
    private Context context;
    public UserDataRepository userDataRepository;

    public PhoneVerificationCodeView getPhoneVerificationCodeView() {
        return phoneVerificationCodeView;
    }

    public Context getContext() {
        return context;
    }
    public RegisterInfo getRegisterInfo() {
        return registerInfo;
    }
    @Inject
    public PhoneVerificationCodePresenter(UserDataRepository userDataRepository, Context context) {
        this.userDataRepository = userDataRepository;
        this.context = context;
    }

    public void setView(PhoneVerificationCodeView phoneVerificationCodeView) {
        this.phoneVerificationCodeView = phoneVerificationCodeView;
    }

    public void create() {
        this.registerInfo = RegisterInfo.getInstance();
        this.phoneVerificationCodeView.onSetCodeToEdit(this.registerInfo.getSmsCheckCode());
        this.phoneVerificationCodeView.setCountDownText(this.context.getString(R.string.presenter_retry_send_verify_code));
        this.phoneVerificationCodeView.onTvCountDownEnabled(true);
        startCountDown();
    }



    public void startCountDown() {
        this.phoneVerificationCodeView.onTvCountDownEnabled(false);
        if (this.b == null) {
            this.b = new SmsCodeVerify(this, 60000, 1000);
        }
        this.b.start();
    }

    public boolean checkParam(String str, String str2, String str3) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3);
    }

    public boolean checkPsw(String str, String str2) {
        return !TextUtils.isEmpty(str) && str.equals(str2) ;
    }

    public void validate(String smsCode, String str, String str2) {
        this.phoneVerificationCodeView.hideSoftKeyBoard();
        if (!ValidateUtil.isLeaglePasswd(str)) {
            this.phoneVerificationCodeView.showError(this.context.getString(R.string.hint_please_enter_correct_password));
            this.phoneVerificationCodeView.clearPassWordText();
        } else if (checkPsw(str2, str)) {
            RegisterInfo.getInstance().setSmsCheckCode(smsCode);
            RegisterInfo.getInstance().setPassword(str);
            addSubscription(this.userDataRepository.register(this.registerInfo)
                    .compose(ReactiveExecutor.asycTransformer())
                    .map(RegisterInfoFun.getRegisterInfoFun())
                    .subscribe(new RegisterInfoView(this)));
        } else {
            this.phoneVerificationCodeView.showError(this.context.getString(R.string.hint_diffrent_pass_with_confirm_pass));
            this.phoneVerificationCodeView.clearPassWordText();
        }
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return true;
    }

    public void validatePassword(String str) {
        if (ValidateUtil.isLeaglePasswd(str)) {
            this.phoneVerificationCodeView.focusConfirmPasswordEdit();
            return;
        }
        this.phoneVerificationCodeView.hideSoftKeyBoard();
        this.phoneVerificationCodeView.showError(this.context.getString(R.string.hint_please_enter_correct_password));
        this.phoneVerificationCodeView.clearPassWordText();
    }

    public void login() {
        addSubscription(this.userDataRepository.login(RegisterInfo.getInstance().getUsername(), RegisterInfo.getInstance().getPassword())
                .compose(ReactiveExecutor.asycTransformer())
                .map(RegisterInfoFun.getRegisterInfoFun())
                .subscribe(new LoginInFromRegister(this)));
    }

    public void queryUserAsset() {
        addSubscription(this.userDataRepository.queryAsset(UserCache.getInstance(this.getContext()).getUserId())
                .compose(ReactiveExecutor.asycTransformer())
                .map(UserAssetFun.getUserAssetFun())
                .subscribe(new queryAsset(this)));
    }

    public void sendSmsCode() {
        ReactiveExecutor.asyc(this.userDataRepository.sendSmsCode(RegisterInfo.getInstance().getUsername())).subscribe(new DefaultSubscriber());
    }

    public void destroy() {
        if (this.b != null) {
            this.b.cancel();
        }
    }
}
