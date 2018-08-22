package com.bdcourtyard.business.estate.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *  EstateEstate
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16
 */
public class EstateEstate  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * 楼盘ID     
     */	
	private String estateId;

	/**
     * 楼盘名称
     */
	private String estateName;

	/**
	 * 楼盘图片ID
	 */
	private String fileId;

	/**
     * 创建时间
     */
	private java.util.Date createTime;



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

	/**
	 * @param estateName 楼盘名称
	 */
	@ApiModelProperty("楼盘名称")
	public void setEstateName(String estateName) {
		this.estateName = estateName;
	}

	/**
	 * @return 楼盘名称
	 */
	@ApiModelProperty("楼盘名称")
	public String getEstateName() {
		return this.estateName;
	}

	/**
	 * @return 楼盘图片ID
	 */
	@ApiModelProperty("楼盘图片ID")
	public String getFileId() {
		return fileId;
	}

	/**
	 * @return 楼盘图片ID
	 */
	@ApiModelProperty("楼盘图片ID")
	public void setFileId(String fileId) {
		this.fileId = fileId;
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
