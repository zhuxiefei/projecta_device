package com.bdcourtyard.business.account.service;

import basic.common.core.dto.PageDto;
import com.bdcourtyard.business.account.model.EmployeeAccountRela;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 *  EmployeeAccountRelaService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16 
 */
public interface EmployeeAccountRelaService {
	
	int insertEmployeeAccountRela(EmployeeAccountRela employeeAccountRela);
	
	int insertEmployeeAccountRelaBatch(List<EmployeeAccountRela> list);
	
	int updateEmployeeAccountRelaById(EmployeeAccountRela employeeAccountRela);
	
	int deleteEmployeeAccountRelaById(String acctName, String employeeId);

 	EmployeeAccountRela getEmployeeAccountRelaById(String acctName, String employeeId);
 
 	List<EmployeeAccountRela> getEmployeeAccountRelas(EmployeeAccountRela employeeAccountRela);

 	PageDto<EmployeeAccountRela> getEmployeeAccountRelasForPage(EmployeeAccountRela employeeAccountRela, Pageable pageable);
}
