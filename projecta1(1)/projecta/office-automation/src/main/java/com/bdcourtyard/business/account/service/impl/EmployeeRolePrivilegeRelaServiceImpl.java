package com.bdcourtyard.business.account.service.impl;

import basic.common.core.dto.PageDto;
import com.bdcourtyard.business.account.dao.EmployeeRolePrivilegeRelaDao;
import com.bdcourtyard.business.account.model.EmployeeRolePrivilegeRela;
import com.bdcourtyard.business.account.service.EmployeeRolePrivilegeRelaService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *  EmployeeRolePrivilegeRelaServiceImpl
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16 
 */
@Service
public class EmployeeRolePrivilegeRelaServiceImpl  implements EmployeeRolePrivilegeRelaService {
	
	@Autowired
	private EmployeeRolePrivilegeRelaDao employeeRolePrivilegeRelaDao;
	
	public int insertEmployeeRolePrivilegeRela(EmployeeRolePrivilegeRela employeeRolePrivilegeRela){
		return employeeRolePrivilegeRelaDao.insertEmployeeRolePrivilegeRela(employeeRolePrivilegeRela);
	}
	public int insertEmployeeRolePrivilegeRelaBatch(List<EmployeeRolePrivilegeRela> list){
		return employeeRolePrivilegeRelaDao.insertEmployeeRolePrivilegeRelaBatch(list);
	}
	public int updateEmployeeRolePrivilegeRelaById(EmployeeRolePrivilegeRela employeeRolePrivilegeRela){
		return employeeRolePrivilegeRelaDao.updateEmployeeRolePrivilegeRelaById(employeeRolePrivilegeRela);
	}
	public int deleteEmployeeRolePrivilegeRelaById(  String rpRela  ){
		return employeeRolePrivilegeRelaDao.deleteEmployeeRolePrivilegeRelaById(  rpRela  );
	}
	public EmployeeRolePrivilegeRela getEmployeeRolePrivilegeRelaById(  String rpRela  ){
		return employeeRolePrivilegeRelaDao.getEmployeeRolePrivilegeRelaById(  rpRela  );
	}
 
 	public List<EmployeeRolePrivilegeRela> getEmployeeRolePrivilegeRelas(EmployeeRolePrivilegeRela employeeRolePrivilegeRela){
		return employeeRolePrivilegeRelaDao.getEmployeeRolePrivilegeRelas(employeeRolePrivilegeRela);

 	}

 	public PageDto<EmployeeRolePrivilegeRela> getEmployeeRolePrivilegeRelasForPage(EmployeeRolePrivilegeRela employeeRolePrivilegeRela, Pageable pageable){
 		
 		 long count = employeeRolePrivilegeRelaDao.getEmployeeRolePrivilegeRelas(employeeRolePrivilegeRela).size();
			PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
			List<EmployeeRolePrivilegeRela> employeeRolePrivilegeRelas = employeeRolePrivilegeRelaDao.getEmployeeRolePrivilegeRelas(employeeRolePrivilegeRela);
			 
			PageDto<EmployeeRolePrivilegeRela> pageDto = new PageDto<EmployeeRolePrivilegeRela>();
			
			if (employeeRolePrivilegeRelas != null) {
				pageDto.setRows( employeeRolePrivilegeRelas);
				pageDto.setTotal(count);
			} else {
				pageDto.setRows(new ArrayList<EmployeeRolePrivilegeRela>());
				pageDto.setTotal(0l);
			}
			
			return pageDto;
 	}
}
