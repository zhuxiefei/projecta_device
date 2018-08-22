package com.bdcourtyard.business.user.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *  UserFeedback
 *
 * @version : Ver 1.0
 * @date	: 2018-7-25
 */
public class UserFeedback  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * 反馈ID     
     */	
	private String feedbackId;

	/**
     * 反馈提交人ID
     */
	private String authorId;

	/**
     * 反馈提交人名字
     */
	private String authorName;

	/**
     * 反馈内容
     */
	private String feedbackContent;

	/**
     * 反馈类型：1为意见，2为问题
     */
	private Integer feedbackType;

	/**
     * 反馈状态：1为未读，2为已读
     */
	private Integer feedbackStatus;

	/**
     * 客户端型号
     */
	private String clientModel;

	/**
     * 客户端版本
     */
	private String clientVersion;

	/**
     * app类型：1为业主APP，2为物业APP
     */
	private Integer appType;

	/**
     * APP版本
     */
	private String appVersion;

	/**
     * 反馈提交时间
     */
	private java.util.Date createTime;

	/**
     * 所属楼盘ID
     */
	private String estateId;



	/**
	 * @param feedbackId 反馈ID
	 */
	@ApiModelProperty("反馈ID")
	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}

	/**
	 * @return 反馈ID
	 */
	@ApiModelProperty("反馈ID")
	public String getFeedbackId() {
		return this.feedbackId;
	}

	/**
	 * @param authorId 反馈提交人ID
	 */
	@ApiModelProperty("反馈提交人ID")
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	/**
	 * @return 反馈提交人ID
	 */
	@ApiModelProperty("反馈提交人ID")
	public String getAuthorId() {
		return this.authorId;
	}

	/**
	 * @param authorName 反馈提交人名字
	 */
	@ApiModelProperty("反馈提交人名字")
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	/**
	 * @return 反馈提交人名字
	 */
	@ApiModelProperty("反馈提交人名字")
	public String getAuthorName() {
		return this.authorName;
	}

	/**
	 * @param feedbackContent 反馈内容
	 */
	@ApiModelProperty("反馈内容")
	public void setFeedbackContent(String feedbackContent) {
		this.feedbackContent = feedbackContent;
	}

	/**
	 * @return 反馈内容
	 */
	@ApiModelProperty("反馈内容")
	public String getFeedbackContent() {
		return this.feedbackContent;
	}

	/**
	 * @param feedbackType 反馈类型：1为意见，2为问题
	 */
	@ApiModelProperty("反馈类型：1为意见，2为问题")
	public void setFeedbackType(Integer feedbackType) {
		this.feedbackType = feedbackType;
	}

	/**
	 * @return 反馈类型：1为意见，2为问题
	 */
	@ApiModelProperty("反馈类型：1为意见，2为问题")
	public Integer getFeedbackType() {
		return this.feedbackType;
	}

	/**
	 * @param feedbackStatus 反馈状态：1为未读，2为已读
	 */
	@ApiModelProperty("反馈状态：1为未读，2为已读")
	public void setFeedbackStatus(Integer feedbackStatus) {
		this.feedbackStatus = feedbackStatus;
	}

	/**
	 * @return 反馈状态：1为未读，2为已读
	 */
	@ApiModelProperty("反馈状态：1为未读，2为已读")
	public Integer getFeedbackStatus() {
		return this.feedbackStatus;
	}

	/**
	 * @param clientModel 客户端型号
	 */
	@ApiModelProperty("客户端型号")
	public void setClientModel(String clientModel) {
		this.clientModel = clientModel;
	}

	/**
	 * @return 客户端型号
	 */
	@ApiModelProperty("客户端型号")
	public String getClientModel() {
		return this.clientModel;
	}

	/**
	 * @param clientVersion 客户端版本
	 */
	@ApiModelProperty("客户端版本")
	public void setClientVersion(String clientVersion) {
		this.clientVersion = clientVersion;
	}

	/**
	 * @return 客户端版本
	 */
	@ApiModelProperty("客户端版本")
	public String getClientVersion() {
		return this.clientVersion;
	}

	/**
	 * @param appType app类型：1为业主APP，2为物业APP
	 */
	@ApiModelProperty("app类型：1为业主APP，2为物业APP,3为营销助手APP")
	public void setAppType(Integer appType) {
		this.appType = appType;
	}

	/**
	 * @return app类型：1为业主APP，2为物业APP
	 */
	@ApiModelProperty("app类型：1为业主APP，2为物业APP,3为营销助手APP")
	public Integer getAppType() {
		return this.appType;
	}

	/**
	 * @param appVersion APP版本
	 */
	@ApiModelProperty("APP版本")
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	/**
	 * @return APP版本
	 */
	@ApiModelProperty("APP版本")
	public String getAppVersion() {
		return this.appVersion;
	}

	/**
	 * @param createTime 反馈提交时间
	 */
	@ApiModelProperty("反馈提交时间")
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return 反馈提交时间
	 */
	@ApiModelProperty("反馈提交时间")
	public java.util.Date getCreateTime() {
		return this.createTime;
	}


	/**
	 * @param estateId 所属楼盘ID
	 */
	@ApiModelProperty("所属楼盘ID")
	public void setEstateId(String estateId) {
		this.estateId = estateId;
	}

	/**
	 * @return 所属楼盘ID
	 */
	@ApiModelProperty("所属楼盘ID")
	public String getEstateId() {
		return this.estateId;
	}
}
