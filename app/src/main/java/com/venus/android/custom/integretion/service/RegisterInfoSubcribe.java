package com.venus.android.custom.integretion.service;

import com.venus.android.data.entity.RegisterInfo;
import com.venus.android.data.entity.User;
import com.venus.android.data.entity.UserEntity;
import com.venus.android.data.entity.wrapper.ResponseDataWrapper;
import com.venus.android.data.network.request.RegisterInfoRequest;
import com.venus.android.data.repository.UserDataRepository;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by lev on 5/31/16.
 */
public class RegisterInfoSubcribe implements Observable.OnSubscribe<User> {
    final /* synthetic */ RegisterInfo registerInfo;
    final /* synthetic */ UserDataRepository userDataRepository;

    public RegisterInfoSubcribe(UserDataRepository userDataRepository, RegisterInfo registerInfo) {
        this.userDataRepository = userDataRepository;
        this.registerInfo = registerInfo;
    }

    public /* synthetic */ void call(Subscriber obj) {
        a(obj);
    }

    public void a(Subscriber<? super User> subscriber) {
        ResponseDataWrapper<UserEntity> regist =
                this.userDataRepository.getUserAccNetService()
                        .regist(new RegisterInfoRequest(this.userDataRepository.getContext(),
                                this.registerInfo.getUsername(),
                                this.registerInfo.getPassword(),
                                this.registerInfo.getSmsCheckCode()));
        this.userDataRepository.getNetMsgHandler().handleError((Subscriber) subscriber, regist);
        if(regist.isSuccess()) {
            regist.data.getUser().setSessionId(regist.data.getSessionId());
            subscriber.onNext(regist.data.getUser());
        }
        subscriber.onCompleted();
    }
}