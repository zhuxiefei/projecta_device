package com.bdcourtyard.business.housetype.domain;

import com.bdcourtyard.business.housetype.model.HouseTypeSence;

import java.util.Date;
import java.util.List;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-23 13:52
 * @Description:
 */
public class FindTypeResp {

    private String typeId;

    /**
     * 户型编号
     */
    private String typeNo;

    /**
     * 户型名称
     */
    private String typeName;

    /**
     * 户型描述
     */
    private String typeDesc;

    /**
     * 建筑面积
     */
    private Double floorArea;

    /**
     * 套内面积
     */
    private Double interFloorArea;

    /**
     * 户型图url
     */
    private String fileUrl;

    private String fileName;

    /**
     * 创建时间
     */
    private java.util.Date createTime;

    private List<SenceResp> sences;

    public List<SenceResp> getSences() {
        return sences;
    }

    public void setSences(List<SenceResp> sences) {
        this.sences = sences;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(String typeNo) {
        this.typeNo = typeNo;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
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

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "FindTypeResp{" +
                "typeId='" + typeId + '\'' +
                ", typeNo='" + typeNo + '\'' +
                ", typeName='" + typeName + '\'' +
                ", typeDesc='" + typeDesc + '\'' +
                ", floorArea=" + floorArea +
                ", interFloorArea=" + interFloorArea +
                ", fileUrl='" + fileUrl + '\'' +
                ", fileName='" + fileName + '\'' +
                ", createTime=" + createTime +
                ", sences=" + sences +
                '}';
    }
}
