package com.bdcourtyard.business.housesell.rest;
import com.bdcourtyard.business.housesell.service.HousesellService;
import com.bdcourtyard.business.housesell.model.Housesell;
import basic.common.core.dto.PageDto;
import basic.common.core.id.IdUtil;

import com.bdcourtyard.business.housesell.vo.HouseSellDetailVo;
import com.bdcourtyard.business.housesell.vo.HouseTypeVo;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;
import com.beite.tools.utils.AESUtil;
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
 *  HousesellController
 *
 * @version : Ver 1.0
 * @date	: 2018-7-24
 */
@RestController
@Api(value = "HousesellController", description = "房屋销售相关")
@RequestMapping(value = "/crm/web/housesell")
public class HousesellController { 
	
	   @InitBinder   
	    public void initBinder(WebDataBinder binder) {   
	        DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	        dateFormat.setLenient(true);   
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
	    }  
	
	@Autowired
	private HousesellService housesellService;

	/*@ApiOperation(value = "根据ID修改房屋", notes = "根据ID修改房屋")
	@RequestMapping(value = "/updateHousesellById", method = RequestMethod.POST)
	public Response<Integer> updateHousesellById(@RequestBody Housesell housesell){
		return new Response<Integer>(housesellService.updateHousesellById(housesell));
	}




*/

	@ApiOperation(value = "获取所有户型", notes = "获取所有户型")
	@RequestMapping(value = "/getAllHouseType", method = RequestMethod.POST)
	public  Response<List<HouseTypeVo>> getAllHouseType(HttpServletRequest request
															 ){
		String estateId;
		try {
			estateId = AESUtil.decrypt(request.getHeader("estateId"));
		} catch (Exception e) {
			throw new GlobalException("99999");
		}
		List<HouseTypeVo> list = housesellService.getAllHouseType(estateId);

		return new Response<List<HouseTypeVo>>(list);
	}


	@ApiOperation(value = "根据对象分页获取房屋销售信息", notes = "根据对象分页获取房屋销售信息")
	@RequestMapping(value = "/getHousesellsForPage", method = RequestMethod.POST)
	public  Response<Page<Housesell>> getHousesellsForPage(HttpServletRequest request,@RequestBody Housesell housesell,
														   @RequestParam(value="page", defaultValue="1")  int page,
														   @RequestParam(value="pageSize", defaultValue="10") int pageSize){
		String estateId;
		try {
			estateId = AESUtil.decrypt(request.getHeader("estateId"));
		} catch (Exception e) {
			throw new GlobalException("99999");
		}
		if(estateId==null||"".equals(estateId)){
			throw new GlobalException("99999");
		}else{
			housesell.setEstateId(estateId);
		}

		Pageable pageable = new PageRequest(page, pageSize);
		Page<Housesell> pageDto= housesellService.getHousesellsForPage_new(housesell,pageable);
		return new Response<Page<Housesell>>(pageDto);
	}

	@ApiOperation(value = "根据房屋ID获取明细", notes = "根据房屋ID获取明细")
	@RequestMapping(value = "/getHouseSellDetail", method = RequestMethod.GET)
	public Response<HouseSellDetailVo> getHousesellById(@RequestParam String houseId  ){
		if(houseId==null||"".equals(houseId.trim())){
			throw new GlobalException("SA002");
		}
		return new Response<HouseSellDetailVo>(housesellService.getHouseSellDetail(  houseId  ));
	}



}
