package com.bdcourtyard.business.user.dao;

import com.bdcourtyard.business.user.model.AppVersion;
import com.bdcourtyard.common.mybatis.QueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  AppVersionDao 
 *
 * @version : Ver 1.0
 * @date	: 2018-7-25
 */
@Repository
public interface AppVersionDao {
	
	int insertAppVersion(AppVersion appVersion);
	
	int insertAppVersionBatch(List<AppVersion> list);
	
	int updateAppVersionById(AppVersion appVersion);
	
	int deleteAppVersionById(@Param("versionId") String versionId);

 	AppVersion getAppVersionById(@Param("versionId") String versionId);

 	List<AppVersion> getAppVersions(@Param("appVersion") AppVersion appVersion);
 	
 	List<AppVersion> getAppVersionsByConditions(@Param("conditions") List<QueryCondition> conditions);

	AppVersion selectNewestVersion(Integer appType);
}
