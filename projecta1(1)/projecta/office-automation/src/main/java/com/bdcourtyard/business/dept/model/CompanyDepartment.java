package com.bdcourtyard.business.dept.model;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;

import java.io.Serializable;

/**
 *  CompanyDepartment
 *
 * @version : Ver 1.0
 * @date	: 2018-7-13
 */
public class CompanyDepartment  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * 部门ID     
     */	
	private String departmentId;

	/**
     * 公司id
     */
	private String companyId;

	/**
     * 部门名称
     */
	private String departmentName;

	/**
     * 部门描述
     */
	private String departmentDesc;

	/**
     * 上级部门，UUID
     */
	private String parentDepartment;

	/**
     * 创建时间
     */
	private java.util.Date createTime;

	/**
     * 修改时间
     */
	private java.util.Date updateTime;

	/**
     * 规则ID
     */
	private String depId;

	/**
     * 层级深度
     */
	private Integer depth;

	/**
     * 所属楼盘ID
     */
	private String estateId;



	/**
	 * @param departmentId 部门ID
	 */
	@ApiModelProperty("部门ID")
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @return 部门ID
	 */
	@ApiModelProperty("部门ID")
	public String getDepartmentId() {
		return this.departmentId;
	}

	/**
	 * @param companyId 公司id
	 */
	@ApiModelProperty("公司id")
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return 公司id
	 */
	@ApiModelProperty("公司id")
	public String getCompanyId() {
		return this.companyId;
	}

	/**
	 * @param departmentName 部门名称
	 */
	@ApiModelProperty("部门名称")
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * @return 部门名称
	 */
	@ApiModelProperty("部门名称")
	public String getDepartmentName() {
		return this.departmentName;
	}

	/**
	 * @param departmentDesc 部门描述
	 */
	@ApiModelProperty("部门描述")
	public void setDepartmentDesc(String departmentDesc) {
		this.departmentDesc = departmentDesc;
	}

	/**
	 * @return 部门描述
	 */
	@ApiModelProperty("部门描述")
	public String getDepartmentDesc() {
		return this.departmentDesc;
	}

	/**
	 * @param parentDepartment 上级部门，UUID
	 */
	@ApiModelProperty("上级部门，UUID")
	public void setParentDepartment(String parentDepartment) {
		this.parentDepartment = parentDepartment;
	}

	/**
	 * @return 上级部门，UUID
	 */
	@ApiModelProperty("上级部门，UUID")
	public String getParentDepartment() {
		return this.parentDepartment;
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
	 * @param updateTime 修改时间
	 */
	@ApiModelProperty("修改时间")
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return 修改时间
	 */
	@ApiModelProperty("修改时间")
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}


	/**
	 * @param depId 规则ID
	 */
	@ApiModelProperty("规则ID")
	public void setDepId(String depId) {
		this.depId = depId;
	}

	/**
	 * @return 规则ID
	 */
	@ApiModelProperty("规则ID")
	public String getDepId() {
		return this.depId;
	}

	/**
	 * @param depth 层级深度
	 */
	@ApiModelProperty("层级深度")
	public void setDepth(Integer depth) {
		this.depth = depth;
	}

	/**
	 * @return 层级深度
	 */
	@ApiModelProperty("层级深度")
	public Integer getDepth() {
		return this.depth;
	}

	/**
	 * @param estateId 所属楼盘ID
	 */
	@ApiModelProperty("所属楼盘ID")
	public void setEstateId(String estateId) {
		this.estateId = estateId;
	}

	/**
	 * @return 所属楼盘ID
	 */
	@ApiModelProperty("所属楼盘ID")
	public String getEstateId() {
		return this.estateId;
	}
}
