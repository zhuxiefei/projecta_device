package com.bdcourtyard.business.login.service.impl;

import com.bdcourtyard.business.account.dao.CompanyEmployeeDao;
import com.bdcourtyard.business.account.dao.EmployeeAccountDao;
import com.bdcourtyard.business.account.dao.EmployeeAccountRelaDao;
import com.bdcourtyard.business.account.dao.EmployeePrivilegeDao;
import com.bdcourtyard.business.account.model.*;
import com.bdcourtyard.business.estate.dao.EstateEstateDao;
import com.bdcourtyard.business.estate.model.EstateEstate;
import com.bdcourtyard.business.login.model.*;
import com.bdcourtyard.business.login.service.LoginService;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.mybatis.QueryCondition;
import com.bdcourtyard.common.utils.IpAddrUtil;
import com.bdcourtyard.common.utils.PropertiesUtil;
import com.bdcourtyard.common.utils.StringUtil;
import com.beite.tools.redis.RedisManager;
import com.beite.tools.sms.BaiduSms;
import com.beite.tools.utils.AESUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by cxx on 2018/7/16.
 */
@Service
public class LoginServiceImpl implements LoginService {

    private static Logger LOG = Logger.getLogger(LoginServiceImpl.class);

    @Autowired
    private EmployeeAccountDao employeeAccountDao;

    @Autowired
    private EmployeeAccountRelaDao employeeAccountRelaDao;

    @Autowired
    private CompanyEmployeeDao companyEmployeeDao;

    @Autowired
    private EstateEstateDao estateEstateDao;

    @Autowired
    private EmployeePrivilegeDao employeePrivilegeDao;

    @Override
    public LoginResp login(LoginReq loginReq, HttpServletRequest request, HttpSession session) {
        LoginResp loginResp = new LoginResp();
        //获取验证码
        String imageCode = (String) session.getAttribute("imageCode");
        if(loginReq.getImageCode() == null){
            throw new GlobalException("L0001");
        }else if(imageCode == null){
            throw new GlobalException("L0002");
        }else if(!imageCode.toLowerCase().equals(loginReq.getImageCode().toLowerCase())){
            throw new GlobalException("L0003");
        }else if (loginReq.getAcctName() == null) {
            throw new GlobalException("L0005");
        } else if (loginReq.getPassword() == null) {
            throw new GlobalException("L0006");
        } else {
            //查询用户信息
            EmployeeAccount employeeAccount = employeeAccountDao.getEmployeeAccountById(loginReq.getAcctName());
            String password = "";
            try {
                password = AESUtil.encrypt(loginReq.getPassword());
            } catch (Exception e) {
                LOG.error("密码加密失败", e);
            }
            if (employeeAccount == null) {
                throw new GlobalException("L0007");
            } else if (!employeeAccount.getPassword().equals(password)) {
                throw new GlobalException("L0004");
            }  else {
                //登录成功，返回该账号对应哪些楼盘
                //先查询acctName对应的employeeId
                List<QueryCondition> qcs = new ArrayList<QueryCondition>();
                qcs.add(new QueryCondition("acctName", employeeAccount.getAcctName()));
                List<EmployeeAccountRela> employeeAccountRelas = employeeAccountRelaDao.getEmployeeAccountRelasByConditions(qcs);
                List<EstateEstate> estates = new ArrayList<>();
                for (EmployeeAccountRela employeeAccountRela : employeeAccountRelas) {
                    //通过employeeId查询estateId,estateId查询楼盘信息
                    CompanyEmployee employee = companyEmployeeDao.getCompanyEmployeeById(employeeAccountRela.getEmployeeId());
                    if (employee != null) {
                        EstateEstate estate = estateEstateDao.getEstateEstateById(employee.getEstateId());
                        try {
                            estate.setEstateId(AESUtil.encrypt(estate.getEstateId()));
                        } catch (Exception e) {
                            LOG.error("estateID加密失败", e);
                        }
                        estates.add(estate);
                    }
                }
                loginResp.setEstates(estates);
                try {
                    loginResp.setAcctName(AESUtil.encrypt(loginReq.getAcctName()));
                } catch (Exception e) {
                    LOG.error("加密失败", e);
                }
                //生成token，并返回
                try {
                    loginResp.setToken(updateToken(loginReq.getAcctName()));
                } catch (Exception e) {
                    LOG.error("token生成失败", e);
                }
                loginResp.setIsInit(employeeAccount.getIsInit());

                //更新用户登录Ip以及登录时间
                String ip = "";
                try {
                    ip = IpAddrUtil.getIpAddress();
                } catch (Exception e) {
                    LOG.error("获取IP失败", e);
                }
                EmployeeAccount ea = new EmployeeAccount();
                ea.setLastLoginIp(ip);
                ea.setAcctName(loginReq.getAcctName());
                ea.setLastLoginTime(new Date());
                employeeAccountDao.updateEmployeeAccountById(ea);
                return loginResp;
            }
        }
    }

    private String updateToken(String acctName) throws Exception {
        Date date = new Date();
        // 生成token内容
        String authToken = UUID.randomUUID() + "-" + date.getTime();
        // 读取配置库中token失效时间（小时）
        String expireTimeStr = PropertiesUtil.getProperty("token.expire.time");
        // 失效时间设为当前时间加上配置库时间
        Long tokenExpireTime = Long.parseLong(expireTimeStr) * 60 * 60;

        //去redis查询该用户是否有token信息
        String tokenContent = RedisManager.get(AESUtil.encrypt(acctName));
        if (StringUtil.isBlank(tokenContent)) {
            RedisManager.add(AESUtil.encrypt(acctName), authToken, tokenExpireTime.intValue());
        } else {
            //先删除，再添加
            RedisManager.delete(AESUtil.encrypt(acctName));
            RedisManager.add(AESUtil.encrypt(acctName), authToken, tokenExpireTime.intValue());
        }
        return authToken;
    }

    @Override
    public ChooseEstateResp chooseEstate(String acctName, String estateId) {
        ChooseEstateResp chooseEstateResp = new ChooseEstateResp();
        CompanyEmployee companyEmployee = null;
        try {
            companyEmployee = employeeAccountDao.getRoleIdByAcctNameAndEstateId(AESUtil.decrypt(acctName), AESUtil.decrypt(estateId));
        } catch (Exception e) {
            LOG.error("查询角色ID失败", e);
        }
        //判断账号是否启用
        if (companyEmployee.getIsEnableAccount().equals(0)){
            throw new GlobalException("L0012");
        }
        //查询该role对应的系统权限（4代表系统）
        List<EmployeePrivilege> privileges = employeePrivilegeDao.getPrivilegesByRoleId(companyEmployee.getRoleId(), "4");
        chooseEstateResp.setPrivileges(privileges);
        try {
            String employeeId = AESUtil.encrypt(companyEmployee.getEmployeeId());
            chooseEstateResp.setEmployeeId(employeeId);
            chooseEstateResp.setEmployeeName(companyEmployee.getEmployeeName());
        } catch (Exception e) {
            LOG.error("加密失败", e);
        }
        return chooseEstateResp;
    }

    @Override
    public List<EmployeePrivilege> chooseSystem(String acctName, String estateId, String privilegeId) {
        CompanyEmployee companyEmployee = null;
        try {
            companyEmployee = employeeAccountDao.getRoleIdByAcctNameAndEstateId(AESUtil.decrypt(acctName), AESUtil.decrypt(estateId));
        } catch (Exception e) {
            LOG.error("查询角色ID失败", e);
        }
        List<EmployeePrivilege> list = new ArrayList<>();
        //查询所有一级菜单权限
        List<EmployeePrivilege> firstMenuList =
                employeePrivilegeDao.getPrivilegesByRoleIdAndParentId(companyEmployee.getRoleId(), "1", privilegeId);
        list.addAll(firstMenuList);
        //查询所有二级菜单权限
        List<EmployeePrivilege> secondMenuList = new ArrayList<>();
        for (EmployeePrivilege p :
                firstMenuList) {
            secondMenuList.addAll(
                    employeePrivilegeDao.getPrivilegesByRoleIdAndParentId(companyEmployee.getRoleId(), "1", p.getPrivilegeId()));
        }
        list.addAll(secondMenuList);
        //查询所有按钮权限
        for (EmployeePrivilege p :
                firstMenuList) {
            //加入按钮权限
            list.addAll(employeePrivilegeDao.getPrivilegesByRoleIdAndParentId(companyEmployee.getRoleId(), "2", p.getPrivilegeId()));
        }
        for (EmployeePrivilege p :
                secondMenuList) {
            //加入按钮权限
            list.addAll(employeePrivilegeDao.getPrivilegesByRoleIdAndParentId(companyEmployee.getRoleId(), "2", p.getPrivilegeId()));
        }
        return list;
    }

    @Override
    public void logout(String acctName) {
        try {
            RedisManager.delete(AESUtil.encrypt(acctName));
        } catch (Exception e) {
            LOG.error("删除用户对应的token失败", e);
        }
    }

    @Override
    public AppLoginResp appLogin(AppLoginReq appLoginReq, HttpServletRequest request, HttpSession session) {
        //先判断账号是否存在
        EmployeeAccount employeeAccount = employeeAccountDao.getEmployeeAccountById(appLoginReq.getAcctName());
        String pwd = "";
        try {
            pwd = AESUtil.encrypt(appLoginReq.getPassword());
        } catch (Exception e) {
            LOG.error("密码加密失败", e);
        }
        if (employeeAccount == null) {
            throw new GlobalException("L0007");
        } else {
            if ("1".equals(appLoginReq.getType())) {
                if (!pwd.equals(employeeAccount.getPassword())) {
                    throw new GlobalException("L0004");
                }
            } else {
                boolean isTrue = BaiduSms.checkValidateCode(appLoginReq.getAcctName(), "login_oa", appLoginReq.getValidateCode());
                if (!isTrue) {
                    throw new GlobalException("L0011");
                }
            }
        }

        //登陆成功之后，生成token，更新登陆ip和时间
        AppLoginResp appLoginResp = new AppLoginResp();
        try {
            //和后台区分 key前加上了app
            appLoginResp.setToken(updateToken("app-" + appLoginReq.getAcctName()));
        } catch (Exception e) {
            LOG.error("token生成失败", e);
        }
        try {
            appLoginResp.setAcctName(AESUtil.encrypt(appLoginReq.getAcctName()));
        } catch (Exception e) {
            LOG.error("加密失败", e);
        }
        //更新用户登录Ip以及登录时间
        String ip = "";
        try {
            ip = IpAddrUtil.getIpAddress();
        } catch (Exception e) {
            LOG.error("获取IP失败", e);
        }
        EmployeeAccount ea = new EmployeeAccount();
        ea.setLastLoginIp(ip);
        ea.setAcctName(appLoginReq.getAcctName());
        ea.setLastLoginTime(new Date());
        employeeAccountDao.updateEmployeeAccountById(ea);
        return appLoginResp;
    }

    @Override
    public void getSmsCode(GetCodeReq getCodeReq) {
        //判断手机号是否注册
        EmployeeAccount employeeAccount = employeeAccountDao.getEmployeeAccountById(getCodeReq.getMobile());
        if (employeeAccount == null) {
            throw new GlobalException("L0007");
        } else {
            int i = BaiduSms.sendValidateCode(getCodeReq.getMobile(), getCodeReq.getType());
            if (i == 2) {
                throw new GlobalException("L0009");
            } else if (i == 3) {
                throw new GlobalException("L0010");
            }
        }
    }

    @Override
    public void checkCode(String mobile, String code) {
        //判断手机号是否注册
        EmployeeAccount employeeAccount = employeeAccountDao.getEmployeeAccountById(mobile);
        if (employeeAccount == null) {
            throw new GlobalException("L0007");
        } else {
            boolean isTure = BaiduSms.checkValidateCode(mobile, "forget_oa", code);
            if (!isTure) {
                throw new GlobalException("L0011");
            }
        }
    }

    @Override
    public void updatePwd(String mobile, String newPwd) {
        //判断手机号是否注册
        EmployeeAccount employeeAccount = employeeAccountDao.getEmployeeAccountById(mobile);
        if (employeeAccount == null) {
            throw new GlobalException("L0007");
        } else {
            try {
                employeeAccount.setPassword(AESUtil.encrypt(newPwd.trim()));
            } catch (Exception e) {
                LOG.error("加密失败", e);
            }
            employeeAccountDao.updateEmployeeAccountById(employeeAccount);
        }
    }
}
