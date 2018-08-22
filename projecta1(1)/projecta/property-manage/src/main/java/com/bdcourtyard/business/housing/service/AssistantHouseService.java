package com.bdcourtyard.business.housing.service;
import basic.common.core.dto.PageDto;
import com.bdcourtyard.business.device.model.PageInfo;
import com.bdcourtyard.business.housing.domain.FindHouseMsgInfoResp;
import com.bdcourtyard.business.housing.domain.FindHouseMsgsResp;

import com.bdcourtyard.business.housing.model.AoSelectConditionReq;
import com.bdcourtyard.common.page.Page;
import org.springframework.data.domain.Pageable;
import com.bdcourtyard.business.housing.model.AssistantHouse;

import java.util.List;

/**
 *  AssistantHouseService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16 
 */
public interface AssistantHouseService {
	
	int insertAssistantHouse(AssistantHouse assistantHouse);
	
	int insertAssistantHouseBatch(List<AssistantHouse> list);
	
	int updateAssistantHouseById(AssistantHouse assistantHouse);
	
	boolean deleteAssistantHouseById(String propertyId);
	
 	AssistantHouse getAssistantHouseById(String propertyId);
 
 	List<AssistantHouse> getAssistantHouses(AssistantHouse assistantHouse);

	//PageDto<AssistantHouse> getAssistantHousesForPage(String title, String adminId, String startTime, String endTime, String estateId, Pageable pageable);
	Page<AssistantHouse> getAssistantHousesForPage(AoSelectConditionReq aoSelectConditionReq, Pageable pageable);

	Page<FindHouseMsgsResp> findByEstateId(String estateId,Pageable pageable);

	FindHouseMsgInfoResp findByPropertyId(String propertyId);
}
