package com.bdcourtyard.business.account.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 编辑账号入参
 * </p>
 * ClassName: UpdateAccountReq <br/>
 * Author: Xia.yx  <br/>
 * Date: 2017/12/4 18:44 <br/>
 * Version: 1.0 <br/>
 */
public class UpdateAccountReq {

    private String acctName;

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

    @ApiModelProperty("员工账号")
    public String getAcctName() {
        return acctName;
    }

    @ApiModelProperty("员工账号")
    public void setAcctName(String acctName) {
        this.acctName = acctName;
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
        final StringBuilder sb = new StringBuilder("UpdateAccountReq{");
        sb.append("acctName='").append(acctName).append('\'');
        sb.append(", isEnableAccount='").append(isEnableAccount).append('\'');
        sb.append(", roleId='").append(roleId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
