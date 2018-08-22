package com.bdcourtyard.business.housetype.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-23 15:46
 * @Description:
 */
public class FindAllTypesReq {

    private String typeName;

    private String startTime;

    private String endTime;

    private String estateId;

    public String getEstateId() {
        return estateId;
    }

    public void setEstateId(String estateId) {
        this.estateId = estateId;
    }

    @ApiModelProperty("户型名称")
    public String getTypeName() {
        return typeName;
    }

    @ApiModelProperty("户型名称")
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @ApiModelProperty("起始时间")
    public String getStartTime() {
        return startTime;
    }

    @ApiModelProperty("起始时间")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @ApiModelProperty("结束时间")
    public String getEndTime() {
        return endTime;
    }

    @ApiModelProperty("结束时间")
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "FindAllTypesReq{" +
                "typeName='" + typeName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", estateId='" + estateId + '\'' +
                '}';
    }
}
