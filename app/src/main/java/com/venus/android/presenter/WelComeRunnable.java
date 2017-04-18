package com.venus.android.presenter;

/**
 * Created by lev on 5/25/16.
 */
public class WelComeRunnable implements Runnable {
    private final WelcomePresenter welcomePresenter;

    private WelComeRunnable(WelcomePresenter welcomePresenter) {
        this.welcomePresenter = welcomePresenter;
    }

    public static Runnable handleClick(WelcomePresenter welcomePresenter) {
        return new WelComeRunnable(welcomePresenter);
    }

    public void run() {
        this.welcomePresenter.click();
    }
}
