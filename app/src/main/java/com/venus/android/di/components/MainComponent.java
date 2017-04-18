package com.venus.android.di.components;

import com.venus.android.di.PerActivity;
import com.venus.android.di.modules.ActivityModule;
import com.venus.android.di.modules.MainModule;
import com.venus.android.ui.activity.MainActivity;
import com.venus.android.ui.fragment.HomeFragment;
import com.venus.android.ui.fragment.NoAssetsFragment;
import com.venus.android.ui.fragment.SettingFragment;

import dagger.Component;

@Component(dependencies = {ApplicationComponent.class}, modules = {ActivityModule.class, MainModule.class})
@PerActivity
public interface MainComponent {
    void inject(MainActivity mainActivity);


    //首页
    void inject(HomeFragment homeFragment);

    //精选基金
//    void inject(ContactUsFragment contactUsFragment);


    //我的资产--无资产
    void inject(NoAssetsFragment noAssetsFragment);

    //我的资产
//    void inject(MeFragment meFragment);

    //账户设置
    void inject(SettingFragment settingFragment);
}
