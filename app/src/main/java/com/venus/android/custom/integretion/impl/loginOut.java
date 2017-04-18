package com.venus.android.custom.integretion.impl;

import com.venus.android.data.cache.UserCache;
import com.venus.android.data.common.ConstValue.Sp;
import com.venus.android.data.reactive.DefaultSubscriber;
import com.venus.android.presenter.SettingPresenter;
import com.venus.android.ui.activity.MainActivity;
import com.venus.android.utils.AppManager;

/**
 * Created by lev on 6/2/16.
 */
public class LoginOut extends DefaultSubscriber<Boolean> {
    final /* synthetic */ SettingPresenter settingPresenter;

    public LoginOut(SettingPresenter logoutPresenter) {
        this.settingPresenter = logoutPresenter;
    }

    public /* synthetic */ void onNext(Boolean obj) {
        logout( obj);
    }

    public void onError(Throwable th) {
        a();
    }

    public void logout(Boolean bool) {
        a();
    }

    private void a() {
        this.settingPresenter.getLocalCache().save(Sp.PASSWORD, "");
        this.settingPresenter.getLocalCache().save(Sp.COOKIE, "");
        UserCache.getInstance(this.settingPresenter.getContext()).clearUserCache();
//        this.settingPresenter.f.clearAppInitResource();
        this.settingPresenter.getLocalCache().save(Sp.SESSIONID, "");
        this.settingPresenter.getLocalCache().save(Sp.PASSWORD, "");
        this.settingPresenter.getLocalCache().save(Sp.COOKIE, "");
        AppManager.getAppManager().finishActivity(MainActivity.class);
        this.settingPresenter.getInteractionListener().goToLoginActivity();
    }
}
