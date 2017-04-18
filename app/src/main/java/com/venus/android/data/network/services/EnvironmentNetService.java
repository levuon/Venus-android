package com.venus.android.data.network.services;

import com.venus.android.data.entity.wrapper.ResponseDataWrapper;

import retrofit.http.GET;

/**
 * Created by lev on 6/3/16.
 */
public interface EnvironmentNetService {


    @GET("front/pic.action")
    ResponseDataWrapper getBanner();

}
