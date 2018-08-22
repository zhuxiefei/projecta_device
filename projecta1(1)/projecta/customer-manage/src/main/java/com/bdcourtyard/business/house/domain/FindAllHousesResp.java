package com.bdcourtyard.business.house.domain;

import java.util.Date;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-24 13:41
 * @Description:
 */
public class FindAllHousesResp {

    private String houseId;

    private String buildingName;

    private String unitName;

    private String houseNum;

    private String typeName;

    private Date createTime;

    private Date openTime;

    private Double floorArea;

    private Double interFloorArea;

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Double getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Double floorArea) {
        this.floorArea = floorArea;
    }

    public Double getInterFloorArea() {
        return interFloorArea;
    }

    public void setInterFloorArea(Double interFloorArea) {
        this.interFloorArea = interFloorArea;
    }

    @Override
    public String toString() {
        return "FindAllHousesResp{" +
                "houseId='" + houseId + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", unitName='" + unitName + '\'' +
                ", houseNum='" + houseNum + '\'' +
                ", typeName='" + typeName + '\'' +
                ", createTime=" + createTime +
                ", openTime=" + openTime +
                ", floorArea=" + floorArea +
                ", interFloorArea=" + interFloorArea +
                '}';
    }
}
