package com.bdcourtyard.business.account.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *  EmployeeAccountRela
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16
 */
public class EmployeeAccountRela  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * 账号     
     */	
	private String acctName;

	/**
     * 物业人员ID
     */
	private String employeeId;

	/**
     * 创建时间
     */
	private java.util.Date createTime;



	/**
	 * @param acctName 账号
	 */
	@ApiModelProperty("账号")
	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}

	/**
	 * @return 账号
	 */
	@ApiModelProperty("账号")
	public String getAcctName() {
		return this.acctName;
	}

	/**
	 * @param employeeId 物业人员ID
	 */
	@ApiModelProperty("物业人员ID")
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return 物业人员ID
	 */
	@ApiModelProperty("物业人员ID")
	public String getEmployeeId() {
		return this.employeeId;
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
