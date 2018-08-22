package com.bdcourtyard.business.houseprice.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
/**
 *  RoomsourceHouseprice
 *
 * @version : Ver 1.0
 * @date	: 2018-7-25
 */
public class RoomsourceHouseprice  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * 房屋价格ID     
     */	
	private String housePriceId;
	
	/**
     * 楼盘定价类型名称     
     */	
	private String priceName;
	
	/**
     * 楼宇ID     
     */	
	private String buildingId;
	
	/**
     * 单元Id     
     */	
	private String unitId;
	
	/**
     * 户型ID     
     */	
	private String typeId;
	
	/**
     * 楼层区间     
     */	
	private String storey;
	
	/**
     * 楼层增价     
     */	
	private Long storeyPrice;
	
	/**
     * 朝向增价     
     */	
	private Long orientationPrice;
	
	/**
     * 装修增价     
     */	
	private Long degreePrice;
	
	/**
     * 朝向     
     */	
	private String orientation;
	
	/**
     * 装修程度1精装 2毛坯     
     */	
	private String degree;
	
	/**
     * 房屋基础单价     
     */	
	private Long originalPrice;
	
	/**
     * 房屋单价     
     */	
	private Long price;
	
	/**
     * 房屋总价     
     */	
	private Long totalPrice;
	
	/**
     * 楼盘ID     
     */	
	private String estateId;
	
	/**
     * 创建人     
     */	
	private String employeeId;
	
	/**
     * 折扣表的id（多个折扣用“，”隔开）     
     */	
	private String discountId;
	
	/**
     * 创建时间     
     */	
	private java.util.Date creatTime;

	/**
	 * @param housePriceId 房屋价格ID
	 */
	@ApiModelProperty("房屋价格ID")
	public void setHousePriceId(String housePriceId) {
		this.housePriceId = housePriceId;
	}
	
	/**
	 * @return 房屋价格ID
	 */
	@ApiModelProperty("房屋价格ID")
	public String getHousePriceId() {
		return this.housePriceId;
	}
	
	/**
	 * @param priceName 楼盘定价类型名称
	 */
	@ApiModelProperty("楼盘定价类型名称")
	public void setPriceName(String priceName) {
		this.priceName = priceName;
	}
	
	/**
	 * @return 楼盘定价类型名称
	 */
	@ApiModelProperty("楼盘定价类型名称")
	public String getPriceName() {
		return this.priceName;
	}
	
	/**
	 * @param buildingId 楼宇ID
	 */
	@ApiModelProperty("楼宇ID")
	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}
	
	/**
	 * @return 楼宇ID
	 */
	@ApiModelProperty("楼宇ID")
	public String getBuildingId() {
		return this.buildingId;
	}
	
	/**
	 * @param unitId 单元Id
	 */
	@ApiModelProperty("单元Id")
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	
	/**
	 * @return 单元Id
	 */
	@ApiModelProperty("单元Id")
	public String getUnitId() {
		return this.unitId;
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
	 * @param storey 楼层区间
	 */
	@ApiModelProperty("楼层区间")
	public void setStorey(String storey) {
		this.storey = storey;
	}
	
	/**
	 * @return 楼层区间
	 */
	@ApiModelProperty("楼层区间")
	public String getStorey() {
		return this.storey;
	}
	
	/**
	 * @param storeyPrice 楼层增价
	 */
	@ApiModelProperty("楼层增价")
	public void setStoreyPrice(Long storeyPrice) {
		this.storeyPrice = storeyPrice;
	}
	
	/**
	 * @return 楼层增价
	 */
	@ApiModelProperty("楼层增价")
	public Long getStoreyPrice() {
		return this.storeyPrice;
	}
	
	/**
	 * @param orientationPrice 朝向增价
	 */
	@ApiModelProperty("朝向增价")
	public void setOrientationPrice(Long orientationPrice) {
		this.orientationPrice = orientationPrice;
	}
	
	/**
	 * @return 朝向增价
	 */
	@ApiModelProperty("朝向增价")
	public Long getOrientationPrice() {
		return this.orientationPrice;
	}
	
	/**
	 * @param degreePrice 装修增价
	 */
	@ApiModelProperty("装修增价")
	public void setDegreePrice(Long degreePrice) {
		this.degreePrice = degreePrice;
	}
	
	/**
	 * @return 装修增价
	 */
	@ApiModelProperty("装修增价")
	public Long getDegreePrice() {
		return this.degreePrice;
	}
	
	/**
	 * @param orientation 朝向
	 */
	@ApiModelProperty("朝向")
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	
	/**
	 * @return 朝向
	 */
	@ApiModelProperty("朝向")
	public String getOrientation() {
		return this.orientation;
	}
	
	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	/**
	 * @param originalPrice 房屋基础单价
	 */
	@ApiModelProperty("房屋基础单价")
	public void setOriginalPrice(Long originalPrice) {
		this.originalPrice = originalPrice;
	}
	
	/**
	 * @return 房屋基础单价
	 */
	@ApiModelProperty("房屋基础单价")
	public Long getOriginalPrice() {
		return this.originalPrice;
	}
	
	/**
	 * @param price 房屋单价
	 */
	@ApiModelProperty("房屋单价")
	public void setPrice(Long price) {
		this.price = price;
	}
	
	/**
	 * @return 房屋单价
	 */
	@ApiModelProperty("房屋单价")
	public Long getPrice() {
		return this.price;
	}
	
	/**
	 * @param totalPrice 房屋总价
	 */
	@ApiModelProperty("房屋总价")
	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	/**
	 * @return 房屋总价
	 */
	@ApiModelProperty("房屋总价")
	public Long getTotalPrice() {
		return this.totalPrice;
	}
	
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
	 * @param employeeId 创建人
	 */
	@ApiModelProperty("创建人")
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	/**
	 * @return 创建人
	 */
	@ApiModelProperty("创建人")
	public String getEmployeeId() {
		return this.employeeId;
	}
	
	/**
	 * @param discountId 折扣表的id（多个折扣用“，”隔开）
	 */
	@ApiModelProperty("折扣表的id（多个折扣用“，”隔开）")
	public void setDiscountId(String discountId) {
		this.discountId = discountId;
	}
	
	/**
	 * @return 折扣表的id（多个折扣用“，”隔开）
	 */
	@ApiModelProperty("折扣表的id（多个折扣用“，”隔开）")
	public String getDiscountId() {
		return this.discountId;
	}
	
	/**
	 * @param creatTime 创建时间
	 */
	@ApiModelProperty("创建时间")
	public void setCreatTime(java.util.Date creatTime) {
		this.creatTime = creatTime;
	}
	
	/**
	 * @return 创建时间
	 */
	@ApiModelProperty("创建时间")
	public java.util.Date getCreatTime() {
		return this.creatTime;
	}
	 
}
