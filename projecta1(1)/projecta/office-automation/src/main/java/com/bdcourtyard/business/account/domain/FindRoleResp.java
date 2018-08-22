package com.bdcourtyard.business.account.domain;

import com.bdcourtyard.business.account.model.EmployeePrivilege;

import java.util.List;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-17 19:38
 * @Description:
 */
public class FindRoleResp {

    private String roleId;

    private String roleName;

    private String roleDesc;

    private List<EmployeePrivilege> privileges;

    private String privilegeIds;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<EmployeePrivilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<EmployeePrivilege> privileges) {
        this.privileges = privileges;
    }

    public String getPrivilegeIds() {
        return privilegeIds;
    }

    public void setPrivilegeIds(String privilegeIds) {
        this.privilegeIds = privilegeIds;
    }

    @Override
    public String toString() {
        return "FindRoleResp{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", privileges=" + privileges +
                ", privilegeIds='" + privilegeIds + '\'' +
                '}';
    }
}
