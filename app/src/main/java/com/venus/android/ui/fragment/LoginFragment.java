package com.venus.android.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.venus.android.R;
import com.venus.android.custom.AdjustSoftInputLinearLayout;
import com.venus.android.custom.AppBar;
import com.venus.android.custom.Runnable.loginFragmentRunnable;
import com.venus.android.custom.listener.loginNameChg;
import com.venus.android.custom.listener.loginNameTouch;
import com.venus.android.custom.listener.loginPasswdTouch;
import com.venus.android.di.components.UserComponent;
import com.venus.android.presenter.LoginPresenter;
import com.venus.android.ui.BaseFragment;
import com.venus.android.ui.activity.MainActivity;
import com.venus.android.ui.activity.RegisterActivity;
import com.venus.android.view.LoginLogicView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class LoginFragment extends BaseFragment<LoginPresenter> implements AdjustSoftInputLinearLayout.KeyBoardStateListener, LoginLogicView {

    @InjectView(R.id.scrollView)
    public ScrollView scrollView;
    @InjectView(R.id.et_login_pwd)
    public EditText tvPassWord;
    @InjectView(R.id.et_login_account)
    EditText tvUserName;


    @InjectView(R.id.iv_delete_account)
    ImageView ivDeleteAccount;

    @InjectView(R.id.iv_delete_login_passwd)
    ImageView ivDeleteLoginPasswd;

    @InjectView(R.id.iv_see_login_passwd)
    ImageView ivSeeLoginPasswd;


    Boolean passwd = false;

    @InjectView(R.id.btn_enter)
    Button btnEnter;

    @InjectView(R.id.tv_register)
    TextView tvRegister;
    @InjectView(R.id.tv_forget_pwd)
    View tvForgetPwd;






    public static LoginFragment createFragment() {
        return new LoginFragment();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((UserComponent) getComponent(UserComponent.class)).inject(this);
        if (activity != null) {
            ((LoginPresenter) this.presenter).setView(this);
            ((LoginPresenter) this.presenter).setInteractionListener((InteractionListener) activity);
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_login, null);
        ButterKnife.inject((Object) this, inflate);
        this.tvUserName.addTextChangedListener(new loginNameChg(this));
        this.tvUserName.setOnTouchListener(new loginNameTouch(this));
        this.tvPassWord.setOnTouchListener(new loginPasswdTouch(this));
        return inflate;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        ((LoginPresenter) this.presenter).init();
    }

    public void onInitAppBar(AppBar appBar) {
        super.onInitAppBar(appBar);
        setHasAppBar(false);
//        appBar.setTitle(getActivity().getString(R.string.hint_register_phone_num));
    }

    public void delayShow() {
        new Handler().postDelayed(new loginFragmentRunnable(this), 100);
    }

    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    public void bindClientId(String str) {
//        if (!TextUtils.isEmpty(str)) {
//            this.a.bindPushClientId(str);
//        }
    }

    public void renderLasLoginUserInfo(String str, String str2, boolean z) {
//        this.tvUserName.setText(str);
//        this.tvPassWord.setText(str2);
//        if (z) {
//            this.cbRemenberPasswd.setChecked(true);
//        } else {
//            this.cbRemenberPasswd.setChecked(false);
//        }
    }

    public void setUsernameError() {
        hideLoading();
        this.tvUserName.requestFocus();
        this.tvUserName.setError(getString(R.string.username_error));
        this.tvPassWord.setError(null);
        this.btnEnter.setEnabled(true);
    }

    public void setPasswordError() {
        hideLoading();
        this.tvPassWord.requestFocus();
        this.tvPassWord.setError(getString(R.string.password_error));
        this.tvUserName.setError(null);
        this.btnEnter.setEnabled(true);
    }

    public void onSuccess() {
        this.btnEnter.setEnabled(true);
    }

    public void onFailed(String str) {
        this.btnEnter.setEnabled(true);
        hideLoading();
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.text_login_fail);
        }
//        showToast(str);
    }

    public void showForgetPwd() {
//        this.vForgetPwd.setVisibility(0);
        onFailed("账号或密码错误");
    }

    @OnClick({R.id.tv_forget_pwd})
    public void clickForgetPwd() {
//        startActivity(WebActivity.getIntent(getContext(), URL.FORGET_PASSWORD, "", true));
    }

    public boolean onFragmentBackPressed() {
        ((LoginPresenter) this.presenter).handleBack();
        return true;
    }

    public void stateChange(int i) {
//        Timber.i("state---" + i, new Object[0]);
//        if (i == 0) {
//            this.ivLoginHeadBear.setVisibility(View.VISIBLE);
//        } else if (i == 1) {
//            this.ivLoginHeadBear.setVisibility(View.INVISIBLE);
//        }
    }


    @OnClick({R.id.tv_register})
    public void onRegisterClick() {
        startActivity(new Intent(getActivity(), RegisterActivity.class));
    }

    @OnClick({R.id.btn_enter})
    public void onClickLogin() {
        ((LoginPresenter) this.presenter).login(this.tvUserName.getText().toString(), this.tvPassWord.getText().toString(), false);
    }


    @OnClick({R.id.ll_delect})
    public void onClickDelect() {
//        ((LoginPresenter) this.presenter).login(this.tvUserName.getText().toString(), this.tvPassWord.getText().toString(), this.cbRemenberPasswd.isChecked());
        startActivity(new Intent(getActivity(), MainActivity.class));
    }




    @OnTextChanged({R.id.et_login_account})
    public void onLoginAccountChg() {
        this.ivDeleteAccount.setVisibility(View.VISIBLE);
        this.ivDeleteLoginPasswd.setVisibility(View.INVISIBLE);
        if(!this.presenter.checkParam(this.tvPassWord.getText().toString(), this.tvUserName.getText().toString())) {
            btnEnter
                    .setBackgroundResource(R.drawable.btn_radius);
            btnEnter.setClickable(true);
            btnEnter.setEnabled(true);
        }else {
            btnEnter
                    .setBackgroundResource(R.drawable.btn_radius_grey);
            btnEnter.setClickable(false);
            btnEnter.setEnabled(false);
        }
    }
    @OnTextChanged({R.id.et_login_pwd})
    public void onPasswdChg() {
        this.ivDeleteLoginPasswd.setVisibility(View.VISIBLE);
        this.ivDeleteAccount.setVisibility(View.INVISIBLE);
        if(!this.presenter.checkParam(this.tvPassWord.getText().toString(), this.tvUserName.getText().toString())) {
            btnEnter
                    .setBackgroundResource(R.drawable.btn_radius);
            btnEnter.setClickable(true);
            btnEnter.setEnabled(true);
        }else {
            btnEnter
                    .setBackgroundResource(R.drawable.btn_radius_grey);
            btnEnter.setClickable(false);
            btnEnter.setEnabled(false);
        }
    }


    @OnClick({R.id.iv_delete_account})
    public void deleteConfirmPwd() {
        if (this.tvUserName != null) {
            this.tvUserName.setText("");
        }
    }
    @OnClick({R.id.iv_delete_login_passwd})
    public void delPasswd() {
        if (this.tvPassWord != null) {
            this.tvPassWord.setText("");
        }
    }
    @OnClick({R.id.iv_see_login_passwd})
    public void seeConfirmPwd() {
        if(!passwd) {
            passwd = true;
            tvPassWord.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.ivSeeLoginPasswd.setBackgroundResource(R.drawable.btn_uninvisibility);
        }else {
            passwd = false;
            tvPassWord.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.ivSeeLoginPasswd.setBackgroundResource(R.drawable.btn_invisibility);
        }
        tvPassWord.setSelection(tvPassWord.getText().toString().length());
        this.ivDeleteLoginPasswd.setVisibility(View.GONE);
    }
}
