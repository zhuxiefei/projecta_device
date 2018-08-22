package com.bdcourtyard.business.housetype.domain;

import java.util.Date;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-23 15:44
 * @Description:
 */
public class FindAllTypesResp {

    private String typeNo;

    private String typeName;

    private String empName;

    private Date createTime;

    private String typeId;

    public String getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(String typeNo) {
        this.typeNo = typeNo;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "FindAllTypesResp{" +
                "typeNo='" + typeNo + '\'' +
                ", typeName='" + typeName + '\'' +
                ", empName='" + empName + '\'' +
                ", createTime=" + createTime +
                ", typeId='" + typeId + '\'' +
                '}';
    }
}
