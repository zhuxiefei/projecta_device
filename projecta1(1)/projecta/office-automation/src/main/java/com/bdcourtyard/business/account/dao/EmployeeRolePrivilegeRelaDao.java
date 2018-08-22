package com.bdcourtyard.business.account.dao;

import com.bdcourtyard.business.account.model.EmployeeAccountRela;
import com.bdcourtyard.business.account.model.EmployeePrivilege;
import com.bdcourtyard.business.account.model.EmployeeRolePrivilegeRela;
import com.bdcourtyard.common.mybatis.QueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  EmployeeRolePrivilegeRelaDao 物业人员角色权限关系
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16
 */
@Repository
public interface EmployeeRolePrivilegeRelaDao {
	
	int insertEmployeeRolePrivilegeRela(EmployeeRolePrivilegeRela employeeRolePrivilegeRela);
	
	int insertEmployeeRolePrivilegeRelaBatch(List<EmployeeRolePrivilegeRela> list);
	
	int updateEmployeeRolePrivilegeRelaById(EmployeeRolePrivilegeRela employeeRolePrivilegeRela);
	
	int deleteEmployeeRolePrivilegeRelaById(@Param("rpRela") String rpRela);

 	EmployeeRolePrivilegeRela getEmployeeRolePrivilegeRelaById(@Param("rpRela") String rpRela);

 	List<EmployeeRolePrivilegeRela> getEmployeeRolePrivilegeRelas(@Param("employeeRolePrivilegeRela") EmployeeRolePrivilegeRela employeeRolePrivilegeRela);
 	
 	List<EmployeeRolePrivilegeRela> getEmployeeRolePrivilegeRelasByConditions(@Param("conditions") List<QueryCondition> conditions);

	/**
	 * 查询角色的所有权限（系统，菜单，按钮）
	 * @param roleId
	 * @return
     */
	List<EmployeePrivilege> findParentPrivileges(String roleId);

	/**
	 * 据角色ID清除关系数据
	 * @param roleId
     */
	void deteleByRoleId(String roleId);

	/**
	 * 批量新增权限
	 * @param relaList
	 */
	void insertRolePrivileges(List<EmployeeRolePrivilegeRela> relaList);
}
