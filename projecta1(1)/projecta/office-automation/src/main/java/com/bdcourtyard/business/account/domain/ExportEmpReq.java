package com.bdcourtyard.business.account.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-17 09:41
 * @Description:
 */
public class ExportEmpReq {

    private String employeeId;

    private String departmentId;

    private String employeeNo;

    private String employeeName;

    private String phone;

    private String empType;

    @ApiModelProperty("雇佣性质：1为正式员工 2为临时工")
    public String getEmpType() {
        return empType;
    }

    @ApiModelProperty("雇佣性质：1为正式员工 2为临时工")
    public void setEmpType(String empType) {
        this.empType = empType;
    }

    @ApiModelProperty("人员ID")
    public String getEmployeeId() {
        return employeeId;
    }

    @ApiModelProperty("人员ID")
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @ApiModelProperty("部门ID")
    public String getDepartmentId() {
        return departmentId;
    }

    @ApiModelProperty("部门ID")
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @ApiModelProperty("人员编号")
    public String getEmployeeNo() {
        return employeeNo;
    }

    @ApiModelProperty("人员编号")
    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    @ApiModelProperty("人员姓名")
    public String getEmployeeName() {
        return employeeName;
    }

    @ApiModelProperty("人员姓名")
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @ApiModelProperty("人员手机号")
    public String getPhone() {
        return phone;
    }

    @ApiModelProperty("人员手机号")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "ExportEmpReq{" +
                "employeeId='" + employeeId + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", employeeNo='" + employeeNo + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", phone='" + phone + '\'' +
                ", empType='" + empType + '\'' +
                '}';
    }
}
