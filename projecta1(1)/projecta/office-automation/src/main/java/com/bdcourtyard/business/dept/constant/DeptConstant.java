package com.bdcourtyard.business.dept.constant;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-13 16:51
 * @Description:
 */
public interface DeptConstant {

    /**
     * 名称格式校验
     */
    String NAME_RULE = "[^\\\\<>%'\"]{0,10}";

    /**
     * 部门描述超过100字
     */
    int DEPT_DESC_LENGTH=100;
}
