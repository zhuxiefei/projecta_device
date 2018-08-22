package com.bdcourtyard.business.returncust.service;
import com.bdcourtyard.business.clientmessage.model.UpdateControlClientEnteringResp;
import com.bdcourtyard.business.returncust.model.ControlClientEntering;
import com.bdcourtyard.business.returncust.vo.RoomsourceReturnRecord;
import org.springframework.data.domain.Pageable;
import com.bdcourtyard.business.returncust.vo.RoomsourceReturncust;
import java.util.List;
import com.bdcourtyard.common.page.Page;

/**
 *  RoomsourceReturncustService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-25
 */
public interface RoomsourceReturncustService {

	int insertRoomsourceReturncustBatch(List<RoomsourceReturncust> list);

	int updateRoomsourceReturncustById(RoomsourceReturncust roomsourceReturncust);

	int deleteRoomsourceReturncustById(String returnId);

	RoomsourceReturncust getRoomsourceReturncustById(String returnId);

	List<RoomsourceReturncust> getRoomsourceReturncusts(RoomsourceReturncust roomsourceReturncust);

	Page<RoomsourceReturncust> getRoomsourceReturncustsForPage(RoomsourceReturncust roomsourceReturncust, Pageable pageable);

	Page<RoomsourceReturncust> getRoomsourceReturncustsForPage_new(RoomsourceReturncust roomsourceReturncust, Pageable pageable);

	Page<RoomsourceReturnRecord> getReturnRecordForPage(RoomsourceReturnRecord roomsourceReturnRecord, Pageable pageable);

	ControlClientEntering getControlClientEnteringById(java.lang.String clientId);

	int updateClientAndAddRecord(String employeeId,UpdateControlClientEnteringResp updateControlClientEnteringResp);
}
