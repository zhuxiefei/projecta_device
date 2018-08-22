package com.bdcourtyard.business.estate.rest;

import com.bdcourtyard.business.estate.service.EstateStartPageService;
import com.bdcourtyard.common.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *  EstateStartPageController
 *
 * @version : Ver 1.0
 * @date	: 2018-7-19
 */
@RestController
@Api(value = "EstateStartPageController", description = "营销助手app--欢迎页")
@RequestMapping(value = "/oa/common/assistantApp/startPage")
public class EstateStartPageController {

	private static final Logger LOG = LoggerFactory.getLogger(EstateStartPageController.class);
	
	   @InitBinder
	    public void initBinder(WebDataBinder binder) {
	        DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	        dateFormat.setLenient(true);   
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    }  
	
	@Autowired
	private EstateStartPageService estateStartPageService;

	@ApiOperation(value = "查询欢迎页图片", notes = "查询欢迎页图片")
    @RequestMapping(value = "/findPages", method = RequestMethod.GET)
    public Response<String> findPages() {
        if (LOG.isInfoEnabled()) {
            LOG.info("--------assistantApp/startPage/v1/findPages-------start");
        }
        Response<String> response = new Response<>();
        response.setData(estateStartPageService.findPages(3));
        if (LOG.isInfoEnabled()) {
            LOG.info("--------assistantApp/startPage/v1/findPages--------end,response=" + response);
        }
        return response;
    }
}
