package com.cdsoft.platform.entity;


import java.io.Serializable;
import java.util.Date;

public class RoleResource implements Serializable {
	
	private static final long serialVersionUID = -2083880577015980729L;

	private String id;
    private String status;
    private String roleCode;
    private String resCode;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
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
     * 拷贝，将对象中的字段全部拷贝到子对象�?
     * @param bean 接收对象的子�?
     * @return 拷贝完成后的子类
     */ 
    public  <T extends RoleResource> T copy(T bean) {
        bean.setId(getId());
        bean.setStatus(getStatus());
        bean.setCreateUser(getCreateUser());
        bean.setCreateTime(getCreateTime());
        bean.setUpdateUser(getUpdateUser());
        bean.setUpdateTime(getUpdateTime());
        bean.setRoleCode(getRoleCode());
        bean.setResCode(getResCode());
        return bean;
    }

    /** 
     * 格式化显�?
     */ 
    @Override
    public String toString() {
        return "{" + 
        	", id:" + getId() + 
        	", status:" + getStatus() + 
        	", createUser:" + getCreateUser() + 
        	", createTime:" + getCreateTime() + 
        	", updateUser:" + getUpdateUser() + 
        	", updateTime:" + getUpdateTime() + 
        	", roleCode:" + getRoleCode() + 
        	", resCode:" + getResCode() + 
        "}";
    }
}