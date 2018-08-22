package com.bdcourtyard.business.housing.model;

public class AddAssistantHouseReq {

    private String title;

    private String content;

    private String fileId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    @Override
    public String toString() {
        return "AddAssistantHouseReq{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", fileId='" + fileId + '\'' +
                '}';
    }
}
