package com.venus.android.data.network.request;

import android.content.Context;

/**
 * Created by lev on 5/31/16.
 */
public class SendSmsCodeRequest extends BaseForturnRequest {
    private String templateId;
    private String mobile;

    public SendSmsCodeRequest(Context context, String templateId, String mobile) {
        super(context);
        this.templateId = templateId;
        this.mobile = mobile;
    }
}
