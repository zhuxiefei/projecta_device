package com.bdcourtyard.business.account.model;

/**
 * Created by cxx on 2018/7/17.
 */
public class ChildPrivilege {

    private String privilegeId;

    private String privilegeName;

    public String getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(String privilegeId) {
        this.privilegeId = privilegeId;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ChildPrivilege{");
        sb.append("privilegeId='").append(privilegeId).append('\'');
        sb.append(", privilegeName='").append(privilegeName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
