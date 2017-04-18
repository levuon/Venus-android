package com.venus.android.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;

import com.venus.android.app.FortuneEnvironment;
import com.venus.android.custom.Fun1.RegisterInfoFun;
import com.venus.android.custom.integretion.impl.LoginFromLogin;
import com.venus.android.data.cache.UserCache;
import com.venus.android.data.common.ConstValue;
import com.venus.android.data.reactive.ReactiveExecutor;
import com.venus.android.data.repository.UserDataRepository;
import com.venus.android.utils.SPUtil;
import com.venus.android.utils.SecurityUtil;
import com.venus.android.view.LoginLogicView;
import com.venus.android.view.LoginLogicView.InteractionListener;

import javax.inject.Inject;


public class LoginPresenter extends BasePresenter {


    private LoginLogicView loginLogicView;
    private UserDataRepository userDataRepository;
//    private ApplicationResourceLoader c;
    private SPUtil d;
    private Context context;
    private InteractionListener interactionListener;
    private int g;
    private FortuneEnvironment fortuneEnvironment;

    @Inject
    public LoginPresenter(UserDataRepository userDataRepository, Context context, FortuneEnvironment merchantEnvironment) {
        this.userDataRepository = userDataRepository;
        this.d = SPUtil.getInstance(context);
        this.context = context;
        this.fortuneEnvironment = merchantEnvironment;
    }

    public void setView(LoginLogicView loginLogicView) {
        this.loginLogicView = loginLogicView;
    }

    public void setInteractionListener(InteractionListener interactionListener) {
        this.interactionListener = interactionListener;
    }
    public LoginLogicView getLoginLogicView() {
        return loginLogicView;
    }
    public Context getContext() {
        return context;
    }

    public void init() {
        boolean z = true;
        this.fortuneEnvironment.clearAppInitResource();
        String string = this.d.getString(ConstValue.Sp.USERNAME, "");
        String str = "";
        if (this.d.getBoolean(ConstValue.Sp.REMENBER_PASS_CHECKED, true)) {
            str = SecurityUtil.decodeBase64(this.d.getString(ConstValue.Sp.ENCRPT, ""));
        } else {
            z = false;
        }
        this.loginLogicView.renderLasLoginUserInfo(string, str, z);
        if (hasLogin()) {
            login(string, str, z);
        }
    }

    public void login(String str, String str2, boolean z) {
        this.loginLogicView.showLoading("正在登录...");
        if (TextUtils.isEmpty(str)) {
            this.loginLogicView.setUsernameError();
        } else if (TextUtils.isEmpty(str2)) {
            this.loginLogicView.setPasswordError();
        } else {
            addSubscription(this.userDataRepository.login(str, str2).compose(ReactiveExecutor.asycTransformer())
                    .map(RegisterInfoFun.getRegisterInfoFun())
                    .subscribe(new LoginFromLogin(this)));
        }
    }

    private void a(String str, String str2, boolean z) {
//        this.a.onSuccess();
//        this.a.hideLoading();
//        this.a.bindClientId(this.d.getString(SpKey.SETTING_STRING_PUSH_CLIENT_ID.key, ""));
//        this.d.save(Sp.USERNAME, str);
//        this.d.save(Sp.SESSIONID, UserViewModel.getInstance(this.e).getSessionid());
//        if (z) {
//            this.d.save(Sp.ENCRPT, SecurityUtil.encodeBase64(str2));
//        }
//        if (UserCache.getInstance(this.e).getCacheUser().isNeedAddInformation()) {
//            this.f.goUserInfoAddActivity();
//        } else {
//            this.f.goMainActivity();
//        }
//        addSubscription(this.b.pushTokenSet(false).compose(ReactiveExecutor.asycTransformer()).subscribe(new DefaultSubscriber()));
    }

    public void goMainActivity(){
            this.interactionListener.goMainActivity();
    }

    private void a(String str) {
        this.loginLogicView.onFailed(str);
    }

    private boolean hasLogin() {
        return UserCache.getInstance(this.context).hasLogin();
    }

    public void saveIsRememberPass(boolean z) {
        this.d.save(ConstValue.Sp.REMENBER_PASS_CHECKED, z);
    }

    public boolean touchLogo(MotionEvent motionEvent) {
        return false;
    }


    public boolean checkParam(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    public void handleBack() {
        this.interactionListener.finishApplication();
    }

    public void destroy() {
        super.destroy();
        this.loginLogicView.hideLoading();
    }
}
