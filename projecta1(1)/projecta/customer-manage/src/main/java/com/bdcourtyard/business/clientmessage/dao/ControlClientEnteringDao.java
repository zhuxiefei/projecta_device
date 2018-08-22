package com.bdcourtyard.business.clientmessage.dao;

import com.bdcourtyard.business.clientmessage.model.ControlClientEntering;
import com.bdcourtyard.business.clientmessage.model.VagueSelect;
import com.bdcourtyard.business.clientmessage.model.VagueSelectValidClient;
import com.bdcourtyard.common.mybatis.QueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  ControlClientEnteringDao 
 *
 * @version : Ver 1.0
 * @date	: 2018-7-24
 */
@Repository
public interface ControlClientEnteringDao {
	
	int insertControlClientEntering(ControlClientEntering controlClientEntering);
	
	int insertControlClientEnteringBatch(List<ControlClientEntering> list);
	
	int updateControlClientEnteringById(ControlClientEntering controlClientEntering);

	int deleteControlClientEnteringById(@Param("ids") String[] ids);

 	ControlClientEntering getControlClientEnteringById(@Param("clientId") String clientId);

 	List<ControlClientEntering> getControlClientEnterings(@Param("controlClientEntering") ControlClientEntering controlClientEntering);
 	
 	List<ControlClientEntering> getControlClientEnteringsByConditions(@Param("conditions") List<QueryCondition> conditions);

 	//客户信息模糊查询
	List<ControlClientEntering> getControlClientEnterings_new(VagueSelect vagueSelect);

	//有效客户模糊查询
	List<ControlClientEntering> getControlClientEnterings_valid(VagueSelectValidClient vagueSelectValidClient);

}
