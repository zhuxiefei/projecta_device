package com.bdcourtyard.business.clientmessage.dao;

import com.bdcourtyard.business.clientmessage.model.ClientNeedreturn;
import com.bdcourtyard.common.mybatis.QueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  ClientNeedreturnDao 客户需回访时间
 *
 * @version : Ver 1.0
 * @date	: 2018-7-26
 */
@Repository
public interface ClientNeedreturnDao {
	
	int insertClientNeedreturn(ClientNeedreturn clientNeedreturn);
	
	int insertClientNeedreturnBatch(List<ClientNeedreturn> list);
	
	int updateClientNeedreturnById(ClientNeedreturn clientNeedreturn);
	
	int deleteClientNeedreturnById(@Param("needId") String needId);

 	ClientNeedreturn getClientNeedreturnById(@Param("needId") String needId);

 	List<ClientNeedreturn> getClientNeedreturns(@Param("clientNeedreturn") ClientNeedreturn clientNeedreturn);
 	
 	List<ClientNeedreturn> getClientNeedreturnsByConditions(@Param("conditions") List<QueryCondition> conditions);

	//根据关联id得到相关数据
	List<ClientNeedreturn> getClientNeedreturnsByclientId(@Param("clientId") String clientId);
	//根据关联id清空相关数据
	int deleteClientNeedreturnByclientId(@Param("clientId") String clientId);

}
