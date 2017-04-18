package com.venus.android.di.components;

import com.venus.android.di.PerActivity;
import com.venus.android.di.modules.ActivityModule;
import com.venus.android.di.modules.UserModule;
import com.venus.android.ui.fragment.LoginFragment;
import com.venus.android.ui.fragment.register.PhoneNumRegisterFragment;
import com.venus.android.ui.fragment.register.PhoneVerificationCodeFragment;

import dagger.Component;

@Component(dependencies = {ApplicationComponent.class}, modules = {ActivityModule.class, UserModule.class})
@PerActivity
public interface UserComponent {

    void inject(LoginFragment loginFragment);
//
//    void inject(MerchantQrcodeScanFragment merchantQrcodeScanFragment);
//
//    void inject(SettingFragment settingFragment);
//
//    void inject(ShopInfoUpdateFragment shopInfoUpdateFragment);
//
//    void inject(SignInfoFragment signInfoFragment);
//
//    void inject(MemberListFragment memberListFragment);
//
//    void inject(OutreachActivityCreateFragment outreachActivityCreateFragment);
//
//    void inject(OutreachActivityListFragment outreachActivityListFragment);
//
//    void inject(BankCardAddFragment bankCardAddFragment);
//
//    void inject(BranchBanksFragment branchBanksFragment);
//
//    void inject(HeadBanksFragment headBanksFragment);
//
//    void inject(PasswordFragment passwordFragment);
//
    void inject(PhoneNumRegisterFragment phoneNumRegisterFragment);

    void inject(PhoneVerificationCodeFragment phoneVerificationCodeFragment);

}
