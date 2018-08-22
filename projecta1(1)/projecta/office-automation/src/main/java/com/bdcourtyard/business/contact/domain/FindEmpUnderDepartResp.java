package com.bdcourtyard.business.contact.domain;

import java.util.List;

/**
 * <p>
 * Describe this class...
 * </p>
 * ClassName: FindEmpUnderDepartResp <br/>
 * Author: xiayanxin  <br/>
 */
public class FindEmpUnderDepartResp {

    private List<ContactDepartment> departmentList;

    private List<EmployeeInfo> employeeInfoList;

    public List<ContactDepartment> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<ContactDepartment> departmentList) {
        this.departmentList = departmentList;
    }

    public List<EmployeeInfo> getEmployeeInfoList() {
        return employeeInfoList;
    }

    public void setEmployeeInfoList(List<EmployeeInfo> employeeInfoList) {
        this.employeeInfoList = employeeInfoList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FindEmpUnderDepartResp{");
        sb.append("departmentList=").append(departmentList);
        sb.append(", employeeInfoList=").append(employeeInfoList);
        sb.append('}');
        return sb.toString();
    }
}
