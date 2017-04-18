package com.venus.android.app;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.venus.android.data.common.ConstValue;
import com.venus.android.di.components.ApplicationComponent;
import com.venus.android.di.components.DaggerApplicationComponent;
import com.venus.android.di.modules.ApplicationModule;

import javax.inject.Inject;

/**
 * Created by lev on 5/29/16.
 */
public class FortuneApplication extends MultiDexApplication {
    private Context context;
    private FortuneApplication fortuneAppliction;
    @Inject
    FortuneEnvironment fortuneEnvironment;
    private ApplicationComponent applicationComponent;

    public void onCreate() {
        super.onCreate();
        initApp();
    }

    private void initApp() {
        ConstValue.DEBUG_MODE = true;
        InjectService();
        this.fortuneEnvironment.initInApplication();
        context = getApplicationContext();
        fortuneAppliction = this;
    }

    private void InjectService() {
        this.applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        this.applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
