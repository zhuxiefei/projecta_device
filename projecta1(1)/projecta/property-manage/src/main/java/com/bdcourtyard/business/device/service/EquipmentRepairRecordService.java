package com.bdcourtyard.business.device.service;

import com.bdcourtyard.business.device.model.EquipmentRepairRecord;
import com.bdcourtyard.business.device.model.PatrolEquipment;
import com.bdcourtyard.business.device.vo.EquipmentRepairRecordDetail;
import com.bdcourtyard.business.device.vo.EquipmentRepairRecordRequest;
import com.bdcourtyard.business.device.vo.EquipmentRepairRecordResponse;
import com.bdcourtyard.common.page.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author zhuxiefei
 * @date 2018/8/9 19:27
 */
public interface EquipmentRepairRecordService {


    List<PatrolEquipment> getPatrolEquipmentByNo(String estateId, String equipmentNo);

    int insertEquipmentRecord(EquipmentRepairRecord equipmentRepairRecord);

    int updateEquipmentRepairRecordById(EquipmentRepairRecord equipmentRepairRecord);

    EquipmentRepairRecordDetail getEquipmentRepairRecordById(String recordId);

    Page<EquipmentRepairRecordResponse> getEquipmentRepairRecordsForPage(String estateId, Pageable pageable, EquipmentRepairRecordRequest equipmentRepairRecordRequest);

    List<EquipmentRepairRecordResponse> getEquipmentRepairRecordForExport(EquipmentRepairRecordRequest equipmentRepairRecordRequest,String estateId);
}