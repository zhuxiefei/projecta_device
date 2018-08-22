package com.bdcourtyard.business.account.service;

import basic.common.core.dto.PageDto;
import com.bdcourtyard.business.account.domain.*;
import com.bdcourtyard.business.account.model.EmployeeAccount;
import com.bdcourtyard.common.page.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *  EmployeeAccountService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16 
 */
public interface EmployeeAccountService {

	Page<FindAllAccountResp> getEmployeeAccountsForPage(FindAllAccountReq accountReq, String estateId, Pageable pageable);

	List<RoleInfo> findRoles(String estateId);

	AddAccountResp addAccount(AddAccountReq accountReq, String estateId);

	void updateAccount(UpdateAccountReq accountReq, String estateId);

	List<FindEmpByDeptResp> findByDepartmentId(String departmentId);

	FindAccountResp findByAcctName(String acctName, String estateId);

	ResetPasswordResp resetPwd(ResetPwdReq pwdReq);

	void updateAdminPwd(UpdatePwdReq pwdReq, HttpServletRequest request);
}
