package com.venus.android.custom.listener;

import android.text.Editable;
import android.text.TextWatcher;

import com.venus.android.ui.fragment.LoginFragment;

/**
 * Created by lev on 5/30/16.
 */
public class loginNameChg implements TextWatcher {
    final /* synthetic */ LoginFragment a;

    public loginNameChg(LoginFragment loginFragment) {
        this.a = loginFragment;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        if (editable != null && editable.length() == 0) {
            this.a.tvPassWord.setText("");
        }
    }
}
