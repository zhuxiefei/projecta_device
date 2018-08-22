package com.bdcourtyard.business.device.service;

import com.bdcourtyard.business.device.model.EquipmentType;
import com.bdcourtyard.business.device.model.EquipmentTypePageParam;
import com.bdcourtyard.common.page.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author zhuxiefei
 * @date 2018/8/6 19:41
 */
public interface EquipmentTypeService {
    int insertEquipmentType(EquipmentType equipmentType);

    int updateEquipmentTypeById(EquipmentType equipmentType);

    void deleteEquiomentTypeById(String typeId);

    EquipmentType getEquipmentTypeById(String typeId);

    Page<EquipmentType> getEquipmentTypesForPage(String estateId, Pageable pageable, EquipmentTypePageParam param);
}