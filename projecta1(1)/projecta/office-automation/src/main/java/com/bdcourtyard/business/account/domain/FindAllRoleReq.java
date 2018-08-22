package com.bdcourtyard.business.account.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-19 21:32
 * @Description:
 */
public class FindAllRoleReq {

    private String roleName;

    @ApiModelProperty("角色名称")
    public String getRoleName() {
        return roleName;
    }

    @ApiModelProperty("角色名称")
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "FindAllRoleReq{" +
                "roleName='" + roleName + '\'' +
                '}';
    }
}
