package com.bdcourtyard.business.clientmessage.service.impl;

import com.bdcourtyard.business.clientmessage.dao.ControlClientEnteringDao;
import com.bdcourtyard.business.clientmessage.model.ControlClientEntering;
import com.bdcourtyard.business.clientmessage.model.VagueSelect;
import com.bdcourtyard.business.clientmessage.model.VagueSelectValidClient;
import com.bdcourtyard.business.clientmessage.service.ControlClientEnteringService;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  ControlClientEnteringServiceImpl
 *
 * @version : Ver 1.0
 * @date	: 2018-7-24 
 */
@Service
public class ControlClientEnteringServiceImpl  implements ControlClientEnteringService {

	private static Logger log = Logger.getLogger(ControlClientEnteringServiceImpl.class);

	@Autowired
	private ControlClientEnteringDao controlClientEnteringDao;

	public int insertControlClientEntering(ControlClientEntering controlClientEntering){
		//如果成交 未成交因素为空
		if(controlClientEntering.getBargain()==1){
			if(controlClientEntering.getUnsubmittedFactor()!=null && !("".equals(controlClientEntering.getUnsubmittedFactor().trim())) && Integer.parseInt(controlClientEntering.getUnsubmittedFactor().trim())!=0){
				throw new GlobalException("CM001");
			}
		}else if(controlClientEntering.getBargain()==2){
			if(controlClientEntering.getUnsubmittedFactor()==null && "".equals(controlClientEntering.getUnsubmittedFactor().trim()) && Integer.parseInt(controlClientEntering.getUnsubmittedFactor().trim())==0){
				throw new GlobalException("CM006");
			}
		}else{
			throw new GlobalException("CM005");
		}
		//如果不需要回访 追踪回访记录 回访时间 显示为空
		if(controlClientEntering.getReturnVisit()==2){
			if(controlClientEntering.getTrace()!=null && !("".equals(controlClientEntering.getTrace().trim()))){
				throw new GlobalException("CM002");
			}
		}else if(controlClientEntering.getReturnVisit()==1){
			if(controlClientEntering.getTrace()==null && "".equals(controlClientEntering.getTrace().trim())){
				throw new GlobalException("CM004");
			}
		}else{
			throw new GlobalException("CM005");
		}
		//客户级别
		if(controlClientEntering.getClientRank()!=1 && controlClientEntering.getClientRank()!=2 && controlClientEntering.getClientRank()!=3){
			throw new GlobalException("CM005");
		}
		//客户状态
		if(controlClientEntering.getClientState()!=1 && controlClientEntering.getClientState()!=2 && controlClientEntering.getClientState()!=3){
			throw new GlobalException("CM005");
		}
		return controlClientEnteringDao.insertControlClientEntering(controlClientEntering);
	}
	public int insertControlClientEnteringBatch(List<ControlClientEntering> list){
		return controlClientEnteringDao.insertControlClientEnteringBatch(list);
	}
	public int updateControlClientEnteringById(ControlClientEntering controlClientEntering){
		//如果成交 未成交因素为空
		if(controlClientEntering.getBargain()==1){
			if(controlClientEntering.getUnsubmittedFactor()!=null && !("".equals(controlClientEntering.getUnsubmittedFactor().trim())) && Integer.parseInt(controlClientEntering.getUnsubmittedFactor().trim())!=0){
				throw new GlobalException("CM001");
			}
		}else if(controlClientEntering.getBargain()==2){
			if(controlClientEntering.getUnsubmittedFactor()==null && "".equals(controlClientEntering.getUnsubmittedFactor().trim()) && Integer.parseInt(controlClientEntering.getUnsubmittedFactor().trim())==0){
				throw new GlobalException("CM006");
			}
		}else{
			throw new GlobalException("CM005");
		}
		//如果不需要回访 追踪回访记录 回访时间 显示为空
		if(controlClientEntering.getReturnVisit()==2){
			if(controlClientEntering.getTrace()!=null && !("".equals(controlClientEntering.getTrace().trim()))){
				throw new GlobalException("CM002");
			}
		}else if(controlClientEntering.getReturnVisit()==1){
			if(controlClientEntering.getTrace()==null && "".equals(controlClientEntering.getTrace().trim())){
				throw new GlobalException("CM004");
			}
		}else{
			throw new GlobalException("CM005");
		}
		//客户级别
		if(controlClientEntering.getClientRank()!=1 && controlClientEntering.getClientRank()!=2 && controlClientEntering.getClientRank()!=3){
			throw new GlobalException("CM005");
		}
		//客户状态
		if(controlClientEntering.getClientState()!=1 && controlClientEntering.getClientState()!=2 && controlClientEntering.getClientState()!=3){
			throw new GlobalException("CM005");
		}
		return controlClientEnteringDao.updateControlClientEnteringById(controlClientEntering);
	}
	public boolean deleteControlClientEnteringById(  String clientId  ){
		try {
			String[] ids = clientId.split(",");
			controlClientEnteringDao.deleteControlClientEnteringById(ids);
			return true;
		}catch (Exception e){
			log.error("异常",e);
			return  false;
		}
	}
	public ControlClientEntering getControlClientEnteringById(  String clientId  ){
		return controlClientEnteringDao.getControlClientEnteringById(  clientId  );
	}

 	public List<ControlClientEntering> getControlClientEnterings(ControlClientEntering controlClientEntering){
		return controlClientEnteringDao.getControlClientEnterings(controlClientEntering);

 	}

 	public Page<ControlClientEntering> getControlClientEnteringsForPage(VagueSelect vagueSelect, Pageable pageable){
		if (vagueSelect.getStartTime() != null && !("".equals(vagueSelect.getStartTime().trim()))) {
			if (vagueSelect.getStartTime().length() > 10) {
				boolean b = checkDate(vagueSelect.getStartTime(), "yyyy-MM-dd HH:mm:ss");
				if (!b) {
					//do something 格式错误
					throw new GlobalException("H0006");
				}
			} else {
				boolean b = checkDate(vagueSelect.getStartTime(), "yyyy-MM-dd");
				if (!b) {
					//do something 格式错误
					throw new GlobalException("H0006");
				} else {
					vagueSelect.setStartTime(vagueSelect.getStartTime() + " 00:00:00");
				}
			}

		}
		if (vagueSelect.getEndTime() != null && !("".equals(vagueSelect.getEndTime().trim()))) {
			if (vagueSelect.getEndTime().length() > 10) {
				boolean b = checkDate(vagueSelect.getEndTime(), "yyyy-MM-dd HH:mm:ss");
				if (!b) {
					//do something 格式错误
					throw new GlobalException("H0006");
				}
			} else {
				boolean b = checkDate(vagueSelect.getEndTime(), "yyyy-MM-dd");
				if (!b) {
					//do something 格式错误
					throw new GlobalException("H0006");
				} else {
					vagueSelect.setEndTime(vagueSelect.getEndTime() + " 23:59:59");
				}

			}

		}
		//判断开始时间和结束时间大小
		if (vagueSelect.getStartTime() != null && !("".equals(vagueSelect.getStartTime().trim())) && vagueSelect.getEndTime() != null && !("".equals(vagueSelect.getEndTime().trim()))) {
			if (!compare_date(vagueSelect.getStartTime(), vagueSelect.getEndTime())) {
				throw new GlobalException("H0007");
			}
		}

		long count = controlClientEnteringDao.getControlClientEnterings_new(vagueSelect).size();
		PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
		List<ControlClientEntering> controlClientEnterings = controlClientEnteringDao.getControlClientEnterings_new(vagueSelect);
		Page<ControlClientEntering> pageDto = new Page<ControlClientEntering>();
			if (controlClientEnterings != null) {
				pageDto.setRows( controlClientEnterings);
				pageDto.setTotal(count);
			} else {
				pageDto.setRows(new ArrayList<ControlClientEntering>());
				pageDto.setTotal(0l);
			}

			return pageDto;
 	}



 	public List<ControlClientEntering> getControlClientEnteringsExport(VagueSelect vagueSelect){

		if (vagueSelect.getStartTime() != null && !("".equals(vagueSelect.getStartTime().trim()))) {
			if (vagueSelect.getStartTime().length() > 10) {
				boolean b = checkDate(vagueSelect.getStartTime(), "yyyy-MM-dd HH:mm:ss");
				if (!b) {
					//do something 格式错误
					throw new GlobalException("H0006");
				}
			} else {
				boolean b = checkDate(vagueSelect.getStartTime(), "yyyy-MM-dd");
				if (!b) {
					//do something 格式错误
					throw new GlobalException("H0006");
				} else {
					vagueSelect.setStartTime(vagueSelect.getStartTime() + " 00:00:00");
				}
			}

		}
		if (vagueSelect.getEndTime() != null && !("".equals(vagueSelect.getEndTime().trim()))) {
			if (vagueSelect.getEndTime().length() > 10) {
				boolean b = checkDate(vagueSelect.getEndTime(), "yyyy-MM-dd HH:mm:ss");
				if (!b) {
					//do something 格式错误
					throw new GlobalException("H0006");
				}
			} else {
				boolean b = checkDate(vagueSelect.getEndTime(), "yyyy-MM-dd");
				if (!b) {
					//do something 格式错误
					throw new GlobalException("H0006");
				} else {
					vagueSelect.setEndTime(vagueSelect.getEndTime() + " 23:59:59");
				}

			}

		}
		//判断开始时间和结束时间大小
		if (vagueSelect.getStartTime() != null && !("".equals(vagueSelect.getStartTime().trim())) && vagueSelect.getEndTime() != null && !("".equals(vagueSelect.getEndTime().trim()))) {
			if (!compare_date(vagueSelect.getStartTime(), vagueSelect.getEndTime())) {
				throw new GlobalException("H0007");
			}

		}

		List<ControlClientEntering> list = controlClientEnteringDao.getControlClientEnterings_new(vagueSelect);
 		return list;
	}

	//有效客户列表模糊查询
	public Page<ControlClientEntering> getControlClientEnterings_valid(VagueSelectValidClient vagueSelectValidClient, Pageable pageable){
		if (vagueSelectValidClient.getStartTime() != null && !("".equals(vagueSelectValidClient.getStartTime().trim()))) {
			if (vagueSelectValidClient.getStartTime().length() > 10) {
				boolean b = checkDate(vagueSelectValidClient.getStartTime(), "yyyy-MM-dd HH:mm:ss");
				if (!b) {
					//do something 格式错误
					throw new GlobalException("H0006");
				}
			} else {
				boolean b = checkDate(vagueSelectValidClient.getStartTime(), "yyyy-MM-dd");
				if (!b) {
					//do something 格式错误
					throw new GlobalException("H0006");
				} else {
					vagueSelectValidClient.setStartTime(vagueSelectValidClient.getStartTime() + " 00:00:00");
				}
			}

		}
		if (vagueSelectValidClient.getEndTime() != null && !("".equals(vagueSelectValidClient.getEndTime().trim()))) {
			if (vagueSelectValidClient.getEndTime().length() > 10) {
				boolean b = checkDate(vagueSelectValidClient.getEndTime(), "yyyy-MM-dd HH:mm:ss");
				if (!b) {
					//do something 格式错误
					throw new GlobalException("H0006");
				}
			} else {
				boolean b = checkDate(vagueSelectValidClient.getEndTime(), "yyyy-MM-dd");
				if (!b) {
					//do something 格式错误
					throw new GlobalException("H0006");
				} else {
					vagueSelectValidClient.setEndTime(vagueSelectValidClient.getEndTime() + " 23:59:59");
				}

			}

		}
		//判断开始时间和结束时间大小
		if (vagueSelectValidClient.getStartTime() != null && !("".equals(vagueSelectValidClient.getStartTime().trim())) && vagueSelectValidClient.getEndTime() != null && !("".equals(vagueSelectValidClient.getEndTime().trim()))) {
			if (!compare_date(vagueSelectValidClient.getStartTime(), vagueSelectValidClient.getEndTime())) {
				throw new GlobalException("H0007");
			}
		}
		long count = controlClientEnteringDao.getControlClientEnterings_valid(vagueSelectValidClient).size();
		PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
		List<ControlClientEntering> controlClientEnterings = controlClientEnteringDao.getControlClientEnterings_valid(vagueSelectValidClient);
		Page<ControlClientEntering> pageDto = new Page<ControlClientEntering>();
		if (controlClientEnterings != null) {
			pageDto.setRows( controlClientEnterings);
			pageDto.setTotal(count);
		} else {
			pageDto.setRows(new ArrayList<ControlClientEntering>());
			pageDto.setTotal(0l);
		}

		return pageDto;
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
}
