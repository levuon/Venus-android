package com.venus.android.custom.integretion.service;

import com.venus.android.data.entity.UserInfoEntity;
import com.venus.android.data.repository.UserDataRepository;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by lev on 6/8/16.
 * 查询用户信息: 登录名, 银行卡, 微信code 证件号...
 */
public class queryUserInfoSubscribe implements Observable.OnSubscribe<UserInfoEntity> {

    final  String userId;
    final /* synthetic */ UserDataRepository userDataRepository;

    public queryUserInfoSubscribe(UserDataRepository userDataRepository, String str) {
        this.userDataRepository = userDataRepository;
        this.userId = str;
    }

    @Override
    public void call(Subscriber obj) {
        getUserInfo(obj);
    }

    public void getUserInfo(Subscriber<? super UserInfoEntity> subscriber) {


    }
}