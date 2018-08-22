package com.bdcourtyard.business.subscription.dao;
import com.bdcourtyard.business.returncust.model.ControlClientEntering;
import com.bdcourtyard.business.subscription.model.RoomsourceSubscription;
import com.bdcourtyard.business.subscription.vo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import com.bdcourtyard.common.mybatis.QueryCondition;

/**
 *  RoomsourceSubscriptionDao 客户认购信息
 *
 * @version : Ver 1.0
 * @date	: 2018-7-24
 */
@Repository
public interface RoomsourceSubscriptionDao {

	int insertRoomsourceSubscription(RoomsourceSubscription roomsourceSubscription);

	int insertRoomsourceSubscriptionBatch(List<RoomsourceSubscription> list);

	int updateRoomsourceSubscriptionById(RoomsourceSubscription roomsourceSubscription);

	int deleteRoomsourceSubscriptionById(@Param("subscriptionId") String subscriptionId);

	RoomsourceSubscription getRoomsourceSubscriptionById(@Param("houseId") String houseId);

	List<RoomsourceSubscription> getRoomsourceSubscriptions(@Param("roomsourceSubscription") RoomsourceSubscription roomsourceSubscription);

	List<RoomsourceSubscription> getRoomsourceSubscriptionsByConditions(@Param("conditions") List<QueryCondition> conditions);

	List<HousesubVo> getHousesubForPage_new(HousesubVo housesubVo);

	//退房操作 start
	int cancelHouseState1(@Param("houseId") String houseId);
	int cancelHouseState2(@Param("houseId") String houseId);
	int cancelHouseState3(@Param("houseId") String houseId);
	int updateHouseStatus(@Param("houseId") String houseId);
	//退房操作 end


	List<SubInformatiomVo> getMeaasgeByName(HashMap map);

	int updateClientById(SubInformatiomVo subInformatiomVo);

	int insertClient(SubInformatiomVo subInformatiomVo);

	//选购
	int insertSub_xg(SubInformatiomVo subInformatiomVo);

	HouseVo getHouseVoById(@Param("houseId") String houseId);

	/**
	 * 通用
	 * @param subInformatiomVo
	 * @return
	 */
	int updateStatus(SubInformatiomVo subInformatiomVo);

	int updateSub_rg(SubInformatiomVo subInformatiomVo);

	int updateSub_ht(SubInformatiomVo subInformatiomVo);
	int insertSalePrice(SalePriceVo salePriceVo);
	int insertSaleDiscount(SaleDiscountVo saleDiscountVo);
}
