package com.bdcourtyard.business.account.rest;

import basic.common.core.dto.PageDto;
import com.bdcourtyard.business.account.domain.*;
import com.bdcourtyard.business.account.model.EmployeeAccount;
import com.bdcourtyard.business.account.service.EmployeeAccountService;
import com.bdcourtyard.business.account.utils.EstateUtil;
import com.bdcourtyard.business.dept.model.CompanyDepartment;
import com.bdcourtyard.business.dept.model.FindDeptListResp;
import com.bdcourtyard.business.dept.service.CompanyDepartmentService;
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
 * EmployeeAccountController
 *
 * @version : Ver 1.0
 * @date : 2018-7-16
 */
@RestController
@Api(value = "EmployeeAccountController", description = "物业人员账户相关")
@RequestMapping(value = "/oa/account")
public class EmployeeAccountController {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeAccountController.class);

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @Autowired
    private EmployeeAccountService employeeAccountService;

    @Autowired
    private CompanyDepartmentService companyDepartmentService;

    @ApiOperation(value = "查询所有角色", notes = "查询所有角色")
    @RequestMapping(value = "/findRoles", method = RequestMethod.GET)
    public Response<List<RoleInfo>> findRoles(HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("----------web/account/v1/findRoles------start-");
        }
        Response<List<RoleInfo>> response = new Response<>();
        response.setData(employeeAccountService.findRoles(EstateUtil.getEstateId(request)));
        if (LOG.isInfoEnabled()) {
            LOG.info("----------web/account/v1/findRoles------end-" + response);
        }
        return response;
    }

    @ApiOperation(value = "新增账号", notes = "新增账号")
    @RequestMapping(value = "/addAccount", method = RequestMethod.POST)
    public Response<AddAccountResp> addAccount(@RequestBody AddAccountReq accountReq, HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("----------web/account/v1/addAccount------start-" + accountReq);
        }
        Response<AddAccountResp> response = new Response<>();
        response.setData(employeeAccountService.addAccount(accountReq, EstateUtil.getEstateId(request)));
        if (LOG.isInfoEnabled()) {
            LOG.info("----------web/account/v1/addAccount------end-" + response);
        }
        return response;
    }

    @ApiOperation(value = "编辑账号", notes = "编辑账号")
    @RequestMapping(value = "/updateAccount", method = RequestMethod.POST)
    public Response<String> updateAccount(@RequestBody UpdateAccountReq accountReq, HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("----------web/account/v1/updateAccount------start-" + accountReq);
        }
        Response<String> response = new Response<>();
        employeeAccountService.updateAccount(accountReq, EstateUtil.getEstateId(request));
        if (LOG.isInfoEnabled()) {
            LOG.info("----------web/account/v1/updateAccount------end-" + response);
        }
        return response;
    }

    @ApiOperation(value = "查询父部门列表", notes = "查询父部门列表")
    @RequestMapping(value = "/findAccountParentDept", method = RequestMethod.GET)
    public Response<List<FindDeptListResp>> findAccountParentDept(HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("--------web/account/v1/findAccountParentDept-------start");
        }
        Response<List<FindDeptListResp>> response = new Response<>();
        response.setData(companyDepartmentService.findParentDeptList(EstateUtil.getEstateId(request)));
        if (LOG.isInfoEnabled()) {
            LOG.info("--------web/account/v1/findAccountParentDept-------end,response=" + response);
        }
        return response;
    }

    @ApiOperation(value = "查询子部门列表", notes = "查询子部门列表")
    @RequestMapping(value = "/findAccountChildrenDept", method = RequestMethod.GET)
    public Response<List<FindDeptListResp>> findAccountChildrenDept(@RequestParam String departmentId) {
        if (LOG.isInfoEnabled()) {
            LOG.info("--------web/account/v1/findAccountChildrenDept-------start" + departmentId);
        }
        Response<List<FindDeptListResp>> response = new Response<>();
        response.setData(companyDepartmentService.findChildrenDeptList(departmentId));
        if (LOG.isInfoEnabled()) {
            LOG.info("--------web/account/v1/findAccountChildrenDept-------end,response=" + response);
        }
        return response;
    }

    @ApiOperation(value = "根据部门查询人员", notes = "根据部门查询人员")
    @RequestMapping(value = "/findEmpByDept", method = RequestMethod.GET)
    public Response<List<FindEmpByDeptResp>> findEmpByDept(@RequestParam String departmentId) {
        if (LOG.isInfoEnabled()) {
            LOG.info("--------web/account/v1/findEmpByDept-------start,departmentId=" + departmentId);
        }
        Response<List<FindEmpByDeptResp>> response = new Response<>();
        response.setData(employeeAccountService.findByDepartmentId(departmentId));
        if (LOG.isInfoEnabled()) {
            LOG.info("--------web/account/v1/findEmpByDept--------end,response=" + response);
        }
        return response;
    }

    @ApiOperation(value = "查询账号详情", notes = "查询账号详情")
    @RequestMapping(value = "/findAccount", method = RequestMethod.GET)
    public Response<FindAccountResp> findAccount(@RequestParam String acctName,
                                                 HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("--------web/account/v1/findAccount-------start,acctName=" + acctName);
        }
        Response<FindAccountResp> response = new Response<>();
        response.setData(employeeAccountService.findByAcctName(acctName, EstateUtil.getEstateId(request)));
        if (LOG.isInfoEnabled()) {
            LOG.info("--------web/account/v1/findAccount--------end,response=" + response);
        }
        return response;
    }

    @ApiOperation(value = "分页搜索查询账号列表", notes = "分页搜索查询账号列表")
    @RequestMapping(value = "/findAllAccount", method = RequestMethod.POST)
    public Response<Page<FindAllAccountResp>> findAllAccount(@RequestBody FindAllAccountReq accountReq,
                                                                @RequestParam(value = "page", defaultValue = "1") int page,
                                                                @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                                                HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("--------web/account/v1/findAllAccount-------start,accountReq=" + accountReq);
        }
        Pageable pageable = new PageRequest(page, pageSize);
        Page<FindAllAccountResp> pageDto = employeeAccountService.getEmployeeAccountsForPage(accountReq, EstateUtil.getEstateId(request), pageable);
        Response<Page<FindAllAccountResp>> response = new Response<>(pageDto);
        if (LOG.isInfoEnabled()) {
            LOG.info("--------web/account/v1/findAllAccount--------end,response=" + response);
        }
        return response;
    }

    @ApiOperation(value = "重置密码", notes = "重置密码")
    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    public Response<ResetPasswordResp> resetPassword(@RequestBody ResetPwdReq pwdReq) {
        if (LOG.isInfoEnabled()){
            LOG.info("========web/account/v1/resetPassword start========pwdReq"+pwdReq);
        }
        Response<ResetPasswordResp> response = new Response<>();
        response.setData(employeeAccountService.resetPwd(pwdReq));
        if (LOG.isInfoEnabled()){
            LOG.info("========web/account/v1/resetPassword ========end,response="+response);
        }
        return response;
    }
}
