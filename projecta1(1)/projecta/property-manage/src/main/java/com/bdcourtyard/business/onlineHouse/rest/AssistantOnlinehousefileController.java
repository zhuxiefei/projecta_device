package com.bdcourtyard.business.onlineHouse.rest;  
import com.bdcourtyard.business.file.model.SystemFile;
import com.bdcourtyard.business.file.service.SystemFileOneService;
import com.bdcourtyard.business.file.service.SystemFileOneService;
import com.bdcourtyard.business.housing.model.AssistantHouse;
import com.bdcourtyard.business.housing.model.AssistantHousefile;
import com.bdcourtyard.business.onlineHouse.model.AssistantOnlineHouse;
import com.bdcourtyard.business.onlineHouse.service.AssistantOnlinehousefileService;
import com.bdcourtyard.business.onlineHouse.model.AssistantOnlinehousefile;
import basic.common.core.dto.PageDto;
import basic.common.core.id.IdUtil;

import com.bdcourtyard.common.exception.GlobalException;
import com.beite.tools.utils.FileUtil;
import com.beite.tools.utils.PropertiesUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.bdcourtyard.common.response.Response;
import com.google.common.collect.Lists;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  AssistantOnlinehousefileController
 *
 * @version : Ver 1.0
 * @date	: 2018-7-17
 */
@RestController
@Api(value = "AssistantOnlinehousefileController", description = "在线看房信息附件关联相关")
@RequestMapping(value = "/pm/web/assistantOnlinehousefile")
public class AssistantOnlinehousefileController { 
	
	   @InitBinder   
	    public void initBinder(WebDataBinder binder) {   
	        DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	        dateFormat.setLenient(true);   
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
	    }  
	
	@Autowired
	private AssistantOnlinehousefileService assistantOnlinehousefileService;
	@Autowired
	private SystemFileOneService systemFileService;
	
	/*@ApiOperation(value = "新增在线看房信息附件关联", notes = "新增在线看房信息附件关联")
	@RequestMapping(value = "/insertAssistantOnlinehousefile", method = RequestMethod.POST)
	public Response<Integer> insertAssistantOnlinehousefile(@RequestBody AssistantOnlinehousefile assistantOnlinehousefile){
		assistantOnlinehousefile.setOnlineId(IdUtil.getId()+"");
		assistantOnlinehousefile.setPictureId(IdUtil.getId()+"");
    	
		return new Response<Integer>(assistantOnlinehousefileService.insertAssistantOnlinehousefile(assistantOnlinehousefile));
	}*/
	@ApiOperation(value = "上传图片", notes = "上传图片")
	@RequestMapping(value = "/AssistantOnlinehousefileupload", method = RequestMethod.POST)
	@ResponseBody
	public SystemFile upload(@RequestBody MultipartFile multipartFile,@RequestParam int fileType,HttpServletRequest request) throws Exception {
		String a = com.bdcourtyard.common.utils.PropertiesUtil.getProperty("fileMaxSize");
		if(multipartFile.getSize()>Integer.parseInt(a)){
			throw new GlobalException("H0017");
		}
		String fileUrl = FileUtil.uploadFile(multipartFile , "online");
		Date createTime = new Date();
		String fileName = multipartFile.getOriginalFilename();
		SystemFile systemFile = new SystemFile();
		systemFile.setFileId(IdUtil.getId()+"");
		systemFile.setFileName(fileName);
		systemFile.setFileUrl(fileUrl);
		systemFile.setCreateTime(createTime);
		int number = FileUtil.getFileType(multipartFile);
		if(number==1){
			systemFile.setFileType(fileType);
		}else{
			throw new GlobalException("H0019");
		}
		systemFileService.insertSystemFile(systemFile);
		return systemFile;
	}

	@ApiOperation(value = "取消上传图片", notes = "取消上传图片")
	@RequestMapping(value = "/AssistantOnlinehousefiledeletefile", method = RequestMethod.GET)
	@ResponseBody
	public Response<Boolean> deletefile(@RequestParam String fileId) throws Exception {
		boolean a = systemFileService.deleteSystemFileById(fileId);
		return new Response<Boolean>(a);
	}

/*	@ApiOperation(value = "取消上传后根据ID删除在线看房信息附件关联", notes = "取消上传后根据ID删除在线看房信息附件关联")
	@RequestMapping(value = "/deletefile", method = RequestMethod.POST)
	@ResponseBody
	public boolean deletefile(@RequestParam("file") MultipartFile file,String fileDir,AssistantOnlinehousefile assistantOnlinehousefile) throws Exception {
		System.out.println(111);
		boolean a = FileUtil.deletefile(fileDir);
		System.out.println(222);
		if(0==assistantOnlinehousefileService.deleteAssistantOnlinehousefileById(assistantOnlinehousefile.getOnlineId(),assistantOnlinehousefile.getPictureId())){
			throw new GlobalException("H0009","删除失败");
		}
		return a;
	}*/


	/*@ApiOperation(value = "批量新增在线看房信息附件关联", notes = "批量新增在线看房信息附件关联")
	@RequestMapping(value = "/insertAssistantOnlinehousefileBatch", method = RequestMethod.POST)
	public Response<Integer> insertAssistantOnlinehousefileBatch(@RequestBody List<AssistantOnlinehousefile> list){
		return  new Response<Integer>(assistantOnlinehousefileService.insertAssistantOnlinehousefileBatch(list));
	}*/
	/*@ApiOperation(value = "根据ID修改在线看房信息附件关联", notes = "根据ID修改在线看房信息附件关联")
	@RequestMapping(value = "/updateAssistantOnlinehousefileById", method = RequestMethod.POST)
	public Response<Integer> updateAssistantOnlinehousefileById(@RequestBody AssistantOnlinehousefile assistantOnlinehousefile){
		return new Response<Integer>(assistantOnlinehousefileService.updateAssistantOnlinehousefileById(assistantOnlinehousefile));
	}
*//*	@ApiOperation(value = "根据ID删除在线看房信息附件关联", notes = "根据ID删除在线看房信息附件关联")
	@RequestMapping(value = "/deleteAssistantOnlinehousefileById", method = RequestMethod.GET)
	public Response<Integer> deleteAssistantOnlinehousefileById( @RequestParam String onlineId  ,   @RequestParam String pictureId  ){
		if(onlineId==null && "".equals(onlineId.trim())){
			throw new GlobalException("H0010");
		}
		return new Response<Integer>(assistantOnlinehousefileService.deleteAssistantOnlinehousefileById(  onlineId  ,    pictureId  ));
	}*//*
	@ApiOperation(value = "根据ID获取在线看房信息附件关联", notes = "根据ID获取在线看房信息附件关联")
	@RequestMapping(value = "/getAssistantOnlinehousefileById", method = RequestMethod.GET)
	public Response<AssistantOnlinehousefile> getAssistantOnlinehousefileById( @RequestParam String onlineId  ,   @RequestParam String pictureId  ){
		return new Response<AssistantOnlinehousefile>(assistantOnlinehousefileService.getAssistantOnlinehousefileById(  onlineId  ,    pictureId  ));
	}
 
*//*	@ApiOperation(value = "根据对象获取在线看房信息附件关联", notes = "根据对象获取在线看房信息附件关联")
	@RequestMapping(value = "/getAssistantOnlinehousefiles", method = RequestMethod.POST)
	public  Response<List<AssistantOnlinehousefile>> getAssistantOnlinehousefiles( @RequestBody AssistantOnlinehousefile assistantOnlinehousefile){
		return new Response<List<AssistantOnlinehousefile>>(assistantOnlinehousefileService.getAssistantOnlinehousefiles(assistantOnlinehousefile));

 	}*//*

	@ApiOperation(value = "根据对象分页获取在线看房信息附件关联", notes = "根据对象分页获取在线看房信息附件关联")
	@RequestMapping(value = "/getAssistantOnlinehousefilesForPage", method = RequestMethod.POST)
	public  Response<PageDto<AssistantOnlinehousefile>> getAssistantOnlinehousefilesForPage(@RequestBody AssistantOnlinehousefile assistantOnlinehousefile,
			@RequestParam(value="page", defaultValue="1")  int page,
			@RequestParam(value="rows", defaultValue="10") int rows){
		Pageable pageable = new PageRequest(page-1, rows);
		PageDto<AssistantOnlinehousefile> pageDto= assistantOnlinehousefileService.getAssistantOnlinehousefilesForPage(assistantOnlinehousefile,pageable);
		return new Response<PageDto<AssistantOnlinehousefile>>(pageDto);
 	}*/
}
