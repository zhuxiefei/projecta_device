package com.bdcourtyard.business.clentstatistics.service.impl;

import com.bdcourtyard.business.clentstatistics.dao.CountDao;
import com.bdcourtyard.business.clentstatistics.model.ClientstatisticsParm;
import com.bdcourtyard.business.clentstatistics.model.ClientstatisticsResp;
import com.bdcourtyard.business.clentstatistics.model.TjValue;
import com.bdcourtyard.business.clentstatistics.service.ClientstatisticsService;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.mybatis.QueryCondition;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * Describe this class...
 *
 * @author: Du.Hx
 * @date: 2018/7/27 11:41
 * @version: 1.0
 */

@Service
public class ClientstatisticsServiceImpl implements ClientstatisticsService {

    @Autowired
   private CountDao tjDao;

    @Override
    public ClientstatisticsResp getTj(ClientstatisticsParm clientstatisticsParm) {
        ClientstatisticsResp resp = new ClientstatisticsResp();
        List<QueryCondition> qcs = new ArrayList<QueryCondition>();
        if(String.valueOf(clientstatisticsParm.getComeflag()).equals("1")){
            if(!StringUtils.isNullOrEmpty(String.valueOf(clientstatisticsParm.getStartTime()))){
                qcs.add(new QueryCondition("DATE_FORMAT(a.imputTime,'%Y-%m-%d')",clientstatisticsParm.getStartTime(),QueryCondition.TYPE_MORE_THEN));
            }
            if(!StringUtils.isNullOrEmpty(String.valueOf(clientstatisticsParm.getEndTime()))){
                qcs.add(new QueryCondition("DATE_FORMAT(a.imputTime,'%Y-%m-%d')",clientstatisticsParm.getEndTime(),QueryCondition.TYPE_LES_THEN));
            }
            List<TjValue> userCounts=new ArrayList<TjValue>();
            if(clientstatisticsParm!=null){
                userCounts = tjDao.getUserCounts(qcs);
            }
            resp.setUserCounts(userCounts);
        }
        if(String.valueOf(clientstatisticsParm.getTypeFlag()).equals("1")){
            List<TjValue> typeCount=new ArrayList<TjValue>();
            if(clientstatisticsParm!=null){
               typeCount = tjDao.getTypeCounts();
            }
            resp.setTypeCounts(typeCount);
        }
        if(String.valueOf(clientstatisticsParm.getComeflag()).equals("1")){
            List<TjValue> priceCount=new ArrayList<TjValue>();
            if(clientstatisticsParm!=null){
                priceCount = tjDao.getPriceCounts();
            }
            resp.setPriceCounts(priceCount);
        }

        return resp;
    }

    /**
     * 查看日期格式是否正确
     *
     * @param str
     * @param format
     * @return
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
}
