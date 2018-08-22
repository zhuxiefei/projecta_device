package com.bdcourtyard.business.account.domain;

/**
 * Created by Administrator on 2018/5/16/016.
 */
public class AddAccountResp {

    /**
     * 0标识不展示密码，1标识展示密码
     */
    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "AddAccountResp{" +
                "flag='" + flag + '\'' +
                '}';
    }
}
