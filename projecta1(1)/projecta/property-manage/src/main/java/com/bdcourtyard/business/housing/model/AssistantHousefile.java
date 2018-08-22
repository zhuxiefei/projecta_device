package com.bdcourtyard.business.housing.model;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
/**
 *  AssistantHousefile
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16
 */
public class AssistantHousefile  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 房产信息ID
	 */
	private String propertyId;

	/**
	 * 附件ID
	 */
	private String fileId;

	private Integer fileType;

	private Date createTime;

	@ApiModelProperty("1为图片 2为视频")
	public Integer getFileType() {
		return fileType;
	}

	@ApiModelProperty("1为图片 2为视频")
	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}

	@ApiModelProperty("创建时间")
	public Date getCreateTime() {
		return createTime;
	}

	@ApiModelProperty("创建时间")
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @param propertyId 房产信息ID
	 */
	@ApiModelProperty("房产信息ID")
	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	/**
	 * @return 房产信息ID
	 */
	@ApiModelProperty("房产信息ID")
	public String getPropertyId() {
		return this.propertyId;
	}

	/**
	 * @param fileId 附件ID
	 */
	@ApiModelProperty("附件ID")
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	/**
	 * @return 附件ID
	 */
	@ApiModelProperty("附件ID")
	public String getFileId() {
		return this.fileId;
	}
}
