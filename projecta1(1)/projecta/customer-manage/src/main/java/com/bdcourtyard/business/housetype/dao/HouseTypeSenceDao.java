package com.bdcourtyard.business.housetype.dao;

import com.bdcourtyard.business.housetype.domain.SenceResp;
import com.bdcourtyard.business.housetype.model.HouseTypeSence;
import com.bdcourtyard.common.mybatis.QueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  HouseTypeSenceDao 户型场景图
 *
 * @version : Ver 1.0
 * @date	: 2018-7-30
 */
@Repository
public interface HouseTypeSenceDao {
	
	int insertHouseTypeSence(HouseTypeSence houseTypeSence);
	
	int insertHouseTypeSenceBatch(List<HouseTypeSence> list);
	
	int updateHouseTypeSenceById(HouseTypeSence houseTypeSence);
	
	int deleteHouseTypeSenceById(@Param("senceId") String senceId);

 	HouseTypeSence getHouseTypeSenceById(@Param("senceId") String senceId);

 	List<HouseTypeSence> getHouseTypeSences(@Param("houseTypeSence") HouseTypeSence houseTypeSence);
 	
 	List<HouseTypeSence> getHouseTypeSencesByConditions(@Param("conditions") List<QueryCondition> conditions);

	void deleteByTypeId(String typeId);

	List<SenceResp> fingByTypeId(String typeId);

	void deleteByTypeIds(String[] typeIds);
}
