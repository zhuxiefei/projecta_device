package com.bdcourtyard.business.houseprice.vo;

/**
 * <p>
 * Describe this class...
 *
 * @author: Du.Hx
 * @date: 2018/7/26 11:43
 * @version: 1.0
 */
public class HouseFloor {

    /**
     * 楼层
     */
    private  String floorNum;
    /**
     * 是否占用：0未占用 1已占用
     */
    private  Integer disabled = 0;

    public HouseFloor() {
        super();
    }
    public HouseFloor(String floorNum) {
        super();
        this.floorNum = floorNum;
    }

    public String getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(String floorNum) {
        this.floorNum = floorNum;
    }

    public Integer getDisabled() {
        return disabled;
    }

    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }
}
