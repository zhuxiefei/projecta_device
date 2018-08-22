package com.bdcourtyard.business.device.service.impl;

import com.bdcourtyard.business.device.dao.EquipmentTypeDao;
import com.bdcourtyard.business.device.dao.PatrolEquipmentDao;
import com.bdcourtyard.business.device.model.EquipmentType;
import com.bdcourtyard.business.device.model.PatrolEquipment;
import com.bdcourtyard.business.device.model.PatrolEquipmentPageRequest;
import com.bdcourtyard.business.device.service.PatrolEquipmentService;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;
import com.bdcourtyard.common.utils.StringUtil;
import com.github.pagehelper.PageHelper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhuxiefei
 * @date 2018/8/7 15:48
 */
@Service
public class PatrolEquipmentServiceImpl implements PatrolEquipmentService {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(PatrolEquipmentServiceImpl.class);
    @Autowired
    private PatrolEquipmentDao patrolEquipmentDao;


    @Autowired
    private EquipmentTypeDao equipmentTypeDao;

    @Override
    public ArrayList<EquipmentType> getEquipmentTypeList(String estateId) {
        if (StringUtils.isEmpty(estateId)){
            throw new GlobalException("DE001");
        }
        return patrolEquipmentDao.getEquipmentTypeList(estateId);
    }

    @Override
    public int insertPatrolEquipment(PatrolEquipment patrolEquipment) {

        patrolEquipment = validateColumn(patrolEquipment);
        //新增前校验
        PatrolEquipment p = patrolEquipmentDao.validateEquipmentNo(patrolEquipment);
        if (p!=null){
            throw new GlobalException("DE047");
        }
        EquipmentType e = equipmentTypeDao.getEquipmentTypeById(patrolEquipment.getEquipmentType());
        if (e==null||e.getTypeName()==null){
            throw new GlobalException("DE058");

        }
        return patrolEquipmentDao.insertPatrolEquipment(patrolEquipment);

    }

    @Override
    public Integer updatePatrolEquipmentById(PatrolEquipment patrolEquipment) {
        if (patrolEquipment!=null&&!StringUtils.isEmpty(patrolEquipment.getEquipmentId())){
            throw new GlobalException("DE046");
        }
        //更新前校验
        patrolEquipment = validateColumn(patrolEquipment);
        PatrolEquipment p = patrolEquipmentDao.validateEquipmentNo(patrolEquipment);
        if (p!=null){
            throw new GlobalException("DE047");
        }
        EquipmentType e = equipmentTypeDao.getEquipmentTypeById(patrolEquipment.getEquipmentType());
        if (e==null||e.getTypeName()==null){
            throw new GlobalException("DE058");
        }
        return patrolEquipmentDao.updatePatrolEquipmentById(patrolEquipment);
    }

    @Override
    public boolean deletePatrolEquipmentById(String equipmentIds) {
        try {
            String[] ids = equipmentIds.split(",");
            for (String id :ids){
                if (id !=null&&!("".equals(id))){
                    patrolEquipmentDao.deletePatrolEquipmentById(id);
                }
            }
            return true;

        }catch (Exception e){
            log.error("异常",e);
            return false;
        }

    }

    @Override
    public PatrolEquipment getPatrolEquipmentById(String equipmentId) {
        return patrolEquipmentDao.getPatrolEquipmentById(equipmentId);
    }

    @Override
    public Page<PatrolEquipment> getPatrolEquipmentForPage(PatrolEquipmentPageRequest patrolEquipmentPageRequest, Pageable pageable, String estateId) {
        //判断是否登录
        if (estateId  == null || "".equals(estateId)){
            throw new GlobalException("H0001");
        }

        if (patrolEquipmentPageRequest.getStartTime()!=null&&!("".equals(patrolEquipmentPageRequest.getStartTime().trim()))){
            if (patrolEquipmentPageRequest.getStartTime().length()>10){
                boolean b = checkDate(patrolEquipmentPageRequest.getStartTime(),"yyyy-MM-dd HH:mm:ss");
                if (!b){
                    //do something 格式错误
                    throw new GlobalException("DE002");
                }
            }else {
                boolean b = checkDate(patrolEquipmentPageRequest.getStartTime(),"yyyy-MM-dd");
                if (!b){
                    //do something 格式错误
                    throw new GlobalException("DE002");
                }else {
                    patrolEquipmentPageRequest.setStartTime(patrolEquipmentPageRequest.getStartTime()+"00:00:00");
                }

            }

        }

        if (patrolEquipmentPageRequest.getEndTime()!=null&&!("".equals(patrolEquipmentPageRequest.getEndTime().trim()))){
            if (patrolEquipmentPageRequest.getEndTime().length()>10){
                boolean b = checkDate(patrolEquipmentPageRequest.getEndTime(),"yyyy-MM-dd HH:mm:ss");
                if (!b){
                    //do something 格式错误
                    throw new GlobalException("DE002");
                }
            }else {
                boolean b = checkDate(patrolEquipmentPageRequest.getEndTime(),"yyyy-MM-dd");
                if (!b){
                    //do something 格式错误
                    throw new GlobalException("DE002");
                }else {
                    patrolEquipmentPageRequest.setEndTime(patrolEquipmentPageRequest.getEndTime()+"00:00:00");
                }

            }

        }
        if (patrolEquipmentPageRequest.getEquipmentName()!=null&&!("".equals(patrolEquipmentPageRequest.getEquipmentName()))){

            boolean b = isSpecialChar(patrolEquipmentPageRequest.getEquipmentName().trim());
            if (b){
                throw new GlobalException("DE015");
            }
            if (patrolEquipmentPageRequest.getEquipmentName().length()>50){
                throw new GlobalException("DE016");
            }
            patrolEquipmentPageRequest.setEquipmentName(patrolEquipmentPageRequest.getEquipmentName().trim());
        }
        if (patrolEquipmentPageRequest.getEquipmentNo()!=null&&!("".equals(patrolEquipmentPageRequest.getEquipmentNo()))){

            boolean b = isSpecialChar(patrolEquipmentPageRequest.getEquipmentNo().trim());
            if (b){
                throw new GlobalException("DE012");
            }
            if (patrolEquipmentPageRequest.getEquipmentNo().length()>50){
                throw new GlobalException("DE013");
            }
            patrolEquipmentPageRequest.setEquipmentNo(patrolEquipmentPageRequest.getEquipmentNo().trim());

        }
        if (patrolEquipmentPageRequest.getEquipmentLocation()!=null&&!("".equals(patrolEquipmentPageRequest.getEquipmentLocation()))){

            boolean b = isSpecialChar(patrolEquipmentPageRequest.getEquipmentLocation().trim());
            if (b){
                throw new GlobalException("DE018");
            }
            if (patrolEquipmentPageRequest.getEquipmentLocation().length()>50){
                throw new GlobalException("DE019");
            }
            patrolEquipmentPageRequest.setEquipmentLocation(patrolEquipmentPageRequest.getEquipmentLocation().trim());

        }

        //分页
        Page<PatrolEquipment> pageDto = new Page<PatrolEquipment>();

        long count = patrolEquipmentDao.getPatrolEquipmentsForPage(patrolEquipmentPageRequest).size();

        PageHelper.startPage(pageable.getPageNumber(),pageable.getPageSize());

        List<PatrolEquipment> list = patrolEquipmentDao.getPatrolEquipmentsForPage(patrolEquipmentPageRequest);

        if (list!=null){
            pageDto.setPage(pageable.getPageNumber());
            pageDto.setPageSize(pageable.getPageSize());
            pageDto.setRows(list);
            pageDto.setTotal(count);
        }else {
            pageDto.setRows(new ArrayList<PatrolEquipment>());
            pageDto.setTotal(0l);
        }

        return pageDto;


    }


    /**
    * @Description: 新增or更新时校验
    * @Param:
    * @return:
    */

    public static PatrolEquipment validateColumn(PatrolEquipment patrolEquipment) {
        if (patrolEquipment != null) {
            //二维码
            patrolEquipment.setEquipmentQRCode("");//暂时设为空
            if (!StringUtils.isEmpty(patrolEquipment.getEquipmentName())) {
                boolean b = isSpecialChar(patrolEquipment.getEquipmentName().trim());
                if (b) {
                    throw new GlobalException("DE012");
                }
                if (patrolEquipment.getEquipmentName().trim().length() > 50) {
                    throw new GlobalException("DE013");
                }
            } else {
                throw new GlobalException("DE011");
            }
            //
            if (!StringUtils.isEmpty(patrolEquipment.getEquipmentNo())) {
                boolean b = isSpecialChar(patrolEquipment.getEquipmentNo().trim());
                if (b) {
                    throw new GlobalException("DE015");
                }
                if (patrolEquipment.getEquipmentNo().trim().length() > 50) {
                    throw new GlobalException("DE016");
                }
            } else {
                throw new GlobalException("DE017");
            }
            if (StringUtils.isEmpty(patrolEquipment.getEquipmentType())) {
                throw new GlobalException("DE014");
            }
            //
            if (!StringUtils.isEmpty(patrolEquipment.getEquipmentLocation())) {
                boolean b = isSpecialChar(patrolEquipment.getEquipmentLocation().trim());
                if (b) {
                    throw new GlobalException("DE018");
                }
                if (patrolEquipment.getEquipmentLocation().trim().length() > 50) {
                    throw new GlobalException("DE019");
                }
            } else {
                throw new GlobalException("DE020");
            }
            //是否巡检
            if (patrolEquipment.getIsCheck() != null) {
                if (patrolEquipment.getIsCheck() == 1) {
                    if (!StringUtils.isEmpty(patrolEquipment.getEquipmentDesc())) {
                        if (patrolEquipment.getEquipmentDesc().trim().length() > 500) {
                            throw new GlobalException("DE024");
                        } else {
                        patrolEquipment.setEquipmentDesc(patrolEquipment.getEquipmentDesc().trim());
                    }

                } else {
                    throw new GlobalException("DE023");
                }
                if (patrolEquipment.getCheckCycle() != null) {//巡检周期判断
                    if (patrolEquipment.getCheckCycle() > 5 || patrolEquipment.getCheckCycle() < 1) {
                        //巡检周期 1、每日巡检 2、每周巡检 3、月度巡检 4、季度巡检 5、年度巡检
                        throw new GlobalException("DE025");
                    }
                } else {
                    throw new GlobalException("DE025");
                }
            } else if (patrolEquipment.getIsCheck() == 2) {//不巡检
                patrolEquipment.setEquipmentDesc("");
                patrolEquipment.setCheckCycle(0);

            } else {//异常字段
                throw new GlobalException("DE022");
            }

            } else {
                throw new GlobalException("DE021");
            }
        //设备生产日期
        //设备生产日期
        if (patrolEquipment.getEquipmentCreateTime() != null && !("").equals(patrolEquipment.getEquipmentCreateTime())) {
            String scTime = patrolEquipment.getEquipmentCreateTime().trim();
            if (!checkDate(scTime, "yyyy-MM-dd")) {
                throw new GlobalException("DE027");
            }
        } else {
            throw new GlobalException("DE026");
        }
        //质保期值
        if (patrolEquipment.getQualityPeriod() != null) {
            String num = patrolEquipment.getQualityPeriod().trim();
            if (isNumeric(num)) {
                patrolEquipment.setQualityPeriod(num);
            } else {
                throw new GlobalException("DE028");
            }
        } else {
            throw new GlobalException("DE029");
        }
        //质保期单位
        if (patrolEquipment.getUnit() != null) {
            if (patrolEquipment.getUnit() != 1 && patrolEquipment.getUnit() != 2) {
                throw new GlobalException("DE045");
            }
        } else {
            throw new GlobalException("DE045");
        }

        //报修截止日期
        if (patrolEquipment.getDeadline() != null && !("").equals(patrolEquipment.getDeadline())) {
            String bxTime = patrolEquipment.getDeadline().trim();
            if (!checkDate(bxTime, "yyyy-MM-dd")) {
                throw new GlobalException("DE030");
            }
        } else {
            throw new GlobalException("DE031");
        }
        //设备生产厂商
        if (patrolEquipment.getEquipmentProducer() != null && !("".equals(patrolEquipment.getEquipmentProducer().trim()))) {
            boolean b = isSpecialChar(patrolEquipment.getEquipmentProducer().trim());
            if (b) { //有特殊字符
                throw new GlobalException("DE032");
            }
            if (patrolEquipment.getEquipmentProducer().trim().length() > 50) { //长度校验
                throw new GlobalException("DE033");
            }
            patrolEquipment.setEquipmentProducer(patrolEquipment.getEquipmentProducer().trim());
        } else {
            throw new GlobalException("DE034");
        }
        //生产厂商电话
        if (patrolEquipment.getProducerPhone() != null && !(patrolEquipment.getProducerPhone().trim().equals(""))) {
            String prophone = patrolEquipment.getProducerPhone().trim();
            if (prophone.length() > 20) {
                throw new GlobalException("DE037");
            }

            patrolEquipment.setProducerPhone(prophone);


        } else {
            throw new GlobalException("DE035");
        }
        //设备维修厂商
        if (patrolEquipment.getEquipmentOperator() != null && !("".equals(patrolEquipment.getEquipmentOperator().trim()))) {
            boolean b = isSpecialChar(patrolEquipment.getEquipmentOperator().trim());
            if (b) { //有特殊字符
                throw new GlobalException("DE038");
            }
            if (patrolEquipment.getEquipmentOperator().trim().length() > 50) { //长度校验
                throw new GlobalException("DE039");
            }
            patrolEquipment.setEquipmentOperator(patrolEquipment.getEquipmentOperator().trim());
        } else {
            throw new GlobalException("DE040");
        }
        //维修厂商电话
        if (patrolEquipment.getOperatorPhone() != null && !(patrolEquipment.getOperatorPhone().trim().equals(""))) {
            String wxphone = patrolEquipment.getOperatorPhone().trim();
            if (wxphone.length() > 20) {
                throw new GlobalException("DE041");
            }

            patrolEquipment.setOperatorPhone(wxphone);

        } else {
            throw new GlobalException("DE043");
        }
        //维修次数
        if (patrolEquipment.getRepairNumber() != null) {
            if (patrolEquipment.getRepairNumber() > 999999999) {
                throw new GlobalException("DE044");
            }
        } else {
            patrolEquipment.setRepairNumber(0);
        }


    } else {
        throw new GlobalException("DE010", "参数为NULL");
    }

    return patrolEquipment;
    }

    /**
    * @Description: 判断是否有特殊字符
    * @Param:
    * @return:  true为包含，false为不包含
    */
    public static boolean isSpecialChar(String str){
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }


    /**
    * @Description:  判断日期格式是否正确
    * @Param:
    * @return:
    */
    public static boolean checkDate(String str,String format){
        DateFormat formatter = new SimpleDateFormat(format);
        try {
            Date date = formatter.parse(str);
            return true;
        } catch (Exception e) {
            return false;
        }
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







































































