package com.bdcourtyard.business.building.dao;

import com.bdcourtyard.business.building.domain.UnitInfo;
import com.bdcourtyard.business.building.model.HouseBuildingUnit;
import com.bdcourtyard.common.mybatis.QueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  HouseBuildingUnitDao 楼宇单元
 *
 * @version : Ver 1.0
 * @date	: 2018-7-23
 */
@Repository
public interface HouseBuildingUnitDao {
	
	int insertHouseBuildingUnit(HouseBuildingUnit houseBuildingUnit);
	
	int insertHouseBuildingUnitBatch(List<HouseBuildingUnit> list);
	
	int updateHouseBuildingUnitById(HouseBuildingUnit houseBuildingUnit);
	
	int deleteHouseBuildingUnitById(@Param("unitId") String unitId);

 	HouseBuildingUnit getHouseBuildingUnitById(@Param("unitId") String unitId);

 	List<HouseBuildingUnit> getHouseBuildingUnits(@Param("houseBuildingUnit") HouseBuildingUnit houseBuildingUnit);
 	
 	List<HouseBuildingUnit> getHouseBuildingUnitsByConditions(@Param("conditions") List<QueryCondition> conditions);

	void deleteByBuildingId(String buildingId);

	List<HouseBuildingUnit> selectByUnitNameAndBuildingId(@Param("unitName") String unitName,@Param("buildingId") String buildingId);

	List<UnitInfo> findByBuildingId(String buildingId);
}
