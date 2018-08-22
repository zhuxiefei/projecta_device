package com.bdcourtyard.business.user.constant;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-25 15:33
 * @Description:
 */
public interface UserConstant {

    /**
     * 头像名称长度120
     */
    Integer IMAGE_NAME_LENGTH = 120;

    /**
     * 头像大小20M
     */
    int IMAGE_LENGTH_MAX = 20*1024*1024;

    /**
     * 文字意见最大长度
     */
    Integer FEEDBACK_CONTENT_SIZE = 500;

    /**
     * 反馈信息状态之未读
     */
    Integer FEEDBACK_STATUS_UNREAD = 1;

    /**
     * 通知状态为未读
     */
    int NOTICE_UNREAD = 1;

    /**
     * 通知状态为已读
     */
    int NOTICE_READ = 2;

    /**
     * 通知状态为删除
     */
    int NOTICE_DELETE = 3;

    /**
     * 营销助手APP
     */
    Integer PROPERTY_APP = 3;
}
