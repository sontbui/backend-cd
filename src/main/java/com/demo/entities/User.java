package com.demo.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "user", catalog = "music_store")
public class User implements java.io.Serializable {

	private Integer id;
	private String fullName;
	private String username;
	private String password;
	private String email;
	private String securityCode;
	private Integer status;
	@Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy")
	private Date created;
	private String avatar;
	private String phone;
	private Integer role;
	private Set<DeliveryInfo> deliveryInfos = new HashSet<DeliveryInfo>(0);
	private Set<Order> orders = new HashSet<Order>(0);
	private Set<Chat> sentMessages = new HashSet<Chat>(0); // Tin nhắn đã gửi
	private Set<Chat> receivedMessages = new HashSet<Chat>(0); // Tin nhắn đã nhận
	@Column(name = "google_id", unique = true)
	private String googleId;

	@Column(name = "is_google_account")
	private Boolean isGoogleAccount = false;
	public User() {
	}

	public User(String fullName, String username, String password, String email, String securityCode, Integer status,
			Date created, String avatar, String phone, Integer role, Set<DeliveryInfo> deliveryInfos, Set<Order> orders,
			Set<Chat> sentMessages, Set<Chat> receivedMessages) {
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.securityCode = securityCode;
		this.status = status;
		this.created = created;
		this.avatar = avatar;
		this.phone = phone;
		this.role = role;
		this.deliveryInfos = deliveryInfos;
		this.orders = orders;
		this.sentMessages = sentMessages;
		this.receivedMessages = receivedMessages;
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

	@Column(name = "full_name", length = 100)
	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "username", length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email", length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "security_code", length = 20)
	public String getSecurityCode() {
		return this.securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "created")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Column(name = "avatar", length = 255)
	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Column(name = "phone", length = 15)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "role")
	public Integer getRole() {
		return this.role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sender")
	public Set<Chat> getSentMessages() {
		return this.sentMessages;
	}

	public void setSentMessages(Set<Chat> sentMessages) {
		this.sentMessages = sentMessages;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "receiver")
	public Set<Chat> getReceivedMessages() {
		return this.receivedMessages;
	}

	public void setReceivedMessages(Set<Chat> receivedMessages) {
		this.receivedMessages = receivedMessages;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<DeliveryInfo> getDeliveryInfos() {
		return this.deliveryInfos;
	}

	public void setDeliveryInfos(Set<DeliveryInfo> deliveryInfos) {
		this.deliveryInfos = deliveryInfos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public String getGoogleId() {
		return googleId;
	}

	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}

	public Boolean getIsGoogleAccount() {
		return isGoogleAccount;
	}

	public void setIsGoogleAccount(Boolean isGoogleAccount) {
		this.isGoogleAccount = isGoogleAccount;
	}
	
}
