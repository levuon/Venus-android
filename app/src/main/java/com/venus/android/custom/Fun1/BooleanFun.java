package com.venus.android.custom.Fun1;

import com.venus.android.viewmodel.BooleanMapper;

import rx.functions.Func1;

/**
 * Created by lev on 5/30/16.
 */
public class BooleanFun implements Func1 {
    private static final BooleanFun booleanFun = new BooleanFun();

    private BooleanFun() {
    }

    public static Func1 getCheckBoolean() {
        return booleanFun;
    }

    public Object call(Object obj) {
        return BooleanMapper.transfer((Boolean) obj);
    }
}
