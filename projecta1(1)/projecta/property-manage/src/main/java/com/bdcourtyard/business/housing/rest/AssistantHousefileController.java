package com.bdcourtyard.business.housing.rest;  
import com.bdcourtyard.business.file.service.SystemFileOneService;
import com.bdcourtyard.business.file.model.SystemFile;
import com.bdcourtyard.business.file.service.SystemFileOneService;
import com.bdcourtyard.business.housing.model.AssistantHouse;
import com.bdcourtyard.business.housing.service.AssistantHousefileService;
import com.bdcourtyard.business.housing.model.AssistantHousefile;
import basic.common.core.dto.PageDto;
import basic.common.core.id.IdUtil;

import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.utils.PropertiesUtil;
import com.beite.tools.utils.FileUtil;
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

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  AssistantHousefileController
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16
 */
@RestController
@Api(value = "AssistantHousefileController", description = "房产信息附件关联相关")
@RequestMapping(value = "/pm/web/assistantHousefile")
public class AssistantHousefileController { 
	
	   @InitBinder   
	    public void initBinder(WebDataBinder binder) {   
	        DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	        dateFormat.setLenient(true);   
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
	    }  
	
	@Autowired
	private AssistantHousefileService assistantHousefileService;
	@Autowired
	private SystemFileOneService systemFileService;
	
	/*@ApiOperation(value = "新增房产信息附件关联", notes = "新增房产信息附件关联")
	@RequestMapping(value = "/insertAssistantHousefile", method = RequestMethod.POST)
	public Response<Integer> insertAssistantHousefile(@RequestBody AssistantHousefile assistantHousefile){
		assistantHousefile.setPropertyId(IdUtil.getId()+"");
		return new Response<Integer>(assistantHousefileService.insertAssistantHousefile(assistantHousefile));
	}*/
	@ApiOperation(value = "上传图片", notes = "上传图片")
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public SystemFile upload(@RequestBody MultipartFile multipartFile, HttpServletRequest request)throws Exception {
		String a = PropertiesUtil.getProperty("fileMaxSize");
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
			systemFile.setFileType(2);
		}else if(number==2){
			systemFile.setFileType(1);
			FileUtil.saveThumbnail(fileUrl);
		}else{
			throw new GlobalException("H0019");
		}

		systemFileService.insertSystemFile(systemFile);
		return systemFile;
	}
	@ApiOperation(value = "取消上传图片", notes = "取消上传图片")
	@RequestMapping(value = "/deletefile", method = RequestMethod.GET)
	@ResponseBody
	public Response<Boolean> deletefile(@RequestParam String fileId) throws Exception {
		boolean a = systemFileService.deleteSystemFileById(fileId);
		return new Response<Boolean>(a);
	}
/*	@ApiOperation(value = "批量新增房产信息附件关联", notes = "批量新增房产信息附件关联")
	@RequestMapping(value = "/insertAssistantHousefileBatch", method = RequestMethod.POST)
	public Response<Integer> insertAssistantHousefileBatch(@RequestBody List<AssistantHousefile> list){
		return  new Response<Integer>(assistantHousefileService.insertAssistantHousefileBatch(list));
	}*/
	/*@ApiOperation(value = "根据ID修改房产信息附件关联", notes = "根据ID修改房产信息附件关联")
	@RequestMapping(value = "/updateAssistantHousefileById", method = RequestMethod.POST)
	public Response<Integer> updateAssistantHousefileById(@RequestBody AssistantHousefile assistantHousefile){
		return new Response<Integer>(assistantHousefileService.updateAssistantHousefileById(assistantHousefile));
	}
	@ApiOperation(value = "根据ID删除房产信息附件关联", notes = "根据ID删除房产信息附件关联")
	@RequestMapping(value = "/deleteAssistantHousefileById", method = RequestMethod.GET)
	public Response<Integer> deleteAssistantHousefileById( @RequestParam String propertyId  ,   @RequestParam String pictureId  ){
		if(propertyId==null && "".equals(propertyId.trim())){
			throw new GlobalException("H0016");
		}
		return new Response<Integer>(assistantHousefileService.deleteAssistantHousefileById(  propertyId  ,    pictureId  ));
	}
	@ApiOperation(value = "根据ID获取房产信息附件关联", notes = "根据ID获取房产信息附件关联")
	@RequestMapping(value = "/getAssistantHousefileById", method = RequestMethod.GET)
	public Response<AssistantHousefile> getAssistantHousefileById( @RequestParam String propertyId  ,   @RequestParam String pictureId  ){
		return new Response<AssistantHousefile>(assistantHousefileService.getAssistantHousefileById(  propertyId  ,    pictureId  ));
	}
 
	@ApiOperation(value = "根据对象获取房产信息附件关联", notes = "根据对象获取房产信息附件关联")
	@RequestMapping(value = "/getAssistantHousefiles", method = RequestMethod.POST)
	public  Response<List<AssistantHousefile>> getAssistantHousefiles( @RequestBody AssistantHousefile assistantHousefile){
		return new Response<List<AssistantHousefile>>(assistantHousefileService.getAssistantHousefiles(assistantHousefile));

 	}

	@ApiOperation(value = "根据对象分页获取房产信息附件关联", notes = "根据对象分页获取房产信息附件关联")
	@RequestMapping(value = "/getAssistantHousefilesForPage", method = RequestMethod.POST)
	public  Response<PageDto<AssistantHousefile>> getAssistantHousefilesForPage(@RequestBody AssistantHousefile assistantHousefile,
			@RequestParam(value="page", defaultValue="1")  int page,
			@RequestParam(value="rows", defaultValue="10") int rows){
		Pageable pageable = new PageRequest(page-1, rows);
		PageDto<AssistantHousefile> pageDto= assistantHousefileService.getAssistantHousefilesForPage(assistantHousefile,pageable);
		return new Response<PageDto<AssistantHousefile>>(pageDto);
 	}*/
}
