package com.bdcourtyard.business.housing.service.impl;  
import com.bdcourtyard.business.housing.dao.AssistantHousefileDao;
import com.bdcourtyard.business.housing.domain.FindHouseMsgInfoResp;
import com.bdcourtyard.business.housing.domain.FindHouseMsgsResp;
import com.bdcourtyard.business.housing.model.AoSelectConditionReq;
import com.bdcourtyard.business.housing.service.AssistantHouseService;
import com.bdcourtyard.business.housing.dao.AssistantHouseDao;
import com.bdcourtyard.business.housing.model.AssistantHouse;
import com.bdcourtyard.common.page.Page;

import com.bdcourtyard.business.onlineHouse.model.AssistantOnlineHouse;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.mybatis.QueryCondition;
import com.bdcourtyard.common.page.Page;
import com.bdcourtyard.common.utils.PropertiesUtil;
import com.github.pagehelper.PageInfo;
import com.mysql.jdbc.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import org.springframework.transaction.annotation.Transactional;

/**
 *  AssistantHouseServiceImpl
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16 
 */
@Transactional
@Service
public class AssistantHouseServiceImpl  implements AssistantHouseService {

	private static Logger log = Logger.getLogger(AssistantHouseServiceImpl.class);
	
	@Autowired
	private AssistantHouseDao assistantHouseDao;

	@Autowired
	private AssistantHousefileDao houseFileDao;
	
	public int insertAssistantHouse(AssistantHouse assistantHouse){
		return assistantHouseDao.insertAssistantHouse(assistantHouse);
	}
	public int insertAssistantHouseBatch(List<AssistantHouse> list){
		return assistantHouseDao.insertAssistantHouseBatch(list);
	}
	public int updateAssistantHouseById(AssistantHouse assistantHouse){
		System.out.println(assistantHouseDao.updateAssistantHouseById(assistantHouse)+"~!!");
		return assistantHouseDao.updateAssistantHouseById(assistantHouse);
	}
	public boolean deleteAssistantHouseById(  String propertyId  ){
		try {
			String[] ids = propertyId.split(",");
			for (String id : ids) {
				if(id==null&&"".equals(id)){
					throw new GlobalException("H0008");
				}
			}
			assistantHouseDao.deleteAssistantHouseById(ids);
			return true;
		}catch (Exception e){
			log.error("异常",e);
			return  false;
		}
	}
	public AssistantHouse getAssistantHouseById(  String propertyId  ){
		AssistantHouse a = assistantHouseDao.getAssistantHouseById(  propertyId  );
		System.out.println(a+"service");
		return assistantHouseDao.getAssistantHouseById(  propertyId  );
	}
 
 	public List<AssistantHouse> getAssistantHouses(AssistantHouse assistantHouse){
		return assistantHouseDao.getAssistantHouses(assistantHouse);

 	}

 	public Page<AssistantHouse> getAssistantHousesForPage(AoSelectConditionReq aoSelectConditionReq, Pageable pageable){
	/*	List<QueryCondition> qcs = new ArrayList<QueryCondition>();
		if(!StringUtils.isNullOrEmpty(aoSelectConditionReq.getTitle())){
			qcs.add(new QueryCondition("title",aoSelectConditionReq.getStartTime(),QueryCondition.TYPE_LIKE));
		}
		if(!StringUtils.isNullOrEmpty(aoSelectConditionReq.getAdminId())){
			qcs.add(new QueryCondition("adminId",aoSelectConditionReq.getStartTime(),QueryCondition.TYPE_LIKE));
		}
		if(!StringUtils.isNullOrEmpty(aoSelectConditionReq.getStartTime())){
			qcs.add(new QueryCondition("createTime",aoSelectConditionReq.getStartTime(),QueryCondition.TYPE_MORE_THEN));
		}
		if(!StringUtils.isNullOrEmpty(aoSelectConditionReq.getEndTime())){
			qcs.add(new QueryCondition("createTime",aoSelectConditionReq.getEndTime(),QueryCondition.TYPE_LES_THEN));
		}*/
		long count = assistantHouseDao.getAssistantHouses_new(aoSelectConditionReq).size();
		PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
		List<AssistantHouse> assistantOnlineHouses = assistantHouseDao.getAssistantHouses_new(aoSelectConditionReq);
		Page<AssistantHouse> pageDto = new Page<AssistantHouse>();
		if (assistantOnlineHouses != null) {
			pageDto.setRows( assistantOnlineHouses);
			pageDto.setTotal(count);
			pageDto.setPage(pageable.getPageNumber());
			pageDto.setPageSize(pageable.getPageSize());
		} else {
			pageDto.setRows(new ArrayList<AssistantHouse>());
			pageDto.setTotal(0l);
			pageDto.setPage(pageable.getPageNumber());
			pageDto.setPageSize(pageable.getPageSize());
		}
			return pageDto;
 	}

	@Override
	public Page<FindHouseMsgsResp> findByEstateId(String estateId, Pageable pageable) {
		long count = assistantHouseDao.findByEstateId(estateId).size();
		PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());

		List<FindHouseMsgsResp> list = assistantHouseDao.findByEstateId(estateId);
		if (null != list && list.size() > 0){
			for (FindHouseMsgsResp resp:
					list) {
				//查询有没有对应的图片
				List<String> picUrls = houseFileDao.findUrlByPropertyIdAndFileType(resp.getPropertyId(), 1);
				if (null != picUrls && picUrls.size() > 0){
					//取第一张图片
					resp.setPic(PropertiesUtil.getProperty("file.server")+picUrls.get(0));
				}
				//查询视频文件
				List<String> videos = houseFileDao.findUrlByPropertyIdAndFileType(resp.getPropertyId(),2);
				if (null != videos && videos.size() > 0){
					resp.setHasVideo("1");
				}else {
					resp.setHasVideo("2");
				}
			}
		}

		Page<FindHouseMsgsResp> pageDto = new Page<>();
		pageDto.setPage(pageable.getPageNumber());
		pageDto.setPageSize(pageable.getPageSize());

		if (list != null) {
			pageDto.setRows(list);
			pageDto.setTotal(count);
		} else {
			pageDto.setRows(new ArrayList<FindHouseMsgsResp>());
			pageDto.setTotal(0l);
		}

		return pageDto;
	}

	@Override
	public FindHouseMsgInfoResp findByPropertyId(String propertyId) {
		FindHouseMsgInfoResp info = assistantHouseDao.findByPropertyId(propertyId);
		if (null != info){
			//查询视频文件
			List<String> videos = houseFileDao.findUrlByPropertyIdAndFileType(propertyId,2);
			List<String> videoUrl = new ArrayList<>();
			List<String> videoPic = new ArrayList<>();
			if (null != videos && videos.size() > 0){
				for (String v:
					 videos) {
					v = PropertiesUtil.getProperty("file.server")+v;
					videoUrl.add(v);
					videoPic.add(v.substring(0,v.lastIndexOf("."))+".png");
				}
				info.setVideoUrl(videoUrl);
				info.setVideoPicUrl(videoPic);
			}
			//查询图片文件
			List<String> pics = houseFileDao.findUrlByPropertyIdAndFileType(propertyId,1);
			List<String> picUrl = new ArrayList<>();
			if (null != pics && pics.size() > 0){
				for (String p:
						pics) {
					picUrl.add(PropertiesUtil.getProperty("file.server")+p);
				}
				info.setPicUrl(picUrl);
			}
			return info;
		}
		return null;
	}
}
