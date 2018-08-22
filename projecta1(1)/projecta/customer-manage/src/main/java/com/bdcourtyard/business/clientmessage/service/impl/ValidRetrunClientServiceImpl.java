package com.bdcourtyard.business.clientmessage.service.impl;

import basic.common.core.id.IdUtil;
import com.bdcourtyard.business.clientmessage.dao.ValidRoomsourceReturncustDao;
import com.bdcourtyard.business.clientmessage.model.RoomsourceReturncust;
import com.bdcourtyard.business.clientmessage.service.ValidRetrunClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ValidRetrunClientServiceImpl implements ValidRetrunClientService {

    @Autowired
    private ValidRoomsourceReturncustDao validRoomsourceReturncustDao;

    @Override
    public int insertRoomsourceReturncust(String counselor ,RoomsourceReturncust roomsourceReturncust) {
        String returnId = IdUtil.getId()+"";
        roomsourceReturncust.setReturnId(returnId);
        roomsourceReturncust.setReturnNo("HF"+returnId);
        roomsourceReturncust.setCreateTime(new Date());
        roomsourceReturncust.setReturnTime(new Date());
        roomsourceReturncust.setCounselor(counselor);
        return validRoomsourceReturncustDao.insertRoomsourceReturncust(roomsourceReturncust);
    }
}
