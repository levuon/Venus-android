package com.venus.android.ui.fragment.register;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.venus.android.R;
import com.venus.android.custom.AppBar;
import com.venus.android.custom.Dialog.DialogFactory;
import com.venus.android.custom.listener.PhoneRegisterSmsSend;
import com.venus.android.custom.listener.RegisterPhoneBack;
import com.venus.android.data.entity.RegisterInfo;
import com.venus.android.di.components.UserComponent;
import com.venus.android.presenter.register.PhoneNumberRegisterPresenter;
import com.venus.android.ui.BaseFragment;
import com.venus.android.ui.Navigator;
import com.venus.android.view.register.PhoneNumberRegisterView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import butterknife.OnTextChanged;

/**
 * Created by lev on 5/30/16.
 */
public class PhoneNumRegisterFragment extends BaseFragment<PhoneNumberRegisterPresenter> implements PhoneNumberRegisterView {
    private Navigator navigator;


    @InjectView(R.id.btn_loginnext)
    Button btnLoginNext;
    @InjectView(R.id.ll_login_showphonenum)
    LinearLayout llLoginShowPhoneNum;
    @InjectView(R.id.tv_login_showphonenum)
    TextView tvLoginShowPhoneNum;
    @InjectView(R.id.iv_delete)
    ImageView ivDelete;
    @InjectView(R.id.et_phonenum)
    EditText etPhoneNum;


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }


    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_register_phone_num, viewGroup, false);
        ButterKnife.inject((Object) this, inflate);
        return inflate;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((UserComponent) getComponent(UserComponent.class)).inject(this);
        this.presenter.setView(this);
        ((PhoneNumberRegisterPresenter) this.presenter).setView(this);
        if (activity != null) {
            this.navigator = (Navigator) activity;
        }
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.etPhoneNum.setSelection(this.etPhoneNum.getText().toString().length());
        if (!TextUtils.isEmpty(RegisterInfo.getInstance().getUsername())) {
            this.etPhoneNum.setText(RegisterInfo.getInstance().getUsername());
        }
    }


    public void onInitAppBar(AppBar appBar) {
        super.onInitAppBar(appBar);
        appBar.setLeftNavigation( R.drawable.btn_back, new RegisterPhoneBack(this));
        appBar.setTitle(getActivity().getString(R.string.hint_register_phone_num));
    }

    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnFocusChange({R.id.et_phonenum})
    public void onPhoneNum(boolean z) {
        if (!z && this.etPhoneNum != null) {
            ((PhoneNumberRegisterPresenter) this.presenter).checkIsAlreadySigned(this.etPhoneNum.getText().toString());
        }
    }

    @OnClick(R.id.iv_delete)
    public void setPhoneNum() {
        etPhoneNum.setText("");
    }
    @OnClick({R.id.btn_loginnext})
    public void onNextStepClick() {
        ((PhoneNumberRegisterPresenter) this.presenter).validateForm(this.etPhoneNum.getText().toString());
    }


    @OnTextChanged({R.id.et_phonenum})
    public void onPhoneNum() {
        if (etPhoneNum.getText().toString().equals("")) {

            llLoginShowPhoneNum.setVisibility(View.GONE);
            ivDelete.setVisibility(View.GONE);
        } else {
            llLoginShowPhoneNum.setVisibility(View.VISIBLE);
            ivDelete.setVisibility(View.VISIBLE);
        }
        tvLoginShowPhoneNum.setText(etPhoneNum.getText().toString());
        if (this.etPhoneNum.length() < 11) {
            btnLoginNext
                    .setBackgroundResource(R.drawable.btn_radius_grey);
            btnLoginNext.setEnabled(false);
            btnLoginNext.setClickable(false);
        } else {
            btnLoginNext.setBackgroundResource(R.drawable.btn_radius);
            btnLoginNext.setEnabled(true);
            btnLoginNext.setClickable(true);
        }
    }

    public void navigateToLoginFragment() {

    }

    public void navigateToVerificationFragment() {
        this.navigator.navigateToSmsCodeVerificationFragment();
    }

    public void showVerificationCodeDialog(String str) {
        DialogFactory.getDoubleBtnDialogBuilder()
                .setTitle(getString(R.string.hint_confirm_phone_num))
                .setMsg(getString(R.string.dialog_msg_we_will_send_code_to_this_phone) + str)
                .setDoubleBtnClickListener(new PhoneRegisterSmsSend(this, str)).build(getContext()).show();

    }

    public void backToLoginActivity() {
        this.navigator.navigateToLoginActivity();
    }

    public void onClearPhoneInput() {

    }
}
