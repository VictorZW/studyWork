package com.cdsoft.platform.entity;

import java.io.Serializable;
import java.util.Date;


public class Role implements Serializable{
	
	private static final long serialVersionUID = 4382590787152682754L;

	private String id;
    private String roleCode;
    private String roleName;
    private String describe;
    private String delFlag;
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

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
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
     * @param bean 接收对象的子
     * @return 拷贝完成后的子类
     */ 
    public  <T extends Role> T copy(T bean) {
        bean.setId(getId());
        bean.setRoleCode(getRoleCode());
        bean.setRoleName(getRoleName());
        bean.setDescribe(getDescribe());
        bean.setDelFlag(getDelFlag());
        return bean;
    }

    /** 
     * 格式化
     */ 
    @Override
    public String toString() {
        return "{" + 
        	", id:" + getId() + 
        	", roleCode:" + getRoleCode() + 
        	", roleName:" + getRoleName() + 
        	", describe:" + getDescribe() + 
        	", delFlag:" + getDelFlag() + 
        "}";
    }
}