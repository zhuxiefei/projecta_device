package com.bdcourtyard.business.account.service.impl;

import basic.common.core.dto.PageDto;
import com.bdcourtyard.business.account.constant.AccountConstant;
import com.bdcourtyard.business.account.constant.EmployeeConstant;
import com.bdcourtyard.business.account.dao.CompanyEmployeeDao;
import com.bdcourtyard.business.account.dao.EmployeeAccountDao;
import com.bdcourtyard.business.account.dao.EmployeeAccountRelaDao;
import com.bdcourtyard.business.account.dao.EmployeeRoleDao;
import com.bdcourtyard.business.account.domain.*;
import com.bdcourtyard.business.account.model.CompanyEmployee;
import com.bdcourtyard.business.account.model.EmployeeAccount;
import com.bdcourtyard.business.account.model.EmployeeAccountRela;
import com.bdcourtyard.business.account.service.EmployeeAccountService;
import com.bdcourtyard.business.account.utils.Validate;
import com.bdcourtyard.business.dept.dao.CompanyDepartmentDao;
import com.bdcourtyard.business.dept.model.CompanyDepartment;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;
import com.bdcourtyard.common.utils.StringUtil;
import com.beite.tools.redis.RedisManager;
import com.beite.tools.utils.AESUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * EmployeeAccountServiceImpl
 *
 * @version : Ver 1.0
 * @date : 2018-7-16
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeeAccountServiceImpl implements EmployeeAccountService {

    @Autowired
    private EmployeeAccountDao employeeAccountDao;

    @Autowired
    EmployeeRoleDao employeeRoleDao;

    @Autowired
    CompanyEmployeeDao companyEmployeeDao;

    @Autowired
    EmployeeAccountRelaDao employeeAccountRelaDao;

    @Autowired
    CompanyDepartmentDao companyDepartmentDao;

    public Page<FindAllAccountResp> getEmployeeAccountsForPage(FindAllAccountReq accountReq, String estateId, Pageable pageable) {
        //校验入参
        validateAccountReq(accountReq);
        if (!StringUtil.isBlank(accountReq.getEmpName()) && accountReq.getEmpName().contains("_")) {
            accountReq.setEmpName(accountReq.getEmpName().replace("_","\\_"));
        }
        String depId = null;
        Integer depth = 0;
        if (!StringUtil.isBlank(accountReq.getDepartmentId())) {
            CompanyDepartment department = companyDepartmentDao.getCompanyDepartmentById(accountReq.getDepartmentId());
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
        //封装dao层入参
        FindAllAccountDaoReq daoReq = new FindAllAccountDaoReq(accountReq.getEmpNo(),accountReq.getDepartmentId(),
                accountReq.getEmpName(),accountReq.getPhoneNum(),accountReq.getStartTime(),accountReq.getEndTime(),
                depId,depth,estateId);
        long count = employeeAccountDao.getEmployeeAccounts(daoReq).size();
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<FindAllAccountResp> employeeAccounts = employeeAccountDao.getEmployeeAccounts(daoReq);

        Page<FindAllAccountResp> pageDto = new Page<FindAllAccountResp>();
        pageDto.setPage(pageable.getPageNumber());
        pageDto.setPageSize(pageable.getPageSize());

        if (employeeAccounts != null) {
            pageDto.setRows(employeeAccounts);
            pageDto.setTotal(count);
        } else {
            pageDto.setRows(new ArrayList<FindAllAccountResp>());
            pageDto.setTotal(0l);
        }

        return pageDto;
    }

    /**
     * 校验分页入参
     * @param accountReq
     * @return
     */
    private void validateAccountReq(FindAllAccountReq accountReq){
        if (!StringUtil.isBlank(accountReq.getDepartmentId())
                && null == companyDepartmentDao.getCompanyDepartmentById(accountReq.getDepartmentId())) {
            throw new GlobalException("D0006");
        }
        //前后去空格
        if (!StringUtil.isEmpty(accountReq.getEmpNo())){
            accountReq.setEmpNo(accountReq.getEmpNo().trim());
        }
        if (!StringUtil.isEmpty(accountReq.getEmpName())){
            accountReq.setEmpName(accountReq.getEmpName().trim());
        }
        if (!StringUtil.isEmpty(accountReq.getPhoneNum())){
            accountReq.setPhoneNum(accountReq.getPhoneNum().trim());
        }
        //验证格式
        if (!StringUtil.isBlank(accountReq.getEmpNo()) && !Validate.isSearchNum(accountReq.getEmpNo().trim(), EmployeeConstant.EMP_NO_MAX)) {
            throw new GlobalException("E0002");
        }
        if (!StringUtil.isBlank(accountReq.getEmpName()) && !Validate.isCommonString(accountReq.getEmpName().trim(), EmployeeConstant.EMP_NAME_LENGTH)){
            throw new GlobalException("E0004");
        }
        if (!StringUtil.isBlank(accountReq.getPhoneNum())){
            String phone = accountReq.getPhoneNum().trim();
            if (phone.length()<EmployeeConstant.PHONE_MIN_LENGTH || phone.length()>EmployeeConstant.PHONE_MAX_LENGTH
                    || !Validate.isSearchNum(phone)){
                throw new GlobalException("E0029");
            }
        }
        if (!StringUtil.isBlank(accountReq.getStartTime()) && !Validate.validateTime(accountReq.getStartTime().trim())){
            throw new GlobalException("A0009");
        }
        if (!StringUtil.isBlank(accountReq.getEndTime()) && !Validate.validateTime(accountReq.getEndTime().trim())){
            throw new GlobalException("A0009");
        }
        if (!StringUtil.isBlank(accountReq.getStartTime()) && !StringUtil.isBlank(accountReq.getEndTime())
                && Validate.validateTime(accountReq.getStartTime().trim()) && Validate.validateTime(accountReq.getEndTime().trim())
                && !Validate.validateTimeDistance(accountReq.getStartTime(),accountReq.getEndTime())){
            throw new GlobalException("A0010");
        }
    }

    @Override
    public List<RoleInfo> findRoles(String estateId) {
        return employeeAccountDao.findRoleList(estateId);
    }

    @Override
    public AddAccountResp addAccount(AddAccountReq accountReq, String estateId) {
        CompanyEmployee emp = companyEmployeeDao.getCompanyEmployeeById(accountReq.getEmpId());
        if (StringUtil.isBlank(accountReq.getEmpId())) {
            throw new GlobalException("A0001");
        } else if (StringUtil.isBlank(accountReq.getIsEnableAccount())) {
            throw new GlobalException("A0006");
        } else if (StringUtil.isBlank(accountReq.getRoleId())) {
            throw new GlobalException("A0007");
        } else if (null == employeeRoleDao.getEmployeeRoleById(accountReq.getRoleId())) {
            throw new GlobalException("A0008");
        } else {
            EmployeeAccountRela empAccountRela = employeeAccountRelaDao.getEmployeeAccountRelaByEmpId(accountReq.getEmpId());
            if (null == emp) {
                throw new GlobalException("A0002");
            } else if (null != empAccountRela) {
                throw new GlobalException("A0003");
            } else {
                AddAccountResp addAccountResp = new AddAccountResp();
                //判断是否已经有employeeAccount
                EmployeeAccount employeeAccount = employeeAccountDao.getEmployeeAccountById(emp.getPhoneNum());
                if (null == employeeAccount) {
                    //添加账号表
                    EmployeeAccount account = new EmployeeAccount();
                    account.setCreateTime(new Date(System.currentTimeMillis()));
                    account.setAcctName(emp.getPhoneNum());
                    try {
                        account.setPassword(AESUtil.encrypt(emp.getPhoneNum().substring(emp.getPhoneNum().length() - 6)));
                    } catch (Exception e) {
                        throw new GlobalException("99999");
                    }
                    account.setIsInit(AccountConstant.IS_INIT);
                    employeeAccountDao.insertEmployeeAccount(account);
                    //添加关系表
                    EmployeeAccountRela rela = new EmployeeAccountRela();
                    rela.setAcctName(emp.getPhoneNum());
                    rela.setCreateTime(new Date(System.currentTimeMillis()));
                    rela.setEmployeeId(emp.getEmployeeId());
                    employeeAccountRelaDao.insertEmployeeAccountRela(rela);
                    //回参设置为展示密码
                    addAccountResp.setFlag("1");
                } else {
                    //添加关系表
                    EmployeeAccountRela rela = new EmployeeAccountRela();
                    rela.setAcctName(emp.getPhoneNum());
                    rela.setCreateTime(new Date(System.currentTimeMillis()));
                    rela.setEmployeeId(emp.getEmployeeId());
                    employeeAccountRelaDao.insertEmployeeAccountRela(rela);
                    //回参设置为不展示密码
                    addAccountResp.setFlag("0");
                }
                emp.setIsEnableAccount(Integer.parseInt(accountReq.getIsEnableAccount()));
                emp.setRoleId(accountReq.getRoleId());
                emp.setEstateId(estateId);
                companyEmployeeDao.updateByPrimaryKeySelective(emp);
                return addAccountResp;
            }
        }
    }

    @Override
    public void updateAccount(UpdateAccountReq accountReq, String estateId) {
        if (StringUtil.isBlank(accountReq.getAcctName())) {
            throw new GlobalException("A0004");
        } else if (StringUtil.isBlank(accountReq.getRoleId())) {
            throw new GlobalException("A0007");
        } else if (null == employeeRoleDao.getEmployeeRoleById(accountReq.getRoleId())) {
            throw new GlobalException("A0008");
        } else {
            EmployeeAccount account = employeeAccountDao.getEmployeeAccountById(accountReq.getAcctName());
            if (null == account) {
                throw new GlobalException("A0005");
            } else if (StringUtil.isBlank(accountReq.getIsEnableAccount())) {
                throw new GlobalException("A0006");
            } else {
                //编辑账号启用状态
                CompanyEmployee emp = employeeAccountDao.selectByAcctName(accountReq.getAcctName(), estateId);
                //查询emp的roleId
                String oldEmpRoleId = emp.getRoleId();
                //修改人员档案信息
                emp.setIsEnableAccount(Integer.parseInt(accountReq.getIsEnableAccount()));
                emp.setRoleId(accountReq.getRoleId());
                companyEmployeeDao.updateByPrimaryKeySelective(emp);
                if (null != emp && !accountReq.getRoleId().equals(oldEmpRoleId)) {
                    try {
                        // 角色变化 清除token 使对应员工下线
                        RedisManager.delete(AESUtil.encrypt(accountReq.getAcctName()));
                    } catch (Exception e) {
                        throw new GlobalException("99999");
                    }
                }
            }
        }
    }

    @Override
    public List<FindEmpByDeptResp> findByDepartmentId(String departmentId) {
        List<FindEmpByDeptResp> list = new ArrayList<>();
        if (StringUtil.isBlank(departmentId)) {
            throw new GlobalException("D0005");
        } else if (null == companyDepartmentDao.getCompanyDepartmentById(departmentId)) {
            throw new GlobalException("D0006");
        } else {
            list = companyEmployeeDao.selectByDepartmentId(departmentId);
        }
        return list;
    }

    @Override
    public FindAccountResp findByAcctName(String acctName, String estateId) {
        FindAccountResp resp = new FindAccountResp();
        if (StringUtil.isBlank(acctName)) {
            throw new GlobalException("A0004");
        } else {
            EmployeeAccount account = employeeAccountDao.getEmployeeAccountById(acctName);
            if (null == account) {
                throw new GlobalException("A0005");
            } else {
                CompanyEmployee employee = employeeAccountDao.selectByAcctName(acctName,estateId);
                if (null != employee) {
                    resp.setAcctName(acctName);
                    resp.setEmployeeRole(employeeRoleDao.getEmployeeRoleById(employee.getRoleId()));
                    resp.setIsEnableAccount(employee.getIsEnableAccount());
                    return resp;
                }
            }
        }
        return resp;
    }

    @Override
    public ResetPasswordResp resetPwd(ResetPwdReq pwdReq) {
        ResetPasswordResp resetPasswordResp = new ResetPasswordResp();
        EmployeeAccount account = employeeAccountDao.getEmployeeAccountById(pwdReq.getAcctName());
        if (null == account) {
            throw new GlobalException("A0005");
        } else{
            try {
                //加密默认密码
                String encryptPwd = AESUtil.encrypt(pwdReq.getAcctName().substring(pwdReq.getAcctName().length() - 6));
                account.setIsInit(AccountConstant.IS_INIT);
                account.setPassword(encryptPwd);
                employeeAccountDao.updateEmployeeAccountById(account);
                //使token下线
                RedisManager.delete(AESUtil.encrypt(pwdReq.getAcctName()));
                resetPasswordResp.setPassword(encryptPwd);
                return resetPasswordResp;
            } catch (Exception e) {
                throw new GlobalException("99999");
            }
        }
    }

    @Override
    public void updateAdminPwd(UpdatePwdReq pwdReq, HttpServletRequest request) {
        if (!StringUtil.isEmpty(pwdReq.getNewPwd()) && !StringUtil.isEmpty(pwdReq.getOldPwd())) {
            //获取acctName
            String acctName = null;
            try {
                acctName = AESUtil.decrypt(request.getHeader("acctName"));
            } catch (Exception e) {
                throw new GlobalException("99999");
            }
            //查询人员账号
            EmployeeAccount account = employeeAccountDao.getEmployeeAccountById(acctName);
            if (null != account){
                String accountPwd;
                try {
                    accountPwd = AESUtil.decrypt(account.getPassword());
                } catch (Exception e) {
                    throw new GlobalException("99999");
                }
                //判断原密码是否正确
                if (pwdReq.getOldPwd().equals(accountPwd)) {
                    //校验新密码格式
                    if (!Validate.isPassword(pwdReq.getNewPwd())) {
                        throw new GlobalException("A0013");
                    }else {
                        //修改密码
                        String encryptNewPwd;
                        try {
                            encryptNewPwd = AESUtil.encrypt(pwdReq.getNewPwd());
                        } catch (Exception e) {
                            throw new GlobalException("99999");
                        }
                        account.setPassword(encryptNewPwd);
                        employeeAccountDao.updateEmployeeAccountById(account);
                    }
                } else {
                    //原密码不正确
                    throw new GlobalException("A0012");
                }
            }else {
                //账号为空
                throw new GlobalException("A0005");
            }
        } else {
            // 密码为空
            throw new GlobalException("A0011");
        }
    }
}
