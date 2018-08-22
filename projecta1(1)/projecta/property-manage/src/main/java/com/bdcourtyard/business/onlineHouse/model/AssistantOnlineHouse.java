package com.bdcourtyard.business.onlineHouse.model;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
/**
 *  AssistantOnlineHouse
 *
 * @version : Ver 1.0
 * @date	: 2018-7-17
 */
public class AssistantOnlineHouse  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
	private java.util.Date createTime;
	
	/**
     * 楼盘ID     
     */	
	private String estateId;

	public AssistantOnlineHouse() {
	}

	public AssistantOnlineHouse(String onlineId, String houseType, String adminId, Date createTime, String estateId) {
		this.onlineId = onlineId;
		this.houseType = houseType;
		this.adminId = adminId;
		this.createTime = createTime;
		this.estateId = estateId;
	}

	/**
	 * @param onlineId 看房信息ID
	 */
	@ApiModelProperty("看房信息ID")
	public void setOnlineId(String onlineId) {
		this.onlineId = onlineId;
	}
	
	/**
	 * @return 看房信息ID
	 */
	@ApiModelProperty("看房信息ID")
	public String getOnlineId() {
		return this.onlineId;
	}
	
	/**
	 * @param houseType 户型名称
	 */
	@ApiModelProperty("户型名称")
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
	
	/**
	 * @return 户型名称
	 */
	@ApiModelProperty("户型名称")
	public String getHouseType() {
		return this.houseType;
	}
	
	/**
	 * @param adminId 发布人
	 */
	@ApiModelProperty("发布人")
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	
	/**
	 * @return 发布人
	 */
	@ApiModelProperty("发布人")
	public String getAdminId() {
		return this.adminId;
	}
	
	/**
	 * @param createTime 发布时间
	 */
	@ApiModelProperty("发布时间")
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * @return 发布时间
	 */
	@ApiModelProperty("发布时间")
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	 
	
	/**
	 * @param estateId 楼盘ID
	 */
	@ApiModelProperty("楼盘ID")
	public void setEstateId(String estateId) {
		this.estateId = estateId;
	}
	
	/**
	 * @return 楼盘ID
	 */
	@ApiModelProperty("楼盘ID")
	public String getEstateId() {
		return this.estateId;
	}
}
