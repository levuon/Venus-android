package com.venus.android.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.venus.android.R;
import com.venus.android.data.cache.UserCache;
import com.venus.android.data.entity.BaseInfo;
import com.venus.android.di.HasComponent;
import com.venus.android.di.components.DaggerMainComponent;
import com.venus.android.di.components.MainComponent;
import com.venus.android.di.modules.MainModule;
import com.venus.android.ui.BaseActivity;
import com.venus.android.ui.fragment.HomeFragment;
import com.venus.android.ui.fragment.NoAssetsFragment;
import com.venus.android.ui.fragment.SettingFragment;
import com.venus.android.view.HomeView;
import com.venus.android.view.NoAssetsView;
import com.venus.android.view.SettingView;

import java.lang.ref.SoftReference;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by lev on 5/29/16.
 */
//4个tab页 有需要添加事件的 可以去实现 tabView 里面的接口
public class MainActivity extends BaseActivity implements HasComponent<MainComponent>, HomeView.InteractionListener, SettingView.InteractionListener, NoAssetsView.InteractionListener{
    //底部tab 图片的点击
    @InjectView(R.id.iv_bottom_home)
    ImageView ivBottomHome;
    @InjectView(R.id.iv_bottom_demand)
    ImageView ivBottomDemand;
    @InjectView(R.id.iv_bottom_account)
    ImageView ivBottomAccount;
    @InjectView(R.id.iv_bottom_more)
    ImageView ivBottomMore;

    @InjectView(R.id.tv_bottom_home)
    TextView tvBottomHome;
    @InjectView(R.id.tv_bottom_account)
    TextView tvBottomAccount;
    @InjectView(R.id.tv_bottom_demand)
    TextView tvBottomDemand;
    @InjectView(R.id.tv_bottom_more)
    TextView tvBottomMore;

    @InjectView(R.id.rl_main_container)
    FrameLayout rlMainContainer;
    private SoftReference<Fragment> homeFragmentCache;
    private SoftReference<Fragment> demandFragmentCache;
    private SoftReference<Fragment> accountFragmentCache;
    private SoftReference<Fragment> settingFragmentCache;
    private SoftReference<Fragment> noAssetFragmentCache;

    private Fragment fragment;


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getComponent().inject(this);
        setHasAppBar(false);
        setContentView(R.layout.activity_main);
        ButterKnife.inject( this);
        onChange(1);

        //方法navigateToMainActivity  里有使用
//        if (getIntent() == null || getIntent().getIntExtra("tab", 1) != 2) {
//            onChange(1);
//        } else {
//            onChange(3);
//        }
    }

    @OnClick({R.id.ll_tab_home})
    public void onTabHomeClicked() {
        onChange(1);
    }
    @OnClick({R.id.ll_tab_demand})
    public void onTabDemandClicked() {
        onChange(2);
    }
    @OnClick({R.id.ll_tab_account})
    public void onTabAccountClicked() {
        onChange(3);
    }
    @OnClick({R.id.ll_tab_more})
    public void onTabMoreClicked() {
        onChange(4);
    }

    private void onChange(int i) {
        switch (i) {
            case 1:
                this.tvBottomHome.setEnabled(true);
                this.ivBottomHome.setEnabled(true);
                this.tvBottomDemand.setEnabled(false);
                this.ivBottomDemand.setEnabled(false);
                this.tvBottomAccount.setEnabled(false);
                this.ivBottomAccount.setEnabled(false);
                this.tvBottomMore.setEnabled(false);
                this.ivBottomMore.setEnabled(false);
                goHomeFragment();
                return;
            case 2:
                this.tvBottomHome.setEnabled(false);
                this.ivBottomHome.setEnabled(false);
                this.tvBottomDemand.setEnabled(true);
                this.ivBottomDemand.setEnabled(true);
                this.tvBottomAccount.setEnabled(false);
                this.ivBottomAccount.setEnabled(false);
                this.tvBottomMore.setEnabled(false);
                this.ivBottomMore.setEnabled(false);
                goDemandFragment();
                return;
            case 3:
                this.tvBottomHome.setEnabled(false);
                this.ivBottomHome.setEnabled(false);
                this.tvBottomDemand.setEnabled(false);
                this.ivBottomDemand.setEnabled(false);
                this.tvBottomAccount.setEnabled(true);
                this.ivBottomAccount.setEnabled(true);
                this.tvBottomMore.setEnabled(false);
                this.ivBottomMore.setEnabled(false);
                goNoAssetOrAccount();
                return;
            case 4:
                this.tvBottomHome.setEnabled(false);
                this.ivBottomHome.setEnabled(false);
                this.tvBottomDemand.setEnabled(false);
                this.ivBottomDemand.setEnabled(false);
                this.tvBottomAccount.setEnabled(false);
                this.ivBottomAccount.setEnabled(false);
                this.tvBottomMore.setEnabled(true);
                this.ivBottomMore.setEnabled(true);
                goSettingFragment();
            default:
                return;
        }
    }

    //首页
    private void goHomeFragment() {
        if (this.homeFragmentCache == null || this.homeFragmentCache.get() == null) {
            this.homeFragmentCache = new SoftReference(new HomeFragment());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.palette_orange));
        }
        Fragment fragment = this.homeFragmentCache.get();
        if (fragment != null) {
            replaceFragment(fragment);
        }
    }
    //基金页
    private void goDemandFragment() {
        if (this.demandFragmentCache == null || this.demandFragmentCache.get() == null) {
            this.demandFragmentCache = new SoftReference(new HomeFragment());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.palette_orange));
        }
        Fragment fragment = this.demandFragmentCache.get();
        if (fragment != null) {
            replaceFragment(fragment);
        }
    }

    private void goNoAssetOrAccount(){
        UserCache user = UserCache.getInstance(this.getContext());
        if(null != user && user.hasLogin()){
            if(BaseInfo.getInstance().isAsset) {
                goAccountFragment();
            }else {
                goNoAssetFragment();
            }
        }else {
            goToLoginActivity();
        }
    }

    private void goNoAssetFragment(){
        if (this.noAssetFragmentCache == null || this.noAssetFragmentCache.get() == null) {
            this.noAssetFragmentCache = new SoftReference(new NoAssetsFragment());
        }
        if (Build.VERSION.SDK_INT >= 21) {
//            getWindow().setStatusBarColor(getResources().getColor(R.color.home_head_background_color));
        }
        Fragment fragment =  this.noAssetFragmentCache.get();
        if (fragment != null) {
            replaceFragment(fragment);
        }
    }
    private void goAccountFragment(){
//        if (this.accountFragmentCache == null || this.accountFragmentCache.get() == null) {
////            this.accountFragmentCache = new SoftReference(new NoAssetsFragment());
//        }
//        if (Build.VERSION.SDK_INT >= 21) {
////            getWindow().setStatusBarColor(getResources().getColor(R.color.home_head_background_color));
//        }
//        Fragment fragment =  this.noAssetFragmentCache.get();
//        if (fragment != null) {
//            replaceFragment(fragment);
//        }
    }

    private void goSettingFragment() {
        UserCache user = UserCache.getInstance(this.getContext());
        if(null != user && user.hasLogin()){
            if (this.settingFragmentCache == null || this.settingFragmentCache.get() == null) {
                this.settingFragmentCache = new SoftReference(new SettingFragment());
            }
            if (Build.VERSION.SDK_INT >= 21) {
//            getWindow().setStatusBarColor(getResources().getColor(R.color.palette_orange));
            }
            Fragment fragment = this.settingFragmentCache.get();
            if (fragment != null) {
                replaceFragment(fragment);
            }
        }else {
            goToLoginActivity();
        }

    }
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (!(this.fragment == null || this.fragment == fragment)) {
            beginTransaction.hide(this.fragment);
        }
        if (this.fragment != fragment) {
            this.fragment = fragment;
            if (fragment.isAdded()) {
                beginTransaction.show(fragment);
            } else {
                beginTransaction.add((int) R.id.rl_main_container, fragment);
            }
            beginTransaction.commitAllowingStateLoss();
        }
    }



    @Override
    public void goToLoginActivity() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
    public MainComponent getComponent() {
        return DaggerMainComponent.builder().activityModule(getActivityModule()).applicationComponent(getApplicationComponent()).mainModule(new MainModule()).build();
    }

}
