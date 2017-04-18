package com.venus.android.data.common;

public class ConstValue {
    public static final int ALIPAY = 1;
    public static final int ALIPAY_QRCODE_PAY = 4;
    public static final int ALIPAY_SWING_CARD_PAY = 3;
    public static final int CARD = 3;
    public static final String CONVERSION_ERROR = "数据开小差了，再刷新试试看！";
    public static final int COUPON_ACTIVITY_STAT_FINISH = 2;
    public static final int COUPON_ACTIVITY_STAT_UNDER_WAY = 1;
    public static final String COUPON_INTRODUCTION_URL = "http://wx.qfpay.com/near/coupon-introduction-plus.html#co-share";
    public static final String COUPON_OTHER_SHOP_URL = "http://wx.qfpay.com/near/coupon-introduction.html#example";
    public static boolean DEBUG_MODE = Boolean.FALSE.booleanValue();
    public static final String INTERNET_ERROR = "当前无法访问网络，请检查网络设置！";
    public static final int PAGE_NUM_INIT = 0;
    public static final int PAGE_SIZE = 10;
    public static final int PAGE_SIZE_20 = 20;
    public static final String PIC_SIZE_BIG = "_640";
    public static final String PIC_SIZE_MIDDLE = "_320";
    public static final String PIC_SIZE_SMALL = "_140";
    public static final String QINIU_FUNC = "near-merchant";
    public static final String QRCODE_INTRODUCTION_URL = "http://wx.qfpay.com/near/qrcode-introduction.html";
    public static final String QiNiuServerUrl = "http://mmwd-client.m1img.com/";
    public static final String SERVER_ERROR = "有点小问题，不要着急，程序员哥哥正在抢修！";
    public static final int TIMEOUT = 20;


    public static final String TODAY = "今天";
    public static final String YESTERDAY = "昨天";

//    public class H5_URL {
//        public static String getEnvSwitchUrl() {
//            return ConstValue.SERVER_BY_HAOJIN_URL + "/near/near-env.html";
//        }
//
//        public static String getRegisgerAgreementUrl() {
//            return ConstValue.SERVER_BY_HAOJIN_URL + "/near/register-protocol.html";
//        }
//
//        public static String getUserGuideDocUrl() {
//            return ConstValue.SERVER_BY_HAOJIN_URL + "/near/sh-operation-standard.html";
//        }
//
//        public static String getH5MainWeburl() {
//            return ConstValue.SERVER_BY_HAOJIN_URL + "/near/";
//        }
//    }

    public class RESPOND_CODE {
        public static final String RESPCD_LOGIN_ERROR = "2100";
        public static final String RESPCD_NO_LOGIN = "2002";
        public static final String RESPCD_SUCCESS = "0000";
    }

    public class Sp {
        public static final String COOKIE = "cookie";
        public static final String ENCRPT = "encrpt";
        public static final String FIRST_USE_ALIPAY_QRCODE = "first_use_alipay_qrcode";
        public static final String FIRST_USE_BAIDU_QRCODE = "first_use_baidu_qrcode";
        public static final String FIRST_USE_WX_CODE = "first_use_wx_code";
        public static final String FIRST_USE_WX_QRCODE = "first_use_wx_qrcode";
        public static final String NAME = "shared";
        public static final String OFFLINE_DEV = "offline_dev";
        public static final String PASSWORD = "password";
        public static final String REMENBER_PASS_CHECKED = "remenber_pass_checked";
        public static final String SESSIONID = "sessionid";
        public static final String USERNAME = "username";
        public static final String USER_ID = "userId";
    }


}
