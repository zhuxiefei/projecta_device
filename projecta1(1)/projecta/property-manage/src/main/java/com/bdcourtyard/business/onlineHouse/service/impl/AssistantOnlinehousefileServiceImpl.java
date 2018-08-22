package com.bdcourtyard.business.onlineHouse.service.impl;  
import com.bdcourtyard.business.onlineHouse.service.AssistantOnlinehousefileService;
import com.bdcourtyard.business.onlineHouse.dao.AssistantOnlinehousefileDao;
import com.bdcourtyard.business.onlineHouse.model.AssistantOnlinehousefile;
import basic.common.core.dto.PageDto;

import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import com.github.pagehelper.PageHelper;

/**
 *  AssistantOnlinehousefileServiceImpl
 *
 * @version : Ver 1.0
 * @date	: 2018-7-17 
 */
@Service
public class AssistantOnlinehousefileServiceImpl  implements AssistantOnlinehousefileService { 
	
	@Autowired
	private AssistantOnlinehousefileDao assistantOnlinehousefileDao;
	
	public int insertAssistantOnlinehousefile(AssistantOnlinehousefile assistantOnlinehousefile){
		return assistantOnlinehousefileDao.insertAssistantOnlinehousefile(assistantOnlinehousefile);
	}
	public int insertAssistantOnlinehousefileBatch(List<AssistantOnlinehousefile> list){
		return assistantOnlinehousefileDao.insertAssistantOnlinehousefileBatch(list);
	}
	public int updateAssistantOnlinehousefileById(AssistantOnlinehousefile assistantOnlinehousefile){
		return assistantOnlinehousefileDao.updateAssistantOnlinehousefileById(assistantOnlinehousefile);
	}
	public int deleteAssistantOnlinehousefileById(  String onlineId  ,    String pictureId  ){
		return assistantOnlinehousefileDao.deleteAssistantOnlinehousefileById(  onlineId  ,    pictureId  );
	}
	public AssistantOnlinehousefile getAssistantOnlinehousefileById(  String onlineId ){
		return assistantOnlinehousefileDao.getAssistantOnlinehousefileById(  onlineId );
	}
 
 	public List<AssistantOnlinehousefile> getAssistantOnlinehousefiles(AssistantOnlinehousefile assistantOnlinehousefile){
		return assistantOnlinehousefileDao.getAssistantOnlinehousefiles(assistantOnlinehousefile);

 	}

 	public PageDto<AssistantOnlinehousefile> getAssistantOnlinehousefilesForPage(AssistantOnlinehousefile assistantOnlinehousefile, Pageable pageable){
 		
 		 long count = assistantOnlinehousefileDao.getAssistantOnlinehousefiles(assistantOnlinehousefile).size();
			PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
			List<AssistantOnlinehousefile> assistantOnlinehousefiles = assistantOnlinehousefileDao.getAssistantOnlinehousefiles(assistantOnlinehousefile);
			 
			PageDto<AssistantOnlinehousefile> pageDto = new PageDto<AssistantOnlinehousefile>();
			
			if (assistantOnlinehousefiles != null) {
				pageDto.setRows( assistantOnlinehousefiles);
				pageDto.setTotal(count);
			} else {
				pageDto.setRows(new ArrayList<AssistantOnlinehousefile>());
				pageDto.setTotal(0l);
			}
			
			return pageDto;
 	}
}
