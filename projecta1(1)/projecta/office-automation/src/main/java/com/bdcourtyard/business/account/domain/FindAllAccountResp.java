package com.bdcourtyard.business.account.domain;

import java.util.Date;

/**
 * <p>
 * 查询账号列表回参
 * </p>
 * ClassName: FindAllAccountResp <br/>
 * Author: Xia.yx  <br/>
 * Date: 2017/12/4 19:43 <br/>
 * Version: 1.0 <br/>
 */
public class FindAllAccountResp {

    private String acctName;

    private String empNo;

    private String empName;

    private String depName;

    private String positionName;

    private Date createTime;

    private Integer isEnableAccount;

    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsEnableAccount() {
        return isEnableAccount;
    }

    public void setIsEnableAccount(Integer isEnableAccount) {
        this.isEnableAccount = isEnableAccount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FindAllAccountResp{");
        sb.append("acctName='").append(acctName).append('\'');
        sb.append(", empNo='").append(empNo).append('\'');
        sb.append(", empName='").append(empName).append('\'');
        sb.append(", depName='").append(depName).append('\'');
        sb.append(", positionName='").append(positionName).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", isEnableAccount=").append(isEnableAccount);
        sb.append(", roleName='").append(roleName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
