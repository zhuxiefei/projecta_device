package com.bdcourtyard.business.housing.domain;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-19 17:50
 * @Description:
 */
public class FindHouseMsgsResp {

    private String pic;

    /**
     * 1标识有视频  2标识没有视频
     */
    private String hasVideo;

    private String propertyId;

    private String title;

    private String createTime;

    private String empName;

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
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

    public String getHasVideo() {
        return hasVideo;
    }

    public void setHasVideo(String hasVideo) {
        this.hasVideo = hasVideo;
    }

    @Override
    public String toString() {
        return "FindHouseMsgsResp{" +
                "pic='" + pic + '\'' +
                ", hasVideo='" + hasVideo + '\'' +
                ", propertyId='" + propertyId + '\'' +
                ", title='" + title + '\'' +
                ", createTime='" + createTime + '\'' +
                ", empName='" + empName + '\'' +
                '}';
    }
}
