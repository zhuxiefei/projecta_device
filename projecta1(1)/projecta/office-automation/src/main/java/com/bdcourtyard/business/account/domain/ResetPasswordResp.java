package com.bdcourtyard.business.account.domain;

/**
 * Created by Administrator on 2018/3/5/005.
 */
public class ResetPasswordResp {

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ResetPasswordResp{" +
                "password='" + password + '\'' +
                '}';
    }
}
