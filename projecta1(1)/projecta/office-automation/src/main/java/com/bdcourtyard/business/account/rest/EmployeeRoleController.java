package com.bdcourtyard.business.account.rest;

import basic.common.core.dto.PageDto;
import basic.common.core.id.IdUtil;
import com.bdcourtyard.business.account.domain.*;
import com.bdcourtyard.business.account.model.EmployeeRole;
import com.bdcourtyard.business.account.service.EmployeeRoleService;
import com.bdcourtyard.business.account.utils.EstateUtil;
import com.bdcourtyard.common.page.Page;
import com.bdcourtyard.common.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * EmployeeRoleController
 *
 * @version : Ver 1.0
 * @date : 2018-7-16
 */
@RestController
@Api(value = "EmployeeRoleController", description = "物业人员角色相关")
@RequestMapping(value = "/oa/role")
public class EmployeeRoleController {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeRoleController.class);

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @Autowired
    private EmployeeRoleService employeeRoleService;

    @ApiOperation(value = "查询权限列表", notes = "查询权限列表")
    @RequestMapping(value = "/findPrivileges", method = RequestMethod.GET)
    public Response<FindPrivilegesResp> findPrivileges(HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("======== web/role/v1/findPrivileges start ========");
        }
        Response<FindPrivilegesResp> response = new Response();
        response.setData(employeeRoleService.findPrivileges(request));
        if (LOG.isInfoEnabled()) {
            LOG.info("======== web/role/v1/findPrivileges end ========response=" + response);
        }
        return response;
    }

    @ApiOperation(value = "查询角色详情", notes = "查询角色详情")
    @RequestMapping(value = "/findRole", method = RequestMethod.GET)
    public Response<FindRoleResp> findRole(@RequestParam String roleId) {
        if (LOG.isInfoEnabled()) {
            LOG.info("======== web/role/v1/findRole start ========roleId=" + roleId);
        }
        Response<FindRoleResp> response = new Response();
        response.setData(employeeRoleService.findRole(roleId));
        if (LOG.isInfoEnabled()) {
            LOG.info("======== web/role/v1/findRole end ========response=" + response);
        }
        return response;
    }

    @ApiOperation(value = "删除角色", notes = "删除角色")
    @RequestMapping(value = "/deleteRole", method = RequestMethod.POST)
    public Response<String> deleteRole(@RequestBody DeleteRoleReq roleReq, HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("======== web/role/v1/deleteRole start ========roleReq=" + roleReq);
        }
        Response<String> response = new Response();
        employeeRoleService.deleteRole(roleReq.getRoleId());
        if (LOG.isInfoEnabled()) {
            LOG.info("======== web/role/v1/deleteRole end ========response=" + response);
        }
        return response;
    }

    @ApiOperation(value = "修改角色", notes = "修改角色")
    @RequestMapping(value = "/updateRole", method = RequestMethod.POST)
    public Response<String> updateRole(@RequestBody UpdateRoleReq updateRoleReq, HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("======== web/role/v1/updateRole start ========updateRoleReq=" + updateRoleReq);
        }
        Response<String> response = new Response();
        employeeRoleService.updateRole(updateRoleReq, EstateUtil.getEstateId(request));
        if (LOG.isInfoEnabled()) {
            LOG.info("======== web/role/v1/updateRole end ========response=" + response);
        }
        return response;
    }

    @ApiOperation(value = "新增角色", notes = "新增角色")
    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    public Response addRole(@RequestBody AddRoleReq addRoleReq, HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("======== web/role/v1/addRole start ========addRoleReq=" + addRoleReq);
        }
        Response response = new Response();
        employeeRoleService.addRole(addRoleReq, EstateUtil.getEstateId(request));
        if (LOG.isInfoEnabled()) {
            LOG.info("======== web/role/v1/addRole end ========response=" + response);
        }
        return response;
    }

    @ApiOperation(value = "分页查询角色列表", notes = "分页查询角色列表")
    @RequestMapping(value = "/findAllRole", method = RequestMethod.POST)
    public Response<Page<EmployeeRole>> findAllRole(@RequestBody FindAllRoleReq roleReq,
                                                       @RequestParam(value = "page", defaultValue = "1") int page,
                                                       @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                                       HttpServletRequest request) {
        if(LOG.isInfoEnabled()){
            LOG.info("======== web/role/v1/findAllRole start ========roleReq="+roleReq);
        }
        Pageable pageable = new PageRequest(page, pageSize);
        Page<EmployeeRole> pageDto = employeeRoleService.getEmployeeRolesForPage(roleReq.getRoleName(), EstateUtil.getEstateId(request), pageable);
        Response<Page<EmployeeRole>> response = new Response<>(pageDto);
        if(LOG.isInfoEnabled()){
            LOG.info("======== web/role/v1/findAllRole end ========response=" + response);
        }
        return response;
    }
}
