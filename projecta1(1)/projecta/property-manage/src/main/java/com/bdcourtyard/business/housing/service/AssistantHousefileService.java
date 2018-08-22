package com.bdcourtyard.business.housing.service;
import basic.common.core.dto.PageDto;
import org.springframework.data.domain.Pageable;
import com.bdcourtyard.business.housing.model.AssistantHousefile;
import java.util.List;

/**
 *  AssistantHousefileService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16 
 */
public interface AssistantHousefileService {
	
	int insertAssistantHousefile(AssistantHousefile assistantHousefile);
	
	int insertAssistantHousefileBatch(List<AssistantHousefile> list);
	
	int updateAssistantHousefileById(AssistantHousefile assistantHousefile);
	
	int deleteAssistantHousefileById(String propertyId);
	
 	AssistantHousefile getAssistantHousefileById(String propertyId);
 
 	List<AssistantHousefile> getAssistantHousefiles(AssistantHousefile assistantHousefile);

 	PageDto<AssistantHousefile> getAssistantHousefilesForPage(AssistantHousefile assistantHousefile, Pageable pageable);
}
