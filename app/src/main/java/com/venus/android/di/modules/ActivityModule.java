package com.venus.android.di.modules;

import android.app.Activity;

import com.venus.android.di.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @PerActivity
    @Provides
    Activity a() {
        return this.activity;
    }
}
