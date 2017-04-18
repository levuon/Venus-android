package com.venus.android.data.entity.wrapper;

import com.venus.android.data.common.ConstValue;

public class ResponseDataWrapper<T> extends ResponseContainer {
    public T data;

    public String toString() {
        return "respcode----->" + this.code + "   " + "respmsg----->" + this.msg + "  resperr" + this.realMsg;
    }

    public boolean isSuccess() {
        return "000000".equalsIgnoreCase(this.code);
    }

    public boolean isNoLoginError() {
        return ConstValue.RESPOND_CODE.RESPCD_NO_LOGIN
                .equalsIgnoreCase(this.code) | ConstValue.RESPOND_CODE
                .RESPCD_LOGIN_ERROR.equalsIgnoreCase(this.code);
    }
}
