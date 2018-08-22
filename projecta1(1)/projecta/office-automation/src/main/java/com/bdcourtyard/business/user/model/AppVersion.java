package com.bdcourtyard.business.user.model;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;

import java.io.Serializable;

/**
 *  AppVersion
 *
 * @version : Ver 1.0
 * @date	: 2018-7-25
 */
public class AppVersion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     *      
     */	
	private String versionId;

	/**
     * 版本名称
     */
	private String versionName;

	/**
     * app类型：1为业主APP，2为物业APP
     */
	private Integer appType;

	/**
     * 版本类型：1为安卓手机APP
     */
	private Integer versionType;

	/**
     * 版本号
     */
	private String versionNo;

	/**
     * 下载路径：全路径
     */
	private String versionUrl;

	/**
     * 是否强制升级：1是，2否
     */
	private Integer isForce;

	/**
     * 版本描述
     */
	private String versionDesc;

	/**
     * 版本创建时间
     */
	private java.util.Date createTime;



	/**
	 * @param versionId
	 */
	@ApiModelProperty("")
	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}

	/**
	 * @return
	 */
	@ApiModelProperty("")
	public String getVersionId() {
		return this.versionId;
	}

	/**
	 * @param versionName 版本名称
	 */
	@ApiModelProperty("版本名称")
	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	/**
	 * @return 版本名称
	 */
	@ApiModelProperty("版本名称")
	public String getVersionName() {
		return this.versionName;
	}

	/**
	 * @param appType app类型：1为业主APP，2为物业APP
	 */
	@ApiModelProperty("app类型：1为业主APP，2为物业APP,3为营销助手APP")
	public void setAppType(Integer appType) {
		this.appType = appType;
	}

	/**
	 * @return app类型：1为业主APP，2为物业APP 3为营销助手APP
	 */
	@ApiModelProperty("app类型：1为业主APP，2为物业APP")
	public Integer getAppType() {
		return this.appType;
	}

	/**
	 * @param versionType 版本类型：1为安卓手机APP
	 */
	@ApiModelProperty("版本类型：1为安卓手机APP")
	public void setVersionType(Integer versionType) {
		this.versionType = versionType;
	}

	/**
	 * @return 版本类型：1为安卓手机APP
	 */
	@ApiModelProperty("版本类型：1为安卓手机APP")
	public Integer getVersionType() {
		return this.versionType;
	}

	/**
	 * @param versionNo 版本号
	 */
	@ApiModelProperty("版本号")
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	/**
	 * @return 版本号
	 */
	@ApiModelProperty("版本号")
	public String getVersionNo() {
		return this.versionNo;
	}

	/**
	 * @param versionUrl 下载路径：全路径
	 */
	@ApiModelProperty("下载路径：全路径")
	public void setVersionUrl(String versionUrl) {
		this.versionUrl = versionUrl;
	}

	/**
	 * @return 下载路径：全路径
	 */
	@ApiModelProperty("下载路径：全路径")
	public String getVersionUrl() {
		return this.versionUrl;
	}

	/**
	 * @param isForce 是否强制升级：1是，2否
	 */
	@ApiModelProperty("是否强制升级：1是，2否")
	public void setIsForce(Integer isForce) {
		this.isForce = isForce;
	}

	/**
	 * @return 是否强制升级：1是，2否
	 */
	@ApiModelProperty("是否强制升级：1是，2否")
	public Integer getIsForce() {
		return this.isForce;
	}

	/**
	 * @param versionDesc 版本描述
	 */
	@ApiModelProperty("版本描述")
	public void setVersionDesc(String versionDesc) {
		this.versionDesc = versionDesc;
	}

	/**
	 * @return 版本描述
	 */
	@ApiModelProperty("版本描述")
	public String getVersionDesc() {
		return this.versionDesc;
	}
	
	/**
	 * @param createTime 版本创建时间
	 */
	@ApiModelProperty("版本创建时间")
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * @return 版本创建时间
	 */
	@ApiModelProperty("版本创建时间")
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	 
}
