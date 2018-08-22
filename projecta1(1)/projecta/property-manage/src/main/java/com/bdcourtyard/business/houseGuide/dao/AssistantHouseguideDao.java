package com.bdcourtyard.business.houseGuide.dao;

import com.bdcourtyard.business.houseGuide.model.AssistantHouseguide;
import com.bdcourtyard.business.houseGuide.model.GetAssistantHouseguidesForPageReq;
import com.bdcourtyard.common.mybatis.QueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  AssistantHouseguideDao 购房指南信息
 *
 * @version : Ver 1.0
 * @date	: 2018-7-19
 */
@Repository
public interface AssistantHouseguideDao {
	
	int insertAssistantHouseguide(AssistantHouseguide assistantHouseguide);
	
	int insertAssistantHouseguideBatch(List<AssistantHouseguide> list);
	
	int updateAssistantHouseguideById(AssistantHouseguide assistantHouseguide);
	
	int deleteAssistantHouseguideById(@Param("guideId") String guideId);

 	AssistantHouseguide getAssistantHouseguideById(@Param("guideId") String guideId);

 	List<AssistantHouseguide> getAssistantHouseguides(@Param("assistantHouseguide") AssistantHouseguide assistantHouseguide);
 	
 	List<AssistantHouseguide> getAssistantHouseguidesByConditions(@Param("conditions") List<QueryCondition> conditions);

	List<AssistantHouseguide> findByEstateId(String estateId);

	List<AssistantHouseguide> getAssistantHouseguidesForPage(GetAssistantHouseguidesForPageReq getAssistantHouseguidesForPageReq);
}
