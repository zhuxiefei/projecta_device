package com.bdcourtyard.business.clentstatistics.rest;

import com.bdcourtyard.business.clentstatistics.model.ClientstatisticsParm;
import com.bdcourtyard.business.clentstatistics.model.ClientstatisticsResp;
import com.bdcourtyard.business.clentstatistics.service.ClientstatisticsService;
import com.bdcourtyard.common.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  RoomsourceHousepriceController
 *
 * @version : Ver 1.0
 * @date	: 2018-7-25
 */
@RestController
@Api(value = "ClentstatisticsContrller", description = "客户需求统计相关")
@RequestMapping(value = "/crm/web/clentstatistics")
public class ClientstatisticsContrller {


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    @Autowired
    private ClientstatisticsService clientstatisticsService;
    @ApiOperation(value = "根据客户信息表对象统计", notes = "根据客户信息表对象统计")
    @RequestMapping(value = "/getClentstatistics", method = RequestMethod.POST)
    public  Response<ClientstatisticsResp> getClentstatistics( @RequestBody ClientstatisticsParm clientstatisticsParm){
        return new Response<ClientstatisticsResp>(clientstatisticsService.getTj(clientstatisticsParm));

    }
}
