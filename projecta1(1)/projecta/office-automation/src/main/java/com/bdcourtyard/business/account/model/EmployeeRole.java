package com.bdcourtyard.business.account.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *  EmployeeRole
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16
 */
public class EmployeeRole  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * 角色ID     
     */	
	private String roleId;

	/**
     * 角色名称
     */
	private String roleName;

	/**
     * 角色描述
     */
	private String roleDesc;

	/**
     * 角色创建时间
     */
	private java.util.Date createTime;

	/**
     * 楼盘id
     */
	private String estateId;



	/**
	 * @param roleId 角色ID
	 */
	@ApiModelProperty("角色ID")
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return 角色ID
	 */
	@ApiModelProperty("角色ID")
	public String getRoleId() {
		return this.roleId;
	}

	/**
	 * @param roleName 角色名称
	 */
	@ApiModelProperty("角色名称")
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return 角色名称
	 */
	@ApiModelProperty("角色名称")
	public String getRoleName() {
		return this.roleName;
	}

	/**
	 * @param roleDesc 角色描述
	 */
	@ApiModelProperty("角色描述")
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	/**
	 * @return 角色描述
	 */
	@ApiModelProperty("角色描述")
	public String getRoleDesc() {
		return this.roleDesc;
	}

	/**
	 * @param createTime 角色创建时间
	 */
	@ApiModelProperty("角色创建时间")
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return 角色创建时间
	 */
	@ApiModelProperty("角色创建时间")
	public java.util.Date getCreateTime() {
		return this.createTime;
	}


	/**
	 * @param estateId 楼盘id
	 */
	@ApiModelProperty("楼盘id")
	public void setEstateId(String estateId) {
		this.estateId = estateId;
	}

	/**
	 * @return 楼盘id
	 */
	@ApiModelProperty("楼盘id")
	public String getEstateId() {
		return this.estateId;
	}
}
