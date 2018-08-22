package com.bdcourtyard.business.device.service.impl;

import com.bdcourtyard.business.device.dao.EquipmentRepairRecordDao;
import com.bdcourtyard.business.device.model.EquipmentRepairRecord;
import com.bdcourtyard.business.device.model.PatrolEquipment;
import com.bdcourtyard.business.device.service.EquipmentRepairRecordService;
import com.bdcourtyard.business.device.vo.EquipmentRepairRecordDetail;
import com.bdcourtyard.business.device.vo.EquipmentRepairRecordRequest;
import com.bdcourtyard.business.device.vo.EquipmentRepairRecordResponse;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;
import com.bdcourtyard.common.utils.StringUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
 * @date 2018/8/9 19:26
 */
@Service
public class EquipmentRepairRecordServiceImpl implements EquipmentRepairRecordService {
    @Autowired
    private EquipmentRepairRecordDao equipmentRepairRecordDao;


    @Override
    public List<PatrolEquipment> getPatrolEquipmentByNo(String estateId, String equipmentNo) {
        if (estateId ==null||"".equals(estateId)){
            throw new GlobalException("H0001");
        }
        if (equipmentNo==null||"".equals(equipmentNo)){
            throw new GlobalException("DE017");
        }
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("estateId",estateId);
        map.put("equipmentNo",equipmentNo);
        return  equipmentRepairRecordDao.getPatrolEquipmentByNo(map);

    }

    @Override
    public int insertEquipmentRecord(EquipmentRepairRecord equipmentRepairRecord) {
        if (equipmentRepairRecord!=null){
            //判断设备id是否为空
            if (StringUtil.isEmpty(equipmentRepairRecord.getEquipmentId())){
                throw new GlobalException("DE046");
            }
        }else {
            throw new GlobalException("DE010");
        }

        //新增前校验
        validateEquipmentRepairRecord(equipmentRepairRecord);

        int i = 1;
        try {
            //更新设备维修次数
            equipmentRepairRecordDao.updateEquipmentRepairNumber(equipmentRepairRecord);
            //新增设备维保记录
            equipmentRepairRecordDao.insertEquipmentRepairRecord(equipmentRepairRecord);
        } catch (Exception e) {
            i = 0;
        }
        return i;
    }

    @Override
    public int updateEquipmentRepairRecordById(EquipmentRepairRecord equipmentRepairRecord) {
        //更新前校验
        if (equipmentRepairRecord!=null){
            //判断维保记录Id是否为空
            if (StringUtil.isEmpty(equipmentRepairRecord.getRecordId())){
                throw new GlobalException("DE055");
            }
        }else {
            throw new GlobalException("DE010");
        }

        //新增前校验
        validateEquipmentRepairRecord(equipmentRepairRecord);
        return equipmentRepairRecordDao.updateEquipmentRepairRecordById(equipmentRepairRecord);

    }

    @Override
    public EquipmentRepairRecordDetail getEquipmentRepairRecordById(String recordId) {
        EquipmentRepairRecordDetail e = equipmentRepairRecordDao.getEquipmentRepairRecordById(recordId);
        if(e!=null){
            if(e.getEquipmentCreateTime()!=null&&e.getEquipmentCreateTime().length()>9){
                e.setEquipmentCreateTime(e.getEquipmentCreateTime().substring(0,10));
            }
            if(e.getDeadline()!=null&&e.getDeadline().length()>9){
                e.setDeadline(e.getDeadline().substring(0,10));
            }
            if(e.getRepairTime()!=null&&e.getRepairTime().length()>9){
                e.setRepairTime(e.getRepairTime().substring(0,10));
            }

        }
        return e;
    }

    @Override
    public Page<EquipmentRepairRecordResponse> getEquipmentRepairRecordsForPage(String estateId, Pageable pageable, EquipmentRepairRecordRequest equipmentRepairRecordRequest) {
        if (StringUtil.isEmpty(estateId)){
            throw new GlobalException("H0001");
        }else {
            equipmentRepairRecordRequest.setEstateId(estateId.trim());
        }
        if (equipmentRepairRecordRequest.getStartTime()!=null&&!("".equals(equipmentRepairRecordRequest.getStartTime().trim()))) {
            if (equipmentRepairRecordRequest.getStartTime().length() > 10) {
                boolean b = checkDate(equipmentRepairRecordRequest.getStartTime(), "yyyy-MM-dd HH:mm:ss");
                if (!b) {
                    throw new GlobalException("DE002");
                }
            } else {
                boolean b = checkDate(equipmentRepairRecordRequest.getStartTime(), "yyyy-MM-dd");

                if (!b) {
                    throw new GlobalException("DE002");
                } else {
                    equipmentRepairRecordRequest.setStartTime(equipmentRepairRecordRequest.getStartTime() + "00:00:00");
                }
            }
        }
        if (equipmentRepairRecordRequest.getEndTime()!=null&&!("".equals(equipmentRepairRecordRequest.getEndTime().trim()))) {
            if (equipmentRepairRecordRequest.getEndTime().length() > 10) {
                boolean b = checkDate(equipmentRepairRecordRequest.getEndTime(), "yyyy-MM-dd HH:mm:ss");
                if (!b) {
                    throw new GlobalException("DE002");
                }
            } else {
                boolean b = checkDate(equipmentRepairRecordRequest.getEndTime(), "yyyy-MM-dd");

                if (!b) {
                    throw new GlobalException("DE002");
                } else {
                    equipmentRepairRecordRequest.setEndTime(equipmentRepairRecordRequest.getEndTime() + "23:59:59");
                }
            }
        }
        //判断开始时间和结束时间大小
        if (equipmentRepairRecordRequest.getStartTime()!=null&&!("".equals(equipmentRepairRecordRequest.getStartTime().trim()))&&
                equipmentRepairRecordRequest.getEndTime()!=null&&!("".equals(equipmentRepairRecordRequest.getEndTime().trim()))){
            if (!compare_date(equipmentRepairRecordRequest.getStartTime(),equipmentRepairRecordRequest.getEndTime())){
                throw new GlobalException("");
            }
        }

        if (equipmentRepairRecordRequest!=null&&equipmentRepairRecordRequest.getKeywords()!=null){
            equipmentRepairRecordRequest.setKeywords(equipmentRepairRecordRequest.getKeywords().trim());
            if (isSpecialChar(equipmentRepairRecordRequest.getKeywords().trim())||equipmentRepairRecordRequest.getKeywords().trim().length()>60){
                throw new GlobalException("");
            }
        }

        Page<EquipmentRepairRecordResponse> pageDto = new Page<EquipmentRepairRecordResponse>();


        long count = equipmentRepairRecordDao.getEquipmentRepairRecordsForPage(equipmentRepairRecordRequest).size();
        PageHelper.startPage(pageable.getPageNumber(),pageable.getPageSize());
        List<EquipmentRepairRecordResponse> list = equipmentRepairRecordDao.getEquipmentRepairRecordsForPage(equipmentRepairRecordRequest);


        if (list!=null){
            pageDto.setPage(pageable.getPageNumber());
            pageDto.setPageSize(pageable.getPageSize());
            pageDto.setRows(list);
            pageDto.setTotal(count);
        }else {
            pageDto.setRows(new ArrayList<EquipmentRepairRecordResponse>());
            pageDto.setTotal(0l);
        }
        return pageDto;

    }

    @Override
    public List<EquipmentRepairRecordResponse> getEquipmentRepairRecordForExport(EquipmentRepairRecordRequest equipmentRepairRecordRequest,String estateId) {
       if (StringUtil.isEmpty(estateId)){
           throw new GlobalException("DE001");
       }else {
           equipmentRepairRecordRequest.setEstateId(estateId.trim());
       }
        if (equipmentRepairRecordRequest.getStartTime()!=null&&!("".equals(equipmentRepairRecordRequest.getStartTime().trim()))) {
            if (equipmentRepairRecordRequest.getStartTime().length() > 10) {
                boolean b = checkDate(equipmentRepairRecordRequest.getStartTime(), "yyyy-MM-dd HH:mm:ss");
                if (!b) {
                    throw new GlobalException("DE002");
                }
            } else {
                boolean b = checkDate(equipmentRepairRecordRequest.getStartTime(), "yyyy-MM-dd");

                if (!b) {
                    throw new GlobalException("DE002");
                } else {
                    equipmentRepairRecordRequest.setStartTime(equipmentRepairRecordRequest.getStartTime() + "00:00:00");
                }
            }
        }
        if (equipmentRepairRecordRequest.getEndTime()!=null&&!("".equals(equipmentRepairRecordRequest.getEndTime().trim()))) {
            if (equipmentRepairRecordRequest.getEndTime().length() > 10) {
                boolean b = checkDate(equipmentRepairRecordRequest.getEndTime(), "yyyy-MM-dd HH:mm:ss");
                if (!b) {
                    throw new GlobalException("DE002");
                }
            } else {
                boolean b = checkDate(equipmentRepairRecordRequest.getEndTime(), "yyyy-MM-dd");

                if (!b) {
                    throw new GlobalException("DE002");
                } else {
                    equipmentRepairRecordRequest.setEndTime(equipmentRepairRecordRequest.getEndTime() + "23:59:59");
                }
            }
        }
        //判断开始时间和结束时间大小
        if (equipmentRepairRecordRequest.getStartTime()!=null&&!("".equals(equipmentRepairRecordRequest.getStartTime().trim()))&&
                equipmentRepairRecordRequest.getEndTime()!=null&&!("".equals(equipmentRepairRecordRequest.getEndTime().trim()))){
            if (!compare_date(equipmentRepairRecordRequest.getStartTime(),equipmentRepairRecordRequest.getEndTime())){
                throw new GlobalException("");
            }
        }

        if (equipmentRepairRecordRequest!=null&&equipmentRepairRecordRequest.getKeywords()!=null){
            equipmentRepairRecordRequest.setKeywords(equipmentRepairRecordRequest.getKeywords().trim());
            if (isSpecialChar(equipmentRepairRecordRequest.getKeywords().trim())||equipmentRepairRecordRequest.getKeywords().trim().length()>60){
                throw new GlobalException("");
            }
        }

        if (equipmentRepairRecordRequest.getEquipmentName()!=null&&!("".equals(equipmentRepairRecordRequest.getEquipmentName().trim()))){
            boolean b = isSpecialChar(equipmentRepairRecordRequest.getEquipmentName().trim());
            if (b){
                throw new GlobalException("DE012");
            }
            if(equipmentRepairRecordRequest.getEquipmentName().trim().length()>50){
                throw new GlobalException("DE013");
            }
            equipmentRepairRecordRequest.setEquipmentName(equipmentRepairRecordRequest.getEquipmentName().trim());
        }
        if (equipmentRepairRecordRequest.getEquipmentLocation()!=null&&!("".equals(equipmentRepairRecordRequest.getEquipmentLocation().trim()))){
            boolean b = isSpecialChar(equipmentRepairRecordRequest.getEquipmentLocation().trim());
            if (b){
                throw new GlobalException("DE018");
            }
            if(equipmentRepairRecordRequest.getEquipmentLocation().trim().length()>50){
                throw new GlobalException("DE019");
            }
            equipmentRepairRecordRequest.setEquipmentLocation(equipmentRepairRecordRequest.getEquipmentLocation().trim());
        }

        List<EquipmentRepairRecordResponse> list =equipmentRepairRecordDao.getEquipmentRepairRecordsForPage(equipmentRepairRecordRequest);

        return list;
    }

    public void validateEquipmentRepairRecord(EquipmentRepairRecord equipmentRepairRecord){
        if (equipmentRepairRecord!=null){

            //维修厂商
            if (StringUtil.isEmpty(equipmentRepairRecord.getEquipmentOperator())){
                throw new GlobalException("DE040");
            }else {
                if (equipmentRepairRecord.getEquipmentOperator().trim().length()>50){
                    throw new GlobalException("DE039");
                }
                equipmentRepairRecord.setEquipmentOperator(equipmentRepairRecord.getEquipmentOperator().trim());
            }
            //维修厂商电话
            if (StringUtil.isEmpty(equipmentRepairRecord.getOperatorPhone())){
                throw new GlobalException("DE043");
            }else {
                if (equipmentRepairRecord.getOperatorPhone().trim().length()>20){
                    throw new GlobalException("DE041");
                }
                equipmentRepairRecord.setOperatorPhone(equipmentRepairRecord.getOperatorPhone().trim());

            }
            //维修内容
            if (StringUtil.isEmpty(equipmentRepairRecord.getRepairDesc())){
                throw new GlobalException("DE051");
            }else {
                if (equipmentRepairRecord.getRepairDesc().trim().length()>500){
                    throw new GlobalException("DE052");
                }
                equipmentRepairRecord.setRepairDesc(equipmentRepairRecord.getRepairDesc());
            }

            //维修费用
            if (StringUtil.isEmpty(equipmentRepairRecord.getRepairExpense())){
                throw new GlobalException("DE048");
            }else {
                boolean b;
                try {
                    Double.parseDouble(equipmentRepairRecord.getRepairExpense());
                    b = false;
                } catch (Exception e) {
                    b = true;
                }
                if (b){
                    throw new GlobalException("DE049");
                }
                double d = Double.parseDouble(equipmentRepairRecord.getRepairExpense());
                if (d>100000000.00||d<1.00){
                    throw new GlobalException("DE050");
                }
            }
            //质保期
            if (StringUtil.isEmpty(equipmentRepairRecord.getQualityPeriod())){
                throw new GlobalException("");
            }else{
                if (equipmentRepairRecord.getQualityPeriod().trim().length()>20){
                    throw new GlobalException("");
                }
                equipmentRepairRecord.setQualityPeriod(equipmentRepairRecord.getQualityPeriod().trim());
            }
            //维修时间
            if (StringUtil.isEmpty(equipmentRepairRecord.getRepairTime())){
                throw new GlobalException("DE053");
            }else {
                if (equipmentRepairRecord.getRepairTime().trim().length()>10){
                    throw new GlobalException("DE056");
                }
                if (!checkDate(equipmentRepairRecord.getRepairTime(),"yyyy-MM-dd")){

                    throw new GlobalException("DE054");
                }
            }
        }else {
            throw new GlobalException("DE010");
        }
    }

    /**
    * @Description: 判断日期格式是否正确
    * @Param:
    * @return:
    */
    public static boolean checkDate(String str, String format) {

        DateFormat formatter = new SimpleDateFormat(format);
        try {
            Date date = formatter.parse(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * 判断是否含有特殊字符
     *
     * @param str
     * @return true为包含，false为不包含
     */
    public static boolean isSpecialChar(String str) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }

    /**
     * 时间比较  若date1>date2返回false
     *
     * @param DATE1
     * @param DATE2
     * @return
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

    /**
     * 利用正则表达式判断字符串是否是数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
}
