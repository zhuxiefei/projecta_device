package com.bdcourtyard.business.housetype.dao;

import com.bdcourtyard.business.housetype.domain.FindAllTypesReq;
import com.bdcourtyard.business.housetype.domain.FindAllTypesResp;
import com.bdcourtyard.business.housetype.domain.FindTypeResp;
import com.bdcourtyard.business.housetype.model.HouseType;
import com.bdcourtyard.common.mybatis.QueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  HouseTypeDao 户型图
 *
 * @version : Ver 1.0
 * @date	: 2018-7-23
 */
@Repository
public interface HouseTypeDao {
	
	int insertHouseType(HouseType houseType);
	
	int insertHouseTypeBatch(List<HouseType> list);
	
	int updateHouseTypeById(HouseType houseType);
	
	int deleteHouseTypeById(@Param("typeId") String typeId);

 	HouseType getHouseTypeById(@Param("typeId") String typeId);

 	List<FindAllTypesResp> getHouseTypes(FindAllTypesReq typesReq);
 	
 	List<HouseType> getHouseTypesByConditions(@Param("conditions") List<QueryCondition> conditions);

	HouseType findByNameAndEstateId(@Param("typeName")String typeName,@Param("estateId")String estateId);

	FindTypeResp findByTypeId(String typeId);

	void deleteByIds(String[] typeIds);

	List<HouseType> findByEstateId(String estateId);
}
