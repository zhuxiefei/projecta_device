package com.bdcourtyard.business.subscription.model;

import java.io.Serializable;
import java.util.List;

import com.bdcourtyard.business.housesell.vo.HousePriceDiscountVo;
import io.swagger.annotations.ApiModelProperty;
/**
 *  RoomsourceSubscription
 *
 * @version : Ver 1.0
 * @date	: 2018-7-24
 */
public class RoomsourceSubscription  implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

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

	private List<HousePriceDiscountVo> housePriceDiscountVo;













	/**
	 * 认购ID
	 */
	private String subscriptionId;

	/**
	 * 房屋ID
	 */
	private String houseId;



	private String clientId;
	/**
	 * 合同姓名
	 */
	private String contractName;

	/**
	 * 身份证号码
	 */
	private String idCard;

	/**
	 * 手机号码
	 */
	private String phone;

	/**
	 * 联系地址
	 */
	private String address;

	/**
	 * 成交房号
	 */
	private String bargainRoom;

	/**
	 * 面积
	 */
	private String subscriptionArea;

	/**
	 * 成交单价
	 */
	private String bargainPrice;

	/**
	 * 认购日期
	 */
	private String subscriptionTime;

	/**
	 * 签约日期
	 */
	private String contractTime;

	/**
	 * 付款方式
	 */
	private int payment;

	/**
	 * 成交总价
	 */
	private String bargainTotal;

	/**
	 * 定金
	 */
	private String handsel;

	/**
	 * 合同时效
	 */
	private String agreementTime;

	/**
	 * 首付款金额
	 */
	private String firstPay;

	/**
	 * 余额
	 */
	private String balance;

	/**
	 * 办理银行按揭时间
	 */
	private String processsingTime;

	/**
	 * 资料
	 */
	private String datum;

	/**
	 * 催款及办理记录
	 */
	private String records;

	/**
	 * 特别注意事项
	 */
	private String attention;

	/**
	 * 创建时间
	 */
	private java.util.Date createTime;

	private String datumOther;

	public String getDatumOther() {
		return datumOther;
	}

	public void setDatumOther(String datumOther) {
		this.datumOther = datumOther;
	}

	/**
	 * @param subscriptionId 认购ID
	 */
	@ApiModelProperty("认购ID")
	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	/**
	 * @return 认购ID
	 */
	@ApiModelProperty("认购ID")
	public String getSubscriptionId() {
		return this.subscriptionId;
	}

	/**
	 * @param houseId 房屋ID
	 */
	@ApiModelProperty("房屋ID")
	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	/**
	 * @return 房屋ID
	 */
	@ApiModelProperty("房屋ID")
	public String getHouseId() {
		return this.houseId;
	}

	/**
	 * @param contractName 合同姓名
	 */
	@ApiModelProperty("合同姓名")
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	/**
	 * @return 合同姓名
	 */
	@ApiModelProperty("合同姓名")
	public String getContractName() {
		return this.contractName;
	}

	/**
	 * @param idCard 身份证号码
	 */
	@ApiModelProperty("身份证号码")
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/**
	 * @return 身份证号码
	 */
	@ApiModelProperty("身份证号码")
	public String getIdCard() {
		return this.idCard;
	}

	/**
	 * @param phone 手机号码
	 */
	@ApiModelProperty("手机号码")
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return 手机号码
	 */
	@ApiModelProperty("手机号码")
	public String getPhone() {
		return this.phone;
	}

	/**
	 * @param address 联系地址
	 */
	@ApiModelProperty("联系地址")
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return 联系地址
	 */
	@ApiModelProperty("联系地址")
	public String getAddress() {
		return this.address;
	}

	/**
	 * @param bargainRoom 成交房号
	 */
	@ApiModelProperty("成交房号")
	public void setBargainRoom(String bargainRoom) {
		this.bargainRoom = bargainRoom;
	}

	/**
	 * @return 成交房号
	 */
	@ApiModelProperty("成交房号")
	public String getBargainRoom() {
		return this.bargainRoom;
	}

	/**
	 * @param subscriptionArea 面积
	 */
	@ApiModelProperty("面积")
	public void setSubscriptionArea(String subscriptionArea) {
		this.subscriptionArea = subscriptionArea;
	}

	/**
	 * @return 面积
	 */
	@ApiModelProperty("面积")
	public String getSubscriptionArea() {
		return this.subscriptionArea;
	}

	/**
	 * @param bargainPrice 成交单价
	 */
	@ApiModelProperty("成交单价")
	public void setBargainPrice(String bargainPrice) {
		this.bargainPrice = bargainPrice;
	}

	/**
	 * @return 成交单价
	 */
	@ApiModelProperty("成交单价")
	public String getBargainPrice() {
		return this.bargainPrice;
	}

	/**
	 * @param subscriptionTime 认购日期
	 */
	@ApiModelProperty("认购日期")
	public void setSubscriptionTime(String subscriptionTime) {
		this.subscriptionTime = subscriptionTime;
	}

	/**
	 * @return 认购日期
	 */
	@ApiModelProperty("认购日期")
	public String getSubscriptionTime() {
		return this.subscriptionTime;
	}


	/**
	 * @param contractTime 签约日期
	 */
	@ApiModelProperty("签约日期")
	public void setContractTime(String contractTime) {
		this.contractTime = contractTime;
	}

	/**
	 * @return 签约日期
	 */
	@ApiModelProperty("签约日期")
	public String getContractTime() {
		return this.contractTime;
	}


	/**
	 * @param payment 付款方式
	 */
	@ApiModelProperty("付款方式")
	public void setPayment(int payment) {
		this.payment = payment;
	}

	/**
	 * @return 付款方式
	 */
	@ApiModelProperty("付款方式")
	public int getPayment() {
		return this.payment;
	}

	/**
	 * @param bargainTotal 成交总价
	 */
	@ApiModelProperty("成交总价")
	public void setBargainTotal(String bargainTotal) {
		this.bargainTotal = bargainTotal;
	}

	/**
	 * @return 成交总价
	 */
	@ApiModelProperty("成交总价")
	public String getBargainTotal() {
		return this.bargainTotal;
	}

	/**
	 * @param handsel 定金
	 */
	@ApiModelProperty("定金")
	public void setHandsel(String handsel) {
		this.handsel = handsel;
	}

	/**
	 * @return 定金
	 */
	@ApiModelProperty("定金")
	public String getHandsel() {
		return this.handsel;
	}

	/**
	 * @param agreementTime 合同时效
	 */
	@ApiModelProperty("合同时效")
	public void setAgreementTime(String agreementTime) {
		this.agreementTime = agreementTime;
	}

	/**
	 * @return 合同时效
	 */
	@ApiModelProperty("合同时效")
	public String getAgreementTime() {
		return this.agreementTime;
	}


	/**
	 * @param firstPay 首付款金额
	 */
	@ApiModelProperty("首付款金额")
	public void setFirstPay(String firstPay) {
		this.firstPay = firstPay;
	}

	/**
	 * @return 首付款金额
	 */
	@ApiModelProperty("首付款金额")
	public String getFirstPay() {
		return this.firstPay;
	}

	/**
	 * @param balance 余额
	 */
	@ApiModelProperty("余额")
	public void setBalance(String balance) {
		this.balance = balance;
	}

	/**
	 * @return 余额
	 */
	@ApiModelProperty("余额")
	public String getBalance() {
		return this.balance;
	}

	/**
	 * @param processsingTime 办理银行按揭时间
	 */
	@ApiModelProperty("办理银行按揭时间")
	public void setProcesssingTime(String processsingTime) {
		this.processsingTime = processsingTime;
	}

	/**
	 * @return 办理银行按揭时间
	 */
	@ApiModelProperty("办理银行按揭时间")
	public String getProcesssingTime() {
		return this.processsingTime;
	}


	/**
	 * @param datum 资料
	 */
	@ApiModelProperty("资料")
	public void setDatum(String datum) {
		this.datum = datum;
	}

	/**
	 * @return 资料
	 */
	@ApiModelProperty("资料")
	public String getDatum() {
		return this.datum;
	}

	/**
	 * @param records 催款及办理记录
	 */
	@ApiModelProperty("催款及办理记录")
	public void setRecords(String records) {
		this.records = records;
	}

	/**
	 * @return 催款及办理记录
	 */
	@ApiModelProperty("催款及办理记录")
	public String getRecords() {
		return this.records;
	}

	/**
	 * @param attention 特别注意事项
	 */
	@ApiModelProperty("特别注意事项")
	public void setAttention(String attention) {
		this.attention = attention;
	}

	/**
	 * @return 特别注意事项
	 */
	@ApiModelProperty("特别注意事项")
	public String getAttention() {
		return this.attention;
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


	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
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

	public String getEstateId() {
		return estateId;
	}

	public void setEstateId(String estateId) {
		this.estateId = estateId;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
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
}
