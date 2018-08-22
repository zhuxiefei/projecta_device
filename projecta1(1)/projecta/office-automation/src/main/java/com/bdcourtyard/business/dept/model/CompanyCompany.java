package com.bdcourtyard.business.dept.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *  CompanyCompany
 *
 * @version : Ver 1.0
 * @date	: 2018-7-13
 */
public class CompanyCompany  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * 企业ID     
     */	
	private String companyId;

	/**
     * 企业名称
     */
	private String companyName;

	/**
     * 创建时间
     */
	private java.util.Date createTime;

	/**
     * 更新时间
     */
	private java.util.Date updateTime;



	/**
	 * @param companyId 企业ID
	 */
	@ApiModelProperty("企业ID")
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return 企业ID
	 */
	@ApiModelProperty("企业ID")
	public String getCompanyId() {
		return this.companyId;
	}

	/**
	 * @param companyName 企业名称
	 */
	@ApiModelProperty("企业名称")
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return 企业名称
	 */
	@ApiModelProperty("企业名称")
	public String getCompanyName() {
		return this.companyName;
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
	 
	
	/**
	 * @param updateTime 更新时间
	 */
	@ApiModelProperty("更新时间")
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
	
	/**
	 * @return 更新时间
	 */
	@ApiModelProperty("更新时间")
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}
	 
}
