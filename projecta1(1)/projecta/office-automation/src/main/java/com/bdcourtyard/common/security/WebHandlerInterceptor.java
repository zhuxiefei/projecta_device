package com.bdcourtyard.common.security;

import com.bdcourtyard.business.account.dao.EmployeeAccountDao;
import com.bdcourtyard.business.account.dao.EmployeePrivilegeDao;
import com.bdcourtyard.business.account.model.CompanyEmployee;
import com.bdcourtyard.business.account.model.EmployeePrivilege;
import com.bdcourtyard.common.response.Response;
import com.bdcourtyard.common.response.StatusCode;
import com.beite.tools.redis.RedisManager;
import com.beite.tools.utils.AESUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cxx on 2018/7/16.
 */
@Component
public class WebHandlerInterceptor implements HandlerInterceptor{

    @Autowired
    EmployeeAccountDao employeeAccountDao;

    @Autowired
    EmployeePrivilegeDao employeePrivilegeDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        //获取当前请求接口url
//        String url = request.getRequestURI();
//        Response response = new Response();
//        String token = request.getHeader("token");
//        String acctName = request.getHeader("acctName");
//        String estateId = request.getHeader("estateId");
//        if(null == acctName || null == token || "".equals(acctName) || "".equals(token)){
//            response.setCode(StatusCode.UNAUTHORIZED);
//            response.setMsg("无权限");
//            responseOut(response, httpServletResponse);
//            return false;
//        }else {
//            String tokenContent = RedisManager.get(acctName);
//            if(!token.equals(tokenContent)){
//                response.setCode(StatusCode.UNAUTHORIZED);
//                response.setMsg("无权限");
//                responseOut(response, httpServletResponse);
//                return false;
//            }else {
//                //查询用户接口权限
//                //先查询对应的角色
//                CompanyEmployee companyEmployee = employeeAccountDao.getRoleIdByAcctNameAndEstateId(AESUtil.decrypt(acctName),AESUtil.decrypt(estateId));
//                //3代表接口权限
//                List<EmployeePrivilege> privileges = employeePrivilegeDao.getPrivilegesByRoleId(companyEmployee.getRoleId(),"3");
//                List<String> list = new ArrayList<>();
//                for(EmployeePrivilege employeePrivilege:privileges){
//                    list.add(employeePrivilege.getPrivilegeName());
//                }
//                if(!list.contains(url)){
//                    response.setCode(StatusCode.UNAUTHORIZED);
//                    response.setMsg("无权限");
//                    responseOut(response, httpServletResponse);
//                    return false;
//                }
//            }
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * <p>
     * 输入gson
     * </p>
     * Author: Cui.xx <br/>
     * Date: 2017/5/16 18:01
     *
     * @param obj
     * @param response
     * @throws IOException
     */
    private void responseOut(Object obj, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        out.print(gson.toJson(obj));
    }
}
