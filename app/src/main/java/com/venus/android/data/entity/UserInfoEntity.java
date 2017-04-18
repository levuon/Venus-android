package com.venus.android.data.entity;

import java.io.Serializable;

/**
 * Created by lev on 6/8/16.
 */
public class UserInfoEntity implements Serializable {
    private static final long serialVersionUID = 10522126282798251L;

    /**
     * 用户userId
     */
    private String            userId;

    /**
     * 登录名
     */
    private String            logonName;

    /**
     * 用户状态名称
     */
    private String            userStatusName;

    /**
     * 用户状态描述
     */
    private String            userStatusDesc;

    /**
     * 用户类型名称
     */
    private String            userTypeName;

    /**
     * 用户类型code
     */
    private String            userTypeCode;

    /**
     * 用户类型描述
     */
    private String            userTypeDesc;

    /**
     * 手机号
     */
    private String            mobileNo;

    /**
     * 邮箱
     */
    private String            email;

    /**
     * 实名用户id
     */
    private String            customerId;

    /**
     * 使用用户名称
     */
    private String            customerName;

    /**
     * 证件类型
     */
    private String            idCardType;

    /**
     * 证件号
     */
    private String            idCard;

    /**
     * 是否有交易密码
     */
    private String            hasTradePwd;

    /**
     * 微信id
     */
    private String            openId;

    private String            appid;

//    /**
//     * 银行卡列表
//     */
//    private List<BankCardDo>  cardList;

    /**风险评测描述，稳健型之类*/
    private String            riskTestResultDesc;

    /**可用的Bonus个数*/
    @Deprecated
    private int               useableBonusCount;

    /**可用的红包个数*/
    private int               availLuckyMoneyCount;

    /**可用的优惠劵个数*/
    private int               availCouponCount;

    /**未读消息条数*/
    private int               unReadMessageCount;



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLogonName() {
        return logonName;
    }

    public void setLogonName(String logonName) {
        this.logonName = logonName;
    }

    public String getUserStatusName() {
        return userStatusName;
    }

    public void setUserStatusName(String userStatusName) {
        this.userStatusName = userStatusName;
    }

    public String getUserStatusDesc() {
        return userStatusDesc;
    }

    public void setUserStatusDesc(String userStatusDesc) {
        this.userStatusDesc = userStatusDesc;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public String getUserTypeCode() {
        return userTypeCode;
    }

    public void setUserTypeCode(String userTypeCode) {
        this.userTypeCode = userTypeCode;
    }

    public String getUserTypeDesc() {
        return userTypeDesc;
    }

    public void setUserTypeDesc(String userTypeDesc) {
        this.userTypeDesc = userTypeDesc;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getIdCardType() {
        return idCardType;
    }

    public void setIdCardType(String idCardType) {
        this.idCardType = idCardType;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getHasTradePwd() {
        return hasTradePwd;
    }

    public void setHasTradePwd(String hasTradePwd) {
        this.hasTradePwd = hasTradePwd;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getRiskTestResultDesc() {
        return riskTestResultDesc;
    }

    public void setRiskTestResultDesc(String riskTestResultDesc) {
        this.riskTestResultDesc = riskTestResultDesc;
    }

    public int getUseableBonusCount() {
        return useableBonusCount;
    }

    public void setUseableBonusCount(int useableBonusCount) {
        this.useableBonusCount = useableBonusCount;
    }

    public int getAvailLuckyMoneyCount() {
        return availLuckyMoneyCount;
    }

    public void setAvailLuckyMoneyCount(int availLuckyMoneyCount) {
        this.availLuckyMoneyCount = availLuckyMoneyCount;
    }

    public int getAvailCouponCount() {
        return availCouponCount;
    }

    public void setAvailCouponCount(int availCouponCount) {
        this.availCouponCount = availCouponCount;
    }

    public int getUnReadMessageCount() {
        return unReadMessageCount;
    }

    public void setUnReadMessageCount(int unReadMessageCount) {
        this.unReadMessageCount = unReadMessageCount;
    }
}
