package com.bdcourtyard.business.returncust.dao;
import com.bdcourtyard.business.clientmessage.model.UpdateControlClientEnteringResp;
import com.bdcourtyard.business.returncust.model.ControlClientEntering;
import com.bdcourtyard.business.returncust.vo.RoomsourceReturnRecord;
import com.bdcourtyard.business.returncust.vo.RoomsourceReturncust;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.bdcourtyard.common.mybatis.QueryCondition;

/**
 *  RoomsourceReturncustDao 回访记录
 *
 * @version : Ver 1.0
 * @date	: 2018-7-25
 */
@Repository
public interface RoomsourceReturncustDao {

	int insertRoomsourceReturncust(RoomsourceReturnRecord roomsourceReturnRecord);

	int insertRoomsourceReturncustBatch(List<RoomsourceReturncust> list);

	int updateRoomsourceReturncustById(RoomsourceReturncust roomsourceReturncust);

	int deleteRoomsourceReturncustById(@Param("returnId") String returnId);

	RoomsourceReturncust getRoomsourceReturncustById(@Param("returnId") String returnId);

	List<RoomsourceReturncust> getRoomsourceReturncusts(@Param("roomsourceReturncust") RoomsourceReturncust roomsourceReturncust);

	List<RoomsourceReturncust> getRoomsourceReturncustsByConditions(@Param("conditions") List<QueryCondition> conditions);

	List<RoomsourceReturncust> getCustomerReturnPage(RoomsourceReturncust roomsourceReturncust);

	List<RoomsourceReturnRecord> getReturnRecordForPage(RoomsourceReturnRecord roomsourceReturnRecord);

	ControlClientEntering getControlClientEnteringById(@Param("clientId")  java.lang.String clientId  );

	int updateControlClientEnteringById(UpdateControlClientEnteringResp updateControlClientEnteringResp);

	Set<String> getNeedReturnClientId(RoomsourceReturncust roomsourceReturncust);

	List<String> getNeedReturnTimeList(@Param("clientId")  java.lang.String clientId );
	int delAllNeedReturnByClientId(UpdateControlClientEnteringResp updateControlClientEnteringResp);
	int insertNeedReturnTime(HashMap map);

}
