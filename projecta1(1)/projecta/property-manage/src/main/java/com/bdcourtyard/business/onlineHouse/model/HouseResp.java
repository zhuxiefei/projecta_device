package com.bdcourtyard.business.onlineHouse.model;

import com.bdcourtyard.business.file.model.SystemFile;

import java.util.List;

public class HouseResp {

    //在线看房信息
    private AssistantOnlineHouse assistantOnlineHouse;

    //文件表对象
    private List<OnlineFileResq> systemFileList;

    public AssistantOnlineHouse getAssistantOnlineHouse() {
        return assistantOnlineHouse;
    }

    public void setAssistantOnlineHouse(AssistantOnlineHouse assistantOnlineHouse) {
        this.assistantOnlineHouse = assistantOnlineHouse;
    }

    public List<OnlineFileResq> getSystemFileList() {
        return systemFileList;
    }

    public void setSystemFileList(List<OnlineFileResq> systemFileList) {
        this.systemFileList = systemFileList;
    }
}
