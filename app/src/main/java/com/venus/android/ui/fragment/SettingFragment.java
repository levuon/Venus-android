package com.venus.android.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.venus.android.R;
import com.venus.android.custom.AppBar;
import com.venus.android.custom.Dialog.DialogFactory;
import com.venus.android.custom.listener.AppLogout;
import com.venus.android.data.cache.UserCache;
import com.venus.android.di.components.MainComponent;
import com.venus.android.presenter.SettingPresenter;
import com.venus.android.ui.BaseFragment;
import com.venus.android.view.SettingView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by lev on 6/2/16.
 */
public class SettingFragment extends BaseFragment<SettingPresenter> implements SettingView {

    @InjectView(R.id.tv_phonenum)
    TextView tvPhoneNum;
    @InjectView(R.id.ll_mybank)
    RelativeLayout llMybank;
    @InjectView(R.id.rl_mypocket)
    RelativeLayout rlMyPocket;

    @InjectView(R.id.tv_phonenumber)
    TextView tvPhoneNumber;
    @InjectView(R.id.btn_logout)
    Button btnLogout;


    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainComponent) getComponent(MainComponent.class)).inject(this);
        if (activity != null) {
            ((SettingPresenter) this.presenter).setView(this);
            ((SettingPresenter) this.presenter).setInteractionListener((InteractionListener) getActivity());
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_account_setting, null);
        ButterKnife.inject((Object) this, inflate);
        return inflate;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.tvPhoneNum.setText( UserCache.getInstance(getContext()).getUserMobile().toString());
        this.tvPhoneNumber.setText(UserCache.getInstance(getContext()).getUserMobile().toString());
    }

    public void onInitAppBar(AppBar appBar) {
        super.onInitAppBar(appBar);
        setHasAppBar(false);
//        appBar.setTitle(getActivity().getString(R.string.hint_register_phone_num));
    }

//    public void delayShow() {
//        new Handler().postDelayed(new loginFragmentRunnable(this), 100);
//    }




    /**      **/
    @OnClick({R.id.ll_mybank})
    public void goMyBank() {
        this.presenter.goMyBankInfo();
    }

    @OnClick({R.id.rl_mypocket})
    public void goMypocket() {

    }

    @OnClick({R.id.btn_logout})
    public void logoutApp() {
        DialogFactory.getDoubleBtnDialogBuilder()
                .setMsg(getString(R.string.hint_confirm_logout))
                .setDoubleBtnClickListener(new AppLogout(this)).build(getContext()).show();
    }

    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
