package com.bdcourtyard.business.account.utils;

import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.utils.StringUtil;
import com.beite.tools.utils.AESUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-16 16:35
 * @Description:获取estateId工具
 */
public class EstateUtil {

    /**
     * 获取解密后的estateId
     *
     * @param request
     * @return
     */
    public static String getEstateId(HttpServletRequest request) {
        String estateId = "";
        if (!StringUtil.isBlank(request.getHeader("estateId"))) {
            try {
                estateId = AESUtil.decrypt(request.getHeader("estateId"));
            } catch (Exception e) {
                throw new GlobalException("99999");
            }
        }
        return estateId;
    }
}
