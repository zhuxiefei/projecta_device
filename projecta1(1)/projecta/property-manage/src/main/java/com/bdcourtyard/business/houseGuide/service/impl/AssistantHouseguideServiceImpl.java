package com.bdcourtyard.business.houseGuide.service.impl;

import basic.common.core.dto.PageDto;
import com.bdcourtyard.business.houseGuide.dao.AssistantHouseguideDao;
import com.bdcourtyard.business.houseGuide.model.AssistantHouseguide;
import com.bdcourtyard.business.houseGuide.model.GetAssistantHouseguidesForPageReq;
import com.bdcourtyard.business.houseGuide.service.AssistantHouseguideService;
import com.bdcourtyard.common.page.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *  AssistantHouseguideServiceImpl
 *
 * @version : Ver 1.0
 * @date	: 2018-7-19
 */
@Service
public class AssistantHouseguideServiceImpl  implements AssistantHouseguideService {

	@Autowired
	private AssistantHouseguideDao assistantHouseguideDao;

	public int insertAssistantHouseguide(AssistantHouseguide assistantHouseguide){
		return assistantHouseguideDao.insertAssistantHouseguide(assistantHouseguide);
	}
	public int insertAssistantHouseguideBatch(List<AssistantHouseguide> list){
		return assistantHouseguideDao.insertAssistantHouseguideBatch(list);
	}
	public int updateAssistantHouseguideById(AssistantHouseguide assistantHouseguide){
		return assistantHouseguideDao.updateAssistantHouseguideById(assistantHouseguide);
	}
	public void deleteAssistantHouseguideByIds(  String guideIds  ){
		String[] ids = guideIds.split(",");

		for(String id:ids) {
			assistantHouseguideDao.deleteAssistantHouseguideById(  id  );
		}

	}
	public AssistantHouseguide getAssistantHouseguideById(String guideId  ){
		return assistantHouseguideDao.getAssistantHouseguideById(  guideId  );
	}

	@Override
	public Page<AssistantHouseguide> getAssistantHouseguides(String estateId, Pageable pageable) {
		long count = assistantHouseguideDao.findByEstateId(estateId).size();
		PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
		List<AssistantHouseguide> list = assistantHouseguideDao.findByEstateId(estateId);

		Page<AssistantHouseguide> pageDto = new Page<>();
        pageDto.setPage(pageable.getPageNumber());
        pageDto.setPageSize(pageable.getPageSize());

        if (list != null) {
			pageDto.setRows(list);
			pageDto.setTotal(count);
		} else {
			pageDto.setRows(new ArrayList<AssistantHouseguide>());
			pageDto.setTotal(0l);
		}

		return pageDto;
	}

	public Page<AssistantHouseguide> getAssistantHouseguidesForPage(GetAssistantHouseguidesForPageReq getAssistantHouseguidesForPageReq, Pageable pageable){

 		 long count = assistantHouseguideDao.getAssistantHouseguidesForPage(getAssistantHouseguidesForPageReq).size();
			PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
			List<AssistantHouseguide> assistantHouseguides = assistantHouseguideDao.getAssistantHouseguidesForPage(getAssistantHouseguidesForPageReq);

			Page<AssistantHouseguide> pageDto = new Page<AssistantHouseguide>();

			if (assistantHouseguides != null) {
				pageDto.setPage(pageable.getPageNumber());
				pageDto.setPageSize(pageable.getPageSize());
				pageDto.setRows( assistantHouseguides);
				pageDto.setTotal(count);
			} else {
				pageDto.setRows(new ArrayList<AssistantHouseguide>());
				pageDto.setTotal(0l);
				pageDto.setPage(pageable.getPageNumber());
				pageDto.setPageSize(pageable.getPageSize());
			}

			return pageDto;
 	}
}
