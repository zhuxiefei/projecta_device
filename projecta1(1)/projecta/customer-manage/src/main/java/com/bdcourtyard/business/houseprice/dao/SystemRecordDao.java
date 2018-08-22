package com.bdcourtyard.business.houseprice.dao;
import com.bdcourtyard.business.houseprice.model.SystemRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.bdcourtyard.common.mybatis.QueryCondition;

/**
 *  SystemRecordDao 
 *
 * @version : Ver 1.0
 * @date	: 2018-7-24
 */
@Repository
public interface SystemRecordDao {
	
	int insertSystemRecord(SystemRecord systemRecord);
	
	int insertSystemRecordBatch(List<SystemRecord> list);
	
	int updateSystemRecordById(SystemRecord systemRecord);
	
	int deleteSystemRecordById(@Param("actId") String actId);
	
 	SystemRecord getSystemRecordById(@Param("actId") String actId);

 	List<SystemRecord> getSystemRecords(@Param("systemRecord") SystemRecord systemRecord);
 	
 	List<SystemRecord> getSystemRecordsByConditions(@Param("conditions") List<QueryCondition> conditions);

}
