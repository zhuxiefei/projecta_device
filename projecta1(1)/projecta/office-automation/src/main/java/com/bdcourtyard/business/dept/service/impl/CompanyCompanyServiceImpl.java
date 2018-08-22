package com.bdcourtyard.business.dept.service.impl;

import basic.common.core.dto.PageDto;
import com.bdcourtyard.business.dept.dao.CompanyCompanyDao;
import com.bdcourtyard.business.dept.model.CompanyCompany;
import com.bdcourtyard.business.dept.service.CompanyCompanyService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *  CompanyCompanyServiceImpl
 *
 * @version : Ver 1.0
 * @date	: 2018-7-13 
 */
@Service
public class CompanyCompanyServiceImpl  implements CompanyCompanyService { 
	
	@Autowired
	private CompanyCompanyDao companyCompanyDao;
	
	public int insertCompanyCompany(CompanyCompany companyCompany){
		return companyCompanyDao.insertCompanyCompany(companyCompany);
	}
	public int insertCompanyCompanyBatch(List<CompanyCompany> list){
		return companyCompanyDao.insertCompanyCompanyBatch(list);
	}
	public int updateCompanyCompanyById(CompanyCompany companyCompany){
		return companyCompanyDao.updateCompanyCompanyById(companyCompany);
	}
	public int deleteCompanyCompanyById(  String companyId  ){
		return companyCompanyDao.deleteCompanyCompanyById(  companyId  );
	}
	public CompanyCompany getCompanyCompanyById(  String companyId  ){
		return companyCompanyDao.getCompanyCompanyById(  companyId  );
	}
 
 	public List<CompanyCompany> getCompanyCompanys(CompanyCompany companyCompany){
		return companyCompanyDao.getCompanyCompanys(companyCompany);

 	}

 	public PageDto<CompanyCompany> getCompanyCompanysForPage(CompanyCompany companyCompany, Pageable pageable){
 		
 		 long count = companyCompanyDao.getCompanyCompanys(companyCompany).size();
			PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
			List<CompanyCompany> companyCompanys = companyCompanyDao.getCompanyCompanys(companyCompany);
			 
			PageDto<CompanyCompany> pageDto = new PageDto<CompanyCompany>();
			
			if (companyCompanys != null) {
				pageDto.setRows( companyCompanys);
				pageDto.setTotal(count);
			} else {
				pageDto.setRows(new ArrayList<CompanyCompany>());
				pageDto.setTotal(0l);
			}
			
			return pageDto;
 	}
}
