package com.bdcourtyard.business.account.domain;

import com.bdcourtyard.business.account.model.EmployeePrivilege;

import java.util.List;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-17 17:14
 * @Description:
 */
public class FindPrivilegesResp {

    private List<EmployeePrivilege> oaList;

    private List<EmployeePrivilege> estateList;

    private List<EmployeePrivilege> crmList;

    private List<EmployeePrivilege> assistantList;

    private List<EmployeePrivilege> networkList;

    public List<EmployeePrivilege> getOaList() {
        return oaList;
    }

    public void setOaList(List<EmployeePrivilege> oaList) {
        this.oaList = oaList;
    }

    public List<EmployeePrivilege> getEstateList() {
        return estateList;
    }

    public void setEstateList(List<EmployeePrivilege> estateList) {
        this.estateList = estateList;
    }

    public List<EmployeePrivilege> getCrmList() {
        return crmList;
    }

    public void setCrmList(List<EmployeePrivilege> crmList) {
        this.crmList = crmList;
    }

    public List<EmployeePrivilege> getAssistantList() {
        return assistantList;
    }

    public void setAssistantList(List<EmployeePrivilege> assistantList) {
        this.assistantList = assistantList;
    }

    public List<EmployeePrivilege> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(List<EmployeePrivilege> networkList) {
        this.networkList = networkList;
    }

    @Override
    public String toString() {
        return "FindPrivilegesResp{" +
                "oaList=" + oaList +
                ", estateList=" + estateList +
                ", crmList=" + crmList +
                ", assistantList=" + assistantList +
                ", networkList=" + networkList +
                '}';
    }
}
