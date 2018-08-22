package com.bdcourtyard.business.common.dao;

import com.bdcourtyard.business.common.model.SystemFile;
import com.bdcourtyard.common.mybatis.QueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  SystemFileDao 系统文件
 *
 * @version : Ver 1.0
 * @date	: 2018-7-18
 */
@Repository
public interface SystemFileDao {
	
	int insertSystemFile(SystemFile systemFile);
	
	int insertSystemFileBatch(List<SystemFile> list);
	
	int updateSystemFileById(SystemFile systemFile);
	
	int deleteSystemFileById(@Param("fileId") String fileId);

 	SystemFile getSystemFileById(@Param("fileId") String fileId);

 	List<SystemFile> getSystemFiles(@Param("systemFile") SystemFile systemFile);
 	
 	List<SystemFile> getSystemFilesByConditions(@Param("conditions") List<QueryCondition> conditions);

	void deleteByFileIds(List<String> fileIds);

}
