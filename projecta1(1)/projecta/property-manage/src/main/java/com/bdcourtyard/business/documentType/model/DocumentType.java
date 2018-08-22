package com.bdcourtyard.business.documentType.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
/**
 *  DocumentType
 *
 * @version : Ver 1.0
 * @date	: 2018-7-31
 */
public class DocumentType  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * 资料类型Id     
     */	
	private java.lang.String typeId;
	
	/**
     * 类型名称     
     */	
	private java.lang.String typeName;
	
	/**
     * 类型描述     
     */	
	private java.lang.String typeDesc;
	
	/**
     * 创建时间     
     */	
	private java.util.Date createTime;
	
	/**
     * 企业员工ID     
     */	
	private java.lang.String employeeId;
	
	/**
     * 更新时间     
     */	
	private java.util.Date updateTime;
	
	/**
     * 楼盘id     
     */	
	private java.lang.String estateId;
	
	 
	
	/**
	 * @param typeId 资料类型Id
	 */
	@ApiModelProperty("资料类型Id")
	public void setTypeId(java.lang.String typeId) {
		this.typeId = typeId;
	}
	
	/**
	 * @return 资料类型Id
	 */
	@ApiModelProperty("资料类型Id")
	public java.lang.String getTypeId() {
		return this.typeId;
	}
	
	/**
	 * @param typeName 类型名称
	 */
	@ApiModelProperty("类型名称")
	public void setTypeName(java.lang.String typeName) {
		this.typeName = typeName;
	}
	
	/**
	 * @return 类型名称
	 */
	@ApiModelProperty("类型名称")
	public java.lang.String getTypeName() {
		return this.typeName;
	}
	
	/**
	 * @param typeDesc 类型描述
	 */
	@ApiModelProperty("类型描述")
	public void setTypeDesc(java.lang.String typeDesc) {
		this.typeDesc = typeDesc;
	}
	
	/**
	 * @return 类型描述
	 */
	@ApiModelProperty("类型描述")
	public java.lang.String getTypeDesc() {
		return this.typeDesc;
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
	 * @param employeeId 企业员工ID
	 */
	@ApiModelProperty("企业员工ID")
	public void setEmployeeId(java.lang.String employeeId) {
		this.employeeId = employeeId;
	}
	
	/**
	 * @return 企业员工ID
	 */
	@ApiModelProperty("企业员工ID")
	public java.lang.String getEmployeeId() {
		return this.employeeId;
	}
	
	/**
	 * @param updateTime 更新时间
	 */
	@ApiModelProperty("更新时间")
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
	
	/**
	 * @return 更新时间
	 */
	@ApiModelProperty("更新时间")
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}
	 
	
	/**
	 * @param estateId 楼盘id
	 */
	@ApiModelProperty("楼盘id")
	public void setEstateId(java.lang.String estateId) {
		this.estateId = estateId;
	}
	
	/**
	 * @return 楼盘id
	 */
	@ApiModelProperty("楼盘id")
	public java.lang.String getEstateId() {
		return this.estateId;
	}
}
