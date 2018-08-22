package com.bdcourtyard.business.clientmessage.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *  ClientNeedreturn
 *
 * @version : Ver 1.0
 * @date	: 2018-7-26
 */
public class ClientNeedreturn implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * 需回访ID     
     */	
	private String needId;

	/**
     * 客户ID
     */
	private String clientId;

	/**
     * 需回访时间
     */
	private String needreturnTime;

	/**
     * 创建时间
     */
	private java.util.Date createTime;



	/**
	 * @param needId 需回访ID
	 */
	@ApiModelProperty("需回访ID")
	public void setNeedId(String needId) {
		this.needId = needId;
	}

	/**
	 * @return 需回访ID
	 */
	@ApiModelProperty("需回访ID")
	public String getNeedId() {
		return this.needId;
	}

	/**
	 * @param clientId 客户ID
	 */
	@ApiModelProperty("客户ID")
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return 客户ID
	 */
	@ApiModelProperty("客户ID")
	public String getClientId() {
		return this.clientId;
	}
	
	/**
	 * @param needreturnTime 需回访时间
	 */
	@ApiModelProperty("需回访时间")
	public void setNeedreturnTime(String needreturnTime) {
		this.needreturnTime = needreturnTime;
	}
	
	/**
	 * @return 需回访时间
	 */
	@ApiModelProperty("需回访时间")
	public String getNeedreturnTime() {
		return this.needreturnTime;
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
