package com.bdcourtyard.business.houseprice.service;
import org.springframework.data.domain.Pageable;
import com.bdcourtyard.business.houseprice.model.SystemRecord;
import java.util.List;
import com.bdcourtyard.common.page.Page;

/**
 *  SystemRecordService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-24 
 */
public interface SystemRecordService {
	
	int insertSystemRecord(SystemRecord systemRecord);
	
	int insertSystemRecordBatch(List<SystemRecord> list);
	
	int updateSystemRecordById(SystemRecord systemRecord);
	
	int deleteSystemRecordById(String actId);
	
 	SystemRecord getSystemRecordById(String actId);

	void addRecord(String modelType, String optType, String relId, String actContent,String employeeId);
 
 	List<SystemRecord> getSystemRecords(SystemRecord systemRecord);

 	Page<SystemRecord> getSystemRecordsForPage(SystemRecord systemRecord, Pageable pageable);
}
