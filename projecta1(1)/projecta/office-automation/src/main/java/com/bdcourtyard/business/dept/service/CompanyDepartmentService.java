package com.bdcourtyard.business.dept.service;

import basic.common.core.dto.PageDto;
import com.bdcourtyard.business.dept.model.*;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

/**
 *  CompanyDepartmentService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-13 
 */
public interface CompanyDepartmentService {
	
	int insertCompanyDepartment(CompanyDepartment companyDepartment);
	
	int insertCompanyDepartmentBatch(List<CompanyDepartment> list);
	
	int updateCompanyDepartmentById(CompanyDepartment companyDepartment);
	
	int deleteCompanyDepartmentById(String departmentId);

 	CompanyDepartment getCompanyDepartmentById(String departmentId);
 
 	List<CompanyDepartment> getCompanyDepartments(CompanyDepartment companyDepartment);

 	PageDto<CompanyDepartment> getCompanyDepartmentsForPage(CompanyDepartment companyDepartment, Pageable pageable);

	/**
	 * 新增部门
	 *
	 * @param deptReq
	 * @return
	 */
	CompanyDepartment addDept(DeptReq deptReq,String estateId);

	/**
	 * 修改部门
	 * @param deptReq
	 * @param estateId
     */
	void updateDept(UpdateDeptReq deptReq,String estateId);

	/**
	 * 删除部门
	 * @param deptReq
	 * @param estateId
     */
	void deleteDept(DeleteDeptReq deptReq,String estateId);

	/**
	 * 查询部门详情
	 * @param departmentId
	 * @return
     */
	CompanyDepartment findDeptDetail(String departmentId);

	/**
	 * 查询父部门列表
	 * @param estateId
	 * @return
     */
	List<FindDeptListResp> findParentDeptList(String estateId);

	/**
	 * 查询子部门列表
	 * @param departmentId
	 * @return
	 */
	List<FindDeptListResp> findChildrenDeptList(String departmentId);
}
