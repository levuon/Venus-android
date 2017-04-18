package com.venus.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.venus.android.di.HasComponent;
import com.venus.android.di.components.DaggerUserComponent;
import com.venus.android.di.components.UserComponent;
import com.venus.android.di.modules.ActivityModule;
import com.venus.android.di.modules.UserModule;
import com.venus.android.ui.BaseActivity;
import com.venus.android.ui.Navigator;
import com.venus.android.ui.fragment.register.PhoneNumRegisterFragment;
import com.venus.android.ui.fragment.register.PhoneVerificationCodeFragment;

/**
 * Created by lev on 5/30/16.
 */
public class RegisterActivity extends BaseActivity implements HasComponent<UserComponent>, Navigator  {


    private PhoneVerificationCodeFragment phoneVerificationCodeFragment;


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasAppBar(true);
        initFragment(new PhoneNumRegisterFragment());
    }



    public void navigateToSmsCodeVerificationFragment() {
        this.phoneVerificationCodeFragment = new PhoneVerificationCodeFragment();
        changeFragment(this.phoneVerificationCodeFragment);
    }

    //已注册后 跳转到登页面
    public void navigateToLoginAgainFragment() {

    }


    public void navigateToLoginActivity() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    public void navigateToMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void finishCascadeChooseFragment() {
        getSupportFragmentManager().popBackStack();
//        if (this.r != null && this.r.isVisible()) {
//            this.r.onInitAppBar(getAppBar());
//        }
//        if (this.y != null && this.y.isVisible()) {
//            this.y.onInitAppBar(getAppBar());
//        }
    }
    public UserComponent getComponent() {
        return DaggerUserComponent.builder().applicationComponent(getApplicationComponent())
                .activityModule(new ActivityModule(this)).userModule(new UserModule()).build();
    }

}
