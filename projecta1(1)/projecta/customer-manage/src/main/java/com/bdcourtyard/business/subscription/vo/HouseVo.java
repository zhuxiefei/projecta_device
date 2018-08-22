package com.bdcourtyard.business.subscription.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/29.
 */
public class HouseVo  implements Serializable {

    private static final long serialVersionUID = 1L;
    private String houuseId;
    private String houseNo;
    private String estateId;
    private int saleStatus;

    public String getHouuseId() {
        return houuseId;
    }

    public void setHouuseId(String houuseId) {
        this.houuseId = houuseId;
    }



    public String getEstateId() {
        return estateId;
    }

    public void setEstateId(String estateId) {
        this.estateId = estateId;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public int getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(int saleStatus) {
        this.saleStatus = saleStatus;
    }
}
