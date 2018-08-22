package com.bdcourtyard.business.account.service;

import basic.common.core.dto.PageDto;
import com.bdcourtyard.business.account.domain.*;
import com.bdcourtyard.business.account.model.CompanyEmployee;
import com.bdcourtyard.business.common.model.SystemFile;
import com.bdcourtyard.common.page.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 *  CompanyEmployeeService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16 
 */
public interface CompanyEmployeeService {
	
	int insertCompanyEmployee(CompanyEmployee companyEmployee);
	
	int insertCompanyEmployeeBatch(List<CompanyEmployee> list);
	
	int updateCompanyEmployeeById(CompanyEmployee companyEmployee);
	
	int deleteCompanyEmployeeById(String employeeId);

 	CompanyEmployee getCompanyEmployeeById(String employeeId);

 	Page<FindAllEmpResp> getCompanyEmployeesForPage(FindEmpListReq findEmpListReq, String estateId, Pageable pageable);

	/**
	 * <p>
	 * 上传照片
	 * </p>
	 * Author: Xia.yx <br/>
	 * Date: 2018/7/16
	 *
	 * */
	UploadPicResp uploadPic(MultipartFile picture);

	/**
	 * <p>
	 * 添加档案
	 * </p>
	 * Author: Xia.yx <br/>
	 * Date: 2018/7/16
	 */
	void addEmployee(CompanyEmployee employee,String estateId);

	/**
	 * 批量删除人员档案
	 * @param empIds
     */
	void deleteEmps(String empIds);

	/**
	 * 查看人员档案详情
	 * @param employeeId
	 * @return
     */
	FindEmpResp findEmployee(String employeeId);

	/**
	 * 修改档案信息
	 * @param employee
	 * @return
	 */
	void updateEmployee(CompanyEmployee employee,String estateId);

	List<FindEmpResp> exportEmp(ExportEmpReq empReq, String estateId);
}
