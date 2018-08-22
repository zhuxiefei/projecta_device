package com.bdcourtyard.business.account.dao;

import com.bdcourtyard.business.account.model.EmployeeAccountRela;
import com.bdcourtyard.common.mybatis.QueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  EmployeeAccountRelaDao 物业人员账户关系
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16
 */
@Repository
public interface EmployeeAccountRelaDao {
	
	int insertEmployeeAccountRela(EmployeeAccountRela employeeAccountRela);
	
	int insertEmployeeAccountRelaBatch(List<EmployeeAccountRela> list);
	
	int updateEmployeeAccountRelaById(EmployeeAccountRela employeeAccountRela);
	
	int deleteEmployeeAccountRelaById(@Param("acctName") String acctName, @Param("employeeId") String employeeId);

 	EmployeeAccountRela getEmployeeAccountRelaById(@Param("acctName") String acctName, @Param("employeeId") String employeeId);

 	List<EmployeeAccountRela> getEmployeeAccountRelas(@Param("employeeAccountRela") EmployeeAccountRela employeeAccountRela);
 	
 	List<EmployeeAccountRela> getEmployeeAccountRelasByConditions(@Param("conditions") List<QueryCondition> conditions);

	EmployeeAccountRela getEmployeeAccountRelaByEmpId(@Param("employeeId") String employeeId);

	List<EmployeeAccountRela> getEmployeeAccountRelaByAcctName(@Param("acctName") String acctName);

	/**
	 * 批量删除人员关系
	 * @param empIds
     */
	void deleteByEmpIds(List<String> empIds);

	/**
	 * 根据roleId查询
	 * @param roleId
	 * @return
     */
	List<EmployeeAccountRela> findByRoleId(String roleId);
}
