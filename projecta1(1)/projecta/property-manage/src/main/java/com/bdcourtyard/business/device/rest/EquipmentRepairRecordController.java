package com.bdcourtyard.business.device.rest;

import basic.common.core.id.IdUtil;
import com.bdcourtyard.business.device.model.EquipmentRepairRecord;
import com.bdcourtyard.business.device.model.EquipmentType;
import com.bdcourtyard.business.device.model.PatrolEquipment;
import com.bdcourtyard.business.device.service.EquipmentRepairRecordService;

import com.bdcourtyard.business.device.vo.EquipmentRepairRecordDetail;
import com.bdcourtyard.business.device.vo.EquipmentRepairRecordRequest;
import com.bdcourtyard.business.device.vo.EquipmentRepairRecordResponse;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;
import com.bdcourtyard.common.response.Response;
import com.bdcourtyard.common.utils.StringUtil;
import com.beite.tools.utils.AESUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @author zhuxiefei
 * @date 2018/8/9 19:26
 */
@RestController
@RequestMapping(value = "/pm/web/EquipmentRepairRecord")
public class EquipmentRepairRecordController {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(EquipmentRepairRecordService.class);
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @Autowired
    private EquipmentRepairRecordService equipmentRepairRecordService;


    @RequestMapping(value = "/getPatrolEquipmentByNo",method = RequestMethod.GET)
    public Response<List<PatrolEquipment>> getPatrolEquipmentNo(HttpServletRequest request, @RequestParam String equipmentNo){
        if (LOG.isInfoEnabled()){
            LOG.info("----------/pm/web/equipmentRepairRecord/getPatrolEquipmentByNo------start-equipmentNo:" + equipmentNo);
        }
        String estateId;
        try {
            estateId = AESUtil.decrypt(request.getHeader("estateId"));
        } catch (Exception e) {

            throw new GlobalException("99999");
        }
        List<PatrolEquipment> p = equipmentRepairRecordService.getPatrolEquipmentByNo(estateId,equipmentNo);

        Response<List<PatrolEquipment>> response = new Response<>(p);

        if (LOG.isInfoEnabled()){
            LOG.info("----------/pm/web/equipmentRepairRecord/getPatrolEquipmentByNo------end-response:" + response);
        }
        return response;

    }

    //新增设备维保记录
    @RequestMapping(value = "/insertEquipmentRepairRecord",method = RequestMethod.POST)
    public Response<Integer> insertEquipmentRecord(@RequestBody EquipmentRepairRecord equipmentRepairRecord){

        if (LOG.isInfoEnabled()){
            LOG.info("----------/pm/web/equipmentRepairRecord/insertEquipmentRepairRecord------start-equipmentRepairRecord:" + equipmentRepairRecord);
        }

        equipmentRepairRecord.setEquipmentId(IdUtil.getId()+"");
        int i = equipmentRepairRecordService.insertEquipmentRecord(equipmentRepairRecord);
        Response<Integer> response = new Response<>(i);
        if (LOG.isInfoEnabled()){
            LOG.info("----------/pm/web/equipmentRepairRecord/insertEquipmentRepairRecord------end-response:" + response);
        }
        return response;

    }

    @RequestMapping(value = "/updateEquipmentRepairRecordById",method = RequestMethod.POST)
    public Response<Integer> updateEquipmentRepairRecordById(@RequestBody EquipmentRepairRecord equipmentRepairRecord){
        if (LOG.isInfoEnabled()){
            LOG.info("----------/pm/web/equipmentRepairRecord/updateEquipmentRepairRecordById------start-equipmentRepairRecord:" + equipmentRepairRecord);
        }
        int u = equipmentRepairRecordService.updateEquipmentRepairRecordById(equipmentRepairRecord);
        Response<Integer> response = new Response<>(u);
        if (LOG.isInfoEnabled()){
            LOG.info("----------/pm/web/equipmentRepairRecord/updateEquipmentRepairRecordById------end-response:" + response);
        }
        return response;
    }

    @RequestMapping(value = "/getEquipmentRepairRecordById",method = RequestMethod.POST)
    public Response<EquipmentRepairRecordDetail> getEquipmentRepairRecordById(@RequestParam String recordId){
        if (LOG.isInfoEnabled()){
            LOG.info("----------/pm/web/equipmentRepairRecord/getEquipmentRepairRecordById------start-equipmentRepairRecord:" + recordId);
        }
        if (StringUtil.isEmpty(recordId)){
            throw new GlobalException("DE055");
        }
        EquipmentRepairRecordDetail detail = equipmentRepairRecordService.getEquipmentRepairRecordById(recordId);
        Response<EquipmentRepairRecordDetail> response = new Response<>(detail);
        if (LOG.isInfoEnabled()){
            LOG.info("----------/pm/web/equipmentRepairRecord/getEquipmentRepairRecordById------end-response:" + response);
        }
        return response;

    }


    @RequestMapping(value = "/getEquipmentRepairRecordsForPage",method = RequestMethod.POST)

    public Response<Page<EquipmentRepairRecordResponse>> getEquipmentRepairRecordsForPage(HttpServletRequest request,
                                                                                         @RequestBody EquipmentRepairRecordRequest equipmentRepairRecordRequest,
                                                                                         @RequestParam(value = "page",defaultValue = "1") int page,
                                                                                         @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        if (LOG.isInfoEnabled()){
            LOG.info("----------/pm/web/equipmentRepairRecord/getEquipmentRepairRecordsForPage------start-equipmentRepairRecordRequest:" + equipmentRepairRecordRequest);
        }
        String estateId;
        try {
            estateId = AESUtil.decrypt(request.getHeader("estateId"));
        } catch (Exception e) {

            throw new GlobalException("99999");
        }
        Pageable pageable = new PageRequest(page,pageSize);
        Page<EquipmentRepairRecordResponse> pageDto = equipmentRepairRecordService.getEquipmentRepairRecordsForPage(estateId,pageable,equipmentRepairRecordRequest);

        Response<Page<EquipmentRepairRecordResponse>> response = new Response<>(pageDto);
        if (LOG.isInfoEnabled()){
            LOG.info("----------/pm/web/equipmentRepairRecord/getEquipmentRepairRecordsForPage------end-response:" + response);
        }
        return response;


    }
    @RequestMapping(value = "/getEquipmentRepairRecordForExport",method = RequestMethod.POST)
    public Response<List<EquipmentRepairRecordResponse>> getEquipmentRepairRecordForExport(HttpServletRequest request,@RequestBody EquipmentRepairRecordRequest equipmentRepairRecordRequest){
        if (LOG.isInfoEnabled()){
            LOG.info("----------/pm/web/equipmentRepairRecord/getEquipmentRepairRecordById------start-equipmentRepairRecordRequest:" + equipmentRepairRecordRequest);
        }
        String estateId;
        try {
            estateId = AESUtil.decrypt(request.getHeader("estateId"));
        } catch (Exception e) {

            throw new GlobalException("99999");
        }
        List<EquipmentRepairRecordResponse> g = equipmentRepairRecordService.getEquipmentRepairRecordForExport(equipmentRepairRecordRequest,estateId);
        Response<List<EquipmentRepairRecordResponse>> response = new Response<>(g);
        if (LOG.isInfoEnabled()){
            LOG.info("----------/pm/web/equipmentRepairRecord/getEquipmentRepairRecordForPage------end-response:" + response);
        }
        return response;
    }









    /*@RequestMapping(value = "/deleteEquipmentRepairRecordById",method = RequestMethod.GET)
    public Response<Integer> deleteEquipmentRepairRecordById(String recordId){

    }*/


    //根据id获取设备维保记录
    /*@RequestMapping(value = "/getEquipmentRepairRecord",method = RequestMethod.GET)
    public Response<EquipmentRepairRecordDetail> getEquipmentRepairRecord()
*/



}
