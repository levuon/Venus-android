package com.venus.android.custom.Fun1;

import com.venus.android.data.entity.User;
import com.venus.android.viewmodel.RegisterInfoMapper;

import rx.functions.Func1;

/**
 * Created by lev on 5/31/16.
 */
public class RegisterInfoFun implements Func1 {
    private static final RegisterInfoFun a = new RegisterInfoFun();

    private RegisterInfoFun() {
    }

    public static Func1 getRegisterInfoFun() {
        return a;
    }

    public Object call(Object obj) {
        return RegisterInfoMapper.transfer((User) obj);
    }
}