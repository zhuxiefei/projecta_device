package com.bdcourtyard.business.estate.service.impl;

import basic.common.core.dto.PageDto;
import com.bdcourtyard.business.estate.dao.EstateStartPageDao;
import com.bdcourtyard.business.estate.model.EstateStartPage;
import com.bdcourtyard.business.estate.service.EstateStartPageService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *  EstateStartPageServiceImpl
 *
 * @version : Ver 1.0
 * @date	: 2018-7-19 
 */
@Service
public class EstateStartPageServiceImpl implements EstateStartPageService {
	
	@Autowired
	private EstateStartPageDao estateStartPageDao;
	
	public int insertEstateStartPage(EstateStartPage estateStartPage){
		return estateStartPageDao.insertEstateStartPage(estateStartPage);
	}
	public int insertEstateStartPageBatch(List<EstateStartPage> list){
		return estateStartPageDao.insertEstateStartPageBatch(list);
	}
	public int updateEstateStartPageById(EstateStartPage estateStartPage){
		return estateStartPageDao.updateEstateStartPageById(estateStartPage);
	}
	public int deleteEstateStartPageById(  String pageId  ){
		return estateStartPageDao.deleteEstateStartPageById(  pageId  );
	}
	public EstateStartPage getEstateStartPageById(String pageId  ){
		return estateStartPageDao.getEstateStartPageById(  pageId  );
	}
 
 	public List<EstateStartPage> getEstateStartPages(EstateStartPage estateStartPage){
		return estateStartPageDao.getEstateStartPages(estateStartPage);

 	}

 	public PageDto<EstateStartPage> getEstateStartPagesForPage(EstateStartPage estateStartPage, Pageable pageable){
 		
 		 long count = estateStartPageDao.getEstateStartPages(estateStartPage).size();
			PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
			List<EstateStartPage> estateStartPages = estateStartPageDao.getEstateStartPages(estateStartPage);
			 
			PageDto<EstateStartPage> pageDto = new PageDto<EstateStartPage>();
			
			if (estateStartPages != null) {
				pageDto.setRows( estateStartPages);
				pageDto.setTotal(count);
			} else {
				pageDto.setRows(new ArrayList<EstateStartPage>());
				pageDto.setTotal(0l);
			}
			
			return pageDto;
 	}

	@Override
	public String findPages(Integer appType) {
		List<String> list = estateStartPageDao.findPages(appType);
		if (null != list && list.size() > 0){
			Random random = new Random();
			int result=random.nextInt(list.size());
			return list.get(result);
		}
		return null;
	}
}