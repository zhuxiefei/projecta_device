package com.bdcourtyard.business.file.dao;  
import com.bdcourtyard.business.file.model.SystemFile;
import com.bdcourtyard.business.onlineHouse.model.OnlineFileResq;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.bdcourtyard.common.mybatis.QueryCondition;

/**
 *  SystemFileDao 系统文件
 *
 * @version : Ver 1.0
 * @date	: 2018-7-18
 */
@Repository
public interface SystemFileOneDao {
	
	int insertSystemFile(SystemFile systemFile);
	
	int insertSystemFileBatch(List<SystemFile> list);
	
	int updateSystemFileById(SystemFile systemFile);
	
	int deleteSystemFileById(@Param("ids") String[] ids);
	
 	SystemFile getSystemFileById(@Param("fileId") String fileId);

 	List<SystemFile> getSystemFiles(@Param("systemFile") SystemFile systemFile);
 	
 	List<SystemFile> getSystemFilesByConditions(@Param("conditions") List<QueryCondition> conditions);

 	//房产信息详情图片
	List<SystemFile> getSystemFilesByPropertyId(@Param("propertyId") String propertyId);

	//在线看房详情图片
	List<OnlineFileResq> getSystemFilesByOnlineId(@Param("onlineId") String onlineId);

}
