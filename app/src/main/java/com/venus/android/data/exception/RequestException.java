package com.venus.android.data.exception;

public class RequestException extends RuntimeException {
    private String a = "";
    private String b = "";

    public RequestException(String str) {
        this.a = str;
    }

    public String getMessage() {
        return this.a;
    }

    public RequestException(String str, String str2) {
        this.b = str;
        this.a = str2;
    }

    public String getErrorMsg() {
        return this.a;
    }

    public String getErrorCode() {
        return this.b;
    }
}
