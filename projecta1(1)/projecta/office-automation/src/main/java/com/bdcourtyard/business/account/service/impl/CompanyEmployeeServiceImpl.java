package com.bdcourtyard.business.account.service.impl;

import basic.common.core.dto.PageDto;
import basic.common.core.id.IdUtil;
import com.bdcourtyard.business.account.constant.EmployeeConstant;
import com.bdcourtyard.business.account.dao.CompanyEmployeeDao;
import com.bdcourtyard.business.account.dao.EmployeeAccountDao;
import com.bdcourtyard.business.account.dao.EmployeeAccountRelaDao;
import com.bdcourtyard.business.account.domain.*;
import com.bdcourtyard.business.account.model.CompanyEmployee;
import com.bdcourtyard.business.account.model.EmployeeAccountRela;
import com.bdcourtyard.business.account.service.CompanyEmployeeService;
import com.bdcourtyard.business.account.utils.Validate;
import com.bdcourtyard.business.common.dao.SystemFileDao;
import com.bdcourtyard.business.common.model.SystemFile;
import com.bdcourtyard.business.dept.dao.CompanyCompanyDao;
import com.bdcourtyard.business.dept.dao.CompanyDepartmentDao;
import com.bdcourtyard.business.dept.model.CompanyCompany;
import com.bdcourtyard.business.dept.model.CompanyDepartment;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;
import com.bdcourtyard.common.utils.PropertiesUtil;
import com.bdcourtyard.common.utils.StringUtil;
import com.beite.tools.redis.RedisManager;
import com.beite.tools.utils.AESUtil;
import com.beite.tools.utils.FileUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * CompanyEmployeeServiceImpl
 *
 * @version : Ver 1.0
 * @date : 2018-7-16
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CompanyEmployeeServiceImpl implements CompanyEmployeeService {

    @Autowired
    private CompanyEmployeeDao companyEmployeeDao;

    @Autowired
    private SystemFileDao fileDao;

    @Autowired
    private CompanyDepartmentDao departmentDao;

    @Autowired
    private CompanyCompanyDao companyDao;

    @Autowired
    private EmployeeAccountRelaDao employeeAccountRelaDao;

    @Autowired
    private EmployeeAccountDao employeeAccountDao;

    public int insertCompanyEmployee(CompanyEmployee companyEmployee) {
        return companyEmployeeDao.insertCompanyEmployee(companyEmployee);
    }

    public int insertCompanyEmployeeBatch(List<CompanyEmployee> list) {
        return companyEmployeeDao.insertCompanyEmployeeBatch(list);
    }

    public int updateCompanyEmployeeById(CompanyEmployee companyEmployee) {
        return companyEmployeeDao.updateCompanyEmployeeById(companyEmployee);
    }

    public int deleteCompanyEmployeeById(String employeeId) {
        return companyEmployeeDao.deleteCompanyEmployeeById(employeeId);
    }

    public CompanyEmployee getCompanyEmployeeById(String employeeId) {
        return companyEmployeeDao.getCompanyEmployeeById(employeeId);
    }

    public Page<FindAllEmpResp> getCompanyEmployeesForPage(FindEmpListReq findEmpListReq, String estateId, Pageable pageable) {
        //校验入参
        validateFindEmpListReq(findEmpListReq);
        String depId = null;
        Integer depth = null;
        if (!StringUtil.isBlank(findEmpListReq.getDepartmentId())) {
            CompanyDepartment department = departmentDao.getCompanyDepartmentById(findEmpListReq.getDepartmentId());
            if (department.getDepth() == 1) {
                depId = department.getDepId().substring(0, 4);
            } else if (department.getDepth() == 2) {
                depId = department.getDepId().substring(0, 8);
            } else if (department.getDepth() == 3) {
                depId = department.getDepId().substring(0, 12);
            } else if (department.getDepth() == 4) {
                depId = department.getDepId().substring(0, 16);
            } else if (department.getDepth() == 5) {
                depId = department.getDepId().substring(0, 20);
            }
            depth = department.getDepth();
        }
        //封装入参对象
        FindAllEmpDaoReq empReq = new FindAllEmpDaoReq(findEmpListReq.getDepartmentId(), findEmpListReq.getEmployeeNo(),
                findEmpListReq.getEmployeeName(), findEmpListReq.getPhone(), findEmpListReq.getEmpType(),
                depId, depth, estateId);
        //分页
        long count = companyEmployeeDao.getCompanyEmployees(empReq).size();
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<FindAllEmpResp> companyEmployees = companyEmployeeDao.getCompanyEmployees(empReq);

        Page<FindAllEmpResp> pageDto = new Page<>();
        pageDto.setPage(pageable.getPageNumber());
        pageDto.setPageSize(pageable.getPageSize());

        if (companyEmployees != null) {
            pageDto.setRows(companyEmployees);
            pageDto.setTotal(count);
        } else {
            pageDto.setRows(new ArrayList<FindAllEmpResp>());
            pageDto.setTotal(0l);
        }
        return pageDto;
    }

    @Override
    public UploadPicResp uploadPic(MultipartFile picture) {
        UploadPicResp resp = new UploadPicResp();
        String imagname = picture.getOriginalFilename();
        //获取文件的类型
        String picType = imagname.substring(imagname.lastIndexOf(".") + 1);
        //图片名长度验证
        if (imagname.length() > EmployeeConstant.IMAGE_NAME_LENGTH) {
            throw new GlobalException("E0041");
        } else if (!Validate.isImage(picType)) {
            //图片类型错误
            throw new GlobalException("E0040");
        } else if (picture.getSize() > EmployeeConstant.IMAGE_SIZE_MAX) {
            //图片过大
            throw new GlobalException("E0039");
        }
        //加密
        try {
            BASE64Encoder encoder = new BASE64Encoder();
            String content = "data:image/jpg;base64," + encoder.encode(picture.getBytes());
            String name = FileUtil.uploadFile("/employeeHead/" + UUID.randomUUID() + ".txt", content);
            String fileId = IdUtil.getLongId()+"";
            SystemFile file = new SystemFile();
            file.setCreateTime(new Date(System.currentTimeMillis()));
            file.setFileName(imagname);
            file.setFileUrl(name);
            file.setFileId(fileId);
            file.setFileType(EmployeeConstant.FILE_TYPE_PIC);
            fileDao.insertSystemFile(file);
            resp.setFile(content);
            resp.setPhotoId(fileId);
            return resp;
        } catch (Exception e) {
            throw new GlobalException("99999");
        }
    }

    private void validateFindEmpListReq(FindEmpListReq empListReq) {
        //判断部门是否被删除
        if (!StringUtil.isBlank(empListReq.getDepartmentId())
                && null == departmentDao.getCompanyDepartmentById(empListReq.getDepartmentId())) {
            throw new GlobalException("E0045");
        }
        //前后去空格
        if (!StringUtil.isEmpty(empListReq.getEmployeeNo())) {
            empListReq.setEmployeeNo(empListReq.getEmployeeNo().trim());
        }
        if (!StringUtil.isEmpty(empListReq.getEmployeeName())) {
            empListReq.setEmployeeName(empListReq.getEmployeeName().trim());
        }
        if (!StringUtil.isEmpty(empListReq.getPhone())) {
            empListReq.setPhone(empListReq.getPhone().trim());
        }
        //验证编号格式
        if (!StringUtil.isBlank(empListReq.getEmployeeNo())
                && !Validate.isSearchNum(empListReq.getEmployeeNo().trim(), EmployeeConstant.EMP_NO_MAX)) {
            throw new GlobalException("E0002");
        }
        if (!StringUtil.isBlank(empListReq.getEmployeeName())
                && !Validate.isCommonString(empListReq.getEmployeeName().trim(), EmployeeConstant.EMP_NAME_LENGTH)) {
            throw new GlobalException("E0004");
        }
        if (!StringUtil.isBlank(empListReq.getPhone())) {
            String phone = empListReq.getPhone().trim();
            if (phone.length() < EmployeeConstant.PHONE_MIN_LENGTH
                    || phone.length() > EmployeeConstant.PHONE_MAX_LENGTH || !Validate.isSearchNum(phone)) {
                throw new GlobalException("E0029");
            }
        }
        if (!StringUtil.isBlank(empListReq.getEmployeeName()) && empListReq.getEmployeeName().contains("_")) {
            empListReq.setEmployeeName(empListReq.getEmployeeName().replace("_", "\\_"));
        }
    }

    @Override
    public void addEmployee(CompanyEmployee employee, String estateId) {
        //判断人员手机号码是否重复
        List<CompanyEmployee> employees = companyEmployeeDao.selectByPhone(employee.getPhoneNum().trim(), estateId);
        if (employees != null && employees.size() > 0) {
            throw new GlobalException("E0047");
        } else {
            CompanyEmployee testEmployee = companyEmployeeDao.selectByEmployeeNum(employee.getEmployeeNo(), estateId);
            if (testEmployee != null) {
                throw new GlobalException("E0042");
            }
            //验证部门是否存在
            CompanyDepartment department = departmentDao.getCompanyDepartmentById(employee.getDepartmentId());
            if (department == null) {
                throw new GlobalException("E0045");
            }
            employee.setCreateTime(new Date(System.currentTimeMillis()));
            employee.setUpdateTime(new Date(System.currentTimeMillis()));
            //公司名称
            CompanyCompany company = companyDao.findOne();
            if (company != null) {
                employee.setCompanyId(company.getCompanyId());
            }
            //是否启用帐号激活 默认0
            employee.setIsEnableAccount(EmployeeConstant.NOT_ENABLEACCOUNT);
            employee.setEstateId(estateId);
            employee.setEmployeeId(IdUtil.getId() + "");
            companyEmployeeDao.insertCompanyEmployee(employee);
        }
    }

    @Override
    public void deleteEmps(String empIds) {
        String[] ids = empIds.split(",");
        List<String> fileIds = new ArrayList<>();
        List<String> relaEmpIdList = new ArrayList<>();
        List<String> acctNameList = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            CompanyEmployee emp = companyEmployeeDao.getCompanyEmployeeById(ids[i]);
            if (emp != null) {
                //删除照片
                if (!StringUtil.isBlank(emp.getPhoto())) {
                    SystemFile file = fileDao.getSystemFileById(emp.getPhoto());
                    if (file != null) {
                        //删除物理路径
                        FileUtil.deletefile(PropertiesUtil.getProperty("privacy.file.dir") + file.getFileUrl());
                        fileIds.add(file.getFileId());
                    }
                }
                EmployeeAccountRela empAccountRela = employeeAccountRelaDao.getEmployeeAccountRelaByEmpId(ids[i]);
                if (null != empAccountRela) {
                    //删除关系表
                    relaEmpIdList.add(ids[i]);
                    //判断人员账号是否需要被删除
                    List<EmployeeAccountRela> relaList = employeeAccountRelaDao.getEmployeeAccountRelaByAcctName(empAccountRela.getAcctName());
                    if (null != relaList && relaList.size() == 1) {
                        acctNameList.add(empAccountRela.getAcctName());
                    }
                    // 删除token，用户下线
                    try {
                        RedisManager.delete(AESUtil.encrypt(empAccountRela.getAcctName()));
                    } catch (Exception e) {
                        throw new GlobalException("99999");
                    }
                }
            }
        }
        //删除文件
        if (fileIds.size() > 0) {
            fileDao.deleteByFileIds(fileIds);
        }
        //删除人员档案
        companyEmployeeDao.deleteByEmpIds(ids);
        //删除人员档案关系
        if (relaEmpIdList.size() > 0) {
            employeeAccountRelaDao.deleteByEmpIds(relaEmpIdList);
        }
        //删除人员账号表
        if (acctNameList.size() > 0) {
            employeeAccountDao.deleteAccounts(acctNameList);
        }
    }

    @Override
    public FindEmpResp findEmployee(String employeeId) {
        FindEmpResp resp = companyEmployeeDao.selectByEmpId(employeeId);
        if (null == resp) {
            throw new GlobalException("E0045");
        }
        if (resp != null && !StringUtil.isBlank(resp.getPhoto())) {
            SystemFile file = fileDao.getSystemFileById(resp.getPhoto());
            if (file != null) {
                try {
                    resp.setPhoto(FileUtil.readTxt(file.getFileUrl()));
                } catch (Exception e) {
                    throw new GlobalException("99999");
                }
            }
        }
        return resp;
    }

    @Override
    public void updateEmployee(CompanyEmployee employee, String estateId) {
        //定义该员工原手机号
        String oldPhone = null;
        //判断人员是否存在
        CompanyEmployee emp = companyEmployeeDao.getCompanyEmployeeById(employee.getEmployeeId());
        if (emp == null) {
            throw new GlobalException("E0044");
        } else {
            //判断人员手机号是否重复
            if (!emp.getPhoneNum().equals(employee.getPhoneNum())) {
                List<CompanyEmployee> empList = companyEmployeeDao.selectByPhone(employee.getPhoneNum(), estateId);
                if (empList != null && empList.size() > 0) {
                    throw new GlobalException("E0047");
                } else {
                    oldPhone = emp.getPhoneNum();
                }
            }
        }
        //验证部门和职位是否存在
        CompanyDepartment department = departmentDao.getCompanyDepartmentById(employee.getDepartmentId());
        if (department == null) {
            throw new GlobalException("E0045");
        }
        employee.setUpdateTime(new Date(System.currentTimeMillis()));
        companyEmployeeDao.updateByPrimaryKeySelective(employee);
    }

    @Override
    public List<FindEmpResp> exportEmp(ExportEmpReq empReq, String estateId) {
        List<FindEmpResp> resps = null;
        //判断员工ID是否为空
        if (!StringUtil.isBlank(empReq.getEmployeeId())) {
            String[] empIds = empReq.getEmployeeId().split(",");
            resps = companyEmployeeDao.selectByEmpIds(empIds);
        } else {
            //封装入参，进行参数校验
            FindEmpListReq empListReq = new FindEmpListReq(empReq.getDepartmentId(),empReq.getEmployeeNo(),
                    empReq.getEmployeeName(),empReq.getPhone(),empReq.getEmpType());
            validateFindEmpListReq(empListReq);
            String depId = null;
            Integer depth = 0;
            if (!StringUtil.isBlank(empListReq.getDepartmentId())) {
                CompanyDepartment department = departmentDao.getCompanyDepartmentById(empListReq.getDepartmentId());
                if (department.getDepth() == 1) {
                    depId = department.getDepId().substring(0, 4);
                } else if (department.getDepth() == 2) {
                    depId = department.getDepId().substring(0, 8);
                } else if (department.getDepth() == 3) {
                    depId = department.getDepId().substring(0, 12);
                } else if (department.getDepth() == 4) {
                    depId = department.getDepId().substring(0, 16);
                } else if (department.getDepth() == 5) {
                    depId = department.getDepId().substring(0, 20);
                }
                depth = department.getDepth();
            }
            //封装dao方法入参
            ExportEmpDaoReq daoReq = new ExportEmpDaoReq(empListReq.getDepartmentId(),empListReq.getEmployeeNo(),
                    empListReq.getEmployeeName(),empListReq.getPhone(),empListReq.getEmpType(),depId,depth,estateId);
            resps = companyEmployeeDao.selectByParams(daoReq);
        }
        return resps;
    }
}
