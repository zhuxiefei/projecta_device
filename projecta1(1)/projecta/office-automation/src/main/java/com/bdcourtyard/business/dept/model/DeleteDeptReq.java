package com.bdcourtyard.business.dept.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-16 09:55
 * @Description:
 */
public class DeleteDeptReq {

    private String departmentId;

    @ApiModelProperty("部门ID")
    public String getDepartmentId() {
        return departmentId;
    }

    @ApiModelProperty("部门ID")
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "DeleteDeptReq{" +
                "departmentId='" + departmentId + '\'' +
                '}';
    }
}
