package com.bdcourtyard.business.onlineHouse.service;

import com.bdcourtyard.business.onlineHouse.model.HouseResp;
import com.bdcourtyard.business.onlineHouse.model.OnlineHouseSimpleInfo;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AppOnlineHouseService {

    public List<OnlineHouseSimpleInfo> findOnlineHouseAll();

}
