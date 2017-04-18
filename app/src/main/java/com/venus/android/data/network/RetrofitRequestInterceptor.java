package com.venus.android.data.network;

import android.content.Context;

import com.venus.android.data.network.request.header.HeaderManager;
import com.venus.android.data.network.request.header.RequestHeader;

import java.util.List;

import retrofit.RequestInterceptor;

public class RetrofitRequestInterceptor implements RequestInterceptor {
    private static volatile RetrofitRequestInterceptor retrofitRequestInterceptor;
    private HeaderManager headerManager;
    private boolean flag;

    public void setIsDebug(boolean z) {
        this.flag = z;
    }

    private RetrofitRequestInterceptor(HeaderManager headerManager) {
        this.headerManager = headerManager;
    }

    public static RetrofitRequestInterceptor getInstance(Context context) {
        if (retrofitRequestInterceptor == null) {
            synchronized (RetrofitRequestInterceptor.class) {
                if (retrofitRequestInterceptor == null) {
                    retrofitRequestInterceptor = new RetrofitRequestInterceptor(new HeaderManager(context));
                }
            }
        }
        return retrofitRequestInterceptor;
    }

    public void intercept(RequestFacade requestFacade) {
        if (this.headerManager != null) {
            this.headerManager.setIsDebug(this.flag);
            List requestHeaders = this.headerManager.getRequestHeaders();
            if (requestHeaders != null) {
                for (int i = 0; i < requestHeaders.size(); i++) {
                    RequestHeader requestHeader = (RequestHeader) requestHeaders.get(i);
                    requestFacade.addHeader(requestHeader.key(), requestHeader.value());
                }
            }
        }
    }
}
