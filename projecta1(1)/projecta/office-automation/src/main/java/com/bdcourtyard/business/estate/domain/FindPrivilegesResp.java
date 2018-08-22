package com.bdcourtyard.business.estate.domain;

import com.bdcourtyard.business.account.model.EmployeePrivilege;

import java.util.List;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-19 10:09
 * @Description:
 */
public class FindPrivilegesResp {

    private List<EmployeePrivilege> privilegeList;

    private String employeeId;

    public List<EmployeePrivilege> getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(List<EmployeePrivilege> privilegeList) {
        this.privilegeList = privilegeList;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "FindPrivilegesResp{" +
                "privilegeList=" + privilegeList +
                ", employeeId='" + employeeId + '\'' +
                '}';
    }
}
