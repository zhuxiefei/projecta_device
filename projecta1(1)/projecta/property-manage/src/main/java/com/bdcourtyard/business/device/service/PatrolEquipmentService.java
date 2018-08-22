package com.bdcourtyard.business.device.service;

import com.bdcourtyard.business.device.model.EquipmentType;
import com.bdcourtyard.business.device.model.PatrolEquipment;
import com.bdcourtyard.business.device.model.PatrolEquipmentPageRequest;
import com.bdcourtyard.common.page.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

/**
 * @author zhuxiefei
 * @date 2018/8/7 15:47
 */
public interface PatrolEquipmentService {
    ArrayList<EquipmentType> getEquipmentTypeList(String estateId);

    int insertPatrolEquipment(PatrolEquipment patrolEquipment);

    Integer updatePatrolEquipmentById(PatrolEquipment patrolEquipment);

    boolean deletePatrolEquipmentById(String equipmentIds);

    PatrolEquipment getPatrolEquipmentById(String equipmentId);


    Page<PatrolEquipment> getPatrolEquipmentForPage(PatrolEquipmentPageRequest patrolEquipmentPageRequest, Pageable pageable, String estateId);
}