package com.venus.android.data.entity;

/**
 * Created by lev on 6/2/16.
 */
public class UserAssetType {
    private String productType;

    private String totalAssert;

    private String lastIncome;

    private String accumulatedIncome;


    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

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
}
