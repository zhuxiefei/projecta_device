package com.bdcourtyard.business.onlineHouse.rest;

import com.bdcourtyard.business.file.service.SystemFileOneService;
import com.bdcourtyard.business.onlineHouse.model.AssistantOnlinehousefile;
import com.bdcourtyard.business.onlineHouse.model.HouseResp;
import com.bdcourtyard.business.onlineHouse.model.OnlineFileResq;
import com.bdcourtyard.business.onlineHouse.model.OnlineHouseSimpleInfo;
import com.bdcourtyard.business.onlineHouse.service.AppOnlineHouseService;
import com.bdcourtyard.business.onlineHouse.service.AssistantOnlineHouseService;
import com.bdcourtyard.business.onlineHouse.service.AssistantOnlinehousefileService;
import com.bdcourtyard.common.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@Api(value = "AppOnlineHouseController", description = "APP在线看房信息")
@RequestMapping(value = "/pm/web/appOnlineHouseController")
public class AppOnlineHouseController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


    @Autowired
    private AppOnlineHouseService appOnlineHouseService;
    @Autowired
    private SystemFileOneService systemFileService;

    /**
     * 返回所有在线房屋信息
     * @return List<OnlineHouseSimpleInfo>
     */
    @ApiOperation(value = "查看所有在线看房信息", notes = "查看所有在线看房信息")
    @RequestMapping(value = "/findAllAppOnlineHouse", method = RequestMethod.POST)
    public Response<List<OnlineHouseSimpleInfo>> findAllAppOnlineHouse(){

        List<OnlineHouseSimpleInfo> houses =  appOnlineHouseService.findOnlineHouseAll();

        return new Response<List<OnlineHouseSimpleInfo>>(houses);
    }

    @ApiOperation(value = "根据房屋信息id查找房屋所有图片", notes = "根据房屋信息id查找房屋所有图片")
    @RequestMapping(value = "/findHouseImagesByOnlineId", method = RequestMethod.GET)
    public Response<List<OnlineFileResq>> findHouseImagesByOnlineId(@RequestParam String onlineId){

        List<OnlineFileResq> list = systemFileService.getSystemFilesByOnlineId(onlineId);

        return new Response<List<OnlineFileResq>>(list);
    }




}
