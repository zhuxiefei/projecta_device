package com.bdcourtyard.business.user.service.impl;

import basic.common.core.id.IdUtil;
import com.bdcourtyard.business.account.dao.CompanyEmployeeDao;
import com.bdcourtyard.business.account.dao.EmployeeAccountDao;
import com.bdcourtyard.business.account.domain.FindEmpResp;
import com.bdcourtyard.business.account.model.CompanyEmployee;
import com.bdcourtyard.business.account.model.EmployeeAccount;
import com.bdcourtyard.business.account.utils.Validate;
import com.bdcourtyard.business.common.dao.SystemFileDao;
import com.bdcourtyard.business.common.dao.SystemNoticeDao;
import com.bdcourtyard.business.common.model.SystemFile;
import com.bdcourtyard.business.common.model.SystemNotice;
import com.bdcourtyard.business.user.constant.UserConstant;
import com.bdcourtyard.business.user.dao.AppVersionDao;
import com.bdcourtyard.business.user.dao.UserFeedbackDao;
import com.bdcourtyard.business.user.domain.AppVersionInfo;
import com.bdcourtyard.business.user.domain.EditPwdReq;
import com.bdcourtyard.business.user.domain.SystemNoticeInfo;
import com.bdcourtyard.business.user.domain.UserInfoResp;
import com.bdcourtyard.business.user.model.AppVersion;
import com.bdcourtyard.business.user.model.UserFeedback;
import com.bdcourtyard.business.user.service.UserService;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;
import com.bdcourtyard.common.utils.PropertiesUtil;
import com.bdcourtyard.common.utils.StringUtil;
import com.beite.tools.utils.AESUtil;
import com.beite.tools.utils.FileUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-25 14:03
 * @Description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private CompanyEmployeeDao employeeDao;

    @Autowired
    private SystemFileDao fileDao;

    @Autowired
    private EmployeeAccountDao accountDao;

    @Autowired
    private UserFeedbackDao feedbackDao;

    @Autowired
    private SystemNoticeDao noticeDao;

    @Autowired
    private AppVersionDao appVersionDao;

    @Override
    public UserInfoResp getUserInfo(HttpServletRequest request) {
        String empId;
        try {
            empId = AESUtil.decrypt(request.getHeader("employeeId"));
        } catch (Exception e) {
            throw new GlobalException("99999");
        }
        FindEmpResp findEmpResp = employeeDao.selectByEmpId(empId);
        UserInfoResp userInfoResp = new UserInfoResp();
        userInfoResp.setDepartmentName(findEmpResp.getDepartmentName());
        userInfoResp.setEmployeeName(findEmpResp.getEmployeeName());
        if (findEmpResp != null && !StringUtil.isEmpty(String.valueOf(findEmpResp.getHead()))) {
            SystemFile file = fileDao.getSystemFileById(findEmpResp.getHead());
            if (file != null) {
                userInfoResp.setPhoto(PropertiesUtil.getProperty("file.server") + file.getFileUrl());
            }
        }
        return userInfoResp;
    }

    @Override
    public void updatePwd(EditPwdReq pwdReq, HttpServletRequest request) {
        String acctName;
        String encryptOldPwd;
        String encryptNewPwd;
        try {
            acctName = AESUtil.decrypt(request.getHeader("acctName"));
            encryptOldPwd = AESUtil.encrypt(pwdReq.getPwd());
            encryptNewPwd = AESUtil.encrypt(pwdReq.getNewPwd());
        } catch (Exception e) {
            throw new GlobalException("99999");
        }
        //判断老密码是否正确
        EmployeeAccount account = accountDao.getEmployeeAccountById(acctName);
        if (null != account && !account.getPassword().equals(encryptOldPwd)) {
            throw new GlobalException("U0001");
        }
        if (!Validate.isPassword(pwdReq.getNewPwd())) {
            throw new GlobalException("U0002");
        }
        account.setPassword(encryptNewPwd);
        accountDao.updateEmployeeAccountById(account);
    }

    @Override
    public void updateHead(MultipartFile file, HttpServletRequest request) {
        String empId;
        try {
            empId = AESUtil.decrypt(request.getHeader("employeeId"));
        } catch (Exception e) {
            throw new GlobalException("99999");
        }
        //获得文件名(包含类型)
        String image_name = file.getOriginalFilename();
        //获取文件的类型
        String picType = image_name.substring(image_name.lastIndexOf(".") + 1);
        if (image_name.length() > UserConstant.IMAGE_NAME_LENGTH) {
            //头像名称过长（120以内）
            throw new GlobalException("U0003");
        } else if (!Validate.isImage(picType)) {
            //头像格式错误（bmp/jpg/jpeg/png）
            throw new GlobalException("U0004");
        } else if (file.getSize() > UserConstant.IMAGE_LENGTH_MAX) {
            //头像大小超过20M
            throw new GlobalException("U0005");
        } else {
            CompanyEmployee employee = employeeDao.getCompanyEmployeeById(empId);
            String fileUrl;
            String fileId = IdUtil.getLongId() + "";
            try {
                fileUrl = FileUtil.uploadFile(file, "head");
            } catch (Exception e) {
                throw new GlobalException("99999");
            }
            SystemFile head = new SystemFile();
            head.setFileUrl(fileUrl);
            head.setFileType(2);
            head.setFileName(image_name);
            head.setCreateTime(new Date(System.currentTimeMillis()));
            head.setFileId(fileId);
            fileDao.insertSystemFile(head);
            employee.setHead(fileId);
            employeeDao.updateCompanyEmployeeById(employee);
        }
    }

    @Override
    public void addFeedback(HttpServletRequest request, UserFeedback feedback) {
        String empId;
        String estateId;
        try {
            empId = AESUtil.decrypt(request.getHeader("employeeId"));
            estateId = AESUtil.decrypt(request.getHeader("estateId"));
        } catch (Exception e) {
            throw new GlobalException("99999");
        }
        //数据校验
        if (StringUtil.isEmpty(feedback.getFeedbackContent())) {
            throw new GlobalException("U0006");
        } else if (UserConstant.FEEDBACK_CONTENT_SIZE < feedback.getFeedbackContent().length()) {
            throw new GlobalException("U0007");
        } else {
            CompanyEmployee employee = employeeDao.getCompanyEmployeeById(empId);
            feedback.setCreateTime(new Date(System.currentTimeMillis()));
            feedback.setAuthorId(empId);
            feedback.setAuthorName(employee.getEmployeeName());
            feedback.setFeedbackId(IdUtil.getLongId() + "");
            feedback.setFeedbackStatus(1);
            feedback.setEstateId(estateId);
            feedbackDao.insertUserFeedback(feedback);
        }
    }

    @Override
    public Integer findSystemNotices(HttpServletRequest request) {
        String empId;
        try {
            empId = AESUtil.decrypt(request.getHeader("employeeId"));
        } catch (Exception e) {
            throw new GlobalException("99999");
        }
        return noticeDao.findSystemNoticeNumber(empId);
    }

    @Override
    public SystemNoticeInfo findNoticeInfo(String noticeId) {
        SystemNotice systemNotice = noticeDao.getSystemNoticeById(noticeId);
        if (systemNotice != null) {
            if (systemNotice.getNoticeStatus() == UserConstant.NOTICE_DELETE) {
                // 通知被删除
                throw new GlobalException("U0008");
            } else {
                // 查询成功 设置已读
                systemNotice.setNoticeStatus(UserConstant.NOTICE_READ);
                noticeDao.updateSystemNoticeById(systemNotice);
                SystemNoticeInfo systemNoticeInfo = new SystemNoticeInfo();
                systemNoticeInfo.setNoticeContent(systemNotice.getNoticeContent());
                systemNoticeInfo.setCreateTime(systemNotice.getCreateTime());
                return systemNoticeInfo;
            }
        }
        return null;
    }

    @Override
    public Page<SystemNoticeInfo> findAllNotices(HttpServletRequest request, Pageable pageable) {
        String empId;
        try {
            empId = AESUtil.decrypt(request.getHeader("employeeId"));
        } catch (Exception e) {
            throw new GlobalException("99999");
        }

        long count = noticeDao.findAllNotices(empId).size();
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<SystemNoticeInfo> infos = noticeDao.findAllNotices(empId);

        Page<SystemNoticeInfo> pageDto = new Page<SystemNoticeInfo>();
        pageDto.setPage(pageable.getPageNumber());
        pageDto.setPageSize(pageable.getPageSize());

        if (infos != null) {
            pageDto.setRows(setTitle(infos));
            pageDto.setTotal(count);
        } else {
            pageDto.setRows(new ArrayList<SystemNoticeInfo>());
            pageDto.setTotal(0l);
        }

        return pageDto;
    }

    @Override
    public Page<UserFeedback> findAllFeedback(Pageable pageable,HttpServletRequest request) {
        String empId;
        try {
            empId = AESUtil.decrypt(request.getHeader("employeeId"));
        } catch (Exception e) {
            throw new GlobalException("99999");
        }

        long count = feedbackDao.findAllFeedback(empId).size();
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<UserFeedback> list = feedbackDao.findAllFeedback(empId);

        Page<UserFeedback> pageDto = new Page<UserFeedback>();
        pageDto.setPage(pageable.getPageNumber());
        pageDto.setPageSize(pageable.getPageSize());

        if (list != null) {
            pageDto.setRows(list);
            pageDto.setTotal(count);
        } else {
            pageDto.setRows(new ArrayList<UserFeedback>());
            pageDto.setTotal(0l);
        }

        return pageDto;
    }

    @Override
    public AppVersionInfo findVersion() {
        AppVersion version = appVersionDao.selectNewestVersion(UserConstant.PROPERTY_APP);
        AppVersionInfo info = null;
        if(version != null) {
            version.setVersionUrl(PropertiesUtil.getProperty("file.server")+version.getVersionUrl());
            info = new AppVersionInfo(version.getVersionNo(),version.getVersionUrl(),
                    version.getVersionName(),version.getVersionType(),version.getIsForce(),version.getVersionDesc());
        }
        return info;
    }

    /**
     * <p>
     * 根据通知类型设置通知标题
     * </p>
     * Author: xiayanxin <br/>
     */
    private List<SystemNoticeInfo> setTitle(List<SystemNoticeInfo> al) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for (SystemNoticeInfo systemNoticeInfo : al) {
            String noticeTitle;
            switch (systemNoticeInfo.getNoticeType()) {
//                case 1:    //新增报修单
//                    noticeTitle = "新增报修单";
//                    break;
                default:
                    noticeTitle = "系统通知";
                    break;
            }
            systemNoticeInfo.setNoticeTitle(noticeTitle);
            // 时间去除时分秒
            String format = sdf.format(systemNoticeInfo.getCreateTime());
            String[] split = format.split(" ");
            systemNoticeInfo.setCreateDate(split[0]);
        }
        return al;
    }
}
