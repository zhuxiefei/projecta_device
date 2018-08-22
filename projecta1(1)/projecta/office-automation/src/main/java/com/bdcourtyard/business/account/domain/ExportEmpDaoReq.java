package com.bdcourtyard.business.account.domain;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-17 10:02
 * @Description:导出人员档案Dao层入参
 */
public class ExportEmpDaoReq {

    private String departmentId;

    private String employeeNo;

    private String employeeName;

    private String phone;

    private String empType;

    private String depId;

    private Integer depth;

    private String estateId;

    public ExportEmpDaoReq(String departmentId, String employeeNo, String employeeName, String phone, String empType, String depId, Integer depth, String estateId) {
        this.departmentId = departmentId;
        this.employeeNo = employeeNo;
        this.employeeName = employeeName;
        this.phone = phone;
        this.empType = empType;
        this.depId = depId;
        this.depth = depth;
        this.estateId = estateId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public String getEstateId() {
        return estateId;
    }

    public void setEstateId(String estateId) {
        this.estateId = estateId;
    }

    @Override
    public String toString() {
        return "ExportEmpDaoReq{" +
                "departmentId='" + departmentId + '\'' +
                ", employeeNo='" + employeeNo + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", phone='" + phone + '\'' +
                ", empType='" + empType + '\'' +
                ", depId='" + depId + '\'' +
                ", depth=" + depth +
                ", estateId='" + estateId + '\'' +
                '}';
    }
}
