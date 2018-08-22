package com.bdcourtyard.business.dept.dao;

import com.bdcourtyard.business.dept.model.CompanyCompany;
import com.bdcourtyard.common.mybatis.QueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  CompanyCompanyDao 企业
 *
 * @version : Ver 1.0
 * @date	: 2018-7-13
 */
@Repository
public interface CompanyCompanyDao {
	
	int insertCompanyCompany(CompanyCompany companyCompany);
	
	int insertCompanyCompanyBatch(List<CompanyCompany> list);
	
	int updateCompanyCompanyById(CompanyCompany companyCompany);
	
	int deleteCompanyCompanyById(@Param("companyId") String companyId);

 	CompanyCompany getCompanyCompanyById(@Param("companyId") String companyId);

 	List<CompanyCompany> getCompanyCompanys(@Param("companyCompany") CompanyCompany companyCompany);
 	
 	List<CompanyCompany> getCompanyCompanysByConditions(@Param("conditions") List<QueryCondition> conditions);

	CompanyCompany findOne();
}
