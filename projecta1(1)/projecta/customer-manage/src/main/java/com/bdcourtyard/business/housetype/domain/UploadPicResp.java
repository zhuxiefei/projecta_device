package com.bdcourtyard.business.housetype.domain;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-23 10:53
 * @Description:
 */
public class UploadPicResp {

    private String fileId;

    private String fileUrl;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public String toString() {
        return "UploadPicResp{" +
                "fileId='" + fileId + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                '}';
    }
}
