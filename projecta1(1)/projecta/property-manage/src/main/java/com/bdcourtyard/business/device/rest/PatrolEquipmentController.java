package com.bdcourtyard.business.device.rest;

import basic.common.core.id.IdUtil;
import com.bdcourtyard.business.device.model.EquipmentType;
import com.bdcourtyard.business.device.model.PatrolEquipment;
import com.bdcourtyard.business.device.model.PatrolEquipmentPageRequest;
import com.bdcourtyard.business.device.service.EquipmentTypeService;
import com.bdcourtyard.business.device.service.PatrolEquipmentService;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;
import com.bdcourtyard.common.response.Response;
import com.beite.tools.utils.AESUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author zhuxiefei
 * @date 2018/8/7 15:47
 */
@RestController
@RequestMapping(value = "/pm/web/equipmentType")
public class PatrolEquipmentController {
    @InitBinder
    public void initBinder(WebDataBinder binder){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,true));
    }
    @Autowired
    private PatrolEquipmentService patrolEquipmentService;

    @RequestMapping(value = "/getEquipmentTypeList",method = RequestMethod.GET)
    public Response<ArrayList> getEquipmentTypeList(HttpServletRequest request){
        String estateId;
        try {
            estateId = AESUtil.decrypt(request.getHeader("estateId"));
        } catch (Exception e) {

            throw new GlobalException("99999");
        }

        ArrayList<EquipmentType> list = patrolEquipmentService.getEquipmentTypeList(estateId);

        return new Response<ArrayList>(list);
    }

    @RequestMapping(value = "/insertPatrolEquipment",method = RequestMethod.POST)
    public Response<Integer> insertPatrolEquipment(@RequestBody PatrolEquipment patrolEquipment,HttpServletRequest request){
        patrolEquipment.setEquipmentId(IdUtil.getId()+"");

        String estateId;

        try {
            estateId = AESUtil.decrypt(request.getHeader("estateId"));
        } catch (Exception e) {

            throw new GlobalException("99999");
        }

        patrolEquipment.setEstateId(estateId.trim());

        return new Response<Integer>(patrolEquipmentService.insertPatrolEquipment(patrolEquipment));
    }


    @RequestMapping(value = "/updatePatrolEquipmentById",method = RequestMethod.POST)
    public Response<Integer> updatePatrolEquipmentById(@RequestBody PatrolEquipment patrolEquipment){
        return new Response<Integer>(patrolEquipmentService.updatePatrolEquipmentById(patrolEquipment));
    }

    @RequestMapping(value = "/deletePatrolEquipmentById",method = RequestMethod.POST)
    public Response<Boolean> deletePatrolEquipmentById(@RequestParam String equipmentIds){
        if (StringUtils.isEmpty(equipmentIds)){
            throw new GlobalException("DE008");
        }
        boolean b = patrolEquipmentService.deletePatrolEquipmentById(equipmentIds);
        if (!b){
            throw new GlobalException("DE008");
        }

        return new Response<Boolean>(b);
    }

    @RequestMapping(value = "/getPatroEquipmentById",method = RequestMethod.GET)
    public Response<PatrolEquipment> getPatroEquipmentById(@RequestParam String equipmentId){
        return new Response<PatrolEquipment>(patrolEquipmentService.getPatrolEquipmentById(equipmentId));
    }

    @RequestMapping(value = "/getPatrolEquipmentsForPage",method = RequestMethod.GET)
    public Response<Page<PatrolEquipment>>getPatrolEquipmentsForPage(@RequestBody PatrolEquipmentPageRequest patrolEquipmentPageRequest,
                                                               @RequestParam(value="page", defaultValue="1")  int page,
                                                               @RequestParam(value="pageSize", defaultValue="10") int pageSize,
                                                               HttpServletRequest request){
        String estateId;
        try {
            estateId = AESUtil.decrypt(request.getHeader("estateId"));
        } catch (Exception e) {

            throw new GlobalException("99999");
        }
        Pageable pageable = new PageRequest(page,pageSize);
        Page<PatrolEquipment> pageDto = patrolEquipmentService.getPatrolEquipmentForPage(patrolEquipmentPageRequest,pageable,estateId);
        return new Response<Page<PatrolEquipment>>(pageDto);
    }
























}