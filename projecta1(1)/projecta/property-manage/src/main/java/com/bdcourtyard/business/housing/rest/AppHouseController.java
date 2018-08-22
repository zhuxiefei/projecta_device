package com.bdcourtyard.business.housing.rest;

import com.bdcourtyard.business.houseGuide.model.AssistantHouseguide;
import com.bdcourtyard.business.housing.domain.FindHouseMsgInfoResp;
import com.bdcourtyard.business.housing.domain.FindHouseMsgsResp;
import com.bdcourtyard.business.housing.service.AssistantHouseService;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;
import com.bdcourtyard.common.response.Response;
import com.beite.tools.utils.AESUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-19 17:46
 * @Description:
 */
@RestController
@Api(value = "AppHouseController", description = "营销助手app--房产信息")
@RequestMapping(value = "/pm/assistantApp/assistantHouse")
public class AppHouseController {

    private static final Logger LOG = LoggerFactory.getLogger(AppHouseController.class);

    @Autowired
    private AssistantHouseService houseService;

    @ApiOperation(value = "分页查询房产信息列表", notes = "分页查询房产信息列表")
    @RequestMapping(value = "/findHouseMsgs", method = RequestMethod.POST)
    public Response<Page<FindHouseMsgsResp>> findHouseMsgs(@RequestParam(value = "page", defaultValue = "1") int page,
                                                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                                           HttpServletRequest request){
        if (LOG.isInfoEnabled()) {
            LOG.info("----------assistantApp/assistantHouse/v1/findHouseMsgs------start-");
        }
        String estateId;
        try {
            estateId = AESUtil.decrypt(request.getHeader("estateId"));
        } catch (Exception e) {
            throw new GlobalException("99999");
        }
        Pageable pageable = new PageRequest(page, pageSize);
        Page<FindHouseMsgsResp> pageDto =  houseService.findByEstateId(estateId,pageable);
        Response<Page<FindHouseMsgsResp>> response = new Response<>(pageDto);
        if (LOG.isInfoEnabled()) {
            LOG.info("----------assistantApp/assistantHouse/v1/findHouseMsgs------end-");
        }
        return response;
    }

    @ApiOperation(value = "查询房产信息详情", notes = "查询房产信息详情")
    @RequestMapping(value = "/findHouseMsgInfo", method = RequestMethod.GET)
    public Response<FindHouseMsgInfoResp> findHouseMsgInfo(@RequestParam String propertyId){
        if (LOG.isInfoEnabled()) {
            LOG.info("----------assistantApp/assistantHouse/v1/findHouseMsgInfo------start-propertyId="+propertyId);
        }
        Response<FindHouseMsgInfoResp> response = new Response<>();
        response.setData(houseService.findByPropertyId(propertyId));
        if (LOG.isInfoEnabled()) {
            LOG.info("----------assistantApp/assistantHouse/v1/findHouseMsgInfo------end-");
        }
        return response;
    }
}
