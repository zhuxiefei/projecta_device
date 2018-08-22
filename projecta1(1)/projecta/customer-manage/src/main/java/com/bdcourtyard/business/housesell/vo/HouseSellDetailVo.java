package com.bdcourtyard.business.housesell.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 *  HouseType
 *
 * @version : Ver 1.0
 * @date	: 2018-7-23
 */
public class HouseSellDetailVo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private  String housePriceId;
	private String houseId;
	private String houseNo;
	private String roomName;
	private String typeName;
	private String floorArea;
	private String interFloorArea;
	private String estateType;
	private String saleStatus;
	private String orientation;
	private String decorationDegree;
	private String buildingId;
	private String unitId;
	private String typeId;
	private String fileUrl;

	private String estateId;

	private String floor;

	private String price;
	private String totalPrice;

	private String floors;


	private List<HousePriceDiscountVo> housePriceDiscountVo;

	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(String floorArea) {
		this.floorArea = floorArea;
	}

	public String getInterFloorArea() {
		return interFloorArea;
	}

	public void setInterFloorArea(String interFloorArea) {
		this.interFloorArea = interFloorArea;
	}

	public String getEstateType() {
		return estateType;
	}

	public void setEstateType(String estateType) {
		this.estateType = estateType;
	}

	public String getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(String saleStatus) {
		this.saleStatus = saleStatus;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public String getDecorationDegree() {
		return decorationDegree;
	}

	public void setDecorationDegree(String decorationDegree) {
		this.decorationDegree = decorationDegree;
	}

	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getEstateId() {
		return estateId;
	}

	public void setEstateId(String estateId) {
		this.estateId = estateId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<HousePriceDiscountVo> getHousePriceDiscountVo() {
		return housePriceDiscountVo;
	}

	public void setHousePriceDiscountVo(List<HousePriceDiscountVo> housePriceDiscountVo) {
		this.housePriceDiscountVo = housePriceDiscountVo;
	}

	public String getHousePriceId() {
		return housePriceId;
	}

	public void setHousePriceId(String housePriceId) {
		this.housePriceId = housePriceId;
	}

	public String getFloors() {
		return floors;
	}

	public void setFloors(String floors) {
		this.floors = floors;
	}
}
