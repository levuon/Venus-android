package com.venus.android.custom.integretion.service;

import com.venus.android.data.entity.BaseInfo;
import com.venus.android.data.entity.resgister.IsSignedEntity;
import com.venus.android.data.entity.wrapper.ResponseDataWrapper;
import com.venus.android.data.network.request.RegisterCheckRequest;
import com.venus.android.data.repository.UserDataRepository;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by lev on 5/29/16.
 */
public class checkIsSignSubscribe implements Observable.OnSubscribe<Boolean> {
    final /* synthetic */ String account;
    final /* synthetic */ UserDataRepository userDataRepository;

    public checkIsSignSubscribe(UserDataRepository userDataRepository, String str) {
        this.userDataRepository = userDataRepository;
        this.account = str;
    }

    public  void call(Subscriber obj) {
        checkIsSigned(obj);
    }

    public void checkIsSigned(Subscriber<? super Boolean> subscriber) {

        ResponseDataWrapper<IsSignedEntity> registerCheck = this.userDataRepository.getUserAccNetService()
                .checkIsSigned(new RegisterCheckRequest(this.userDataRepository.getContext(), this.account));
        this.userDataRepository.getNetMsgHandler().handleError((Subscriber) subscriber, registerCheck);
        if(registerCheck.isSuccess()) {
            BaseInfo.getInstance().setIsRealName(registerCheck.data.isRealName());
            BaseInfo.getInstance().setIsBindCard(registerCheck.data.isBindCard());
            BaseInfo.getInstance().setIsHasDeviceId(registerCheck.data.isHasDeviceId());
            if (registerCheck.data.isRegister()) {
                subscriber.onNext(Boolean.TRUE);
            }else {
                subscriber.onNext(Boolean.FALSE);
            }
        }else {
            subscriber.onNext(Boolean.FALSE);
        }
        subscriber.onCompleted();
    }
}
