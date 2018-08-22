package com.bdcourtyard.business.returncust.service.impl;
import basic.common.core.id.IdUtil;
import com.bdcourtyard.business.clientmessage.model.UpdateControlClientEnteringResp;
import com.bdcourtyard.business.returncust.model.ControlClientEntering;
import com.bdcourtyard.business.returncust.service.RoomsourceReturncustService;
import com.bdcourtyard.business.returncust.dao.RoomsourceReturncustDao;
import com.bdcourtyard.business.returncust.vo.RoomsourceReturnRecord;
import com.bdcourtyard.business.returncust.vo.RoomsourceReturncust;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.pagehelper.PageHelper;
import org.springframework.transaction.annotation.Transactional;

/**
 *  RoomsourceReturncustServiceImpl
 *
 * @version : Ver 1.0
 * @date	: 2018-7-25
 */
@Service
@Transactional
public class RoomsourceReturncustServiceImpl  implements RoomsourceReturncustService {

	@Autowired
	private RoomsourceReturncustDao roomsourceReturncustDao;


	public int insertRoomsourceReturncustBatch(List<RoomsourceReturncust> list){
		return roomsourceReturncustDao.insertRoomsourceReturncustBatch(list);
	}
	public int updateRoomsourceReturncustById(RoomsourceReturncust roomsourceReturncust){
		return roomsourceReturncustDao.updateRoomsourceReturncustById(roomsourceReturncust);
	}
	public int deleteRoomsourceReturncustById(  String returnId  ){
		return roomsourceReturncustDao.deleteRoomsourceReturncustById(  returnId  );
	}
	public RoomsourceReturncust getRoomsourceReturncustById(  String returnId  ){
		return roomsourceReturncustDao.getRoomsourceReturncustById(  returnId  );
	}

	public List<RoomsourceReturncust> getRoomsourceReturncusts(RoomsourceReturncust roomsourceReturncust){
		return roomsourceReturncustDao.getRoomsourceReturncusts(roomsourceReturncust);

	}

	public Page<RoomsourceReturncust> getRoomsourceReturncustsForPage(RoomsourceReturncust roomsourceReturncust, Pageable pageable){

		long count = roomsourceReturncustDao.getRoomsourceReturncusts(roomsourceReturncust).size();
		PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
		List<RoomsourceReturncust> roomsourceReturncusts = roomsourceReturncustDao.getRoomsourceReturncusts(roomsourceReturncust);

		Page<RoomsourceReturncust> pageDto = new Page<RoomsourceReturncust>();
		pageDto.setPage(pageable.getPageNumber());
		pageDto.setPageSize(pageable.getPageSize());
		if (roomsourceReturncusts != null) {
			pageDto.setRows( roomsourceReturncusts);
			pageDto.setTotal(count);
		} else {
			pageDto.setRows(new ArrayList<RoomsourceReturncust>());
			pageDto.setTotal(0l);
		}

		return pageDto;
	}

	@Override
	public Page<RoomsourceReturncust> getRoomsourceReturncustsForPage_new(RoomsourceReturncust roomsourceReturncust, Pageable pageable) {
		if(roomsourceReturncust.getDateRange()!=null&&!("".equals(roomsourceReturncust.getDateRange().trim()))&&!("0".equals(roomsourceReturncust.getDateRange().trim()))){

			if(roomsourceReturncust.getDateRange().trim().equals("1")){
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
				String x = df.format(new Date());
				String start = x+" 00:00:00";
				String end = x+" 23:59:59";
				roomsourceReturncust.setStartTime(start);
				roomsourceReturncust.setEndTime(end);
			}
			if(roomsourceReturncust.getDateRange().trim().equals("2")){

				try {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
					String x = df.format(new Date());
					String start = x+" 00:00:00";
					Date date3 = df.parse(x);
					String next3DateStr = df.format(date3.getTime() + 2 * 24 * 60 * 60 * 1000);
					String end = next3DateStr+" 23:59:59";
					roomsourceReturncust.setStartTime(start);
					roomsourceReturncust.setEndTime(end);
				} catch (ParseException e) {
					throw new GlobalException("99999");
				}



			}
			if(roomsourceReturncust.getDateRange().trim().equals("3")){
				try {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
					String x = df.format(new Date());
					String start = x+" 00:00:00";
					Date date3 = df.parse(x);
					String next3DateStr = df.format(date3.getTime() + 6 * 24 * 60 * 60 * 1000);
					String end = next3DateStr+" 23:59:59";
					roomsourceReturncust.setStartTime(start);
					roomsourceReturncust.setEndTime(end);
				} catch (ParseException e) {
					throw new GlobalException("99999");
				}

			}
			if(roomsourceReturncust.getDateRange().trim().equals("4")){
				try {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
					String x = df.format(new Date());
					String start = x+" 00:00:00";
					Date date3 = df.parse(x);
					String next3DateStr = df.format(date3.getTime() + 14 * 24 * 60 * 60 * 1000);
					String end = next3DateStr+" 23:59:59";
					roomsourceReturncust.setStartTime(start);
					roomsourceReturncust.setEndTime(end);
				} catch (ParseException e) {
					throw new GlobalException("99999");
				}

			}
			if(roomsourceReturncust.getDateRange().trim().equals("5")){
				try {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
					String x = df.format(new Date());
					String start = x+" 00:00:00";
					Date date3 = df.parse(x);
					String next3DateStr = df.format(date3.getTime() + 29 * 24 * 60 * 60 * 1000);
					String end = next3DateStr+" 23:59:59";
					roomsourceReturncust.setStartTime(start);
					roomsourceReturncust.setEndTime(end);
				} catch (ParseException e) {
					throw new GlobalException("99999");
				}

			}

		}

		if (roomsourceReturncust.getStartTime() != null && !("".equals(roomsourceReturncust.getStartTime().trim()))) {
			if (roomsourceReturncust.getStartTime().length() > 10) {
				boolean b = checkDate(roomsourceReturncust.getStartTime(), "yyyy-MM-dd HH:mm:ss");
				if (!b) {
					//do something 格式错误
					throw new GlobalException("SA003");
				}
			} else {
				boolean b = checkDate(roomsourceReturncust.getStartTime(), "yyyy-MM-dd");
				if (!b) {
					//do something 格式错误
					throw new GlobalException("SA003");
				} else {
					roomsourceReturncust.setStartTime(roomsourceReturncust.getStartTime() + " 00:00:00");
				}
			}

		}


		if (roomsourceReturncust.getEndTime() != null && !("".equals(roomsourceReturncust.getEndTime().trim()))) {
			if (roomsourceReturncust.getEndTime().length() > 10) {
				boolean b = checkDate(roomsourceReturncust.getEndTime(), "yyyy-MM-dd HH:mm:ss");
				if (!b) {
					//do something 格式错误
					throw new GlobalException("SA003");
				}
			} else {
				boolean b = checkDate(roomsourceReturncust.getEndTime(), "yyyy-MM-dd");
				if (!b) {
					//do something 格式错误
					throw new GlobalException("SA003");
				} else {
					roomsourceReturncust.setEndTime(roomsourceReturncust.getEndTime() + " 23:59:59");
				}

			}

		}

		//判断开始时间和结束时间大小
		if (roomsourceReturncust.getStartTime() != null && !("".equals(roomsourceReturncust.getStartTime().trim())) && roomsourceReturncust.getEndTime() != null && !("".equals(roomsourceReturncust.getEndTime().trim()))) {
			if (!compare_date(roomsourceReturncust.getStartTime(), roomsourceReturncust.getEndTime())) {
				throw new GlobalException("SA004");
			}

		}
		if(roomsourceReturncust.getClientId()!=null){
			roomsourceReturncust.setClientId(roomsourceReturncust.getClientId().trim());
		}
		if(roomsourceReturncust.getClientName()!=null){
			roomsourceReturncust.setClientName(roomsourceReturncust.getClientName().trim());
		}
		Set<String> set = new HashSet<>();
		boolean b =false;
		if((roomsourceReturncust.getStartTime()!=null&&!("".equals(roomsourceReturncust.getStartTime())))||(roomsourceReturncust.getEndTime()!=null&&!("".equals(roomsourceReturncust.getEndTime())))){
			set =  roomsourceReturncustDao.getNeedReturnClientId(roomsourceReturncust);

			roomsourceReturncust.setList(set);
			b=true;

		}
		if(set!=null&&set.size()==0&&b){
			Page<RoomsourceReturncust> pageDto = new Page<RoomsourceReturncust>();
			pageDto.setPage(pageable.getPageNumber());
			pageDto.setPageSize(pageable.getPageSize());
			pageDto.setRows(new ArrayList<RoomsourceReturncust>());
			pageDto.setTotal(0l);
			return pageDto;
		}else{
			long count = roomsourceReturncustDao.getCustomerReturnPage(roomsourceReturncust).size();
			PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
			List<RoomsourceReturncust> roomsourceReturncusts = roomsourceReturncustDao.getCustomerReturnPage(roomsourceReturncust);

			Page<RoomsourceReturncust> pageDto = new Page<RoomsourceReturncust>();
			pageDto.setPage(pageable.getPageNumber());
			pageDto.setPageSize(pageable.getPageSize());
			if (roomsourceReturncusts != null) {
				pageDto.setRows( roomsourceReturncusts);
				pageDto.setTotal(count);
			} else {
				pageDto.setRows(new ArrayList<RoomsourceReturncust>());
				pageDto.setTotal(0l);
			}

			return pageDto;

		}



	}

	@Override
	public Page<RoomsourceReturnRecord> getReturnRecordForPage(RoomsourceReturnRecord roomsourceReturnRecord, Pageable pageable) {
		if(roomsourceReturnRecord!=null){
			if(roomsourceReturnRecord.getClientId()!=null&&!("".equals(roomsourceReturnRecord.getClientId().trim()))){
				roomsourceReturnRecord.setClientId(roomsourceReturnRecord.getClientId().trim());
			}else{
				throw new GlobalException("SA001");
			}

			if (roomsourceReturnRecord.getStartTime() != null && !("".equals(roomsourceReturnRecord.getStartTime().trim()))) {
				if (roomsourceReturnRecord.getStartTime().length() > 10) {
					boolean b = checkDate(roomsourceReturnRecord.getStartTime(), "yyyy-MM-dd HH:mm:ss");
					if (!b) {
						//do something 格式错误
						throw new GlobalException("SA003");
					}
				} else {
					boolean b = checkDate(roomsourceReturnRecord.getStartTime(), "yyyy-MM-dd");
					if (!b) {
						//do something 格式错误
						throw new GlobalException("SA003");
					} else {
						roomsourceReturnRecord.setStartTime(roomsourceReturnRecord.getStartTime() + " 00:00:00");
					}
				}

			}


			if (roomsourceReturnRecord.getEndTime() != null && !("".equals(roomsourceReturnRecord.getEndTime().trim()))) {
				if (roomsourceReturnRecord.getEndTime().length() > 10) {
					boolean b = checkDate(roomsourceReturnRecord.getEndTime(), "yyyy-MM-dd HH:mm:ss");
					if (!b) {
						//do something 格式错误
						throw new GlobalException("SA003");
					}
				} else {
					boolean b = checkDate(roomsourceReturnRecord.getEndTime(), "yyyy-MM-dd");
					if (!b) {
						//do something 格式错误
						throw new GlobalException("SA003");
					} else {
						roomsourceReturnRecord.setEndTime(roomsourceReturnRecord.getEndTime() + " 23:59:59");
					}

				}

			}

			//判断开始时间和结束时间大小
			if (roomsourceReturnRecord.getStartTime() != null && !("".equals(roomsourceReturnRecord.getStartTime().trim())) && roomsourceReturnRecord.getEndTime() != null && !("".equals(roomsourceReturnRecord.getEndTime().trim()))) {
				if (!compare_date(roomsourceReturnRecord.getStartTime(), roomsourceReturnRecord.getEndTime())) {
					throw new GlobalException("SA004");
				}

			}
		}else{
			//throw new GlobalException("SA001");
		}
		long count = roomsourceReturncustDao.getReturnRecordForPage(roomsourceReturnRecord).size();
		PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
		List<RoomsourceReturnRecord> roomsourceReturncusts = roomsourceReturncustDao.getReturnRecordForPage(roomsourceReturnRecord);

		Page<RoomsourceReturnRecord> pageDto = new Page<RoomsourceReturnRecord>();
		pageDto.setPage(pageable.getPageNumber());
		pageDto.setPageSize(pageable.getPageSize());
		if (roomsourceReturncusts != null) {
			pageDto.setRows( roomsourceReturncusts);
			pageDto.setTotal(count);
		} else {
			pageDto.setRows(new ArrayList<RoomsourceReturnRecord>());
			pageDto.setTotal(0l);
		}

		return pageDto;
	}




	public ControlClientEntering getControlClientEnteringById(java.lang.String clientId  ){
		ControlClientEntering c = roomsourceReturncustDao.getControlClientEnteringById(  clientId  );
		if(c==null){
			throw new GlobalException("客户不存在或已被删除");
		}
		List<String> needReturnTimeList = roomsourceReturncustDao.getNeedReturnTimeList(clientId);
		if(needReturnTimeList!=null&&needReturnTimeList.size()>0){
			c.setNeedReturnTimeList(needReturnTimeList);
		}
		return c;
	}

	public int updateClientAndAddRecord(String employeeId,UpdateControlClientEnteringResp updateControlClientEnteringResp){
		if(updateControlClientEnteringResp!=null){
			if(updateControlClientEnteringResp.getClientId()==null||"".equals(updateControlClientEnteringResp.getClientId().trim())){
				throw new GlobalException("SA005");
			}
			ControlClientEntering c =roomsourceReturncustDao.getControlClientEnteringById(  updateControlClientEnteringResp.getClientId()  );
			if(c==null){
				throw new GlobalException("SA006");
			}
			if(updateControlClientEnteringResp.getClientName()==null||"".equals(updateControlClientEnteringResp.getClientName().trim())||updateControlClientEnteringResp.getClientName().trim().length()>20){
				throw new GlobalException("SA008"); //客户名称为空或长度过长
			}
			if(updateControlClientEnteringResp.getClientAge()==null||updateControlClientEnteringResp.getClientAge().trim().equals("")||!isNumeric(updateControlClientEnteringResp.getClientAge().trim())){
				throw new GlobalException("SA009"); //年龄为空或格式不正确
			}else{
				updateControlClientEnteringResp.setClientAge(updateControlClientEnteringResp.getClientAge().trim());
			}
			if(updateControlClientEnteringResp.getClientGender()==null||updateControlClientEnteringResp.getClientGender().trim().equals("")||updateControlClientEnteringResp.getClientGender().trim().length()>10){
				throw new GlobalException("SA010"); //客户性别为空或长度过长
			}
			if(updateControlClientEnteringResp.getClientLooks()==null||updateControlClientEnteringResp.getClientLooks().trim().equals("")||updateControlClientEnteringResp.getClientLooks().trim().length()>50){
				throw new GlobalException("SA011"); //客户体貌特征为空或长度过长
			}
			if(updateControlClientEnteringResp.getClientPhone()==null||updateControlClientEnteringResp.getClientPhone().trim().equals("")||updateControlClientEnteringResp.getClientPhone().trim().length()>20){
				throw new GlobalException("SA012"); //客户联系方式为空或长度过长
			}
			if(updateControlClientEnteringResp.getIdCard()==null||updateControlClientEnteringResp.getIdCard().trim().equals("")||updateControlClientEnteringResp.getIdCard().trim().length()>20){
				throw new GlobalException("SA013"); //客户身份证号码为空或长度过长
			}
			if(updateControlClientEnteringResp.getInformation()!=null&&updateControlClientEnteringResp.getInformation().length()>100){
				throw new GlobalException("SA014"); //信息来源长度过长
			}
			if(updateControlClientEnteringResp.getClientFamily()!=null&&updateControlClientEnteringResp.getClientFamily().length()>100){
				throw new GlobalException("SA015"); //家庭人口长度过长
			}
			if(updateControlClientEnteringResp.getFamilyStructure()!=null&&updateControlClientEnteringResp.getFamilyStructure().length()>100){
				throw new GlobalException("SA016"); //家庭结构长度过长
			}
			if(updateControlClientEnteringResp.getDwellResidential()!=null&&updateControlClientEnteringResp.getDwellResidential().length()>100){
				throw new GlobalException("SA017"); //居住区域长度过长
			}
			if(updateControlClientEnteringResp.getWorkResidential()!=null&&updateControlClientEnteringResp.getWorkResidential().length()>100){
				throw new GlobalException("SA018"); //工作区域长度过长
			}
			if(updateControlClientEnteringResp.getVehicle()!=null&&updateControlClientEnteringResp.getVehicle().length()>100){
				throw new GlobalException("SA019"); //交通工具长度过长
			}
			if(updateControlClientEnteringResp.getMotive()!=null&&updateControlClientEnteringResp.getMotive().length()>100){
				throw new GlobalException("SA020"); //购买动机长度过长
			}
			if(updateControlClientEnteringResp.getEmphasis()==null||"".equals(updateControlClientEnteringResp.getEmphasis().trim())||updateControlClientEnteringResp.getEmphasis().trim().length()>100){
				throw new GlobalException("SA021"); //客户询问的重点为空或长度过长
			}
			if(updateControlClientEnteringResp.getDemandProduct()!=null&&updateControlClientEnteringResp.getDemandProduct().length()>100){
				throw new GlobalException("SA022"); //需求产品长度过长
			}
			if(updateControlClientEnteringResp.getDemandHouse()==null||"".equals(updateControlClientEnteringResp.getDemandHouse().trim())||updateControlClientEnteringResp.getDemandHouse().trim().length()>100){
				throw new GlobalException("SA023"); //需求房型为空或长度过长
			}
			if(updateControlClientEnteringResp.getDemandDiscount()==null||"".equals(updateControlClientEnteringResp.getDemandDiscount().trim())||updateControlClientEnteringResp.getDemandDiscount().trim().length()>100){
				throw new GlobalException("SA024"); //需求面积为空或长度过长
			}
			if(updateControlClientEnteringResp.getDemandTotal()==null||"".equals(updateControlClientEnteringResp.getDemandTotal().trim())||updateControlClientEnteringResp.getDemandTotal().trim().length()>100){
				throw new GlobalException("SA025"); //需求总价为空或长度过长
			}
			if(updateControlClientEnteringResp.getDemandFllor()==null||"".equals(updateControlClientEnteringResp.getDemandFllor().trim())||updateControlClientEnteringResp.getDemandTotal().trim().length()>100){
				throw new GlobalException("SA026"); //需求楼层为空或长度过长
			}
			if(updateControlClientEnteringResp.getProductReflect()!=null&&updateControlClientEnteringResp.getProductReflect().length()>100){
				throw new GlobalException("SA027"); //产品反应长度过长
			}
			if(updateControlClientEnteringResp.getProductRecommendRoomNumber()==null||"".equals(updateControlClientEnteringResp.getProductRecommendRoomNumber().trim())||updateControlClientEnteringResp.getProductRecommendRoomNumber().trim().length()>20){
				throw new GlobalException("SA028");//产品推荐:房号为空或长度过长
			}
			if(updateControlClientEnteringResp.getProductRecommendHouseType()==null||"".equals(updateControlClientEnteringResp.getProductRecommendHouseType().trim())||updateControlClientEnteringResp.getProductRecommendHouseType().trim().length()>20){
				throw new GlobalException("SA029");//产品推荐:房型为空或长度过长
			}
			if(updateControlClientEnteringResp.getProductRecommendProportion()==null||"".equals(updateControlClientEnteringResp.getProductRecommendProportion().trim())||updateControlClientEnteringResp.getProductRecommendProportion().trim().length()>20){
				throw new GlobalException("SA030");//产品推荐:面积为空或长度过长
			}
			if(updateControlClientEnteringResp.getProductRecommendUnitPrice()==null||"".equals(updateControlClientEnteringResp.getProductRecommendUnitPrice().trim())||updateControlClientEnteringResp.getProductRecommendUnitPrice().trim().length()>20){
				throw new GlobalException("SA031");//产品推荐:单价为空或长度过长
			}

			if(updateControlClientEnteringResp.getProductRecommendTotalPrices()==null||"".equals(updateControlClientEnteringResp.getProductRecommendTotalPrices().trim())||updateControlClientEnteringResp.getProductRecommendTotalPrices().trim().length()>20){
				throw new GlobalException("SA032");//产品推荐:总价为空或长度过长
			}

			if(updateControlClientEnteringResp.getReceivingRecords()!=null&&updateControlClientEnteringResp.getReceivingRecords().length()>100){
				throw new GlobalException("SA033"); //接待记录长度过长
			}
			if(updateControlClientEnteringResp.getClientRank()!=1&&updateControlClientEnteringResp.getClientRank()!=2&&updateControlClientEnteringResp.getClientRank()!=3){
				throw new GlobalException("SA034"); //选择客户级别
			}
			if(updateControlClientEnteringResp.getClientInauguration()!=null&&updateControlClientEnteringResp.getClientInauguration().length()>100){
				throw new GlobalException("SA035"); //客户就职单位长度过长
			}
			if(updateControlClientEnteringResp.getInaugurationName()!=null&&updateControlClientEnteringResp.getInaugurationName().length()>100){
				throw new GlobalException("SA036"); //客户单位名称长度过长
			}
			if(updateControlClientEnteringResp.getDuty()!=null&&updateControlClientEnteringResp.getDuty().length()>20){
				throw new GlobalException("SA037"); //客户职务长度过长
			}
			if(updateControlClientEnteringResp.getClientState()!=1&&updateControlClientEnteringResp.getClientState()!=2&&updateControlClientEnteringResp.getClientState()!=3){
				throw new GlobalException("SA038"); //选择客户状态
			}
			if(updateControlClientEnteringResp.getReturnVisit()!=1&&updateControlClientEnteringResp.getReturnVisit()!=2){
				throw new GlobalException("SA039"); //选择是否需要回访
			}
			//imputTime
			//returnTime
			if(updateControlClientEnteringResp.getTrace()!=null&&updateControlClientEnteringResp.getTrace().length()>100){
				throw new GlobalException("SA040"); //追踪回访记录长度过长
			}
			if(updateControlClientEnteringResp.getBargain()!=1&&updateControlClientEnteringResp.getBargain()!=2){
				throw new GlobalException("SA041"); //选择是否成交
			}
			if(updateControlClientEnteringResp.getUnsubmittedFactor()!=null&&updateControlClientEnteringResp.getUnsubmittedFactor().length()>100){
				throw new GlobalException("SA042"); //未成交因素长度过长
			}

			if(updateControlClientEnteringResp.getConfirm()==null||"".equals(updateControlClientEnteringResp.getConfirm().trim())||updateControlClientEnteringResp.getConfirm().trim().length()>20){
				throw new GlobalException("SA043");//主管确认记录为空或长度过长
			}

			if(updateControlClientEnteringResp.getRemark()!=null&&updateControlClientEnteringResp.getRemark().length()>500){
				throw new GlobalException("SA044"); //备注长度过长
			}
			//estateId
			if(updateControlClientEnteringResp.getEmphasisRests()!=null&&updateControlClientEnteringResp.getEmphasisRests().length()>100){
				throw new GlobalException("SA045"); //客户询问重点:其他 长度过长
			}
			if(updateControlClientEnteringResp.getUnsubmittedFactorRests()!=null&&updateControlClientEnteringResp.getUnsubmittedFactorRests().length()>100){
				throw new GlobalException("SA046"); //未成交因素:其他 长度过长
			}
			if(updateControlClientEnteringResp.getClientInaugurationRests()!=null&&updateControlClientEnteringResp.getClientInaugurationRests().length()>100){
				throw new GlobalException("SA047"); //客户就职单位:其他 长度过长
			}
			if(updateControlClientEnteringResp.getInformationRests()!=null&&updateControlClientEnteringResp.getInformationRests().length()>100){
				throw new GlobalException("SA048");
			}




		}else{
			throw new GlobalException("SA001");
		}

		try{
		/*	if(controlClientEntering.getReturnTime()!=null){
				SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
				Date x =  s.parse(controlClientEntering.getReturnTime());
				controlClientEntering.setTodate(x);
			}*/
			roomsourceReturncustDao.delAllNeedReturnByClientId(updateControlClientEnteringResp);
			if(updateControlClientEnteringResp.getReturnTimes()!=null&&updateControlClientEnteringResp.getReturnTimes().length>0){
				for(String x :updateControlClientEnteringResp.getReturnTimes()){
					if(!x.equals("")){
						try{
							HashMap<String,String> map = new HashMap<String,String>();
							map.put("clientId",updateControlClientEnteringResp.getClientId());
							map.put("needreturnTime",x);
							map.put("needId",IdUtil.getId()+"");
							roomsourceReturncustDao.insertNeedReturnTime(map);
						}catch(Exception e){
							throw new GlobalException("SA003");
						}

					}

				}

			}
			roomsourceReturncustDao.updateControlClientEnteringById(updateControlClientEnteringResp);
			RoomsourceReturnRecord record = new RoomsourceReturnRecord();
			String x = IdUtil.getId() +"";
			record.setReturnId(x);
			record.setReturnNo("HF"+x);
			record.setClientId(updateControlClientEnteringResp.getClientId());
			record.setCounselor(employeeId);
			roomsourceReturncustDao.insertRoomsourceReturncust(record);

		}catch (Exception e){
			e.printStackTrace();
			throw new GlobalException("SA007");
		}
		return 1;
	}


	/**
	 * 时间比较  若date1>date2返回false
	 *
	 * @param DATE1
	 * @param DATE2
	 * @return
	 */
	public static boolean compare_date(String DATE1, String DATE2) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() >= dt2.getTime()) {
				return false;
			} else {
				return true;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}

	}

	/**
	 * 查看日期格式是否正确
	 *
	 * @param str
	 * @param format
	 * @return
	 */
	public static boolean checkDate(String str, String format) {

		DateFormat formatter = new SimpleDateFormat(format);
		try {
			Date date = formatter.parse(str);
			return true;
		} catch (Exception e) {
			return false;
		}
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
