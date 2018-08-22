package com.bdcourtyard.business.houseprice.service.impl;

import com.bdcourtyard.business.building.model.HouseBuilding;
import com.bdcourtyard.business.building.service.HouseBuildingService;
import com.bdcourtyard.business.house.service.HouseHouseService;
import com.bdcourtyard.business.houseprice.dao.RoomsourceHousepriceDao;
import com.bdcourtyard.business.houseprice.model.RoomsourceHousediscount;
import com.bdcourtyard.business.houseprice.model.RoomsourceHouseprice;
import com.bdcourtyard.business.houseprice.service.RoomsourceHousediscountService;
import com.bdcourtyard.business.houseprice.service.RoomsourceHousepriceService;
import com.bdcourtyard.business.houseprice.vo.HouseFloor;
import com.bdcourtyard.business.houseprice.vo.HousePriceParm;
import com.bdcourtyard.business.houseprice.vo.HousepriceResp;
import com.bdcourtyard.business.houseprice.vo.RoomsourceHousepricePage;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.mybatis.QueryCondition;
import com.bdcourtyard.common.page.Page;
import com.beite.tools.utils.AESUtil;
import com.github.pagehelper.PageHelper;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  RoomsourceHousepriceServiceImpl
 *
 * @version : Ver 1.0
 * @date	: 2018-7-25 
 */
@Service
public class RoomsourceHousepriceServiceImpl  implements RoomsourceHousepriceService { 
	
	@Autowired
	private RoomsourceHousepriceDao roomsourceHousepriceDao;
	@Autowired
	private HouseHouseService houseHouseService;
	@Autowired
	private RoomsourceHousediscountService roomsourceHousediscountService;
	
	@Override
	public int insertRoomsourceHouseprice(HttpServletRequest request, RoomsourceHouseprice roomsourceHouseprice){

		//价格名称校验
		if(roomsourceHouseprice!=null&&roomsourceHouseprice.getPriceName()!=null&&!("".equals(roomsourceHouseprice.getPriceName().trim()))){
			boolean b = isSpecialChar(roomsourceHouseprice.getPriceName());
			if(b){ //有特殊字符
				throw new GlobalException("HP001");
			}
			if(roomsourceHouseprice.getPriceName().length()>50){ //长度校验
				throw new GlobalException("HP002");
			}
		}else{
			throw new GlobalException("HP003");
		}
		//房屋基础单价，三个增价：校验
		if(StringUtils.isNullOrEmpty(String.valueOf(roomsourceHouseprice.getPrice()))
				||StringUtils.isNullOrEmpty(String.valueOf(roomsourceHouseprice.getOrientationPrice()))||StringUtils.isNullOrEmpty(String.valueOf(roomsourceHouseprice.getStoreyPrice()))
				||StringUtils.isNullOrEmpty(String.valueOf(roomsourceHouseprice.getTotalPrice()))||StringUtils.isNullOrEmpty(String.valueOf(roomsourceHouseprice.getDegreePrice()))){
			throw new GlobalException("HP004");//房屋价格等为空
		}
		String estateId="";
		String employeeId="";
		if(roomsourceHouseprice.getEmployeeId()!=null) {
			try {
				employeeId = AESUtil.decrypt(request.getHeader("employeeId"));
				roomsourceHouseprice.setEmployeeId(employeeId);
			} catch (Exception e) {
				throw new GlobalException("99999");
			}
		}else{
			roomsourceHouseprice.setEmployeeId("1");
		}
		if(roomsourceHouseprice.getEstateId()!=null) {
			try {
				roomsourceHouseprice.setEstateId(AESUtil.decrypt(request.getHeader("estateId")));
			} catch (Exception e) {
				throw new GlobalException("99999");
			}
		}else{
			roomsourceHouseprice.setEstateId("1");
		}

		roomsourceHouseprice.setCreatTime(new Date());
		return roomsourceHousepriceDao.insertRoomsourceHouseprice(roomsourceHouseprice);
	}

	public int insertRoomsourceHousepriceBatch(List<RoomsourceHouseprice> list){
		return roomsourceHousepriceDao.insertRoomsourceHousepriceBatch(list);
	}
	public int updateRoomsourceHousepriceById(RoomsourceHouseprice roomsourceHouseprice){

		//价格名称校验
		if(roomsourceHouseprice!=null&&roomsourceHouseprice.getPriceName()!=null&&!("".equals(roomsourceHouseprice.getPriceName().trim()))){
			boolean b = isSpecialChar(roomsourceHouseprice.getPriceName());
			if(b){ //有特殊字符
				throw new GlobalException("HP001");
			}
			if(roomsourceHouseprice.getPriceName().length()>50){ //长度校验
				throw new GlobalException("HP002");
			}
		}else{
			throw new GlobalException("HP003");
		}
		//房屋基础单价，三个增价：校验
		if(StringUtils.isNullOrEmpty(String.valueOf(roomsourceHouseprice.getPrice()))
				||StringUtils.isNullOrEmpty(String.valueOf(roomsourceHouseprice.getOrientationPrice()))||StringUtils.isNullOrEmpty(String.valueOf(roomsourceHouseprice.getStoreyPrice()))
				||StringUtils.isNullOrEmpty(String.valueOf(roomsourceHouseprice.getTotalPrice()))||StringUtils.isNullOrEmpty(String.valueOf(roomsourceHouseprice.getDegreePrice()))){
			throw new GlobalException("HP004");//房屋价格等为空
		}
		return roomsourceHousepriceDao.updateRoomsourceHousepriceById(roomsourceHouseprice);
	}
	public int deleteRoomsourceHousepriceById(  String housePriceId  ){
		return roomsourceHousepriceDao.deleteRoomsourceHousepriceById(  housePriceId  );
	}

	@Override
	public void deleteRoomsourceHousepriceByIds(String housePriceIds) {
		String[] ids = housePriceIds.split(",");
		for (String id : ids) {
			roomsourceHousepriceDao.deleteRoomsourceHousepriceById(id);
		}
	}

	public HousepriceResp getHousepriceRespById(  String housePriceId  ){
		RoomsourceHouseprice roomsourceHouseprice= roomsourceHousepriceDao.getRoomsourceHousepriceById(  housePriceId  );
		String discountIds=roomsourceHouseprice.getDiscountId();
		String []discountId=discountIds.split(",");
		String disName="";
		HousepriceResp housepriceResp=new HousepriceResp();
		List<RoomsourceHousediscount> list=new ArrayList<RoomsourceHousediscount>();
		for (int i=0;i<discountId.length;i++){
			RoomsourceHousediscount roomsourceHousediscount=roomsourceHousediscountService.getRoomsourceHousediscountById(discountId[i]);
			if(roomsourceHousediscount!=null){
				list.add(roomsourceHousediscount);
			}
		}
		housepriceResp.setRoomsourceHousediscounts(list);
		housepriceResp.setRoomsourceHouseprice(roomsourceHouseprice);
		return housepriceResp;
	}
 
 	public List<RoomsourceHouseprice> getRoomsourceHouseprices(RoomsourceHouseprice roomsourceHouseprice){
		return roomsourceHousepriceDao.getRoomsourceHouseprices(roomsourceHouseprice);

 	}


	public Page<RoomsourceHousepricePage> getRoomsourceHousepricesForPage(HousePriceParm housePriceParm, Pageable pageable){
		List<QueryCondition> qcs = new ArrayList<QueryCondition>();
		if(!StringUtils.isNullOrEmpty(housePriceParm.getPriceName())){
			qcs.add(new QueryCondition("a.priceName", housePriceParm.getPriceName(),QueryCondition.TYPE_LIKE));
		}
		if(housePriceParm.getMaintotalPrice()!=null){
			qcs.add(new QueryCondition("a.totalPrice", housePriceParm.getMaintotalPrice(),QueryCondition.TYPE_MORE_THEN));
		}
		if(housePriceParm.getMaxtotalPrice() !=null){
			qcs.add(new QueryCondition("a.totalPrice", housePriceParm.getMaxtotalPrice(),QueryCondition.TYPE_LES_THEN));
		}
		if(!"".equals(housePriceParm.getStartTime())&&housePriceParm.getStartTime()!=null){
			qcs.add(new QueryCondition("a.creatTime", housePriceParm.getStartTime()+" 00:00:00",QueryCondition.TYPE_MORE_THEN));
		}
		if(!"".equals(housePriceParm.getEndTime())&&housePriceParm.getEndTime()!=null){
			qcs.add(new QueryCondition("a.creatTime", housePriceParm.getEndTime()+" 23:59:59",QueryCondition.TYPE_LES_THEN));
		}
 		 long count = roomsourceHousepriceDao.getRoomsourceHousepricesByConditions(qcs).size();
			PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
			List<RoomsourceHousepricePage> roomsourceHouseprices = roomsourceHousepriceDao.getRoomsourceHousepricesByConditions(qcs);
			 
			Page<RoomsourceHousepricePage> pageDto = new Page<RoomsourceHousepricePage>();
			pageDto.setPage(pageable.getPageNumber());
			pageDto.setPageSize(pageable.getPageSize());
			if (roomsourceHouseprices != null) {
				pageDto.setRows( roomsourceHouseprices);
				pageDto.setTotal(count);
			} else {
				pageDto.setRows(new ArrayList<RoomsourceHousepricePage>());
				pageDto.setTotal(0l);
			}


			
			return pageDto;
 	}



 	@Autowired
	private HouseBuildingService houseBuildingService;
	@Override
	public List<HouseFloor> getRoomsourceHousepricePageByIds(String housePriceId,String buildingId,
			String unitId,String typeId) {
		HouseBuilding building =houseBuildingService.getHouseBuildingById(buildingId);
		if(building==null){
			throw  new GlobalException("HP0005");//不能为空
		}
        //1.获取总楼层
		int	floor=0;
		if(building.getFloors()!=null){
			floor=building.getFloors();
		}
		List<HouseFloor> hfs = new ArrayList<HouseFloor>();
		HouseFloor houseFloor=new HouseFloor();
		for(int f=1;f<floor+1;f++){
			hfs.add(new HouseFloor(f+""));
		}
		//2.获取已占用楼层
		List<String> listFloor=new ArrayList<String>();
		List<RoomsourceHouseprice> list=roomsourceHousepriceDao.getRoomsourceHousepricesByIs( buildingId, unitId,typeId);
		String[]storeys=new String[]{};
		for(RoomsourceHouseprice rh:list){
			if(!rh.getHousePriceId().equals(housePriceId)){
				storeys =  rh.getStorey().split(",");
				for(String f:storeys){
					listFloor.add(f);
				}
			}
		}

		//设置已占用楼层
		for(HouseFloor hf :hfs){
			if(listFloor.indexOf(hf.getFloorNum())>-1){
				hf.setDisabled(1);
			}
		}
		return hfs;
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
