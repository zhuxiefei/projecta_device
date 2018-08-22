package com.bdcourtyard.business.house.constant;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-23 20:05
 * @Description:
 */
public interface HouseConstant {

    /**
     * 房号长度
     */
    Integer HOUSE_NUM_LENGTH = 6;

    /**
     * 排序字段最大长度
     */
    Integer ORDER_MAX_LENGTH = 10000;

    /**
     * EXCEL格式校验
     */
    String EXCEL_RULE = "xls";

    /**
     * EXCEL大小校验
     */
    Long EXCEL_MAX_SIZE = 15 * 1024 * 1024L;

    /**
     * 楼层高度
     */
    Integer FLOOR_LENGTH = 200;
}
