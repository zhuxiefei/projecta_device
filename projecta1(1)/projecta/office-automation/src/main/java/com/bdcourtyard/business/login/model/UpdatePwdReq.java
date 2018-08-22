package com.bdcourtyard.business.login.model;

/**
 * Created by cxx on 2018/7/19.
 */
public class UpdatePwdReq {

    private String mobile;

    private String newPwd;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UpdatePwdReq{");
        sb.append("mobile='").append(mobile).append('\'');
        sb.append(", newPwd='").append(newPwd).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
