package com.bdcourtyard.business.housesell.service;
import com.bdcourtyard.business.housesell.vo.HouseSellDetailVo;
import com.bdcourtyard.business.housesell.vo.HouseTypeVo;
import org.springframework.data.domain.Pageable;
import com.bdcourtyard.business.housesell.model.Housesell;
import java.util.List;
import com.bdcourtyard.common.page.Page;

/**
 *  HousesellService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-24 
 */
public interface HousesellService {
	
	int insertHousesell(Housesell housesell);
	
	int insertHousesellBatch(List<Housesell> list);
	
	int updateHousesellById(Housesell housesell);
	
	int deleteHousesellById(String houseId);
	
 	Housesell getHousesellById(String houseId);
 
 	List<Housesell> getHousesells(Housesell housesell);

 	Page<Housesell> getHousesellsForPage(Housesell housesell, Pageable pageable);

	Page<Housesell> getHousesellsForPage_new(Housesell housesell, Pageable pageable);

	List<HouseTypeVo> getAllHouseType(String estateId);

	HouseSellDetailVo getHouseSellDetail(String houseId);
}
