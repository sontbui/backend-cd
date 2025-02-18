package com.demo.entities;
// Generated Nov 8, 2024, 3:46:28 PM by Hibernate Tools 4.3.6.Final

import java.math.BigDecimal;
import jakarta.persistence.*;

/**
 * Orderdetails generated by hbm2java
 */
@Entity
@Table(name = "orderdetails", catalog = "music_store")
public class Orderdetails implements java.io.Serializable {

	private Integer id;
	private Cd cd;
	private Order order;
	private Integer quantity;
	private BigDecimal price;
	private Boolean status;

	public Orderdetails() {
	}

	public Orderdetails(Cd cd, Order order, Integer quantity, BigDecimal price, Boolean status) {
		this.cd = cd;
		this.order = order;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_id")
	public Cd getCd() {
		return this.cd;
	}

	public void setCd(Cd cd) {
		this.cd = cd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Column(name = "quantity")
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Column(name = "price", precision = 10)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "status")
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
