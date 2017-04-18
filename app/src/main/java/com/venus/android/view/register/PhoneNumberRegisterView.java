package com.venus.android.view.register;


import com.venus.android.view.FormView;

public interface PhoneNumberRegisterView extends FormView {


    void navigateToVerificationFragment();

    void navigateToLoginFragment();

    void onClearPhoneInput();

    void showVerificationCodeDialog(String str);

}
