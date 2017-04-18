package com.venus.android.custom.Fun1;

import com.venus.android.data.entity.pay.BasePayEntity;
import com.venus.android.viewmodel.IsSignedMapper;

import rx.functions.Func1;

/**
 * Created by lev on 5/30/16.
 */
public class BasePayEntityFun implements Func1 {
    private static final BasePayEntityFun basePayEntityFun = new BasePayEntityFun();

    private BasePayEntityFun() {
    }

    public static Func1 getBasePayEntity() {
        return basePayEntityFun;
    }

    public Object call(Object obj) {
        return IsSignedMapper.transfer( (BasePayEntity) obj);
    }
}
