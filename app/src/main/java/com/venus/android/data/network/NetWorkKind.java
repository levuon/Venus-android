package com.venus.android.data.network;

import retrofit.RetrofitError;

/**
 * Created by lev on 6/6/16.
 */
public class NetWorkKind {
    public static final /* synthetic */ int[] arry = new int[RetrofitError.Kind.values().length];

    static {
        try {
            arry[RetrofitError.Kind.HTTP.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            arry[RetrofitError.Kind.NETWORK.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            arry[RetrofitError.Kind.CONVERSION.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            arry[RetrofitError.Kind.UNEXPECTED.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
