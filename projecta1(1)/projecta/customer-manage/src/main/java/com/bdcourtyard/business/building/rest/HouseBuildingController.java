package com.bdcourtyard.business.building.rest;

import basic.common.core.id.IdUtil;
import com.bdcourtyard.business.building.domain.BuildingInfo;
import com.bdcourtyard.business.building.model.HouseBuilding;
import com.bdcourtyard.business.building.service.HouseBuildingService;
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

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *  HouseBuildingController
 *
 * @version : Ver 1.0
 * @date	: 2018-7-23
 */
@RestController
@Api(value = "HouseBuildingController", description = "楼宇相关")
@RequestMapping(value = "/crm/web/houseBuilding")
public class HouseBuildingController {

	private static final Logger LOG = LoggerFactory.getLogger(HouseBuildingController.class);
	
	   @InitBinder
	    public void initBinder(WebDataBinder binder) {
	        DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	        dateFormat.setLenient(true);   
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    }  
	
	@Autowired
	private HouseBuildingService houseBuildingService;
	
	@ApiOperation(value = "新增楼宇", notes = "新增楼宇")
	@RequestMapping(value = "/insertHouseBuilding", method = RequestMethod.POST)
	public Response<String> insertHouseBuilding(@RequestBody HouseBuilding houseBuilding, HttpServletRequest request){
		houseBuilding.setBuildingId(IdUtil.getId()+"");
		Response<String> response = new Response<>();
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseBuilding/insertHouseBuilding------start-houseBuilding："+houseBuilding);
		}
		houseBuildingService.insertHouseBuilding(houseBuilding,request);
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseBuilding/insertHouseBuilding------end-response:"+response);
		}
		return response;
	}

	@ApiOperation(value = "根据ID修改楼宇", notes = "根据ID修改楼宇")
	@RequestMapping(value = "/updateHouseBuildingById", method = RequestMethod.POST)
	public Response<String> updateHouseBuildingById(@RequestBody HouseBuilding houseBuilding){
		Response<String> response = new Response<>();
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseBuilding/updateHouseBuildingById------start-houseBuilding："+houseBuilding);
		}
		houseBuildingService.updateHouseBuildingById(houseBuilding);
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseBuilding/updateHouseBuildingById------end-response:"+response);
		}
		return response;
	}

	@ApiOperation(value = "根据ID删除楼宇", notes = "根据ID删除楼宇")
	@RequestMapping(value = "/deleteHouseBuildingById", method = RequestMethod.POST)
	public Response<String> deleteHouseBuildingById(@RequestBody HouseBuilding building ){
		Response<String> response = new Response<>();
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseBuilding/deleteHouseBuildingById------start-building："+building);
		}
		houseBuildingService.deleteHouseBuildingById(building.getBuildingId());
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseBuilding/deleteHouseBuildingById------end-response:"+response);
		}
		return response;
	}

	@ApiOperation(value = "根据ID获取楼宇", notes = "根据ID获取楼宇")
	@RequestMapping(value = "/getHouseBuildingById", method = RequestMethod.GET)
	public Response<HouseBuilding> getHouseBuildingById(@RequestParam String buildingId  ){
		Response<HouseBuilding> response = new Response<>();
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseBuilding/getHouseBuildingById------start-buildingId："+buildingId);
		}
		response.setData(houseBuildingService.getHouseBuildingById(buildingId));
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseBuilding/getHouseBuildingById------end-response:"+response);
		}
		return response;
	}

	@ApiOperation(value = "获取楼宇列表", notes = "获取楼宇列表")
	@RequestMapping(value = "/getHouseBuildingList", method = RequestMethod.GET)
	public Response<List<BuildingInfo>> getHouseBuildingList(HttpServletRequest request){
		Response<List<BuildingInfo>> response = new Response<>();
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseBuilding/getHouseBuildingList------start");
		}
			response.setData(houseBuildingService.findBuildingList(request));
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseBuilding/getHouseBuildingList------end-response:"+response);
		}
		return response;
	}
}
