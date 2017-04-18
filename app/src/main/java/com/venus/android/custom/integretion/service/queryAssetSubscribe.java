package com.venus.android.custom.integretion.service;

import com.venus.android.data.entity.UserTotalAsset;
import com.venus.android.data.entity.wrapper.ResponseDataWrapper;
import com.venus.android.data.network.request.BaseForturnRequest;
import com.venus.android.data.repository.UserDataRepository;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by lev on 6/2/16.
 */
public class queryAssetSubscribe  implements Observable.OnSubscribe<UserTotalAsset> {
    final /* synthetic */ String userId;
    final /* synthetic */ UserDataRepository userDataRepository;

    public queryAssetSubscribe(UserDataRepository userDataRepository, String userId) {
        this.userDataRepository = userDataRepository;
        this.userId = userId;
    }

    public /* synthetic */ void call(Subscriber obj) {
        queryAsset(obj);
    }

    public void queryAsset(Subscriber<? super UserTotalAsset> subscriber) {
        ResponseDataWrapper<UserTotalAsset> regist =
                this.userDataRepository.getUserAccNetService()
                        .queryAsset(new BaseForturnRequest(this.userDataRepository.getContext()));
        this.userDataRepository.getNetMsgHandler().handleError((Subscriber) subscriber, regist);
        subscriber.onNext(regist.data);
        subscriber.onCompleted();
    }
}