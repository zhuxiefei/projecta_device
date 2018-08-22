package com.bdcourtyard.business.onlineHouse.dao;  
import com.bdcourtyard.business.housing.model.AoSelectConditionReq;
import com.bdcourtyard.business.housing.model.AssistantHouse;
import com.bdcourtyard.business.onlineHouse.model.AoConditionReq;
import com.bdcourtyard.business.onlineHouse.model.AssistantOnlineHouse;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import com.bdcourtyard.common.mybatis.QueryCondition;

/**
 *  AssistantOnlineHouseDao 在线看房信息
 *
 * @version : Ver 1.0
 * @date	: 2018-7-17
 */
@Repository
public interface AssistantOnlineHouseDao {
	
	int insertAssistantOnlineHouse(AssistantOnlineHouse assistantOnlineHouse);
	
	int insertAssistantOnlineHouseBatch(List<AssistantOnlineHouse> list);
	
	int updateAssistantOnlineHouseById(AssistantOnlineHouse assistantOnlineHouse);
	
	int deleteAssistantOnlineHouseById(@Param("onlineId") String onlineId);
	
 	AssistantOnlineHouse getAssistantOnlineHouseById(@Param("onlineId") String onlineId);

 	List<AssistantOnlineHouse> getAssistantOnlineHouses(@Param("assistantOnlineHouse") AssistantOnlineHouse assistantOnlineHouse);
 	
 	List<AssistantOnlineHouse> getAssistantOnlineHousesByConditions(@Param("conditions") List<QueryCondition> conditions);

	//模糊查询
	List<AssistantOnlineHouse> getAssistantOnlineHouses_new(AoConditionReq aoConditionReq);

	//户型名称不重复
	List<AssistantOnlineHouse> selectAllAssistantOnlineHouses(@Param("houseType") String houseType);

}
