package com.bdcourtyard.business.account.model;

import java.util.List;

/**
 * Created by cxx on 2018/7/17.
 */
public class Privilege {

    private String privilegeId;

    private String privilegeName;

    private List<ChildPrivilege> childPrivilege;

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

    public List<ChildPrivilege> getChildPrivilege() {
        return childPrivilege;
    }

    public void setChildPrivilege(List<ChildPrivilege> childPrivilege) {
        this.childPrivilege = childPrivilege;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Privilege{");
        sb.append("privilegeId='").append(privilegeId).append('\'');
        sb.append(", privilegeName='").append(privilegeName).append('\'');
        sb.append(", childPrivilege=").append(childPrivilege);
        sb.append('}');
        return sb.toString();
    }
}
