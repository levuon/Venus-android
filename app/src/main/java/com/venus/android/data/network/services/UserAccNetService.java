package com.venus.android.data.network.services;

import com.venus.android.data.entity.UserEntity;
import com.venus.android.data.entity.UserTotalAsset;
import com.venus.android.data.entity.resgister.IsSignedEntity;
import com.venus.android.data.entity.wrapper.ResponseDataWrapper;
import com.venus.android.data.network.request.BaseForturnRequest;
import com.venus.android.data.network.request.LoginRequest;
import com.venus.android.data.network.request.RegisterCheckRequest;
import com.venus.android.data.network.request.RegisterInfoRequest;
import com.venus.android.data.network.request.SendSmsCodeRequest;

import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by lev on 5/29/16.
 */
public interface UserAccNetService {

    @POST("/v1/user/canregister")
    ResponseDataWrapper<IsSignedEntity> checkIsSigned(@Body RegisterCheckRequest registerCheckRequest);

    @POST("/v1/message/dynamic/send")
    ResponseDataWrapper sendSmsCode(@Body SendSmsCodeRequest sendSmsCodeRequest);

    @POST("/v1/user/register")
    ResponseDataWrapper<UserEntity> regist(@Body RegisterInfoRequest registerInfoRequest);

    @POST("/v1/user/logon")
    ResponseDataWrapper<UserEntity> login(@Body LoginRequest loginRequest);

    @POST("/v1/user/logout")
    ResponseDataWrapper loginOut(@Body BaseForturnRequest baseForturnRequest);

    @POST("/v1/merchant/query/assert/total")
    ResponseDataWrapper<UserTotalAsset> queryAsset(@Body BaseForturnRequest baseForturnRequest);

}
