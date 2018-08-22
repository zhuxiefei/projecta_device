package com.bdcourtyard.business.device.model;

import java.io.Serializable;

/**
 * @author zhuxiefei
 * @date 2018/8/9 19:13
 */
public class EquipmentRepairRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    private String recordId;

    private String equipmentId;

    private String equipmentOperator;

    private String operatorPhone;

    private String repairDesc;

    private String repairExpense;

    private String repairTime;

    private String qualityPeriod;

    private String createTime;

    private String updateTime;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
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

    public String getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(String repairTime) {
        this.repairTime = repairTime;
    }

    public String getQualityPeriod() {
        return qualityPeriod;
    }

    public void setQualityPeriod(String qualityPeriod) {
        this.qualityPeriod = qualityPeriod;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }



}