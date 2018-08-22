package com.bdcourtyard.business.account.constant;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-16 15:23
 * @Description:
 */
public interface EmployeeConstant {

    /**
     *图片名称长度
     */
    int IMAGE_NAME_LENGTH = 120;

    /**
     * 图片大小
     */
    int IMAGE_SIZE_MAX = 20*1024*1024;

    /**
     * 人员编号最大值
     */
    int EMP_NO_MAX = 1000;

    /**
     * 人员名称最长值
     */
    int EMP_NAME_LENGTH = 10;

    /**
     * 民族最长值
     */
    int EMP_ETHNIC_LENGTH = 5;

    /**
     * 毕业院校最长值
     */
    int GRADUATE_LENGTH = 20;

    /**
     * 专业最长值
     */
    int MAJOR_LENGTH = 20;

    /**
     * 家庭住址最长值
     */
    int ADRESS_LENGTH = 50;

    /**
     * 籍贯最长值
     */
    int RESIDENCY_LENGTH = 50;

    /**
     * 转正标识
     */
    int IS_REGULAR = 1;

    /**
     * 紧急联系人姓名长度
     */
    int EMERGENCY_PERSON_LENGTH = 10;

    /**
     * 未启用账号
     */
    Integer NOT_ENABLEACCOUNT = 0;

    /**
     * 手机号搜索输入最长值
     */
    Integer PHONE_MAX_LENGTH = 11;

    /**
     * 手机号搜索输入最短值
     */
    Integer PHONE_MIN_LENGTH = 1;

    /**
     * 文件保存类型--图片
     */
    Integer FILE_TYPE_PIC = 2;
}
