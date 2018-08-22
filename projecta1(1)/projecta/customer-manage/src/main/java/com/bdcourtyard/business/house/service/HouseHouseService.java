package com.bdcourtyard.business.house.service;

import com.bdcourtyard.business.house.domain.*;
import com.bdcourtyard.business.house.model.HouseHouse;
import com.bdcourtyard.business.houseprice.vo.HouseOrTypePage;
import com.bdcourtyard.business.housetype.model.HouseType;
import com.bdcourtyard.common.page.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *  HouseHouseService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-23 
 */
public interface HouseHouseService {
	
	int insertHouseHouse(HouseHouse houseHouse, HttpServletRequest request);

	List<ImportMsg> insertHouseHouseBatch(MultipartFile multipartFile, HttpServletRequest request);
	
	int updateHouseHouseById(HouseHouse houseHouse, HttpServletRequest request);
	
	int deleteHouseHouseById(String houseId);

	FindHouseResp getHouseHouseById(String houseId);

 	Page<FindAllHousesResp> getHouseHousesForPage(FindAllHousesReq housesReq, Pageable pageable,HttpServletRequest request);

	List<HouseType> findAllTypes(HttpServletRequest request);

	List<FindAllHousesResp> exportHouses(FindAllHousesReq housesReq,HttpServletRequest request);

	void updateOpenTime(UpdateOpenTimeReq timeReq);

	//根据楼宇id和单元的id获取房屋的信息
	List<HouseOrTypePage> getHouseOrtypes(String buildingId, String unitId  );

}
