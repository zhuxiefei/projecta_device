package com.bdcourtyard.business.dept.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-16 09:26
 * @Description:
 */
public class UpdateDeptReq {

    private String departmentId;

    private String departmentName;

    private String departmentDesc;

    @ApiModelProperty("部门ID")
    public String getDepartmentId() {
        return departmentId;
    }
    @ApiModelProperty("部门ID")
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

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

    @Override
    public String toString() {
        return "UpdateDeptReq{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", departmentDesc='" + departmentDesc + '\'' +
                '}';
    }
}
