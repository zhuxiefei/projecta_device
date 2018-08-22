package com.bdcourtyard.business.house.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-24 13:43
 * @Description:
 */
public class FindAllHousesReq {

    private String houseIds;

    private String houseNum;

    private String typeName;

    private String buildingId;

    private String unitId;

    private String estateId;

    private String isOthers;

    @ApiModelProperty("房屋ID，多个用逗号隔开")
    public String getHouseIds() {
        return houseIds;
    }

    @ApiModelProperty("房屋ID，多个用逗号隔开")
    public void setHouseIds(String houseIds) {
        this.houseIds = houseIds;
    }

    @ApiModelProperty("房号")
    public String getHouseNum() {
        return houseNum;
    }

    @ApiModelProperty("房号")
    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    @ApiModelProperty("户型名称")
    public String getTypeName() {
        return typeName;
    }

    @ApiModelProperty("户型名称")
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @ApiModelProperty("楼宇ID")
    public String getBuildingId() {
        return buildingId;
    }

    @ApiModelProperty("楼宇ID")
    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    @ApiModelProperty("单元ID")
    public String getUnitId() {
        return unitId;
    }

    @ApiModelProperty("单元ID")
    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    @ApiModelProperty("1代表楼宇单元都为空")
    public String getIsOthers() {
        return isOthers;
    }

    @ApiModelProperty("1代表楼宇单元都为空")
    public void setIsOthers(String isOthers) {
        this.isOthers = isOthers;
    }

    public String getEstateId() {
        return estateId;
    }

    public void setEstateId(String estateId) {
        this.estateId = estateId;
    }

    @Override
    public String toString() {
        return "FindAllHousesReq{" +
                "houseIds='" + houseIds + '\'' +
                ", houseNum='" + houseNum + '\'' +
                ", typeName='" + typeName + '\'' +
                ", buildingId='" + buildingId + '\'' +
                ", unitId='" + unitId + '\'' +
                ", estateId='" + estateId + '\'' +
                ", isOthers='" + isOthers + '\'' +
                '}';
    }
}
