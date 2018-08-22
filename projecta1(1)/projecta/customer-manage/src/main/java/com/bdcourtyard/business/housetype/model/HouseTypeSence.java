package com.bdcourtyard.business.housetype.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *  HouseTypeSence
 *
 * @version : Ver 1.0
 * @date	: 2018-7-30
 */
public class HouseTypeSence implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * 场景Id     
     */	
	private String senceId;

	/**
     * 户型ID
     */
	private String typeId;

	/**
     * 附件ID
     */
	private String fileId;

	/**
     * 场景名称
     */
	private String sceneName;

	/**
     * 场景顺序
     */
	private Integer sceneSort;

	/**
     * 创建时间
     */
	private java.util.Date createTime;



	/**
	 * @param senceId 场景Id
	 */
	@ApiModelProperty("场景Id")
	public void setSenceId(String senceId) {
		this.senceId = senceId;
	}

	/**
	 * @return 场景Id
	 */
	@ApiModelProperty("场景Id")
	public String getSenceId() {
		return this.senceId;
	}

	/**
	 * @param typeId 户型ID
	 */
	@ApiModelProperty("户型ID")
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	/**
	 * @return 户型ID
	 */
	@ApiModelProperty("户型ID")
	public String getTypeId() {
		return this.typeId;
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

	/**
	 * @param sceneName 场景名称
	 */
	@ApiModelProperty("场景名称")
	public void setSceneName(String sceneName) {
		this.sceneName = sceneName;
	}

	/**
	 * @return 场景名称
	 */
	@ApiModelProperty("场景名称")
	public String getSceneName() {
		return this.sceneName;
	}

	/**
	 * @param sceneSort 场景顺序
	 */
	@ApiModelProperty("场景顺序")
	public void setSceneSort(Integer sceneSort) {
		this.sceneSort = sceneSort;
	}

	/**
	 * @return 场景顺序
	 */
	@ApiModelProperty("场景顺序")
	public Integer getSceneSort() {
		return this.sceneSort;
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

	@Override
	public String toString() {
		return "HouseTypeSence{" +
				"senceId='" + senceId + '\'' +
				", typeId='" + typeId + '\'' +
				", fileId='" + fileId + '\'' +
				", sceneName='" + sceneName + '\'' +
				", sceneSort=" + sceneSort +
				", createTime=" + createTime +
				'}';
	}
}
