package com.bdcourtyard.business.housing.model;

import com.bdcourtyard.business.file.model.SystemFile;

import java.util.List;

public class HouseResponse {

    private AssistantHouse assistantHouse;

    private List<SystemFile> systemFiles;

    public AssistantHouse getAssistantHouse() {
        return assistantHouse;
    }

    public void setAssistantHouse(AssistantHouse assistantHouse) {
        this.assistantHouse = assistantHouse;
    }

    public List<SystemFile> getSystemFiles() {
        return systemFiles;
    }

    public void setSystemFiles(List<SystemFile> systemFiles) {
        this.systemFiles = systemFiles;
    }
}
