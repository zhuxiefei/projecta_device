package com.bdcourtyard.business.estate.service.impl;

import basic.common.core.dto.PageDto;
import com.bdcourtyard.business.account.constant.EmployeeConstant;
import com.bdcourtyard.business.account.dao.CompanyEmployeeDao;
import com.bdcourtyard.business.account.dao.EmployeePrivilegeDao;
import com.bdcourtyard.business.account.model.CompanyEmployee;
import com.bdcourtyard.business.account.model.EmployeePrivilege;
import com.bdcourtyard.business.estate.dao.EstateEstateDao;
import com.bdcourtyard.business.estate.domain.FindEstatesResp;
import com.bdcourtyard.business.estate.domain.FindPrivilegesResp;
import com.bdcourtyard.business.estate.model.EstateEstate;
import com.bdcourtyard.business.estate.service.EstateEstateService;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.utils.PropertiesUtil;
import com.beite.tools.utils.AESUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 *  EstateEstateServiceImpl
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16 
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EstateEstateServiceImpl  implements EstateEstateService { 
	
	@Autowired
	private EstateEstateDao estateEstateDao;

	@Autowired
	private CompanyEmployeeDao employeeDao;

	@Autowired
	private EmployeePrivilegeDao privilegeDao;
	
	public int insertEstateEstate(EstateEstate estateEstate){
		return estateEstateDao.insertEstateEstate(estateEstate);
	}
	public int insertEstateEstateBatch(List<EstateEstate> list){
		return estateEstateDao.insertEstateEstateBatch(list);
	}
	public int updateEstateEstateById(EstateEstate estateEstate){
		return estateEstateDao.updateEstateEstateById(estateEstate);
	}
	public int deleteEstateEstateById(  String estateId  ){
		return estateEstateDao.deleteEstateEstateById(  estateId  );
	}
	public EstateEstate getEstateEstateById(  String estateId  ){
		return estateEstateDao.getEstateEstateById(  estateId  );
	}
 
 	public List<EstateEstate> getEstateEstates(EstateEstate estateEstate){
		return estateEstateDao.getEstateEstates(estateEstate);

 	}

 	public PageDto<EstateEstate> getEstateEstatesForPage(EstateEstate estateEstate, Pageable pageable){
 		
 		 long count = estateEstateDao.getEstateEstates(estateEstate).size();
			PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
			List<EstateEstate> estateEstates = estateEstateDao.getEstateEstates(estateEstate);
			 
			PageDto<EstateEstate> pageDto = new PageDto<EstateEstate>();
			
			if (estateEstates != null) {
				pageDto.setRows( estateEstates);
				pageDto.setTotal(count);
			} else {
				pageDto.setRows(new ArrayList<EstateEstate>());
				pageDto.setTotal(0l);
			}
			
			return pageDto;
 	}

	@Override
	public List<FindEstatesResp> findEstates(String acctName) {
		List<FindEstatesResp> list = estateEstateDao.findEstates(acctName);
		if (null != list && list.size() > 0){
			for (FindEstatesResp estate
					:list) {
				try {
					estate.setFileUrl(PropertiesUtil.getProperty("file.server")+estate.getFileUrl());
					estate.setEstateId(AESUtil.encrypt(estate.getEstateId()));
				} catch (Exception e) {
					throw new GlobalException("99999");
				}
			}
		}
		return list;
	}

	@Override
	public FindPrivilegesResp findPri(String acctName, String estateId) {
		//判断账号是否启用
		CompanyEmployee companyEmployee = employeeDao.findByAcctNameAndEstateId(acctName,estateId);
		if (null != companyEmployee && EmployeeConstant.NOT_ENABLEACCOUNT.equals(companyEmployee.getIsEnableAccount())){
			throw new GlobalException("E0049");
		}else {
			//查询菜单权限
			FindPrivilegesResp resp = new FindPrivilegesResp();
			//401代表营销助手app系统权限id
			resp.setPrivilegeList(privilegeDao.getPrivilegesByRoleIdAndParentId(companyEmployee.getRoleId(),"1","401"));
			try {
				resp.setEmployeeId(AESUtil.encrypt(companyEmployee.getEmployeeId()));
			} catch (Exception e) {
				throw new GlobalException("99999");
			}
			return resp;
		}
	}
}
