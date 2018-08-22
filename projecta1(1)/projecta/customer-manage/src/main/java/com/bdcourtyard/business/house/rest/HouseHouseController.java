package com.bdcourtyard.business.house.rest;

import basic.common.core.id.IdUtil;
import com.bdcourtyard.business.building.domain.BuildingInfo;
import com.bdcourtyard.business.building.domain.UnitInfo;
import com.bdcourtyard.business.building.model.HouseBuilding;
import com.bdcourtyard.business.building.model.HouseBuildingUnit;
import com.bdcourtyard.business.building.service.HouseBuildingService;
import com.bdcourtyard.business.building.service.HouseBuildingUnitService;
import com.bdcourtyard.business.house.domain.*;
import com.bdcourtyard.business.house.model.HouseHouse;
import com.bdcourtyard.business.house.service.HouseHouseService;
import com.bdcourtyard.business.housetype.model.HouseType;
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
 * HouseHouseController
 *
 * @version : Ver 1.0
 * @date    : 2018-7-23
 */
@RestController
@Api(value = "HouseHouseController", description = "房屋相关")
@RequestMapping(value = "/crm/web/houseHouse")
public class HouseHouseController {

    private static final Logger LOG = LoggerFactory.getLogger(HouseHouseController.class);

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @Autowired
    private HouseHouseService houseHouseService;

    @Autowired
    private HouseBuildingService houseBuildingService;

    @Autowired
    private HouseBuildingUnitService houseBuildingUnitService;

    @ApiOperation(value = "新增房屋", notes = "新增房屋")
    @RequestMapping(value = "/insertHouseHouse", method = RequestMethod.POST)
    public Response<String> insertHouseHouse(@RequestBody HouseHouse houseHouse, HttpServletRequest request) {
        houseHouse.setHouseId(IdUtil.getId() + "");
        if (LOG.isInfoEnabled()) {
            LOG.info("----------/crm/web/houseHouse/insertHouseHouse------start-houseHouse:" + houseHouse);
        }
        Response<String> response = new Response<>();
        houseHouseService.insertHouseHouse(houseHouse, request);
        if (LOG.isInfoEnabled()) {
            LOG.info("----------/crm/web/houseHouse/insertHouseHouse------end-response:" + response);
        }
        return response;
    }

    @ApiOperation(value = "批量导入房屋", notes = "批量导入房屋")
    @RequestMapping(value = "/insertHouseHouseBatch", method = RequestMethod.POST)
    public Response<List<ImportMsg>> insertHouseHouseBatch(MultipartFile multipartFile, HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("----------/crm/web/houseHouse/insertHouseHouseBatch------start-");
        }
        Response<List<ImportMsg>> response = new Response<>();
        response.setData(houseHouseService.insertHouseHouseBatch(multipartFile, request));
        if (LOG.isInfoEnabled()) {
            LOG.info("----------/crm/web/houseHouse/insertHouseHouseBatch------end-response:" + response);
        }
        return response;
    }

    @ApiOperation(value = "根据ID修改房屋", notes = "根据ID修改房屋")
    @RequestMapping(value = "/updateHouseHouseById", method = RequestMethod.POST)
    public Response<String> updateHouseHouseById(@RequestBody HouseHouse houseHouse, HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("----------/crm/web/houseHouse/updateHouseHouseById------start-houseHouse:" + houseHouse);
        }
        Response<String> response = new Response<>();
        houseHouseService.updateHouseHouseById(houseHouse, request);
        if (LOG.isInfoEnabled()) {
            LOG.info("----------/crm/web/houseHouse/updateHouseHouseById------end-response:" + response);
        }
        return response;
    }

    @ApiOperation(value = "根据ID删除房屋", notes = "根据ID删除房屋")
    @RequestMapping(value = "/deleteHouseHouseById", method = RequestMethod.POST)
    public Response<String> deleteHouseHouseById(@RequestBody HouseHouse house) {
        if (LOG.isInfoEnabled()) {
            LOG.info("----------/crm/web/houseHouse/deleteHouseHouseById------start-houseHouse:" + house);
        }
        Response<String> response = new Response<>();
        houseHouseService.deleteHouseHouseById(house.getHouseId());
        if (LOG.isInfoEnabled()) {
            LOG.info("----------/crm/web/houseHouse/deleteHouseHouseById------end-response:" + response);
        }
        return response;
    }

    @ApiOperation(value = "根据ID获取房屋", notes = "根据ID获取房屋")
    @RequestMapping(value = "/getHouseHouseById", method = RequestMethod.GET)
    public Response<FindHouseResp> getHouseHouseById(@RequestParam String houseId) {
        if (LOG.isInfoEnabled()) {
            LOG.info("----------/crm/web/houseHouse/getHouseHouseById------start-houseId:" + houseId);
        }
        Response<FindHouseResp> response = new Response<>();
        response.setData(houseHouseService.getHouseHouseById(houseId));
        if (LOG.isInfoEnabled()) {
            LOG.info("----------/crm/web/houseHouse/getHouseHouseById------end-response:" + response);
        }
        return response;
    }

    @ApiOperation(value = "根据对象分页获取房屋", notes = "根据对象分页获取房屋")
    @RequestMapping(value = "/getHouseHousesForPage", method = RequestMethod.POST)
    public Response<Page<FindAllHousesResp>> getHouseHousesForPage(@RequestBody FindAllHousesReq housesReq,
                                                                   @RequestParam(value = "page", defaultValue = "1") int page,
                                                                   @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                                                   HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("----------/crm/web/houseHouse/getHouseHousesForPage------start-housesReq:" + housesReq);
        }
        Pageable pageable = new PageRequest(page, pageSize);
        Page<FindAllHousesResp> pageDto = houseHouseService.getHouseHousesForPage(housesReq, pageable, request);
        Response<Page<FindAllHousesResp>> response = new Response<>(pageDto);
        if (LOG.isInfoEnabled()) {
            LOG.info("----------/crm/web/houseHouse/getHouseHousesForPage------end-response:" + response);
        }
        return response;
    }

    @ApiOperation(value = "查询所有户型", notes = "查询所有户型")
    @RequestMapping(value = "/findAllTypes", method = RequestMethod.GET)
    public Response<List<HouseType>> findAllTypes(HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("----------/crm/web/houseHouse/findAllTypes------start-");
        }
        Response<List<HouseType>> response = new Response<>();
        response.setData(houseHouseService.findAllTypes(request));
        if (LOG.isInfoEnabled()) {
            LOG.info("----------/crm/web/houseHouse/findAllTypes------end-response:" + response);
        }
        return response;
    }

    @ApiOperation(value = "获取楼宇列表", notes = "获取楼宇列表")
    @RequestMapping(value = "/findBuildings", method = RequestMethod.GET)
    public Response<List<BuildingInfo>> findBuildings(HttpServletRequest request){
        Response<List<BuildingInfo>> response = new Response<>();
        if (LOG.isInfoEnabled()) {
            LOG.info("----------/crm/web/houseHouse/findBuildings------start");
        }
        response.setData(houseBuildingService.findBuildingList(request));
        if (LOG.isInfoEnabled()) {
            LOG.info("----------/crm/web/houseHouse/findBuildings------end-response:"+response);
        }
        return response;
    }

    @ApiOperation(value = "根据楼宇ID获取楼宇单元", notes = "根据楼宇ID获取楼宇单元")
    @RequestMapping(value = "/findUnits", method = RequestMethod.GET)
    public Response<List<UnitInfo>> findUnits(@RequestParam String buildingId  ){
        Response<List<UnitInfo>> response = new Response<>();
        if (LOG.isInfoEnabled()) {
            LOG.info("----------/crm/web/houseHouse/findUnits------start-buildingId：" +buildingId);
        }
        response.setData(houseBuildingUnitService.findByBuildingId(buildingId));
        if (LOG.isInfoEnabled()) {
            LOG.info("----------/crm/web/houseHouse/findUnits------end-response:"+response);
        }
        return response;
    }

    @ApiOperation(value = "导出房屋列表", notes = "导出房屋列表")
    @RequestMapping(value = "/exportHouses", method = RequestMethod.POST)
    public Response<List<FindAllHousesResp>> exportHouses(@RequestBody FindAllHousesReq housesReq,
                                                          HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("----------/crm/web/houseHouse/exportHouses------start-housesReq:" + housesReq);
        }
        Response<List<FindAllHousesResp>> response = new Response<>();
        response.setData(houseHouseService.exportHouses(housesReq, request));
        if (LOG.isInfoEnabled()) {
            LOG.info("----------/crm/web/houseHouse/exportHouses------end-response:" + response);
        }
        return response;
    }

    @ApiOperation(value = "批量编辑开盘时间", notes = "批量编辑开盘时间")
    @RequestMapping(value = "/updateOpenTime", method = RequestMethod.POST)
    public Response<String> updateOpenTime(@RequestBody UpdateOpenTimeReq timeReq) {
        if (LOG.isInfoEnabled()) {
            LOG.info("----------/crm/web/houseHouse/updateOpenTime------start-timeReq:" + timeReq);
        }
        Response<String> response = new Response<>();
        houseHouseService.updateOpenTime(timeReq);
        if (LOG.isInfoEnabled()) {
            LOG.info("----------/crm/web/houseHouse/updateOpenTime------end-response:" + response);
        }
        return response;
    }
}
