package com.bdcourtyard.business.house.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-24 14:28
 * @Description:
 */
public class UpdateOpenTimeReq {

    private String houseIds;

    private String openTime;

    @ApiModelProperty("房屋ID，多个用逗号隔开")
    public String getHouseIds() {
        return houseIds;
    }

    @ApiModelProperty("房屋ID，多个用逗号隔开")
    public void setHouseIds(String houseIds) {
        this.houseIds = houseIds;
    }

    @ApiModelProperty("开盘时间")
    public String getOpenTime() {
        return openTime;
    }

    @ApiModelProperty("开盘时间")
    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    @Override
    public String toString() {
        return "UpdateOpenTimeReq{" +
                "houseIds='" + houseIds + '\'' +
                ", openTime='" + openTime + '\'' +
                '}';
    }
}
