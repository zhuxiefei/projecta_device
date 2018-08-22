package com.bdcourtyard.business.houseprice.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *  RoomsourceHousediscount
 *
 * @version : Ver 1.0
 * @date	: 2018-7-24
 */
public class RoomsourceHousediscount  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String  startTime;
	private String endTime;

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
     * 折扣ID     
     */	
	private String discountId;
	
	/**
     * 折扣名称     
     */	
	private String discountName;
	
	/**
     * 折扣率     
     */	
	private Long discount;
	
	/**
     * 生效时间     
     */	
	private java.util.Date efficacyDate;
	
	/**
     * 失效时间     
     */	
	private java.util.Date loseEfficacyDate;
	
	/**
     * 创建人     
     */	
	private String employeeId;
	
	/**
     * 创建时间     
     */	
	private java.util.Date creatTime;
	
	/**
     * 修改时间     
     */	
	private java.util.Date updateTime;
	
	/**
     * 最后修改人     
     */	
	private String updateEmployeeId;

	/**
	 * @param discountId 折扣ID
	 */
	@ApiModelProperty("折扣ID")
	public void setDiscountId(String discountId) {
		this.discountId = discountId;
	}
	
	/**
	 * @return 折扣ID
	 */
	@ApiModelProperty("折扣ID")
	public String getDiscountId() {
		return this.discountId;
	}
	
	/**
	 * @param discountName 折扣名称
	 */
	@ApiModelProperty("折扣名称")
	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}
	
	/**
	 * @return 折扣名称
	 */
	@ApiModelProperty("折扣名称")
	public String getDiscountName() {
		return this.discountName;
	}
	
	/**
	 * @param discount 折扣率
	 */
	@ApiModelProperty("折扣率")
	public void setDiscount(Long discount) {
		this.discount = discount;
	}
	
	/**
	 * @return 折扣率
	 */
	@ApiModelProperty("折扣率")
	public Long getDiscount() {
		return this.discount;
	}
	
	/**
	 * @param efficacyDate 生效时间
	 */
	@ApiModelProperty("生效时间")
	public void setEfficacyDate(java.util.Date efficacyDate) {
		this.efficacyDate = efficacyDate;
	}
	
	/**
	 * @return 生效时间
	 */
	@ApiModelProperty("生效时间")
	public java.util.Date getEfficacyDate() {
		return this.efficacyDate;
	}
	 
	
	/**
	 * @param loseEfficacyDate 失效时间
	 */
	@ApiModelProperty("失效时间")
	public void setLoseEfficacyDate(java.util.Date loseEfficacyDate) {
		this.loseEfficacyDate = loseEfficacyDate;
	}
	
	/**
	 * @return 失效时间
	 */
	@ApiModelProperty("失效时间")
	public java.util.Date getLoseEfficacyDate() {
		return this.loseEfficacyDate;
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


	/**
	 * @param updateTime 修改时间
	 */
	@ApiModelProperty("修改时间")
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
	
	/**
	 * @return 修改时间
	 */
	@ApiModelProperty("修改时间")
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}
	 
	
	/**
	 * @param updateEmployeeId 最后修改人
	 */
	@ApiModelProperty("最后修改人")
	public void setUpdateEmployeeId(String updateEmployeeId) {
		this.updateEmployeeId = updateEmployeeId;
	}
	
	/**
	 * @return 最后修改人
	 */
	@ApiModelProperty("最后修改人")
	public String getUpdateEmployeeId() {
		return this.updateEmployeeId;
	}
}
