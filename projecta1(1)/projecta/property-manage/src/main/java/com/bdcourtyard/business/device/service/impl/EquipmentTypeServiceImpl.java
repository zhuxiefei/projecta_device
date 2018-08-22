package com.bdcourtyard.business.device.service.impl;

import com.bdcourtyard.business.device.dao.EquipmentTypeDao;
import com.bdcourtyard.business.device.model.EquipmentType;
import com.bdcourtyard.business.device.model.EquipmentTypePageParam;
import com.bdcourtyard.business.device.service.EquipmentTypeService;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhuxiefei
 * @date 2018/8/6 19:41
 */
@Service
@Transactional
public class EquipmentTypeServiceImpl implements EquipmentTypeService {

    @Autowired
    private EquipmentTypeDao equipmentTypeDao;

    @Override
    public int insertEquipmentType(EquipmentType equipmentType) {
        // !StringUtils.isEmpty(equipmentType.getTypeName())
        if (equipmentType != null && !StringUtils.isEmpty(equipmentType.getTypeName())) {
            //判断是否有特殊字符
            boolean b = isSpecialChar(equipmentType.getTypeName());
            //如果有特殊字符
            if (b) {
                throw new GlobalException("DE012");
            }
            //判断是否过长
            if (equipmentType.getTypeName().length() > 50) {
                throw new GlobalException("DE013");
            }
        } else {
            throw new GlobalException("DE011");
        }

        equipmentType.setCreateTime(new Date(System.currentTimeMillis()));
        equipmentType.setTypeName(equipmentType.getTypeName().trim());
        //校验
        EquipmentType type = equipmentTypeDao.validateTypeName(equipmentType);
        if (type != null) {
            throw new GlobalException("DE007");
        }
        return equipmentTypeDao.insertEquipmentType(equipmentType);
    }

    @Override
    public int updateEquipmentTypeById(EquipmentType equipmentType) {
        if (equipmentType != null && !StringUtils.isEmpty(equipmentType.getTypeId())) {

        } else {
            throw new GlobalException("DE007");
        }

        if (equipmentType != null && !StringUtils.isEmpty(equipmentType.getTypeName())) {
            boolean b = isSpecialChar(equipmentType.getTypeName());
            //存在特殊字符
            if (b) {
                throw new GlobalException("DE004");
            }
            //名称过长
            if (equipmentType.getTypeName().length() > 50) {
                throw new GlobalException("DE005");
            }
        } else {
            throw new GlobalException("DE003");
        }
        //校验
        equipmentType.setTypeName(equipmentType.getTypeName().trim());
        EquipmentType type = equipmentTypeDao.validateTypeName(equipmentType);
        if (type != null) {
            throw new GlobalException("DE007");
        }
        return equipmentTypeDao.updateEquipmentTypeById(equipmentType);
    }

    @Override
    public void deleteEquiomentTypeById(String typeIds) {
        String[] ids = typeIds.split(",");
        for (String id : ids) {
            equipmentTypeDao.deleteEquipmentTypeById(id);
        }
    }

    @Override
    public EquipmentType getEquipmentTypeById(String typeId) {
        return equipmentTypeDao.getEquipmentTypeById(typeId);
    }

    @Override
    public Page<EquipmentType> getEquipmentTypesForPage(String estateId, Pageable pageable, EquipmentTypePageParam param) {
        if (StringUtils.isEmpty(estateId)) {
            throw new GlobalException("DE001");
        }

        String typeName = "";
        if (!StringUtils.isEmpty(param.getTypeName())) {
            boolean b = isSpecialChar(param.getTypeName().trim());
            //有特殊字符
            if (b) {
                throw new GlobalException("DE004");
            }
            if (param.getTypeName().length() > 50) {
                throw new GlobalException("DE005");
            }
            typeName = param.getTypeName().trim();
        }
        String startTime = "";
        if (param.getStartTime() != null && !("".equals(param.getStartTime().trim()))) {
            if (param.getStartTime().length() > 10) {
                boolean b = checkDate(param.getStartTime(), "yyyy-MM-dd HH:mm:ss");
                if (!b) {
                    //do something 格式错误
                    throw new GlobalException("DE002");
                } else {
                    startTime = param.getStartTime();
                }
            } else {
                boolean b = checkDate(param.getStartTime(), "yyyy-MM-dd");
                if (!b) {
                    //do something 格式错误
                    throw new GlobalException("DE002");
                } else {
                    startTime = param.getStartTime() + " 00:00:00";
                }
            }

        }
        String endTime = "";
        if (param.getEndTime() != null && !("".equals(param.getEndTime().trim()))) {
            if (param.getEndTime().length() > 10) {
                boolean b = checkDate(param.getEndTime(), "yyyy-MM-dd HH:mm:ss");
                if (!b) {
                    //do something 格式错误
                    throw new GlobalException("DE002");
                } else {
                    endTime = param.getEndTime();
                }
            } else {
                boolean b = checkDate(param.getEndTime(), "yyyy-MM-dd");
                if (!b) {
                    //do something 格式错误
                    throw new GlobalException("DE002");
                } else {
                    endTime = param.getEndTime() + " 23:59:59";
                }

            }

        }


        //判断开始时间和结束时间大小
        if (startTime != null && !("".equals(startTime.trim())) && endTime != null && !("".equals(endTime.trim()))) {
            if (!compare_date(startTime, endTime)) {
                throw new GlobalException("DE006");
            }

        }

        Page<EquipmentType> pageDto = new Page<EquipmentType>();

        HashMap map = new HashMap<String, Object>();
        map.put("startTime", startTime);
        map.put("endTime", endTime);
        map.put("estateId", estateId);
        map.put("typeName", typeName);
        long count = equipmentTypeDao.getEquipmentTypes_new(map).size();
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<EquipmentType> list = equipmentTypeDao.getEquipmentTypes_new(map);


        if (list != null) {
            pageDto.setPage(pageable.getPageNumber());
            pageDto.setPageSize(pageable.getPageSize());
            pageDto.setRows(list);
            pageDto.setTotal(count);
        } else {
            pageDto.setRows(new ArrayList<EquipmentType>());
            pageDto.setTotal(0l);
        }

        return pageDto;
    }


    /**
     * @Description: 判断是否含有特殊字符
     * @Param:
     * @return:
     */


    public static boolean isSpecialChar(String str) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();

    }

    /**
     * @Description: 查看日期格式是否正确
     * @Param:
     * @return:
     */

    public static boolean checkDate(String string, String format) {
        DateFormat formatter = new SimpleDateFormat(format);
        try {
            Date date = formatter.parse(string);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @Description: 时间比较
     * @Param:
     * @return:
     */
    public static boolean compare_date(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() >= dt2.getTime()) {
                return false;
            } else {
                return true;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }

    }
}