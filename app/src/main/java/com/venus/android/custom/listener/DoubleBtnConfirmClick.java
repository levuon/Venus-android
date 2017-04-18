package com.venus.android.custom.listener;

import android.view.View;

import com.venus.android.custom.Dialog.DoubleBtnConfirmDialog;

/**
 * Created by lev on 5/31/16.
 */
public class DoubleBtnConfirmClick implements View.OnClickListener {
    final /* synthetic */ DoubleBtnConfirmDialog.Builder builder;

    public DoubleBtnConfirmClick(DoubleBtnConfirmDialog.Builder builder) {
        this.builder = builder;
    }

    public void onClick(View view) {
        this.builder.getDoubleBtnClickListener().onConfirm();
        this.builder.getDialog().dismiss();
    }
}
