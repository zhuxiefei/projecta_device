package com.bdcourtyard.business.houseGuide.rest;

import basic.common.core.id.IdUtil;
import com.bdcourtyard.business.houseGuide.model.AssistantHouseguide;
import com.bdcourtyard.business.houseGuide.model.GetAssistantHouseguidesForPageReq;
import com.bdcourtyard.business.houseGuide.service.AssistantHouseguideService;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;
import com.bdcourtyard.common.response.Response;
import com.beite.tools.utils.AESUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by cxx on 2018/7/19.
 */
@RestController
@Api(value = "WebAssistantHouseguideController", description = "购房指南管理")
@RequestMapping(value = "/pm/web/houseGuide")
public class WebAssistantHouseguideController {

    @Autowired
    private AssistantHouseguideService assistantHouseguideService;

    @ApiOperation(value = "查询购房指南列表", notes = "查询购房指南列表")
    @RequestMapping(value = "v1/getAssistantHouseguidesForPage", method = RequestMethod.POST)
    public Response<Page<AssistantHouseguide>> getAssistantHouseguidesForPage(
            @RequestBody GetAssistantHouseguidesForPageReq getAssistantHouseguidesForPageReq,
            @RequestParam(value="page", defaultValue="1")  int page,
            @RequestParam(value="pageSize", defaultValue="10") int pageSize,
            HttpServletRequest request){

        Pageable pageable = new PageRequest(page, pageSize);
        String estateId = "";
        try {
            estateId = AESUtil.decrypt(request.getHeader("estateId"));
        } catch (Exception e) {
            throw new GlobalException("99999");
        }
        getAssistantHouseguidesForPageReq.setEstateId(estateId);
        Page pageDto = assistantHouseguideService.getAssistantHouseguidesForPage(getAssistantHouseguidesForPageReq,pageable);
        return new Response(pageDto);
    }

    @ApiOperation(value = "新增购房指南信息", notes = "新增购房指南信息")
    @RequestMapping(value = "/insertAssistantHouseguide", method = RequestMethod.POST)
    public Response<Integer> insertAssistantHouseguide(@RequestBody AssistantHouseguide assistantHouseguide,
                                                       HttpServletRequest request){
        String employeeId = "";
        String estateId = "";
        try {
            estateId = AESUtil.decrypt(request.getHeader("estateId"));
            employeeId = AESUtil.decrypt(request.getHeader("employeeId"));
        } catch (Exception e) {
            throw new GlobalException("99999");
        }
        assistantHouseguide.setEstateId(estateId);
        assistantHouseguide.setAdminId(employeeId);
        assistantHouseguide.setCreateTime(new Date());
        assistantHouseguide.setGuideId(IdUtil.getId()+"");
        return new Response<Integer>(assistantHouseguideService.insertAssistantHouseguide(assistantHouseguide));
    }

    @ApiOperation(value = "根据ID修改购房指南信息", notes = "根据ID修改购房指南信息")
    @RequestMapping(value = "/updateAssistantHouseguideById", method = RequestMethod.POST)
    public Response<Integer> updateAssistantHouseguideById(@RequestBody AssistantHouseguide assistantHouseguide,HttpServletRequest request){
        String employeeId = "";
        String estateId = "";
        try {
            estateId = AESUtil.decrypt(request.getHeader("estateId"));
            employeeId = AESUtil.decrypt(request.getHeader("employeeId"));
        } catch (Exception e) {
            throw new GlobalException("99999");
        }
        assistantHouseguide.setEstateId(estateId);
        assistantHouseguide.setAdminId(employeeId);
        assistantHouseguide.setCreateTime(new Date());
        return new Response<Integer>(assistantHouseguideService.updateAssistantHouseguideById(assistantHouseguide));
    }

    @ApiOperation(value = "删除购房指南信息", notes = "删除购房指南信息")
    @RequestMapping(value = "/deleteAssistantHouseguideByIds", method = RequestMethod.GET)
    public Response deleteAssistantHouseguideByIds( @RequestParam String guideIds  ){
        assistantHouseguideService.deleteAssistantHouseguideByIds(  guideIds  );
        return new Response();
    }
}
