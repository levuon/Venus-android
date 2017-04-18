package com.venus.android.ui.fragment.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.venus.android.R;
import com.venus.android.custom.AppBar;
import com.venus.android.custom.listener.PhoneRegisterLeftClick;
import com.venus.android.data.entity.RegisterInfo;
import com.venus.android.di.components.UserComponent;
import com.venus.android.presenter.register.PhoneVerificationCodePresenter;
import com.venus.android.ui.BaseFragment;
import com.venus.android.ui.Navigator;
import com.venus.android.ui.activity.LoginActivity;
import com.venus.android.ui.activity.MainActivity;
import com.venus.android.view.register.PhoneVerificationCodeView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import butterknife.OnTextChanged;

/**
 * Created by lev on 5/31/16.
 */
public class PhoneVerificationCodeFragment extends BaseFragment<PhoneVerificationCodePresenter> implements PhoneVerificationCodeView {
    private Navigator navigator;
    @InjectView(R.id.tv_phonenum)
    TextView tvPhoneNum;
    @InjectView(R.id.et_sms_code)
    EditText etSmsCode;
    @InjectView(R.id.et_login_pwd)
    EditText etLoginPwd;
    @InjectView(R.id.et_confirm_login_pwd)
    EditText etConfirmLoginPwd;
    @InjectView(R.id.tv_count_down)
    TextView tvCountDown;
    @InjectView(R.id.iv_delete_sms_code)
    ImageView ivDeleteSmsCode;
    @InjectView(R.id.iv_delete_passwd)
    ImageView ivDeletePwd;
    @InjectView(R.id.iv_delete_confirm_passwd)
    ImageView ivDeleteConfirmPwd;
    @InjectView(R.id.iv_see_passwd)
    ImageView ivSeePasswd;
    @InjectView(R.id.iv_see_confirm_pwd)
    ImageView ivSeeConfirmPasswd;
    @InjectView(R.id.btn_register)
    Button btnRegister;

    Boolean checkBox = true;
    Boolean isPwd = false;
    Boolean isConfirmPwd = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_phone_register_code, null);
        ButterKnife.inject((Object) this, inflate);
        return inflate;
    }


    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((UserComponent) getComponent(UserComponent.class)).inject(this);
        ((PhoneVerificationCodePresenter) this.presenter).setView(this);
        if (activity != null) {
            this.navigator = (Navigator) activity;
        }
    }


    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        ((PhoneVerificationCodePresenter) this.presenter).create();
        if (!TextUtils.isEmpty(RegisterInfo.getInstance().getUsername())) {
            this.tvPhoneNum.setText(RegisterInfo.getInstance().getUsername());
        }
    }

    public void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
    }

    public void onInitAppBar(AppBar appBar) {
        super.onInitAppBar(appBar);
        appBar.setLeftNavigation((int) R.drawable.btn_back, new PhoneRegisterLeftClick(this));
        appBar.setTitle(getString(R.string.register));
        appBar.setShowRight(false);
    }

    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
        ((PhoneVerificationCodePresenter) this.presenter).destroy();
    }
    public void clearPassWordText() {
        this.etLoginPwd.setText("");
        this.etConfirmLoginPwd.setText("");
    }

    public void focusConfirmPasswordEdit() {
        this.etConfirmLoginPwd.requestFocus();
    }

    //
    @OnClick({R.id.iv_delete_sms_code})
    public void deleteSmsCode() {
        if (this.etSmsCode != null) {
            this.etSmsCode.setText("");
        }
    }
    @OnClick({R.id.iv_delete_passwd})
    public void deletePwd() {
        if (this.etLoginPwd != null) {
            this.etLoginPwd.setText("");
        }
    }
    @OnClick({R.id.iv_delete_confirm_passwd})
    public void deleteConfirmPwd() {
        if (this.etConfirmLoginPwd != null) {
            this.etConfirmLoginPwd.setText("");
        }
    }

    @OnClick({R.id.iv_see_passwd})
    public void seePwd() {
        if(!isPwd) {
            isPwd = true;
            etLoginPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.ivSeePasswd.setBackgroundResource(R.drawable.btn_uninvisibility);
        }else {
            isPwd = false;
            etLoginPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.ivSeePasswd.setBackgroundResource(R.drawable.btn_invisibility);
        }
        etLoginPwd.setSelection(etLoginPwd.getText().toString().length());
        this.ivDeletePwd.setVisibility(View.GONE);
        this.ivDeleteConfirmPwd.setVisibility(View.GONE);

    }

    @OnClick({R.id.iv_see_confirm_pwd})
    public void seeConfirmPwd() {
        if(!isConfirmPwd) {
            isConfirmPwd = true;
            etConfirmLoginPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.ivSeeConfirmPasswd.setBackgroundResource(R.drawable.btn_uninvisibility);
        }else {
            isConfirmPwd = false;
            etConfirmLoginPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.ivSeeConfirmPasswd.setBackgroundResource(R.drawable.btn_invisibility);
        }
        etConfirmLoginPwd.setSelection(etConfirmLoginPwd.getText().toString().length());
        this.ivDeletePwd.setVisibility(View.GONE);
        this.ivDeleteConfirmPwd.setVisibility(View.GONE);

    }

    @OnEditorAction({R.id.tv_login_pwd})
    public boolean onPasswordEditorAction() {
        if (this.etLoginPwd != null) {
            (this.presenter).validatePassword(this.etLoginPwd.getText().toString());
        }
        return true;
    }

//    @OnEditorAction({R.id.et_confirm_login_pwd})
//    public boolean onConfirmPassEditorAction() {
//        ( this.presenter).validate(this.etLoginPwd.getText().toString(), this.etConfirmLoginPwd.getText().toString());
//        return true;
//    }

    @OnCheckedChanged({R.id.checkBox1})
    public void checkChg(CompoundButton buttonView,
                         boolean isChecked) {
        if (isChecked) {
            checkBox = true;
            if (!this.presenter.checkParam(this.etSmsCode.getText().toString(), this.etLoginPwd.getText().toString(), this.etConfirmLoginPwd.getText().toString())) {
                btnRegister
                        .setBackgroundResource(R.drawable.btn_radius);
                btnRegister.setClickable(true);
                btnRegister.setEnabled(true);
            }
        } else {
            checkBox = false;
            btnRegister
                    .setBackgroundResource(R.drawable.btn_radius_grey);
            btnRegister.setClickable(false);
            btnRegister.setEnabled(false);
        }
    }

    @OnTextChanged({R.id.et_sms_code})
    public void onYzmChg() {
        this.ivDeleteSmsCode.setVisibility(View.VISIBLE);
        this.ivDeletePwd.setVisibility(View.INVISIBLE);
        this.ivDeleteConfirmPwd.setVisibility(View.INVISIBLE);
        if(checkBox && !this.presenter.checkParam(this.etSmsCode.getText().toString(), this.etLoginPwd.getText().toString(), this.etConfirmLoginPwd.getText().toString())) {
            btnRegister
                    .setBackgroundResource(R.drawable.btn_radius);
            btnRegister.setClickable(true);
            btnRegister.setEnabled(true);
        }else {
            btnRegister
                    .setBackgroundResource(R.drawable.btn_radius_grey);
            btnRegister.setClickable(false);
            btnRegister.setEnabled(false);
        }
    }

    @OnTextChanged({R.id.et_login_pwd})
    public void onLoginPwdChg(){
        this.ivDeleteSmsCode.setVisibility(View.INVISIBLE);
        this.ivDeletePwd.setVisibility(View.VISIBLE);
        this.ivDeleteConfirmPwd.setVisibility(View.INVISIBLE);
        if(checkBox && !this.presenter.checkParam(this.etSmsCode.getText().toString(), this.etLoginPwd.getText().toString(), this.etConfirmLoginPwd.getText().toString())) {
            btnRegister
                    .setBackgroundResource(R.drawable.btn_radius);
            btnRegister.setClickable(true);
            btnRegister.setEnabled(true);
        }else {
            btnRegister
                    .setBackgroundResource(R.drawable.btn_radius_grey);
            btnRegister.setClickable(false);
            btnRegister.setEnabled(false);
        }
    }
    @OnTextChanged({R.id.et_confirm_login_pwd})
    public void onConfirmLoginPwdChg(){
        this.ivDeleteSmsCode.setVisibility(View.INVISIBLE);
        this.ivDeletePwd.setVisibility(View.INVISIBLE);
        this.ivDeleteConfirmPwd.setVisibility(View.VISIBLE);
        if(checkBox && !this.presenter.checkParam(this.etSmsCode.getText().toString(), this.etLoginPwd.getText().toString(), this.etConfirmLoginPwd.getText().toString())) {
            btnRegister
                    .setBackgroundResource(R.drawable.btn_radius);
            btnRegister.setClickable(true);
            btnRegister.setEnabled(true);
        }else {
            btnRegister
                    .setBackgroundResource(R.drawable.btn_radius_grey);
            btnRegister.setClickable(false);
            btnRegister.setEnabled(false);
        }
    }

    @OnClick({R.id.tv_count_down})
    public void onCountDownClick() {
        ((PhoneVerificationCodePresenter) this.presenter).sendSmsCode();
        ((PhoneVerificationCodePresenter) this.presenter).startCountDown();
    }

    @OnClick({R.id.btn_register})
    public void onNextStepClick() {
        ((PhoneVerificationCodePresenter) this.presenter).validate(this.etSmsCode.getText().toString(), this.etLoginPwd.getText().toString(), this.etConfirmLoginPwd.getText().toString());
    }
    @Override
    public void onSetCodeToEdit(String str) {
        if (this.etSmsCode != null) {
            this.etSmsCode.setText(str);
        }
    }

    @Override
    public void onTvCountDownEnabled(boolean z) {
        if (z) {
            this.tvCountDown.setEnabled(true);
        } else {
            this.tvCountDown.setEnabled(false);
        }
    }

    @Override
    public void goLoginActivity() {
        startActivity(new Intent(getActivity(), LoginActivity.class));
        getActivity().finish();
    }

    @Override
    public void navigateToMainActivity(){
//        if("Asset".equals(str)) {
//            Intent intent = new Intent();
//            intent.setComponent(new ComponentName(this.getContext(), MainActivity.class));
//            intent.putExtra("tab", 3);
//            startActivity(intent);
//        } else {
            startActivity(new Intent(getActivity(), MainActivity.class));
            getActivity().finish();
//        }
    }

    @Override
    public void setCountDownText(String str) {
        this.tvCountDown.setText(str);
    }
}
