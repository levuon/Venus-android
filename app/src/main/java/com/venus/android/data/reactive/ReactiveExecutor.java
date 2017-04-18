package com.venus.android.data.reactive;

import rx.Observable;
import rx.Observable.Transformer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ReactiveExecutor {
    @Deprecated
    public static <T> Observable<T> asyc(Observable<T> observable) {
        return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> Transformer<T, T> asycTransformer() {
        return TransformerEvent.getTransformerEvent();
    }
}
