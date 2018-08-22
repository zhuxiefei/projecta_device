package com.bdcourtyard.business.device.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhuxiefei
 * @date 2018/8/7 15:34
 */
public class PatrolEquipment implements Serializable{
    private static final long serialVersionUID = 1L;

    private String equipmentId;

    private String equipmentNo;

    private String equipmentType;

    private String equipmentName;

    private String equipmentLocation;

    private String equipmentQRCode;

    private String equipmentDesc;

    private Integer isCheck;

    private Integer checkCycle;

    private String equipmentCreateTime;

    private String qualityPeriod;

    private String deadline;

    private String equipmentProducer;

    private String producerPhone;

    private String equipmentOperator;

    private String operatorPhone;

    private Integer repairNumber;

    private Date createTime;

    private Date updateTime;

    private Integer unit;

    private String estateId;

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentNo() {
        return equipmentNo;
    }

    public void setEquipmentNo(String equipmentNo) {
        this.equipmentNo = equipmentNo;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentLocation() {
        return equipmentLocation;
    }

    public void setEquipmentLocation(String equipmentLocation) {
        this.equipmentLocation = equipmentLocation;
    }

    public String getEquipmentQRCode() {
        return equipmentQRCode;
    }

    public void setEquipmentQRCode(String equipmentQRCode) {
        this.equipmentQRCode = equipmentQRCode;
    }

    public String getEquipmentDesc() {
        return equipmentDesc;
    }

    public void setEquipmentDesc(String equipmentDesc) {
        this.equipmentDesc = equipmentDesc;
    }

    public Integer getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Integer isCheck) {
        this.isCheck = isCheck;
    }

    public Integer getCheckCycle() {
        return checkCycle;
    }

    public void setCheckCycle(Integer checkCycle) {
        this.checkCycle = checkCycle;
    }

    public String getEquipmentCreateTime() {
        return equipmentCreateTime;
    }

    public void setEquipmentCreateTime(String equipmentCreateTime) {
        this.equipmentCreateTime = equipmentCreateTime;
    }

    public String getQualityPeriod() {
        return qualityPeriod;
    }

    public void setQualityPeriod(String qualityPeriod) {
        this.qualityPeriod = qualityPeriod;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getEquipmentProducer() {
        return equipmentProducer;
    }

    public void setEquipmentProducer(String equipmentProducer) {
        this.equipmentProducer = equipmentProducer;
    }

    public String getProducerPhone() {
        return producerPhone;
    }

    public void setProducerPhone(String producerPhone) {
        this.producerPhone = producerPhone;
    }

    public String getEquipmentOperator() {
        return equipmentOperator;
    }

    public void setEquipmentOperator(String equipmentOperator) {
        this.equipmentOperator = equipmentOperator;
    }

    public String getOperatorPhone() {
        return operatorPhone;
    }

    public void setOperatorPhone(String operatorPhone) {
        this.operatorPhone = operatorPhone;
    }

    public Integer getRepairNumber() {
        return repairNumber;
    }

    public void setRepairNumber(Integer repairNumber) {
        this.repairNumber = repairNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public String getEstateId() {
        return estateId;
    }

    public void setEstateId(String estateId) {
        this.estateId = estateId;
    }

    @Override
    public String toString() {
        return "PatrolEquipment{" +
                "equipmentId='" + equipmentId + '\'' +
                ", equipmentNo='" + equipmentNo + '\'' +
                ", equipmentType='" + equipmentType + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", equipmentLocation='" + equipmentLocation + '\'' +
                ", equipmentQRCode='" + equipmentQRCode + '\'' +
                ", equipmentDesc='" + equipmentDesc + '\'' +
                ", isCheck='" + isCheck + '\'' +
                ", checkCycle='" + checkCycle + '\'' +
                ", equipmentCreateTime='" + equipmentCreateTime + '\'' +
                ", qualityPeriod='" + qualityPeriod + '\'' +
                ", deadline='" + deadline + '\'' +
                ", equipmentProducer='" + equipmentProducer + '\'' +
                ", producerPhone='" + producerPhone + '\'' +
                ", equipmentOperator='" + equipmentOperator + '\'' +
                ", operatorPhone='" + operatorPhone + '\'' +
                ", repairNumber='" + repairNumber + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", unit='" + unit + '\'' +
                ", estateId='" + estateId + '\'' +
                '}';
    }


}