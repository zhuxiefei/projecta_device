package com.bdcourtyard.business.subscription.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/29.
 */
public class SalePriceVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String salePriceId;
    private String houseId;
    private String housePriceId ;
    private String price;
    private String totalPrice ;
    private String createTime;

    public String getSalePriceId() {
        return salePriceId;
    }

    public void setSalePriceId(String salePriceId) {
        this.salePriceId = salePriceId;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getHousePriceId() {
        return housePriceId;
    }

    public void setHousePriceId(String housePriceId) {
        this.housePriceId = housePriceId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
