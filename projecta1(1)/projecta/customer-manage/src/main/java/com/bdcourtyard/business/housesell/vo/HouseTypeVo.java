package com.bdcourtyard.business.housesell.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *  HouseType
 *
 * @version : Ver 1.0
 * @date	: 2018-7-23
 */
public class HouseTypeVo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     *      
     */	
	private String typeId;

	/**
     * 户型编号
     */
	private String typeNo;

	/**
     * 户型名称
     */
	private String typeName;

	/**
     * 发布人ID
     */
	private String employeeId;

	/**
     * 户型描述
     */
	private String typeDesc;

	/**
     * 建筑面积
     */
	private Double floorArea;

	/**
     * 套内面积
     */
	private Double interFloorArea;

	/**
     * 户型图ID
     */
	private String fileId;

	/**
     * 创建时间
     */
	private java.util.Date createTime;

	/**
     * 楼盘ID
     */
	private String estateId;



	/**
	 * @param typeId
	 */
	@ApiModelProperty("")
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	/**
	 * @return
	 */
	@ApiModelProperty("")
	public String getTypeId() {
		return this.typeId;
	}

	/**
	 * @param typeNo 户型编号
	 */
	@ApiModelProperty("户型编号")
	public void setTypeNo(String typeNo) {
		this.typeNo = typeNo;
	}

	/**
	 * @return 户型编号
	 */
	@ApiModelProperty("户型编号")
	public String getTypeNo() {
		return this.typeNo;
	}

	/**
	 * @param typeName 户型名称
	 */
	@ApiModelProperty("户型名称")
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * @return 户型名称
	 */
	@ApiModelProperty("户型名称")
	public String getTypeName() {
		return this.typeName;
	}

	/**
	 * @param employeeId 发布人ID
	 */
	@ApiModelProperty("发布人ID")
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return 发布人ID
	 */
	@ApiModelProperty("发布人ID")
	public String getEmployeeId() {
		return this.employeeId;
	}

	/**
	 * @param typeDesc 户型描述
	 */
	@ApiModelProperty("户型描述")
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}

	/**
	 * @return 户型描述
	 */
	@ApiModelProperty("户型描述")
	public String getTypeDesc() {
		return this.typeDesc;
	}

	/**
	 * @param floorArea 建筑面积
	 */
	@ApiModelProperty("建筑面积")
	public void setFloorArea(Double floorArea) {
		this.floorArea = floorArea;
	}

	/**
	 * @return 建筑面积
	 */
	@ApiModelProperty("建筑面积")
	public Double getFloorArea() {
		return this.floorArea;
	}

	/**
	 * @param interFloorArea 套内面积
	 */
	@ApiModelProperty("套内面积")
	public void setInterFloorArea(Double interFloorArea) {
		this.interFloorArea = interFloorArea;
	}

	/**
	 * @return 套内面积
	 */
	@ApiModelProperty("套内面积")
	public Double getInterFloorArea() {
		return this.interFloorArea;
	}

	/**
	 * @param fileId 户型图ID
	 */
	@ApiModelProperty("户型图ID")
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	/**
	 * @return 户型图ID
	 */
	@ApiModelProperty("户型图ID")
	public String getFileId() {
		return this.fileId;
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
}
