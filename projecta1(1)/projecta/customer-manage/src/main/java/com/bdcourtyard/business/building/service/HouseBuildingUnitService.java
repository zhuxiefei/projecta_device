package com.bdcourtyard.business.building.service;

import com.bdcourtyard.business.building.domain.UnitInfo;
import com.bdcourtyard.business.building.model.HouseBuildingUnit;
import com.bdcourtyard.common.page.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 *  HouseBuildingUnitService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-23 
 */
public interface HouseBuildingUnitService {
	
	int insertHouseBuildingUnit(HouseBuildingUnit houseBuildingUnit);
	
	int insertHouseBuildingUnitBatch(List<HouseBuildingUnit> list);
	
	int updateHouseBuildingUnitById(HouseBuildingUnit houseBuildingUnit);
	
	int deleteHouseBuildingUnitById(String unitId);

 	HouseBuildingUnit getHouseBuildingUnitById(String unitId);
 
 	List<HouseBuildingUnit> getHouseBuildingUnits(HouseBuildingUnit houseBuildingUnit);

 	Page<HouseBuildingUnit> getHouseBuildingUnitsForPage(HouseBuildingUnit houseBuildingUnit, Pageable pageable);

	List<UnitInfo> findByBuildingId(String buildingId);
}
