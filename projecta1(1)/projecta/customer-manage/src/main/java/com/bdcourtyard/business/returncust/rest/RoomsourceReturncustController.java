package com.bdcourtyard.business.returncust.rest;
import com.bdcourtyard.business.clientmessage.model.ClientNeedreturn;
import com.bdcourtyard.business.clientmessage.model.LookOverControlClientEntering;
import com.bdcourtyard.business.clientmessage.model.UpdateControlClientEnteringResp;
import com.bdcourtyard.business.clientmessage.service.ClientNeedreturnService;
import com.bdcourtyard.business.clientmessage.service.ControlClientEnteringService;
import com.bdcourtyard.business.clientmessage.service.ValidRetrunClientService;
import com.bdcourtyard.business.returncust.model.ControlClientEntering;
import com.bdcourtyard.business.returncust.service.RoomsourceReturncustService;
import basic.common.core.id.IdUtil;

import com.bdcourtyard.business.returncust.vo.RoomsourceReturnRecord;
import com.bdcourtyard.business.returncust.vo.RoomsourceReturncust;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;
import com.beite.tools.utils.AESUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.bdcourtyard.common.response.Response;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *  RoomsourceReturncustController
 *
 * @version : Ver 1.0
 * @date	: 2018-7-25
 */
@RestController
@Api(value = "RoomsourceReturncustController", description = "回访记录相关")
@RequestMapping(value = "/crm/web/roomsourceReturncust")
public class RoomsourceReturncustController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@Autowired
	private RoomsourceReturncustService roomsourceReturncustService;

	@Autowired
	private ControlClientEnteringService controlClientEnteringService;
	@Autowired
	private ClientNeedreturnService clientNeedreturnService;
	@Autowired
	private ValidRetrunClientService validRetrunClientService;

	/*@ApiOperation(value = "新增回访记录", notes = "新增回访记录")
	@RequestMapping(value = "/insertRoomsourceReturncust", method = RequestMethod.POST)
	public Response<Integer> insertRoomsourceReturncust(@RequestBody RoomsourceReturncust roomsourceReturncust){
		roomsourceReturncust.setReturnId(IdUtil.getId()+"");

		return new Response<Integer>(roomsourceReturncustService.insertRoomsourceReturncust(roomsourceReturncust));
	}
	@ApiOperation(value = "批量新增回访记录", notes = "批量新增回访记录")
	@RequestMapping(value = "/insertRoomsourceReturncustBatch", method = RequestMethod.POST)
	public Response<Integer> insertRoomsourceReturncustBatch(@RequestBody List<RoomsourceReturncust> list){
		return  new Response<Integer>(roomsourceReturncustService.insertRoomsourceReturncustBatch(list));
	}
	@ApiOperation(value = "根据ID修改回访记录", notes = "根据ID修改回访记录")
	@RequestMapping(value = "/updateRoomsourceReturncustById", method = RequestMethod.POST)
	public Response<Integer> updateRoomsourceReturncustById(@RequestBody RoomsourceReturncust roomsourceReturncust){
		return new Response<Integer>(roomsourceReturncustService.updateRoomsourceReturncustById(roomsourceReturncust));
	}
	@ApiOperation(value = "根据ID删除回访记录", notes = "根据ID删除回访记录")
	@RequestMapping(value = "/deleteRoomsourceReturncustById", method = RequestMethod.GET)
	public Response<Integer> deleteRoomsourceReturncustById( @RequestParam String returnId  ){
		return new Response<Integer>(roomsourceReturncustService.deleteRoomsourceReturncustById(  returnId  ));
	}
	@ApiOperation(value = "根据ID获取回访记录", notes = "根据ID获取回访记录")
	@RequestMapping(value = "/getRoomsourceReturncustById", method = RequestMethod.GET)
	public Response<RoomsourceReturncust> getRoomsourceReturncustById( @RequestParam String returnId  ){
		return new Response<RoomsourceReturncust>(roomsourceReturncustService.getRoomsourceReturncustById(  returnId  ));
	}

	@ApiOperation(value = "根据对象获取回访记录", notes = "根据对象获取回访记录")
	@RequestMapping(value = "/getRoomsourceReturncusts", method = RequestMethod.POST)
	public  Response<List<RoomsourceReturncust>> getRoomsourceReturncusts( @RequestBody RoomsourceReturncust roomsourceReturncust){
		return new Response<List<RoomsourceReturncust>>(roomsourceReturncustService.getRoomsourceReturncusts(roomsourceReturncust));

 	}**/

	@ApiOperation(value = "根据对象分页获取回访客户列表", notes = "根据对象分页获取回访客户列表")
	@RequestMapping(value = "/getRoomsourceReturncustsForPage", method = RequestMethod.POST)
	public  Response<Page<RoomsourceReturncust>> getRoomsourceReturncustsForPage(javax.servlet.http.HttpServletRequest request, @RequestBody RoomsourceReturncust roomsourceReturncust,
																				 @RequestParam(value="page", defaultValue="1")  int page,
																				 @RequestParam(value="pageSize", defaultValue="10") int pageSize){
		String estateId ;
		try {
			estateId = AESUtil.decrypt(request.getHeader("estateId"));
		} catch (Exception e) {
			throw new GlobalException("99999");
		}
		roomsourceReturncust.setEstateId(estateId);
		Pageable pageable = new PageRequest(page, pageSize);
		Page<RoomsourceReturncust> pageDto= roomsourceReturncustService.getRoomsourceReturncustsForPage_new(roomsourceReturncust,pageable);
		return new Response<Page<RoomsourceReturncust>>(pageDto);
	}


	@ApiOperation(value = "根据对象分页获取回访记录列表", notes = "根据对象分页获取回访记录列表")
	@RequestMapping(value = "/getReturnRecordForPage", method = RequestMethod.POST)
	public  Response<Page<RoomsourceReturnRecord>> getReturnRecordForPage(javax.servlet.http.HttpServletRequest request, @RequestBody RoomsourceReturnRecord roomsourceReturnRecord,
																		  @RequestParam(value="page", defaultValue="1")  int page,
																		  @RequestParam(value="pageSize", defaultValue="10") int pageSize){

		Pageable pageable = new PageRequest(page, pageSize);
		Page<RoomsourceReturnRecord> pageDto= roomsourceReturncustService.getReturnRecordForPage(roomsourceReturnRecord,pageable);
		return new Response<Page<RoomsourceReturnRecord>>(pageDto);
	}




	@ApiOperation(value = "根据ID获取客户信息", notes = "根据ID获取客户信息")
	@RequestMapping(value = "/getControlClientEnteringById", method = RequestMethod.GET)
	public Response<LookOverControlClientEntering> getControlClientEnteringById(@RequestParam String clientId  ){
		if(clientId==null||clientId.trim().equals("")){
			throw new GlobalException("SA005");
		}
		LookOverControlClientEntering lookOverControlClientEntering = new LookOverControlClientEntering();
		com.bdcourtyard.business.clientmessage.model.ControlClientEntering controlClientEntering = controlClientEnteringService.getControlClientEnteringById(clientId);
		lookOverControlClientEntering.setControlClientEntering(controlClientEntering);

		List<ClientNeedreturn> list = clientNeedreturnService.getClientNeedreturnsByclientId(clientId);
		lookOverControlClientEntering.setClientNeedreturnList(list);
		return new Response<LookOverControlClientEntering>(lookOverControlClientEntering);
	}





	@ApiOperation(value = "保存客户信息并添加回访记录", notes = "保存客户信息并添加回访记录")
	@RequestMapping(value = "/updateClientAndAddRecord", method = RequestMethod.POST)
	public Response<Integer> updateClientAndAddRecord(javax.servlet.http.HttpServletRequest request,@RequestBody UpdateControlClientEnteringResp updateControlClientEnteringResp){
		String employeeId ;
		try {
			employeeId = AESUtil.decrypt(request.getHeader("employeeId"));
		} catch (Exception e) {
			throw new GlobalException("99999");
		}

		return new Response<Integer>(roomsourceReturncustService.updateClientAndAddRecord(employeeId,updateControlClientEnteringResp));
	}


}
