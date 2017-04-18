package com.venus.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.venus.android.di.HasComponent;
import com.venus.android.di.components.DaggerEnvironmentComponent;
import com.venus.android.di.components.EnvironmentComponent;
import com.venus.android.di.modules.ActivityModule;
import com.venus.android.di.modules.EnvironmentModule;
import com.venus.android.ui.BaseActivity;
import com.venus.android.ui.fragment.WelcomeFragment;
import com.venus.android.view.WelcomeView.InteractionListener;

/**
 * Created by lev on 5/29/16.
 */
public class WelcomeActivity  extends BaseActivity  implements HasComponent<EnvironmentComponent>, InteractionListener {

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasAppBar(false);
        getWindow().setFlags(1024, 1024);
//        setContentView(R.layout.activity_welcome);
        initFragment(new WelcomeFragment());
    }

    public void goMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void goGuideActivity() {
//        startActivity(new Intent(this, GuideActivity.class));
        finish();
    }

    public EnvironmentComponent getComponent() {
        return DaggerEnvironmentComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .environmentModule(new EnvironmentModule())
                .build();
    }
}
