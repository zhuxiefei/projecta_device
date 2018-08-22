package com.bdcourtyard.business.account.service;

import basic.common.core.dto.PageDto;
import com.bdcourtyard.business.account.model.EmployeeRolePrivilegeRela;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 *  EmployeeRolePrivilegeRelaService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16 
 */
public interface EmployeeRolePrivilegeRelaService {
	
	int insertEmployeeRolePrivilegeRela(EmployeeRolePrivilegeRela employeeRolePrivilegeRela);
	
	int insertEmployeeRolePrivilegeRelaBatch(List<EmployeeRolePrivilegeRela> list);
	
	int updateEmployeeRolePrivilegeRelaById(EmployeeRolePrivilegeRela employeeRolePrivilegeRela);
	
	int deleteEmployeeRolePrivilegeRelaById(String rpRela);

 	EmployeeRolePrivilegeRela getEmployeeRolePrivilegeRelaById(String rpRela);
 
 	List<EmployeeRolePrivilegeRela> getEmployeeRolePrivilegeRelas(EmployeeRolePrivilegeRela employeeRolePrivilegeRela);

 	PageDto<EmployeeRolePrivilegeRela> getEmployeeRolePrivilegeRelasForPage(EmployeeRolePrivilegeRela employeeRolePrivilegeRela, Pageable pageable);
}
