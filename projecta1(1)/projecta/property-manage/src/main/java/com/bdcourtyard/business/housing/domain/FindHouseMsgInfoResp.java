package com.bdcourtyard.business.housing.domain;

import java.util.List;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-19 18:00
 * @Description:
 */
public class FindHouseMsgInfoResp {

    private List<String> picUrl;

    private List<String> videoUrl;

    private List<String> videoPicUrl;

    private String propertyId;

    private String title;

    private String createTime;

    private String empName;

    private String content;

    public List<String> getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(List<String> picUrl) {
        this.picUrl = picUrl;
    }

    public List<String> getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(List<String> videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getVideoPicUrl() {
        return videoPicUrl;
    }

    public void setVideoPicUrl(List<String> videoPicUrl) {
        this.videoPicUrl = videoPicUrl;
    }

    @Override
    public String toString() {
        return "FindHouseMsgInfoResp{" +
                "picUrl=" + picUrl +
                ", videoUrl=" + videoUrl +
                ", videoPicUrl=" + videoPicUrl +
                ", propertyId='" + propertyId + '\'' +
                ", title='" + title + '\'' +
                ", createTime='" + createTime + '\'' +
                ", empName='" + empName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
