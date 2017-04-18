package com.venus.android.ui.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.venus.android.R;
import com.venus.android.custom.AppBar;
import com.venus.android.di.components.EnvironmentComponent;
import com.venus.android.presenter.WelcomePresenter;
import com.venus.android.ui.BaseFragment;
import com.venus.android.view.WelcomeView;

import butterknife.ButterKnife;
import butterknife.InjectView;
/**
 * Created by lev on 5/29/16.
 */
public class WelcomeFragment extends BaseFragment<WelcomePresenter> implements WelcomeView {
    @InjectView(R.id.rl_start_page_layout)
    RelativeLayout rlStartPageLayout;
    @InjectView(R.id.sdv_start_image)
    SimpleDraweeView sdvStartImage;

    public void onInitAppBar(AppBar appBar) {
        super.onInitAppBar(appBar);
        appBar.setVisibility(View.GONE);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((EnvironmentComponent) getComponent(EnvironmentComponent.class)).inject(this);
        if (activity != null) {
            ((WelcomePresenter) this.presenter).setView(this);
            ((WelcomePresenter) this.presenter).setInteractionListener((InteractionListener) activity);
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_welcome, viewGroup, false);
        ButterKnife.inject((Object) this, inflate);
        return inflate;
    }



    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        ((WelcomePresenter) this.presenter).init();
    }

    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    public void showStartPage(String str) {
        this.rlStartPageLayout.setVisibility(View.VISIBLE);
//        this.rlRegisterGuide.setVisibility(View.INVISIBLE);
        this.sdvStartImage.setImageURI(Uri.parse(str));
    }

    public void showRegisterGuide() {
        this.rlStartPageLayout.setVisibility(View.INVISIBLE);
    }

    public void showDefaultStartPage() {
        this.rlStartPageLayout.setVisibility(View.VISIBLE);
//        this.rlRegisterGuide.setVisibility(View.INVISIBLE);
    }

}
