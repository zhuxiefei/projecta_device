package com.bdcourtyard.business.houseprice.rest;

import basic.common.core.id.IdUtil;
import com.bdcourtyard.business.houseprice.model.SystemRecord;
import com.bdcourtyard.business.houseprice.service.SystemRecordService;
import com.bdcourtyard.common.page.Page;
import com.bdcourtyard.common.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *  SystemRecordController
 *
 * @version : Ver 1.0
 * @date	: 2018-7-24
 */
@RestController
@Api(value = "SystemRecordController", description = "系统操作记录相关")
@RequestMapping(value = "/crm/web/systemRecord")
public class SystemRecordController { 
	
	   @InitBinder   
	    public void initBinder(WebDataBinder binder) {   
	        DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	        dateFormat.setLenient(true);   
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
	    }  
	
	@Autowired
	private SystemRecordService systemRecordService;
	
	@ApiOperation(value = "新增系统操作记录", notes = "新增系统操作记录")
	@RequestMapping(value = "/insertSystemRecord", method = RequestMethod.POST)
	public Response<Integer> insertSystemRecord(@RequestBody SystemRecord systemRecord){
		systemRecord.setActId(IdUtil.getId()+"");
		return new Response<Integer>(systemRecordService.insertSystemRecord(systemRecord));
	}
	@ApiOperation(value = "根据系统操作记录ID修改", notes = "根据系统操作记录ID修改")
	@RequestMapping(value = "/updateSystemRecordById", method = RequestMethod.POST)
	public Response<Integer> updateSystemRecordById(@RequestBody SystemRecord systemRecord){
		return new Response<Integer>(systemRecordService.updateSystemRecordById(systemRecord));
	}
	@ApiOperation(value = "根据系统操作记录ID删除", notes = "根据系统操作记录ID删除")
	@RequestMapping(value = "/deleteSystemRecordById", method = RequestMethod.GET)
	public Response<Integer> deleteSystemRecordById( @RequestParam String actId  ){
		return new Response<Integer>(systemRecordService.deleteSystemRecordById(  actId  ));
	}
	@ApiOperation(value = "根据系统操作记录ID获取", notes = "根据系统操作记录ID获取")
	@RequestMapping(value = "/getSystemRecordById", method = RequestMethod.GET)
	public Response<SystemRecord> getSystemRecordById( @RequestParam String actId  ){
		return new Response<SystemRecord>(systemRecordService.getSystemRecordById(  actId  ));
	}
 
	@ApiOperation(value = "根据系统操作记录对象获取", notes = "根据系统操作记录对象获取")
	@RequestMapping(value = "/getSystemRecords", method = RequestMethod.POST)
	public  Response<List<SystemRecord>> getSystemRecords( @RequestBody SystemRecord systemRecord){
		return new Response<List<SystemRecord>>(systemRecordService.getSystemRecords(systemRecord));

 	}

	@ApiOperation(value = "根据系统操作记录对象分页获取", notes = "根据系统操作记录对象分页获取")
	@RequestMapping(value = "/getSystemRecordsForPage", method = RequestMethod.POST)
	public  Response<Page<SystemRecord>> getSystemRecordsForPage(@RequestBody SystemRecord systemRecord,
			@RequestParam(value="page", defaultValue="1")  int page,
			@RequestParam(value="pageSize", defaultValue="10") int pageSize){
		Pageable pageable = new PageRequest(page, pageSize);
		Page<SystemRecord> pageDto= systemRecordService.getSystemRecordsForPage(systemRecord,pageable);
		return new Response<Page<SystemRecord>>(pageDto);
 	}
}
