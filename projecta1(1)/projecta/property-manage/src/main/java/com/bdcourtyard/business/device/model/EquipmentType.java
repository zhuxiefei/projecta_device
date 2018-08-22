package com.bdcourtyard.business.device.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 *  EquipmentType
 *
 * @version : Ver 1.0
 * @date	: 2018-8-7
 */
public class EquipmentType implements Serializable {
	

	private static final long serialVersionUID = 1L;
	

	private String typeId;


	private String typeName;


	private Date createTime;


	private String estateId;


	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}


	public String getTypeId() {
		return this.typeId;
	}


	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	public String getTypeName() {
		return this.typeName;
	}


	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public java.util.Date getCreateTime() {
		return this.createTime;
	}


	public void setEstateId(String estateId) {
		this.estateId = estateId;
	}


	public String getEstateId() {
		return this.estateId;
	}

	@Override
	public String toString() {
		return "EquipmentType{" +
				"typeId='" + typeId + '\'' +
				", typeName='" + typeName + '\'' +
				", createTime=" + createTime +
				", estateId='" + estateId + '\'' +
				'}';
	}
}
