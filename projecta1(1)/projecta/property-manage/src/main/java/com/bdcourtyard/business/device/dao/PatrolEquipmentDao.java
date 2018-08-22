package com.bdcourtyard.business.device.dao;

import com.bdcourtyard.business.device.model.EquipmentType;
import com.bdcourtyard.business.device.model.PatrolEquipment;
import com.bdcourtyard.business.device.model.PatrolEquipmentPageRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuxiefei
 * @date 2018/8/7 15:49
 */
@Repository
public interface PatrolEquipmentDao {
    ArrayList<EquipmentType> getEquipmentTypeList(@Param("estateId") String estateId);

    PatrolEquipment validateEquipmentNo(PatrolEquipment patrolEquipment);

    int insertPatrolEquipment(PatrolEquipment patrolEquipment);

    Integer updatePatrolEquipmentById(PatrolEquipment patrolEquipment);


    int deletePatrolEquipmentById(@Param("equipmentId") String equipmentId);

    PatrolEquipment getPatrolEquipmentById(String equipmentId);

    List<PatrolEquipment> getPatrolEquipmentsForPage(PatrolEquipmentPageRequest patrolEquipmentPageRequest);
}