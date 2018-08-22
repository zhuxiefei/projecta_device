package com.bdcourtyard.business.account.constant;

/**
 * <p>
 * 角色管理常量
 * </p>
 * ClassName: RoleConstant <br/>
 * Author: xiayanxin  <br/>
 * Date: 2018/7/17 <br/>
 */
public interface RoleConstant {

    /**
     * 关键词格式
     */
    String KEYWORD_FORMAT = "[^\\\\<>%'\"]{1,}";

    /**
     * 名称长度
     */
    int KEYWORD_SIZE = 20;

    /**
     * 超级管理员名称
     */
    String ADMIN = "admin";

    /**
     * 角色描述限制长度 100
     */
    int ROLEDESC_SIZE = 100;

}
