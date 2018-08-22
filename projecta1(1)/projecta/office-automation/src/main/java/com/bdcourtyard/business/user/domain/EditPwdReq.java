package com.bdcourtyard.business.user.domain;

/**
 * <p>
 * Describe this class...
 * </p>
 * ClassName: EditPwdReq <br/>
 * Author: xiayanxin  <br/>
 */
public class EditPwdReq {

    String pwd;

    String newPwd;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EditPwdReq{");
        sb.append("pwd='").append(pwd).append('\'');
        sb.append(", newPwd='").append(newPwd).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
