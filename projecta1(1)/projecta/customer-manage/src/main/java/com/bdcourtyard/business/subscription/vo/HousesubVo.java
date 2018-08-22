package com.bdcourtyard.business.subscription.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *  Housesell
 *
 * @version : Ver 1.0
 * @date	: 2018-7-24
 */
public class HousesubVo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	private String houseId;
	/*

	 */
	private  String clientName;

	/**
	 * 房号
	 */
	private String houseNum;

	/**
	 * 房屋描述
	 */
	private String houseDesc;

	/**
	 * 房屋所属楼宇ID
	 */
	private String buildingId;

	private String estateType;

	/**
	 * 所属单元ID
	 */
	private String unitId;

	/**
	 * 所属户型ID
	 */
	private String typeId;
	/**
	 * 建筑面积
	 */
	private String floorArea;

	/**
	 * 开盘时间
	 */
	private java.util.Date openTime;

	/**
	 * 1东2西3南4北5东南6东北7西南8西北
	 */
	private Boolean orientation;

	/**
	 * 1精装修2毛坯
	 */
	private Boolean decorationDegree;

	/**
	 * 排序字段
	 */
	private Integer displayOrder;

	/**
	 * 楼盘id
	 */
	private String estateId;

	/**
	 * 房屋创建时间
	 */
	private java.util.Date createTime;

	/**
	 * 房屋编号
	 */
	private String houseNo;

	/**
	 * 销售状态
	 */
	private int saleStatus;

	/**
	 * 房间
	 */
	private String roomName;


	/**
	 *
	 * @return
	 */
	private String typeName;

	/**
	 *
	 * @return
	 */
	private String  interFloorArea;





	@ApiModelProperty("房间")
	public String getRoomName() {
		return roomName;
	}
	@ApiModelProperty("房间")
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	/**
	 * @param houseId
	 */
	@ApiModelProperty("")
	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	/**
	 * @return
	 */
	@ApiModelProperty("")
	public String getHouseId() {
		return this.houseId;
	}

	/**
	 * @param houseNum 房号
	 */
	@ApiModelProperty("房号")
	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	/**
	 * @return 房号
	 */
	@ApiModelProperty("房号")
	public String getHouseNum() {
		return this.houseNum;
	}

	/**
	 * @param houseDesc 房屋描述
	 */
	@ApiModelProperty("房屋描述")
	public void setHouseDesc(String houseDesc) {
		this.houseDesc = houseDesc;
	}

	/**
	 * @return 房屋描述
	 */
	@ApiModelProperty("房屋描述")
	public String getHouseDesc() {
		return this.houseDesc;
	}

	/**
	 * @param buildingId 房屋所属楼宇ID
	 */
	@ApiModelProperty("房屋所属楼宇ID")
	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	/**
	 * @return 房屋所属楼宇ID
	 */
	@ApiModelProperty("房屋所属楼宇ID")
	public String getBuildingId() {
		return this.buildingId;
	}

	/**
	 * @param unitId 所属单元ID
	 */
	@ApiModelProperty("所属单元ID")
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	/**
	 * @return 所属单元ID
	 */
	@ApiModelProperty("所属单元ID")
	public String getUnitId() {
		return this.unitId;
	}

	/**
	 * @param typeId 所属户型ID
	 */
	@ApiModelProperty("所属户型ID")
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	/**
	 * @return 所属户型ID
	 */
	@ApiModelProperty("所属户型ID")
	public String getTypeId() {
		return this.typeId;
	}

	/**
	 * @param openTime 开盘时间
	 */
	@ApiModelProperty("开盘时间")
	public void setOpenTime(java.util.Date openTime) {
		this.openTime = openTime;
	}

	/**
	 * @return 开盘时间
	 */
	@ApiModelProperty("开盘时间")
	public java.util.Date getOpenTime() {
		return this.openTime;
	}


	/**
	 * @param orientation 1东2西3南4北5东南6东北7西南8西北
	 */
	@ApiModelProperty("1东2西3南4北5东南6东北7西南8西北")
	public void setOrientation(Boolean orientation) {
		this.orientation = orientation;
	}

	/**
	 * @return 1东2西3南4北5东南6东北7西南8西北
	 */
	@ApiModelProperty("1东2西3南4北5东南6东北7西南8西北")
	public Boolean getOrientation() {
		return this.orientation;
	}

	/**
	 * @param decorationDegree 1精装修2毛坯
	 */
	@ApiModelProperty("1精装修2毛坯")
	public void setDecorationDegree(Boolean decorationDegree) {
		this.decorationDegree = decorationDegree;
	}

	/**
	 * @return 1精装修2毛坯
	 */
	@ApiModelProperty("1精装修2毛坯")
	public Boolean getDecorationDegree() {
		return this.decorationDegree;
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
	 * @param createTime 房屋创建时间
	 */
	@ApiModelProperty("房屋创建时间")
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return 房屋创建时间
	 */
	@ApiModelProperty("房屋创建时间")
	public java.util.Date getCreateTime() {
		return this.createTime;
	}


	/**
	 * @param houseNo 房屋编号
	 */
	@ApiModelProperty("房屋编号")
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	/**
	 * @return 房屋编号
	 */
	@ApiModelProperty("房屋编号")
	public String getHouseNo() {
		return this.houseNo;
	}

	/**
	 * @param saleStatus 销售状态
	 */
	@ApiModelProperty("销售状态")
	public void setSaleStatus(int saleStatus) {
		this.saleStatus = saleStatus;
	}

	/**
	 * @return 销售状态
	 */
	@ApiModelProperty("销售状态")
	public int getSaleStatus() {
		return this.saleStatus;
	}

	@ApiModelProperty("楼宇类型")
	public String getEstateType() {
		return estateType;
	}

	@ApiModelProperty("楼宇类型")
	public void setEstateType(String estateType) {
		this.estateType = estateType;
	}

	@ApiModelProperty("建筑面积")
	public String getFloorArea() {
		return floorArea;
	}

	@ApiModelProperty("建筑面积")
	public void setFloorArea(String floorArea) {
		this.floorArea = floorArea;
	}


	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getInterFloorArea() {
		return interFloorArea;
	}

	public void setInterFloorArea(String interFloorArea) {
		this.interFloorArea = interFloorArea;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


}
