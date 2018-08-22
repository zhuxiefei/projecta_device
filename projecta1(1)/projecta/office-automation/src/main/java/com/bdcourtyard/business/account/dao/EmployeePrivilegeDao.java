package com.bdcourtyard.business.account.dao;

import com.bdcourtyard.business.account.model.EmployeePrivilege;
import com.bdcourtyard.common.mybatis.QueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  EmployeePrivilegeDao 物业人员权限
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16
 */
@Repository
public interface EmployeePrivilegeDao {
	
	int insertEmployeePrivilege(EmployeePrivilege employeePrivilege);
	
	int insertEmployeePrivilegeBatch(List<EmployeePrivilege> list);
	
	int updateEmployeePrivilegeById(EmployeePrivilege employeePrivilege);
	
	int deleteEmployeePrivilegeById(@Param("privilegeId") String privilegeId);

 	EmployeePrivilege getEmployeePrivilegeById(@Param("privilegeId") String privilegeId);

 	List<EmployeePrivilege> getEmployeePrivileges(@Param("employeePrivilege") EmployeePrivilege employeePrivilege);
 	
 	List<EmployeePrivilege> getEmployeePrivilegesByConditions(@Param("conditions") List<QueryCondition> conditions);

	/**
	 * 查询roleId对应的权限
	 * @param roleId
	 * @return
     */
	List<EmployeePrivilege> getPrivilegesByRoleId(@Param("roleId")String roleId,@Param("privilegeType")String privilegeType);

	List<EmployeePrivilege> getPrivilegesByRoleIdAndParentId(@Param("roleId")String roleId,@Param("privilegeType")String privilegeType,@Param("parentId")String parentId);

	/**
	 * 查询所有系统权限
	 * @return
	 */
	List<EmployeePrivilege> findSystems(@Param("roleId") String roleId);

	/**
	 * 根据父Id查询所有接口权限ID
	 * @param ids
	 * @return
     */
	List<String> findPriIdByParentIds(List<String> ids);
}
