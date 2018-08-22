package com.bdcourtyard.business.account.dao;

import com.bdcourtyard.business.account.model.EmployeeRole;
import com.bdcourtyard.common.mybatis.QueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  EmployeeRoleDao 物业人员角色
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16
 */
@Repository
public interface EmployeeRoleDao {
	
	int insertEmployeeRole(EmployeeRole employeeRole);
	
	int insertEmployeeRoleBatch(List<EmployeeRole> list);
	
	int updateEmployeeRoleById(EmployeeRole employeeRole);
	
	int deleteEmployeeRoleById(@Param("roleId") String roleId);

 	EmployeeRole getEmployeeRoleById(@Param("roleId") String roleId);

 	List<EmployeeRole> getEmployeeRoles(@Param("roleName") String roleName,
										@Param("estateId") String estateId);
 	
 	List<EmployeeRole> getEmployeeRolesByConditions(@Param("conditions") List<QueryCondition> conditions);

	/**
	 * 根据角色名称查询角色信息
	 * @param roleName
	 * @param estateId
     * @return
     */
	EmployeeRole findRoleIsExistence(@Param("roleName") String roleName,@Param("estateId") String estateId);

	void updateByPrimaryKeySelective(EmployeeRole employeeRole);
}
