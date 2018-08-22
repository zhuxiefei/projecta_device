package com.bdcourtyard.business.dept.dao;

import com.bdcourtyard.business.dept.model.CompanyDepartment;
import com.bdcourtyard.business.dept.model.DeleteDeptReq;
import com.bdcourtyard.common.mybatis.QueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  CompanyDepartmentDao 企业部门
 *
 * @version : Ver 1.0
 * @date	: 2018-7-13
 */
@Repository
public interface CompanyDepartmentDao {
	
	int insertCompanyDepartment(CompanyDepartment companyDepartment);
	
	int insertCompanyDepartmentBatch(List<CompanyDepartment> list);
	
	int updateCompanyDepartmentById(CompanyDepartment companyDepartment);
	
	int deleteCompanyDepartmentById(@Param("departmentId") String departmentId);

 	CompanyDepartment getCompanyDepartmentById(@Param("departmentId") String departmentId);

 	List<CompanyDepartment> getCompanyDepartments(@Param("companyDepartment") CompanyDepartment companyDepartment);
 	
 	List<CompanyDepartment> getCompanyDepartmentsByConditions(@Param("conditions") List<QueryCondition> conditions);

	/**
	 * 查询最新的一级部门
	 * @return
	 */
	CompanyDepartment findNewestOneDepth(@Param("estateId")String estateId);

	/**
	 * 查询同级部门是否重复
	 * @param name
	 * @param parentId
	 * @return
	 */
	CompanyDepartment findByParentIdAndName(@Param("name") String name,
									 @Param("parentId") String parentId,
									 @Param("estateId") String estateId);

	/**
	 * 根据parentId查询子部门
	 * @param parentId
	 * @return
	 */
	List<CompanyDepartment> findByParentId(String parentId);

	/**
	 * 查询同一部门下的所有子部门名称是否重复
	 * @param name
	 * @param depId
	 * @return
	 */
	CompanyDepartment findByNameAndDepId(@Param("name") String name,@Param("depId") String depId);

	/**
	 * 根据规则ID和深度删除该部门和下级部门
	 */
	void deleteByDepIdAndDepth(@Param("depId") String depId, @Param("depth") Integer depth);

	/**
	 * 查询部门详情
	 *
	 * @param departmentId
	 * @return
	 */
	CompanyDepartment findDeptDetail(String departmentId);

	/**
	 * 查询部门列表
	 *
	 * @return
	 */
	List<CompanyDepartment> findParentDeptList(String estateId);
}
