package com.bdcourtyard.business.account.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *  EmployeePrivilege
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16
 */
public class EmployeePrivilege  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * 权限ID     
     */	
	private String privilegeId;

	/**
     * 权限名称
     */
	private String privilegeName;

	/**
     * 权限描述
     */
	private String privilegeDesc;

	/**
     * 父权限ID
     */
	private String parentId;

	/**
     * 权限类型：1为菜单，2为按钮，3为接口
     */
	private Integer privilegeType;

	/**
     * 权限创建时间
     */
	private java.util.Date createTime;



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
	 * @param privilegeName 权限名称
	 */
	@ApiModelProperty("权限名称")
	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	/**
	 * @return 权限名称
	 */
	@ApiModelProperty("权限名称")
	public String getPrivilegeName() {
		return this.privilegeName;
	}

	/**
	 * @param privilegeDesc 权限描述
	 */
	@ApiModelProperty("权限描述")
	public void setPrivilegeDesc(String privilegeDesc) {
		this.privilegeDesc = privilegeDesc;
	}

	/**
	 * @return 权限描述
	 */
	@ApiModelProperty("权限描述")
	public String getPrivilegeDesc() {
		return this.privilegeDesc;
	}

	/**
	 * @param parentId 父权限ID
	 */
	@ApiModelProperty("父权限ID")
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return 父权限ID
	 */
	@ApiModelProperty("父权限ID")
	public String getParentId() {
		return this.parentId;
	}

	/**
	 * @param privilegeType 权限类型：1为菜单，2为按钮，3为接口
	 */
	@ApiModelProperty("权限类型：1为菜单，2为按钮，3为接口")
	public void setPrivilegeType(Integer privilegeType) {
		this.privilegeType = privilegeType;
	}

	/**
	 * @return 权限类型：1为菜单，2为按钮，3为接口
	 */
	@ApiModelProperty("权限类型：1为菜单，2为按钮，3为接口")
	public Integer getPrivilegeType() {
		return this.privilegeType;
	}
	
	/**
	 * @param createTime 权限创建时间
	 */
	@ApiModelProperty("权限创建时间")
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * @return 权限创建时间
	 */
	@ApiModelProperty("权限创建时间")
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	 
}
