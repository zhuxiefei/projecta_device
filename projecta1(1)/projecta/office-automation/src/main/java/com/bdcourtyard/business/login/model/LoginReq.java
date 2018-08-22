package com.bdcourtyard.business.login.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cxx on 2018/7/16.
 */
public class LoginReq {

    private String acctName;

    private String password;

    private String imageCode;

    @ApiModelProperty("账号")
    public String getAcctName() {
        return acctName;
    }

    @ApiModelProperty("账号")
    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    @ApiModelProperty("密码")
    public String getPassword() {
        return password;
    }

    @ApiModelProperty("密码")
    public void setPassword(String password) {
        this.password = password;
    }

    @ApiModelProperty("图形验证码")
    public String getImageCode() {
        return imageCode;
    }

    @ApiModelProperty("图形验证码")
    public void setImageCode(String imageCode) {
        this.imageCode = imageCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LoginReq{");
        sb.append("acctName='").append(acctName).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", imageCode='").append(imageCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
