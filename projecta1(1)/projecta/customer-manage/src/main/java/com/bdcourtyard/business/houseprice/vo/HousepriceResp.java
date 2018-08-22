package com.bdcourtyard.business.houseprice.vo;

import com.bdcourtyard.business.houseprice.model.RoomsourceHousediscount;
import com.bdcourtyard.business.houseprice.model.RoomsourceHouseprice;

import java.util.List;

/**
 * <p>
 * Describe this class...
 *
 * @author: Du.Hx
 * @date: 2018/7/26 19:58
 * @version: 1.0
 */
public class HousepriceResp {
    RoomsourceHouseprice roomsourceHouseprice;
    List<RoomsourceHousediscount> roomsourceHousediscounts;

    public RoomsourceHouseprice getRoomsourceHouseprice() {
        return roomsourceHouseprice;
    }

    public void setRoomsourceHouseprice(RoomsourceHouseprice roomsourceHouseprice) {
        this.roomsourceHouseprice = roomsourceHouseprice;
    }

    public List<RoomsourceHousediscount> getRoomsourceHousediscounts() {
        return roomsourceHousediscounts;
    }

    public void setRoomsourceHousediscounts(List<RoomsourceHousediscount> roomsourceHousediscounts) {
        this.roomsourceHousediscounts = roomsourceHousediscounts;
    }
}
