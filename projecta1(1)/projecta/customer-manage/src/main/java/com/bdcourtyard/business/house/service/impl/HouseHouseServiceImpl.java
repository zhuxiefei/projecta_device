package com.bdcourtyard.business.house.service.impl;

import basic.common.core.id.IdUtil;
import com.bdcourtyard.business.building.dao.HouseBuildingDao;
import com.bdcourtyard.business.building.dao.HouseBuildingUnitDao;
import com.bdcourtyard.business.building.model.HouseBuilding;
import com.bdcourtyard.business.house.constant.HouseConstant;
import com.bdcourtyard.business.house.dao.HouseHouseDao;
import com.bdcourtyard.business.house.domain.*;
import com.bdcourtyard.business.house.model.HouseHouse;
import com.bdcourtyard.business.house.service.HouseHouseService;
import com.bdcourtyard.business.houseprice.vo.HouseOrTypePage;
import com.bdcourtyard.business.housetype.constant.TypeConstant;
import com.bdcourtyard.business.housetype.dao.HouseTypeDao;
import com.bdcourtyard.business.housetype.model.HouseType;
import com.bdcourtyard.business.housetype.util.Validate;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.mybatis.QueryCondition;
import com.bdcourtyard.common.page.Page;
import com.bdcourtyard.common.utils.StringUtil;
import com.beite.tools.utils.AESUtil;
import com.github.pagehelper.PageHelper;
import com.mysql.jdbc.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * HouseHouseServiceImpl
 *
 * @version : Ver 1.0
 * @date : 2018-7-23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class HouseHouseServiceImpl implements HouseHouseService {

    @Autowired
    private HouseHouseDao houseHouseDao;

    @Autowired
    private HouseBuildingDao buildingDao;

    @Autowired
    private HouseBuildingUnitDao unitDao;

    @Autowired
    private HouseTypeDao typeDao;

    public int insertHouseHouse(HouseHouse houseHouse, HttpServletRequest request) {
        try {
			houseHouse.setEstateId(AESUtil.decrypt(request.getHeader("estateId")));
        } catch (Exception e) {
            throw new GlobalException("99999");
        }
        if (null != houseHouseDao.findHouseByParams(houseHouse.getBuildingId(), houseHouse.getUnitId(),
                houseHouse.getHouseNum(), houseHouse.getEstateId())) {
            //该房屋已存在
            throw new GlobalException("H0108");
        }
        validateHouse(houseHouse);
        houseHouse.setCreateTime(new Date(System.currentTimeMillis()));
        houseHouse.setHouseNo("H" + IdUtil.getLongId());
        houseHouse.setSaleStatus(1);
        return houseHouseDao.insertHouseHouse(houseHouse);
    }


    public List<ImportMsg> insertHouseHouseBatch(MultipartFile multipartFile, HttpServletRequest request) {
        if (null == multipartFile) {
            throw new GlobalException("H0110");
        } else {
            //获取原始文件名（包括类型）
            String fileName = multipartFile.getOriginalFilename();
            //获取文件类型
            String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (multipartFile.getSize() > HouseConstant.EXCEL_MAX_SIZE) {
                throw new GlobalException("H0111");
            } else if (!fileType.toLowerCase().matches(HouseConstant.EXCEL_RULE)) {
                throw new GlobalException("H0112");
            } else {
                HSSFWorkbook workbook;
                Sheet sheet;
                try {
                    workbook = new HSSFWorkbook(multipartFile.getInputStream());
                    sheet = workbook.getSheetAt(0);
                } catch (IOException e) {
                    throw new GlobalException("H0113");
                }
                String estateId;
                try {
                    estateId = AESUtil.decrypt(request.getHeader("estateId"));
                } catch (Exception e) {
                    throw new GlobalException("99999");
                }
                // 获取到excel文件中的所有行数
                int rows = sheet.getPhysicalNumberOfRows();
                int lastRow = sheet.getLastRowNum();
                if (rows <= 1) {
                    throw new GlobalException("H0110");
                } else {
                    //数据校验失败的房屋列表
                    List<ImportMsg> list = new ArrayList<>();
                    //插入数据库的房屋列表
                    List<HouseHouse> addList = new ArrayList<>();
                    //数据库校验成功的房屋列表（方便进行二次校验）
                    List<ImportMsg> checkList = new ArrayList<>();
                    //验证excel的模型是否正确
                    if (!validateExcel(sheet.getRow(0))) {
                        throw new GlobalException("H0113");
                    }
                    for (int i = 1; i <= lastRow; i++) {
                        // 检测去除空格时是否存在数据 导入时存在空格会默认为一条数据 1去除空格为没有数据 2为有数据
                        int data = 1;
                        Row row = sheet.getRow(i);
                        if (row != null) {
                            ImportMsg importMsg = new ImportMsg();
                            //楼宇名称
                            Cell cell = row.getCell(0);
                            if (cell != null) {
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                if (!StringUtil.isEmpty(cell.getStringCellValue().trim())) {
                                    data = 2;
                                    importMsg.setBuildingName(cell.getStringCellValue().trim());
                                }
                            }
                            //单元名称
                            cell = row.getCell(1);
                            if (cell != null) {
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                if (!StringUtil.isEmpty(cell.getStringCellValue().trim())) {
                                    data = 2;
                                    importMsg.setUnitName(cell.getStringCellValue().trim());
                                }
                            }
                            //房号
                            cell = row.getCell(2);
                            if (cell != null) {
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                if (!StringUtil.isEmpty(cell.getStringCellValue().trim())) {
                                    data = 2;
                                    importMsg.setHouseNum(cell.getStringCellValue().trim());
                                }
                            }
                            //户型
                            cell = row.getCell(3);
                            if (cell != null) {
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                if (!StringUtil.isEmpty(cell.getStringCellValue().trim())) {
                                    data = 2;
                                    importMsg.setTypeName(cell.getStringCellValue().trim());
                                }
                            }
                            //房屋排序
                            cell = row.getCell(4);
                            if (cell != null) {
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                if (!StringUtil.isEmpty(cell.getStringCellValue().trim())) {
                                    data = 2;
                                    importMsg.setDisplayOrder(cell.getStringCellValue().trim());
                                }
                            }
                            //朝向
                            cell = row.getCell(5);
                            if (cell != null) {
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                if (!StringUtil.isEmpty(cell.getStringCellValue().trim())) {
                                    data = 2;
                                    importMsg.setOrientation(cell.getStringCellValue().trim());
                                }
                            }
                            //装修程度
                            cell = row.getCell(6);
                            if (cell != null) {
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                if (!StringUtil.isEmpty(cell.getStringCellValue().trim())) {
                                    data = 2;
                                    importMsg.setDecorationDegree(cell.getStringCellValue().trim());
                                }
                            }
                            //开盘时间
                            cell = row.getCell(7);
                            if (cell != null) {
                                if (0 == cell.getCellType() && DateUtil.isCellDateFormatted(cell)) {
                                    cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    data = 2;
                                    Date d = cell.getDateCellValue();
                                    DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                                    importMsg.setOpenTime(formater.format(d));
                                } else {
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                                    importMsg.setOpenTime(cell.getStringCellValue().trim());
                                }
                            }
                            //楼层
                            cell = row.getCell(8);
                            if (cell != null) {
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                if (!StringUtil.isEmpty(cell.getStringCellValue().trim())) {
                                    data = 2;
                                    importMsg.setFloor(cell.getStringCellValue().trim());
                                }
                            }
                            if (data == 2) {
                                // 进行数据校验
                                HashMap<String, String> result = checkImportInfo(importMsg, estateId);
                                // 判断是否存在错误信息
                                if (result.size() == 0) {
                                    boolean flag = true;
                                    //二次校验
                                    checkList.add(importMsg);
                                    if (checkList.size() > 1) {
                                        for (int j = 0; j < checkList.size() - 1; j++) {
                                            //如果有相同房屋，则排除
                                            if (StringUtil.isEmpty(importMsg.getUnitName()) && !StringUtil.isEmpty(importMsg.getBuildingName())) {
                                                if (importMsg.getBuildingName().equals(checkList.get(j).getBuildingName())
                                                        && StringUtil.isEmpty(checkList.get(j).getUnitName())
                                                        && importMsg.getHouseNum().equals(checkList.get(j).getHouseNum())) {
                                                    flag = false;
                                                }
                                            }
                                            if (!StringUtil.isEmpty(importMsg.getUnitName()) && !StringUtil.isEmpty(importMsg.getBuildingName())) {
                                                if (importMsg.getBuildingName().equals(checkList.get(j).getBuildingName())
                                                        && importMsg.getUnitName().equals(checkList.get(j).getUnitName())
                                                        && importMsg.getHouseNum().equals(checkList.get(j).getHouseNum())) {
                                                    flag = false;
                                                }
                                            }
                                        }
                                    }
                                    //如果和前面的导入数据不重复，则插入
                                    if (flag) {
                                        // 添加房屋
                                        HouseHouse house = new HouseHouse();
                                        house.setHouseId(IdUtil.getLongId() + "");
                                        house.setSaleStatus(1);
                                        house.setHouseNo("H" + IdUtil.getLongId());
                                        house.setEstateId(estateId);
                                        house.setCreateTime(new Date(System.currentTimeMillis()));
                                        if (!StringUtil.isBlank(importMsg.getDisplayOrder())) {
                                            house.setDisplayOrder(Integer.parseInt(importMsg.getDisplayOrder()));
                                        }
                                        house.setHouseNum(importMsg.getHouseNum());
                                        house.setDecorationDegree(Integer.parseInt(importMsg.getDecorationDegree()));
                                        house.setOrientation(Integer.parseInt(importMsg.getOrientation()));
                                        try {
                                            house.setOpenTime(new SimpleDateFormat("yyyy-MM-dd").parse(importMsg.getOpenTime()));
                                        } catch (ParseException e) {
                                            throw new GlobalException("99999");
                                        }
                                        if (importMsg.getTypeName() != null
                                                && typeDao.findByNameAndEstateId(importMsg.getTypeName(), estateId) != null) {
                                            house.setTypeId(typeDao.findByNameAndEstateId(importMsg.getTypeName(), estateId).getTypeId());
                                        }
                                        if (importMsg.getBuildingName() != null
                                                && buildingDao.findByNameAndEstateId(importMsg.getBuildingName(), estateId) != null) {
                                            house.setBuildingId(buildingDao.findByNameAndEstateId(importMsg.getBuildingName(), estateId).getBuildingId());
                                        }
                                        if (importMsg.getUnitName() != null
                                                && buildingDao.findByNameAndEstateId(importMsg.getBuildingName(), estateId) != null) {
                                            String buildingId = buildingDao.findByNameAndEstateId(importMsg.getBuildingName(), estateId).getBuildingId();
                                            house.setUnitId(unitDao.selectByUnitNameAndBuildingId(importMsg.getUnitName(), buildingId).get(0).getUnitId());
                                        }
                                        addList.add(house);
                                    } else {
                                        importMsg.setFailureMsg("该房屋已存在");
                                        list.add(importMsg);
                                    }
                                } else {
                                    importMsg.setFailureMsg(result.get("message"));
                                    list.add(importMsg);
                                }
                            }
                        }
                    }
                    //批量插入数据库
                    if (addList.size() != 0) {
                        houseHouseDao.insertHouseHouseBatch(addList);
                    }
                    if (list.size() != 0) {
                        return list;
                    }
                    //判断是否插入的都是空行
                    if (addList.size() == 0 && list.size() == 0) {
                        throw new GlobalException("H0110");
                    }
                }
            }
        }
        return null;
    }

    public int updateHouseHouseById(HouseHouse houseHouse, HttpServletRequest request) {
        try {
			houseHouse.setEstateId(AESUtil.decrypt(request.getHeader("estateId")));
        } catch (Exception e) {
            throw new GlobalException("99999");
        }
        HouseHouse house = houseHouseDao.getHouseHouseById(houseHouse.getHouseId());
        if (null == house) {
            throw new GlobalException("H0114");
        }
        if (null != houseHouseDao.findHouseByParams(houseHouse.getBuildingId(), houseHouse.getUnitId(),
                houseHouse.getHouseNum(), houseHouse.getEstateId())) {
            if (null != house && !house.getHouseNum().equals(houseHouse.getHouseNum()))
                //该房屋已存在
                throw new GlobalException("H0108");
        }
        validateHouse(houseHouse);
        return houseHouseDao.updateHouseHouseById(houseHouse);
    }

    public int deleteHouseHouseById(String houseId) {
        String[] houseIds = houseId.split(",");
        houseHouseDao.deleteByHouseIds(houseIds);
        return 0;
    }

    public FindHouseResp getHouseHouseById(String houseId) {
        //判断房屋是否被删除
        HouseHouse house = houseHouseDao.getHouseHouseById(houseId);
        if (null == house) {
            throw new GlobalException("H0114");
        }
        return houseHouseDao.findHouseById(houseId);
    }

    public Page<FindAllHousesResp> getHouseHousesForPage(FindAllHousesReq housesReq, Pageable pageable, HttpServletRequest request) {

        try {
            housesReq.setEstateId(AESUtil.decrypt(request.getHeader("estateId")));
        } catch (Exception e) {
            throw new GlobalException("99999");
        }
        validateHouseReq(housesReq);
        long count = houseHouseDao.getHouseHouses(housesReq).size();
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<FindAllHousesResp> houseHouses = houseHouseDao.getHouseHouses(housesReq);

        Page<FindAllHousesResp> pageDto = new Page<>();
        pageDto.setPage(pageable.getPageNumber());
        pageDto.setPageSize(pageable.getPageSize());
        if (houseHouses != null) {
            pageDto.setRows(houseHouses);
            pageDto.setTotal(count);
        } else {
            pageDto.setRows(new ArrayList<FindAllHousesResp>());
            pageDto.setTotal(0l);
        }
        return pageDto;
    }

    private void validateHouseReq(FindAllHousesReq housesReq) {
        if (!StringUtil.isEmpty(housesReq.getHouseNum())) {
            housesReq.setHouseNum(housesReq.getHouseNum().trim());
        }
        if (!StringUtil.isEmpty(housesReq.getTypeName())) {
            housesReq.setTypeName(housesReq.getTypeName().trim());
        }

        if (!StringUtil.isBlank(housesReq.getHouseNum())) {
            if (!Validate.isCommonString(housesReq.getHouseNum(), HouseConstant.HOUSE_NUM_LENGTH)) {
                throw new GlobalException("H0107");
            }
        }
        if (!StringUtil.isBlank(housesReq.getTypeName())) {
            if (!Validate.isCommonString(housesReq.getTypeName(), TypeConstant.TYPE_NAME_LENGTH)) {
                throw new GlobalException("H0115");
            }
        }
        //判断楼宇单元是否存在
        if (housesReq.getBuildingId() != null && null == buildingDao.getHouseBuildingById(housesReq.getBuildingId())) {
            throw new GlobalException("H0101");
        } else if (housesReq.getUnitId() != null && null == unitDao.getHouseBuildingUnitById(housesReq.getUnitId())) {
            throw new GlobalException("H0102");
        }
        if (!StringUtil.isBlank(housesReq.getHouseNum()) && housesReq.getHouseNum().contains("_")) {
            housesReq.setHouseNum(housesReq.getHouseNum().replace("_", "\\_"));
        }
        if (!StringUtil.isBlank(housesReq.getTypeName()) && housesReq.getTypeName().contains("_")) {
            housesReq.setTypeName(housesReq.getTypeName().replace("_", "\\_"));
        }
    }

    @Override
    public List<HouseType> findAllTypes(HttpServletRequest request) {
        String estateId;
        try {
            estateId = AESUtil.decrypt(request.getHeader("estateId"));
        } catch (Exception e) {
            throw new GlobalException("99999");
        }
        return typeDao.findByEstateId(estateId);
    }

    @Override
    public List<FindAllHousesResp> exportHouses(FindAllHousesReq housesReq, HttpServletRequest request) {
        if (!StringUtil.isBlank(housesReq.getHouseIds())) {
            //根据houseId导出
            String[] houseIds = housesReq.getHouseIds().split(",");
            return houseHouseDao.exportByHouseIds(houseIds);
        } else {
            //根据搜索条件导出
            try {
            housesReq.setEstateId(AESUtil.decrypt(request.getHeader("estateId")));
            } catch (Exception e) {
                throw new GlobalException("99999");
            }
            validateHouseReq(housesReq);
            return houseHouseDao.getHouseHouses(housesReq);
        }
    }

    @Override
    public void updateOpenTime(UpdateOpenTimeReq timeReq) {
        houseHouseDao.updateOpenTime(timeReq.getOpenTime(),timeReq.getHouseIds().split(","));
    }

    private void validateHouse(HouseHouse houseReq) {
        if (!StringUtil.isBlank(houseReq.getBuildingId())
                && null == buildingDao.getHouseBuildingById(houseReq.getBuildingId())) {
            //楼宇不存在
            throw new GlobalException("H0101");
        } else if (!StringUtil.isBlank(houseReq.getUnitId())
                && null == unitDao.getHouseBuildingUnitById(houseReq.getUnitId())) {
            //单元不存在
            throw new GlobalException("H0102");
        } else if (StringUtil.isBlank(houseReq.getTypeId())) {
            //户型不能为空
            throw new GlobalException("H0118");
        } else if (!StringUtil.isBlank(houseReq.getTypeId())
                && null == typeDao.getHouseTypeById(houseReq.getTypeId())) {
            //户型不存在
            throw new GlobalException("H0103");
        } else if (!StringUtil.isBlank(houseReq.getUnitId())
                && StringUtil.isBlank(houseReq.getBuildingId())) {
            //有单元无楼宇
            throw new GlobalException("H0104");
        } else if (!StringUtil.isBlank(houseReq.getUnitId()) && !StringUtil.isBlank(houseReq.getBuildingId())
                && null != unitDao.getHouseBuildingUnitById(houseReq.getUnitId())
                && !unitDao.getHouseBuildingUnitById(houseReq.getUnitId()).getBuildingId().equals(houseReq.getBuildingId())) {
            //单元楼宇不匹配
            throw new GlobalException("H0105");
        } else if (StringUtil.isEmpty(houseReq.getHouseNum())) {
            //房号为空
            throw new GlobalException("H0106");
        } else if (StringUtil.isEmpty(houseReq.getHouseNum().trim())) {
            //房号去空格为空
            throw new GlobalException("H0106");
        } else if (!Validate.isCommonString(houseReq.getHouseNum().trim(), HouseConstant.HOUSE_NUM_LENGTH)) {
            //房号格式不符合
            throw new GlobalException("H0107");
        } else if (null != houseReq.getDisplayOrder()
                && !Validate.isNum(houseReq.getDisplayOrder() + "", HouseConstant.ORDER_MAX_LENGTH)) {
            //排序字段错误
            throw new GlobalException("H0109");
        } else if (null == houseReq.getFloor()) {
            //楼层为空
            throw new GlobalException("H0116");
        } else if (!Validate.isNum(houseReq.getFloor()+"",HouseConstant.FLOOR_LENGTH)) {
            //楼层格式不正确
            throw new GlobalException("H0117");
        }
    }

    /**
     * <p>
     * 判断excel文件模板是否正确
     * </p>
     * Author: xiayanxin <br/>
     */
    private boolean validateExcel(Row row) {
        if (!"楼宇名称".equals(row.getCell(0).getStringCellValue().trim())) {
            return false;
        }
        if (!"单元名称".equals(row.getCell(1).getStringCellValue().trim())) {
            return false;
        }
        if (!"房号".equals(row.getCell(2).getStringCellValue().trim())) {
            return false;
        }
        if (!"户型".equals(row.getCell(3).getStringCellValue().trim())) {
            return false;
        }
        if (!"房屋排序".equals(row.getCell(4).getStringCellValue().trim())) {
            return false;
        }
        if (!"朝向（1东2西3南4北5东南6东北7西南8西北）".equals(row.getCell(5).getStringCellValue().trim())) {
            return false;
        }
        if (!"装修程度（1精装修2毛坯）".equals(row.getCell(6).getStringCellValue().trim())) {
            return false;
        }
        if (!"开盘时间（年-月-日）".equals(row.getCell(7).getStringCellValue().trim())) {
            return false;
        }
        if (!"楼层".equals(row.getCell(8).getStringCellValue().trim())) {
            return false;
        }
        return true;
    }

    /**
     * <p>
     * 校验导入的数据
     * </p>
     * Author: xiayanxin <br/>
     *
     * @param importMsg 导入数据入参
     */
    private HashMap<String, String> checkImportInfo(ImportMsg importMsg, String estateId) {
        HashMap<String, String> map = new LinkedHashMap<>();
        if (importMsg.getBuildingName() != null && buildingDao.findByNameAndEstateId(importMsg.getBuildingName(), estateId) == null) {
            map.put("code", "H0101");
            map.put("message", "该楼宇不存在");
            return map;
        }
        if (importMsg.getUnitName() != null
                && (unitDao.selectByUnitNameAndBuildingId(importMsg.getUnitName(), null) == null
                || unitDao.selectByUnitNameAndBuildingId(importMsg.getUnitName(), null).size() == 0)) {
            map.put("code", "H0102");
            map.put("message", "该单元不存在");
            return map;
        }
        if (null == importMsg.getTypeName()) {
            map.put("code", "H0118");
            map.put("message", "请填写户型");
            return map;
        }
        if (importMsg.getTypeName() != null && typeDao.findByNameAndEstateId(importMsg.getTypeName(), estateId) == null) {
            map.put("code", "H0103");
            map.put("message", "该户型不存在");
            return map;
        }
        if (importMsg.getUnitName() != null && importMsg.getBuildingName() == null) {
            map.put("code", "H0101");
            map.put("message", "楼宇不能为空");
            return map;
        }
        if (importMsg.getUnitName() != null && importMsg.getBuildingName() != null) {
            int flag = 0;
            HouseBuilding building = buildingDao.findByNameAndEstateId(importMsg.getBuildingName(), estateId);
            if (building != null
                    && unitDao.selectByUnitNameAndBuildingId(importMsg.getUnitName(), building.getBuildingId()) != null
                    && unitDao.selectByUnitNameAndBuildingId(importMsg.getUnitName(), building.getBuildingId()).size() != 0) {
                flag = 1;
                if (!StringUtil.isEmpty(importMsg.getHouseNum())) {
                    if (null != houseHouseDao.findHouseByParams(
                            building.getBuildingId(),
                            unitDao.selectByUnitNameAndBuildingId(importMsg.getUnitName(), building.getBuildingId()).get(0).getUnitId(),
                            importMsg.getHouseNum(),
                            estateId)) {
                        map.put("code", "H0108");
                        map.put("message", "该房屋已存在");
                        return map;
                    }
                }
            }
            if (flag == 0) {
                map.put("code", "H0105");
                map.put("message", "该单元不属于该楼宇");
                return map;
            }
        }
        if ((importMsg.getUnitName() == null && importMsg.getBuildingName() == null) && !StringUtil.isEmpty(importMsg.getHouseNum())) {
            if (null != houseHouseDao.findHouseByParams(null, null, importMsg.getHouseNum(), estateId)) {
                map.put("code", "H0108");
                map.put("message", "该房屋已存在");
                return map;
            }
        }
        if ((importMsg.getUnitName() == null && importMsg.getBuildingName() != null) && !StringUtil.isEmpty(importMsg.getHouseNum())) {
            HouseBuilding building = buildingDao.findByNameAndEstateId(importMsg.getBuildingName(), estateId);
            String buildingId = null;
            if (building != null) {
                buildingId = building.getBuildingId();
            }
            if (null != houseHouseDao.findHouseByParams(buildingId, null, importMsg.getHouseNum(), estateId)) {
                map.put("code", "H0108");
                map.put("message", "该房屋已存在");
                return map;
            }
        }
        if (StringUtil.isEmpty(importMsg.getHouseNum())) {
            map.put("code", "H0106");
            map.put("message", "房号不能为空");
        } else if (!Validate.isCommonString(importMsg.getHouseNum().trim(), HouseConstant.HOUSE_NUM_LENGTH)) {
            map.put("code", "H0107");
            map.put("message", "房号不能输入\\<>’”%且长度不超过6位");
        } else if (StringUtil.isEmpty(importMsg.getDisplayOrder())) {
            map.put("code", "H0109");
            map.put("message", "房屋序号不能为空");
        } else if (!StringUtil.isBlank(importMsg.getDisplayOrder())
                && !Validate.isNum(importMsg.getDisplayOrder(), HouseConstant.ORDER_MAX_LENGTH)) {
            map.put("code", "H0109");
            map.put("message", "房屋排序只能输入正整数，且不超过10000");
        } else if (!StringUtil.isBlank(importMsg.getOrientation())
                && !Validate.isNum(importMsg.getOrientation(), 8)) {
            map.put("code", "");
            map.put("message", "朝向请填写1~8的整数");
        } else if (!StringUtil.isBlank(importMsg.getDecorationDegree())
                && !Validate.isNum(importMsg.getDecorationDegree(), 2)) {
            map.put("code", "");
            map.put("message", "朝向请填写1~2的整数");
        } else if (!StringUtil.isBlank(importMsg.getOpenTime())
                && !Validate.validateTime(importMsg.getOpenTime())) {
            map.put("code", "");
            map.put("message", "开盘时间请填写年-月-日格式");
        } else if (!StringUtil.isBlank(importMsg.getOpenTime())
                && !Validate.validateTimeDistance(new SimpleDateFormat("yyyy-MM-dd").format(new Date()),
                importMsg.getOpenTime())) {
            map.put("code", "");
            map.put("message", "开盘时间不能早于当前时间");
        } else if (StringUtil.isBlank(importMsg.getFloor())) {
            map.put("code", "H0116");
            map.put("message", "楼层不能为空");
        } else if (!Validate.isNum(importMsg.getFloor(),HouseConstant.FLOOR_LENGTH)) {
            map.put("code", "H0117");
            map.put("message", "楼层请填写1-200的整数");
        }
        return map;
    }

    /**
     * 根据楼宇和单元的id获取相关的房屋
     * @param buildingId
     * @param unitId
     * @return
     */
    @Override
    public List<HouseOrTypePage> getHouseOrtypes(String buildingId, String unitId) {
        List<QueryCondition> qcs = new ArrayList<QueryCondition>();
        if(!StringUtils.isNullOrEmpty(buildingId)){
            qcs.add(new QueryCondition("a.buildingId", buildingId));
        }

        if(!StringUtils.isNullOrEmpty(unitId)){
            qcs.add(new QueryCondition("a.unitId", unitId));
        }
        List<HouseOrTypePage> houseOrTypePages = houseHouseDao.findHouseOrTypePageParams(buildingId,unitId);
        return houseOrTypePages;
    }

}
