package com.bdcourtyard.business.contact.domain;

/**
 * <p>
 * 通讯录部门类
 * </p>
 * ClassName: ContactDepartment <br/>
 * Author: xiayanxin  <br/>
 */
public class ContactDepartment {

    String departmentId;

    String departmentName;

    Integer number;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ContactDepartment{");
        sb.append("departmentId='").append(departmentId).append('\'');
        sb.append(", departmentName='").append(departmentName).append('\'');
        sb.append(", number='").append(number).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
