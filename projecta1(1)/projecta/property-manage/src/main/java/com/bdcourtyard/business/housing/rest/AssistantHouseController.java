package com.bdcourtyard.business.housing.rest;  
import com.bdcourtyard.business.device.model.PageInfo;
import com.bdcourtyard.business.file.model.SystemFile;
import com.bdcourtyard.business.file.service.SystemFileOneService;
import com.bdcourtyard.business.file.service.SystemFileOneService;
import com.bdcourtyard.business.housing.model.*;
import com.bdcourtyard.business.housing.service.AssistantHouseService;
import basic.common.core.dto.PageDto;
import basic.common.core.id.IdUtil;

import com.bdcourtyard.business.housing.service.AssistantHousefileService;
import com.bdcourtyard.business.onlineHouse.model.AoConditionReq;
import com.bdcourtyard.business.onlineHouse.model.AssistantOnlinehousefile;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;
import com.beite.tools.utils.AESUtil;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.HttpRequestHandler;
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

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *  AssistantHouseController
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16
 */
@RestController
@Api(value = "AssistantHouseController", description = "房产信息相关")
@RequestMapping(value = "/pm/web/assistantHouse")
public class AssistantHouseController { 
	
	   @InitBinder   
	    public void initBinder(WebDataBinder binder) {   
	        DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	        dateFormat.setLenient(true);   
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
	    }  
	
	@Autowired
	private AssistantHouseService assistantHouseService;
	@Autowired
	private AssistantHousefileService assistantHousefileService;
	@Autowired
	private SystemFileOneService systemFileService;
	
	@ApiOperation(value = "新增房产信息", notes = "新增房产信息")
	@RequestMapping(value = "/insertAssistantHouse", method = RequestMethod.POST)
	public Response<Integer> insertAssistantHouse(@RequestBody AddAssistantHouseReq houseReq,HttpServletRequest request){
		AssistantHouse assistantHouse = new AssistantHouse(IdUtil.getId()+"",houseReq.getTitle(),
				houseReq.getContent(),null,null,null);
		Date createTime = new Date();
		assistantHouse.setCreateTime(createTime);
		String estateId;
		try {
			estateId = AESUtil.decrypt(request.getHeader("estateId"));
		} catch (Exception e) {
			throw new GlobalException("99999");
		}
		if(estateId==null||"".equals(estateId.trim())){
			throw new GlobalException("H0001");
		}else{
			assistantHouse.setEstateId(estateId);
		}
		String adminid;
		try {
			adminid = AESUtil.decrypt(request.getHeader("employeeId"));
		} catch (Exception e) {
			throw new GlobalException("99999");
		}
		if(adminid==null||"".equals(adminid.trim())){
			throw new GlobalException("H0001");
		}else{
			assistantHouse.setAdminId(adminid);
		}
		assistantHouse.setTitle(assistantHouse.getTitle().trim());
		assistantHouse.setContent(assistantHouse.getContent().trim());
		//新增前验证标题
		if(assistantHouse.getTitle()!=null && !("".equals(assistantHouse.getTitle().trim()))){
			if(assistantHouse.getTitle().length()>50){
				throw new GlobalException("H0003");
			}
		}else{
			throw new GlobalException("H0002");
		}
		//新增前验证内容
		if(assistantHouse.getContent()!=null && !("".equals(assistantHouse.getContent().trim()))){
			if(assistantHouse.getContent().length()>5000){
				throw new GlobalException("H0005");
			}
		}else{
			throw new GlobalException("H0004");
		}

		if(houseReq.getFileId()!=null && !("".equals(houseReq.getFileId()))){
			//生成附件表
			String[] fileIds = houseReq.getFileId().split(",");
			for(String fileId : fileIds){
				AssistantHousefile assistantHousefile = new AssistantHousefile();
				assistantHousefile.setPropertyId(assistantHouse.getPropertyId());
				assistantHousefile.setFileId(fileId);
				assistantHousefile.setCreateTime(createTime);
				if (1 == systemFileService.getSystemFileById(fileId).getFileType()){
					assistantHousefile.setFileType(2);
				}else {
					assistantHousefile.setFileType(1);
				}
				assistantHousefileService.insertAssistantHousefile(assistantHousefile);
			}
		}

		return new Response<Integer>(assistantHouseService.insertAssistantHouse(assistantHouse));
	}
	@ApiOperation(value = "根据ID修改房产信息", notes = "根据ID修改房产信息")
	@RequestMapping(value = "/updateAssistantHouseById", method = RequestMethod.POST)
	public Response<Integer> updateAssistantHouseById(@RequestBody UpdateAssistantHouseReq updateAssistantHouseReq,HttpServletRequest request){
		if(updateAssistantHouseReq.getPropertyId()==null && "".equals(updateAssistantHouseReq.getPropertyId().trim())){
			throw new GlobalException("H0024");
		}
		AssistantHouse assistantHouse = assistantHouseService.getAssistantHouseById(updateAssistantHouseReq.getPropertyId());
		Date createTime = new Date();

		String estateId;
		try {
			estateId = AESUtil.decrypt(request.getHeader("estateId"));
		} catch (Exception e) {
			throw new GlobalException("99999");
		}
		if(estateId==null||"".equals(estateId.trim())){
			throw new GlobalException("H0001");
		}else{
			assistantHouse.setEstateId(estateId);
		}
		String adminid;
		try {
			adminid = AESUtil.decrypt(request.getHeader("employeeId"));
		} catch (Exception e) {
			throw new GlobalException("99999");
		}
		if(adminid==null||"".equals(adminid.trim())){
			throw new GlobalException("H0001");
		}else{
			assistantHouse.setAdminId(adminid);
		}

		assistantHouse.setCreateTime(createTime);

		assistantHouse.setTitle(updateAssistantHouseReq.getTitle().trim());
		assistantHouse.setContent(updateAssistantHouseReq.getContent().trim());
		//修改前验证标题
		if(assistantHouse.getTitle()!=null && !("".equals(assistantHouse.getTitle().trim()))){
			if(assistantHouse.getTitle().length()>50){
				throw new GlobalException("H0003");
			}
		}else{
			throw new GlobalException("H0002");
		}
		//修改前验证内容
		if(assistantHouse.getContent()!=null && !("".equals(assistantHouse.getContent().trim()))){
			if(assistantHouse.getContent().length()>5000){
				throw new GlobalException("H0005");
			}
		}else{
			throw new GlobalException("H0004");
		}
		int result = assistantHousefileService.deleteAssistantHousefileById(updateAssistantHouseReq.getPropertyId());
		if(result<0){
			throw new GlobalException("H0023");
		}
		//重新添加关联关系
		if(updateAssistantHouseReq.getFileId()!=null && !("".equals(updateAssistantHouseReq.getFileId()))){
			String[] fileIds = updateAssistantHouseReq.getFileId().split(",");
			for(String fileId : fileIds){
				SystemFile systemFile = systemFileService.getSystemFileById(fileId);
				AssistantHousefile assistantHousefile = new AssistantHousefile();
				assistantHousefile.setPropertyId(updateAssistantHouseReq.getPropertyId());
				assistantHousefile.setFileType(systemFile.getFileType());
				assistantHousefile.setFileId(fileId);
				assistantHousefile.setCreateTime(createTime);
				int a = assistantHousefileService.insertAssistantHousefile(assistantHousefile);
				if(a<0){
					throw new GlobalException("H0018");
				}
			}
		}
		return new Response<Integer>(assistantHouseService.updateAssistantHouseById(assistantHouse));
	}
	@ApiOperation(value = "根据ID删除房产信息", notes = "根据ID删除房产信息")
	@RequestMapping(value = "/deleteAssistantHouseById", method = RequestMethod.GET)
	public Response<Boolean> deleteAssistantHouseById( @RequestParam String propertyId  ){
		if(propertyId==null||"".equals(propertyId.trim())){
			throw new GlobalException("H0008");
		}
		boolean a =  assistantHouseService.deleteAssistantHouseById(propertyId);
		if(!a){
			throw new GlobalException("H0009");
		}
		return new Response<Boolean>(a);
	}
	@ApiOperation(value = "根据ID获取房产信息", notes = "根据ID获取房产信息")
	@RequestMapping(value = "/getAssistantHouseById", method = RequestMethod.GET)
	public Response<HouseResponse> getAssistantHouseById( @RequestParam String propertyId  ){
		HouseResponse houseResponse = new HouseResponse();
		houseResponse.setAssistantHouse(assistantHouseService.getAssistantHouseById(propertyId));

		List<SystemFile> list = systemFileService.getSystemFilesByPropertyId(propertyId);
		houseResponse.setSystemFiles(list);
		return new Response<HouseResponse>(houseResponse);
	}

	@ApiOperation(value = "根据对象分页获取房产信息", notes = "根据对象分页获取房产信息")
	@RequestMapping(value = "/getAssistantHousesForPage", method = RequestMethod.POST)
	public  Response<Page<AssistantHouse>> getAssistantHousesForPage(@RequestBody AoSelectConditionReq aoSelectConditionReq,HttpServletRequest request){
		Pageable pageable = new PageRequest(aoSelectConditionReq.getPage(),aoSelectConditionReq.getPageSize());
		String estateId;
		try {
			estateId = AESUtil.decrypt(request.getHeader("estateId"));
		} catch (Exception e) {
			throw new GlobalException("99999");
		}
		aoSelectConditionReq.setEstateId(estateId);
		Page<AssistantHouse> pageDto= assistantHouseService.getAssistantHousesForPage(aoSelectConditionReq,pageable);
		return new Response<Page<AssistantHouse>>(pageDto);
 	}

	/**
	 * 查看日期格式是否正确
	 * @param str
	 * @param format
	 * @return
	 */
	public static boolean checkDate(String str,String format){

		DateFormat formatter = new SimpleDateFormat(format);
		try{
			Date date = formatter.parse(str);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	/**
	 * 时间比较  若date1>date2返回false
	 * @param DATE1
	 * @param DATE2
	 * @return
	 */
	public static boolean compare_date(String DATE1, String DATE2) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() >= dt2.getTime()) {
				return false;
			} else {
				return true;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}

	}
}
