package com.venus.android.presenter;

import android.content.Context;

import com.venus.android.custom.Fun1.BooleanFun;
import com.venus.android.custom.integretion.impl.LoginOut;
import com.venus.android.data.reactive.ReactiveExecutor;
import com.venus.android.data.repository.EnvironmentDataRepository;
import com.venus.android.data.repository.UserDataRepository;
import com.venus.android.utils.SPUtil;
import com.venus.android.view.SettingView;
import com.venus.android.view.SettingView.InteractionListener;

import javax.inject.Inject;

/**
 * Created by lev on 6/2/16.
 */
public class SettingPresenter extends BasePresenter {

    private SettingView settingView;



    private InteractionListener interactionListener;
    private Context context;
    private SPUtil localCache;
    private EnvironmentDataRepository environmentDataRepository;
    private UserDataRepository userDataRepository;



    public SettingView getSettingView() {
        return settingView;
    }
    public void setView(SettingView settingView) {
        this.settingView = settingView;
    }
    public void setInteractionListener(InteractionListener interactionListener) {
        this.interactionListener = interactionListener;
    }
    public SPUtil getLocalCache() {
        return localCache;
    }
    public Context getContext() {
        return context;
    }
    public InteractionListener getInteractionListener() {
        return interactionListener;
    }
    @Inject
    public SettingPresenter(Context context, UserDataRepository userDataRepository) {
        this.localCache = SPUtil.getInstance(context);
        this.userDataRepository = userDataRepository;
        this.context = context;
    }



    public void goMyBankInfo() {
//        if(UserCache)
    }

    public void logout() {
        addSubscription(this.userDataRepository
                .logout()
                .compose(ReactiveExecutor.<Boolean>asycTransformer())
                .map(BooleanFun.getCheckBoolean())
                .subscribe(new LoginOut(this)));
    }
}
