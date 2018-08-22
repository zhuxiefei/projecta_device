package com.bdcourtyard.business.subscription.service;
import com.bdcourtyard.business.housesell.vo.HouseSellDetailVo;
import com.bdcourtyard.business.returncust.model.ControlClientEntering;
import com.bdcourtyard.business.subscription.vo.HousesubVo;
import com.bdcourtyard.business.subscription.vo.SubInformatiomVo;
import org.springframework.data.domain.Pageable;
import com.bdcourtyard.business.subscription.model.RoomsourceSubscription;
import java.util.List;
import com.bdcourtyard.common.page.Page;

/**
 *  RoomsourceSubscriptionService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-24
 */
public interface RoomsourceSubscriptionService {

	int insertRoomsourceSubscription(RoomsourceSubscription roomsourceSubscription);

	int insertRoomsourceSubscriptionBatch(List<RoomsourceSubscription> list);

	int updateRoomsourceSubscriptionById(RoomsourceSubscription roomsourceSubscription);

	int deleteRoomsourceSubscriptionById(String subscriptionId);

	RoomsourceSubscription getRoomsourceSubscriptionById(HouseSellDetailVo detail,String subscriptionId);

	List<RoomsourceSubscription> getRoomsourceSubscriptions(RoomsourceSubscription roomsourceSubscription);

	Page<HousesubVo> getRoomsourceSubscriptionsForPage(HousesubVo housesubVo, Pageable pageable);

	int cancelHouseState(String houseId);

	List<SubInformatiomVo> getMeaasgeByName(String name,String estateId);

	int insertHouseSub_xg(SubInformatiomVo subInformatiomVo);

	int insertHouseSub_rg(SubInformatiomVo subInformatiomVo);

	int insertHouseSub_ht( HouseSellDetailVo detail,SubInformatiomVo subInformatiomVo);

}
