package com.bdcourtyard.business.device.vo;

import java.io.Serializable;

/**
 * @author zhuxiefei
 * @date 2018/8/13 13:48
 */
public class EquipmentRepairRecordResponse implements Serializable{
    private static final long serialVersionUID = 1L;

    private String equipmentId;

    private String equipmentNo;

    private String equipmentName;

    private String equipmentType;

    private String equipmentLocation;

    private String recordId;

    private String repairTime;

    private String equipmentOperator;

    private String operatorPhone;

    private String repairDesc;

    private String repairExpense;

    private String qualityPeriod;

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

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getEquipmentLocation() {
        return equipmentLocation;
    }

    public void setEquipmentLocation(String equipmentLocation) {
        this.equipmentLocation = equipmentLocation;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(String repairTime) {
        this.repairTime = repairTime;
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

    public String getRepairDesc() {
        return repairDesc;
    }

    public void setRepairDesc(String repairDesc) {
        this.repairDesc = repairDesc;
    }

    public String getRepairExpense() {
        return repairExpense;
    }

    public void setRepairExpense(String repairExpense) {
        this.repairExpense = repairExpense;
    }

    public String getQualityPeriod() {
        return qualityPeriod;
    }

    public void setQualityPeriod(String qualityPeriod) {
        this.qualityPeriod = qualityPeriod;
    }

    public String getEstateId() {
        return estateId;
    }

    public void setEstateId(String estateId) {
        this.estateId = estateId;
    }
}