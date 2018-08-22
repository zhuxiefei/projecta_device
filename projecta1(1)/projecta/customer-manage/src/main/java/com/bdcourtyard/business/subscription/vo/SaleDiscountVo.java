package com.bdcourtyard.business.subscription.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/29.
 */
public class SaleDiscountVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String saleDiscountId;
    private String houseId;
    private String discountId ;
    private String discountName;
    private String discount ;
    private Date efficacyDate;
    private Date loseEfficacyDate;

    public String getSaleDiscountId() {
        return saleDiscountId;
    }

    public void setSaleDiscountId(String saleDiscountId) {
        this.saleDiscountId = saleDiscountId;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Date getEfficacyDate() {
        return efficacyDate;
    }

    public void setEfficacyDate(Date efficacyDate) {
        this.efficacyDate = efficacyDate;
    }

    public Date getLoseEfficacyDate() {
        return loseEfficacyDate;
    }

    public void setLoseEfficacyDate(Date loseEfficacyDate) {
        this.loseEfficacyDate = loseEfficacyDate;
    }
}
