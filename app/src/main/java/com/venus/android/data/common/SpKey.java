package com.venus.android.data.common;

public enum SpKey {

    CACHE_INIT_SERVICE("cacheInitService"),
    IS_SHOW_COUPON_GUIDE("is_show_coupon_guide"),
    START_PAGE_SHOW_TIME("start_page_show_time");


    public String key;

    private SpKey(String str) {
        this.key = str;
    }
}
