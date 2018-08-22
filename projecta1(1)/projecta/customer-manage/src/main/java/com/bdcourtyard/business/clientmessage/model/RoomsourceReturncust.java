package com.bdcourtyard.business.clientmessage.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *  RoomsourceReturncust
 *
 * @version : Ver 1.0
 * @date	: 2018-7-26
 */
public class RoomsourceReturncust implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * 回访ID     
     */	
	private String returnId;

	/**
     * 回访编号
     */
	private String returnNo;

	/**
     * 回访时间
     */
	private java.util.Date returnTime;

	/**
     * 回访客户ID
     */
	private String clientId;

	/**
     * 顾问ID
     */
	private String counselor;

	/**
     * 创建时间
     */
	private java.util.Date createTime;



	/**
	 * @param returnId 回访ID
	 */
	@ApiModelProperty("回访ID")
	public void setReturnId(String returnId) {
		this.returnId = returnId;
	}

	/**
	 * @return 回访ID
	 */
	@ApiModelProperty("回访ID")
	public String getReturnId() {
		return this.returnId;
	}

	/**
	 * @param returnNo 回访编号
	 */
	@ApiModelProperty("回访编号")
	public void setReturnNo(String returnNo) {
		this.returnNo = returnNo;
	}

	/**
	 * @return 回访编号
	 */
	@ApiModelProperty("回访编号")
	public String getReturnNo() {
		return this.returnNo;
	}

	/**
	 * @param returnTime 回访时间
	 */
	@ApiModelProperty("回访时间")
	public void setReturnTime(java.util.Date returnTime) {
		this.returnTime = returnTime;
	}

	/**
	 * @return 回访时间
	 */
	@ApiModelProperty("回访时间")
	public java.util.Date getReturnTime() {
		return this.returnTime;
	}


	/**
	 * @param clientId 回访客户ID
	 */
	@ApiModelProperty("回访客户ID")
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return 回访客户ID
	 */
	@ApiModelProperty("回访客户ID")
	public String getClientId() {
		return this.clientId;
	}

	/**
	 * @param counselor 顾问ID
	 */
	@ApiModelProperty("顾问ID")
	public void setCounselor(String counselor) {
		this.counselor = counselor;
	}

	/**
	 * @return 顾问ID
	 */
	@ApiModelProperty("顾问ID")
	public String getCounselor() {
		return this.counselor;
	}
	
	/**
	 * @param createTime 创建时间
	 */
	@ApiModelProperty("创建时间")
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * @return 创建时间
	 */
	@ApiModelProperty("创建时间")
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	 
}
