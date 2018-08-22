package com.bdcourtyard.business.device.dao;

import com.bdcourtyard.business.device.model.EquipmentType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @author zhuxiefei
 * @date 2018/8/6 19:40
 */
@Repository
public interface EquipmentTypeDao {
    //验证
    EquipmentType validateTypeName(EquipmentType equipmentType);

    int insertEquipmentType(EquipmentType equipmentType);

    int updateEquipmentTypeById(EquipmentType equipmentType);

    int deleteEquipmentTypeById(@Param("typeId") String typeId);

    EquipmentType getEquipmentTypeById(String typeId);

    List<EquipmentType> getEquipmentTypes_new(HashMap map);
}