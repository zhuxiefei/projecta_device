package com.bdcourtyard.business.account.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-16 17:51
 * @Description:
 */
public class FindEmpListReq {

    private String departmentId;

    private String employeeNo;

    private String employeeName;

    private String phone;

    /**
     * 1为正式员工 2为临时工
     */
    private String empType;

    public FindEmpListReq(){}

    public FindEmpListReq(String departmentId, String employeeNo, String employeeName, String phone, String empType) {
        this.departmentId = departmentId;
        this.employeeNo = employeeNo;
        this.employeeName = employeeName;
        this.phone = phone;
        this.empType = empType;
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

    @ApiModelProperty("人员名称")
    public String getEmployeeName() {
        return employeeName;
    }

    @ApiModelProperty("人员名称")
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

    @ApiModelProperty("雇佣性质：1为正式员工 2为临时工")
    public String getEmpType() {
        return empType;
    }

    @ApiModelProperty("雇佣性质：1为正式员工 2为临时工")
    public void setEmpType(String empType) {
        this.empType = empType;
    }

    @Override
    public String toString() {
        return "FindEmpListReq{" +
                "departmentId='" + departmentId + '\'' +
                ", employeeNo='" + employeeNo + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", phone='" + phone + '\'' +
                ", empType='" + empType + '\'' +
                '}';
    }
}
