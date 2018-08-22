package com.bdcourtyard.business.building.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *  HouseBuildingUnit
 *
 * @version : Ver 1.0
 * @date	: 2018-7-23
 */
public class HouseBuildingUnit  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     *      
     */	
	private String unitId;

	/**
     * 单元名称
     */
	private String unitName;

	/**
     * 单元所属楼宇ID
     */
	private String buildingId;

	/**
     * 排序字段
     */
	private Integer displayOrder;

	/**
     * 创建时间
     */
	private java.util.Date createTime;



	/**
	 * @param unitId
	 */
	@ApiModelProperty("")
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	/**
	 * @return
	 */
	@ApiModelProperty("")
	public String getUnitId() {
		return this.unitId;
	}

	/**
	 * @param unitName 单元名称
	 */
	@ApiModelProperty("单元名称")
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	/**
	 * @return 单元名称
	 */
	@ApiModelProperty("单元名称")
	public String getUnitName() {
		return this.unitName;
	}

	/**
	 * @param buildingId 单元所属楼宇ID
	 */
	@ApiModelProperty("单元所属楼宇ID")
	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	/**
	 * @return 单元所属楼宇ID
	 */
	@ApiModelProperty("单元所属楼宇ID")
	public String getBuildingId() {
		return this.buildingId;
	}

	/**
	 * @param displayOrder 排序字段
	 */
	@ApiModelProperty("排序字段")
	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	/**
	 * @return 排序字段
	 */
	@ApiModelProperty("排序字段")
	public Integer getDisplayOrder() {
		return this.displayOrder;
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
		return "HouseBuildingUnit{" +
				"unitId='" + unitId + '\'' +
				", unitName='" + unitName + '\'' +
				", buildingId='" + buildingId + '\'' +
				", displayOrder=" + displayOrder +
				", createTime=" + createTime +
				'}';
	}
}
