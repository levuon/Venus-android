package com.venus.android.di.components;

import android.content.Context;

import com.venus.android.app.FortuneApplication;
import com.venus.android.app.FortuneEnvironment;
import com.venus.android.data.repository.EnvironmentDataRepository;
import com.venus.android.data.repository.UserDataRepository;
import com.venus.android.di.modules.ApplicationModule;
import com.venus.android.ui.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    Context context();

    void inject(FortuneApplication fortuneApplication);

    void inject(BaseActivity baseActivity);

    UserDataRepository userDataRepository();

    FortuneEnvironment fortuneEnvironment();

    EnvironmentDataRepository environmentDataRepository();


}
