package com.bdcourtyard.business.account.domain;

import com.bdcourtyard.business.account.model.EmployeeRole;

/**
 * <p>
 * 查询账号详情回参
 * </p>
 * ClassName: FindAccountResp <br/>
 * Author: Xia.yx  <br/>
 * Date: 2017/12/4 19:27 <br/>
 * Version: 1.0 <br/>
 */
public class FindAccountResp {

    private String acctName;

    private Integer isEnableAccount;

    private EmployeeRole employeeRole;

    public EmployeeRole getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public Integer getIsEnableAccount() {
        return isEnableAccount;
    }

    public void setIsEnableAccount(Integer isEnableAccount) {
        this.isEnableAccount = isEnableAccount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FindAccountResp{");
        sb.append("acctName='").append(acctName).append('\'');
        sb.append(", isEnableAccount=").append(isEnableAccount);
        sb.append(", employeeRole=").append(employeeRole);
        sb.append('}');
        return sb.toString();
    }
}
