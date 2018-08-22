package com.bdcourtyard.business.houseprice.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * Describe this class...
 *
 * @author: Du.Hx
 * @date: 2018/7/26 20:17
 * @version: 1.0
 */
public class HousePriceParm {

    /**
     * 楼盘定价类型名称
     */
    private String priceName;


    /**
     * 房屋最大价格
     */
    private Long MaxtotalPrice;
    /**
     * 房屋最小价格
     */
    private Long MaintotalPrice;

    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;

    public String getPriceName() {
        return priceName;
    }

    public void setPriceName(String priceName) {
        this.priceName = priceName;
    }

    public Long getMaxtotalPrice() {
        return MaxtotalPrice;
    }

    public void setMaxtotalPrice(Long maxtotalPrice) {
        MaxtotalPrice = maxtotalPrice;
    }

    public Long getMaintotalPrice() {
        return MaintotalPrice;
    }

    public void setMaintotalPrice(Long maintotalPrice) {
        MaintotalPrice = maintotalPrice;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
