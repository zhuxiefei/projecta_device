package com.bdcourtyard.business.account.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-17 19:53
 * @Description:
 */
public class DeleteRoleReq {

    private String roleId;

    @ApiModelProperty("角色ID")
    public String getRoleId() {
        return roleId;
    }

    @ApiModelProperty("角色ID")
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RoleIdReq{");
        sb.append("roleId=").append(roleId);
        sb.append('}');
        return sb.toString();
    }
}
