package com.bdcourtyard.business.contact.rest;

import com.bdcourtyard.business.contact.domain.*;
import com.bdcourtyard.business.contact.service.ContactService;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.response.Response;
import com.beite.tools.utils.AESUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 通讯录接口类
 * </p>
 * ClassName: ContactController <br/>
 * Author: xiayanxin  <br/>
 */
@RestController
@Api(value = "ContactController", description = "营销助手app--通讯录")
@RequestMapping("/oa/contact")
public class ContactController {

    private static final Logger LOG = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    ContactService contactService;

    @ApiOperation(value = "查询部门列表以及部门下的员工数量", notes = "查询部门列表以及部门下的员工数量")
    @RequestMapping(value = "v1/findDepartments", method = RequestMethod.POST)
    public Response<Object> findDeviceInfo(HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("========propertyApp/contact/v1/findDepartments start===========");
        }
        Response<Object> response = new Response<>();
        String estateId;
        try {
            estateId = AESUtil.decrypt(request.getHeader("estateId"));
        } catch (Exception e) {
            throw new GlobalException("99999");
        }
        List<ContactDepartment> departments = contactService.findDepartments(estateId);
        response.setData(departments);
        if (LOG.isInfoEnabled()) {
            LOG.info("========propertyApp/contact/v1/findDepartments end==========");
        }
        return response;
    }

    @ApiOperation(value = "查询部门下所有次级部门和绑定该部门的员工信息", notes = "查询部门下所有次级部门和绑定该部门的员工信息")
    @RequestMapping(value = "v1/findEmpUnderDepart", method = RequestMethod.POST)
    public Response<FindEmpUnderDepartResp> findEmpUnderDepart(@RequestBody FindEmpUnderDepartReq findEmpUnderDepartReq,
                                                               HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("========propertyApp/contact/v1/findEmpUnderDepart start===========departmentId=="
                    + findEmpUnderDepartReq.getDepartmentId());
        }
        Response<FindEmpUnderDepartResp> response = new Response<>();
        String estateId;
        try {
            estateId = AESUtil.decrypt(request.getHeader("estateId"));
        } catch (Exception e) {
            throw new GlobalException("99999");
        }
        response.setData(contactService.findEmpUnderDepart(findEmpUnderDepartReq.getDepartmentId(),
                estateId));
        if (LOG.isInfoEnabled()) {
            LOG.info("========propertyApp/contact/v1/findEmpUnderDepart end==========");
        }
        return response;
    }

//    @ApiOperation(value = "员工详情", notes = "员工详情")
//    @RequestMapping(value = "v1/findEmployee", method = RequestMethod.POST)
//    public Response<Object> findEmployee(@RequestBody FindEmployeeReq findEmployeeReq) {
//        if (LOG.isInfoEnabled()) {
//            LOG.info("========propertyApp/contact/v1/findEmployee start===========employeeId=="
//                    + findEmployeeReq.getEmployeeId());
//        }
//        Response<Object> response = new Response<>();
//        FindEmployeeResp findEmployeeResp = contactService.findEmployee(findEmployeeReq.getEmployeeId());
//        response.setData(findEmployeeResp);
//        if (LOG.isInfoEnabled()) {
//            LOG.info("========propertyApp/contact/v1/findEmployee end==========");
//        }
//        return response;
//    }

//    @ApiOperation(value = "查询该部门下所有人员信息（包括子部门）", notes = "查询该部门下所有人员信息（包括子部门）")
//    @RequestMapping(value = "v1/findEmps", method = RequestMethod.POST)
//    public Response<List<EmployeeInfo>> findEmps(@RequestBody FindEmpUnderDepartReq findEmpUnderDepartReq,
//                                                 HttpServletRequest request) {
//        if (LOG.isInfoEnabled()) {
//            LOG.info("========propertyApp/contact/v1/findEmps start===========employeeId=="
//                    + findEmpUnderDepartReq.getDepartmentId());
//        }
//        Response<List<EmployeeInfo>> response = new Response<>();
//        String estateId;
//        try {
//            estateId = AESUtil.decrypt(request.getHeader("estateId"));
//        } catch (Exception e) {
//            throw new GlobalException("99999");
//        }
//        response.setData(contactService.findEmps(findEmpUnderDepartReq.getDepartmentId(), estateId));
//        if (LOG.isInfoEnabled()) {
//            LOG.info("========propertyApp/contact/v1/findEmps end==========");
//        }
//        return response;
//    }
}
