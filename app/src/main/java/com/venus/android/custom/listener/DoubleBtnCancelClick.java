package com.venus.android.custom.listener;

import android.view.View;

import com.venus.android.custom.Dialog.DoubleBtnConfirmDialog.Builder;

/**
 * Created by lev on 5/31/16.
 */
public class DoubleBtnCancelClick  implements View.OnClickListener {
    final /* synthetic */ Builder builder;

    public DoubleBtnCancelClick(Builder builder) {
        this.builder = builder;
    }

    public void onClick(View view) {
        this.builder.getDoubleBtnClickListener().onCancel();
        this.builder.getDialog().dismiss();
    }
}
