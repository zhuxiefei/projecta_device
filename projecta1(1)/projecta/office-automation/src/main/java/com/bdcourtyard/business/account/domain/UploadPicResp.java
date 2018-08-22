package com.bdcourtyard.business.account.domain;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-19 13:32
 * @Description:
 */
public class UploadPicResp {

    private String photoId;

    private String file;

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "UploadPicResp{" +
                "photoId='" + photoId + '\'' +
                ", file='" + file + '\'' +
                '}';
    }
}
