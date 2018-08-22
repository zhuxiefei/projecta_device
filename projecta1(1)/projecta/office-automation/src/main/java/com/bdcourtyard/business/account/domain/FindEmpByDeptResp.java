package com.bdcourtyard.business.account.domain;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-17 14:13
 * @Description:
 */
public class FindEmpByDeptResp {

    private String empId;

    private String empNo;

    private String empName;

    private String empPhone;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FindEmpResp{");
        sb.append("empId='").append(empId).append('\'');
        sb.append(", empNo='").append(empNo).append('\'');
        sb.append(", empName='").append(empName).append('\'');
        sb.append(", empPhone='").append(empPhone).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
