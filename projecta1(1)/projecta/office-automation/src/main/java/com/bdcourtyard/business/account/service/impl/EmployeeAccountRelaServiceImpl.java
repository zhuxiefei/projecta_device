package com.bdcourtyard.business.account.service.impl;

import basic.common.core.dto.PageDto;
import com.bdcourtyard.business.account.dao.EmployeeAccountRelaDao;
import com.bdcourtyard.business.account.model.EmployeeAccountRela;
import com.bdcourtyard.business.account.service.EmployeeAccountRelaService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *  EmployeeAccountRelaServiceImpl
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16 
 */
@Service
public class EmployeeAccountRelaServiceImpl  implements EmployeeAccountRelaService {
	
	@Autowired
	private EmployeeAccountRelaDao employeeAccountRelaDao;
	
	public int insertEmployeeAccountRela(EmployeeAccountRela employeeAccountRela){
		return employeeAccountRelaDao.insertEmployeeAccountRela(employeeAccountRela);
	}
	public int insertEmployeeAccountRelaBatch(List<EmployeeAccountRela> list){
		return employeeAccountRelaDao.insertEmployeeAccountRelaBatch(list);
	}
	public int updateEmployeeAccountRelaById(EmployeeAccountRela employeeAccountRela){
		return employeeAccountRelaDao.updateEmployeeAccountRelaById(employeeAccountRela);
	}
	public int deleteEmployeeAccountRelaById(  String acctName  ,    String employeeId  ){
		return employeeAccountRelaDao.deleteEmployeeAccountRelaById(  acctName  ,    employeeId  );
	}
	public EmployeeAccountRela getEmployeeAccountRelaById(  String acctName  ,    String employeeId  ){
		return employeeAccountRelaDao.getEmployeeAccountRelaById(  acctName  ,    employeeId  );
	}
 
 	public List<EmployeeAccountRela> getEmployeeAccountRelas(EmployeeAccountRela employeeAccountRela){
		return employeeAccountRelaDao.getEmployeeAccountRelas(employeeAccountRela);

 	}

 	public PageDto<EmployeeAccountRela> getEmployeeAccountRelasForPage(EmployeeAccountRela employeeAccountRela, Pageable pageable){
 		
 		 long count = employeeAccountRelaDao.getEmployeeAccountRelas(employeeAccountRela).size();
			PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
			List<EmployeeAccountRela> employeeAccountRelas = employeeAccountRelaDao.getEmployeeAccountRelas(employeeAccountRela);
			 
			PageDto<EmployeeAccountRela> pageDto = new PageDto<EmployeeAccountRela>();
			
			if (employeeAccountRelas != null) {
				pageDto.setRows( employeeAccountRelas);
				pageDto.setTotal(count);
			} else {
				pageDto.setRows(new ArrayList<EmployeeAccountRela>());
				pageDto.setTotal(0l);
			}
			
			return pageDto;
 	}
}
