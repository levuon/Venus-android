package com.venus.android.view;

public interface WelcomeView extends BaseUiLogicView {

    public interface InteractionListener {
        void goMainActivity();

        void goGuideActivity();
    }


    void showDefaultStartPage();

    void showRegisterGuide();

    void showStartPage(String str);
}
