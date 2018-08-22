package com.bdcourtyard.business.housesell.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *  HouseType
 *
 * @version : Ver 1.0
 * @date	: 2018-7-23
 */
public class HousePriceVo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String housePriceId;
	private String price;
	private String totalPrice;

	private String storey;

	private String discountId;


	public String getHousePriceId() {
		return housePriceId;
	}

	public void setHousePriceId(String housePriceId) {
		this.housePriceId = housePriceId;
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

	public String getStorey() {
		return storey;
	}

	public void setStorey(String storey) {
		this.storey = storey;
	}

	public String getDiscountId() {
		return discountId;
	}

	public void setDiscountId(String discountId) {
		this.discountId = discountId;
	}
}
