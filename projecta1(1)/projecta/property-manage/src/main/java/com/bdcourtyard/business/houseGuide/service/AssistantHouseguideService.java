package com.bdcourtyard.business.houseGuide.service;

import com.bdcourtyard.business.houseGuide.model.AssistantHouseguide;
import com.bdcourtyard.business.houseGuide.model.GetAssistantHouseguidesForPageReq;
import com.bdcourtyard.common.page.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 *  AssistantHouseguideService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-19 
 */
public interface AssistantHouseguideService {

	int insertAssistantHouseguide(AssistantHouseguide assistantHouseguide);

	int insertAssistantHouseguideBatch(List<AssistantHouseguide> list);

	int updateAssistantHouseguideById(AssistantHouseguide assistantHouseguide);

	void deleteAssistantHouseguideByIds(String guideIds);

 	AssistantHouseguide getAssistantHouseguideById(String guideId);

	Page<AssistantHouseguide> getAssistantHouseguides(String estateId,Pageable pageable);

 	Page<AssistantHouseguide> getAssistantHouseguidesForPage(GetAssistantHouseguidesForPageReq getAssistantHouseguidesForPageReq, Pageable pageable);
}
