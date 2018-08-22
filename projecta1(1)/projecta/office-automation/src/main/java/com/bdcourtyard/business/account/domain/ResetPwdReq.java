package com.bdcourtyard.business.account.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-17 15:39
 * @Description:
 */
public class ResetPwdReq {

    private String acctName;

    @ApiModelProperty("账号")
    public String getAcctName() {
        return acctName;
    }

    @ApiModelProperty("账号")
    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    @Override
    public String toString() {
        return "ResetPwdReq{" +
                "acctName='" + acctName + '\'' +
                '}';
    }
}
