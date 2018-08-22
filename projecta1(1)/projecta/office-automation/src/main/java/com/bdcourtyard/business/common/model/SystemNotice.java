package com.bdcourtyard.business.common.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *  SystemNotice
 *
 * @version : Ver 1.0
 * @date	: 2018-7-25
 */
public class SystemNotice implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * 通知ID     
     */	
	private String noticeId;

	/**
     * 接收通知人ID
     */
	private String noticeUserId;

	/**
     * 通知内容
     */
	private String noticeContent;

	/**
     * 通知状态：1为未读，2为已读，3为已删除
     */
	private Integer noticeStatus;

	/**
     * 通知类型：1为系统通知 2为认证通知
     */
	private Integer noticeType;

	/**
     * 通知产生时间
     */
	private java.util.Date createTime;



	/**
	 * @param noticeId 通知ID
	 */
	@ApiModelProperty("通知ID")
	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}

	/**
	 * @return 通知ID
	 */
	@ApiModelProperty("通知ID")
	public String getNoticeId() {
		return this.noticeId;
	}

	/**
	 * @param noticeUserId 接收通知人ID
	 */
	@ApiModelProperty("接收通知人ID")
	public void setNoticeUserId(String noticeUserId) {
		this.noticeUserId = noticeUserId;
	}

	/**
	 * @return 接收通知人ID
	 */
	@ApiModelProperty("接收通知人ID")
	public String getNoticeUserId() {
		return this.noticeUserId;
	}

	/**
	 * @param noticeContent 通知内容
	 */
	@ApiModelProperty("通知内容")
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	/**
	 * @return 通知内容
	 */
	@ApiModelProperty("通知内容")
	public String getNoticeContent() {
		return this.noticeContent;
	}

	/**
	 * @param noticeStatus 通知状态：1为未读，2为已读，3为已删除
	 */
	@ApiModelProperty("通知状态：1为未读，2为已读，3为已删除")
	public void setNoticeStatus(Integer noticeStatus) {
		this.noticeStatus = noticeStatus;
	}

	/**
	 * @return 通知状态：1为未读，2为已读，3为已删除
	 */
	@ApiModelProperty("通知状态：1为未读，2为已读，3为已删除")
	public Integer getNoticeStatus() {
		return this.noticeStatus;
	}

	/**
	 * @param noticeType 通知类型：1为系统通知 2为认证通知
	 */
	@ApiModelProperty("通知类型：1为系统通知 2为认证通知")
	public void setNoticeType(Integer noticeType) {
		this.noticeType = noticeType;
	}

	/**
	 * @return 通知类型：1为系统通知 2为认证通知
	 */
	@ApiModelProperty("通知类型：1为系统通知 2为认证通知")
	public Integer getNoticeType() {
		return this.noticeType;
	}
	
	/**
	 * @param createTime 通知产生时间
	 */
	@ApiModelProperty("通知产生时间")
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * @return 通知产生时间
	 */
	@ApiModelProperty("通知产生时间")
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	 
}
