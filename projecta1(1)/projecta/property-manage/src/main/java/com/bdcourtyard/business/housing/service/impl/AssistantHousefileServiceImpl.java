package com.bdcourtyard.business.housing.service.impl;  
import com.bdcourtyard.business.housing.service.AssistantHousefileService;
import com.bdcourtyard.business.housing.dao.AssistantHousefileDao;
import com.bdcourtyard.business.housing.model.AssistantHousefile;
import basic.common.core.dto.PageDto;

import com.bdcourtyard.common.exception.GlobalException;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import com.github.pagehelper.PageHelper;

/**
 *  AssistantHousefileServiceImpl
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16 
 */
@Service
public class AssistantHousefileServiceImpl  implements AssistantHousefileService { 
	
	@Autowired
	private AssistantHousefileDao assistantHousefileDao;
	
	public int insertAssistantHousefile(AssistantHousefile assistantHousefile){
		assistantHousefile.setPropertyId(assistantHousefile.getPropertyId().trim());
		assistantHousefile.setFileId(assistantHousefile.getFileId().trim());
		System.out.println(33);
		if(assistantHousefile.getFileId()==null && "".equals(assistantHousefile.getFileId().trim())){
			throw new GlobalException("H0010","房产信息附件id为空");
		}
		if(assistantHousefile.getPropertyId()==null && "".equals(assistantHousefile.getPropertyId().trim())){
			throw new GlobalException("H0008","房产信息id为空");
		}
		return assistantHousefileDao.insertAssistantHousefile(assistantHousefile);
	}
	public int insertAssistantHousefileBatch(List<AssistantHousefile> list){
		return assistantHousefileDao.insertAssistantHousefileBatch(list);
	}
	public int updateAssistantHousefileById(AssistantHousefile assistantHousefile){
		return assistantHousefileDao.updateAssistantHousefileById(assistantHousefile);
	}
	public int deleteAssistantHousefileById(  String propertyId ){
		return assistantHousefileDao.deleteAssistantHousefileById(  propertyId  );
	}
	public AssistantHousefile getAssistantHousefileById(  String propertyId ){
		return assistantHousefileDao.getAssistantHousefileById(  propertyId );
	}
 
 	public List<AssistantHousefile> getAssistantHousefiles(AssistantHousefile assistantHousefile){
		return assistantHousefileDao.getAssistantHousefiles(assistantHousefile);

 	}

 	public PageDto<AssistantHousefile> getAssistantHousefilesForPage(AssistantHousefile assistantHousefile, Pageable pageable){
 		
 		 long count = assistantHousefileDao.getAssistantHousefiles(assistantHousefile).size();
			PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
			List<AssistantHousefile> assistantHousefiles = assistantHousefileDao.getAssistantHousefiles(assistantHousefile);
			 
			PageDto<AssistantHousefile> pageDto = new PageDto<AssistantHousefile>();
			
			if (assistantHousefiles != null) {
				pageDto.setRows( assistantHousefiles);
				pageDto.setTotal(count);
			} else {
				pageDto.setRows(new ArrayList<AssistantHousefile>());
				pageDto.setTotal(0l);
			}
			
			return pageDto;
 	}
}
