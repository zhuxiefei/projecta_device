package com.bdcourtyard.business.building.dao;

import com.bdcourtyard.business.building.domain.BuildingInfo;
import com.bdcourtyard.business.building.model.HouseBuilding;
import com.bdcourtyard.common.mybatis.QueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  HouseBuildingDao 楼宇
 *
 * @version : Ver 1.0
 * @date	: 2018-7-23
 */
@Repository
public interface HouseBuildingDao {
	
	int insertHouseBuilding(HouseBuilding houseBuilding);
	
	int insertHouseBuildingBatch(List<HouseBuilding> list);
	
	int updateHouseBuildingById(HouseBuilding houseBuilding);
	
	int deleteHouseBuildingById(@Param("buildingId") String buildingId);

 	HouseBuilding getHouseBuildingById(@Param("buildingId") String buildingId);

 	List<HouseBuilding> getHouseBuildings(@Param("houseBuilding") HouseBuilding houseBuilding);
 	
 	List<HouseBuilding> getHouseBuildingsByConditions(@Param("conditions") List<QueryCondition> conditions);

	HouseBuilding findByNameAndEstateId(@Param("buildingName")String buildingName,@Param("estateId")String estateId);

	List<BuildingInfo> findBuildingList(String estateId);
}
