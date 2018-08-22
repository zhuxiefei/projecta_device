package com.bdcourtyard.business.device.vo;

import java.io.Serializable;

/** 
* @Description:
* @Param:  
* @return:  
*/ 
public class EquipmentRepairRecordDetail implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 记录ID
     */
    private String recordId;

    /**
     * 设备ID
     */
    private String equipmentId;

    /**
     * 维修厂商
     */
    private String equipmentOperator;

    /**
     * 维修厂商电话
     */
    private String operatorPhone;

    /**
     * 维修内容
     */
    private String repairDesc;

    /**
     * 维修费用
     */
    private String repairExpense;
    /**
     * 质保期值
     */
    private String qualityPeriod;

    /**
     * 维修日期
     */
    private String repairTime;



    /**
     * 设备编号
     */
    private String equipmentNo;

    /**
     * 设备类型ID
     */
    private String equipmentType;


    /**
     * 设备名称
     */
    private String equipmentName;

    /**
     * 设备位置
     */
    private String equipmentLocation;

    /**
     * 是否需要巡检 1代表需要 2代表不需要
     */
    private Integer isCheck;

    /**
     * 设备生产日期
     */
    private String equipmentCreateTime;


    /**
     * 质保期（格式：数值,日期单位）
     */
    private String qualityPeriodDevice;

    /**
     * 报修截止日期
     */
    private String deadline;

    /**
     * 设备生产厂商
     */
    private String equipmentProducer;

    /**
     * 生产厂商电话
     */
    private String producerPhone;

    /**
     * 单位
     */
    private int unit;


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

    public String getQualityPeriod() {
        return qualityPeriod;
    }

    public void setQualityPeriod(String qualityPeriod) {
        this.qualityPeriod = qualityPeriod;
    }

    public String getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(String repairTime) {
        this.repairTime = repairTime;
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

    public Integer getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Integer isCheck) {
        this.isCheck = isCheck;
    }

    public String getEquipmentCreateTime() {
        return equipmentCreateTime;
    }

    public void setEquipmentCreateTime(String equipmentCreateTime) {
        this.equipmentCreateTime = equipmentCreateTime;
    }

    public String getQualityPeriodDevice() {
        return qualityPeriodDevice;
    }

    public void setQualityPeriodDevice(String qualityPeriodDevice) {
        this.qualityPeriodDevice = qualityPeriodDevice;
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

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }
}
