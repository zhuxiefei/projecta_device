package com.bdcourtyard.business.account.dao;

import com.bdcourtyard.business.account.domain.FindAllAccountDaoReq;
import com.bdcourtyard.business.account.domain.FindAllAccountResp;
import com.bdcourtyard.business.account.domain.RoleInfo;
import com.bdcourtyard.business.account.model.CompanyEmployee;
import com.bdcourtyard.business.account.model.EmployeeAccount;
import com.bdcourtyard.common.mybatis.QueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  EmployeeAccountDao 物业人员账户
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16
 */
@Repository
public interface EmployeeAccountDao {
	
	int insertEmployeeAccount(EmployeeAccount employeeAccount);
	
	int insertEmployeeAccountBatch(List<EmployeeAccount> list);
	
	int updateEmployeeAccountById(EmployeeAccount employeeAccount);
	
	int deleteEmployeeAccountById(@Param("acctName") String acctName);

 	EmployeeAccount getEmployeeAccountById(@Param("acctName") String acctName);

 	List<FindAllAccountResp> getEmployeeAccounts(FindAllAccountDaoReq daoReq);
 	
 	List<EmployeeAccount> getEmployeeAccountsByConditions(@Param("conditions") List<QueryCondition> conditions);

	void deleteAccounts(List<String> acctNames);

	List<RoleInfo> findRoleList(String estateId);

	CompanyEmployee getRoleIdByAcctNameAndEstateId(@Param("acctName")String acctName, @Param("estateId")String estateId);

	CompanyEmployee selectByAcctName(@Param("acctName") String acctName,
									 @Param("estateId") String estateId);
}
