package com.venus.android.data.network;

import android.content.Context;

import com.squareup.okhttp.OkHttpClient;
import com.venus.android.custom.Factory.LogPrint;
import com.venus.android.data.common.ConstValue;

import retrofit.ErrorHandler;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RestAdapter.Builder;
import retrofit.RestAdapter.LogLevel;
import retrofit.client.OkClient;


public class HRetrofitCreator {
    private static Context context;
    private RestAdapter restAdapter;
    public static void init(Context contextArg) {
        context = contextArg;
    }


    public static HRetrofitCreator createAppInitInstance() {
        return new HRetrofitCreator("http://172.16.60.106:18080", new HErrorHandler());
    }
    public static HRetrofitCreator createQueryBannerInstance() {
        return new HRetrofitCreator("http://58.247.5.180/lcmgr/", new HErrorHandler());
    }

    private HRetrofitCreator(String str, ErrorHandler errorHandler) {
        if (context == null) {
            throw new RuntimeException("please call init method in application onCreate method when application create");
        }
        RequestInterceptor instance = RetrofitRequestInterceptor.getInstance(context);
        LogLevel logLevel = LogLevel.FULL;
        OkHttpClient okHttpSingleInstance = OkHttpCreator.getOkHttpSingleInstance();
        RestAdapter.Log a = LogPrint.printLog();
        if (!ConstValue.DEBUG_MODE) {
//            instance.setIsDebug(true);
            this.restAdapter = new Builder().setEndpoint(str)
                    .setRequestInterceptor(instance)
                    .setErrorHandler(errorHandler)
                    .setClient(new OkClient(okHttpSingleInstance)).setLogLevel(logLevel).setLog(a).build();
            return;
        }
        this.restAdapter = new Builder().setEndpoint(str)
                .setRequestInterceptor(instance)
                .setErrorHandler(errorHandler)
                .setClient(new OkClient(okHttpSingleInstance))
                .setLogLevel(LogLevel.NONE).build();
    }

    public <T> T getService(Class<T> cls) {
        return this.restAdapter.create(cls);
    }
}
