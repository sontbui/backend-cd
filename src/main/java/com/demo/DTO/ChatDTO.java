package com.demo.DTO;

import java.util.Date;

import com.demo.entities.User;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ChatDTO {
	private Integer id;
	private int senderID; // Khóa ngoại trỏ tới bảng User (người gửi)
	private int receiverID; // Khóa ngoại trỏ tới bảng User (người nhận)
	private String content;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getSenderID() {
		return senderID;
	}
	public void setSenderID(int senderID) {
		this.senderID = senderID;
	}
	public int getReceiverID() {
		return receiverID;
	}
	public void setReceiverID(int receiverID) {
		this.receiverID = receiverID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "ChatDTO [id=" + id + ", senderID=" + senderID + ", receiverID=" + receiverID + ", content=" + content
				+ ", time=" + time + "]";
	}

	
}
