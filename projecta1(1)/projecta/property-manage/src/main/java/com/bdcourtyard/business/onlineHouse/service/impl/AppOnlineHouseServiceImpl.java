package com.bdcourtyard.business.onlineHouse.service.impl;

import com.bdcourtyard.business.onlineHouse.dao.AppOnlineHouseDao;
import com.bdcourtyard.business.onlineHouse.model.HouseResp;
import com.bdcourtyard.business.onlineHouse.model.OnlineHouseSimpleInfo;
import com.bdcourtyard.business.onlineHouse.service.AppOnlineHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppOnlineHouseServiceImpl implements AppOnlineHouseService {

    @Autowired
    private AppOnlineHouseDao appOnlineHouseDao;

    @Override
    public List<OnlineHouseSimpleInfo> findOnlineHouseAll() {
        return appOnlineHouseDao.selectAllHouseInfo();
    }
}
