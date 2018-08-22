package com.bdcourtyard.business.subscription.rest;
import com.bdcourtyard.business.housesell.service.HousesellService;
import com.bdcourtyard.business.housesell.vo.HouseSellDetailVo;
import com.bdcourtyard.business.returncust.model.ControlClientEntering;
import com.bdcourtyard.business.subscription.service.RoomsourceSubscriptionService;
import com.bdcourtyard.business.subscription.model.RoomsourceSubscription;
import basic.common.core.dto.PageDto;
import basic.common.core.id.IdUtil;

import com.bdcourtyard.business.subscription.vo.HousesubVo;
import com.bdcourtyard.business.subscription.vo.SubInformatiomVo;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;
import com.beite.tools.utils.AESUtil;
import javax.servlet.http.HttpServletRequest;
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  RoomsourceSubscriptionController
 *
 * @version : Ver 1.0
 * @date	: 2018-7-24
 */
@RestController
@Api(value = "RoomsourceSubscriptionController", description = "客户认购信息相关")
@RequestMapping(value = "/crm/web/roomsourceSubscription")
public class RoomsourceSubscriptionController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@Autowired
	private HousesellService housesellService;

	@Autowired
	private RoomsourceSubscriptionService roomsourceSubscriptionService;

	/*@ApiOperation(value = "新增客户认购信息", notes = "新增客户认购信息")
	@RequestMapping(value = "/insertRoomsourceSubscription", method = RequestMethod.POST)
	public Response<Integer> insertRoomsourceSubscription(@RequestBody RoomsourceSubscription roomsourceSubscription){
		roomsourceSubscription.setSubscriptionId(IdUtil.getId()+"");

		return new Response<Integer>(roomsourceSubscriptionService.insertRoomsourceSubscription(roomsourceSubscription));
	}
	@ApiOperation(value = "批量新增客户认购信息", notes = "批量新增客户认购信息")
	@RequestMapping(value = "/insertRoomsourceSubscriptionBatch", method = RequestMethod.POST)
	public Response<Integer> insertRoomsourceSubscriptionBatch(@RequestBody List<RoomsourceSubscription> list){
		return  new Response<Integer>(roomsourceSubscriptionService.insertRoomsourceSubscriptionBatch(list));
	}
	@ApiOperation(value = "根据ID修改客户认购信息", notes = "根据ID修改客户认购信息")
	@RequestMapping(value = "/updateRoomsourceSubscriptionById", method = RequestMethod.POST)
	public Response<Integer> updateRoomsourceSubscriptionById(@RequestBody RoomsourceSubscription roomsourceSubscription){
		return new Response<Integer>(roomsourceSubscriptionService.updateRoomsourceSubscriptionById(roomsourceSubscription));
	}
	@ApiOperation(value = "根据ID删除客户认购信息", notes = "根据ID删除客户认购信息")
	@RequestMapping(value = "/deleteRoomsourceSubscriptionById", method = RequestMethod.GET)
	public Response<Integer> deleteRoomsourceSubscriptionById( @RequestParam String subscriptionId  ){
		return new Response<Integer>(roomsourceSubscriptionService.deleteRoomsourceSubscriptionById(  subscriptionId  ));
	}

	@ApiOperation(value = "根据对象获取客户认购信息", notes = "根据对象获取客户认购信息")
	@RequestMapping(value = "/getRoomsourceSubscriptions", method = RequestMethod.POST)
	public  Response<List<RoomsourceSubscription>> getRoomsourceSubscriptions( @RequestBody RoomsourceSubscription roomsourceSubscription){
		return new Response<List<RoomsourceSubscription>>(roomsourceSubscriptionService.getRoomsourceSubscriptions(roomsourceSubscription));

 	}*/

	@ApiOperation(value = "根据对象分页获取客户认购信息", notes = "根据对象分页获取客户认购信息")
	@RequestMapping(value = "/getRoomsourceSubscriptionsForPage", method = RequestMethod.POST)
	public  Response<Page<HousesubVo>> getRoomsourceSubscriptionsForPage(HttpServletRequest request,@RequestBody HousesubVo housesubVo,
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
			housesubVo.setEstateId(estateId);
		}
		Pageable pageable = new PageRequest(page, pageSize);
		Page<HousesubVo> pageDto= roomsourceSubscriptionService.getRoomsourceSubscriptionsForPage(housesubVo,pageable);
		return new Response<Page<HousesubVo>>(pageDto);
	}



	@ApiOperation(value = "根据房屋ID获取详情", notes = "根据房屋ID获取详情")
	@RequestMapping(value = "/getRoomsourceSubscriptionById", method = RequestMethod.GET)
	public Response<RoomsourceSubscription> getRoomsourceSubscriptionById( @RequestParam String houseId  ){
		if(houseId==null||"".equals(houseId.trim())){
			throw new GlobalException("SA002");
		}
		//从房屋销售获取基本详情
		HouseSellDetailVo detail = housesellService.getHouseSellDetail(houseId);

		return new Response<RoomsourceSubscription>(roomsourceSubscriptionService.getRoomsourceSubscriptionById(detail, houseId  ));
	}


	@ApiOperation(value = "根据房屋ID执行退房、取消操作", notes = "根据房屋ID执行退房、取消操作（调此接口前最后先调详情接口，展示并确认退房人的姓名，防止多人操作，退了其他客户的房）")
	@RequestMapping(value = "/cancelHouseState", method = RequestMethod.GET)
	public Response<Integer> cancelHouseState( @RequestParam String houseId  ){
		if(houseId==null||"".equals(houseId.trim())){
			throw new GlobalException("SA002");
		}


		return new Response<Integer>(roomsourceSubscriptionService.cancelHouseState( houseId  ));
	}


	@ApiOperation(value = "根据姓名获取客户信息", notes = "根据姓名获取客户信息（选购时候使用）")
	@RequestMapping(value = "/getMeaasgeByName", method = RequestMethod.GET)
	public Response<List<SubInformatiomVo>> getMeaasgeByName(HttpServletRequest request, @RequestParam String name  ){
		if(name==null||"".equals(name.trim())){
			throw new GlobalException("SA001");
		}
		name=name.trim();
		String estateId;
		try {
			estateId = AESUtil.decrypt(request.getHeader("estateId"));
		} catch (Exception e) {
			throw new GlobalException("99999");
		}
		if(estateId==null||"".equals(estateId)){
			throw new GlobalException("99999");
		}

		return new Response<List<SubInformatiomVo>>(roomsourceSubscriptionService.getMeaasgeByName( name  ,estateId));
	}

	//
	@ApiOperation(value = "对在售房屋选购操作", notes = "对在售房屋选购操作（若是通过搜索得到的用户一定要传clientId）")
	@RequestMapping(value = "/insertHouseSub_xg", method = RequestMethod.POST)
	public  Response<Integer> insertHouseSub_xg(HttpServletRequest request,@RequestBody SubInformatiomVo subInformatiomVo){
		String estateId,employeeId;
		try {
			estateId = AESUtil.decrypt(request.getHeader("estateId"));
			employeeId = AESUtil.decrypt(request.getHeader("employeeId"));
		} catch (Exception e) {
			throw new GlobalException("99999");
		}
		if(estateId==null||"".equals(estateId)||employeeId==null||"".equals(employeeId)){
			throw new GlobalException("99999");
		}else{
			subInformatiomVo.setEstateId(estateId);
			subInformatiomVo.setEmployeeId(employeeId);
		}
		return new Response<Integer>(roomsourceSubscriptionService.insertHouseSub_xg(subInformatiomVo));
	}

	@ApiOperation(value = "对认购中的房屋认购操作", notes = "对认购中的房屋认购操作")
	@RequestMapping(value = "/insertHouseSub_rg", method = RequestMethod.POST)
	public  Response<Integer> insertHouseSub_rg(HttpServletRequest request,@RequestBody SubInformatiomVo subInformatiomVo){
		String estateId,employeeId;
		try {
			estateId = AESUtil.decrypt(request.getHeader("estateId"));
			employeeId = AESUtil.decrypt(request.getHeader("employeeId"));
		} catch (Exception e) {
			throw new GlobalException("99999");
		}
		if(estateId==null||"".equals(estateId)||employeeId==null||"".equals(employeeId)){
			throw new GlobalException("99999");
		}else{
			subInformatiomVo.setEstateId(estateId);
			subInformatiomVo.setEmployeeId(employeeId);
		}
		return new Response<Integer>(roomsourceSubscriptionService.insertHouseSub_rg(subInformatiomVo));
	}


	@ApiOperation(value = "对已认购的房屋进行合同管理操作", notes = "对已认购的房屋进行合同管理操作")
	@RequestMapping(value = "/insertHouseSub_ht", method = RequestMethod.POST)
	public  Response<Integer> insertHouseSub_ht(HttpServletRequest request,@RequestBody SubInformatiomVo subInformatiomVo){
		String estateId,employeeId;
		try {
			estateId = AESUtil.decrypt(request.getHeader("estateId"));
			employeeId = AESUtil.decrypt(request.getHeader("employeeId"));
		} catch (Exception e) {
			throw new GlobalException("99999");
		}
		if(estateId==null||"".equals(estateId)||employeeId==null||"".equals(employeeId)){
			throw new GlobalException("99999");
		}else{
			subInformatiomVo.setEstateId(estateId);
			subInformatiomVo.setEmployeeId(employeeId);
		}
		if(subInformatiomVo.getHouseId()==null||subInformatiomVo.getHouseId().equals("")){
			throw new GlobalException("SA002");
		}
		//从房屋销售获取基本详情
		HouseSellDetailVo detail = housesellService.getHouseSellDetail(subInformatiomVo.getHouseId());
		return new Response<Integer>(roomsourceSubscriptionService.insertHouseSub_ht(detail ,subInformatiomVo));
	}









}
