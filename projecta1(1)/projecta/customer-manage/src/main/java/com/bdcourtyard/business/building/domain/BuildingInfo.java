package com.bdcourtyard.business.building.domain;

import io.swagger.models.auth.In;

import java.util.Date;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-26 11:20
 * @Description:
 */
public class BuildingInfo {

    private String buildingId;

    private String name;

    private String buildingDesc;

    private Integer displayOrder;

    private java.util.Date createTime;

    private Integer estateType;

    private Integer floors;

    public Integer getFloors() {
        return floors;
    }

    public void setFloors(Integer floors) {
        this.floors = floors;
    }

    public Integer getEstateType() {
        return estateType;
    }

    public void setEstateType(Integer estateType) {
        this.estateType = estateType;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuildingDesc() {
        return buildingDesc;
    }

    public void setBuildingDesc(String buildingDesc) {
        this.buildingDesc = buildingDesc;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BuildingInfo{" +
                "buildingId='" + buildingId + '\'' +
                ", name='" + name + '\'' +
                ", buildingDesc='" + buildingDesc + '\'' +
                ", displayOrder=" + displayOrder +
                ", createTime=" + createTime +
                ", estateType=" + estateType +
                ", floors=" + floors +
                '}';
    }
}
