package com.venus.android.data.network.request;

import android.content.Context;

import com.venus.android.data.cache.UserCache;
import com.venus.android.data.entity.User;

import java.text.SimpleDateFormat;

/**
 * Created by lev on 5/30/16.
 */
public class BaseForturnRequest extends BaseRequest{

    public String userId;
    public String sessionId = "";
    public String imei = "";
    public String source = "";


    public BaseForturnRequest(Context context) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        DeviceUtil instance = DeviceUtil.getInstance(context);
//        this.udid = DeviceUtil.getDeviceID(context);
        User cacheUser = UserCache.getInstance(context).getCacheUser();
        if(null != cacheUser) {
            this.userId = String.valueOf(cacheUser.getUserId());
            this.sessionId = String.valueOf(cacheUser.getSessionId());
        }
        this.source = "ANDROID";
//        this.contact = cacheUser.getMobile();
//        this.network = instance.getNetworkAccessMode();
    }


}
