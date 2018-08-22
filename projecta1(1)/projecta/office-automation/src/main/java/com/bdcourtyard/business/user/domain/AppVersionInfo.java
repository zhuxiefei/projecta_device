package com.bdcourtyard.business.user.domain;

/**
 * <p>
 * 最新App版本信息回参
 * </p>
 * ClassName: AppVersionInfo <br/>
 * Author: xiayanxin <br/>
 * Date: 2017/6/21 11:40 <br/>
 * Version: 1.0 <br/>
 */
public class AppVersionInfo {
    private String versionNo;

    private String versionUrl;

    private String versionName;

    private Integer versionType;

    private Integer isForce;

    private String versionDesc;

    public AppVersionInfo(){}

    public AppVersionInfo(String versionNo, String versionUrl, String versionName, Integer versionType, Integer isForce, String versionDesc) {
        this.versionNo = versionNo;
        this.versionUrl = versionUrl;
        this.versionName = versionName;
        this.versionType = versionType;
        this.isForce = isForce;
        this.versionDesc = versionDesc;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public String getVersionUrl() {
        return versionUrl;
    }

    public void setVersionUrl(String versionUrl) {
        this.versionUrl = versionUrl;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public Integer getVersionType() {
        return versionType;
    }

    public void setVersionType(Integer versionType) {
        this.versionType = versionType;
    }

    public Integer getIsForce() {
        return isForce;
    }

    public void setIsForce(Integer isForce) {
        this.isForce = isForce;
    }

    public String getVersionDesc() {
        return versionDesc;
    }

    public void setVersionDesc(String versionDesc) {
        this.versionDesc = versionDesc;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AppVersionInfo{");
        sb.append("versionNo='").append(versionNo).append('\'');
        sb.append(", versionUrl='").append(versionUrl).append('\'');
        sb.append(", versionName='").append(versionName).append('\'');
        sb.append(", versionType=").append(versionType);
        sb.append(", isForce=").append(isForce);
        sb.append(", versionDesc='").append(versionDesc).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
