package com.bdcourtyard.business.estate.service;

import basic.common.core.dto.PageDto;
import com.bdcourtyard.business.account.model.EmployeePrivilege;
import com.bdcourtyard.business.estate.domain.FindEstatesResp;
import com.bdcourtyard.business.estate.domain.FindPrivilegesResp;
import com.bdcourtyard.business.estate.model.EstateEstate;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 *  EstateEstateService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16 
 */
public interface EstateEstateService {
	
	int insertEstateEstate(EstateEstate estateEstate);
	
	int insertEstateEstateBatch(List<EstateEstate> list);
	
	int updateEstateEstateById(EstateEstate estateEstate);
	
	int deleteEstateEstateById(String estateId);

 	EstateEstate getEstateEstateById(String estateId);
 
 	List<EstateEstate> getEstateEstates(EstateEstate estateEstate);

 	PageDto<EstateEstate> getEstateEstatesForPage(EstateEstate estateEstate, Pageable pageable);

	List<FindEstatesResp> findEstates(String acctName);

	FindPrivilegesResp findPri(String acctName, String estateId);
}
