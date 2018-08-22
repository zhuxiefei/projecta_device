package com.bdcourtyard.business.estate.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *  EstateStartPage
 *
 * @version : Ver 1.0
 * @date	: 2018-7-19
 */
public class EstateStartPage implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * 启动页ID     
     */	
	private String pageId;

	/**
     * 描述
     */
	private String name;

	/**
     * 排序
     */
	private Integer sort;

	/**
     * 图片地址
     */
	private String url;

	/**
     * 1：业主app 2物业app
     */
	private Boolean appType;

	/**
     * 创建时间
     */
	private java.util.Date createTime;



	/**
	 * @param pageId 启动页ID
	 */
	@ApiModelProperty("启动页ID")
	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	/**
	 * @return 启动页ID
	 */
	@ApiModelProperty("启动页ID")
	public String getPageId() {
		return this.pageId;
	}

	/**
	 * @param name 描述
	 */
	@ApiModelProperty("描述")
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return 描述
	 */
	@ApiModelProperty("描述")
	public String getName() {
		return this.name;
	}

	/**
	 * @param sort 排序
	 */
	@ApiModelProperty("排序")
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * @return 排序
	 */
	@ApiModelProperty("排序")
	public Integer getSort() {
		return this.sort;
	}

	/**
	 * @param url 图片地址
	 */
	@ApiModelProperty("图片地址")
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return 图片地址
	 */
	@ApiModelProperty("图片地址")
	public String getUrl() {
		return this.url;
	}

	/**
	 * @param appType 1：业主app 2物业app
	 */
	@ApiModelProperty("1：业主app 2物业app 3为营销助手APP")
	public void setAppType(Boolean appType) {
		this.appType = appType;
	}

	/**
	 * @return 1：业主app 2物业app
	 */
	@ApiModelProperty("1：业主app 2物业app 3为营销助手APP")
	public Boolean getAppType() {
		return this.appType;
	}
	
	/**
	 * @param createTime 创建时间
	 */
	@ApiModelProperty("创建时间")
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * @return 创建时间
	 */
	@ApiModelProperty("创建时间")
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	 
}
