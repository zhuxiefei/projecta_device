package com.bdcourtyard.business.common.dao;

import com.bdcourtyard.business.common.model.SystemNotice;
import com.bdcourtyard.business.user.domain.SystemNoticeInfo;
import com.bdcourtyard.common.mybatis.QueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  SystemNoticeDao 系统通知
 *
 * @version : Ver 1.0
 * @date	: 2018-7-25
 */
@Repository
public interface SystemNoticeDao {
	
	int insertSystemNotice(SystemNotice systemNotice);
	
	int insertSystemNoticeBatch(List<SystemNotice> list);
	
	int updateSystemNoticeById(SystemNotice systemNotice);
	
	int deleteSystemNoticeById(@Param("noticeId") String noticeId);

 	SystemNotice getSystemNoticeById(@Param("noticeId") String noticeId);

 	List<SystemNotice> getSystemNotices(@Param("systemNotice") SystemNotice systemNotice);
 	
 	List<SystemNotice> getSystemNoticesByConditions(@Param("conditions") List<QueryCondition> conditions);

	int findSystemNoticeNumber(String empId);

	List<SystemNoticeInfo> findAllNotices(String empId);
}
