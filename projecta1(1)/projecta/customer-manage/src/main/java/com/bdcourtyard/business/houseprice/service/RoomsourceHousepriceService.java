package com.bdcourtyard.business.houseprice.service;

import com.bdcourtyard.business.houseprice.model.RoomsourceHouseprice;
import com.bdcourtyard.business.houseprice.vo.HouseFloor;
import com.bdcourtyard.business.houseprice.vo.HousePriceParm;
import com.bdcourtyard.business.houseprice.vo.HousepriceResp;
import com.bdcourtyard.business.houseprice.vo.RoomsourceHousepricePage;
import com.bdcourtyard.common.page.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *  RoomsourceHousepriceService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-25 
 */
public interface RoomsourceHousepriceService {
	
	int insertRoomsourceHouseprice(HttpServletRequest request, RoomsourceHouseprice roomsourceHouseprice);
	
	int insertRoomsourceHousepriceBatch(List<RoomsourceHouseprice> list);
	
	int updateRoomsourceHousepriceById(RoomsourceHouseprice roomsourceHouseprice);
	
	int deleteRoomsourceHousepriceById(String housePriceId);

	void deleteRoomsourceHousepriceByIds(  String housePriceIds  );
	
 	HousepriceResp getHousepriceRespById(String housePriceId);
 
 	List<RoomsourceHouseprice> getRoomsourceHouseprices(RoomsourceHouseprice roomsourceHouseprice);

 	Page<RoomsourceHousepricePage> getRoomsourceHousepricesForPage(HousePriceParm housePriceParm,
            Pageable pageable);

	List<HouseFloor> getRoomsourceHousepricePageByIds(String housePriceId, String buildingId, String unitId,String typeId );
}
