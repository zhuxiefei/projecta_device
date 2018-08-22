package com.bdcourtyard.business.account.domain;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-16 19:36
 * @Description:
 */
public class FindAllEmpResp {

    /**
     * id
     */
    private String employeeId;

    /**
     * 编号
     */
    private String employeeNo;

    /**
     * 姓名
     */
    private String employeeName;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 职位名称
     */
    private String positionName;

    /**
     * 性别
     */
    private Integer gender;
    /**
     * 雇佣性质
     */
    private Integer employType;
    /**
     * 联系电话
     */
    private String phoneNum;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getEmployType() {
        return employType;
    }

    public void setEmployType(Integer employType) {
        this.employType = employType;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "EmployeeList{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeNo='" + employeeNo + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", positionName='" + positionName + '\'' +
                ", gender=" + gender +
                ", employType=" + employType +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
