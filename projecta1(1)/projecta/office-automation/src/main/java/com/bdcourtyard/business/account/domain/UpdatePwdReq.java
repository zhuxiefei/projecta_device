package com.bdcourtyard.business.account.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-17 16:11
 * @Description:
 */
public class UpdatePwdReq {

    private String oldPwd;

    private String newPwd;

    @ApiModelProperty("原密码")
    public String getOldPwd() {
        return oldPwd;
    }

    @ApiModelProperty("原密码")
    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    @ApiModelProperty("新密码")
    public String getNewPwd() {
        return newPwd;
    }

    @ApiModelProperty("新密码")
    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    @Override
    public String toString() {
        return "UpdatePwdReq{" +
                "oldPwd='" + oldPwd + '\'' +
                ", newPwd='" + newPwd + '\'' +
                '}';
    }
}
