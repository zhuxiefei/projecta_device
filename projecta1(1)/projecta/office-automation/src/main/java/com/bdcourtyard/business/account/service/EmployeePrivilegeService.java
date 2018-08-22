package com.bdcourtyard.business.account.service;

import basic.common.core.dto.PageDto;
import com.bdcourtyard.business.account.model.EmployeePrivilege;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 *  EmployeePrivilegeService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16 
 */
public interface EmployeePrivilegeService {
	
	int insertEmployeePrivilege(EmployeePrivilege employeePrivilege);
	
	int insertEmployeePrivilegeBatch(List<EmployeePrivilege> list);
	
	int updateEmployeePrivilegeById(EmployeePrivilege employeePrivilege);
	
	int deleteEmployeePrivilegeById(String privilegeId);

 	EmployeePrivilege getEmployeePrivilegeById(String privilegeId);
 
 	List<EmployeePrivilege> getEmployeePrivileges(EmployeePrivilege employeePrivilege);

 	PageDto<EmployeePrivilege> getEmployeePrivilegesForPage(EmployeePrivilege employeePrivilege, Pageable pageable);
}
