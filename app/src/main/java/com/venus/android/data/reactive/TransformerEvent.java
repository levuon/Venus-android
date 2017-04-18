package com.venus.android.data.reactive;

import rx.Observable;
import rx.Observable.Transformer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lev on 5/24/16.
 */
public class TransformerEvent implements Transformer {
    private static final TransformerEvent transformerEvent = new TransformerEvent();

    private TransformerEvent() {
    }

    public static Observable.Transformer getTransformerEvent() {
        return transformerEvent;
    }

    public Object call(Object obj) {
        return ((Observable) obj).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
