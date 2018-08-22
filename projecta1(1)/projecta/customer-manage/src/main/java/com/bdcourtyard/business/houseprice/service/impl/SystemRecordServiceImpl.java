package com.bdcourtyard.business.houseprice.service.impl;

import basic.common.core.id.IdUtil;
import com.bdcourtyard.business.houseprice.dao.SystemRecordDao;
import com.bdcourtyard.business.houseprice.model.SystemRecord;
import com.bdcourtyard.business.houseprice.service.SystemRecordService;
import com.bdcourtyard.common.page.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  SystemRecordServiceImpl
 *
 * @version : Ver 1.0
 * @date	: 2018-7-24 
 */
@Service
public class SystemRecordServiceImpl  implements SystemRecordService { 
	
	@Autowired
	private SystemRecordDao systemRecordDao;
	
	public int insertSystemRecord(SystemRecord systemRecord){
		return systemRecordDao.insertSystemRecord(systemRecord);
	}
	public int insertSystemRecordBatch(List<SystemRecord> list){
		return systemRecordDao.insertSystemRecordBatch(list);
	}
	public int updateSystemRecordById(SystemRecord systemRecord){
		return systemRecordDao.updateSystemRecordById(systemRecord);
	}
	public int deleteSystemRecordById(  String actId  ){
		return systemRecordDao.deleteSystemRecordById(  actId  );
	}
	public SystemRecord getSystemRecordById(  String actId  ){
		return systemRecordDao.getSystemRecordById(  actId  );
	}
 
 	public List<SystemRecord> getSystemRecords(SystemRecord systemRecord){
		return systemRecordDao.getSystemRecords(systemRecord);

 	}
 	@Override
	public void addRecord(String modelType, String optType, String relId, String actContent,String employeeId) {
		SystemRecord record = new SystemRecord();
		record.setActId(IdUtil.getId()+"");
		record.setCreatTime(new Date());
		record.setModelType(modelType);
		record.setOptType(optType);
		record.setReaId(relId);
		record.setActContent(actContent);
		record.setEmployeeId(employeeId);
		systemRecordDao.insertSystemRecord(record);

	}
 	public Page<SystemRecord> getSystemRecordsForPage(SystemRecord systemRecord, Pageable pageable){
 		
 		 long count = systemRecordDao.getSystemRecords(systemRecord).size();
			PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
			List<SystemRecord> systemRecords = systemRecordDao.getSystemRecords(systemRecord);
			 
			Page<SystemRecord> pageDto = new Page<SystemRecord>();
			pageDto.setPage(pageable.getPageNumber());
			pageDto.setPageSize(pageable.getPageSize());
			if (systemRecords != null) {
				pageDto.setRows( systemRecords);
				pageDto.setTotal(count);
			} else {
				pageDto.setRows(new ArrayList<SystemRecord>());
				pageDto.setTotal(0l);
			}
			
			return pageDto;
 	}
}
