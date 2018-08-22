package com.bdcourtyard.business.clientmessage.service.impl;

import basic.common.core.dto.PageDto;
import com.bdcourtyard.business.clientmessage.dao.ClientNeedreturnDao;
import com.bdcourtyard.business.clientmessage.model.ClientNeedreturn;
import com.bdcourtyard.business.clientmessage.service.ClientNeedreturnService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *  ClientNeedreturnServiceImpl
 *
 * @version : Ver 1.0
 * @date	: 2018-7-26 
 */
@Service
public class ClientNeedreturnServiceImpl implements ClientNeedreturnService {
	
	@Autowired
	private ClientNeedreturnDao clientNeedreturnDao;
	
	public int insertClientNeedreturn(ClientNeedreturn clientNeedreturn){
		return clientNeedreturnDao.insertClientNeedreturn(clientNeedreturn);
	}
	public int insertClientNeedreturnBatch(List<ClientNeedreturn> list){
		return clientNeedreturnDao.insertClientNeedreturnBatch(list);
	}
	public int updateClientNeedreturnById(ClientNeedreturn clientNeedreturn){
		return clientNeedreturnDao.updateClientNeedreturnById(clientNeedreturn);
	}
	public int deleteClientNeedreturnById(  String needId  ){
		return clientNeedreturnDao.deleteClientNeedreturnById(  needId  );
	}
	public ClientNeedreturn getClientNeedreturnById(String needId  ){
		return clientNeedreturnDao.getClientNeedreturnById(  needId  );
	}
 
 	public List<ClientNeedreturn> getClientNeedreturns(ClientNeedreturn clientNeedreturn){
		return clientNeedreturnDao.getClientNeedreturns(clientNeedreturn);

 	}

 	public PageDto<ClientNeedreturn> getClientNeedreturnsForPage(ClientNeedreturn clientNeedreturn, Pageable pageable){
 		
 		 long count = clientNeedreturnDao.getClientNeedreturns(clientNeedreturn).size();
			PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
			List<ClientNeedreturn> clientNeedreturns = clientNeedreturnDao.getClientNeedreturns(clientNeedreturn);
			 
			PageDto<ClientNeedreturn> pageDto = new PageDto<ClientNeedreturn>();
			
			if (clientNeedreturns != null) {
				pageDto.setRows( clientNeedreturns);
				pageDto.setTotal(count);
			} else {
				pageDto.setRows(new ArrayList<ClientNeedreturn>());
				pageDto.setTotal(0l);
			}
			
			return pageDto;
 	}

	public List<ClientNeedreturn> getClientNeedreturnsByclientId(String clientId){
 		return clientNeedreturnDao.getClientNeedreturnsByclientId(clientId);
	}

	//根据关联id清空相关数据
	public int deleteClientNeedreturnByclientId(String clientId){
		return clientNeedreturnDao.deleteClientNeedreturnByclientId(clientId);
	}
}
