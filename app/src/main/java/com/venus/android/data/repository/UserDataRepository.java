package com.venus.android.data.repository;

import android.content.Context;

import com.venus.android.custom.integretion.service.LoginOutSubscribe;
import com.venus.android.custom.integretion.service.LoginSubscribe;
import com.venus.android.custom.integretion.service.RegisterInfoSubcribe;
import com.venus.android.custom.integretion.service.checkIsSignSubscribe;
import com.venus.android.custom.integretion.service.queryAssetSubscribe;
import com.venus.android.custom.integretion.service.sendSmsSubcribe;
import com.venus.android.data.entity.RegisterInfo;
import com.venus.android.data.entity.User;
import com.venus.android.data.entity.UserTotalAsset;
import com.venus.android.data.network.HRetrofitCreator;
import com.venus.android.data.network.services.UserAccNetService;

import rx.Observable;

/**
 * Created by lev on 5/29/16.
 */
public class UserDataRepository implements DataRepository {

    public static final int USER_ALREADY_REGISTER = 1;
    private UserAccNetService userAccNetService = HRetrofitCreator.createAppInitInstance().getService(UserAccNetService.class);
    private NetMsgHandler netMsgHandler;
    private Context context;

    public Context getContext() {
        return context;
    }
    public UserAccNetService getUserAccNetService() {
        return userAccNetService;
    }
    public NetMsgHandler getNetMsgHandler() {
        return netMsgHandler;
    }

    public static UserDataRepository createUserDataRepository(Context context) {
        return new UserDataRepository(context);
    }

    public UserDataRepository(Context context) {
        this.netMsgHandler = NetMsgHandler.getHandler(context);
        this.context= context;
    }

    public Observable<Boolean> checkIsSigned(String str) {
        return Observable.create(new checkIsSignSubscribe(this, str));
    }

    public Observable<Boolean> sendSmsCode(String str) {
        return Observable.create(new sendSmsSubcribe(this, str));
    }

    public Observable<User> register(RegisterInfo registerInfo) {
        return Observable.create(new RegisterInfoSubcribe(this, registerInfo));
    }


    public Observable<User> login(String account, String passwd) {
        return Observable.create(new LoginSubscribe(this, account, passwd));
    }

    public Observable<Boolean> logout() {
        return Observable.create(new LoginOutSubscribe(this));
    }

    public Observable<UserTotalAsset> queryAsset(String userId) {
        return Observable.create(new queryAssetSubscribe(this, userId));
    }



}
