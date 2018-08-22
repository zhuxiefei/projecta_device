package com.bdcourtyard.business.account.service;

import basic.common.core.dto.PageDto;
import com.bdcourtyard.business.account.domain.AddRoleReq;
import com.bdcourtyard.business.account.domain.FindPrivilegesResp;
import com.bdcourtyard.business.account.domain.FindRoleResp;
import com.bdcourtyard.business.account.domain.UpdateRoleReq;
import com.bdcourtyard.business.account.model.EmployeeRole;
import com.bdcourtyard.common.page.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *  EmployeeRoleService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16 
 */
public interface EmployeeRoleService {

 	Page<EmployeeRole> getEmployeeRolesForPage(String roleName, String estateId, Pageable pageable);

	FindPrivilegesResp findPrivileges(HttpServletRequest request);

	FindRoleResp findRole(String roleId);

	void deleteRole(String roleId);

	void updateRole(UpdateRoleReq roleReq,String estateId);

	void addRole(AddRoleReq roleReq, String estateId);
}
