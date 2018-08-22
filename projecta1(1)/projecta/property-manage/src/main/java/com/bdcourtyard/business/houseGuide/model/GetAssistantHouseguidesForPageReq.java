package com.bdcourtyard.business.houseGuide.model;

/**
 * Created by cxx on 2018/7/19.
 */
public class GetAssistantHouseguidesForPageReq {

    private String title;

    private String employeeName;

    private String startTime;

    private String endTime;

    private String estateId;

    public String getEstateId() {
        return estateId;
    }

    public void setEstateId(String estateId) {
        this.estateId = estateId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GetAssistantHouseguidesForPageReq{");
        sb.append("title='").append(title).append('\'');
        sb.append(", employeeName='").append(employeeName).append('\'');
        sb.append(", startTime='").append(startTime).append('\'');
        sb.append(", endTime='").append(endTime).append('\'');
        sb.append(", estateId='").append(estateId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
