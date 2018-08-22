package com.bdcourtyard.business.onlineHouse.service;
import basic.common.core.dto.PageDto;
import com.bdcourtyard.business.onlineHouse.model.AoConditionReq;
import org.springframework.data.domain.Pageable;
import com.bdcourtyard.business.onlineHouse.model.AssistantOnlineHouse;
import com.bdcourtyard.common.page.Page;

import java.util.HashMap;
import java.util.List;

/**
 *  AssistantOnlineHouseService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-17 
 */
public interface AssistantOnlineHouseService {
	
	int insertAssistantOnlineHouse(AssistantOnlineHouse assistantOnlineHouse);
	
	int insertAssistantOnlineHouseBatch(List<AssistantOnlineHouse> list);
	
	int updateAssistantOnlineHouseById(AssistantOnlineHouse assistantOnlineHouse);
	
	boolean deleteAssistantOnlineHouseById(String onlineId);
	
 	AssistantOnlineHouse getAssistantOnlineHouseById(String onlineId);
 
 	List<AssistantOnlineHouse> getAssistantOnlineHouses(AssistantOnlineHouse assistantOnlineHouse);

	Page<AssistantOnlineHouse> getAssistantOnlineHousesForPage(AoConditionReq aoConditionReq, Pageable pageable);

	//户型名称不重复
	List<AssistantOnlineHouse> selectAllAssistantOnlineHouses(String houseType);
}
