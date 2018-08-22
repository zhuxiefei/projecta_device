package com.bdcourtyard.business.houseprice.rest;
import com.bdcourtyard.business.building.domain.UnitInfo;
import com.bdcourtyard.business.building.model.HouseBuilding;
import com.bdcourtyard.business.building.model.HouseBuildingUnit;
import com.bdcourtyard.business.building.rest.HouseBuildingUnitController;
import com.bdcourtyard.business.building.service.HouseBuildingService;
import com.bdcourtyard.business.building.service.HouseBuildingUnitService;
import com.bdcourtyard.business.house.model.HouseHouse;
import com.bdcourtyard.business.house.service.HouseHouseService;
import com.bdcourtyard.business.houseprice.model.RoomsourceHousediscount;
import com.bdcourtyard.business.houseprice.service.RoomsourceHousediscountService;
import com.bdcourtyard.business.houseprice.service.RoomsourceHousepriceService;
import com.bdcourtyard.business.houseprice.model.RoomsourceHouseprice;
import basic.common.core.dto.PageDto;
import basic.common.core.id.IdUtil;

import com.bdcourtyard.business.houseprice.vo.*;
import com.bdcourtyard.business.housetype.model.HouseType;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  RoomsourceHousepriceController
 *
 * @version : Ver 1.0
 * @date	: 2018-7-25
 */
@RestController
@Api(value = "RoomsourceHousepriceController", description = "房屋价格表相关")
@RequestMapping(value = "/crm/web/roomsourceHouseprice")
public class RoomsourceHousepriceController {
	private static final Logger LOG = LoggerFactory.getLogger(HouseBuildingUnitController.class);
	
	   @InitBinder   
	    public void initBinder(WebDataBinder binder) {   
	        DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	        dateFormat.setLenient(true);   
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
	    }  
	
	@Autowired
	private RoomsourceHousepriceService roomsourceHousepriceService;
	@Autowired
	private HouseHouseService houseHouseService;
	@Autowired
	private HouseBuildingService houseBuildingService;
	@Autowired
	private HouseBuildingUnitService houseBuildingUnitService;
	
	@ApiOperation(value = "新增房屋价格", notes = "新增房屋价格")
	@RequestMapping(value = "/insertRoomsourceHouseprice", method = RequestMethod.POST)
	public Response<Integer> insertRoomsourceHouseprice(HttpServletRequest request, @RequestBody RoomsourceHouseprice roomsourceHouseprice){
		roomsourceHouseprice.setHousePriceId(IdUtil.getId()+"");
		return new Response<Integer>(roomsourceHousepriceService.insertRoomsourceHouseprice(request,roomsourceHouseprice));
	}

	@ApiOperation(value = "根据楼宇对象获取", notes = "根据楼宇对象获取")
	@RequestMapping(value = "/getHouseBuildingByList", method = RequestMethod.POST)
	public  Response<List<HouseBuilding>> getHouseBuildings( @RequestBody HouseBuilding houseBuilding){
		return new Response<List<HouseBuilding>>(houseBuildingService.getHouseBuildings(houseBuilding));

	}

	@ApiOperation(value = "根据楼宇ID获取楼宇单元", notes = "根据楼宇ID获取单元")
	@RequestMapping(value = "/getBuildingByUnitId", method = RequestMethod.GET)
	public Response<List<UnitInfo>> getHouseBuildingUnitById(@RequestParam String buildingId  ){
		Response<List<UnitInfo>> response = new Response<>();
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/roomsourceHouseprice/getBuildingByUnitId------start-buildingId：" +buildingId);
		}
		response.setData(houseBuildingUnitService.findByBuildingId(buildingId));
		if (LOG.isInfoEnabled()) {
			LOG.info("----------/crm/web/roomsourceHouseprice/getBuildingByUnitId------end-response:"+response);
		}
		return response;
	}

	@ApiOperation(value = "根据楼宇和单元的ID获取", notes = "根据楼宇和单元的ID获取")
	@RequestMapping(value = "/getHouseOrTypePageById", method = RequestMethod.GET)
	public Response<List<HouseOrTypePage>> getHouseOrTypePageById( @RequestParam String buildingId,@RequestParam String unitId  ){
		return new Response<List<HouseOrTypePage>>(houseHouseService.getHouseOrtypes(buildingId,unitId));
	}

	@ApiOperation(value = "根据楼宇,单元和户型的ID获取楼层", notes = "根据楼宇,单元和户型的ID获取楼层")
	@RequestMapping(value = "/getRoomsourceHousepricePageByIds", method = RequestMethod.GET)
	public Response<List<HouseFloor>> getRoomsourceHousepricePageByIds(@RequestParam(required = false)  String housePriceId ,@RequestParam String buildingId,@RequestParam String unitId,@RequestParam String typeId ){
		return new Response<List<HouseFloor>>(roomsourceHousepriceService.getRoomsourceHousepricePageByIds(housePriceId,buildingId,unitId,typeId));
	}

	@Autowired
	private RoomsourceHousediscountService roomsourceHousediscountService;
	@ApiOperation(value = "根据房屋折扣表对象获取", notes = "根据房屋折扣表对象获取")
	@RequestMapping(value = "/getRoomsourceHousediscounts", method = RequestMethod.POST)
	public  Response<List<RoomsourceHousediscount>> getRoomsourceHousediscounts( @RequestBody RoomsourceHousediscount roomsourceHousediscount){
		return new Response<List<RoomsourceHousediscount>>(roomsourceHousediscountService.getRoomsourceHousediscounts(roomsourceHousediscount));

	}
	@ApiOperation(value = "根据房屋价格表ID修改", notes = "根据房屋价格表ID修改")
	@RequestMapping(value = "/updateRoomsourceHousepriceById", method = RequestMethod.POST)
	public Response<Integer> updateRoomsourceHousepriceById(@RequestBody RoomsourceHouseprice roomsourceHouseprice){
		return new Response<Integer>(roomsourceHousepriceService.updateRoomsourceHousepriceById(roomsourceHouseprice));
	}
	@ApiOperation(value = "根据房屋价格表ID删除", notes = "批量删除，多个的价格价格用，隔开")
	@RequestMapping(value = "/deleteRoomsourceHousepriceById", method = RequestMethod.GET)
	public Response<Boolean> deleteRoomsourceHousepriceById( @RequestParam String  housePriceIds ){

		if(housePriceIds==null){
			throw new GlobalException("HP006");
		}
		roomsourceHousepriceService.deleteRoomsourceHousepriceByIds(housePriceIds);
		return new Response<Boolean>(true);
	}
	@ApiOperation(value = "根据房屋价格表ID获取", notes = "根据房屋价格表ID获取")
	@RequestMapping(value = "/getRoomsourceHousepriceById", method = RequestMethod.GET)
	public Response<HousepriceResp> getRoomsourceHousepriceById( @RequestParam String housePriceId  ){
		return new Response<HousepriceResp>(roomsourceHousepriceService.getHousepriceRespById(  housePriceId  ));
	}
 
	@ApiOperation(value = "根据房屋价格表对象分页获取", notes = "根据房屋价格表对象分页获取")
	@RequestMapping(value = "/getRoomsourceHousepricesForPage", method = RequestMethod.POST)
	public  Response<Page<RoomsourceHousepricePage>> getRoomsourceHousepricesForPage(@RequestBody HousePriceParm housePriceParm,
			@RequestParam(value="page", defaultValue="1")  int page,
			@RequestParam(value="pageSize", defaultValue="10") int pageSize){
		Pageable pageable = new PageRequest(page, pageSize);
		Page<RoomsourceHousepricePage> pageDto= roomsourceHousepriceService.getRoomsourceHousepricesForPage(housePriceParm,pageable);
		return new Response<Page<RoomsourceHousepricePage>>(pageDto);
 	}
}
