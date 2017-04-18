package com.venus.android.view;

public interface LoginLogicView extends BaseUiLogicView {

    public interface InteractionListener {
        void finishActivity();

        void finishApplication();

        void goMainActivity();
    }

    void bindClientId(String str);

    void onFailed(String str);

    void onSuccess();

    void renderLasLoginUserInfo(String str, String str2, boolean z);

    void setPasswordError();

    void setUsernameError();

    void showForgetPwd();
}
