package com.bdcourtyard.business.onlineHouse.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
/**
 *  AssistantOnlinehousefile
 *
 * @version : Ver 1.0
 * @date	: 2018-7-17
 */
public class AssistantOnlinehousefile  implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * 看房信息ID
	 */
	private java.lang.String onlineId;

	/**
	 * 附件ID
	 */
	private java.lang.String fileId;

	/**
	 * 场景名称
	 */
	private java.lang.String sceneName;

	/**
	 * 场景顺序
	 */
	private java.lang.String sceneSort;

	/**
	 * 创建时间
	 */
	private java.util.Date createTime;



	/**
	 * @param onlineId 看房信息ID
	 */
	@ApiModelProperty("看房信息ID")
	public void setOnlineId(java.lang.String onlineId) {
		this.onlineId = onlineId;
	}

	/**
	 * @return 看房信息ID
	 */
	@ApiModelProperty("看房信息ID")
	public java.lang.String getOnlineId() {
		return this.onlineId;
	}

	/**
	 * @param fileId 附件ID
	 */
	@ApiModelProperty("附件ID")
	public void setFileId(java.lang.String fileId) {
		this.fileId = fileId;
	}

	/**
	 * @return 附件ID
	 */
	@ApiModelProperty("附件ID")
	public java.lang.String getFileId() {
		return this.fileId;
	}

	/**
	 * @param sceneName 场景名称
	 */
	@ApiModelProperty("场景名称")
	public void setSceneName(java.lang.String sceneName) {
		this.sceneName = sceneName;
	}

	/**
	 * @return 场景名称
	 */
	@ApiModelProperty("场景名称")
	public java.lang.String getSceneName() {
		return this.sceneName;
	}

	/**
	 * @param sceneSort 场景顺序
	 */
	@ApiModelProperty("场景顺序")
	public void setSceneSort(java.lang.String sceneSort) {
		this.sceneSort = sceneSort;
	}

	/**
	 * @return 场景顺序
	 */
	@ApiModelProperty("场景顺序")
	public java.lang.String getSceneSort() {
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

}
