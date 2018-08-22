package com.bdcourtyard.business.account.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 新增账号入参
 * </p>
 * ClassName: AddAccountReq <br/>
 * Author: Xia.yx  <br/>
 * Date: 2017/12/4 17:10 <br/>
 * Version: 1.0 <br/>
 */
public class AddAccountReq {

    private String empId;

    /**
     * 是否启用账号登录：1为正常,0为禁止登陆
     */
    private String isEnableAccount;

    private String roleId;

    @ApiModelProperty("角色ID")
    public String getRoleId() {
        return roleId;
    }

    @ApiModelProperty("角色ID")
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @ApiModelProperty("员工ID")
    public String getEmpId() {
        return empId;
    }

    @ApiModelProperty("员工ID")
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    @ApiModelProperty("是否启用账号：1为启用 0为未启用")
    public String getIsEnableAccount() {
        return isEnableAccount;
    }

    @ApiModelProperty("是否启用账号：1为启用 0为未启用")
    public void setIsEnableAccount(String isEnableAccount) {
        this.isEnableAccount = isEnableAccount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AddAccountReq{");
        sb.append("empId='").append(empId).append('\'');
        sb.append(", isEnableAccount='").append(isEnableAccount).append('\'');
        sb.append(", roleId='").append(roleId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
