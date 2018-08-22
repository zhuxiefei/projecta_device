package com.bdcourtyard.business.onlineHouse.dao;  
import com.bdcourtyard.business.onlineHouse.model.AssistantOnlinehousefile;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.bdcourtyard.common.mybatis.QueryCondition;

/**
 *  AssistantOnlinehousefileDao 在线看房信息附件关联
 *
 * @version : Ver 1.0
 * @date	: 2018-7-17
 */
@Repository
public interface AssistantOnlinehousefileDao {
	
	int insertAssistantOnlinehousefile(AssistantOnlinehousefile assistantOnlinehousefile);
	
	int insertAssistantOnlinehousefileBatch(List<AssistantOnlinehousefile> list);
	
	int updateAssistantOnlinehousefileById(AssistantOnlinehousefile assistantOnlinehousefile);

	int deleteAssistantOnlinehousefileById(@Param("onlineId")  java.lang.String onlineId  ,  @Param("fileId")  java.lang.String fileId  );
	
 	AssistantOnlinehousefile getAssistantOnlinehousefileById(@Param("onlineId") String onlineId);

 	List<AssistantOnlinehousefile> getAssistantOnlinehousefiles(@Param("assistantOnlinehousefile") AssistantOnlinehousefile assistantOnlinehousefile);
 	
 	List<AssistantOnlinehousefile> getAssistantOnlinehousefilesByConditions(@Param("conditions") List<QueryCondition> conditions);

}
