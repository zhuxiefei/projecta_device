package com.bdcourtyard.business.housetype.domain;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-30 11:08
 * @Description:
 */
public class SenceResp {

    private String fileUrl;

    private String fileId;

    private String sceneName;

    private Integer sceneSort;

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public Integer getSceneSort() {
        return sceneSort;
    }

    public void setSceneSort(Integer sceneSort) {
        this.sceneSort = sceneSort;
    }

    @Override
    public String toString() {
        return "SenceResp{" +
                "fileUrl='" + fileUrl + '\'' +
                ", fileId='" + fileId + '\'' +
                ", sceneName='" + sceneName + '\'' +
                ", sceneSort=" + sceneSort +
                '}';
    }
}
