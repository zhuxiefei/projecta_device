package com.bdcourtyard.business.building.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *  HouseBuilding
 *
 * @version : Ver 1.0
 * @date	: 2018-7-23
 */
public class HouseBuilding  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     *      
     */	
	private String buildingId;

	/**
     * 楼宇名称
     */
	private String buildingName;

	/**
     * buildingDesc
     */
	private String buildingDesc;

	/**
     * 排序字段
     */
	private Integer displayOrder;

	/**
     * 楼盘id
     */
	private String estateId;

	/**
     * 1为商用2为住宅
     */
	private Integer estateType;

	/**
     * 楼宇创建时间
     */
	private java.util.Date createTime;

	/**
	 * 总楼层
	 */
	private  Integer floors;

	@ApiModelProperty("楼层")
	public Integer getFloors() {
		return floors;
	}

	@ApiModelProperty("楼层")
	public void setFloors(Integer floors) {
		this.floors = floors;
	}

	/**
	 * @param buildingId
	 */
	@ApiModelProperty("")
	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	/**
	 * @return
	 */
	@ApiModelProperty("")
	public String getBuildingId() {
		return this.buildingId;
	}

	/**
	 * @param buildingName 楼宇名称
	 */
	@ApiModelProperty("楼宇名称")
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	/**
	 * @return 楼宇名称
	 */
	@ApiModelProperty("楼宇名称")
	public String getBuildingName() {
		return this.buildingName;
	}

	/**
	 * @param buildingDesc buildingDesc
	 */
	@ApiModelProperty("buildingDesc")
	public void setBuildingDesc(String buildingDesc) {
		this.buildingDesc = buildingDesc;
	}

	/**
	 * @return buildingDesc
	 */
	@ApiModelProperty("buildingDesc")
	public String getBuildingDesc() {
		return this.buildingDesc;
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
	 * @param estateId 楼盘id
	 */
	@ApiModelProperty("楼盘id")
	public void setEstateId(String estateId) {
		this.estateId = estateId;
	}

	/**
	 * @return 楼盘id
	 */
	@ApiModelProperty("楼盘id")
	public String getEstateId() {
		return this.estateId;
	}

	/**
	 * @param estateType 1为商用2为住宅
	 */
	@ApiModelProperty("1为商用2为住宅")
	public void setEstateType(Integer estateType) {
		this.estateType = estateType;
	}

	/**
	 * @return 1为商用2为住宅
	 */
	@ApiModelProperty("1为商用2为住宅")
	public Integer getEstateType() {
		return this.estateType;
	}
	
	/**
	 * @param createTime 楼宇创建时间
	 */
	@ApiModelProperty("楼宇创建时间")
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * @return 楼宇创建时间
	 */
	@ApiModelProperty("楼宇创建时间")
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	 
}
