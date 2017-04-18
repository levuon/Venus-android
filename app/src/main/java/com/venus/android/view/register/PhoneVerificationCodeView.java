package com.venus.android.view.register;

import com.venus.android.view.FormView;

public interface PhoneVerificationCodeView extends FormView {

    void navigateToMainActivity();

    void goLoginActivity();

    void clearPassWordText();

    void focusConfirmPasswordEdit();

    void onSetCodeToEdit(String str);

    void onTvCountDownEnabled(boolean z);

    void setCountDownText(String str);
}
