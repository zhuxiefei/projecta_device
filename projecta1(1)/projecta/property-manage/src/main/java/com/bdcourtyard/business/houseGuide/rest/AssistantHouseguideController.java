package com.bdcourtyard.business.houseGuide.rest;

import com.bdcourtyard.business.houseGuide.model.AssistantHouseguide;
import com.bdcourtyard.business.houseGuide.service.AssistantHouseguideService;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;
import com.bdcourtyard.common.response.Response;
import com.beite.tools.utils.AESUtil;
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
 * AssistantHouseguideController
 *
 * @version : Ver 1.0
 * @date    : 2018-7-19
 */
@RestController
@Api(value = "AssistantHouseguideController", description = "营销助手app--购房指南")
@RequestMapping(value = "/pm/assistantApp/houseGuide")
public class AssistantHouseguideController {

    private static final Logger LOG = LoggerFactory.getLogger(AssistantHouseguideController.class);

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @Autowired
    private AssistantHouseguideService assistantHouseguideService;

    @ApiOperation(value = "分页查询购房指南列表", notes = "分页查询购房指南列表")
    @RequestMapping(value = "/findGuides", method = RequestMethod.POST)
    public Response<Page<AssistantHouseguide>> findGuides(@RequestParam(value = "page", defaultValue = "1") int page,
                                                          @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                                          HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("----------assistantApp/houseGuide/v1/findGuides------start-");
        }
        Pageable pageable = new PageRequest(page, pageSize);
        String estateId;
        try {
            estateId = AESUtil.decrypt(request.getHeader("estateId"));
        } catch (Exception e) {
            throw new GlobalException("99999");
        }
        Page<AssistantHouseguide> pageDto = assistantHouseguideService.getAssistantHouseguides(estateId, pageable);
        Response<Page<AssistantHouseguide>> response = new Response<>(pageDto);
        if (LOG.isInfoEnabled()) {
            LOG.info("----------assistantApp/houseGuide/v1/findGuides------end-");
        }
        return response;
    }

    @ApiOperation(value = "查询购房指南详情", notes = "查询购房指南详情")
    @RequestMapping(value = "/findGuideInfo", method = RequestMethod.GET)
    public Response<AssistantHouseguide> findGuideInfo(@RequestParam String guideId,
                                                       HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("----------assistantApp/houseGuide/v1/findGuideInfo------start-guideId=" + guideId);
        }
        Response<AssistantHouseguide> response = new Response<>();
        response.setData(assistantHouseguideService.getAssistantHouseguideById(guideId));
        if (LOG.isInfoEnabled()) {
            LOG.info("----------assistantApp/houseGuide/v1/findGuideInfo------end-");
        }
        return response;
    }
}
