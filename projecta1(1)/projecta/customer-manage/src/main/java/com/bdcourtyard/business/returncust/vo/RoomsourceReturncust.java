package com.bdcourtyard.business.returncust.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Set;

/**
 *  RoomsourceReturncust
 *
 * @version : Ver 1.0
 * @date	: 2018-7-25
 */
public class RoomsourceReturncust implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String startTime;
	private String endTime;
	private String clientId;
	private String dateRange;
	private String clientName;
	private String clientPhone;
	private String clientState;
	private  String estateId;
	private Set<String> list;

	public Set<String> getList() {
		return list;
	}

	public void setList(Set<String> list) {
		this.list = list;
	}

	public String getEstateId() {
		return estateId;
	}

	public void setEstateId(String estateId) {
		this.estateId = estateId;
	}

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

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getDateRange() {
		return dateRange;
	}

	public void setDateRange(String dateRange) {
		this.dateRange = dateRange;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	public String getClientState() {
		return clientState;
	}

	public void setClientState(String clientState) {
		this.clientState = clientState;
	}
}
