package com.demo.entities;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "chat", catalog = "music_store")
public class Chat implements java.io.Serializable {

	private Integer id;
	private User sender; // Khóa ngoại trỏ tới bảng User (người gửi)
	private User receiver; // Khóa ngoại trỏ tới bảng User (người nhận)
	private String content;
	private Date time;

	public Chat() {
	}

	public Chat(User sender, User receiver, String content, Date time) {
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
		this.time = time;
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
	@JoinColumn(name = "sender_id", nullable = false)
	public User getSender() {
		return this.sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "receiver_id", nullable = false)
	public User getReceiver() {
		return this.receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	@Column(name = "content", nullable = false, columnDefinition = "TEXT")
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "time", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
}
