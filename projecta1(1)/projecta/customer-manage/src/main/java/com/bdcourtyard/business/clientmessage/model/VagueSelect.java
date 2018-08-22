package com.bdcourtyard.business.clientmessage.model;

import io.swagger.annotations.ApiModelProperty;

public class VagueSelect {
    /**
     * 客户编号
     */
    private String clientId;

    /**
     * 客户姓名
     */
    private String clientName;

    /**
     * 联系电话
     */
    private String clientPhone;

    /**
     * 客户状态
     */
    private Integer clientState;

    /**
     * 是否成交
     */
    private Integer bargain;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    @ApiModelProperty("客户编号")
    public String getClientId() {
        return clientId;
    }
    @ApiModelProperty("客户编号")
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    @ApiModelProperty("客户姓名")
    public String getClientName() {
        return clientName;
    }
    @ApiModelProperty("客户姓名")
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    @ApiModelProperty("联系电话")
    public String getClientPhone() {
        return clientPhone;
    }
    @ApiModelProperty("联系电话")
    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }
    @ApiModelProperty("客户状态 1.意向客户 2.来访客户 3.无效客户")
    public Integer getClientState() {
        return clientState;
    }
    @ApiModelProperty("客户状态 1.意向客户 2.来访客户 3.无效客户")
    public void setClientState(Integer clientState) {
        this.clientState = clientState;
    }
    @ApiModelProperty("是否成交 1.是 2.否")
    public Integer getBargain() {
        return bargain;
    }
    @ApiModelProperty("是否成交 1.是 2.否")
    public void setBargain(Integer bargain) {
        this.bargain = bargain;
    }
    @ApiModelProperty("开始时间")
    public String getStartTime() {
        return startTime;
    }
    @ApiModelProperty("开始时间")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    @ApiModelProperty("结束时间")
    public String getEndTime() {
        return endTime;
    }
    @ApiModelProperty("结束时间")
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
