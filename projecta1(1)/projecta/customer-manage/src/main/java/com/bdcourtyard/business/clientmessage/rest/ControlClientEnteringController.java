package com.bdcourtyard.business.clientmessage.rest;

import basic.common.core.id.IdUtil;
import com.bdcourtyard.business.clientmessage.model.*;
import com.bdcourtyard.business.clientmessage.service.ClientNeedreturnService;
import com.bdcourtyard.business.clientmessage.service.ControlClientEnteringService;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;
import com.bdcourtyard.common.response.Response;
import com.beite.tools.utils.AESUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
 *  ControlClientEnteringController
 *
 * @version : Ver 1.0
 * @date	: 2018-7-24
 */
@RestController
@Api(value = "ControlClientEnteringController", description = "客户信息管理相关")
@RequestMapping(value = "/crm/web/controlClientEntering")
public class ControlClientEnteringController { 
	
	   @InitBinder
	    public void initBinder(WebDataBinder binder) {
	        DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	        dateFormat.setLenient(true);   
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    }  
	
	@Autowired
	private ControlClientEnteringService controlClientEnteringService;
	@Autowired
	private ClientNeedreturnService clientNeedreturnService;

	@ApiOperation(value = "客户信息新增", notes = "客户信息新增")
	@RequestMapping(value = "/insertControlClientEntering", method = RequestMethod.POST)
	public Response<Integer> insertControlClientEntering(@RequestBody AddControlClientEntering addControlClientEntering,HttpServletRequest request){
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		ControlClientEntering controlClientEntering = new ControlClientEntering(null,addControlClientEntering.getClientName(),
				addControlClientEntering.getClientAge(),addControlClientEntering.getClientGender(),addControlClientEntering.getClientLooks(),
				addControlClientEntering.getClientPhone(),addControlClientEntering.getIdCard(),addControlClientEntering.getInformation(),
				addControlClientEntering.getClientFamily(),addControlClientEntering.getFamilyStructure(),addControlClientEntering.getDwellResidential(),
				addControlClientEntering.getWorkResidential(),addControlClientEntering.getVehicle(),addControlClientEntering.getMotive(),
				addControlClientEntering.getEmphasis(),addControlClientEntering.getDemandProduct(),addControlClientEntering.getDemandHouse(),
				addControlClientEntering.getDemandDiscount(),addControlClientEntering.getDemandTotal(),addControlClientEntering.getDemandFllor(),
				addControlClientEntering.getProductReflect(),addControlClientEntering.getProductRecommendRoomNumber(),
				addControlClientEntering.getProductRecommendHouseType(),addControlClientEntering.getProductRecommendProportion(),
				addControlClientEntering.getProductRecommendUnitPrice(),addControlClientEntering.getProductRecommendTotalPrices(),
				addControlClientEntering.getReceivingRecords(),addControlClientEntering.getClientRank(),addControlClientEntering.getClientInauguration(),
				addControlClientEntering.getInaugurationName(),addControlClientEntering.getDuty(),addControlClientEntering.getClientState(),
				null,addControlClientEntering.getReturnVisit(),addControlClientEntering.getTrace(),
				addControlClientEntering.getBargain(),addControlClientEntering.getUnsubmittedFactor(),addControlClientEntering.getConfirm(),addControlClientEntering.getRemark(),null,
				addControlClientEntering.getEmphasisRests(),addControlClientEntering.getClientInaugurationRests(),addControlClientEntering.getUnsubmittedFactorRests(),null,
				addControlClientEntering.getInformationRests()
				);
		String estateId="1";controlClientEntering.setEstateId(estateId);
		/*String estateId;
		try {
			estateId = AESUtil.decrypt(request.getHeader("estateId"));
		} catch (Exception e) {
			throw new GlobalException("99999");
		}
		if(estateId==null||"".equals(estateId.trim())){
			throw new GlobalException("H0001");
		}else{
			controlClientEntering.setEstateId(estateId);
		}*/
		String clientId = simpleDateFormat.format(date);
		controlClientEntering.setClientId(clientId);
		controlClientEntering.setImputTime(date);
		String counselor="1";controlClientEntering.setCounselor(counselor);
		/*String counselor;
		try {
			counselor = AESUtil.decrypt(request.getHeader("employeeId"));
		} catch (Exception e) {
			throw new GlobalException("99999");
		}
		if(estateId==null||"".equals(estateId.trim())){
			throw new GlobalException("H0001");
		}else{
			controlClientEntering.setCounselor(counselor);
		}*/

		//生成关联回访时间表
		String[] retrunTimes = addControlClientEntering.getReturnTimes();
		ClientNeedreturn clientNeedreturn = new ClientNeedreturn();
		if(retrunTimes!=null){
			for(String returnTime : retrunTimes){
				clientNeedreturn.setNeedId(IdUtil.getId()+"");
				clientNeedreturn.setClientId(clientId);
				clientNeedreturn.setNeedreturnTime(returnTime);
				clientNeedreturn.setCreateTime(date);
				int result = clientNeedreturnService.insertClientNeedreturn(clientNeedreturn);
				if(result<0){
					throw new GlobalException("CM007");
				}
		}
	}
		return new Response<Integer>(controlClientEnteringService.insertControlClientEntering(controlClientEntering));
	}
	/*@ApiOperation(value = "批量新增", notes = "批量新增")
	@RequestMapping(value = "/insertControlClientEnteringBatch", method = RequestMethod.POST)
	public Response<Integer> insertControlClientEnteringBatch(@RequestBody List<ControlClientEntering> list){
		return  new Response<Integer>(controlClientEnteringService.insertControlClientEnteringBatch(list));
	}*/
	@ApiOperation(value = "客户信息根据ID修改", notes = "客户信息根据ID修改")
	@RequestMapping(value = "/updateControlClientEnteringById", method = RequestMethod.POST)
	public Response<Integer> updateControlClientEnteringById(@RequestBody UpdateControlClientEnteringResp updateControlClientEnteringResp, HttpServletRequest request){

		ControlClientEntering controlClientEntering = new ControlClientEntering(updateControlClientEnteringResp.getClientId(),updateControlClientEnteringResp.getClientName(),
				updateControlClientEnteringResp.getClientAge(),updateControlClientEnteringResp.getClientGender(),updateControlClientEnteringResp.getClientLooks(),
				updateControlClientEnteringResp.getClientPhone(),updateControlClientEnteringResp.getIdCard(),updateControlClientEnteringResp.getInformation(),
				updateControlClientEnteringResp.getClientFamily(),updateControlClientEnteringResp.getFamilyStructure(),updateControlClientEnteringResp.getDwellResidential(),
				updateControlClientEnteringResp.getWorkResidential(),updateControlClientEnteringResp.getVehicle(),updateControlClientEnteringResp.getMotive(),
				updateControlClientEnteringResp.getEmphasis(),updateControlClientEnteringResp.getDemandProduct(),updateControlClientEnteringResp.getDemandHouse(),
				updateControlClientEnteringResp.getDemandDiscount(),updateControlClientEnteringResp.getDemandTotal(),updateControlClientEnteringResp.getDemandFllor(),
				updateControlClientEnteringResp.getProductReflect(),updateControlClientEnteringResp.getProductRecommendRoomNumber(),
				updateControlClientEnteringResp.getProductRecommendHouseType(),updateControlClientEnteringResp.getProductRecommendProportion(),
				updateControlClientEnteringResp.getProductRecommendUnitPrice(),updateControlClientEnteringResp.getProductRecommendTotalPrices(),
				updateControlClientEnteringResp.getReceivingRecords(),updateControlClientEnteringResp.getClientRank(),updateControlClientEnteringResp.getClientInauguration(),
				updateControlClientEnteringResp.getInaugurationName(),updateControlClientEnteringResp.getDuty(),updateControlClientEnteringResp.getClientState(),
				null,updateControlClientEnteringResp.getReturnVisit(),updateControlClientEnteringResp.getTrace(),
				updateControlClientEnteringResp.getBargain(),updateControlClientEnteringResp.getUnsubmittedFactor(),updateControlClientEnteringResp.getConfirm(),updateControlClientEnteringResp.getRemark(),null,
				updateControlClientEnteringResp.getEmphasisRests(),updateControlClientEnteringResp.getClientInaugurationRests(),updateControlClientEnteringResp.getUnsubmittedFactorRests(),null,
				updateControlClientEnteringResp.getInformationRests()
		);
		String estateId="1";controlClientEntering.setEstateId(estateId);
		/*String estateId;
		try {
			estateId = AESUtil.decrypt(request.getHeader("estateId"));
		} catch (Exception e) {
			throw new GlobalException("99999");
		}
		if(estateId==null||"".equals(estateId.trim())){
			throw new GlobalException("H0001");
		}else{
			controlClientEntering.setEstateId(estateId);
		}*/
		 String counselor="1";controlClientEntering.setCounselor(counselor);
		/*String counselor;
		try {
			counselor = AESUtil.decrypt(request.getHeader("employeeId"));
		} catch (Exception e) {
			throw new GlobalException("99999");
		}
		if(estateId==null||"".equals(estateId.trim())){
			throw new GlobalException("H0001");
		}else{
			controlClientEntering.setCounselor(counselor);
		}*/
		controlClientEntering.setImputTime(new Date());

		String[] retrunTimes = updateControlClientEnteringResp.getReturnTimes();
		//清空有关联的回访时间
		int deleteresult = clientNeedreturnService.deleteClientNeedreturnByclientId(updateControlClientEnteringResp.getClientId());
		if(deleteresult<0){
			throw new GlobalException("H0009");
		}

		//生成关联回访时间表
		ClientNeedreturn clientNeedreturn = new ClientNeedreturn();
		if(retrunTimes!=null){
			for(String returnTime : retrunTimes){
				clientNeedreturn.setNeedId(IdUtil.getId()+"");
				clientNeedreturn.setClientId(updateControlClientEnteringResp.getClientId());
				clientNeedreturn.setNeedreturnTime(returnTime);
				clientNeedreturn.setCreateTime(new Date());
				int addresult = clientNeedreturnService.insertClientNeedreturn(clientNeedreturn);
				if(addresult<0){
					throw new GlobalException("CM007");
				}
			}
		}
		return new Response<Integer>(controlClientEnteringService.updateControlClientEnteringById(controlClientEntering));
	}
	@ApiOperation(value = "客户信息根据ID删除", notes = "客户信息根据ID删除")
	@RequestMapping(value = "/deleteControlClientEnteringById", method = RequestMethod.GET)
	public Response<Boolean> deleteControlClientEnteringById(@RequestParam String clientId  ){
		return new Response<Boolean>(controlClientEnteringService.deleteControlClientEnteringById(  clientId  ));
	}
	@ApiOperation(value = "客户信息根据ID获取", notes = "客户信息根据ID获取")
	@RequestMapping(value = "/getControlClientEnteringById", method = RequestMethod.GET)
	public Response<LookOverControlClientEntering> getControlClientEnteringById(@RequestParam String clientId  ){

		LookOverControlClientEntering lookOverControlClientEntering = new LookOverControlClientEntering();
		ControlClientEntering controlClientEntering = controlClientEnteringService.getControlClientEnteringById(clientId);
		lookOverControlClientEntering.setControlClientEntering(controlClientEntering);

		List<ClientNeedreturn> list = clientNeedreturnService.getClientNeedreturnsByclientId(clientId);
		lookOverControlClientEntering.setClientNeedreturnList(list);
		return new Response<LookOverControlClientEntering>(lookOverControlClientEntering);
	}
 
	/*@ApiOperation(value = "根据对象获取", notes = "根据对象获取")
	@RequestMapping(value = "/getControlClientEnterings", method = RequestMethod.POST)
	public Response<List<ControlClientEntering>> getControlClientEnterings(@RequestBody ControlClientEntering controlClientEntering){
		return new Response<List<ControlClientEntering>>(controlClientEnteringService.getControlClientEnterings(controlClientEntering));
 	}*/

	@ApiOperation(value = "客户信息根据对象分页获取", notes = "客户信息根据对象分页获取")
	@RequestMapping(value = "/getControlClientEnteringsForPage", method = RequestMethod.POST)
	public Response<Page<ControlClientEntering>> getControlClientEnteringsForPage(@RequestBody VagueSelect vagueSelect,HttpServletRequest request,
																				  @RequestParam(value="page", defaultValue="1")  int page,
																				  @RequestParam(value="pageSize", defaultValue="10") int pageSize){
		/*String estateId;
		try {
			estateId = AESUtil.decrypt(request.getHeader("estateId"));
		} catch (Exception e) {
			throw new GlobalException("99999");
		}*/
		Pageable pageable = new PageRequest(page, pageSize);
		Page<ControlClientEntering> pageDto= controlClientEnteringService.getControlClientEnteringsForPage(vagueSelect,pageable);
		return new Response<Page<ControlClientEntering>>(pageDto);
 	}

	@ApiOperation(value = "根据条件查询(用于导出)", notes = "根据条件查询(用于导出)")
	@RequestMapping(value = "/getControlClientEnteringsExport", method = RequestMethod.POST)
	public Response<List<ControlClientEntering>> getControlClientEnteringsExport(@RequestBody VagueSelect vagueSelect){
		List<ControlClientEntering> pageDto= controlClientEnteringService.getControlClientEnteringsExport(vagueSelect);
		return new Response<List<ControlClientEntering>>(pageDto);
	}
}
