package com.venus.android.data.network.request;

import android.content.Context;

/**
 * Created by lev on 6/1/16.
 */
public class LoginRequest extends BaseForturnRequest {

    private String account;
    private String password;

    public LoginRequest(Context context, String str, String str2){
        super(context);
        this.account = str;
        this.password = str2;
    }
}
