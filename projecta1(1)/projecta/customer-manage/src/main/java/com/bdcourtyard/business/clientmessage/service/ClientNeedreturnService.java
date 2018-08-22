package com.bdcourtyard.business.clientmessage.service;

import basic.common.core.dto.PageDto;
import com.bdcourtyard.business.clientmessage.model.ClientNeedreturn;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 *  ClientNeedreturnService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-26 
 */
public interface ClientNeedreturnService {
	
	int insertClientNeedreturn(ClientNeedreturn clientNeedreturn);
	
	int insertClientNeedreturnBatch(List<ClientNeedreturn> list);
	
	int updateClientNeedreturnById(ClientNeedreturn clientNeedreturn);
	
	int deleteClientNeedreturnById(String needId);

 	ClientNeedreturn getClientNeedreturnById(String needId);
 
 	List<ClientNeedreturn> getClientNeedreturns(ClientNeedreturn clientNeedreturn);

 	PageDto<ClientNeedreturn> getClientNeedreturnsForPage(ClientNeedreturn clientNeedreturn, Pageable pageable);

 	//根据关联id得到相关数据
	List<ClientNeedreturn> getClientNeedreturnsByclientId(String clientId);
	//根据关联id清空相关数据
	int deleteClientNeedreturnByclientId(String clientId);
}
