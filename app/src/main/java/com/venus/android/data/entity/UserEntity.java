package com.venus.android.data.entity;

/**
 * Created by lev on 5/31/16.
 */
public class UserEntity {
    private User user;

    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
