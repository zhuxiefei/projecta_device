package com.bdcourtyard.business.account.service.impl;

import basic.common.core.dto.PageDto;
import com.bdcourtyard.business.account.dao.EmployeePrivilegeDao;
import com.bdcourtyard.business.account.model.EmployeePrivilege;
import com.bdcourtyard.business.account.service.EmployeePrivilegeService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *  EmployeePrivilegeServiceImpl
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16 
 */
@Service
public class EmployeePrivilegeServiceImpl  implements EmployeePrivilegeService { 
	
	@Autowired
	private EmployeePrivilegeDao employeePrivilegeDao;
	
	public int insertEmployeePrivilege(EmployeePrivilege employeePrivilege){
		return employeePrivilegeDao.insertEmployeePrivilege(employeePrivilege);
	}
	public int insertEmployeePrivilegeBatch(List<EmployeePrivilege> list){
		return employeePrivilegeDao.insertEmployeePrivilegeBatch(list);
	}
	public int updateEmployeePrivilegeById(EmployeePrivilege employeePrivilege){
		return employeePrivilegeDao.updateEmployeePrivilegeById(employeePrivilege);
	}
	public int deleteEmployeePrivilegeById(  String privilegeId  ){
		return employeePrivilegeDao.deleteEmployeePrivilegeById(  privilegeId  );
	}
	public EmployeePrivilege getEmployeePrivilegeById(  String privilegeId  ){
		return employeePrivilegeDao.getEmployeePrivilegeById(  privilegeId  );
	}
 
 	public List<EmployeePrivilege> getEmployeePrivileges(EmployeePrivilege employeePrivilege){
		return employeePrivilegeDao.getEmployeePrivileges(employeePrivilege);

 	}

 	public PageDto<EmployeePrivilege> getEmployeePrivilegesForPage(EmployeePrivilege employeePrivilege, Pageable pageable){
 		
 		 long count = employeePrivilegeDao.getEmployeePrivileges(employeePrivilege).size();
			PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
			List<EmployeePrivilege> employeePrivileges = employeePrivilegeDao.getEmployeePrivileges(employeePrivilege);
			 
			PageDto<EmployeePrivilege> pageDto = new PageDto<EmployeePrivilege>();
			
			if (employeePrivileges != null) {
				pageDto.setRows( employeePrivileges);
				pageDto.setTotal(count);
			} else {
				pageDto.setRows(new ArrayList<EmployeePrivilege>());
				pageDto.setTotal(0l);
			}
			
			return pageDto;
 	}
}
