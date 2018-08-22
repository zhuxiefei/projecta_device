package com.bdcourtyard.business.estate.service;

import basic.common.core.dto.PageDto;
import com.bdcourtyard.business.estate.model.EstateStartPage;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 *  EstateStartPageService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-19 
 */
public interface EstateStartPageService {
	
	int insertEstateStartPage(EstateStartPage estateStartPage);
	
	int insertEstateStartPageBatch(List<EstateStartPage> list);
	
	int updateEstateStartPageById(EstateStartPage estateStartPage);
	
	int deleteEstateStartPageById(String pageId);

 	EstateStartPage getEstateStartPageById(String pageId);
 
 	List<EstateStartPage> getEstateStartPages(EstateStartPage estateStartPage);

 	PageDto<EstateStartPage> getEstateStartPagesForPage(EstateStartPage estateStartPage, Pageable pageable);

	String findPages(Integer appType);
}
