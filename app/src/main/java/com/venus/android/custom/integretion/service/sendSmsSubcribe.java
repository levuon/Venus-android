package com.venus.android.custom.integretion.service;

import com.venus.android.data.entity.wrapper.ResponseDataWrapper;
import com.venus.android.data.network.request.SendSmsCodeRequest;
import com.venus.android.data.repository.UserDataRepository;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by lev on 5/31/16.
 */
public class sendSmsSubcribe implements Observable.OnSubscribe<Boolean> {
    final /* synthetic */ String phoneNum;
    final /* synthetic */ UserDataRepository userDataRepository;

    public sendSmsSubcribe(UserDataRepository userDataRepository, String str) {
        this.userDataRepository = userDataRepository;
        this.phoneNum = str;
    }

    public /* synthetic */ void call(Subscriber obj) {
        a(obj);
    }

    public void a(Subscriber<? super Boolean> subscriber) {
        ResponseDataWrapper sendSmsCode = this.userDataRepository
                .getUserAccNetService()
                .sendSmsCode(new SendSmsCodeRequest(userDataRepository.getContext(), "10000002", this.phoneNum));
        this.userDataRepository.getNetMsgHandler().handleError((Subscriber) subscriber, sendSmsCode);
        if (sendSmsCode.isSuccess()) {
            subscriber.onNext(Boolean.TRUE);
        } else {
            subscriber.onNext(Boolean.FALSE);
        }
        subscriber.onCompleted();
    }
}
