package com.demo.DTO;

import java.math.BigDecimal;
import java.util.Date;

import com.demo.entities.User;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderDTO {
	private Integer id;
	private Integer userID;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date orderDate;
	private double totalAmount;
	private String reason;
	private Integer status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
