package com.bdcourtyard.business.dept.model;

import java.util.Date;
import java.util.List;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-18 13:39
 * @Description:
 */
public class FindDeptListResp {

    /**
     * 部门ID
     */
    private String departmentId;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 部门描述
     */
    private String departmentDesc;

    /**
     * 创建时间
     */
    private java.util.Date createTime;

    private boolean hasChild;

    public FindDeptListResp(String departmentId, String departmentName, String departmentDesc, Date createTime, boolean hasChild) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentDesc = departmentDesc;
        this.createTime = createTime;
        this.hasChild = hasChild;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDesc() {
        return departmentDesc;
    }

    public void setDepartmentDesc(String departmentDesc) {
        this.departmentDesc = departmentDesc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public boolean isHasChild() {
        return hasChild;
    }

    public void setHasChild(boolean hasChild) {
        this.hasChild = hasChild;
    }

    @Override
    public String toString() {
        return "FindDeptListResp{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", departmentDesc='" + departmentDesc + '\'' +
                ", createTime=" + createTime +
                ", hasChild=" + hasChild +
                '}';
    }
}
