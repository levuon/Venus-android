package com.venus.android.data.cache;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.venus.android.data.common.ConstValue;
import com.venus.android.data.entity.User;
import com.venus.android.utils.SPUtil;
import com.venus.android.utils.SecurityUtil;

import timber.log.Timber;

public class UserCache {
    private static volatile UserCache userCache = null;
    private Context context;
    private SPUtil spUtil;
    private String d;
    private User user = null;

    public static UserCache getInstance(Context context) {
        if (userCache == null) {
            synchronized (UserCache.class) {
                if (userCache == null) {
                    userCache = new UserCache(context);
                    Timber.i("INSTANCE---" + userCache, new Object[0]);
                }
            }
        }
        return userCache;
    }

    private UserCache(Context context) {
        this.context = context;
        this.spUtil = SPUtil.getInstance(this.context);
    }

    public void cacheUser(User user) {
        clearUserCache();
        SPUtil.getInstance(this.context).save("user", SecurityUtil.encodeBase64(user.toJson()));
    }

    @Deprecated
    public User getCacheUser() {
        if (this.user == null) {
            this.user = (User) new Gson().fromJson(SecurityUtil.decodeBase64(SPUtil.getInstance(this.context).getString("user", "")), User.class);
        }
        return this.user;
    }

    public void clearUserCache() {
        this.d = null;
        this.spUtil.remove("user");
        this.user = null;
    }

    public boolean hasLogin() {
        if (getCacheUser() == null || TextUtils.isEmpty(getCacheUser().getSessionId())) {
            return false;
        }
        return true;
    }

    public String getUserName() {
        return getCacheUser().getMobileNo();
    }

    public String getUserMobile() {
        return getCacheUser().getMobileNo();
    }


    public String getUserId() {
        return String.valueOf(getCacheUser().getUserId());
    }

    public boolean cachePass(String str) {
        this.spUtil.save(ConstValue.Sp.ENCRPT, SecurityUtil.encodeBase64(str));
        return true;
    }

    public void clearCachePass() {
        this.spUtil.remove(ConstValue.Sp.ENCRPT);
    }
}
