package com.cdsoft.platform.entity;

import java.io.Serializable;
import java.util.Date;

public class Resource implements Serializable {
	
	private static final long serialVersionUID = -2064347114607795397L;

	private String id;
    private String name;
    private String url;
    private String menuCode;
    private String type;
    private String permission;
    private String showInFront;
    private String picName;
    private String resCode;
    private String resType;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getShowInFront() {
		return showInFront;
	}

	public void setShowInFront(String showInFront) {
		this.showInFront = showInFront;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}

	public String getResType() {
		return resType;
	}

	public void setResType(String resType) {
		this.resType = resType;
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

	/** 
     * 拷贝，将对象中的字段全部拷贝到子对象
     * @param bean 接收对象
     * @return 拷贝完成后的子类
     */ 
    public  <T extends Resource> T copy(T bean) {
        bean.setId(getId());
        bean.setName(getName());
        bean.setUrl(getUrl());
        bean.setMenuCode(getMenuCode());
        bean.setType(getType());
        bean.setPermission(getPermission());
        bean.setShowInFront(getShowInFront());
        bean.setPicName(getPicName());
        bean.setResCode(getResCode());
        bean.setResType(getResType());
        return bean;
    }

    /** 
     * 格式化显�?
     */ 
    @Override
    public String toString() {
        return "{" + 
        	", id:" + getId() + 
        	", name:" + getName() + 
        	", url:" + getUrl() + 
        	", menuCode:" + getMenuCode() + 
        	", type:" + getType() + 
        	", permission:" + getPermission() + 
        	", showInFront:" + getShowInFront() + 
        	", picName:" + getPicName() + 
        	", resCode:" + getResCode() + 
        	", resType:" + getResType() + 
        "}";
    }
}