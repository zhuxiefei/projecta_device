package com.bdcourtyard.business.clientmessage.model;

import io.swagger.annotations.ApiModelProperty;

public class VagueSelectValidClient {

    /**
     * 需回访时间id
     * 1.当天 2.最近三天 3.最近一周 4.最近十五天 5.最近一个月
     */
    private Integer returnTimeId;

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
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    @ApiModelProperty("需回访时间id 1.当天 2.最近三天 3.最近一周 4.最近十五天 5.最近一个月")
    public Integer getReturnTimeId() {
        return returnTimeId;
    }
    @ApiModelProperty("需回访时间id 1.当天 2.最近三天 3.最近一周 4.最近十五天 5.最近一个月")
    public void setReturnTimeId(Integer returnTimeId) {
        this.returnTimeId = returnTimeId;
    }
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
    @ApiModelProperty("客户联系方式")
    public String getClientPhone() {
        return clientPhone;
    }
    @ApiModelProperty("客户联系方式")
    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
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
