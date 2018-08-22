package com.bdcourtyard.business.houseprice.vo;

/**
 * <p>
 * Describe this class...
 *
 * @author: Du.Hx
 * @date: 2018/7/25 15:30
 * @version: 1.0
 */
public class HouseOrTypePage {

    /**
     * Parm
     */
    //楼宇Id
    private String buildingId;
    //单元Id
    private String unitId;
    /**
     * Page
     */
    //户型id
    private String typeId;
    //户型名称
    private String typeName;
    //建筑面积
    private Double floorArea;

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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Double getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Double floorArea) {
        this.floorArea = floorArea;
    }
}
