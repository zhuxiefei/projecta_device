package com.bdcourtyard.business.login.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cxx on 2018/7/18.
 */
public class AppLoginResp {

    private String acctName;

    private String token;

    @ApiModelProperty("账号")
    public String getAcctName() {
        return acctName;
    }
    @ApiModelProperty("账号")
    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }
    @ApiModelProperty("token令牌")
    public String getToken() {
        return token;
    }
    @ApiModelProperty("token令牌")
    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AppLoginResp{");
        sb.append("acctName='").append(acctName).append('\'');
        sb.append(", token='").append(token).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
