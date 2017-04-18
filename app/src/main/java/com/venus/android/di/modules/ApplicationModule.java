package com.venus.android.di.modules;

import android.app.Application;
import android.content.Context;

import com.venus.android.app.FortuneEnvironment;
import com.venus.android.data.repository.EnvironmentDataRepository;
import com.venus.android.data.repository.UserDataRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    Context provideContext() {
        return this.application;
    }

    @Singleton
    @Provides
    FortuneEnvironment provideFortuneEnvironment() {
        return new FortuneEnvironment(this.application);
    }

    @Singleton
    @Provides
    UserDataRepository provideUserDataReposiory() {
        return new UserDataRepository(this.application);
    }

    @Singleton
    @Provides
    EnvironmentDataRepository provideEnvironmentDataRepository(){
        return  new EnvironmentDataRepository(this.application);
    }

}
