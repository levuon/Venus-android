package com.venus.android.data.exception;

public class PasswordErrorException extends Throwable {
    private String a;

    public PasswordErrorException(String str) {
        this.a = str;
    }

    public String getMessage() {
        return this.a;
    }
}
