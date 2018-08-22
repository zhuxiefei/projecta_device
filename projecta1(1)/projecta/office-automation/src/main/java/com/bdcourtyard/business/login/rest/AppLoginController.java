package com.bdcourtyard.business.login.rest;

import com.bdcourtyard.business.login.model.*;
import com.bdcourtyard.business.login.service.LoginService;
import com.bdcourtyard.common.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by cxx on 2018/7/17.
 */
@RestController
@Api(value = "AppLoginController", description = "app登录相关")
@RequestMapping("oa/common/employee")
public class AppLoginController {

    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "app登录", notes = "app登录")
    @RequestMapping(value = "/v1/appLogin",method = RequestMethod.POST)
    public Response<AppLoginResp> appLogin(@RequestBody AppLoginReq appLoginReq, HttpServletRequest request, HttpSession session){
        return new Response(loginService.appLogin(appLoginReq,request,session));
    }

    @ApiOperation(value = "获取验证码（登陆和忘记密码通用）", notes = "获取验证码")
    @RequestMapping(value = "/v1/getSmsCode",method = RequestMethod.POST)
    public Response getSmsCode(@RequestBody GetCodeReq getCodeReq){
        loginService.getSmsCode(getCodeReq);
        return new Response();
    }

    @ApiOperation(value = "忘记密码-校验账号是否存在已经验证码是否正确", notes = "校验账号是否存在已经验证码是否正确")
    @RequestMapping(value = "/v1/checkCode",method = RequestMethod.POST)
    public Response checkCode(@RequestBody CheckCodeReq checkCodeReq){
        loginService.checkCode(checkCodeReq.getMobile(),checkCodeReq.getCode());
        return new Response();
    }

    @ApiOperation(value = "忘记密码-修改密码", notes = "修改密码")
    @RequestMapping(value = "/v1/updatePwd",method = RequestMethod.POST)
    public Response updatePwd(@RequestBody UpdatePwdReq updatePwdReq){
        loginService.updatePwd(updatePwdReq.getMobile(),updatePwdReq.getNewPwd());
        return new Response();
    }
}
