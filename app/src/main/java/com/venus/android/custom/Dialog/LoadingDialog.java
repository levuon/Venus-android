package com.venus.android.custom.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.venus.android.R;

/**
 * Created by lev on 5/29/16.
 */
public class LoadingDialog extends Dialog {
    private View a;

    public static class Builder {
        private String a = "";
        private boolean b = false;

        public Builder setMsg(String str) {
            this.a = str;
            return this;
        }

        public Builder setTouchOutDismss(boolean z) {
            this.b = z;
            return this;
        }

        public Dialog build(Context context) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout_loading_dialog, null);
            ((TextView) inflate.findViewById(R.id.tv_loading_msg)).setText(this.a);
            Dialog loadingDialog = new LoadingDialog(context, R.style.Theme_Near_CustomProgressDialog, inflate);
            loadingDialog.setCanceledOnTouchOutside(this.b);
            return loadingDialog;
        }
    }

    public LoadingDialog(Context context, int i, View view) {
        super(context, i);
        a(context, view);
    }

    private void a(Context context, View view) {
        this.a = view;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.a != null) {
            setContentView(this.a);
        }
    }

    public static Builder a() {
        return new Builder();
    }
}
