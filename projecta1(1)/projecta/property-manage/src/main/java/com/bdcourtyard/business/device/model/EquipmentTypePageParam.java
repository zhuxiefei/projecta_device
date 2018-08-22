package com.bdcourtyard.business.device.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhuxiefei
 * @date 2018/8/7 14:03
 */
public class EquipmentTypePageParam implements Serializable{

    private static final long serialVersionUID = 1L;
    private String typeName;
    private String startTime;
    private String endTime;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String createTime) {
        this.startTime = createTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "EquipmentTypePageParam{" +
                "typeName='" + typeName + '\'' +
                ", createTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}