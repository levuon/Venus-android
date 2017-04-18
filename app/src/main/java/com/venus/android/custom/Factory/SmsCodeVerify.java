package com.venus.android.custom.Factory;

import android.os.CountDownTimer;

import com.venus.android.R;
import com.venus.android.presenter.register.PhoneVerificationCodePresenter;

/**
 * Created by lev on 5/31/16.
 */
public class SmsCodeVerify  extends CountDownTimer {
    final /* synthetic */ PhoneVerificationCodePresenter pvc;

    public SmsCodeVerify(PhoneVerificationCodePresenter phoneVerificationCodePresenter, long j, long j2) {
        super(j, j2);
        this.pvc = phoneVerificationCodePresenter;
    }

    public void onTick(long j) {
        this.pvc.getPhoneVerificationCodeView().setCountDownText((j / 1000) + this.pvc.getContext().getString(R.string.presenter_hint_second_retry));
    }

    public void onFinish() {
        this.pvc.getPhoneVerificationCodeView().setCountDownText(this.pvc.getContext().getString(R.string.presenter_retry_send_verify_code));
        this.pvc.getPhoneVerificationCodeView().onTvCountDownEnabled(true);
    }
}
