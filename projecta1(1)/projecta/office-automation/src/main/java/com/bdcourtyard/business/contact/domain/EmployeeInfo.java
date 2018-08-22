package com.bdcourtyard.business.contact.domain;

/**
 * <p>
 * Describe this class...
 * </p>
 * ClassName: EmployeeInfo <br/>
 * Author: xiayanxin  <br/>
 */
public class EmployeeInfo {

    String employeeId;

    String employeeName;

    String departmentName;

    String head;

    String phoneNum;

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EmployeeInfo{");
        sb.append("employeeId='").append(employeeId).append('\'');
        sb.append(", employeeName='").append(employeeName).append('\'');
        sb.append(", departmentName='").append(departmentName).append('\'');
        sb.append(", head='").append(head).append('\'');
        sb.append(", phoneNum='").append(phoneNum).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
