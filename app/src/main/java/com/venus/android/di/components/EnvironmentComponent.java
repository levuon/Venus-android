package com.venus.android.di.components;

import com.venus.android.di.PerActivity;
import com.venus.android.di.modules.ActivityModule;
import com.venus.android.di.modules.EnvironmentModule;
import com.venus.android.ui.fragment.WelcomeFragment;

import dagger.Component;


@Component(dependencies = {ApplicationComponent.class}, modules = {ActivityModule.class, EnvironmentModule.class})
@PerActivity
public interface EnvironmentComponent {
    void inject(WelcomeFragment welcomeFragment);
}
