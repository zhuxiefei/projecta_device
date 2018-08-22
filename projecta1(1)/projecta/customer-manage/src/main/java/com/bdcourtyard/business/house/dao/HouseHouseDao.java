package com.bdcourtyard.business.house.dao;

import com.bdcourtyard.business.house.domain.FindAllHousesReq;
import com.bdcourtyard.business.house.domain.FindAllHousesResp;
import com.bdcourtyard.business.house.domain.FindHouseResp;
import com.bdcourtyard.business.house.model.HouseHouse;
import com.bdcourtyard.business.houseprice.vo.HouseOrTypePage;
import com.bdcourtyard.common.mybatis.QueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  HouseHouseDao 房屋
 *
 * @version : Ver 1.0
 * @date	: 2018-7-23
 */
@Repository
public interface HouseHouseDao {
	
	int insertHouseHouse(HouseHouse houseHouse);
	
	int insertHouseHouseBatch(List<HouseHouse> list);
	
	int updateHouseHouseById(HouseHouse houseHouse);
	
	int deleteHouseHouseById(@Param("houseId") String houseId);

 	HouseHouse getHouseHouseById(@Param("houseId") String houseId);

 	List<FindAllHousesResp> getHouseHouses(FindAllHousesReq housesReq);
 	
 	List<HouseHouse> getHouseHousesByConditions(@Param("conditions") List<QueryCondition> conditions);

	List<HouseHouse> findByTypeId(String typeId);

	void updateTypeIdByHouseList(List<HouseHouse> houses);

	List<HouseHouse> selectByBuildingId(String buildingId);

	List<HouseHouse> selectByUnitId(String unitId);

	HouseHouse findHouseByParams(@Param("buildingId") String buildingId,@Param("unitId") String unitId,
								 @Param("houseNum") String houseNum,@Param("estateId") String estateId);

	void deleteByHouseIds(String[] array);

	List<FindAllHousesResp> exportByHouseIds(String[] houseIds);

	void updateOpenTime(@Param("openTime") String openTime,@Param("houseIds") String[] houseIds);

	List<HouseOrTypePage> findHouseOrTypePageParams(@Param("buildingId") String buildingId,@Param("unitId") String unitId);

	FindHouseResp findHouseById(@Param("houseId") String houseId);
}
