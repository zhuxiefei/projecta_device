package com.bdcourtyard.business.dept.model;

import io.swagger.annotations.ApiModelProperty;

public class DeptReq {
    private String departmentName;
    private String departmentDesc;
    private String parentDepartment;

    @ApiModelProperty("部门名称")
    public String getDepartmentName() {
        return departmentName;
    }

    @ApiModelProperty("部门名称")
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @ApiModelProperty("部门描述")
    public String getDepartmentDesc() {
        return departmentDesc;
    }

    @ApiModelProperty("部门描述")
    public void setDepartmentDesc(String departmentDesc) {
        this.departmentDesc = departmentDesc;
    }

    @ApiModelProperty("父部门ID")
    public String getParentDepartment() {
        return parentDepartment;
    }

    @ApiModelProperty("父部门ID")
    public void setParentDepartment(String parentDepartment) {
        this.parentDepartment = parentDepartment;
    }

    @Override
    public String toString() {
        return "DeptReq{" +
                "departmentName='" + departmentName + '\'' +
                ", departmentDesc='" + departmentDesc + '\'' +
                ", parentDepartment='" + parentDepartment + '\'' +
                '}';
    }
}
