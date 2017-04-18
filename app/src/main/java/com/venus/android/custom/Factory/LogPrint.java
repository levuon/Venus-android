package com.venus.android.custom.Factory;

import retrofit.RestAdapter;

/**
 * Created by lev on 5/30/16.
 */
public class LogPrint  implements RestAdapter.Log {
    private static final LogPrint logPrint = new LogPrint();

    private LogPrint() {
    }

    public static RestAdapter.Log printLog() {
        return logPrint;
    }

    public void log(String str) {
        System.out.println(str);
    }
}
