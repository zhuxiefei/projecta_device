package com.bdcourtyard.business.estate.rest;

import com.bdcourtyard.business.account.utils.EstateUtil;
import com.bdcourtyard.business.estate.domain.FindEstatesResp;
import com.bdcourtyard.business.estate.domain.FindPrivilegesResp;
import com.bdcourtyard.business.estate.model.EstateEstate;
import com.bdcourtyard.business.estate.service.EstateEstateService;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.response.Response;
import com.beite.tools.utils.AESUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-18 17:41
 * @Description:
 */
@RestController
@Api(value = "EstateController", description = "营销助手app--选择楼宇")
@RequestMapping(value = "/oa/common/assistantApp/estate")
public class EstateController {

    private static final Logger LOG = LoggerFactory.getLogger(EstateController.class);

    @Autowired
    private EstateEstateService estateService;

    @ApiOperation(value = "查询楼盘列表", notes = "查询楼盘列表")
    @RequestMapping(value = "/findEstates", method = RequestMethod.GET)
    public Response<List<FindEstatesResp>> findEstates(HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("--------assistantApp/estate/v1/findEstates-------start");
        }
        Response<List<FindEstatesResp>> response = new Response<>();
        try {
            response.setData(estateService.findEstates(AESUtil.decrypt(request.getHeader("acctName"))));
        } catch (Exception e) {
            throw new GlobalException("99999");
        }
        if (LOG.isInfoEnabled()) {
            LOG.info("--------assistantApp/estate/v1/findEstates--------end,response=" + response);
        }
        return response;
    }

    @ApiOperation(value = "查询权限列表", notes = "查询权限列表")
    @RequestMapping(value = "/findPrivileges", method = RequestMethod.GET)
    public Response<FindPrivilegesResp> findPrivileges(HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("--------assistantApp/estate/v1/findPrivileges-------start");
        }
        Response<FindPrivilegesResp> response = new Response<>();
        String acctName;
        try {
            acctName = AESUtil.decrypt(request.getHeader("acctName"));
        } catch (Exception e) {
            throw new GlobalException("99999");
        }
        response.setData(estateService.findPri(acctName,EstateUtil.getEstateId(request)));
        if (LOG.isInfoEnabled()) {
            LOG.info("--------assistantApp/estate/v1/findPrivileges--------end,response=" + response);
        }
        return response;
    }
}
