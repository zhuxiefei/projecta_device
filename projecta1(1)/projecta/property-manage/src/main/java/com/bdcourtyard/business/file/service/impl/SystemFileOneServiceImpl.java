package com.bdcourtyard.business.file.service.impl;  
import com.bdcourtyard.business.file.service.SystemFileOneService;
import com.bdcourtyard.business.file.service.SystemFileOneService;
import com.bdcourtyard.business.file.dao.SystemFileOneDao;
import com.bdcourtyard.business.file.model.SystemFile;
import basic.common.core.dto.PageDto;

import com.bdcourtyard.business.housing.service.impl.AssistantHouseServiceImpl;
import com.bdcourtyard.business.onlineHouse.model.OnlineFileResq;
import com.bdcourtyard.common.exception.GlobalException;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import com.github.pagehelper.PageHelper;

/**
 *  SystemFileServiceImpl
 *
 * @version : Ver 1.0
 * @date	: 2018-7-18 
 */
@Service
public class SystemFileOneServiceImpl  implements SystemFileOneService {
	private static Logger log = Logger.getLogger(SystemFileOneServiceImpl.class);
	@Autowired
	private SystemFileOneDao systemFileDao;
	
	public int insertSystemFile(SystemFile systemFile){
		return systemFileDao.insertSystemFile(systemFile);
	}
	public int insertSystemFileBatch(List<SystemFile> list){
		return systemFileDao.insertSystemFileBatch(list);
	}
	public int updateSystemFileById(SystemFile systemFile){
		return systemFileDao.updateSystemFileById(systemFile);
	}
	public boolean deleteSystemFileById(  String fileId  ){
		try {
			String[] ids = fileId.split(",");
			for (String id : ids) {
				if(id==null&&"".equals(id)){
				}
			}
			systemFileDao.deleteSystemFileById(ids);
			return true;
		}catch (Exception e){
			log.error("异常",e);
			return  false;
		}
	}
	public SystemFile getSystemFileById(  String fileId  ){
		return systemFileDao.getSystemFileById(  fileId  );
	}
 
 	public List<SystemFile> getSystemFiles(SystemFile systemFile){
		return systemFileDao.getSystemFiles(systemFile);

 	}

 	public PageDto<SystemFile> getSystemFilesForPage(SystemFile systemFile, Pageable pageable){
 		
 		 long count = systemFileDao.getSystemFiles(systemFile).size();
			PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
			List<SystemFile> systemFiles = systemFileDao.getSystemFiles(systemFile);
			 
			PageDto<SystemFile> pageDto = new PageDto<SystemFile>();
			
			if (systemFiles != null) {
				pageDto.setRows( systemFiles);
				pageDto.setTotal(count);
			} else {
				pageDto.setRows(new ArrayList<SystemFile>());
				pageDto.setTotal(0l);
			}
			
			return pageDto;
 	}

	public List<SystemFile> getSystemFilesByPropertyId(String propertyId){
 		return systemFileDao.getSystemFilesByPropertyId(propertyId);
	}

	public List<OnlineFileResq> getSystemFilesByOnlineId(String onlineId){
 		return systemFileDao.getSystemFilesByOnlineId(onlineId);
	}
}
