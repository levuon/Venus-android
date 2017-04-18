package com.venus.android.data.network.request;

import android.content.Context;

/**
 * Created by lev on 5/30/16.
 */
public class RegisterCheckRequest extends BaseForturnRequest {
    public String account;

    public RegisterCheckRequest(Context context, String account) {
        super(context);
        this.account = account;
    }
}
