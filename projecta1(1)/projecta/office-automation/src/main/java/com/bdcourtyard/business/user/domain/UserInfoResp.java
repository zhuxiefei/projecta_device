package com.bdcourtyard.business.user.domain;

/**
 * <p>
 * Describe this class...
 * </p>
 * ClassName: UserInfoResp <br/>
 * Author: xiayanxin  <br/>
 */
public class UserInfoResp {

    String employeeName;

    String departmentName;

    String photo;

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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserInfoResp{");
        sb.append("employeeName='").append(employeeName).append('\'');
        sb.append(", departmentName='").append(departmentName).append('\'');
        sb.append(", photo='").append(photo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
