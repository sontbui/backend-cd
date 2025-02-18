package com.demo.DTO;

import java.math.BigDecimal;

import com.demo.entities.Cd;
import com.demo.entities.Order;

public class OrderDetailsDTO {
	private Integer id;
	private int cdID;
	private String cdTitle;
	private int orderID;
	private Integer quantity;
	private BigDecimal price;
	private Boolean status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getCdID() {
		return cdID;
	}
	public void setCdID(int cdID) {
		this.cdID = cdID;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getCdTitle() {
		return cdTitle;
	}
	public void setCdTitle(String cdTitle) {
		this.cdTitle = cdTitle;
	}

	
}
