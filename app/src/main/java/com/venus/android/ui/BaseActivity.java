package com.venus.android.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.venus.android.R;
import com.venus.android.app.FortuneApplication;
import com.venus.android.custom.AppBar;
import com.venus.android.custom.Dialog.DialogFactory;
import com.venus.android.data.cache.UserCache;
import com.venus.android.data.common.ConstValue;
import com.venus.android.di.components.ApplicationComponent;
import com.venus.android.di.modules.ActivityModule;
import com.venus.android.utils.AppManager;
import com.venus.android.utils.SPUtil;
import com.venus.android.utils.ScreenUtil;
import com.venus.android.utils.SnackBarUtils;
import com.venus.android.utils.Toaster;
import com.venus.android.view.BaseLogicView;
import com.venus.android.view.Interaction;

import net.steamcrafted.loadtoast.LoadToast;

import butterknife.InjectView;
import butterknife.Optional;

/**
 * Created by lev on 5/29/16.
 */
public class BaseActivity extends AppCompatActivity implements BaseFragment.BackHandlerInterface, BaseLogicView, Interaction {
    public LoadToast loadToast;
    @InjectView(R.id.common_v_error)
    @Optional
    View mErrorPage;
    RelativeLayout relativeLayout;
    AppBar appBar;
    FrameLayout frameLayout;
    protected String password = "";
    private View view;
    private FragmentManager fragmentManager;
    private BaseFragment baseFragment;
    public SPUtil spUtil;
    private Dialog dialog;
    protected String username = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.loadToast = new LoadToast(this);
        this.loadToast.setBackgroundColor(getResources().getColor(R.color.palette_white_transparent)).setProgressColor(getResources().getColor(R.color.palette_red)).setTextColor(getResources().getColor(R.color.palette_red));
        this.loadToast.setTranslationY(ScreenUtil.dip2px(getApplicationContext(), 50.0f));
        this.view = LayoutInflater.from(this).inflate(R.layout.activity_base_content, null);
        this.fragmentManager = getSupportFragmentManager();
        super.setContentView(this.view);
        this.frameLayout = (FrameLayout) findViewById(R.id.layout_content);
        this.appBar = (AppBar) findViewById(R.id.appbar);
        this.relativeLayout = (RelativeLayout) findViewById(R.id.layout_root);
        AppManager.getAppManager().addActivity(this);
        this.spUtil = SPUtil.getInstance(this);
        getApplicationComponent().inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return ((FortuneApplication) getApplication()).getApplicationComponent();
    }

    public ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    public void setSelectedFragment(BaseFragment baseFragment) {
        this.baseFragment = baseFragment;
    }

    public void changeFragment(Fragment fragment) {
        replaceInitFragment(fragment, false);
    }

    public void initFragment(Fragment fragment) {
        replaceInitFragment(fragment, true);
    }

    public void onBackPressed() {
        if (this.baseFragment == null || !this.baseFragment.onFragmentBackPressed()) {
            super.onBackPressed();
        }
    }


    /** fragment 操作 **/
    public void addFragment(Fragment fragment) {
        if (fragment.getArguments() == null) {
            fragment.setArguments(new Bundle());
        }
        FragmentTransaction beginTransaction = this.fragmentManager.beginTransaction();
        beginTransaction.add(R.id.layout_content, fragment, fragment.getClass().getName());
        beginTransaction.addToBackStack(null);
        beginTransaction.commitAllowingStateLoss();
    }

    public void addFragment(BaseFragment baseFragment) {
        if (baseFragment.getArguments() == null) {
            baseFragment.setArguments(new Bundle());
        }
        FragmentTransaction beginTransaction = this.fragmentManager.beginTransaction();
        beginTransaction.add(R.id.layout_content, baseFragment, baseFragment.getClass().getName());
        beginTransaction.addToBackStack(null);
        beginTransaction.commitAllowingStateLoss();
    }

    public void hideFragment(BaseFragment baseFragment) {
        FragmentTransaction beginTransaction = this.fragmentManager.beginTransaction();
        if (baseFragment != null && baseFragment.isAdded()) {
            beginTransaction.hide(baseFragment);
        }
        beginTransaction.commitAllowingStateLoss();
    }

    public void showFragment(BaseFragment baseFragment) {
        FragmentTransaction beginTransaction = this.fragmentManager.beginTransaction();
        if (baseFragment != null && baseFragment.isAdded()) {
            beginTransaction.show(baseFragment);
        }
        beginTransaction.commitAllowingStateLoss();
    }

    public void removeFragment(BaseFragment baseFragment) {
        FragmentTransaction beginTransaction = this.fragmentManager.beginTransaction();
        if (baseFragment != null && baseFragment.isAdded()) {
            beginTransaction.remove(baseFragment);
        }
        beginTransaction.commitAllowingStateLoss();
    }

    private void replaceInitFragment(Fragment fragment, boolean z) {
        if (fragment.getArguments() == null) {
            fragment.setArguments(new Bundle());
        }
        FragmentTransaction beginTransaction = this.fragmentManager.beginTransaction();
        beginTransaction.replace(R.id.layout_content, fragment, fragment.getClass().getName());
        if (!z) {
            beginTransaction.addToBackStack(null);
        }
        beginTransaction.commitAllowingStateLoss();
    }

    public void popFragment() {
        this.fragmentManager.popBackStack();
    }

    /**
     *  app Bar
     * @param
     */
    public void setHasAppBar(boolean z) {
        if (z) {
            this.appBar.setVisibility(View.VISIBLE);
        } else {
            this.appBar.setVisibility(View.INVISIBLE);
        }
    }

    public AppBar getAppBar() {
        return this.appBar;
    }



    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void setContentView(int i) {
        LayoutInflater.from(this).inflate(i, this.frameLayout);
        super.setContentView(this.view);
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public Resources getResources() {
        Resources resources = super.getResources();
        Configuration configuration = new Configuration();
        configuration.setToDefaults();
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return resources;
    }

    public void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().popActivity(this);

    }

    public void showNormalDialog(String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
//        CustomDialogBuilder.buildDoubleBtnDialog(this)
//                .setMsg(str2)
//                .setConfirmBtnText(getString(R.string.text_ok))
//                .setTouchOutsideCanDismiss(true)
//                .setOnConfrimClickListener(new ConfirmClickListener(this, onClickListener))
//                .setCancelBtnText(getString(R.string.text_cancel))
//                .setCancelClickListener(new CancelClickListener(this, onClickListener2))
//                .getDialog().show();
    }

    protected boolean hasLoginForm() {
        this.username = this.spUtil.getString(ConstValue.Sp.USERNAME, "");
        return UserCache.getInstance(this).hasLogin();
    }

//    public void showNoNetWorkDialog() {
////        new AlertDialog.Builder(this).setTitle((int) R.string.net_question_tip).setMessage((int) R.string.no_net_message).setNegativeButton(getString(R.string.i_know_it), null).create().show();
//    }


    /******** Implement interface BaseLogicView  START  ******/
    public Context getContext() {
        return this;
    }

    public void hideLoading() {
        if (this.dialog != null && this.dialog.isShowing()) {
            this.dialog.dismiss();
        }
    }
    public void showSoftKeyBoard() {
    }

    public void hideSoftKeyBoard() {
    }

    @Override
    public void loadToastFail() {
        if (this.loadToast != null) {
            this.loadToast.error();
        }
    }

    @Override
    public void loadToastSuccess() {
        if (this.loadToast != null) {
            this.loadToast.success();
        }
    }

    @Override
    public void showLoadToast(String str) {
        if (this.loadToast != null) {
            this.loadToast.setText(str);
            this.loadToast.show();
        }
    }

    public void setErrorPageVisible(boolean z) {
        if (this.mErrorPage == null) {
            return;
        }
        if (z) {
            this.mErrorPage.setVisibility(View.VISIBLE);
        } else {
            this.mErrorPage.setVisibility(View.INVISIBLE);
        }
    }

    public void showError(String str) {
        SnackBarUtils.showShortSnackBar(this.appBar, str);
    }

    public void showLoading() {
        this.dialog = DialogFactory.getLoadingDailogBuilder().setMsg("正在加载,请稍等...").setTouchOutDismss(false).build(getContext());
        this.dialog.show();
    }

    public void showLoading(String str) {
        if (this.dialog == null) {
            this.dialog = DialogFactory.getLoadingDailogBuilder().setMsg(str).build(getContext());
            this.dialog.show();
        }
    }

    @Override
    public void showToast(String str) {
        Toaster.shortShow(getContext(), str);
    }

    public void showFormFilterDialog(String str) {
    }


    /******** Implement interface BaseLogicView  END ******/




    public RelativeLayout getRlRoot() {
        return this.relativeLayout;
    }




    /*********  implements interface Interaction   begin ********/
    public void startFortuneActivity(Intent intent) {
        try {
            startActivity(intent);
        } catch (Throwable e) {
        }
    }

    public void finishActivity() {
        finish();
    }
    /*********  implements interface Interaction   end ********/
}
