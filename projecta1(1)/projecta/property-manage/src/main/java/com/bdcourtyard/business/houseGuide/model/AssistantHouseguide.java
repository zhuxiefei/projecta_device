package com.bdcourtyard.business.houseGuide.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *  AssistantHouseguide
 *
 * @version : Ver 1.0
 * @date	: 2018-7-19
 */
public class AssistantHouseguide  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * 看房指南ID     
     */	
	private String guideId;

	/**
     * 标题
     */
	private String title;

	/**
     * 内容
     */
	private String content;

	/**
     * 发布人
     */
	private String adminId;

	/**
     * 发布时间
     */
	private java.util.Date createTime;

	/**
     * 楼盘ID
     */
	private String estateId;



	/**
	 * @param guideId 看房指南ID
	 */
	@ApiModelProperty("看房指南ID")
	public void setGuideId(String guideId) {
		this.guideId = guideId;
	}

	/**
	 * @return 看房指南ID
	 */
	@ApiModelProperty("看房指南ID")
	public String getGuideId() {
		return this.guideId;
	}

	/**
	 * @param title 标题
	 */
	@ApiModelProperty("标题")
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return 标题
	 */
	@ApiModelProperty("标题")
	public String getTitle() {
		return this.title;
	}

	/**
	 * @param content 内容
	 */
	@ApiModelProperty("内容")
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return 内容
	 */
	@ApiModelProperty("内容")
	public String getContent() {
		return this.content;
	}

	/**
	 * @param adminId 发布人
	 */
	@ApiModelProperty("发布人")
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	/**
	 * @return 发布人
	 */
	@ApiModelProperty("发布人")
	public String getAdminId() {
		return this.adminId;
	}

	/**
	 * @param createTime 发布时间
	 */
	@ApiModelProperty("发布时间")
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return 发布时间
	 */
	@ApiModelProperty("发布时间")
	public java.util.Date getCreateTime() {
		return this.createTime;
	}


	/**
	 * @param estateId 楼盘ID
	 */
	@ApiModelProperty("楼盘ID")
	public void setEstateId(String estateId) {
		this.estateId = estateId;
	}

	/**
	 * @return 楼盘ID
	 */
	@ApiModelProperty("楼盘ID")
	public String getEstateId() {
		return this.estateId;
	}
}
