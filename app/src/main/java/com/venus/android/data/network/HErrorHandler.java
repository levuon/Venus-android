package com.venus.android.data.network;

import com.crashlytics.android.Crashlytics;
import com.venus.android.data.common.ConstValue;
import com.venus.android.data.exception.RequestException;

import retrofit.ErrorHandler;
import retrofit.RetrofitError;

public class HErrorHandler implements ErrorHandler {
    public Throwable handleError(RetrofitError retrofitError) {
        if (!ConstValue.DEBUG_MODE) {
            retrofitError.printStackTrace();
        }
        String str = "获取数据失败，请稍后重试";
        switch (NetWorkKind.arry[retrofitError.getKind().ordinal()]) {
            case 1:
                str = ConstValue.SERVER_ERROR;
                Crashlytics.logException(retrofitError);
                break;
            case 2:
                str = "网络连接异常,请检查网络设置";
                break;
            case 3:
                str = ConstValue.CONVERSION_ERROR;
                Crashlytics.logException(retrofitError);
                break;
            case 4:
                str = "未知的网络异常哦";
                break;
        }
            return new RequestException(str);
    }
}
