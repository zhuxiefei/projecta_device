package com.bdcourtyard.business.subscription.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/29.
 */
public class SubInformatiomVo implements Serializable {



    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 认购ID
     */
    private String subscriptionId;

    /**
     * 房屋ID
     */
    private String houseId;



    private String clientId;
    /**
     * 合同姓名
     */
    private String contractName;

    /**
     * 身份证号码
     */
    private String idCard;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 成交房号
     */
    private String bargainRoom;

    /**
     * 面积
     */
    private String subscriptionArea;

    /**
     * 成交单价
     */
    private String bargainPrice;

    /**
     * 认购日期
     */
    private String subscriptionTime;

    /**
     * 签约日期
     */
    private String contractTime;

    /**
     * 付款方式
     */
    private int payment;

    /**
     * 成交总价
     */
    private String bargainTotal;

    /**
     * 定金
     */
    private String handsel;

    /**
     * 合同时效
     */
    private String agreementTime;

    /**
     * 首付款金额
     */
    private String firstPay;

    /**
     * 余额
     */
    private String balance;

    /**
     * 办理银行按揭时间
     */
    private String processsingTime;

    /**
     * 资料
     */
    private String datum;

    /**
     * 催款及办理记录
     */
    private String records;

    /**
     * 特别注意事项
     */
    private String attention;

    private String estateId;

    private String employeeId;

    private int status;
    /**
     * 创建时间
     */
    private Date createTime;

    private String datumOther;


    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBargainRoom() {
        return bargainRoom;
    }

    public void setBargainRoom(String bargainRoom) {
        this.bargainRoom = bargainRoom;
    }

    public String getSubscriptionArea() {
        return subscriptionArea;
    }

    public void setSubscriptionArea(String subscriptionArea) {
        this.subscriptionArea = subscriptionArea;
    }

    public String getBargainPrice() {
        return bargainPrice;
    }

    public void setBargainPrice(String bargainPrice) {
        this.bargainPrice = bargainPrice;
    }

    public String getSubscriptionTime() {
        return subscriptionTime;
    }

    public void setSubscriptionTime(String subscriptionTime) {
        this.subscriptionTime = subscriptionTime;
    }

    public String getContractTime() {
        return contractTime;
    }

    public void setContractTime(String contractTime) {
        this.contractTime = contractTime;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public String getBargainTotal() {
        return bargainTotal;
    }

    public void setBargainTotal(String bargainTotal) {
        this.bargainTotal = bargainTotal;
    }

    public String getHandsel() {
        return handsel;
    }

    public void setHandsel(String handsel) {
        this.handsel = handsel;
    }

    public String getAgreementTime() {
        return agreementTime;
    }

    public void setAgreementTime(String agreementTime) {
        this.agreementTime = agreementTime;
    }

    public String getFirstPay() {
        return firstPay;
    }

    public void setFirstPay(String firstPay) {
        this.firstPay = firstPay;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getProcesssingTime() {
        return processsingTime;
    }

    public void setProcesssingTime(String processsingTime) {
        this.processsingTime = processsingTime;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getRecords() {
        return records;
    }

    public void setRecords(String records) {
        this.records = records;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDatumOther() {
        return datumOther;
    }

    public void setDatumOther(String datumOther) {
        this.datumOther = datumOther;
    }
}
