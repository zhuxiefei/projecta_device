package com.bdcourtyard.business.account.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *  EmployeeAccount
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16
 */
public class EmployeeAccount  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * 账号     
     */	
	private String acctName;

	/**
     * 密码
     */
	private String password;

	/**
     * 密码是否需要重新修改：1：不需要2：需要
     */
	private int isInit;

	/**
     * 管理员最后一次登录时间
     */
	private java.util.Date lastLoginTime;

	/**
     * 管理员最后一次登录IP
     */
	private String lastLoginIp;

	/**
     * 账号创建时间
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
	 * @param password 密码
	 */
	@ApiModelProperty("密码")
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return 密码
	 */
	@ApiModelProperty("密码")
	public String getPassword() {
		return this.password;
	}

	/**
	 * @param isInit 密码是否需要重新修改：1：不需要2：需要
	 */
	@ApiModelProperty("密码是否需要重新修改：1：不需要2：需要")
	public void setIsInit(int isInit) {
		this.isInit = isInit;
	}

	/**
	 * @return 密码是否需要重新修改：1：不需要2：需要
	 */
	@ApiModelProperty("密码是否需要重新修改：1：不需要2：需要")
	public int getIsInit() {
		return this.isInit;
	}

	/**
	 * @param lastLoginTime 管理员最后一次登录时间
	 */
	@ApiModelProperty("管理员最后一次登录时间")
	public void setLastLoginTime(java.util.Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * @return 管理员最后一次登录时间
	 */
	@ApiModelProperty("管理员最后一次登录时间")
	public java.util.Date getLastLoginTime() {
		return this.lastLoginTime;
	}


	/**
	 * @param lastLoginIp 管理员最后一次登录IP
	 */
	@ApiModelProperty("管理员最后一次登录IP")
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	/**
	 * @return 管理员最后一次登录IP
	 */
	@ApiModelProperty("管理员最后一次登录IP")
	public String getLastLoginIp() {
		return this.lastLoginIp;
	}
	
	/**
	 * @param createTime 账号创建时间
	 */
	@ApiModelProperty("账号创建时间")
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * @return 账号创建时间
	 */
	@ApiModelProperty("账号创建时间")
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	 
}
