package com.venus.android.data.entity;

/**
 * Created by lev on 5/30/16.
 */
public class BaseInfo {

    private static BaseInfo INSTANCE = null;

    public static String url = "http://192.168.0.105:18080";

    public static Boolean isSignIn = false;

    public static Boolean isAsset = false;

    public static Boolean isBindCard = false;

    public static Boolean isHasDeviceId = false;

    public static Boolean isRealName = false;


    public static BaseInfo getInstance() {
        if (INSTANCE == null) {
            synchronized (RegisterInfo.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BaseInfo();
                }
            }
        }
        return INSTANCE;
    }
    public static void clearInstance() {
        INSTANCE = null;
    }


    public static Boolean getIsSignIn() {
        return isSignIn;
    }

    public static void setIsSignIn(Boolean isSignIn) {
        BaseInfo.isSignIn = isSignIn;
    }

    public static Boolean getIsAsset() {
        return isAsset;
    }

    public static void setIsAsset(Boolean isAsset) {
        BaseInfo.isAsset = isAsset;
    }

    public static Boolean getIsRealName() {
        return isRealName;
    }

    public static void setIsRealName(Boolean isRealName) {
        BaseInfo.isRealName = isRealName;
    }

    public static Boolean getIsBindCard() {
        return isBindCard;
    }

    public static void setIsBindCard(Boolean isBindCard) {
        BaseInfo.isBindCard = isBindCard;
    }

    public static Boolean getIsHasDeviceId() {
        return isHasDeviceId;
    }

    public static void setIsHasDeviceId(Boolean isHasDeviceId) {
        BaseInfo.isHasDeviceId = isHasDeviceId;
    }
}
