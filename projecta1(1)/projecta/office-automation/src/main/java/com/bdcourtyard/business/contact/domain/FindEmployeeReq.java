package com.bdcourtyard.business.contact.domain;

/**
 * <p>
 * Describe this class...
 * </p>
 * ClassName: FindEmployeeReq <br/>
 * Author: xiayanxin  <br/>
 */
public class FindEmployeeReq {

    String employeeId;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FindEmployeeReq{");
        sb.append("employeeId='").append(employeeId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
