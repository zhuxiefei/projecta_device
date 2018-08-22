package com.bdcourtyard.business.clientmessage.rest;

import basic.common.core.id.IdUtil;
import com.bdcourtyard.business.clientmessage.model.*;
import com.bdcourtyard.business.clientmessage.service.ClientNeedreturnService;
import com.bdcourtyard.business.clientmessage.service.ControlClientEnteringService;
import com.bdcourtyard.business.clientmessage.service.ValidRetrunClientService;
import com.bdcourtyard.business.returncust.service.RoomsourceReturncustService;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;
import com.bdcourtyard.common.response.Response;
import com.beite.tools.utils.AESUtil;
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

@RestController
@Api(value = "ValidReturnClientController", description = "有效客户回访列表相关")
@RequestMapping(value = "/crm/web/validReturnClient")
public class ValidReturnClientController {

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
    @Autowired
    private ValidRetrunClientService validRetrunClientService;

    @ApiOperation(value = "有效客户回访列表根据对象分页获取", notes = "有效客户回访列表根据对象分页获取")
    @RequestMapping(value = "/getValidReturnClientForPage", method = RequestMethod.POST)
    public Response<Page<ControlClientEntering>> getControlClientEnteringsForPage(@RequestBody VagueSelectValidClient vagueSelectValidClient,
                                                                                  HttpServletRequest request,
                                                                                  @RequestParam(value="page", defaultValue="1")  int page,
                                                                                  @RequestParam(value="pageSize", defaultValue="10") int pageSize){
        /*String estateId;
        try {
            estateId = AESUtil.decrypt(request.getHeader("estateId"));
        } catch (Exception e) {
            throw new GlobalException("99999");
        }*/
        Pageable pageable = new PageRequest(page, pageSize);
       Page<ControlClientEntering> pageDto= controlClientEnteringService.getControlClientEnterings_valid(vagueSelectValidClient,pageable);
        return new Response<Page<ControlClientEntering>>(pageDto);
    }

    @ApiOperation(value = "有效客户回访列表根据ID回访", notes = "有效客户回访列表根据ID回访")
    @RequestMapping(value = "/getValidReturnClientById", method = RequestMethod.GET)
    public Response<LookOverControlClientEntering> getControlClientEnteringById(@RequestParam String clientId  ){
        LookOverControlClientEntering lookOverControlClientEntering = new LookOverControlClientEntering();
        ControlClientEntering controlClientEntering = controlClientEnteringService.getControlClientEnteringById(clientId);
        lookOverControlClientEntering.setControlClientEntering(controlClientEntering);

        List<ClientNeedreturn> list = clientNeedreturnService.getClientNeedreturnsByclientId(clientId);
        lookOverControlClientEntering.setClientNeedreturnList(list);
        return new Response<LookOverControlClientEntering>(lookOverControlClientEntering);
    }

    @ApiOperation(value = "保存客户信息并添加回访记录", notes = "保存客户信息并添加回访记录")
    @RequestMapping(value = "/updateClientAndAddRecord", method = RequestMethod.POST)
    public Response<Integer> updateClientAndAddRecord(javax.servlet.http.HttpServletRequest request,@RequestBody UpdateControlClientEnteringResp updateControlClientEnteringResp){
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
        /*String employeeId ;
        try {
            employeeId = AESUtil.decrypt(request.getHeader("employeeId"));
        } catch (Exception e) {
            throw new GlobalException("99999");
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
        //生成回访客户表
        RoomsourceReturncust roomsourceReturncust = new RoomsourceReturncust();
        roomsourceReturncust.setClientId(updateControlClientEnteringResp.getClientId());
        String counselor = "1";
        /*String counselor;
        try {
            counselor = AESUtil.decrypt(request.getHeader("employeeId"));
        } catch (Exception e) {
            throw new GlobalException("99999");
        }*/
        validRetrunClientService.insertRoomsourceReturncust(counselor,roomsourceReturncust);

        return new Response<Integer>(controlClientEnteringService.updateControlClientEnteringById(controlClientEntering));
    }

}
