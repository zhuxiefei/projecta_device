package com.bdcourtyard.business.onlineHouse.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class OnlineHouseSimpleInfo implements Serializable {

    /**
     * 看房信息ID
     */
    private String onlineId;
    /**
     * 户型名称
     */
    private String houseType;
    /**
     * 发布人
     */
    private String adminId;
    /**
     * 发布时间
     */
    private Date createTime;
    /**
     * 附件ID
     */
    private String fileId;
    /**
     * 文件路径
     */
    private String fileUrl;

    @ApiModelProperty("看房信息ID")
    public String getOnlineId() {
        return onlineId;
    }
    @ApiModelProperty("看房信息ID")
    public void setOnlineId(String onlineId) {
        this.onlineId = onlineId;
    }
    @ApiModelProperty("看房类型")
    public String getHouseType() {
        return houseType;
    }
    @ApiModelProperty("看房类型")
    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }
    @ApiModelProperty("发布人名")
    public String getAdminId() {
        return adminId;
    }
    @ApiModelProperty("发布人名")
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
    @ApiModelProperty("创建时间")
    public Date getCreateTime() {
        return createTime;
    }
    @ApiModelProperty("创建时间")
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @ApiModelProperty("场景1图片的id")
    public String getFileId() {
        return fileId;
    }
    @ApiModelProperty("场景1图片的id")
    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
    @ApiModelProperty("场景1图片的url")
    public String getFileUrl() {
        return fileUrl;
    }
    @ApiModelProperty("场景1图片的url")
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
