package com.venus.android.custom.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.venus.android.R;
import com.venus.android.custom.listener.DoubleBtnCancelClick;
import com.venus.android.custom.listener.DoubleBtnConfirmClick;
/**
 * Created by lev on 5/29/16.
 */

public class DoubleBtnConfirmDialog extends Dialog {
    private Context context;

    public static class Builder {
        public static int TYPE_DOUBLE_BTN = 1;
        public static int TYPE_SINGLE_BTN = 0;
        private String title;
        private String msg;
        private String confirmText = "";
        private String cancelText = "";
        private boolean e;
        private DoubleBtnClickListener doubleBtnClickListener;
        private Dialog dialog = null;

        public interface DoubleBtnClickListener {
            void onCancel();

            void onConfirm();
        }

        public Builder setTouchOutDismss(boolean z) {
            this.e = z;
            return this;
        }
        public Dialog getDialog() {
            return dialog;
        }

        public DoubleBtnClickListener getDoubleBtnClickListener() {
            return doubleBtnClickListener;
        }
        public Builder setDoubleBtnClickListener(DoubleBtnClickListener doubleBtnClickListener) {
            this.doubleBtnClickListener = doubleBtnClickListener;
            return this;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public Builder setMsg(String str) {
            this.msg = str;
            return this;
        }

        public Builder setConfirmBtnText(String str) {
            this.confirmText = str;
            return this;
        }

        public Builder setCancelBtnText(String str) {
            this.cancelText = str;
            return this;
        }

        public Dialog build(Context context) {
            if (TextUtils.isEmpty(this.confirmText)) {
                this.confirmText = context.getString(R.string.text_confirm);
            }
            if (TextUtils.isEmpty(this.cancelText)) {
                this.cancelText = context.getString(R.string.text_cancel);
            }
            if (TextUtils.isEmpty(this.title)) {
                this.title = context.getString(R.string.text_tip);
            }
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.dialog = new Dialog(context, R.style.publish_dialog);
            View inflate = layoutInflater.inflate(R.layout.activity_dialog, null);
            ((TextView) inflate.findViewById(R.id.tv_alert_content)).setText(this.msg);
            ((TextView) inflate.findViewById(R.id.tv_alert_title)).setText(this.title);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_confirm);
            textView.setText(this.confirmText);
            textView.setOnClickListener(new DoubleBtnConfirmClick(this));
            textView = (TextView) inflate.findViewById(R.id.tv_cancel);
            textView.setText(this.cancelText);
            textView.setOnClickListener(new DoubleBtnCancelClick(this));
            this.dialog.setContentView(inflate);
            return this.dialog;
        }
    }

    public DoubleBtnConfirmDialog(Context context) {
        super(context);
        a(context);
    }

    public DoubleBtnConfirmDialog(Context context, int i) {
        super(context, i);
        a(context);
    }

    protected DoubleBtnConfirmDialog(Context context, boolean z, OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        a(context);
    }

    private void a(Context context) {
        this.context = context;
    }

    public static Builder builder() {
        return new Builder();
    }
}
