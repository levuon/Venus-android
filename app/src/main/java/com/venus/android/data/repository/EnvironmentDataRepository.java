package com.venus.android.data.repository;

import android.content.Context;

import com.venus.android.custom.integretion.service.AppInitSubscribe;
import com.venus.android.data.entity.InitConfigEntity;

import rx.Observable;

public class EnvironmentDataRepository {
//    private EnvironmentService a = ((EnvironmentService) HRetrofitCreator.createQtServerInstance().getService(EnvironmentService.class));
//    private EnvironmentService b = ((EnvironmentService) HRetrofitCreator.createAppConfigInstance().getService(EnvironmentService.class));
    private NetMsgHandler netMsgHandler;
    private Context d;

    public static EnvironmentDataRepository createRepo(Context context) {
        return new EnvironmentDataRepository(context);
    }

    public EnvironmentDataRepository(Context context) {
        this.netMsgHandler = NetMsgHandler.getHandler(context);
        this.d = context;
    }

    public Observable<InitConfigEntity> appInit() {
        return Observable.create(new AppInitSubscribe(this));
    }
//
//    public Observable<Date> getNetworkTime() {
//        return Observable.create(new bly(this));
//    }
//
//    public Observable<TimeEntity> getCurrentServerTime() {
//        return Observable.create(new blz(this));
//    }

}
