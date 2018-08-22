package com.bdcourtyard.business.houseprice.vo;

import java.util.Date;

/**
 * <p>
 * Describe this class...
 *
 * @author: Du.Hx
 * @date: 2018/7/26 20:36
 * @version: 1.0
 */
public class RoomsourceHousepricePage {

    /**
     * 房屋价格ID
     */
    private String housePriceId;

    /**
     * 楼盘定价类型名称
     */
    private String priceName;

    /**
     * 楼宇ID
     */
    private String buildingId;

    /**
     * 单元Id
     */
    private String unitId;

    /**
     * 户型ID
     */
    private String typeId;

    /**
     * 楼层区间
     */
    private String storey;

    /**
     * 楼层增价
     */
    private Long storeyPrice;

    /**
     * 朝向增价
     */
    private Long orientationPrice;

    /**
     * 装修增价
     */
    private Long degreePrice;

    /**
     * 朝向
     */
    private String orientation;

    /**
     * 装修程度1精装 2毛坯
     */
    private String degree;

    /**
     * 房屋基础单价
     */
    private Long originalPrice;

    /**
     * 房屋单价
     */
    private Long price;

    /**
     * 房屋总价
     */
    private Long totalPrice;

    /**
     * 楼盘ID
     */
    private String estateId;

    /**
     * 创建人
     */
    private String employeeId;

    /**
     * 折扣表的id（多个折扣用“，”隔开）
     */
    private String discountId;

    /**
     * 创建时间
     */
    private java.util.Date creatTime;

    /**
     * 楼号
     */
    private String buildingName;
    /**
     * 单元
     */
    private String unitName;
    /**
     * 房屋面积
     */
    private Double floorArea;

    public String getHousePriceId() {
        return housePriceId;
    }

    public void setHousePriceId(String housePriceId) {
        this.housePriceId = housePriceId;
    }

    public String getPriceName() {
        return priceName;
    }

    public void setPriceName(String priceName) {
        this.priceName = priceName;
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

    public String getStorey() {
        return storey;
    }

    public void setStorey(String storey) {
        this.storey = storey;
    }

    public Long getStoreyPrice() {
        return storeyPrice;
    }

    public void setStoreyPrice(Long storeyPrice) {
        this.storeyPrice = storeyPrice;
    }

    public Long getOrientationPrice() {
        return orientationPrice;
    }

    public void setOrientationPrice(Long orientationPrice) {
        this.orientationPrice = orientationPrice;
    }

    public Long getDegreePrice() {
        return degreePrice;
    }

    public void setDegreePrice(Long degreePrice) {
        this.degreePrice = degreePrice;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Long getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Long originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getEstateId() {
        return estateId;
    }

    public void setEstateId(String estateId) {
        this.estateId = estateId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
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

    public Double getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Double floorArea) {
        this.floorArea = floorArea;
    }
}
