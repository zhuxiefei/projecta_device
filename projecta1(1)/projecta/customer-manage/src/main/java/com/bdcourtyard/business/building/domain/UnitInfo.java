package com.bdcourtyard.business.building.domain;

import java.util.Date;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-26 11:21
 * @Description:
 */
public class UnitInfo {

    private String unitId;

    private String name;

    private Integer displayOrder;

    private java.util.Date createTime;

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "UnitInfo{" +
                "unitId='" + unitId + '\'' +
                ", name='" + name + '\'' +
                ", displayOrder=" + displayOrder +
                ", createTime=" + createTime +
                '}';
    }
}
