package com.venus.android.data.network.request;

import android.content.Context;

/**
 * Created by lev on 5/31/16.
 */
public class RegisterInfoRequest extends BaseForturnRequest {
    private String account;
    private String password;
    private String dynamicCode;

    public RegisterInfoRequest(Context context, String acc, String pwd, String smsCode){
        super(context);
        this.account = acc;
        this.password = pwd;
        this.dynamicCode = smsCode;
    }

}
