package com.demo.DTO;

import java.math.BigDecimal;
import java.util.Date;

import com.demo.entities.DeliveryInfo;
import com.demo.entities.Order;

public class PaymentDTO {
	private Integer id;
	private Integer deliveryInfoID;
	private Integer orderID;
	private String transactionNo;
	private Date created;
	private String description;
	private BigDecimal price;
	private Boolean status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDeliveryInfoID() {
		return deliveryInfoID;
	}
	public void setDeliveryInfoID(Integer deliveryInfoID) {
		this.deliveryInfoID = deliveryInfoID;
	}
	
	public String getTransactionNo() {
		return transactionNo;
	}
	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public Integer getOrderID() {
		return orderID;
	}
	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}
	@Override
	public String toString() {
		return "PaymentDTO [id=" + id + ", deliveryInfoID=" + deliveryInfoID + ", orderID=" + orderID
				+ ", transactionNo=" + transactionNo + ", created=" + created + ", description=" + description
				+ ", price=" + price + ", status=" + status + "]";
	}
	

}
