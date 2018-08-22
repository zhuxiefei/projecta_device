package com.bdcourtyard.business.houseprice.dao;

import com.bdcourtyard.business.houseprice.model.RoomsourceHousediscount;
import com.bdcourtyard.common.mybatis.QueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *  RoomsourceHousediscountDao 
 *
 * @version : Ver 1.0
 * @date	: 2018-7-24
 */
@Repository
public interface RoomsourceHousediscountDao {
	
	int insertRoomsourceHousediscount(RoomsourceHousediscount roomsourceHousediscount);
	
	int insertRoomsourceHousediscountBatch(List<RoomsourceHousediscount> list);
	
	int updateRoomsourceHousediscountById(RoomsourceHousediscount roomsourceHousediscount);
	
	int deleteRoomsourceHousediscountById(@Param("discountId") String discountId);
	
 	RoomsourceHousediscount getRoomsourceHousediscountById(@Param("discountId") String discountId);

 	List<RoomsourceHousediscount> getRoomsourceHousediscounts(@Param("roomsourceHousediscount") RoomsourceHousediscount roomsourceHousediscount);

	List<RoomsourceHousediscount> getRoomsourceHousediscountsByConditions(@Param("conditions") List<QueryCondition> conditions);

}
