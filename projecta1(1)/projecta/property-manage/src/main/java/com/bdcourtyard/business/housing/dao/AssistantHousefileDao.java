package com.bdcourtyard.business.housing.dao;  
import com.bdcourtyard.business.housing.model.AssistantHousefile;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.bdcourtyard.common.mybatis.QueryCondition;

/**
 *  AssistantHousefileDao 房产信息附件关联
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16
 */
@Repository
public interface AssistantHousefileDao {

	int insertAssistantHousefile(AssistantHousefile assistantHousefile);

	int insertAssistantHousefileBatch(List<AssistantHousefile> list);

	int updateAssistantHousefileById(AssistantHousefile assistantHousefile);

	int deleteAssistantHousefileById(@Param("propertyId") String propertyId);

 	AssistantHousefile getAssistantHousefileById(@Param("propertyId") String propertyId);

 	List<AssistantHousefile> getAssistantHousefiles(@Param("assistantHousefile") AssistantHousefile assistantHousefile);

 	List<AssistantHousefile> getAssistantHousefilesByConditions(@Param("conditions") List<QueryCondition> conditions);

	List<String> findUrlByPropertyIdAndFileType(@Param("propertyId") String propertyId, @Param("fileType") Integer fileType);
}
