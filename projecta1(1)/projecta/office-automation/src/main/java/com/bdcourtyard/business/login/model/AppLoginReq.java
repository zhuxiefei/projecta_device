package com.bdcourtyard.business.login.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cxx on 2018/7/17.
 */
public class AppLoginReq {
    private String acctName;

    private String password;

    private String validateCode;

    private String type;

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
    @ApiModelProperty("验证码")
    public String getValidateCode() {
        return validateCode;
    }
    @ApiModelProperty("验证码")
    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }
    @ApiModelProperty("登陆方式：1密码登陆2验证码登陆")
    public String getType() {
        return type;
    }
    @ApiModelProperty("登陆方式：1密码登陆2验证码登陆")
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AppLoginReq{");
        sb.append("acctName='").append(acctName).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", validateCode='").append(validateCode).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
