package com.bdcourtyard.business.housetype.domain;

import com.bdcourtyard.business.housetype.model.HouseType;
import com.bdcourtyard.business.housetype.model.HouseTypeSence;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-30 10:25
 * @Description:
 */
public class AddTypeReq {

    private HouseType houseType;

    private List<HouseTypeSence> sences;

    public HouseType getHouseType() {
        return houseType;
    }

    public void setHouseType(HouseType houseType) {
        this.houseType = houseType;
    }

    public List<HouseTypeSence> getSences() {
        return sences;
    }

    public void setSences(List<HouseTypeSence> sences) {
        this.sences = sences;
    }

    @Override
    public String toString() {
        return "AddTypeReq{" +
                "houseType=" + houseType +
                ", sences=" + sences +
                '}';
    }
}
