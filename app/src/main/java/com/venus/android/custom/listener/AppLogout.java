package com.venus.android.custom.listener;

import com.venus.android.custom.Dialog.DoubleBtnConfirmDialog;
import com.venus.android.presenter.SettingPresenter;
import com.venus.android.ui.fragment.SettingFragment;

/**
 * Created by lev on 6/2/16.
 */
public class AppLogout implements DoubleBtnConfirmDialog.Builder.DoubleBtnClickListener {
    final /* synthetic */ SettingFragment settingFragment;

    public AppLogout(SettingFragment settingFragment) {
        this.settingFragment = settingFragment;
    }

    public void onConfirm() {
        ((SettingPresenter) this.settingFragment.presenter).logout();
    }

    public void onCancel() {
    }
}
