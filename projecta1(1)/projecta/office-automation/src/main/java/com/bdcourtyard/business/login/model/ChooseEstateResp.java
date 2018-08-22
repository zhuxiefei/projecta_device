package com.bdcourtyard.business.login.model;

import com.bdcourtyard.business.account.model.EmployeePrivilege;

import java.util.List;

/**
 * Created by cxx on 2018/7/18.
 */
public class ChooseEstateResp {

    private List<EmployeePrivilege> privileges;

    private String employeeId;

    private String employeeName;

    public List<EmployeePrivilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<EmployeePrivilege> privileges) {
        this.privileges = privileges;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ChooseEstateResp{");
        sb.append("privileges=").append(privileges);
        sb.append(", employeeId='").append(employeeId).append('\'');
        sb.append(", employeeName='").append(employeeName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
