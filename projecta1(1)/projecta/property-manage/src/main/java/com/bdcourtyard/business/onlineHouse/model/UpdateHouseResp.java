package com.bdcourtyard.business.onlineHouse.model;

import com.bdcourtyard.business.file.model.SystemFile;
import com.bdcourtyard.business.housing.model.AssistantHouse;

import java.util.List;

public class UpdateHouseResp {

    //主表id
    private String onlineId;

    //户型名称
    private String houseType;

    //附件表id
    private String[] fileIds;

    //文件表对象
    List<AssistantOnlinehousefile> assistantOnlinehousefileList;



    public String getOnlineId() {
        return onlineId;
    }

    public void setOnlineId(String onlineId) {
        this.onlineId = onlineId;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String[] getFileIds() {
        return fileIds;
    }

    public void setFileIds(String[] fileIds) {
        this.fileIds = fileIds;
    }

    public List<AssistantOnlinehousefile> getAssistantOnlinehousefileList() {
        return assistantOnlinehousefileList;
    }

    public void setAssistantOnlinehousefileList(List<AssistantOnlinehousefile> assistantOnlinehousefileList) {
        this.assistantOnlinehousefileList = assistantOnlinehousefileList;
    }
}
