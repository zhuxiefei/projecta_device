package com.bdcourtyard.business.building.service.impl;

import com.bdcourtyard.business.building.constant.BuildingConstant;
import com.bdcourtyard.business.building.dao.HouseBuildingDao;
import com.bdcourtyard.business.building.dao.HouseBuildingUnitDao;
import com.bdcourtyard.business.building.domain.UnitInfo;
import com.bdcourtyard.business.building.model.HouseBuilding;
import com.bdcourtyard.business.building.model.HouseBuildingUnit;
import com.bdcourtyard.business.building.service.HouseBuildingUnitService;
import com.bdcourtyard.business.house.dao.HouseHouseDao;
import com.bdcourtyard.business.house.model.HouseHouse;
import com.bdcourtyard.business.housetype.util.Validate;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;
import com.bdcourtyard.common.utils.StringUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * HouseBuildingUnitServiceImpl
 *
 * @version : Ver 1.0
 * @date : 2018-7-23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class HouseBuildingUnitServiceImpl implements HouseBuildingUnitService {

    @Autowired
    private HouseBuildingUnitDao houseBuildingUnitDao;

    @Autowired
    private HouseHouseDao houseDao;

    @Autowired
    private HouseBuildingDao buildingDao;

    public int insertHouseBuildingUnit(HouseBuildingUnit houseBuildingUnit) {
        //判断楼宇下单元名称是否重复
        List<HouseBuildingUnit> units = houseBuildingUnitDao.selectByUnitNameAndBuildingId(houseBuildingUnit.getUnitName(),
                houseBuildingUnit.getBuildingId());
        if (null != units && units.size() > 0) {
            throw new GlobalException("B0008");
        }
        if (StringUtil.isBlank(houseBuildingUnit.getBuildingId())) {
            //楼宇id为空
            throw new GlobalException("B0009");
        }
        validateUnit(houseBuildingUnit);
        houseBuildingUnit.setCreateTime(new Date(System.currentTimeMillis()));
        return houseBuildingUnitDao.insertHouseBuildingUnit(houseBuildingUnit);
    }

    public int insertHouseBuildingUnitBatch(List<HouseBuildingUnit> list) {
        return houseBuildingUnitDao.insertHouseBuildingUnitBatch(list);
    }

    public int updateHouseBuildingUnitById(HouseBuildingUnit houseBuildingUnit) {
        //判断楼宇下单元名称是否重复
        HouseBuildingUnit unit = houseBuildingUnitDao.getHouseBuildingUnitById(houseBuildingUnit.getUnitId());
        if (null == unit) {
            throw new GlobalException("B0012");
        } else {
            List<HouseBuildingUnit> units = houseBuildingUnitDao.selectByUnitNameAndBuildingId(houseBuildingUnit.getUnitName(),
                    unit.getBuildingId());
            if (!unit.getUnitName().equals(houseBuildingUnit.getUnitName())
                    && null != units && units.size() > 0) {
                throw new GlobalException("B0008");
            }
        }
        if (StringUtil.isBlank(houseBuildingUnit.getUnitId())) {
            //单元id为空
            throw new GlobalException("B0014");
        }
        validateUnit(houseBuildingUnit);
        return houseBuildingUnitDao.updateHouseBuildingUnitById(houseBuildingUnit);
    }

    public int deleteHouseBuildingUnitById(String unitId) {
        //判断单元下是否有房屋
        List<HouseHouse> houses = houseDao.selectByUnitId(unitId);
        if (null != houses && houses.size() > 0) {
            throw new GlobalException("B0013");
        } else {
            return houseBuildingUnitDao.deleteHouseBuildingUnitById(unitId);
        }
    }

    public HouseBuildingUnit getHouseBuildingUnitById(String unitId) {
        return houseBuildingUnitDao.getHouseBuildingUnitById(unitId);
    }

    public List<HouseBuildingUnit> getHouseBuildingUnits(HouseBuildingUnit houseBuildingUnit) {
        return houseBuildingUnitDao.getHouseBuildingUnits(houseBuildingUnit);

    }

    public Page<HouseBuildingUnit> getHouseBuildingUnitsForPage(HouseBuildingUnit houseBuildingUnit, Pageable pageable) {

        long count = houseBuildingUnitDao.getHouseBuildingUnits(houseBuildingUnit).size();
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<HouseBuildingUnit> houseBuildingUnits = houseBuildingUnitDao.getHouseBuildingUnits(houseBuildingUnit);

        Page<HouseBuildingUnit> pageDto = new Page<HouseBuildingUnit>();
        pageDto.setPage(pageable.getPageNumber());
        pageDto.setPageSize(pageable.getPageSize());
        if (houseBuildingUnits != null) {
            pageDto.setRows(houseBuildingUnits);
            pageDto.setTotal(count);
        } else {
            pageDto.setRows(new ArrayList<HouseBuildingUnit>());
            pageDto.setTotal(0l);
        }

        return pageDto;
    }

    @Override
    public List<UnitInfo> findByBuildingId(String buildingId) {
        if (null == buildingDao.getHouseBuildingById(buildingId)) {
            return new ArrayList<>();
        } else {
            return houseBuildingUnitDao.findByBuildingId(buildingId);
        }
    }

    private void validateUnit(HouseBuildingUnit unit) {
        if (StringUtil.isEmpty(unit.getUnitName())) {
            //单元名称为空
            throw new GlobalException("B0010");
        } else if (!Validate.isCommonString(unit.getUnitName().trim(), BuildingConstant.BUILDING_NAME_LENGTH)) {
            //单元名称格式错误
            throw new GlobalException("B0011");
        } else if (null != unit.getDisplayOrder()
                && !(unit.getDisplayOrder() + "").matches(BuildingConstant.DISPLAY_RULE)) {
            //排序字段错误
            throw new GlobalException("B0004");
        }
    }
}
