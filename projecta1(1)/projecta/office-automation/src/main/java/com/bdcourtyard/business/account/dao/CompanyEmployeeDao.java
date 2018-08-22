package com.bdcourtyard.business.account.dao;

import com.bdcourtyard.business.account.domain.*;
import com.bdcourtyard.business.account.model.CompanyEmployee;
import com.bdcourtyard.business.contact.domain.FindEmployeeResp;
import com.bdcourtyard.common.mybatis.QueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  CompanyEmployeeDao 企业员工
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16
 */
@Repository
public interface CompanyEmployeeDao {
	
	int insertCompanyEmployee(CompanyEmployee companyEmployee);
	
	int insertCompanyEmployeeBatch(List<CompanyEmployee> list);
	
	int updateCompanyEmployeeById(CompanyEmployee companyEmployee);
	
	int deleteCompanyEmployeeById(@Param("employeeId") String employeeId);

 	CompanyEmployee getCompanyEmployeeById(@Param("employeeId") String employeeId);

 	List<FindAllEmpResp> getCompanyEmployees(FindAllEmpDaoReq empReq);
 	
 	List<CompanyEmployee> getCompanyEmployeesByConditions(@Param("conditions") List<QueryCondition> conditions);

	/**
	 * 条件查询该部门和下级部门的员工
	 *
	 * @param depId 规则ID
	 * @param type  1代表排除没有账号的员工  2代表不排除
	 * @return
	 */
	List<CompanyEmployee> findByDepIdAndType(@Param("depId") String depId,
									  @Param("type") Integer type,
									  @Param("estateId") String estateId);

	/**
	 * 根据人员的手机号查询
	 * @param phone
	 * @param estateId
     * @return
     */
	List<CompanyEmployee> selectByPhone(@Param("phone") String phone,@Param("estateId") String estateId);

	/**
	 * 根据编号查询档案信息
	 * @param employeeNo
	 * @param estateId
     * @return
     */
	CompanyEmployee selectByEmployeeNum(@Param("employeeNo") String employeeNo,@Param("estateId") String estateId);

	/**
	 * 批量删除人员档案
	 * @param ids
     */
	void deleteByEmpIds(String[] ids);

	/**
	 * 根据empId查询
	 * @param empId
	 * @return
     */
	FindEmpResp selectByEmpId(String empId);

	/**
	 * 修改人员档案
	 * @param record
	 * @return
     */
	int updateByPrimaryKeySelective(CompanyEmployee record);

	/**
	 * 根据多个人员ID查询人员信息
	 * @param empIds
	 * @return
     */
	List<FindEmpResp> selectByEmpIds(String[] empIds);

	/**
	 * 根据筛选条件查询
	 * @param daoReq
	 * @return
     */
	List<FindEmpResp> selectByParams(ExportEmpDaoReq daoReq);

	/**
	 * 根据部门ID查询人员
	 * @param departmentId
	 * @return
     */
	List<FindEmpByDeptResp> selectByDepartmentId(String departmentId);

	/**
	 * 根据roleID查询
	 * @param roleId
	 * @return
     */
	List<CompanyEmployee> findEmpByRoleId(String roleId);

	CompanyEmployee findByAcctNameAndEstateId(@Param("acctName") String acctName,@Param("estateId") String estateId);

	/**
	 * 查询部门下有多少员工
	 *
	 * @param depId
	 * @return
	 */
	int findEmpNumUnderDepart(@Param("depId") String depId,
							  @Param("estateId") String estateId);

	/**
	 * 查询绑定该部门的所有员工
	 *
	 * @param departmentId
	 * @return
	 */
	List<CompanyEmployee> findByDepartmentId(String departmentId);

	FindEmployeeResp findEmployee(String employeeId);
}
