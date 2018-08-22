package com.bdcourtyard.business.houseprice.service.impl;

import com.bdcourtyard.business.houseprice.dao.RoomsourceHousediscountDao;
import com.bdcourtyard.business.houseprice.model.RoomsourceHousediscount;
import com.bdcourtyard.business.houseprice.service.RoomsourceHousediscountService;
import com.bdcourtyard.business.houseprice.service.SystemRecordService;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.mybatis.QueryCondition;
import com.bdcourtyard.common.page.Page;
import com.github.pagehelper.PageHelper;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  RoomsourceHousediscountServiceImpl
 *
 * @version : Ver 1.0
 * @date	: 2018-7-24 
 */
@Service
@Transactional
public class RoomsourceHousediscountServiceImpl  implements RoomsourceHousediscountService { 
	
	@Autowired
	private RoomsourceHousediscountDao roomsourceHousediscountDao;
	@Autowired
	private SystemRecordService systemRecordService;


	@Override
	public int insertRoomsourceHousediscount(HttpServletRequest request,RoomsourceHousediscount roomsourceHousediscount){
		if(roomsourceHousediscount!=null&&roomsourceHousediscount.getDiscountName()!=null&&!("".equals(roomsourceHousediscount.getDiscountName().trim()))){
			boolean b = isSpecialChar(roomsourceHousediscount.getDiscountName());
			if(b){ //有特殊字符
				throw new GlobalException("HP001");
			}
			if(roomsourceHousediscount.getDiscountName().length()>50){ //长度校验
				throw new GlobalException("HP002");
			}
		}else{
			throw new GlobalException("HP003");
		}
		String employeeId ="1";
	/*	try {

			*//*employeeId = AESUtil.decrypt(request.getHeader("employeeId"));*//*
		} catch (Exception e) {
			e.printStackTrace();
		}
*/
		String dicountId=roomsourceHousediscount.getDiscountId();
		roomsourceHousediscount.setEmployeeId(employeeId);
		roomsourceHousediscount.setCreatTime(new Date());
		int bool=roomsourceHousediscountDao.insertRoomsourceHousediscount(roomsourceHousediscount);
		if(bool>0){
			systemRecordService.addRecord("01","add",dicountId,"添加:"+roomsourceHousediscount.getDiscountName()+"记录",employeeId);
		}
		return 1;
	}
	@Override
	public int insertRoomsourceHousediscountBatch(List<RoomsourceHousediscount> list){
		return roomsourceHousediscountDao.insertRoomsourceHousediscountBatch(list);
	}
	@Override
	public int updateRoomsourceHousediscountById(RoomsourceHousediscount roomsourceHousediscount){
		if(roomsourceHousediscount!=null&&roomsourceHousediscount.getDiscountName()!=null&&!("".equals(roomsourceHousediscount.getDiscountName().trim()))){
			boolean b = isSpecialChar(roomsourceHousediscount.getDiscountName());
			if(b){ //有特殊字符
				throw new GlobalException("HD001");
			}
			if(roomsourceHousediscount.getDiscountName().length()>50){ //长度校验
				throw new GlobalException("HD002");
			}
		}else{
			throw new GlobalException("HD003");
		}
		String employeeId ="2";
	/*	try {

			*//*employeeId = AESUtil.decrypt(request.getHeader("employeeId"));*//*
		} catch (Exception e) {
			e.printStackTrace();
		}
*/
		String dicountId=roomsourceHousediscount.getDiscountId();
		roomsourceHousediscount.setUpdateEmployeeId(employeeId);
		roomsourceHousediscount.setUpdateTime(new Date());
		int bool=roomsourceHousediscountDao.updateRoomsourceHousediscountById(roomsourceHousediscount);
		if(bool>0){
			systemRecordService.addRecord("01","edit",dicountId,"修改："+roomsourceHousediscount.getDiscountName()+"记录",employeeId);
		}
		return 1;
	}
	@Override
	public int deleteRoomsourceHousediscountById(  String discountId  ){
		return roomsourceHousediscountDao.deleteRoomsourceHousediscountById(  discountId  );
	}
	@Override
	public RoomsourceHousediscount getRoomsourceHousediscountById(  String discountId  ){
		return roomsourceHousediscountDao.getRoomsourceHousediscountById(  discountId  );
	}
	@Override
	public void deleteRoomsourceHousediscountByIds(  String discountIds  ){
		String[] ids = discountIds.split(",");
		String employeeId ="2";
	/*	try {

			*//*employeeId = AESUtil.decrypt(request.getHeader("employeeId"));*//*
		} catch (Exception e) {
			e.printStackTrace();
		}
*/
		for (String id : ids) {
			RoomsourceHousediscount roomsourceHousediscount=roomsourceHousediscountDao.getRoomsourceHousediscountById(  id  );
			if(roomsourceHousediscount!=null){
				systemRecordService.addRecord("01","del",id,"删除："+roomsourceHousediscount.getDiscountName()+"记录",employeeId);
			}
			roomsourceHousediscountDao.deleteRoomsourceHousediscountById(id);
		}
	}
	@Override
 	public List<RoomsourceHousediscount> getRoomsourceHousediscounts(RoomsourceHousediscount roomsourceHousediscount){
		List<QueryCondition> qcs = new ArrayList<QueryCondition>();
		if(!StringUtils.isNullOrEmpty(roomsourceHousediscount.getEndTime())){
			qcs.add(new QueryCondition("loseEfficacyDate", new Date(),QueryCondition.TYPE_LES_THEN));
		}
		return roomsourceHousediscountDao.getRoomsourceHousediscounts(roomsourceHousediscount);
 	}
	@Override
 	public Page<RoomsourceHousediscount> getRoomsourceHousediscountsForPage(RoomsourceHousediscount roomsourceHousediscount, Pageable pageable){
		List<QueryCondition> qcs = new ArrayList<QueryCondition>();
		if(!StringUtils.isNullOrEmpty(roomsourceHousediscount.getDiscountName())){
			qcs.add(new QueryCondition("discountName", roomsourceHousediscount.getDiscountName(),QueryCondition.TYPE_LIKE));
		}

		if(!StringUtils.isNullOrEmpty(roomsourceHousediscount.getStartTime())){
			qcs.add(new QueryCondition("creatTime", roomsourceHousediscount.getStartTime(),QueryCondition.TYPE_MORE_THEN));
		}
		if(!StringUtils.isNullOrEmpty(roomsourceHousediscount.getEndTime())){
			qcs.add(new QueryCondition("creatTime", roomsourceHousediscount.getEndTime(),QueryCondition.TYPE_LES_THEN));
		}
		long count = roomsourceHousediscountDao.getRoomsourceHousediscountsByConditions(qcs).size();
			PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
			List<RoomsourceHousediscount> roomsourceHousediscounts = roomsourceHousediscountDao.getRoomsourceHousediscountsByConditions(qcs);
			 
			Page<RoomsourceHousediscount> pageDto = new Page<RoomsourceHousediscount>();
			pageDto.setPage(pageable.getPageNumber());
			pageDto.setPageSize(pageable.getPageSize());
			if (roomsourceHousediscounts != null) {
				pageDto.setRows( roomsourceHousediscounts);
				pageDto.setTotal(count);
			} else {
				pageDto.setRows(new ArrayList<RoomsourceHousediscount>());
				pageDto.setTotal(0l);
			}
			
			return pageDto;
 	}


	/**
	 * 判断是否含有特殊字符
	 *
	 * @param str
	 * @return true为包含，false为不包含
	 */
	public static boolean isSpecialChar(String str) {
		String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.find();
	}
}
