package com.bdcourtyard.business.onlineHouse.service;
import basic.common.core.dto.PageDto;
import org.springframework.data.domain.Pageable;
import com.bdcourtyard.business.onlineHouse.model.AssistantOnlinehousefile;
import java.util.List;

/**
 *  AssistantOnlinehousefileService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-17 
 */
public interface AssistantOnlinehousefileService {
	
	int insertAssistantOnlinehousefile(AssistantOnlinehousefile assistantOnlinehousefile);
	
	int insertAssistantOnlinehousefileBatch(List<AssistantOnlinehousefile> list);
	
	int updateAssistantOnlinehousefileById(AssistantOnlinehousefile assistantOnlinehousefile);
	
	int deleteAssistantOnlinehousefileById(String onlineId, String pictureId);
	
 	AssistantOnlinehousefile getAssistantOnlinehousefileById(String onlineId);
 
 	List<AssistantOnlinehousefile> getAssistantOnlinehousefiles(AssistantOnlinehousefile assistantOnlinehousefile);

 	PageDto<AssistantOnlinehousefile> getAssistantOnlinehousefilesForPage(AssistantOnlinehousefile assistantOnlinehousefile, Pageable pageable);
}
