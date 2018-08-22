package com.bdcourtyard.business.dept.service;

import basic.common.core.dto.PageDto;
import com.bdcourtyard.business.dept.model.CompanyCompany;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 *  CompanyCompanyService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-13 
 */
public interface CompanyCompanyService {
	
	int insertCompanyCompany(CompanyCompany companyCompany);
	
	int insertCompanyCompanyBatch(List<CompanyCompany> list);
	
	int updateCompanyCompanyById(CompanyCompany companyCompany);
	
	int deleteCompanyCompanyById(String companyId);

 	CompanyCompany getCompanyCompanyById(String companyId);
 
 	List<CompanyCompany> getCompanyCompanys(CompanyCompany companyCompany);

 	PageDto<CompanyCompany> getCompanyCompanysForPage(CompanyCompany companyCompany, Pageable pageable);
}
