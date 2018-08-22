package com.bdcourtyard.business.house.domain;

/**
 * <p>
 * 导入错误信息回参
 * </p>
 * ClassName: ImportMsg <br/>
 * Author: xiayanxin <br/>
 */
public class ImportMsg {
    private String buildingName;

    private String unitName;

    private String houseNum;

    private String typeName;

    private String displayOrder;

    private String orientation;

    private String decorationDegree;

    private String openTime;

    private String floor;

    private String failureMsg;

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

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getDecorationDegree() {
        return decorationDegree;
    }

    public void setDecorationDegree(String decorationDegree) {
        this.decorationDegree = decorationDegree;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getFailureMsg() {
        return failureMsg;
    }

    public void setFailureMsg(String failureMsg) {
        this.failureMsg = failureMsg;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "ImportMsg{" +
                "buildingName='" + buildingName + '\'' +
                ", unitName='" + unitName + '\'' +
                ", houseNum='" + houseNum + '\'' +
                ", typeName='" + typeName + '\'' +
                ", displayOrder='" + displayOrder + '\'' +
                ", orientation='" + orientation + '\'' +
                ", decorationDegree='" + decorationDegree + '\'' +
                ", openTime='" + openTime + '\'' +
                ", floor='" + floor + '\'' +
                ", failureMsg='" + failureMsg + '\'' +
                '}';
    }
}
