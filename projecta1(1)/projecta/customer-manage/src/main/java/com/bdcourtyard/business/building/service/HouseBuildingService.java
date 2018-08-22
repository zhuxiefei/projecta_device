package com.bdcourtyard.business.building.service;

import com.bdcourtyard.business.building.domain.BuildingInfo;
import com.bdcourtyard.business.building.model.HouseBuilding;
import com.bdcourtyard.common.page.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *  HouseBuildingService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-23 
 */
public interface HouseBuildingService {
	
	int insertHouseBuilding(HouseBuilding houseBuilding, HttpServletRequest request);
	
	int insertHouseBuildingBatch(List<HouseBuilding> list);
	
	int updateHouseBuildingById(HouseBuilding houseBuilding);
	
	int deleteHouseBuildingById(String buildingId);

 	HouseBuilding getHouseBuildingById(String buildingId);
 
 	List<HouseBuilding> getHouseBuildings(HouseBuilding houseBuilding);

 	Page<HouseBuilding> getHouseBuildingsForPage(HouseBuilding houseBuilding, Pageable pageable);

	List<BuildingInfo> findBuildingList(HttpServletRequest request);
}
