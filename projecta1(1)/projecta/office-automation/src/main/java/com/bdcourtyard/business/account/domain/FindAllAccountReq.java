package com.bdcourtyard.business.account.domain;

/**
 * <p>
 * 查询账号列表入参
 * </p>
 * ClassName: FindAllAccountReq <br/>
 * Author: Xia.yx  <br/>
 * Date: 2017/12/4 19:40 <br/>
 * Version: 1.0 <br/>
 */
public class FindAllAccountReq{

    private String empNo;

    private String departmentId;

    private String empName;

    private String phoneNum;

    private String startTime;

    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FindAllAccountReq{");
        sb.append("empNo='").append(empNo).append('\'');
        sb.append(", departmentId='").append(departmentId).append('\'');
        sb.append(", empName='").append(empName).append('\'');
        sb.append(", phoneNum='").append(phoneNum).append('\'');
        sb.append(", startTime='").append(startTime).append('\'');
        sb.append(", endTime='").append(endTime).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
