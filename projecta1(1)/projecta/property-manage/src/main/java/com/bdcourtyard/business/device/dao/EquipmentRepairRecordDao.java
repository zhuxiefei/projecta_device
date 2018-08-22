package com.bdcourtyard.business.device.dao;

import com.bdcourtyard.business.device.model.EquipmentRepairRecord;
import com.bdcourtyard.business.device.model.PatrolEquipment;
import com.bdcourtyard.business.device.vo.EquipmentRepairRecordDetail;
import com.bdcourtyard.business.device.vo.EquipmentRepairRecordRequest;
import com.bdcourtyard.business.device.vo.EquipmentRepairRecordResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @author zhuxiefei
 * @date 2018/8/10 9:52
 */
@Repository
public interface EquipmentRepairRecordDao {

    List<PatrolEquipment> getPatrolEquipmentByNo(HashMap map);

    int updateEquipmentRepairNumber(EquipmentRepairRecord equipmentRepairRecord);

    int insertEquipmentRepairRecord(EquipmentRepairRecord equipmentRepairRecord);

    int updateEquipmentRepairRecordById(EquipmentRepairRecord equipmentRepairRecord);

    EquipmentRepairRecordDetail getEquipmentRepairRecordById(@Param("recordId") String recordId);

    List<EquipmentRepairRecordResponse> getEquipmentRepairRecordsForPage(EquipmentRepairRecordRequest equipmentRepairRecordRequest);


}