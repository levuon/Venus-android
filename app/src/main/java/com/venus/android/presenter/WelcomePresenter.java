package com.venus.android.presenter;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;

import com.venus.android.app.FortuneEnvironment;
import com.venus.android.custom.Fun1.InitConfigFun;
import com.venus.android.custom.integretion.impl.InitConfigView;
import com.venus.android.data.common.SpKey;
import com.venus.android.data.reactive.ReactiveExecutor;
import com.venus.android.data.repository.EnvironmentDataRepository;
import com.venus.android.utils.SPUtil;
import com.venus.android.view.WelcomeView;

import javax.inject.Inject;

import rx.Subscription;

public class WelcomePresenter extends BasePresenter {
    private WelcomeView welcomeView;
    private WelcomeView.InteractionListener interactionListener;
    private Context context;
    private EnvironmentDataRepository environmentDataRepository;
    private Handler handler;
    private Runnable runnable;
    private final long g = 3000;
    private Subscription h;
    private FortuneEnvironment fortuneEnvironment;

    @Inject
    public WelcomePresenter(Context context, EnvironmentDataRepository environmentDataRepository, FortuneEnvironment fortuneEnvironment) {
        this.environmentDataRepository = environmentDataRepository;
        this.context = context;
        this.fortuneEnvironment = fortuneEnvironment;
    }

    public void destroy() {
        super.destroy();
        if (this.handler != null && this.runnable != null) {
            this.handler.removeCallbacks(this.runnable);
        }
    }

    public void setView(WelcomeView welcomeView) {
        this.welcomeView = welcomeView;
    }

    public void setInteractionListener(WelcomeView.InteractionListener interactionListener) {
        this.interactionListener = interactionListener;
    }

    public void init() {
        this.fortuneEnvironment.initInFirstActivity();
        this.h = this.environmentDataRepository.appInit()
                .map(InitConfigFun.getInitConfig())
                .compose(ReactiveExecutor.asycTransformer())
                .subscribe(new InitConfigView(this));
        addSubscription(this.h);
        this.handler = new Handler();
        this.runnable = WelComeRunnable.handleClick(this);
        this.handler.postDelayed(this.runnable, SPUtil.getInstance(this.context).getLong(SpKey.START_PAGE_SHOW_TIME.key, 3000));
    }

    public void click() {
        goMainOrGuide();
    }

    public boolean startPageFlag(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("http://");
    }


    public void showDefaultStartPage() {
        this.welcomeView.showDefaultStartPage();
    }

    public void showRegisterGuide(String str, long j) {
        this.welcomeView.showStartPage(str);
        SPUtil.getInstance(this.context).save(SpKey.START_PAGE_SHOW_TIME.key, j);
    }

    private void goMainOrGuide() {
        if (!(this.h == null || this.h.isUnsubscribed())) {
            this.h.unsubscribe();
        }
        this.interactionListener.goMainActivity();
//        if (ApkUtil.isFirstInstall(this.context)) {
//            this.welcomeView.showRegisterGuide();
//        } else {
//            this.interactionListener.goMainActivity();
//        }
    }
}

