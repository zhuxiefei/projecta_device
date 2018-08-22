package com.bdcourtyard.business.account.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *  EmployeeRolePrivilegeRela
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16
 */
public class EmployeeRolePrivilegeRela  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * 关系ID     
     */	
	private String rpRela;

	/**
     * 角色ID
     */
	private String roleId;

	/**
     * 权限ID
     */
	private String privilegeId;

	/**
     * 关系创建时间
     */
	private java.util.Date createTime;



	/**
	 * @param rpRela 关系ID
	 */
	@ApiModelProperty("关系ID")
	public void setRpRela(String rpRela) {
		this.rpRela = rpRela;
	}

	/**
	 * @return 关系ID
	 */
	@ApiModelProperty("关系ID")
	public String getRpRela() {
		return this.rpRela;
	}

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
	 * @param privilegeId 权限ID
	 */
	@ApiModelProperty("权限ID")
	public void setPrivilegeId(String privilegeId) {
		this.privilegeId = privilegeId;
	}

	/**
	 * @return 权限ID
	 */
	@ApiModelProperty("权限ID")
	public String getPrivilegeId() {
		return this.privilegeId;
	}
	
	/**
	 * @param createTime 关系创建时间
	 */
	@ApiModelProperty("关系创建时间")
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * @return 关系创建时间
	 */
	@ApiModelProperty("关系创建时间")
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	 
}
