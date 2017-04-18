package com.venus.android.custom.Fun1;

import com.venus.android.data.entity.InitConfigEntity;
import com.venus.android.viewmodel.InitConfigViewModelMapper;

import rx.functions.Func1;

/**
 * Created by lev on 5/30/16.
 */
public class InitConfigFun implements Func1 {
    private static final InitConfigFun initConfigFun = new InitConfigFun();

    private InitConfigFun() {
    }

    public static Func1 getInitConfig() {
        return initConfigFun;
    }

    public Object call(Object obj) {
        return InitConfigViewModelMapper.transfer((InitConfigEntity) obj);
    }
}
