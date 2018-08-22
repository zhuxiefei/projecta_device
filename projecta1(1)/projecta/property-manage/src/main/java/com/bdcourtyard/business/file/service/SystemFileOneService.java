package com.bdcourtyard.business.file.service;
import basic.common.core.dto.PageDto;
import com.bdcourtyard.business.onlineHouse.model.OnlineFileResq;
import org.springframework.data.domain.Pageable;
import com.bdcourtyard.business.file.model.SystemFile;
import java.util.List;

/**
 *  SystemFileService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-18 
 */
public interface SystemFileOneService {
	
	int insertSystemFile(SystemFile systemFile);
	
	int insertSystemFileBatch(List<SystemFile> list);
	
	int updateSystemFileById(SystemFile systemFile);
	
	boolean deleteSystemFileById(String fileId);
	
 	SystemFile getSystemFileById(String fileId);
 
 	List<SystemFile> getSystemFiles(SystemFile systemFile);

 	PageDto<SystemFile> getSystemFilesForPage(SystemFile systemFile, Pageable pageable);

 	//房产信息详情图片
	List<SystemFile> getSystemFilesByPropertyId(String propertyId);

 	//在线看房详情图片
	List<OnlineFileResq> getSystemFilesByOnlineId(String onlineId);
}
