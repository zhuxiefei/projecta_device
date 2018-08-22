package com.bdcourtyard.business.housetype.constant;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-23 11:01
 * @Description:
 */
public interface TypeConstant {

    /**
     *图片名称长度
     */
    int IMAGE_NAME_LENGTH = 120;

    /**
     * 图片大小
     */
    int IMAGE_SIZE_MAX = 20*1024*1024;

    /**
     * 户型图描述长度
     */
    int TYPE_DESC_LENGTH = 512;

    /**
     * 户型名称长度
     */
    int TYPE_NAME_LENGTH = 128;

    /**
     * 面积格式校验
     */
    String AREA_RULE = "(^0\\.\\d{1,2}$)|(^\\d{1,5}\\.\\d{1,2}$)|(^\\d{1,5}$)";
}
