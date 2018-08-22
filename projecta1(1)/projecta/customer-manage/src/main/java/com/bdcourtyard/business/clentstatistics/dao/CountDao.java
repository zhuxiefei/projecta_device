package com.bdcourtyard.business.clentstatistics.dao;

import com.bdcourtyard.business.clentstatistics.model.ClientstatisticsParm;
import com.bdcourtyard.business.clentstatistics.model.ClientstatisticsResp;
import com.bdcourtyard.business.clentstatistics.model.TjValue;
import com.bdcourtyard.business.clientmessage.model.ClientNeedreturn;
import com.bdcourtyard.common.mybatis.QueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  ClientNeedreturnDao 客户需回访时间
 *
 * @version : Ver 1.0
 * @date	: 2018-7-26
 */
@Repository
public interface CountDao {
	List<TjValue> getUserCounts(@Param("conditions") List<QueryCondition> conditions);
	List<TjValue> getTypeCounts();
	List<TjValue> getPriceCounts();

}
