package com.bdcourtyard.business.housesell.dao;
import com.bdcourtyard.business.housesell.model.Housesell;
import com.bdcourtyard.business.housesell.vo.HousePriceDiscountVo;
import com.bdcourtyard.business.housesell.vo.HousePriceVo;
import com.bdcourtyard.business.housesell.vo.HouseSellDetailVo;
import com.bdcourtyard.business.housesell.vo.HouseTypeVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.bdcourtyard.common.mybatis.QueryCondition;

/**
 *  HousesellDao 房屋
 *
 * @version : Ver 1.0
 * @date	: 2018-7-24
 */
@Repository
public interface HousesellDao {

	int insertHousesell(Housesell housesell);

	int insertHousesellBatch(List<Housesell> list);

	int updateHousesellById(Housesell housesell);

	int deleteHousesellById(@Param("houseId") String houseId);

	Housesell getHousesellById(@Param("houseId") String houseId);

	List<Housesell> getHousesells(@Param("housesell") Housesell housesell);

	List<Housesell> getHousesellsForPage_new(Housesell housesell);

	List<Housesell> getHousesellsByConditions(@Param("conditions") List<QueryCondition> conditions);

	List<HouseTypeVo> getAllHouseType(@Param("estateId") String estateId);

	HouseSellDetailVo getHouseSellDetail(@Param("houseId") String houseId);

	List<HousePriceVo> getHousePrice(HouseSellDetailVo houseSellDetailVo);

	HousePriceDiscountVo getHousePriceDiscount(@Param("discountId") String discountId);

	List<HousePriceVo> getsaleHousePrice(@Param("houseId") String houseId);

	List<HousePriceDiscountVo> getsaleHousePriceDiscount (@Param("houseId") String houseId);

}
