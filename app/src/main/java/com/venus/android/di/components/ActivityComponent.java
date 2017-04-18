package com.venus.android.di.components;

import android.app.Activity;

import com.venus.android.di.PerActivity;
import com.venus.android.di.modules.ActivityModule;

import dagger.Component;

@Component(dependencies = {ApplicationComponent.class}, modules = {ActivityModule.class})
@PerActivity
public interface ActivityComponent {
    Activity activity();
}
