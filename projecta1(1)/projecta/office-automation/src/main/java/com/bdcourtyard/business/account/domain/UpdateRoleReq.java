package com.bdcourtyard.business.account.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 修改角色接口入参
 * </p>
 * ClassName: UpdateRoleReq <br/>
 * Author: xiayanxin  <br/>
 * Date: 2018/7/17 <br/>
 */
public class UpdateRoleReq {

    private String roleId;

    private String roleName;

    private String roleDesc;

    private String privilegeIds;

    @ApiModelProperty("角色ID")
    public String getRoleId() {
        return roleId;
    }

    @ApiModelProperty("角色ID")
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @ApiModelProperty("角色名称")
    public String getRoleName() {
        return roleName;
    }

    @ApiModelProperty("角色名称")
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @ApiModelProperty("角色描述")
    public String getRoleDesc() {
        return roleDesc;
    }

    @ApiModelProperty("角色描述")
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @ApiModelProperty("权限ID，多个中间以逗号隔开")
    public String getPrivilegeIds() {
        return privilegeIds;
    }

    @ApiModelProperty("权限ID，多个中间以逗号隔开")
    public void setPrivilegeIds(String privilegeIds) {
        this.privilegeIds = privilegeIds;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UpdateRoleReq{");
        sb.append("roleId=").append(roleId);
        sb.append(", roleName='").append(roleName).append('\'');
        sb.append(", roleDesc='").append(roleDesc).append('\'');
        sb.append(", privilegeIds='").append(privilegeIds).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
