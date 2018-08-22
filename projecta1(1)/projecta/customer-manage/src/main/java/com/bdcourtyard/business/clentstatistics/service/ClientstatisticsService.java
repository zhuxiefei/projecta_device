package com.bdcourtyard.business.clentstatistics.service;

import com.bdcourtyard.business.clentstatistics.model.ClientstatisticsParm;
import com.bdcourtyard.business.clentstatistics.model.ClientstatisticsResp;

/**
 * <p>
 * Describe this class...
 *
 * @author: Du.Hx
 * @date: 2018/7/27 11:40
 * @version: 1.0
 */
public interface ClientstatisticsService {
     ClientstatisticsResp getTj(ClientstatisticsParm clientstatisticsParm);
}

