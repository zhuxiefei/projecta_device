package com.bdcourtyard.business.housing.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
/**
 *  AssistantHouse
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16
 */
public class AssistantHouse  implements Serializable {

	public AssistantHouse() {

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * 房产ID     
     */	
	private String propertyId;
	
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

	public AssistantHouse(String propertyId, String title, String content, String adminId, Date createTime, String estateId) {
		this.propertyId = propertyId;
		this.title = title;
		this.content = content;
		this.adminId = adminId;
		this.createTime = createTime;
		this.estateId = estateId;
	}

	/**
	 * @param propertyId 房产ID
	 */
	@ApiModelProperty("房产ID")
	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}
	
	/**
	 * @return 房产ID
	 */
	@ApiModelProperty("房产ID")
	public String getPropertyId() {
		return this.propertyId;
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

	@Override
	public String toString() {
		return "AssistantHouse{" +
				"propertyId='" + propertyId + '\'' +
				", title='" + title + '\'' +
				", content='" + content + '\'' +
				", adminId='" + adminId + '\'' +
				", createTime=" + createTime +
				", estateId='" + estateId + '\'' +
				'}';
	}

}
