package com.bdcourtyard.business.onlineHouse.service.impl;
import com.bdcourtyard.business.housing.model.AssistantHouse;
import com.bdcourtyard.common.page.Page;
import com.bdcourtyard.business.onlineHouse.model.AoConditionReq;
import com.bdcourtyard.business.onlineHouse.service.AssistantOnlineHouseService;
import com.bdcourtyard.business.onlineHouse.dao.AssistantOnlineHouseDao;
import com.bdcourtyard.business.onlineHouse.model.AssistantOnlineHouse;
import basic.common.core.dto.PageDto;

import com.bdcourtyard.common.mybatis.QueryCondition;
import com.mysql.jdbc.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageHelper;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;

/**
 *  AssistantOnlineHouseServiceImpl
 *
 * @version : Ver 1.0
 * @date	: 2018-7-17 
 */
@Transactional
@Service
public class AssistantOnlineHouseServiceImpl  implements AssistantOnlineHouseService {
	private static Logger log = Logger.getLogger(AssistantOnlineHouseServiceImpl.class);
	
	@Autowired
	private AssistantOnlineHouseDao assistantOnlineHouseDao;
	
	public int insertAssistantOnlineHouse(AssistantOnlineHouse assistantOnlineHouse){
		return assistantOnlineHouseDao.insertAssistantOnlineHouse(assistantOnlineHouse);
	}
	public int insertAssistantOnlineHouseBatch(List<AssistantOnlineHouse> list){
		return assistantOnlineHouseDao.insertAssistantOnlineHouseBatch(list);
	}
	public int updateAssistantOnlineHouseById(AssistantOnlineHouse assistantOnlineHouse){
		return assistantOnlineHouseDao.updateAssistantOnlineHouseById(assistantOnlineHouse);
	}
	public boolean deleteAssistantOnlineHouseById(  String onlineId  ){
		try {
			String[] ids = onlineId.split(",");
			for (String id : ids) {
				if(id!=null&&!("".equals(id))){
					assistantOnlineHouseDao.deleteAssistantOnlineHouseById(id);
				}
			}
			return true;
		}catch (Exception e){
			log.error("",e);
			return  false;
		}
	}
	public AssistantOnlineHouse getAssistantOnlineHouseById(  String onlineId  ){
		return assistantOnlineHouseDao.getAssistantOnlineHouseById(  onlineId  );
	}
 
 	public List<AssistantOnlineHouse> getAssistantOnlineHouses(AssistantOnlineHouse assistantOnlineHouse){
		return assistantOnlineHouseDao.getAssistantOnlineHouses(assistantOnlineHouse);

 	}

 	//户型名称不重复
	public List<AssistantOnlineHouse> selectAllAssistantOnlineHouses(String houseType){
 		return assistantOnlineHouseDao.selectAllAssistantOnlineHouses(houseType);
 	}

 	public Page<AssistantOnlineHouse> getAssistantOnlineHousesForPage(AoConditionReq aoConditionReq, Pageable pageable){
		/*List<QueryCondition> qcs = new ArrayList<QueryCondition>();
		if(!StringUtils.isNullOrEmpty(aoConditionReq.getHouseType())){
			qcs.add(new QueryCondition("houseType",aoConditionReq.getHouseType(), QueryCondition.TYPE_LIKE));
		}
		if(!StringUtils.isNullOrEmpty(aoConditionReq.getStartTime())){
			qcs.add(new QueryCondition("createTime",aoConditionReq.getStartTime(),QueryCondition.TYPE_MORE_THEN));
		}

		if(!StringUtils.isNullOrEmpty(aoConditionReq.getEndTime())){
			qcs.add(new QueryCondition("createTime",aoConditionReq.getEndTime(),QueryCondition.TYPE_LES_THEN));
		}*/

		long count = assistantOnlineHouseDao.getAssistantOnlineHouses_new(aoConditionReq).size();
			PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
			List<AssistantOnlineHouse> assistantOnlineHouses = assistantOnlineHouseDao.getAssistantOnlineHouses_new(aoConditionReq);
		Page<AssistantOnlineHouse> pageDto = new Page<AssistantOnlineHouse>();
		if (assistantOnlineHouses != null) {
			pageDto.setRows( assistantOnlineHouses);
			pageDto.setTotal(count);
			pageDto.setPage(pageable.getPageNumber());
			pageDto.setPageSize(pageable.getPageSize());
		} else {
			pageDto.setRows(new ArrayList<AssistantOnlineHouse>());
			pageDto.setTotal(0l);
			pageDto.setPage(pageable.getPageNumber());
			pageDto.setPageSize(pageable.getPageSize());
		}
			
			return pageDto;
 	}
}
