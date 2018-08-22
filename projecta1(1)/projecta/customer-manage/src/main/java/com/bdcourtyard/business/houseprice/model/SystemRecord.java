package com.bdcourtyard.business.houseprice.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
/**
 *  SystemRecord
 *
 * @version : Ver 1.0
 * @date	: 2018-7-24
 */
public class SystemRecord  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * 操作记录表ID     
     */	
	private String actId;
	
	/**
     * 关联ID     
     */	
	private String reaId;
	
	/**
     * 模块类型：1.折扣管理2.     
     */	
	private String modelType;
	
	/**
     * 操作类型：add,del,edit;     
     */	
	private String optType;
	
	/**
     * 备注     
     */	
	private String actContent;
	
	/**
     * 操作人     
     */	
	private String employeeId;
	
	/**
     * 操作时间     
     */	
	private java.util.Date creatTime;
	
	 
	
	/**
	 * @param actId 操作记录表ID
	 */
	@ApiModelProperty("操作记录表ID")
	public void setActId(String actId) {
		this.actId = actId;
	}
	
	/**
	 * @return 操作记录表ID
	 */
	@ApiModelProperty("操作记录表ID")
	public String getActId() {
		return this.actId;
	}
	
	/**
	 * @param reaId 关联ID
	 */
	@ApiModelProperty("关联ID")
	public void setReaId(String reaId) {
		this.reaId = reaId;
	}
	
	/**
	 * @return 关联ID
	 */
	@ApiModelProperty("关联ID")
	public String getReaId() {
		return this.reaId;
	}
	
	/**
	 * @param modelType 模块类型：1.折扣管理2.
	 */
	@ApiModelProperty("模块类型：1.折扣管理2.")
	public void setModelType(String modelType) {
		this.modelType = modelType;
	}
	
	/**
	 * @return 模块类型：1.折扣管理2.
	 */
	@ApiModelProperty("模块类型：1.折扣管理2.")
	public String getModelType() {
		return this.modelType;
	}
	
	/**
	 * @param optType 操作类型：add,del,edit;
	 */
	@ApiModelProperty("操作类型：add,del,edit;")
	public void setOptType(String optType) {
		this.optType = optType;
	}
	
	/**
	 * @return 操作类型：add,del,edit;
	 */
	@ApiModelProperty("操作类型：add,del,edit;")
	public String getOptType() {
		return this.optType;
	}
	
	/**
	 * @param actContent 备注
	 */
	@ApiModelProperty("备注")
	public void setActContent(String actContent) {
		this.actContent = actContent;
	}
	
	/**
	 * @return 备注
	 */
	@ApiModelProperty("备注")
	public String getActContent() {
		return this.actContent;
	}
	
	/**
	 * @param employeeId 操作人
	 */
	@ApiModelProperty("操作人")
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	/**
	 * @return 操作人
	 */
	@ApiModelProperty("操作人")
	public String getEmployeeId() {
		return this.employeeId;
	}
	
	/**
	 * @param creatTime 操作时间
	 */
	@ApiModelProperty("操作时间")
	public void setCreatTime(java.util.Date creatTime) {
		this.creatTime = creatTime;
	}
	
	/**
	 * @return 操作时间
	 */
	@ApiModelProperty("操作时间")
	public java.util.Date getCreatTime() {
		return this.creatTime;
	}
	 
}
