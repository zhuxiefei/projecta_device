package com.bdcourtyard.business.housetype.rest;

import basic.common.core.id.IdUtil;
import com.bdcourtyard.business.housetype.domain.*;
import com.bdcourtyard.business.housetype.model.HouseType;
import com.bdcourtyard.business.housetype.service.HouseTypeService;
import com.bdcourtyard.common.page.Page;
import com.bdcourtyard.common.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *  HouseTypeController
 *
 * @version : Ver 1.0
 * @date	: 2018-7-23
 */
@RestController
@Api(value = "HouseTypeController", description = "户型图相关")
@RequestMapping(value = "/crm/web/houseType")
public class HouseTypeController {

	private static final Logger LOG = LoggerFactory.getLogger(HouseTypeController.class);

	@InitBinder
	    public void initBinder(WebDataBinder binder) {
	        DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	        dateFormat.setLenient(true);   
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    }  
	
	@Autowired
	private HouseTypeService houseTypeService;

	@ApiOperation(value = "上传户型图", notes = "上传户型图")
	@RequestMapping(value = "/uploadPic", method = RequestMethod.POST)
	public Response<UploadPicResp> uploadPic(MultipartFile picture){
		Response<UploadPicResp> response = new Response<>();
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseType/uploadPic------start-");
		}
		response.setData(houseTypeService.uploadPic(picture));
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseType/uploadPic------end-"+response);
		}
		return response;
	}
	
	@ApiOperation(value = "新增户型图", notes = "新增户型图")
	@RequestMapping(value = "/insertHouseType", method = RequestMethod.POST)
	public Response<String> insertHouseType(@RequestBody AddTypeReq typeReq, HttpServletRequest request){
    	Response<String> response = new Response();
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseType/insertHouseType------start-houseType:"+typeReq);
		}
		houseTypeService.insertHouseType(typeReq,request);
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseType/insertHouseType------end-response:"+response);
		}
		return response;
	}

	@ApiOperation(value = "根据ID修改户型图", notes = "根据ID修改户型图")
	@RequestMapping(value = "/updateHouseTypeById", method = RequestMethod.POST)
	public Response<String> updateHouseTypeById(@RequestBody AddTypeReq typeReq,HttpServletRequest request){
		Response<String> response = new Response();
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseType/updateHouseTypeById------start-typeReq:"+typeReq);
		}
		houseTypeService.updateHouseTypeById(typeReq,request);
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseType/updateHouseTypeById------end-response:"+response);
		}
		return response;
	}

	@ApiOperation(value = "根据ID删除户型图", notes = "根据ID删除户型图（批量删除时，id以逗号隔开）")
	@RequestMapping(value = "/deleteHouseTypeById", method = RequestMethod.POST)
	public Response<String> deleteHouseTypeById(@RequestBody HouseType houseType  ){
		Response<String> response = new Response();
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseType/deleteHouseTypeById------start-houseType:"+houseType);
		}
		houseTypeService.deleteHouseTypeById(houseType.getTypeId());
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseType/deleteHouseTypeById------end-response:"+response);
		}
		return response;
	}
	@ApiOperation(value = "根据ID获取户型图", notes = "根据ID获取户型图")
	@RequestMapping(value = "/getHouseTypeById", method = RequestMethod.GET)
	public Response<FindTypeResp> getHouseTypeById(@RequestParam String typeId  ){
		Response<FindTypeResp> response = new Response();
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseType/getHouseTypeById------start-typeId:"+typeId);
		}
		response.setData(houseTypeService.getHouseTypeById(typeId));
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseType/getHouseTypeById------end-response:"+response);
		}
		return response;
	}

	@ApiOperation(value = "根据对象分页获取户型图", notes = "根据对象分页获取户型图")
	@RequestMapping(value = "/getHouseTypesForPage", method = RequestMethod.POST)
	public Response<Page<FindAllTypesResp>> getHouseTypesForPage(@RequestBody FindAllTypesReq typesReq,
																 @RequestParam(value="page", defaultValue="1")  int page,
																 @RequestParam(value="pageSize", defaultValue="10") int pageSize,
																 HttpServletRequest request){
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseType/getHouseTypesForPage------start-typesReq:"+typesReq);
		}
		Pageable pageable = new PageRequest(page, pageSize);
		Page<FindAllTypesResp> pageDto= houseTypeService.getHouseTypesForPage(typesReq,pageable,request);
		Response<Page<FindAllTypesResp>> response = new Response<>(pageDto);
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseType/getHouseTypesForPage------end-response:"+response);
		}
		return response;
	}
}
