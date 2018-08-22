package com.bdcourtyard.business.user.rest;

import com.bdcourtyard.business.user.domain.AppVersionInfo;
import com.bdcourtyard.business.user.domain.EditPwdReq;
import com.bdcourtyard.business.user.domain.SystemNoticeInfo;
import com.bdcourtyard.business.user.domain.UserInfoResp;
import com.bdcourtyard.business.user.model.UserFeedback;
import com.bdcourtyard.business.user.service.UserService;
import com.bdcourtyard.common.page.Page;
import com.bdcourtyard.common.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-25 14:06
 * @Description:
 */
@RestController
@Api(value = "UserController", description = "营销助手APP--个人中心")
@RequestMapping("/oa/assistantApp/user")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询个人信息", notes = "查询个人信息")
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public Response<Object> getUserInfo(HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("========/app/user/v1/getUserInfo start==========");
        }
        Response<Object> response = new Response<Object>();
        UserInfoResp userInfoResp = userService.getUserInfo(request);
        response.setData(userInfoResp);
        if (LOG.isInfoEnabled()) {
            LOG.info("========/app/user/v1/getUserInfo end=========response=" + response);
        }
        return response;
    }

    @ApiOperation(value = "修改密码", notes = "修改密码")
    @RequestMapping(value = "/editPwd", method = RequestMethod.POST)
    public Response<Object> editPwd(HttpServletRequest request, @RequestBody EditPwdReq editPwdReq) {
        if (LOG.isInfoEnabled()) {
            LOG.info("========/app/user/v1/editPwd start==========");
        }
        Response<Object> response = new Response<Object>();
        userService.updatePwd(editPwdReq, request);
        if (LOG.isInfoEnabled()) {
            LOG.info("========/app/user/v1/editPwd end=========response=" + response);
        }
        return response;
    }

    @ApiOperation(value = "修改头像", notes = "修改头像")
    @RequestMapping(value = "/updateHead", method = RequestMethod.POST)
    public Response<Object> updateHead(HttpServletRequest request, MultipartFile photo) {
        if (LOG.isInfoEnabled()) {
            LOG.info("========/app/user/v1/updateHead start==========");
        }
        Response<Object> response = new Response<Object>();
        userService.updateHead(photo, request);
        if (LOG.isInfoEnabled()) {
            LOG.info("========/app/user/v1/updateHead end=========response=" + response);
        }
        return response;
    }

    @ApiOperation(value = "添加意见反馈", notes = "添加意见反馈")
    @RequestMapping(value = "/addFeedBack", method = RequestMethod.POST)
    public Response<String> addFeedBack(HttpServletRequest request, @RequestBody UserFeedback feedback) {
        if (LOG.isInfoEnabled()) {
            LOG.info("========/propertyapp/system/v1/addFeedBack start========feedback=" + feedback);
        }
        Response<String> response = new Response<>();
        userService.addFeedback(request, feedback);
        if (LOG.isInfoEnabled()) {
            LOG.info("========/propertyapp/system/v1/addFeedBack end========response=" + response);
        }
        return response;
    }

    @ApiOperation(value = "查看意见反馈列表", notes = "查看意见反馈列表")
    @RequestMapping(value = "/findAllFeedback", method = RequestMethod.GET)
    public Response<Page<UserFeedback>> findAllFeedback(@RequestParam(value = "page", defaultValue = "1") int page,
                                                        @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                                        HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("========/propertyapp/system/v1/findAllFeedback start========");
        }
        Pageable pageable = new PageRequest(page, pageSize);
        Page<UserFeedback> pageDto = userService.findAllFeedback(pageable, request);
        Response<Page<UserFeedback>> response = new Response<>(pageDto);
        if (LOG.isInfoEnabled()) {
            LOG.info("========/propertyapp/system/v1/findAllFeedback end========response=" + response);
        }
        return response;
    }

    @ApiOperation(value = "查询系统通知的未读数量", notes = "查询系统通知的未读数量")
    @RequestMapping(value = "/findUnreadNumber", method = RequestMethod.GET)
    public Response<Integer> findUnreadNumber(HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("======== app/notice/v1/findSystemNotice start ========");
        }
        Response<Integer> response = new Response();
        response.setData(userService.findSystemNotices(request));
        if (LOG.isInfoEnabled()) {
            LOG.info("======== app/notice/v1/findSystemNotice end ========response=" + response);
        }
        return response;
    }

    @ApiOperation(value = "查询系统通知详情", notes = "查询系统通知详情")
    @RequestMapping(value = "/v1/findSystemNotice", method = RequestMethod.GET)
    public Response<SystemNoticeInfo> findSystemNotice(@RequestParam String noticeId) {
        if (LOG.isInfoEnabled()) {
            LOG.info("======== app/notice/v1/findSystemNotice start ========noticeId=" + noticeId);
        }
        Response<SystemNoticeInfo> response = new Response();
        response.setData(userService.findNoticeInfo(noticeId));
        if (LOG.isInfoEnabled()) {
            LOG.info("======== app/notice/v1/findSystemNotice end ========response=" + response);
        }
        return response;
    }

    @ApiOperation(value = "查询系统通知列表", notes = "查询系统通知列表")
    @RequestMapping(value = "/findAllSystemNotice", method = RequestMethod.GET)
    public Response<Page<SystemNoticeInfo>> findAllSystemNotice(@RequestParam(value = "page", defaultValue = "1") int page,
                                                                @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                                                HttpServletRequest request) {
        if (LOG.isInfoEnabled()) {
            LOG.info("======== app/notice/v1/findAllSystemNotice start ========page=" + page);
        }
        Pageable pageable = new PageRequest(page, pageSize);
        Page<SystemNoticeInfo> pageDto = userService.findAllNotices(request, pageable);
        Response<Page<SystemNoticeInfo>> response = new Response<>(pageDto);
        if (LOG.isInfoEnabled()) {
            LOG.info("======== app/notice/v1/findAllSystemNotice end ========response=" + response);
        }
        return response;
    }

    @ApiOperation(value = "检查版本更新", notes = "检查版本更新")
    @RequestMapping(value = "/findAppVersion", method = RequestMethod.GET)
    public Response<AppVersionInfo> findAppVersion() {
        if (LOG.isInfoEnabled()) {
            LOG.info("========app/version/v1/findAppVersion start");
        }
        Response<AppVersionInfo> response = new Response<>();
        response.setData(userService.findVersion());
        if (LOG.isInfoEnabled()) {
            LOG.info("========app/version/v1/findAppVersion end========response" + response);
        }
        return response;
    }
}
