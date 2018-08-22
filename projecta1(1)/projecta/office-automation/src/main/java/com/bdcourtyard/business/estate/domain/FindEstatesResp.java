package com.bdcourtyard.business.estate.domain;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-24 09:56
 * @Description:
 */
public class FindEstatesResp {

    private String estateId;

    private String estateName;

    private String fileUrl;

    public String getEstateId() {
        return estateId;
    }

    public void setEstateId(String estateId) {
        this.estateId = estateId;
    }

    public String getEstateName() {
        return estateName;
    }

    public void setEstateName(String estateName) {
        this.estateName = estateName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public String toString() {
        return "FindEstatesResp{" +
                "estateId='" + estateId + '\'' +
                ", estateName='" + estateName + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                '}';
    }
}
