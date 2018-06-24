package com.cdsoft.platform.entity;
import java.util.ArrayList;
import java.util.List;

public class JsonTreeData {
 
    public String id;       //json id
    public String pid;      //
    public String text;     //json 显示文本
    public String state;    //json 'open','closed'
    public List<JsonTreeData> children = new ArrayList<JsonTreeData>();       //
    public String url;
    public String type;
    public String orderId;
    
    public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<JsonTreeData> getChildren() {
		return children;
	}

	public void setChildren(List<JsonTreeData> children) {
		this.children = children;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/** 
     * 格式化显示
     */ 
    @Override
    public String toString() {
        return "{" + 
        	" id:" + getId() + 
        	", pid:" + getPid() + 
        	", text:" + getText() + 
        	", state:" + getState() + 
        	", children:" + getChildren() + 
        "}";
    }
}