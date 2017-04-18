package com.venus.android.custom.integretion.service;

import com.venus.android.data.entity.InitConfigEntity;
import com.venus.android.data.repository.EnvironmentDataRepository;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by lev on 5/30/16.
 */
public class AppInitSubscribe implements Observable.OnSubscribe<InitConfigEntity> {
    final EnvironmentDataRepository a;

    public AppInitSubscribe(EnvironmentDataRepository environmentDataRepository) {
        this.a = environmentDataRepository;
    }

    public void call(Subscriber obj) {
        a(obj);
    }

    public void a(Subscriber<? super InitConfigEntity> subscriber) {
//        String versionName = ApkUtil.getVersionName(this.a.d);
//        String deviceName = DeviceUtil.getDeviceName();
//        String str = "Android " + Build.VERSION.RELEASE;
//        ResponseDataWrapper appInit = this.a.b.appInit("merchant", versionName, deviceName, str);
//        this.a.c.handleError((Subscriber) subscriber, appInit);
//        subscriber.onNext(appInit.data);
        subscriber.onCompleted();
    }
}
