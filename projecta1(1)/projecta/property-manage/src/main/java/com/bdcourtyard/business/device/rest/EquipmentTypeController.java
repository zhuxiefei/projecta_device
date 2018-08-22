package com.bdcourtyard.business.device.rest;

import basic.common.core.id.IdUtil;
import com.bdcourtyard.business.device.model.EquipmentType;
import com.bdcourtyard.business.device.model.EquipmentTypePageParam;
import com.bdcourtyard.business.device.service.EquipmentTypeService;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;
import com.bdcourtyard.common.response.Response;
import com.beite.tools.utils.AESUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
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

/**
 * @author zhuxiefei
 * @date 2018/8/6 19:40
 */

@RestController
@RequestMapping(value = "/pm/web/equipmentType")
public class EquipmentTypeController {
    private static final Logger LOG = LoggerFactory.getLogger(EquipmentTypeController.class);
    @InitBinder
    public void initBinder(WebDataBinder binder){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,true));
    }
    @Autowired
    private EquipmentTypeService equipmentTypeService;

    @RequestMapping(value = "/inserEquipmentType",method = RequestMethod.POST)
    public Response<Integer> inserEquipmentType(HttpServletRequest request,@RequestBody EquipmentType equipmentType){
        if (LOG.isInfoEnabled()){
            LOG.info("----------/pm/web/equipmentType/insertEquipmentType------start-equipmentType:" + equipmentType);
        }
        equipmentType.setTypeId(IdUtil.getId()+"");
        String estateId;
        try {
            estateId = AESUtil.decrypt(request.getHeader("estateId"));
        } catch (Exception e) {
            throw new GlobalException("99999");

        }

        if (estateId==null||"".equals(estateId.trim())){
            throw new GlobalException("DE001");
        }else {
            equipmentType.setEstateId(estateId);

        }

        int i = equipmentTypeService.insertEquipmentType(equipmentType);
        Response<Integer> response = new Response<>(i);
        if (LOG.isInfoEnabled()) {
            LOG.info("----------/pm/web/equipmentType/insertEquipmentType------end-response:" + response);
        }
        return response;

    }

    @RequestMapping(value = "/updateEquipmentTypeById",method = RequestMethod.POST)
    public Response<Integer> updateEquipmentTypeById(@RequestBody EquipmentType equipmentType){
        return new Response<Integer>(equipmentTypeService.updateEquipmentTypeById(equipmentType));
    }
    @RequestMapping(value = "/deleteEquipmentTypeById",method = RequestMethod.GET)
    public Response<Boolean> deleteEquipmentTypeById(@RequestParam String typeIds){

        equipmentTypeService.deleteEquiomentTypeById(typeIds);
        return new Response();
    }

    @RequestMapping(value = "/getEquipmentTypeById",method = RequestMethod.GET)
    public Response<EquipmentType> getEquipmentTypeById(@RequestParam String typeId){
        if (typeId == null||"".equals(typeId.trim())){
            throw new GlobalException("DE007");
        }
        return new Response<EquipmentType>(equipmentTypeService.getEquipmentTypeById(typeId));
    }

    @RequestMapping(value = "/getEquipmentTypesForPage",method = RequestMethod.POST)
    public Response<Page<EquipmentType>> getEquipmentTypesForPage(HttpServletRequest request, @RequestBody EquipmentTypePageParam param,
                                                                  @RequestParam(value="page", defaultValue="1")  int page,
                                                                  @RequestParam(value="pageSize", defaultValue="10") int pageSize){

        String estateId;
        try {
            estateId = AESUtil.decrypt(request.getHeader("estateId"));
        } catch (Exception e) {
            throw new GlobalException("99999");

        }
        Pageable pageable = new PageRequest(page,pageSize);
        Page<EquipmentType> pageDto = equipmentTypeService.getEquipmentTypesForPage(estateId,pageable,param);
        return new Response<Page<EquipmentType>>(pageDto);
    }

}