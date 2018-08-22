package com.bdcourtyard.business.subscription.service.impl;
import basic.common.core.id.IdUtil;
import com.bdcourtyard.business.housesell.vo.HousePriceDiscountVo;
import com.bdcourtyard.business.housesell.vo.HouseSellDetailVo;
import com.bdcourtyard.business.returncust.model.ControlClientEntering;
import com.bdcourtyard.business.subscription.service.RoomsourceSubscriptionService;
import com.bdcourtyard.business.subscription.dao.RoomsourceSubscriptionDao;
import com.bdcourtyard.business.subscription.model.RoomsourceSubscription;
import com.bdcourtyard.business.subscription.vo.*;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.pagehelper.PageHelper;
import org.springframework.transaction.annotation.Transactional;

/**
 *  RoomsourceSubscriptionServiceImpl
 *
 * @version : Ver 1.0
 * @date	: 2018-7-24
 */
@Service
@Transactional
public class RoomsourceSubscriptionServiceImpl  implements RoomsourceSubscriptionService {

	@Autowired
	private RoomsourceSubscriptionDao roomsourceSubscriptionDao;

	public int insertRoomsourceSubscription(RoomsourceSubscription roomsourceSubscription){
		return roomsourceSubscriptionDao.insertRoomsourceSubscription(roomsourceSubscription);
	}
	public int insertRoomsourceSubscriptionBatch(List<RoomsourceSubscription> list){
		return roomsourceSubscriptionDao.insertRoomsourceSubscriptionBatch(list);
	}
	public int updateRoomsourceSubscriptionById(RoomsourceSubscription roomsourceSubscription){
		return roomsourceSubscriptionDao.updateRoomsourceSubscriptionById(roomsourceSubscription);
	}
	public int deleteRoomsourceSubscriptionById(  String subscriptionId  ){
		return roomsourceSubscriptionDao.deleteRoomsourceSubscriptionById(  subscriptionId  );
	}


	public RoomsourceSubscription getRoomsourceSubscriptionById(HouseSellDetailVo detail,String houseId  ){

		//认购表中数据获取 start

		//认购表中数据获取 end
		RoomsourceSubscription sub = roomsourceSubscriptionDao.getRoomsourceSubscriptionById(houseId);



		//基本详情重新赋值 start
		if(detail==null){
			throw new GlobalException("SA049");
		}
		if(sub==null){
			sub = new RoomsourceSubscription();
		}
		if(detail.getHouseId()!=null){
			sub.setHouseId(detail.getHouseId());
		}
		if(detail.getHouseNo()!=null){
			sub.setHouseNo(detail.getHouseNo());
		}
		if(detail.getRoomName()!=null){
			sub.setRoomName(detail.getRoomName());
		}
		if(detail.getTypeName()!=null){
			sub.setTypeName(detail.getTypeName());
		}
		if(detail.getFloorArea()!=null){
			sub.setFloorArea(detail.getFloorArea());
		}
		if(detail.getInterFloorArea()!=null){
			sub.setInterFloorArea(detail.getInterFloorArea());
		}
		if(detail.getEstateType()!=null){
			sub.setEstateType(detail.getEstateType());
		}
		if(detail.getSaleStatus()!=null){
			sub.setSaleStatus(detail.getSaleStatus());
		}
		if(detail.getOrientation()!=null){
			sub.setOrientation(detail.getOrientation());
		}
		if(detail.getDecorationDegree()!=null){
			sub.setDecorationDegree(detail.getDecorationDegree());
		}
		if(detail.getBuildingId()!=null){
			sub.setBuildingId(detail.getBuildingId());
		}
		if(detail.getUnitId()!=null){
			sub.setUnitId(detail.getUnitId());
		}
		if(detail.getTypeId()!=null){
			sub.setTypeId(detail.getTypeId());
		}
		if(detail.getFileUrl()!=null){
			sub.setFileUrl(detail.getFileUrl());
		}
		if(detail.getEstateId()!=null){
			sub.setEstateId(detail.getEstateId());
		}
		if(detail.getFloor()!=null){
			sub.setFloor(detail.getFloor());
		}
		if(detail.getPrice()!=null){
			sub.setPrice(detail.getPrice());
		}
		if(detail.getTotalPrice()!=null){
			sub.setTotalPrice(detail.getTotalPrice());
		}

		if(detail.getHousePriceDiscountVo()!=null){
			sub.setHousePriceDiscountVo(detail.getHousePriceDiscountVo());
		}
		//基本详情重新赋值 end





		return sub;
	}



	public List<RoomsourceSubscription> getRoomsourceSubscriptions(RoomsourceSubscription roomsourceSubscription){
		return roomsourceSubscriptionDao.getRoomsourceSubscriptions(roomsourceSubscription);

	}

	public Page<HousesubVo> getRoomsourceSubscriptionsForPage(HousesubVo housesubVo, Pageable pageable){

		long count = roomsourceSubscriptionDao.getHousesubForPage_new(housesubVo).size();
		PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
		List<HousesubVo> roomsourceSubscriptions = roomsourceSubscriptionDao.getHousesubForPage_new(housesubVo);

		Page<HousesubVo> pageDto = new Page<HousesubVo>();
		pageDto.setPage(pageable.getPageNumber());
		pageDto.setPageSize(pageable.getPageSize());
		if (roomsourceSubscriptions != null) {
			pageDto.setRows( roomsourceSubscriptions);
			pageDto.setTotal(count);
		} else {
			pageDto.setRows(new ArrayList<HousesubVo>());
			pageDto.setTotal(0l);
		}

		return pageDto;
	}

	@Override
	public int cancelHouseState(String houseId) {
		try{
			roomsourceSubscriptionDao.cancelHouseState1(houseId);
			roomsourceSubscriptionDao.cancelHouseState2(houseId);
			roomsourceSubscriptionDao.cancelHouseState3(houseId);
			roomsourceSubscriptionDao.updateHouseStatus(houseId);
		}catch (Exception e){
			e.printStackTrace();
			throw new GlobalException("SA007");
		}

		return 1;
	}

	@Override
	public List<SubInformatiomVo> getMeaasgeByName(String name, String estateId) {
		HashMap<String ,String> map = new HashMap<String,String >();
		map.put("name",name);
		map.put("estateId",estateId);
		return roomsourceSubscriptionDao.getMeaasgeByName(map);
	}

	@Override
	public int insertHouseSub_xg(SubInformatiomVo subInformatiomVo) {
		if(subInformatiomVo==null){
			throw new GlobalException("SA001");
		}else{

			//do something 验证
			if(subInformatiomVo.getContractName()==null||"".equals(subInformatiomVo.getContractName())||subInformatiomVo.getContractName().length()>20){
				throw new GlobalException("");//客户姓名为空或长度过长
			}else{
				subInformatiomVo.setContractName(subInformatiomVo.getContractName().trim());
			}
			if(subInformatiomVo.getIdCard()==null||"".equals(subInformatiomVo.getIdCard())||subInformatiomVo.getIdCard().length()>20||!isNumeric(subInformatiomVo.getIdCard())){
				throw new GlobalException("");//客户姓名为空或长度过长
			}else{
				subInformatiomVo.setIdCard(subInformatiomVo.getIdCard().trim());
			}





			//判断是否房屋状态未变 为1 在售
			if(subInformatiomVo.getHouseId()==null||subInformatiomVo.getHouseId().equals("")){
				throw new GlobalException("SA002");
			}else{
				//
				HouseVo hv =roomsourceSubscriptionDao.getHouseVoById(subInformatiomVo.getHouseId());
				if(hv==null||hv.getHouseNo()==null){
					throw new GlobalException("SA049");
				}else{
					if(hv.getSaleStatus()==1){
					}else{
						throw new GlobalException("SA050");
					}
				}
			}



			if(subInformatiomVo.getClientId()==null||subInformatiomVo.getClientId().equals("")){//选购时没有搜索到客户信息，需新增 在选购
				String clientId = IdUtil.getId()+"";
				String subId = IdUtil.getId()+"";
				subInformatiomVo.setClientId(clientId);
				subInformatiomVo.setSubscriptionId(subId);
				roomsourceSubscriptionDao.insertClient(subInformatiomVo);
				roomsourceSubscriptionDao.insertSub_xg(subInformatiomVo);
				subInformatiomVo.setStatus(2);
				roomsourceSubscriptionDao.updateStatus(subInformatiomVo);

			}else{//选购时搜索到客户信息，需更新客户表  在选购
				String subId = IdUtil.getId()+"";
				subInformatiomVo.setSubscriptionId(subId);
				int i=roomsourceSubscriptionDao.updateClientById(subInformatiomVo);
				int j=roomsourceSubscriptionDao.insertSub_xg(subInformatiomVo);
				subInformatiomVo.setStatus(2);
				int k=roomsourceSubscriptionDao.updateStatus(subInformatiomVo);
				if(i==1&&j==1&&k==1){
				}else{
					throw new GlobalException("SA007");
				}

			}


		}
		return 1;
	}
	@Override
	public int insertHouseSub_rg(SubInformatiomVo subInformatiomVo) {
		if(subInformatiomVo==null){
			throw new GlobalException("SA001");
		}else{

			//do something 验证




			//判断是否房屋状态未变 为2 认购中
			if(subInformatiomVo.getHouseId()==null||subInformatiomVo.getHouseId().equals("")){
				throw new GlobalException("SA002");
			}else{
				//
				HouseVo hv =roomsourceSubscriptionDao.getHouseVoById(subInformatiomVo.getHouseId());
				if(hv==null||hv.getHouseNo()==null){
					throw new GlobalException("SA049");
				}else{
					if(hv.getSaleStatus()==2){
					}else{
						throw new GlobalException("SA050");
					}
				}
			}



			if(subInformatiomVo.getClientId()==null||subInformatiomVo.getClientId().equals("")){
				throw new GlobalException("SA005");
			}else{
				if(subInformatiomVo.getSubscriptionId()==null||subInformatiomVo.getSubscriptionId().equals("")){
					throw new GlobalException("SA051");

				}else{
					int i= roomsourceSubscriptionDao.updateSub_rg(subInformatiomVo);
					subInformatiomVo.setStatus(3);
					int j =roomsourceSubscriptionDao.updateStatus(subInformatiomVo);
					if(i==1&&j==1){
					}else{
						throw new GlobalException("SA007");
					}

				}


			}


		}
		return 1;
	}

	@Override
	public int insertHouseSub_ht(HouseSellDetailVo detail ,SubInformatiomVo subInformatiomVo) {
		if(subInformatiomVo==null){
			throw new GlobalException("SA001");
		}else{

			//do something 验证




			//判断是否房屋状态未变 为3 已认购
			if(subInformatiomVo.getHouseId()==null||subInformatiomVo.getHouseId().equals("")){
				throw new GlobalException("SA002");
			}else{
				//
				HouseVo hv =roomsourceSubscriptionDao.getHouseVoById(subInformatiomVo.getHouseId());
				if(hv==null||hv.getHouseNo()==null){
					throw new GlobalException("SA049");
				}else{
					if(hv.getSaleStatus()==3){
					}else{
						throw new GlobalException("SA050");
					}
				}
			}



			if(subInformatiomVo.getClientId()==null||subInformatiomVo.getClientId().equals("")){
				throw new GlobalException("SA005");
			}else{
				if(subInformatiomVo.getSubscriptionId()==null||subInformatiomVo.getSubscriptionId().equals("")){
					throw new GlobalException("SA051");

				}else{
					int i=roomsourceSubscriptionDao.updateSub_ht(subInformatiomVo);
					subInformatiomVo.setStatus(4);
					int j =roomsourceSubscriptionDao.updateStatus(subInformatiomVo);
					int k=roomsourceSubscriptionDao.updateClientById(subInformatiomVo);
					if(i==1&&j==1&&k==1){
					}else{
						throw new GlobalException("SA007");
					}

					roomsourceSubscriptionDao.cancelHouseState2(subInformatiomVo.getHouseId());
					roomsourceSubscriptionDao.cancelHouseState3(subInformatiomVo.getHouseId());

					//变为已售后 保存 价格、折扣等信息
					if(detail!=null&&detail.getHousePriceId()!=null&&!("".equals(detail.getHousePriceId()))){
						SalePriceVo sp = new SalePriceVo();
						sp.setHousePriceId(detail.getHousePriceId());
						sp.setHouseId(detail.getHouseId());
						sp.setPrice(detail.getPrice());
						sp.setTotalPrice(detail.getTotalPrice());
						sp.setSalePriceId(IdUtil.getId()+"");
						roomsourceSubscriptionDao.insertSalePrice(sp);

					}
					if(detail!=null&&detail.getHousePriceDiscountVo()!=null&&detail.getHousePriceDiscountVo().size()>0){
						for(HousePriceDiscountVo hsdv:detail.getHousePriceDiscountVo()){
							if(hsdv.getDiscountId()!=null){
								SaleDiscountVo sd = new SaleDiscountVo();
								sd.setSaleDiscountId(IdUtil.getId()+"");
								sd.setDiscountId(hsdv.getDiscountId());
								sd.setDiscount(hsdv.getDiscount());
								sd.setHouseId(detail.getHouseId());
								sd.setDiscountName(hsdv.getDiscountName());
								sd.setEfficacyDate(hsdv.getEfficacyDate());
								sd.setLoseEfficacyDate(hsdv.getLoseEfficacyDate());
								roomsourceSubscriptionDao.insertSaleDiscount(sd);

							}
						}

					}




				}


			}


		}
		return 1;
	}



	/**
	 * 利用正则表达式判断字符串是否是数字
	 *
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}
}
