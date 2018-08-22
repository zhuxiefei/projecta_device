package com.bdcourtyard.business.login.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cxx on 2018/7/18.
 */
public class GetCodeReq {

    private String mobile;
    /**
     * 登录：login_oa;忘记密码：forget_oa
     */
    private String type;

    @ApiModelProperty("手机号")
    public String getMobile() {
        return mobile;
    }
    @ApiModelProperty("手机号")
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    @ApiModelProperty("登录：login_oa;忘记密码：forget_oa")
    public String getType() {
        return type;
    }
    @ApiModelProperty("登录：login_oa;忘记密码：forget_oa")
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GetCodeReq{");
        sb.append("mobile='").append(mobile).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
