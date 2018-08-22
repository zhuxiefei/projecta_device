package com.bdcourtyard.business.account.rest;

import com.bdcourtyard.business.account.constant.EmployeeConstant;
import com.bdcourtyard.business.account.domain.*;
import com.bdcourtyard.business.account.model.CompanyEmployee;
import com.bdcourtyard.business.account.service.CompanyEmployeeService;
import com.bdcourtyard.business.account.utils.EstateUtil;
import com.bdcourtyard.business.account.utils.Validate;
import com.bdcourtyard.business.dept.model.FindDeptListResp;
import com.bdcourtyard.business.dept.service.CompanyDepartmentService;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;
import com.bdcourtyard.common.response.Response;
import com.bdcourtyard.common.utils.StringUtil;
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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * CompanyEmployeeController
 *
 * @version : Ver 1.0
 * @date : 2018-7-16
 */
@RestController
@Api(value = "CompanyEmployeeController", description = "企业员工相关")
@RequestMapping(value = "/oa/employee")
public class CompanyEmployeeController {

    private static final Logger LOG = LoggerFactory.getLogger(CompanyEmployeeController.class);

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @Autowired
    private CompanyEmployeeService companyEmployeeService;

    @Autowired
    private CompanyDepartmentService companyDepartmentService;

    @ApiOperation(value = "新增企业员工", notes = "新增企业员工")
    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public Response<String> addEmployee(@RequestBody CompanyEmployee employee,
                                        HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("----------web/employee/v1/addEmployee------start-" + employee);
        }
        Response<String> response = new Response<>();
        //字段校验
        validateEmployee(employee);
        //保存
        companyEmployeeService.addEmployee(employee, EstateUtil.getEstateId(request));
        if (LOG.isInfoEnabled()) {
            LOG.info("----------web/employee/v1/addEmployee------end-" + response);
        }
        return response;
    }

    @ApiOperation(value = "分页查询人员档案", notes = "分页查询人员档案")
    @RequestMapping(value = "/findAllEmployee", method = RequestMethod.POST)
    public Response<Page<FindAllEmpResp>> findAllEmployee(@RequestBody FindEmpListReq empListReq,
                                                          @RequestParam(value = "page", defaultValue = "1") int page,
                                                          @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                                          HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("----------web/employee/v1/findAllEmployee------start-" + empListReq);
        }
        Pageable pageable = new PageRequest(page , pageSize);
        Page<FindAllEmpResp> pageDto = companyEmployeeService.getCompanyEmployeesForPage(empListReq, EstateUtil.getEstateId(request), pageable);
        Response<Page<FindAllEmpResp>> response = new Response<>(pageDto);
        if (LOG.isInfoEnabled()) {
            LOG.info("----------web/employee/v1/findAllEmployee------end-" + response);
        }
        return response;
    }

    @ApiOperation(value = "删除人员档案", notes = "删除人员档案")
    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
    public Response<String> deleteEmployee(@RequestBody DeleteEmpReq empReq) {
        if (LOG.isInfoEnabled()) {
            LOG.info("----------web/employee/v1/deleteEmployee------start---empIds:" + empReq.getEmpIds());
        }
        Response<String> response = new Response<>();
        companyEmployeeService.deleteEmps(empReq.getEmpIds());
        if (LOG.isInfoEnabled()) {
            LOG.info("----------web/employee/v1/deleteEmployee------end---:" + response);
        }
        return response;
    }

    @ApiOperation(value = "查看人员档案详情", notes = "查看人员档案详情")
    @RequestMapping(value = "/findEmployee", method = RequestMethod.GET)
    public Response<FindEmpResp> findEmployee(@RequestParam String employeeId) {
        if (LOG.isInfoEnabled()) {
            LOG.info("----------web/employee/v1/findEmployee------start---employeeId:" + employeeId);
        }
        Response<FindEmpResp> response = new Response<>();
        //查询详情
        response.setData(companyEmployeeService.findEmployee(employeeId));
        if (LOG.isInfoEnabled()) {
            LOG.info("----------web/employee/v1/findEmployee------end---:" + response);
        }
        return response;
    }

    @ApiOperation(value = "更新人员档案", notes = "更新人员档案")
    @RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
    public Response<String> updateEmployee(@RequestBody CompanyEmployee employee,
                                           HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("----------web/employee/v1/updateEmployee------start---:" + employee);
        }
        Response<String> response = new Response<>();
        //字段校验
        validateEmployee(employee);
        //修改
        companyEmployeeService.updateEmployee(employee, EstateUtil.getEstateId(request));
        if (LOG.isInfoEnabled()) {
            LOG.info("----------web/employee/v1/updateEmployee------end---:" + response);
        }
        return response;
    }

    @ApiOperation(value = "导出人员档案", notes = "导出人员档案")
    @RequestMapping(value = "/exportEmp", method = RequestMethod.POST)
    public Response<List<FindEmpResp>> exportEmp(@RequestBody ExportEmpReq employeeReq, HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("----------web/employee/v1/exportEmp------start---" + employeeReq);
        }
        Response<List<FindEmpResp>> response = new Response<>();
        response.setData(companyEmployeeService.exportEmp(employeeReq,EstateUtil.getEstateId(request)));
        if (LOG.isInfoEnabled()) {
            LOG.info("----------web/employee/v1/exportEmp------end---" + response);
        }
        return response;
    }


    @ApiOperation(value = "查询父部门列表", notes = "查询父部门列表")
    @RequestMapping(value = "/findEmpParentDept", method = RequestMethod.GET)
    public Response<List<FindDeptListResp>> findEmpParentDept(HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("--------web/employee/v1/findEmpParentDept-------start");
        }
        Response<List<FindDeptListResp>> response = new Response<>();
        response.setData(companyDepartmentService.findParentDeptList(EstateUtil.getEstateId(request)));
        if (LOG.isInfoEnabled()) {
            LOG.info("--------web/employee/v1/findEmpParentDept-------end,response=" + response);
        }
        return response;
    }

    @ApiOperation(value = "查询子部门列表", notes = "查询子部门列表")
    @RequestMapping(value = "/findEmpChildrenDept", method = RequestMethod.GET)
    public Response<List<FindDeptListResp>> findEmpChildrenDept(@RequestParam String departmentId) {
        if (LOG.isInfoEnabled()) {
            LOG.info("--------web/employee/v1/findEmpChildrenDept-------start" + departmentId);
        }
        Response<List<FindDeptListResp>> response = new Response<>();
        response.setData(companyDepartmentService.findChildrenDeptList(departmentId));
        if (LOG.isInfoEnabled()) {
            LOG.info("--------web/employee/v1/findEmpChildrenDept-------end,response=" + response);
        }
        return response;
    }

    @ApiOperation(value = "上传头像", notes = "上传头像")
    @RequestMapping(value = "/uploadPhoto", method = RequestMethod.POST)
    public Response<UploadPicResp> uploadPhoto(MultipartFile picture) {
        if (LOG.isInfoEnabled()) {
            LOG.info("--------web/employee/v1/uploadPhoto-------start,picture=" + picture);
        }
        Response<UploadPicResp> response = new Response<>();
        response.setData(companyEmployeeService.uploadPic(picture));
        if (LOG.isInfoEnabled()) {
            LOG.info("--------web/employee/v1/uploadPhoto-------end,response=" + response);
        }
        return response;
    }

    /**
     * <p>
     * 人员档案参数校验
     * </p>
     * Author: xiayxnin <br/>
     * Date: 2018/7/16
     */
    private void validateEmployee(CompanyEmployee employee) {
        //验证人员编号,去空格
        if (StringUtil.isBlank(employee.getEmployeeNo())) {
            throw new GlobalException("E0001");
        } else if (!Validate.isNum(employee.getEmployeeNo(), EmployeeConstant.EMP_NO_MAX)) {
            throw new GlobalException("E0002");
        } else {
            //前后去空格
            employee.setEmployeeNo(employee.getEmployeeNo().trim());
        }

        //验证姓名
        if (StringUtil.isBlank(employee.getEmployeeName())) {
            throw new GlobalException("E0003");
        } else if (!Validate.isCommonString(employee.getEmployeeName(), EmployeeConstant.EMP_NAME_LENGTH)) {
            throw new GlobalException("E0004");
        } else {
            //前后去空格
            employee.setEmployeeName(employee.getEmployeeName().trim());
        }

        //验证性别
        if (employee.getGender() == null) {
            throw new GlobalException("E0005");
        }

        //验证出生日期
        if (employee.getBirthday() == null) {
            throw new GlobalException("E0006");
        }

        //验证民族
        if (StringUtil.isBlank(employee.getEthnic())) {
            throw new GlobalException("E0007");
        } else if (!Validate.isChinese(employee.getEthnic(), EmployeeConstant.EMP_ETHNIC_LENGTH)) {
            throw new GlobalException("E0008");
        } else {
            //前后去空格
            employee.setEthnic(employee.getEthnic().trim());
        }

        //验证婚姻状态
        if (employee.getMaritalStatus() == null) {
            throw new GlobalException("E0009");
        }

        //验证政治面貌
        if (employee.getPoliticalStatus() == null) {
            throw new GlobalException("E0010");
        }

        //验证学历
        if (employee.getHighestEducation() == null) {
            throw new GlobalException("E0011");
        }

        //验证身份证
        if (StringUtil.isBlank(employee.getIdNum())) {
            throw new GlobalException("E0012");
        } else if (!Validate.isApplicantIdNum(employee.getIdNum())) {
            throw new GlobalException("E0013");
        } else {
            //前后去空格
            employee.setIdNum(employee.getIdNum().trim());
        }

        //验证毕业院校
        if (!StringUtil.isBlank(employee.getGraduatedFrom())) {
            if (!Validate.isCommonString(employee.getGraduatedFrom(), EmployeeConstant.GRADUATE_LENGTH)) {
                throw new GlobalException("E0014");
            }
            //前后去空格
            employee.setGraduatedFrom(employee.getGraduatedFrom());
        }

        //验证毕业时间
        //毕业时间不可小于出生日期
        if (employee.getGraduatedDate() != null) {
            if (employee.getGraduatedDate().getTime() < employee.getBirthday().getTime()) {
                throw new GlobalException("E0016");
            }
        }

        //验证专业
        if (!StringUtil.isBlank(employee.getMajor())) {
            if (!Validate.isCommonString(employee.getMajor(), EmployeeConstant.MAJOR_LENGTH)) {
                throw new GlobalException("E0017");
            }
            //前后去空格
            employee.setMajor(employee.getMajor().trim());
        }

        //验证所属部门
        if (StringUtil.isBlank(employee.getDepartmentId())) {
            throw new GlobalException("E0018");
        }

        //验证雇佣性质
        if (employee.getEmployType() == null) {
            throw new GlobalException("E0020");
        }

        //验证参加工作时间
        if (employee.getWorkDate() == null) {
            throw new GlobalException("E0021");
        }

        //验证进本单位时间
        if (employee.getOnBoardDate() == null) {
            throw new GlobalException("E0022");
        }

        //进本单位时间大于等于工作时间
        if (employee.getOnBoardDate().getTime() < employee.getWorkDate().getTime()) {
            throw new GlobalException("E0023");
        }

        //出生日期大于等于参加工作时间
        if (employee.getBirthday().getTime() > employee.getWorkDate().getTime()) {
            throw new GlobalException("E0048");
        }

        //验证家庭地址
        if (StringUtil.isBlank(employee.getAddress())) {
            throw new GlobalException("E0024");
        } else if (!Validate.isCommonString(employee.getAddress(), EmployeeConstant.ADRESS_LENGTH)) {
            throw new GlobalException("E0025");
        } else {
            //前后去空格
            employee.setAddress(employee.getAddress());
        }

        //验证籍贯
        if (StringUtil.isBlank(employee.getResidency())) {
            throw new GlobalException("E0026");
        } else if (!Validate.isCommonString(employee.getResidency(), EmployeeConstant.RESIDENCY_LENGTH)) {
            throw new GlobalException("E0027");
        } else {
            //前后去空格
            employee.setResidency(employee.getResidency());
        }

        //验证联系方式
        if (StringUtil.isBlank(employee.getPhoneNum())) {
            throw new GlobalException("E0028");
        } else if (!Validate.isMobile(employee.getPhoneNum())) {
            throw new GlobalException("E0029");
        } else {
            //前后去空格
            employee.setPhoneNum(employee.getPhoneNum().trim());
        }

        //验证邮箱
        if (!StringUtil.isBlank(employee.getEmail())) {
            if (!Validate.isEmail(employee.getEmail())) {
                throw new GlobalException("E0030");
            } else {
                //前后去空格
                employee.setEmail(employee.getEmail().trim());
            }
        }

        //验证是否转正,转正日期
        if (employee.getIsRegular() == null) {
            throw new GlobalException("E0031");
        } else if (employee.getIsRegular() == EmployeeConstant.IS_REGULAR && employee.getRegularDate() == null) {
            throw new GlobalException("E0032");
        }

        //验证身高
        if (employee.getHeight() != null) {
            if (!Validate.validateHW(employee.getHeight())) {
                throw new GlobalException("E0033");
            }
        }

        //验证体重
        if (employee.getWeight() != null) {
            if (!Validate.validateHW(employee.getWeight())) {
                throw new GlobalException("E0034");
            }
        }

        //验证紧急联系人
        if (StringUtil.isBlank(employee.getEmergencyContactPerson())) {
            throw new GlobalException("E0035");
        } else if (!Validate.isCommonString(employee.getEmergencyContactPerson(), EmployeeConstant.EMERGENCY_PERSON_LENGTH)) {
            throw new GlobalException("E0036");
        } else {
            //前后去空格
            employee.setEmergencyContactPerson(employee.getEmergencyContactPerson().trim());
        }

        //验证紧急联系人号码
        if (StringUtil.isBlank(employee.getEmergencyContactNumber())) {
            throw new GlobalException("E0037");
        } else if (!Validate.isMobile(employee.getEmergencyContactNumber())) {
            throw new GlobalException("E0038");
        } else {
            //前后去空格
            employee.setEmergencyContactNumber(employee.getEmergencyContactNumber().trim());
        }
    }
}
