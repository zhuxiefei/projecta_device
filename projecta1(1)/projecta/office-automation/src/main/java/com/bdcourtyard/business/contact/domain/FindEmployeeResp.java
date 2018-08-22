package com.bdcourtyard.business.contact.domain;

/**
 * <p>
 * Describe this class...
 * </p>
 * ClassName: FindEmployeeResp <br/>
 * Author: xiayanxin  <br/>
 */
public class FindEmployeeResp {

    String employeeName;

    String departmentName;

    String phoneNum;

    String head;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FindEmployeeResp{");
        sb.append("employeeName='").append(employeeName).append('\'');
        sb.append(", departmentName='").append(departmentName).append('\'');
        sb.append(", phoneNum='").append(phoneNum).append('\'');
        sb.append(", head='").append(head).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
