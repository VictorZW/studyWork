package com.cdsoft.platform.entity;

import java.util.Date;

public class Message {

	private String id;
	
	private String title;
	
	private String type;
	
	private String sender;
	
	private String recipient;
	
	private String content;
	
	private Date times;
	
	private String messageCode;
	
	private Date updateTime;
	
	private String updateUser;
	
	private Date createTime;
	
	private String createUser;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTimes() {
		return times;
	}

	public void setTimes(Date times) {
		this.times = times;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", title=" + title + ", type=" + type
				+ ", sender=" + sender + ", recipient=" + recipient
				+ ", content=" + content + ", times=" + times
				+ ", messageCode=" + messageCode + ", updateTime=" + updateTime
				+ ", updateUser=" + updateUser + ", createTime=" + createTime
				+ ", createUser=" + createUser + "]";
	}

	

	
	
	
	
}
