package com.bdcourtyard.business.clentstatistics.model;

import java.util.Date;

/**
 * <p>
 * Describe this class...
 *
 * @author: Du.Hx
 * @date: 2018/7/27 14:29
 * @version: 1.0
 */
public class ClientstatisticsParm {

    /**
     * 来访人数统计 0未选1已选
     */
    private String comeflag;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 户型意向 0未选1已选
     */
    private String typeFlag;
    /**
     * 价格意向 0未选1已选
     */
    private String priceFlag;

    public String getComeflag() {
        return comeflag;
    }

    public void setComeflag(String comeflag) {
        this.comeflag = comeflag;
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

    public String getTypeFlag() {
        return typeFlag;
    }

    public void setTypeFlag(String typeFlag) {
        this.typeFlag = typeFlag;
    }

    public String getPriceFlag() {
        return priceFlag;
    }

    public void setPriceFlag(String priceFlag) {
        this.priceFlag = priceFlag;
    }
}
