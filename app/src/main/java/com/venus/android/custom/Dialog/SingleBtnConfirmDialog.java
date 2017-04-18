package com.venus.android.custom.Dialog;

import android.app.Dialog;

/**
 * Created by lev on 5/29/16.
 */
public class SingleBtnConfirmDialog {

    public static class Builder {
        public Dialog a = null;
        private String b;
        private String c;
        private String d = "确定";
        private boolean e;
        private OnConfirmClickListener f;

        public interface OnConfirmClickListener {
            void onConfirm();
        }

        public Builder setTouchOutDismss(boolean z) {
            this.e = z;
            return this;
        }

        public Builder setTitle(String str) {
            this.b = str;
            return this;
        }

        public Builder setMsg(String str) {
            this.c = str;
            return this;
        }

        public Builder setConfirmBtnText(String str) {
            this.d = str;
            return this;
        }

        public Builder setConfirmClickListener(OnConfirmClickListener onConfirmClickListener) {
            this.f = onConfirmClickListener;
            return this;
        }

//        public Dialog build(Context context) {
//            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
//            this.a = new Dialog(context, R.style.publish_dialog);
//            View inflate = layoutInflater.inflate(R.layout.view_dialog_layout_type1, null);
//            ((TextView) inflate.findViewById(R.id.tv_alert_content)).setText(this.c);
//            ((TextView) inflate.findViewById(R.id.tv_alert_title)).setText(this.b);
//            TextView textView = (TextView) inflate.findViewById(R.id.tv_confirm);
//            textView.setText(this.d);
//            textView.setOnClickListener(new byz(this));
//            this.a.setContentView(inflate);
//            this.a.setCanceledOnTouchOutside(this.e);
//            return this.a;
//        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
