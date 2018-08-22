package com.bdcourtyard.business.account.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-18 15:05
 * @Description:
 */
public class AddRoleReq {

    private String roleName;

    private String roleDesc;

    private String privilegeIds;

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
        return "AddRoleReq{" +
                "roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", privilegeIds='" + privilegeIds + '\'' +
                '}';
    }
}
