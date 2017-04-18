package com.venus.android.data.entity;

import java.util.Map;

/**
 * Created by lev on 6/2/16.
 */
public class UserTotalAsset {
    private String totalAssert;

    private String lastIncome;

    private String accumulatedIncome;

    private Map<String,UserAssetType> detail;

    public String getTotalAssert() {
        return totalAssert;
    }

    public void setTotalAssert(String totalAssert) {
        this.totalAssert = totalAssert;
    }

    public String getLastIncome() {
        return lastIncome;
    }

    public void setLastIncome(String lastIncome) {
        this.lastIncome = lastIncome;
    }

    public String getAccumulatedIncome() {
        return accumulatedIncome;
    }

    public void setAccumulatedIncome(String accumulatedIncome) {
        this.accumulatedIncome = accumulatedIncome;
    }

    public Map<String, UserAssetType> getDetail() {
        return detail;
    }

    public void setDetail(Map<String, UserAssetType> detail) {
        this.detail = detail;
    }
}
