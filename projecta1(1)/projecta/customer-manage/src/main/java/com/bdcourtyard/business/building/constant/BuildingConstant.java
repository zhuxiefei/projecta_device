package com.bdcourtyard.business.building.constant;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-23 16:41
 * @Description:
 */
public interface BuildingConstant {

    /**
     * 楼宇名称长度
     */
    Integer BUILDING_NAME_LENGTH = 20;

    /**
     * 楼宇描述内容长度校验 长度为512的所有字符
     */
    Integer BUILDING_DESC_SIZE = 512;

    /**
     * 排序字段规则
     */
    String DISPLAY_RULE = "^(([1-9]\\d{0,3})|10000)$";
}
