package com.bdcourtyard.business.housing.dao;  
import com.bdcourtyard.business.housing.domain.FindHouseMsgInfoResp;
import com.bdcourtyard.business.housing.domain.FindHouseMsgsResp;
import com.bdcourtyard.business.housing.model.AoSelectConditionReq;
import com.bdcourtyard.business.housing.model.AssistantHouse;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import com.bdcourtyard.common.mybatis.QueryCondition;

/**
 *  AssistantHouseDao 房产信息
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16
 */
@Repository
public interface AssistantHouseDao {
	
	int insertAssistantHouse(AssistantHouse assistantHouse);
	
	int insertAssistantHouseBatch(List<AssistantHouse> list);
	
	int updateAssistantHouseById(AssistantHouse assistantHouse);

	int deleteAssistantHouseById(@Param("ids") String[] ids);
	
 	AssistantHouse getAssistantHouseById(@Param("propertyId") String propertyId);

 	List<AssistantHouse> getAssistantHouses(@Param("assistantHouse") AssistantHouse assistantHouse);
 	
 	List<AssistantHouse> getAssistantHousesByConditions(@Param("conditions") List<QueryCondition> conditions);

 	//模糊查询
	List<AssistantHouse> getAssistantHouses_new(AoSelectConditionReq aoSelectConditionReq);
	//暂时还没开始图片校验--------------
	//验证图片数量
	int selectAssistantHouseAndAssistantHousefileById(@Param("propertyId") String propertyId);

	List<FindHouseMsgsResp> findByEstateId(String estateId);

	FindHouseMsgInfoResp findByPropertyId(String propertyId);
}
