package com.venus.android.data.entity.resgister;

public class IsSignedEntity {

    private boolean isBindCard;
    private boolean isHasDeviceId;
    private boolean isRealName;
    private boolean isRegister;

    public boolean isBindCard() {
        return isBindCard;
    }

    public void setBindCard(boolean bindCard) {
        isBindCard = bindCard;
    }

    public boolean isHasDeviceId() {
        return isHasDeviceId;
    }

    public void setHasDeviceId(boolean hasDeviceId) {
        isHasDeviceId = hasDeviceId;
    }

    public boolean isRealName() {
        return isRealName;
    }

    public void setRealName(boolean realName) {
        isRealName = realName;
    }

    public boolean isRegister() {
        return isRegister;
    }

    public void setRegister(boolean register) {
        isRegister = register;
    }

}
