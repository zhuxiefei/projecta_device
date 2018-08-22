package com.bdcourtyard.business.login.service;

import com.bdcourtyard.business.account.model.EmployeePrivilege;
import com.bdcourtyard.business.account.model.Privilege;
import com.bdcourtyard.business.login.model.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by cxx on 2018/7/16.
 */
public interface LoginService {
    LoginResp login(LoginReq loginReq, HttpServletRequest request, HttpSession session);

    ChooseEstateResp chooseEstate(String acctName, String estateId);

    List<EmployeePrivilege> chooseSystem(String acctName, String estateId, String privilegeId);

    void logout(String acctName);

    AppLoginResp appLogin(AppLoginReq appLoginReq, HttpServletRequest request, HttpSession session);

    void getSmsCode(GetCodeReq getCodeReq);

    void checkCode(String mobile, String code);

    void updatePwd(String mobile, String newPwd);
}
