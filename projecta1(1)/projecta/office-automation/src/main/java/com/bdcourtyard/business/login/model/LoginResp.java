package com.bdcourtyard.business.login.model;

import com.bdcourtyard.business.estate.model.EstateEstate;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by cxx on 2018/7/16.
 */
public class LoginResp {

    private String acctName;

    private String token;

    private int isInit;

    private List<EstateEstate> estates;

    @ApiModelProperty("token令牌")
    public String getToken() {
        return token;
    }

    @ApiModelProperty("token令牌")
    public void setToken(String token) {
        this.token = token;
    }

    @ApiModelProperty("楼盘信息列表")
    public List<EstateEstate> getEstates() {
        return estates;
    }

    @ApiModelProperty("楼盘信息列表")
    public void setEstates(List<EstateEstate> estates) {
        this.estates = estates;
    }

    @ApiModelProperty("账号")
    public String getAcctName() {
        return acctName;
    }

    @ApiModelProperty("账号")
    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public int getIsInit() {
        return isInit;
    }

    public void setIsInit(int isInit) {
        this.isInit = isInit;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LoginResp{");
        sb.append("acctName='").append(acctName).append('\'');
        sb.append(", token='").append(token).append('\'');
        sb.append(", isInit='").append(isInit).append('\'');
        sb.append(", estates=").append(estates);
        sb.append('}');
        return sb.toString();
    }
}
