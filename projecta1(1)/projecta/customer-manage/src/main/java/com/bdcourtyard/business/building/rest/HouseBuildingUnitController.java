package com.bdcourtyard.business.building.rest;

import basic.common.core.id.IdUtil;
import com.bdcourtyard.business.building.domain.BuildingInfo;
import com.bdcourtyard.business.building.domain.UnitInfo;
import com.bdcourtyard.business.building.model.HouseBuildingUnit;
import com.bdcourtyard.business.building.service.HouseBuildingUnitService;
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *  HouseBuildingUnitController
 *
 * @version : Ver 1.0
 * @date	: 2018-7-23
 */
@RestController
@Api(value = "HouseBuildingUnitController", description = "楼宇单元相关")
@RequestMapping(value = "/crm/web/houseBuildingUnit")
public class HouseBuildingUnitController {

	private static final Logger LOG = LoggerFactory.getLogger(HouseBuildingUnitController.class);
	
	   @InitBinder
	    public void initBinder(WebDataBinder binder) {
	        DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	        dateFormat.setLenient(true);   
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    }  
	
	@Autowired
	private HouseBuildingUnitService houseBuildingUnitService;
	
	@ApiOperation(value = "新增楼宇单元", notes = "新增楼宇单元")
	@RequestMapping(value = "/insertHouseBuildingUnit", method = RequestMethod.POST)
	public Response<String> insertHouseBuildingUnit(@RequestBody HouseBuildingUnit houseBuildingUnit){
		houseBuildingUnit.setUnitId(IdUtil.getId()+"");
		Response<String> response = new Response<>();
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseBuildingUnit/insertHouseBuildingUnit------start-houseBuildingUnit："
					+houseBuildingUnit);
		}
		houseBuildingUnitService.insertHouseBuildingUnit(houseBuildingUnit);
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseBuildingUnit/insertHouseBuildingUnit------end-response:"+response);
		}
		return response;
	}

	@ApiOperation(value = "根据ID修改楼宇单元", notes = "根据ID修改楼宇单元")
	@RequestMapping(value = "/updateHouseBuildingUnitById", method = RequestMethod.POST)
	public Response<String> updateHouseBuildingUnitById(@RequestBody HouseBuildingUnit houseBuildingUnit){
		Response<String> response = new Response<>();
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseBuildingUnit/updateHouseBuildingUnitById------start-houseBuildingUnit："
					+houseBuildingUnit);
		}
		houseBuildingUnitService.updateHouseBuildingUnitById(houseBuildingUnit);
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseBuildingUnit/updateHouseBuildingUnitById------end-response:"+response);
		}
		return response;
	}

	@ApiOperation(value = "根据ID删除楼宇单元", notes = "根据ID删除楼宇单元")
	@RequestMapping(value = "/deleteHouseBuildingUnitById", method = RequestMethod.POST)
	public Response<String> deleteHouseBuildingUnitById(@RequestBody HouseBuildingUnit unit){
		Response<String> response = new Response<>();
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseBuildingUnit/deleteHouseBuildingUnitById------start-unit：" +unit);
		}
		houseBuildingUnitService.deleteHouseBuildingUnitById(unit.getUnitId());
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseBuildingUnit/deleteHouseBuildingUnitById------end-response:"+response);
		}
		return response;
	}

	@ApiOperation(value = "根据楼宇ID获取楼宇单元", notes = "根据楼宇ID获取楼宇单元")
	@RequestMapping(value = "/getHouseBuildingUnitById", method = RequestMethod.GET)
	public Response<List<UnitInfo>> getHouseBuildingUnitById(@RequestParam String buildingId  ){
		Response<List<UnitInfo>> response = new Response<>();
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseBuildingUnit/getHouseBuildingUnitById------start-buildingId：" +buildingId);
		}
		response.setData(houseBuildingUnitService.findByBuildingId(buildingId));
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/houseBuildingUnit/getHouseBuildingUnitById------end-response:"+response);
		}
		return response;
	}
}
