package com.bdcourtyard.business.contact.domain;

/**
 * <p>
 * Describe this class...
 * </p>
 * ClassName: FindEmpUnderDepartReq <br/>
 * Author: xiayanxin  <br/>
 */
public class FindEmpUnderDepartReq {

    String departmentId;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FindEmpUnderDepartReq{");
        sb.append("departmentId='").append(departmentId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
