package com.bdcourtyard.business.dept.rest;

import com.bdcourtyard.business.account.utils.EstateUtil;
import com.bdcourtyard.business.dept.model.*;
import com.bdcourtyard.business.dept.service.CompanyDepartmentService;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * CompanyDepartmentController
 *
 * @version : Ver 1.0
 * @date : 2018-7-13
 */
@RestController
@Api(value = "CompanyDepartmentController", description = "企业部门相关")
@RequestMapping(value = "/oa/deptMgr")
public class CompanyDepartmentController {

    private static final Logger LOG = LoggerFactory.getLogger(CompanyDepartmentController.class);

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @Autowired
    private CompanyDepartmentService companyDepartmentService;

    @ApiOperation(value = "新增企业部门", notes = "新增企业部门")
    @RequestMapping(value = "/addDept", method = RequestMethod.POST)
    public Response<CompanyDepartment> addDept(@RequestBody DeptReq deptReq, HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("--------web/deptMgr/v1/addDept-------start,deptReq=" + deptReq);
        }
        Response<CompanyDepartment> response = new Response<>();
        response.setData(companyDepartmentService.addDept(deptReq, EstateUtil.getEstateId(request)));
        if (LOG.isInfoEnabled()) {
            LOG.info("--------web/charges/v1/addDept--------end,response=" + response);
        }
        return response;
    }

    @ApiOperation(value = "修改企业部门", notes = "修改企业部门")
    @RequestMapping(value = "/updateDept", method = RequestMethod.POST)
    public Response<String> updateDept(@RequestBody UpdateDeptReq deptReq, HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("--------web/deptMgr/v1/updateDept-------start,deptReq=" + deptReq);
        }
        Response<String> response = new Response<String>();
        companyDepartmentService.updateDept(deptReq, EstateUtil.getEstateId(request));
        if (LOG.isInfoEnabled()) {
            LOG.info("--------web/deptMgr/v1/updateDept--------end,response=" + response);
        }
        return response;
    }

    @ApiOperation(value = "删除企业部门", notes = "删除企业部门")
    @RequestMapping(value = "/deleteDept", method = RequestMethod.POST)
    public Response<String> deleteDept(@RequestBody DeleteDeptReq deptReq, HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("--------web/deptMgr/v1/deleteDept-------start,deptReq=" + deptReq);
        }
        Response<String> response = new Response<String>();
        companyDepartmentService.deleteDept(deptReq, EstateUtil.getEstateId(request));
        if (LOG.isInfoEnabled()) {
            LOG.info("--------web/deptMgr/v1/deleteDept--------end,response=" + response);
        }
        return response;
    }

    @ApiOperation(value = "查询部门详情", notes = "查询部门详情")
    @RequestMapping(value = "/findDeptDetail", method = RequestMethod.GET)
    public Response<CompanyDepartment> findDeptDetail(@RequestParam String departmentId) {
        if (LOG.isInfoEnabled()) {
            LOG.info("--------web/deptMgr/v1/findDeptDetail-------start,departmentId=" + departmentId);
        }
        Response<CompanyDepartment> response = new Response<>();
        CompanyDepartment deptDetail = companyDepartmentService.findDeptDetail(departmentId);
        if (null == deptDetail) {
            throw new GlobalException("D0006");
        } else {
            response.setData(deptDetail);
        }
        if (LOG.isInfoEnabled()) {
            LOG.info("--------web/deptMgr/v1/findDeptDetail--------end,response=" + response);
        }
        return response;
    }

    @ApiOperation(value = "查询父部门列表", notes = "查询父部门列表")
    @RequestMapping(value = "/findParentDeptList", method = RequestMethod.GET)
    public Response<List<FindDeptListResp>> findParentDeptList(HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("--------web/deptMgr/v1/findParentDeptList-------start");
        }
        Response<List<FindDeptListResp>> response = new Response<>();
        response.setData(companyDepartmentService.findParentDeptList(EstateUtil.getEstateId(request)));
        if (LOG.isInfoEnabled()) {
            LOG.info("--------web/deptMgr/v1/findParentDeptList-------end,response=" + response);
        }
        return response;
    }

    @ApiOperation(value = "查询子部门列表", notes = "查询子部门列表")
    @RequestMapping(value = "/findChildrenDeptList", method = RequestMethod.GET)
    public Response<List<FindDeptListResp>> findChildrenDeptList(@RequestParam String departmentId) {
        if (LOG.isInfoEnabled()) {
            LOG.info("--------web/deptMgr/v1/findChildrenDeptList-------start" + departmentId);
        }
        Response<List<FindDeptListResp>> response = new Response<>();
        response.setData(companyDepartmentService.findChildrenDeptList(departmentId));
        if (LOG.isInfoEnabled()) {
            LOG.info("--------web/deptMgr/v1/findChildrenDeptList-------end,response=" + response);
        }
        return response;
    }
}
