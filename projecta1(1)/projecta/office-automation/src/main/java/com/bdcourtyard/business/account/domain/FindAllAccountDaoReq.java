package com.bdcourtyard.business.account.domain;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-17 15:11
 * @Description:
 */
public class FindAllAccountDaoReq {

    private String empNo;

    private String departmentId;

    private String empName;

    private String phoneNum;

    private String startTime;

    private String endTime;

    private String depId;

    private Integer depth;

    private String estateId;

    public FindAllAccountDaoReq(String empNo, String departmentId, String empName, String phoneNum, String startTime, String endTime, String depId, Integer depth, String estateId) {
        this.empNo = empNo;
        this.departmentId = departmentId;
        this.empName = empName;
        this.phoneNum = phoneNum;
        this.startTime = startTime;
        this.endTime = endTime;
        this.depId = depId;
        this.depth = depth;
        this.estateId = estateId;
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

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

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
        return "FindAllAccountDaoReq{" +
                "empNo='" + empNo + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", empName='" + empName + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", depId='" + depId + '\'' +
                ", depth=" + depth +
                ", estateId='" + estateId + '\'' +
                '}';
    }
}
