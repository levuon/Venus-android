package com.venus.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.venus.android.di.HasComponent;
import com.venus.android.di.components.DaggerUserComponent;
import com.venus.android.di.components.UserComponent;
import com.venus.android.di.modules.ActivityModule;
import com.venus.android.di.modules.UserModule;
import com.venus.android.ui.BaseActivity;
import com.venus.android.ui.fragment.LoginFragment;
import com.venus.android.utils.AppManager;
import com.venus.android.view.LoginLogicView.InteractionListener;

/**
 * Created by lev on 5/30/16.
 */
public class LoginActivity extends BaseActivity implements HasComponent<UserComponent>, InteractionListener {

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasAppBar(false);
        initFragment(LoginFragment.createFragment());
    }

    public void goMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void goLoginActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }




    public void finishActivity() {
        finish();
    }

    public void finishApplication() {
        AppManager.finishAllActivity();
    }

    public UserComponent getComponent() {
        return DaggerUserComponent.builder().applicationComponent(getApplicationComponent()).activityModule(new ActivityModule(this)).userModule(new UserModule()).build();
    }
}
