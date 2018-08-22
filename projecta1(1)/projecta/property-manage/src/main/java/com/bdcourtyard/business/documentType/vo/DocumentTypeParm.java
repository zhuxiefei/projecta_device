package com.bdcourtyard.business.documentType.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhuxiefei
 * @date 2018/7/31 17:25
 */
public class DocumentTypeParm {

    @Override
    public String toString() {
        return "DocumentTypeParm{" +
                "typeName='" + typeName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", estateId='" + estateId + '\'' +
                '}';
    }

    public DocumentTypeParm(){

    }
    private String typeName;
    private String startTime;
    private String endTime;
    private String estateId;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEstateId() {
        return estateId;
    }

    public void setEstateId(String estateId) {
        this.estateId = estateId;
    }
}