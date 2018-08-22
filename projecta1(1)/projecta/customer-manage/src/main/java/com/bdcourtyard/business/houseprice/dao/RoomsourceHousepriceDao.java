package com.bdcourtyard.business.houseprice.dao;

import com.bdcourtyard.business.houseprice.model.RoomsourceHouseprice;
import com.bdcourtyard.business.houseprice.vo.HousePriceParm;
import com.bdcourtyard.business.houseprice.vo.RoomsourceHousepricePage;
import com.bdcourtyard.common.mybatis.QueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  RoomsourceHousepriceDao 
 *
 * @version : Ver 1.0
 * @date	: 2018-7-25
 */
@Repository
public interface RoomsourceHousepriceDao {
	
	int insertRoomsourceHouseprice(RoomsourceHouseprice roomsourceHouseprice);
	
	int insertRoomsourceHousepriceBatch(List<RoomsourceHouseprice> list);
	
	int updateRoomsourceHousepriceById(RoomsourceHouseprice roomsourceHouseprice);
	
	int deleteRoomsourceHousepriceById(@Param("housePriceId") String housePriceId);
	
 	RoomsourceHouseprice getRoomsourceHousepriceById(@Param("housePriceId") String housePriceId);

 	List<RoomsourceHouseprice> getRoomsourceHouseprices(@Param("roomsourceHouseprice") RoomsourceHouseprice roomsourceHouseprice);

 	List<RoomsourceHousepricePage> getRoomsourceHousepricesParm(@Param("housePriceParm") HousePriceParm housePriceParm);

 	List<RoomsourceHousepricePage> getRoomsourceHousepricesByConditions(@Param("conditions") List<QueryCondition> conditions);

 	List<RoomsourceHouseprice> getRoomsourceHousepricesByIs(@Param("buildingId") String buildingId,
			@Param("unitId") String unitId,@Param("typeId") String typeId);

}
