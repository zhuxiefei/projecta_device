package com.bdcourtyard.business.housetype.service;

import com.bdcourtyard.business.housetype.domain.*;
import com.bdcourtyard.business.housetype.model.HouseType;
import com.bdcourtyard.common.page.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *  HouseTypeService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-23 
 */
public interface HouseTypeService {
	
	int insertHouseType(AddTypeReq typeReq, HttpServletRequest request);
	
	int insertHouseTypeBatch(List<HouseType> list);
	
	int updateHouseTypeById(AddTypeReq typeReq,HttpServletRequest request);
	
	int deleteHouseTypeById(String typeId);

 	FindTypeResp getHouseTypeById(String typeId);

 	Page<FindAllTypesResp> getHouseTypesForPage(FindAllTypesReq typesReq, Pageable pageable,HttpServletRequest request);

	UploadPicResp uploadPic(MultipartFile file);
}
