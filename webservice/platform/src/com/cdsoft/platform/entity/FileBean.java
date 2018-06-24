package com.cdsoft.platform.entity;

import java.util.Date;

public class FileBean {
	private String id;
	
	private String fileCode;
	
	private String fileName;
	
	private String fileDesc;
	
	private String fileSize;
	
	private String fileType;
	
	private String status;
	
	private String isDel;
	
	private String fileUrl;
	
	private String category;
	
	private Date createTime;
	
	private Date updateTime;
	
	private String createUser;
	
	private String updateUser;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileCode() {
		return fileCode;
	}

	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDesc() {
		return fileDesc;
	}

	public void setFileDesc(String fileDesc) {
		this.fileDesc = fileDesc;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Override
	public String toString() {
		return "File [id=" + id + ", fileCode=" + fileCode + ", fileName=" + fileName + ", fileDesc=" + fileDesc
				+ ", fileSize=" + fileSize + ", fileType=" + fileType + ", status=" + status + ", isDel=" + isDel
				+ ", fileUrl=" + fileUrl + ", category=" + category + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", createUser=" + createUser + ", updateUser=" + updateUser + "]";
	}

}
