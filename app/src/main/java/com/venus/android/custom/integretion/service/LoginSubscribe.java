package com.venus.android.custom.integretion.service;

import com.venus.android.data.entity.User;
import com.venus.android.data.entity.UserEntity;
import com.venus.android.data.entity.wrapper.ResponseDataWrapper;
import com.venus.android.data.network.request.LoginRequest;
import com.venus.android.data.repository.UserDataRepository;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by lev on 6/1/16.
 */
public class LoginSubscribe implements Observable.OnSubscribe<User> {

    final /* synthetic */ String account;
    final /* synthetic */ String passwd;
    final /* synthetic */ UserDataRepository userDataRepository;

    public LoginSubscribe(UserDataRepository userDataRepository, String str, String str2) {
        this.userDataRepository = userDataRepository;
        this.account = str;
        this.passwd = str2;
    }
    @Override
    public void call(Subscriber obj) {
        login(obj);
    }

    public void login(Subscriber<? super User> subscriber) {

//
//        try{
//
//        }catch(Exception) {
//
//        }

        ResponseDataWrapper<UserEntity> registerCheck = this.userDataRepository.getUserAccNetService()
                .login(new LoginRequest(this.userDataRepository.getContext(), this.account, this.passwd));
        this.userDataRepository.getNetMsgHandler().handleError((Subscriber) subscriber, registerCheck);
        if(registerCheck.isSuccess()) {
            registerCheck.data.getUser().setSessionId(registerCheck.data.getSessionId());
            subscriber.onNext(registerCheck.data.getUser());
        }
        subscriber.onCompleted();
    }
}
