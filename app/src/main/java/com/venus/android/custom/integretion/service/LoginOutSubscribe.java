package com.venus.android.custom.integretion.service;

import com.venus.android.data.entity.wrapper.ResponseDataWrapper;
import com.venus.android.data.network.request.BaseForturnRequest;
import com.venus.android.data.repository.UserDataRepository;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by lev on 6/2/16.
 */
public class LoginOutSubscribe implements Observable.OnSubscribe<Boolean> {

    final /* synthetic */ UserDataRepository userDataRepository;

    public LoginOutSubscribe(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }
    @Override
    public void call(Subscriber obj) {
        login(obj);
    }

    public void login(Subscriber<? super Boolean> subscriber) {

        ResponseDataWrapper loginOut = this.userDataRepository.getUserAccNetService()
                .loginOut(new BaseForturnRequest(this.userDataRepository.getContext()));
        this.userDataRepository.getNetMsgHandler().handleError((Subscriber) subscriber, loginOut);
        if (loginOut.isSuccess()) {
            subscriber.onNext(Boolean.TRUE);
        } else {
            subscriber.onNext(Boolean.FALSE);
        }
        subscriber.onCompleted();
    }
}
