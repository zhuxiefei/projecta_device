package com.bdcourtyard.business.user.service;

import com.bdcourtyard.business.user.domain.AppVersionInfo;
import com.bdcourtyard.business.user.domain.EditPwdReq;
import com.bdcourtyard.business.user.domain.SystemNoticeInfo;
import com.bdcourtyard.business.user.domain.UserInfoResp;
import com.bdcourtyard.business.user.model.UserFeedback;
import com.bdcourtyard.common.page.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-25 14:02
 * @Description:
 */
public interface UserService {

    UserInfoResp getUserInfo(HttpServletRequest request);

    void updatePwd(EditPwdReq pwdReq, HttpServletRequest request);

    void updateHead(MultipartFile file,HttpServletRequest request);

    void addFeedback(HttpServletRequest request, UserFeedback feedback);

    Integer findSystemNotices(HttpServletRequest request);

    SystemNoticeInfo findNoticeInfo(String noticeId);

    Page<SystemNoticeInfo> findAllNotices(HttpServletRequest request, Pageable pageable);

    Page<UserFeedback> findAllFeedback(Pageable pageable,HttpServletRequest request);

    AppVersionInfo findVersion();
}
