package com.bdcourtyard.business.houseprice.service;

import com.bdcourtyard.business.houseprice.model.RoomsourceHousediscount;
import com.bdcourtyard.common.page.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *  RoomsourceHousediscountService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-24 
 */
public interface RoomsourceHousediscountService {
	
	int insertRoomsourceHousediscount(HttpServletRequest request,RoomsourceHousediscount roomsourceHousediscount);
	
	int insertRoomsourceHousediscountBatch(List<RoomsourceHousediscount> list);
	
	int updateRoomsourceHousediscountById(RoomsourceHousediscount roomsourceHousediscount);
	
	int deleteRoomsourceHousediscountById(String discountId);
	
 	RoomsourceHousediscount getRoomsourceHousediscountById(String discountId);

	void deleteRoomsourceHousediscountByIds(  String discountIds  );
 
 	List<RoomsourceHousediscount> getRoomsourceHousediscounts(RoomsourceHousediscount roomsourceHousediscount);

 	Page<RoomsourceHousediscount> getRoomsourceHousediscountsForPage(RoomsourceHousediscount roomsourceHousediscount,
            Pageable pageable);
}
