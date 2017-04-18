package com.venus.android.custom.Fun1;

import com.venus.android.data.entity.UserTotalAsset;
import com.venus.android.viewmodel.UserAssetMapper;

import rx.functions.Func1;

/**
 * Created by lev on 6/2/16.
 */
public class UserAssetFun implements Func1 {
    private static final UserAssetFun a = new UserAssetFun();

    private UserAssetFun() {
    }

    public static Func1 getUserAssetFun() {
        return a;
    }

    public Object call(Object obj) {
        return UserAssetMapper.transfer((UserTotalAsset) obj);
    }
}