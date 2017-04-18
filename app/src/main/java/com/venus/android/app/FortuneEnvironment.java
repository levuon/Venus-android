package com.venus.android.app;

import android.content.Context;

import com.crashlytics.android.Crashlytics;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.venus.android.data.common.ConstValue;
import com.venus.android.data.network.HRetrofitCreator;

import io.fabric.sdk.android.Fabric;
import timber.log.Timber;

/**
 * Created by lev on 5/29/16.
 */


public class FortuneEnvironment {
    private static Context context;
    public FortuneEnvironment(Context context) {
        this.context = context;
    }

    public void initInApplication() {
        Timber.i("init in application onCreate", new Object[0]);
        initConextArg(context);
    }

    public void initInFirstActivity() {
        Timber.i("初始化第一个Activity", new Object[0]);
        if (context == null) {
            throw new RuntimeException("you should call initInApplication() method in Application onCreate method");
        }
//        UmengUpdateAgent.setDefault();
//        if (ConstValue.DEBUG_MODE) {
//            MobclickAgent.setDebugMode(true);
//        }
    }

    public void clearAppInitResource() {
        Timber.i("clear app init resource", new Object[0]);
//        new InitServiceCache(a).clear();
    }


    private static void initConextArg(Context context) {
        //restful 初始化
        HRetrofitCreator.init(context);
        //图片加载 初始化
        Fresco.initialize(context);
        if (ConstValue.DEBUG_MODE) {
            Timber.plant(new Timber.DebugTree());
            return;
        }
        Fabric.with(context, new Crashlytics());
    }
}
