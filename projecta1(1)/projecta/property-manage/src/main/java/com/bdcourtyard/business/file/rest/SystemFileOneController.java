package com.bdcourtyard.business.file.rest;  
import com.bdcourtyard.business.file.service.SystemFileOneService;
import com.bdcourtyard.business.file.service.SystemFileOneService;
import com.bdcourtyard.business.file.model.SystemFile;
import basic.common.core.dto.PageDto;
import basic.common.core.id.IdUtil;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.bdcourtyard.common.response.Response;
import com.google.common.collect.Lists;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  SystemFileController
 *
 * @version : Ver 1.0
 * @date	: 2018-7-18
 */
@RestController
@Api(value = "SystemFileOneController", description = "系统文件相关")
@RequestMapping(value = "/pm/web/systemFileOne")
public class SystemFileOneController {
	
	   @InitBinder   
	    public void initBinder(WebDataBinder binder) {   
	        DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	        dateFormat.setLenient(true);   
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
	    }  
	
	@Autowired
	private SystemFileOneService systemFileService;
	
	@ApiOperation(value = "新增系统文件", notes = "新增系统文件")
	@RequestMapping(value = "/insertSystemFile", method = RequestMethod.POST)
	public Response<Integer> insertSystemFile(@RequestBody SystemFile systemFile){
		systemFile.setFileId(IdUtil.getId()+"");
    	
		return new Response<Integer>(systemFileService.insertSystemFile(systemFile));
	}
	@ApiOperation(value = "批量新增系统文件", notes = "批量新增系统文件")
	@RequestMapping(value = "/insertSystemFileBatch", method = RequestMethod.POST)
	public Response<Integer> insertSystemFileBatch(@RequestBody List<SystemFile> list){
		return  new Response<Integer>(systemFileService.insertSystemFileBatch(list));
	}
	@ApiOperation(value = "根据ID修改系统文件", notes = "根据ID修改系统文件")
	@RequestMapping(value = "/updateSystemFileById", method = RequestMethod.POST)
	public Response<Integer> updateSystemFileById(@RequestBody SystemFile systemFile){
		return new Response<Integer>(systemFileService.updateSystemFileById(systemFile));
	}
	/*@ApiOperation(value = "根据ID删除系统文件", notes = "根据ID删除系统文件")
	@RequestMapping(value = "/deleteSystemFileById", method = RequestMethod.GET)
	public Response<Integer> deleteSystemFileById( @RequestParam String fileId  ){
		return new Response<Integer>(systemFileService.deleteSystemFileById(  fileId  ));
	}*/
	@ApiOperation(value = "根据ID获取系统文件", notes = "根据ID获取系统文件")
	@RequestMapping(value = "/getSystemFileById", method = RequestMethod.GET)
	public Response<SystemFile> getSystemFileById( @RequestParam String fileId  ){
		return new Response<SystemFile>(systemFileService.getSystemFileById(  fileId  ));
	}
 
	@ApiOperation(value = "根据对象获取系统文件", notes = "根据对象获取系统文件")
	@RequestMapping(value = "/getSystemFiles", method = RequestMethod.POST)
	public  Response<List<SystemFile>> getSystemFiles( @RequestBody SystemFile systemFile){
		return new Response<List<SystemFile>>(systemFileService.getSystemFiles(systemFile));

 	}

	@ApiOperation(value = "根据对象分页获取系统文件", notes = "根据对象分页获取系统文件")
	@RequestMapping(value = "/getSystemFilesForPage", method = RequestMethod.POST)
	public  Response<PageDto<SystemFile>> getSystemFilesForPage(@RequestBody SystemFile systemFile,
			@RequestParam(value="page", defaultValue="1")  int page,
			@RequestParam(value="rows", defaultValue="10") int rows){
		Pageable pageable = new PageRequest(page-1, rows);
		PageDto<SystemFile> pageDto= systemFileService.getSystemFilesForPage(systemFile,pageable);
		return new Response<PageDto<SystemFile>>(pageDto);
 	}
}
