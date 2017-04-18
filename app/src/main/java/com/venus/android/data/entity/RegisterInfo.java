package com.venus.android.data.entity;

import com.google.gson.Gson;

public class RegisterInfo {
    private static RegisterInfo INSTANCE = null;
    private String bankaccount = "";
    private String bankcode = "";
    private String bankname = "";
    private String banktype = "";
    private String banktypeName = "";
    private String bankuser = "";
    private String headbankPhone = "";
    private String headbankname = "";
    private String password = "";
    private String smsCheckCode;
    private String smscodeCheckePhoneNumber;
    private String username = "";

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RegisterInfo{");
        sb.append(", bankaccount='").append(bankaccount).append('\'');
        sb.append(", bankcode='").append(bankcode).append('\'');
        sb.append(", bankname='").append(bankname).append('\'');
        sb.append(", banktype='").append(banktype).append('\'');
        sb.append(", banktypeName='").append(banktypeName).append('\'');
        sb.append(", bankuser='").append(bankuser).append('\'');
        sb.append(", headbankPhone='").append(headbankPhone).append('\'');
        sb.append(", headbankname='").append(headbankname).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", smsCheckCode='").append(smsCheckCode).append('\'');
        sb.append(", smscodeCheckePhoneNumber='").append(smscodeCheckePhoneNumber).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append('}');
        return sb.toString();
    }
    public String toJson() {
        return new Gson().toJson((Object) this);
    }

    public static RegisterInfo getInstance() {
        if (INSTANCE == null) {
            synchronized (RegisterInfo.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RegisterInfo();
                }
            }
        }
        return INSTANCE;
    }

    public static void clearInstance() {
        INSTANCE = null;
    }

    public String getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
    }


    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }



    public String getBanktype() {
        return banktype;
    }

    public void setBanktype(String banktype) {
        this.banktype = banktype;
    }

    public String getBanktypeName() {
        return banktypeName;
    }

    public void setBanktypeName(String banktypeName) {
        this.banktypeName = banktypeName;
    }

    public String getBankuser() {
        return bankuser;
    }

    public void setBankuser(String bankuser) {
        this.bankuser = bankuser;
    }

    public String getHeadbankPhone() {
        return headbankPhone;
    }

    public void setHeadbankPhone(String headbankPhone) {
        this.headbankPhone = headbankPhone;
    }

    public String getHeadbankname() {
        return headbankname;
    }

    public void setHeadbankname(String headbankname) {
        this.headbankname = headbankname;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSmsCheckCode() {
        return smsCheckCode;
    }

    public void setSmsCheckCode(String smsCheckCode) {
        this.smsCheckCode = smsCheckCode;
    }

    public String getSmscodeCheckePhoneNumber() {
        return smscodeCheckePhoneNumber;
    }

    public void setSmscodeCheckePhoneNumber(String smscodeCheckePhoneNumber) {
        this.smscodeCheckePhoneNumber = smscodeCheckePhoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
