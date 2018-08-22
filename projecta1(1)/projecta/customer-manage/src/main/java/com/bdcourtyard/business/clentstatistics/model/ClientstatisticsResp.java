package com.bdcourtyard.business.clentstatistics.model;

import java.util.List;

/**
 * <p>
 * Describe this class...
 *
 * @author: Du.Hx
 * @date: 2018/7/27 15:20
 * @version: 1.0
 */
public class ClientstatisticsResp {
    List<TjValue> userCounts;
    List<TjValue> typeCounts;
    List<TjValue> priceCounts;

    public List<TjValue> getUserCounts() {
        return userCounts;
    }

    public void setUserCounts(List<TjValue> userCounts) {
        this.userCounts = userCounts;
    }

    public List<TjValue> getTypeCounts() {
        return typeCounts;
    }

    public void setTypeCounts(List<TjValue> typeCounts) {
        this.typeCounts = typeCounts;
    }

    public List<TjValue> getPriceCounts() {
        return priceCounts;
    }

    public void setPriceCounts(List<TjValue> priceCounts) {
        this.priceCounts = priceCounts;
    }
}
