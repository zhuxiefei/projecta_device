package com.bdcourtyard.business.clientmessage.dao;

import com.bdcourtyard.business.clientmessage.model.RoomsourceReturncust;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidRoomsourceReturncustDao {
    int insertRoomsourceReturncust(RoomsourceReturncust roomsourceReturncust);
}
