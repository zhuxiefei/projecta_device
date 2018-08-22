package com.bdcourtyard.business.onlineHouse.dao;

import com.bdcourtyard.business.onlineHouse.model.HouseResp;
import com.bdcourtyard.business.onlineHouse.model.OnlineHouseSimpleInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppOnlineHouseDao {
   public List<OnlineHouseSimpleInfo> selectAllHouseInfo();
}
