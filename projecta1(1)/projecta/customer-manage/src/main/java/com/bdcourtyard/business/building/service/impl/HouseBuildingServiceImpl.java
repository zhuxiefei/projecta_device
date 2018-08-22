package com.bdcourtyard.business.building.service.impl;

import com.bdcourtyard.business.building.constant.BuildingConstant;
import com.bdcourtyard.business.building.dao.HouseBuildingDao;
import com.bdcourtyard.business.building.dao.HouseBuildingUnitDao;
import com.bdcourtyard.business.building.domain.BuildingInfo;
import com.bdcourtyard.business.building.model.HouseBuilding;
import com.bdcourtyard.business.building.service.HouseBuildingService;
import com.bdcourtyard.business.house.dao.HouseHouseDao;
import com.bdcourtyard.business.house.model.HouseHouse;
import com.bdcourtyard.business.housetype.util.Validate;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;
import com.bdcourtyard.common.utils.StringUtil;
import com.beite.tools.utils.AESUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * HouseBuildingServiceImpl
 *
 * @version : Ver 1.0
 * @date    : 2018-7-23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class HouseBuildingServiceImpl implements HouseBuildingService {

    @Autowired
    private HouseBuildingDao houseBuildingDao;

    @Autowired
    private HouseHouseDao houseDao;

    @Autowired
    private HouseBuildingUnitDao unitDao;

    public int insertHouseBuilding(HouseBuilding houseBuilding, HttpServletRequest request) {
        try {
			houseBuilding.setEstateId(AESUtil.decrypt(request.getHeader("estateId")));
        } catch (Exception e) {
            throw new GlobalException("99999");
        }
        if (null != houseBuildingDao.findByNameAndEstateId(houseBuilding.getBuildingName(),
                houseBuilding.getEstateId())) {
            //楼宇名称已存在
            throw new GlobalException("B0005");
        }
        validateBuilding(houseBuilding);
        houseBuilding.setCreateTime(new Date(System.currentTimeMillis()));
        return houseBuildingDao.insertHouseBuilding(houseBuilding);
    }

    public int insertHouseBuildingBatch(List<HouseBuilding> list) {
        return houseBuildingDao.insertHouseBuildingBatch(list);
    }

    public int updateHouseBuildingById(HouseBuilding houseBuilding) {
        validateBuilding(houseBuilding);
        HouseBuilding building = houseBuildingDao.getHouseBuildingById(houseBuilding.getBuildingId());
        if (null == building) {
            throw new GlobalException("B0006");
        } else {
            if (!building.getBuildingName().equals(houseBuilding.getBuildingName())
                    && null != houseBuildingDao.findByNameAndEstateId(houseBuilding.getBuildingName(), houseBuilding.getEstateId())) {
                //楼宇名称已存在
                throw new GlobalException("B0005");
            }
        }
        return houseBuildingDao.updateHouseBuildingById(houseBuilding);
    }

    public int deleteHouseBuildingById(String buildingId) {
        //判断该楼宇下是否有房屋
        List<HouseHouse> houses = houseDao.selectByBuildingId(buildingId);
        if (null != houses && houses.size() > 0){
            throw new GlobalException("B0007");
        }
        houseBuildingDao.deleteHouseBuildingById(buildingId);
        unitDao.deleteByBuildingId(buildingId);
        return 0;
    }

    public HouseBuilding getHouseBuildingById(String buildingId) {
        HouseBuilding building = houseBuildingDao.getHouseBuildingById(buildingId);
        if (null == building) {
            throw new GlobalException("B0006");
        }
        return houseBuildingDao.getHouseBuildingById(buildingId);
    }

    public List<HouseBuilding> getHouseBuildings(HouseBuilding houseBuilding) {
        return houseBuildingDao.getHouseBuildings(houseBuilding);

    }

    public Page<HouseBuilding> getHouseBuildingsForPage(HouseBuilding houseBuilding, Pageable pageable) {

        long count = houseBuildingDao.getHouseBuildings(houseBuilding).size();
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<HouseBuilding> houseBuildings = houseBuildingDao.getHouseBuildings(houseBuilding);

        Page<HouseBuilding> pageDto = new Page<HouseBuilding>();
        pageDto.setPage(pageable.getPageNumber());
        pageDto.setPageSize(pageable.getPageSize());
        if (houseBuildings != null) {
            pageDto.setRows(houseBuildings);
            pageDto.setTotal(count);
        } else {
            pageDto.setRows(new ArrayList<HouseBuilding>());
            pageDto.setTotal(0l);
        }

        return pageDto;
    }

    @Override
    public List<BuildingInfo> findBuildingList(HttpServletRequest request) {
        String estateId;
        try {
            estateId = AESUtil.decrypt(request.getHeader("estateId"));
        } catch (Exception e) {
            throw new GlobalException("99999");
        }
        return houseBuildingDao.findBuildingList(estateId);
    }

    private void validateBuilding(HouseBuilding building) {
        if (StringUtil.isEmpty(building.getBuildingName())) {
            //楼宇名称为空
            throw new GlobalException("B0001");
        } else if (!Validate.isCommonString(building.getBuildingName().trim(), BuildingConstant.BUILDING_NAME_LENGTH)) {
            //楼宇名称格式错误
            throw new GlobalException("B0002");
        } else if (!StringUtil.isEmpty(building.getBuildingDesc())
                && building.getBuildingDesc().length() > BuildingConstant.BUILDING_DESC_SIZE) {
            //楼宇描述格式错误
            throw new GlobalException("B0003");
        } else if (null != building.getDisplayOrder()
                && !(building.getDisplayOrder() + "").matches(BuildingConstant.DISPLAY_RULE)) {
            //排序字段错误
            throw new GlobalException("B0004");
        }
    }
}
