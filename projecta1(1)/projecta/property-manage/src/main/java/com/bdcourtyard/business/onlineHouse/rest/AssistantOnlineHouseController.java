package com.bdcourtyard.business.onlineHouse.rest;  
import basic.common.core.dto.PageDto;
import com.bdcourtyard.business.file.model.SystemFile;
import com.bdcourtyard.business.file.service.SystemFileOneService;
import com.bdcourtyard.business.onlineHouse.model.*;
import com.bdcourtyard.business.onlineHouse.service.AssistantOnlineHouseService;
import com.bdcourtyard.common.page.Page;
import basic.common.core.id.IdUtil;

import com.bdcourtyard.business.onlineHouse.service.AssistantOnlinehousefileService;
import com.bdcourtyard.common.exception.GlobalException;
import com.beite.tools.utils.AESUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  AssistantOnlineHouseController
 *
 * @version : Ver 1.0
 * @date	: 2018-7-17
 */
@RestController
@Api(value = "AssistantOnlineHouseController", description = "在线看房信息相关")
@RequestMapping(value = "/pm/web/assistantOnlineHouse")
public class AssistantOnlineHouseController { 
	
	   @InitBinder   
	    public void initBinder(WebDataBinder binder) {   
	        DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	        dateFormat.setLenient(true);   
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
	    }  
	
	@Autowired
	private AssistantOnlineHouseService assistantOnlineHouseService;
	@Autowired
	private AssistantOnlinehousefileService assistantOnlinehousefileService;
	@Autowired
	private SystemFileOneService systemFileService;
	
	@ApiOperation(value = "新增在线看房信息", notes = "新增在线看房信息")
	@RequestMapping(value = "/insertAssistantOnlineHouse", method = RequestMethod.POST)
	public Response<Integer> insertAssistantOnlineHouse(@RequestBody AddHouseReq houseReq, HttpServletRequest request){
		//主表
		AssistantOnlineHouse assistantOnlineHouse = new AssistantOnlineHouse(
				IdUtil.getId()+"",houseReq.getHouseType(),null,null,null);
		Date createTime = new Date();
		assistantOnlineHouse.setCreateTime(createTime);
		String estateId;
		try {
			estateId = AESUtil.decrypt(request.getHeader("estateId"));
		} catch (Exception e) {
			throw new GlobalException("99999");
		}
		if(estateId==null||"".equals(estateId.trim())){
			throw new GlobalException("H0001");
		}else{
			assistantOnlineHouse.setEstateId(estateId);
		}
		String adminid;
		try {
			adminid = AESUtil.decrypt(request.getHeader("employeeId"));
		} catch (Exception e) {
			throw new GlobalException("99999");
		}
		if(estateId==null||"".equals(estateId.trim())){
			throw new GlobalException("H0001");
		}else{
			assistantOnlineHouse.setAdminId(adminid);
		}
		//户型名称不重复
		if(houseReq.getHouseType()!=null && !("".equals(houseReq.getHouseType().trim()))){
			List<AssistantOnlineHouse> list = assistantOnlineHouseService.selectAllAssistantOnlineHouses(houseReq.getHouseType().trim());
			if(list.size()==0){
				assistantOnlineHouse.setHouseType(assistantOnlineHouse.getHouseType().trim());
			}else{
				throw new GlobalException("H0020");
			}
		}else{
			throw new GlobalException("H0022");
		}
		//附件表 户型
		String[] fileIds = houseReq.getFileIds();
		if(fileIds.length!=0){
			for(String fileId : fileIds){
				AssistantOnlinehousefile assistantOnlinehousefile = new AssistantOnlinehousefile();
				assistantOnlinehousefile.setOnlineId(assistantOnlineHouse.getOnlineId());
				assistantOnlinehousefile.setFileId(fileId);
				int result = assistantOnlinehousefileService.insertAssistantOnlinehousefile(assistantOnlinehousefile);
				if(result<0){
					throw new GlobalException("H0021");
				}
			}
		}
		//附件表 场景
		List<AssistantOnlinehousefile> assistantOnlinehousefiles = houseReq.getAssistantOnlinehousefileList();
		if(assistantOnlinehousefiles.size()!=0){
			for(AssistantOnlinehousefile assistantOnlinehousefile:assistantOnlinehousefiles){
				assistantOnlinehousefile.setOnlineId(assistantOnlineHouse.getOnlineId());
				int result = assistantOnlinehousefileService.insertAssistantOnlinehousefile(assistantOnlinehousefile);
				if(result<0){
					throw new GlobalException("H0021");
				}
			}
		}
		System.out.println(222);
		return new Response<Integer>(assistantOnlineHouseService.insertAssistantOnlineHouse(assistantOnlineHouse));
	}
	/*@ApiOperation(value = "批量新增在线看房信息", notes = "批量新增在线看房信息")
	@RequestMapping(value = "/insertAssistantOnlineHouseBatch", method = RequestMethod.POST)
	public Response<Integer> insertAssistantOnlineHouseBatch(@RequestBody List<AssistantOnlineHouse> list){
		return  new Response<Integer>(assistantOnlineHouseService.insertAssistantOnlineHouseBatch(list));
	}*/
	@ApiOperation(value = "根据ID修改在线看房信息", notes = "根据ID修改在线看房信息")
	@RequestMapping(value = "/updateAssistantOnlineHouseById", method = RequestMethod.POST)
	public Response<Integer> updateAssistantOnlineHouseById(@RequestBody UpdateHouseResp updateHouseResp,HttpServletRequest request){
		//主表
		AssistantOnlineHouse assistantOnlineHouse = new AssistantOnlineHouse(
				updateHouseResp.getOnlineId(),updateHouseResp.getHouseType(),null,null,null);
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
			assistantOnlineHouse.setEstateId(estateId);
		}
		String adminid;
		try {
			adminid = AESUtil.decrypt(request.getHeader("employeeId"));
		} catch (Exception e) {
			throw new GlobalException("99999");
		}
		if(estateId==null||"".equals(estateId.trim())){
			throw new GlobalException("H0001");
		}else{
			assistantOnlineHouse.setAdminId(adminid);
		}
		assistantOnlineHouse.setCreateTime(createTime);
		//户型名称不重复
		if(updateHouseResp.getHouseType()!=null && !("".equals(updateHouseResp.getHouseType().trim()))){
			List<AssistantOnlineHouse> list = assistantOnlineHouseService.selectAllAssistantOnlineHouses(updateHouseResp.getHouseType().trim());
			System.out.println(list.size());
			if(list.size()==0){
				assistantOnlineHouse.setHouseType(assistantOnlineHouse.getHouseType().trim());
			}else{
				throw new GlobalException("H0022");
			}
		}else{
			throw new GlobalException("H0020");
		}
		//清空关联关系
		List<OnlineFileResq> systemFileList =  systemFileService.getSystemFilesByOnlineId(updateHouseResp.getOnlineId());
		for(OnlineFileResq systemFile:systemFileList){
			int result = assistantOnlinehousefileService.deleteAssistantOnlinehousefileById(updateHouseResp.getOnlineId(),systemFile.getFileId());
			if(result<0){
				throw new GlobalException("H0023");
			}
		}
		//重新添加关联关系
		//附件表 户型
		String[] fileIds = updateHouseResp.getFileIds();
		if(fileIds.length!=0){
			for(String fileId : fileIds){
				AssistantOnlinehousefile assistantOnlinehousefile = new AssistantOnlinehousefile();
				assistantOnlinehousefile.setOnlineId(assistantOnlineHouse.getOnlineId());
				assistantOnlinehousefile.setFileId(fileId);
				int result = assistantOnlinehousefileService.insertAssistantOnlinehousefile(assistantOnlinehousefile);
				if(result<0){
					throw new GlobalException("H0021");
				}
			}
		}
		//附件表 场景
		List<AssistantOnlinehousefile> assistantOnlinehousefiles = updateHouseResp.getAssistantOnlinehousefileList();
		if(assistantOnlinehousefiles.size()!=0){
			for(AssistantOnlinehousefile assistantOnlinehousefile:assistantOnlinehousefiles){
				assistantOnlinehousefile.setOnlineId(assistantOnlineHouse.getOnlineId());
				int result = assistantOnlinehousefileService.insertAssistantOnlinehousefile(assistantOnlinehousefile);
				if(result<0){
					throw new GlobalException("H0021");
				}
			}
		}
		return new Response<Integer>(assistantOnlineHouseService.updateAssistantOnlineHouseById(assistantOnlineHouse));
	}

	@ApiOperation(value = "根据ID删除在线看房信息", notes = "根据ID删除在线看房信息")
	@RequestMapping(value = "/deleteAssistantOnlineHouseById", method = RequestMethod.GET)
	public Response<Boolean> deleteAssistantOnlineHouseById( @RequestParam String onlineId  ){
		if(onlineId==null||"".equals(onlineId.trim())){
			throw new GlobalException("H0012");
		}
		boolean a = assistantOnlineHouseService.deleteAssistantOnlineHouseById(onlineId);
		System.out.println(a+"~");
		if(!a){
			throw new GlobalException("H0009");
		}
		return new Response<Boolean>(a);
	}
	@ApiOperation(value = "根据ID获取在线看房信息", notes = "根据ID获取在线看房信息")
	@RequestMapping(value = "/getAssistantOnlineHouseById", method = RequestMethod.GET)
	public Response<HouseResp> getAssistantOnlineHouseById(@RequestParam String onlineId  ){
		HouseResp houseResp = new HouseResp();
		houseResp.setAssistantOnlineHouse(assistantOnlineHouseService.getAssistantOnlineHouseById(onlineId));

		List<OnlineFileResq> list = systemFileService.getSystemFilesByOnlineId(onlineId);
		houseResp.setSystemFileList(list);
		return new Response<HouseResp>(houseResp);
	}
 
	/*@ApiOperation(value = "根据对象获取在线看房信息", notes = "根据对象获取在线看房信息")
	@RequestMapping(value = "/getAssistantOnlineHouses", method = RequestMethod.POST)
	public  Response<List<AssistantOnlineHouse>> getAssistantOnlineHouses( @RequestBody AssistantOnlineHouse assistantOnlineHouse){
		return new Response<List<AssistantOnlineHouse>>(assistantOnlineHouseService.getAssistantOnlineHouses(assistantOnlineHouse));

 	}*/

	@ApiOperation(value = "根据对象分页获取在线看房信息", notes = "根据对象分页获取在线看房信息")
	@RequestMapping(value = "/getAssistantOnlineHousesForPage", method = RequestMethod.POST)
	public  Response<Page<AssistantOnlineHouse>> getAssistantOnlineHousesForPage(@RequestBody AoConditionReq aoConditionReq,HttpServletRequest request){
		Pageable pageable = new PageRequest(aoConditionReq.getPage(),aoConditionReq.getPageSize());
		String estateId;
		try {
			estateId = AESUtil.decrypt(request.getHeader("estateId"));
		} catch (Exception e) {
			throw new GlobalException("99999");
		}
		aoConditionReq.setEstateId(estateId);
		Page<AssistantOnlineHouse> pageDto= assistantOnlineHouseService.getAssistantOnlineHousesForPage(aoConditionReq,pageable);
		return new Response<Page<AssistantOnlineHouse>>(pageDto);


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
