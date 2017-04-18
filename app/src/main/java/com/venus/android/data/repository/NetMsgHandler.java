package com.venus.android.data.repository;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;

import com.venus.android.custom.handler.MsgHandler;
import com.venus.android.data.common.ConstValue;
import com.venus.android.data.entity.pay.BasePayEntity;
import com.venus.android.data.entity.wrapper.ResponseDataWrapper;
import com.venus.android.data.exception.NearNetWorkException;

import rx.Subscriber;


public class NetMsgHandler {
    private Context context;
    private final Handler b = new MsgHandler(this);

    private NetMsgHandler(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }
    public static NetMsgHandler getHandler(Context context) {
        return new NetMsgHandler(context);
    }

    public void handleError(Subscriber subscriber, ResponseDataWrapper responseDataWrapper) {
        if (responseDataWrapper == null) {
            subscriber.onError(new NearNetWorkException("获取数据错误"));
        } else if (!responseDataWrapper.isSuccess()) {
            if (responseDataWrapper.isNoLoginError()) {
                this.b.sendEmptyMessage(0);
            }
            if (!TextUtils.isEmpty(responseDataWrapper.msg)) {
                subscriber.onError(new NearNetWorkException(responseDataWrapper.msg));
            }
//            else if (TextUtils.isEmpty(responseDataWrapper.realMsg)) {
//                subscriber.onError(new NearNetWorkException("数据获取错误,请重试"));
//            }
            else {
                subscriber.onError(new NearNetWorkException(responseDataWrapper.realMsg));
            }
        }
    }

    public void handleError(Subscriber subscriber, BasePayEntity basePayEntity) {
        if (basePayEntity == null) {
            subscriber.onError(new NearNetWorkException("获取数据错误"));
        } else if (!basePayEntity.getRespondCode().equals("0000")) {
            if(ConstValue.RESPOND_CODE.RESPCD_NO_LOGIN.equalsIgnoreCase(basePayEntity.getRespondCode()) ||
                    ConstValue.RESPOND_CODE.RESPCD_LOGIN_ERROR.equalsIgnoreCase(basePayEntity.getRespondCode()) )
                this.b.sendEmptyMessage(0);
            }
            if (!TextUtils.isEmpty(basePayEntity.getRespondError())) {
                subscriber.onError(new NearNetWorkException(basePayEntity.getRespondError()));
            } else if (TextUtils.isEmpty(basePayEntity.getRespondError())) {
                subscriber.onError(new NearNetWorkException(basePayEntity.getRespondMsg()));
            }
    }
}
