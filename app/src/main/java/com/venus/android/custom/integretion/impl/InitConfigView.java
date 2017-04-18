package com.venus.android.custom.integretion.impl;

import com.venus.android.data.reactive.DefaultSubscriber;
import com.venus.android.presenter.WelcomePresenter;
import com.venus.android.viewmodel.InitConfigViewModel;

/**
 * Created by lev on 5/25/16.
 */
public class InitConfigView extends DefaultSubscriber<InitConfigViewModel> {
    final /* synthetic */ WelcomePresenter welcomePresenter;

    public InitConfigView(WelcomePresenter welcomePresenter) {
        this.welcomePresenter = welcomePresenter;
    }

    @Override
    public void onNext(InitConfigViewModel initConfigViewModel) {
        showStartPage(initConfigViewModel);
    }

    //    public void onNext(Object  obj) {
//        a((InitConfigViewModel) obj);
//    }

    public void onError(Throwable th) {
        super.onError(th);
        this.welcomePresenter.showDefaultStartPage();
    }

    public void showStartPage(InitConfigViewModel initConfigViewModel) {
        super.onNext(initConfigViewModel);
        long j = initConfigViewModel.startPageDelayTime == 0 ? 3000 : initConfigViewModel.startPageDelayTime;
        if (this.welcomePresenter.startPageFlag(initConfigViewModel.startPageUrl)) {
            this.welcomePresenter.showRegisterGuide(initConfigViewModel.startPageUrl, j);
        } else {
            this.welcomePresenter.showDefaultStartPage();
        }
    }
}

