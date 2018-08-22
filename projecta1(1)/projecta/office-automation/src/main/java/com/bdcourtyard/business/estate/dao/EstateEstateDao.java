package com.bdcourtyard.business.estate.dao;

import com.bdcourtyard.business.estate.domain.FindEstatesResp;
import com.bdcourtyard.business.estate.model.EstateEstate;
import com.bdcourtyard.common.mybatis.QueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  EstateEstateDao 楼盘
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16
 */
@Repository
public interface EstateEstateDao {
	
	int insertEstateEstate(EstateEstate estateEstate);
	
	int insertEstateEstateBatch(List<EstateEstate> list);
	
	int updateEstateEstateById(EstateEstate estateEstate);
	
	int deleteEstateEstateById(@Param("estateId") String estateId);

 	EstateEstate getEstateEstateById(@Param("estateId") String estateId);

 	List<EstateEstate> getEstateEstates(@Param("estateEstate") EstateEstate estateEstate);
 	
 	List<EstateEstate> getEstateEstatesByConditions(@Param("conditions") List<QueryCondition> conditions);

	List<FindEstatesResp> findEstates(String acctName);
}
