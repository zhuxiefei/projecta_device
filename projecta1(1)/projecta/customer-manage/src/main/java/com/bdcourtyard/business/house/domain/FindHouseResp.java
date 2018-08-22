package com.bdcourtyard.business.house.domain;

import io.swagger.models.auth.In;

import java.util.Date;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-30 14:39
 * @Description:
 */
public class FindHouseResp {

    private String buildingName;

    private String unitName;

    private String typeName;

    private String buildingId;

    private String unitId;

    private String typeId;

    private String houseNum;

    private String houseId;

    private Date openTime;

    private Integer orientation;

    private Integer decorationDegree;

    private Integer displayOrder;

    private Integer floor;

    private Integer floorArea;

    private Integer interFloorArea;

    private Date createTime;

    public Integer getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Integer floorArea) {
        this.floorArea = floorArea;
    }

    public Integer getInterFloorArea() {
        return interFloorArea;
    }

    public void setInterFloorArea(Integer interFloorArea) {
        this.interFloorArea = interFloorArea;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Integer getOrientation() {
        return orientation;
    }

    public void setOrientation(Integer orientation) {
        this.orientation = orientation;
    }

    public Integer getDecorationDegree() {
        return decorationDegree;
    }

    public void setDecorationDegree(Integer decorationDegree) {
        this.decorationDegree = decorationDegree;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "FindHouseResp{" +
                "buildingName='" + buildingName + '\'' +
                ", unitName='" + unitName + '\'' +
                ", typeName='" + typeName + '\'' +
                ", buildingId='" + buildingId + '\'' +
                ", unitId='" + unitId + '\'' +
                ", typeId='" + typeId + '\'' +
                ", houseNum='" + houseNum + '\'' +
                ", houseId='" + houseId + '\'' +
                ", openTime=" + openTime +
                ", orientation=" + orientation +
                ", decorationDegree=" + decorationDegree +
                ", displayOrder=" + displayOrder +
                ", floor=" + floor +
                ", floorArea=" + floorArea +
                ", interFloorArea=" + interFloorArea +
                ", createTime=" + createTime +
                '}';
    }
}
