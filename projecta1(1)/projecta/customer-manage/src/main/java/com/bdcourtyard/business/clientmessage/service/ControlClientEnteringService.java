package com.bdcourtyard.business.clientmessage.service;

import com.bdcourtyard.business.clientmessage.model.ControlClientEntering;
import com.bdcourtyard.business.clientmessage.model.VagueSelect;
import com.bdcourtyard.business.clientmessage.model.VagueSelectValidClient;
import com.bdcourtyard.common.page.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 *  ControlClientEnteringService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-24 
 */
public interface ControlClientEnteringService {
	
	int insertControlClientEntering(ControlClientEntering controlClientEntering);
	
	int insertControlClientEnteringBatch(List<ControlClientEntering> list);
	
	int updateControlClientEnteringById(ControlClientEntering controlClientEntering);
	
	boolean deleteControlClientEnteringById(String clientId);

 	ControlClientEntering getControlClientEnteringById(String clientId);
 
 	List<ControlClientEntering> getControlClientEnterings(ControlClientEntering controlClientEntering);

 	Page<ControlClientEntering> getControlClientEnteringsForPage(VagueSelect vagueSelect, Pageable pageable);
	//客户信息模糊查询
	List<ControlClientEntering> getControlClientEnteringsExport(VagueSelect vagueSelect);
	//有效客户列表模糊查询
	Page<ControlClientEntering> getControlClientEnterings_valid(VagueSelectValidClient vagueSelectValidClient, Pageable pageable);

}
