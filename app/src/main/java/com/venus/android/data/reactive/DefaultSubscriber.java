package com.venus.android.data.reactive;

import com.venus.android.data.exception.MerchantLogger;

import rx.Subscriber;

public class DefaultSubscriber<T> extends Subscriber<T> {
    public void onCompleted() {
        onFinally();
    }

    public void onError(Throwable th) {
        MerchantLogger.log(th);
        onFinally();
    }

    public void onNext(T t) {
    }

    public void onFinally() {
    }
}
