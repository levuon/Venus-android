package com.venus.android.presenter;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class BasePresenter implements Presenter {
    private CompositeSubscription a;

    public void addSubscription(Subscription subscription) {
        if (this.a == null) {
            this.a = new CompositeSubscription();
        }
        this.a.add(subscription);
    }

    public void create() {
        this.a = new CompositeSubscription();
    }

    public void resume() {
    }

    public void pause() {
    }

    public void destroy() {
        if (this.a != null && !this.a.isUnsubscribed()) {
            this.a.unsubscribe();
        }
    }
}
