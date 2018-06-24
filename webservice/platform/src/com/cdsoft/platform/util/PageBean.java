package com.cdsoft.platform.util;

import java.util.List;
import java.util.Map;

public class PageBean {
	private int pc;//当前页码
	private int tr;//总记录数
	private int ps;//每页记录数
	private List<Map<String,Object>> beanList;
	
	//计算总页数
	public int getTp(){
		int tp = tr / ps;
		return tr % ps == 0 ? tp : tp + 1;
	}
	
	public int getPc() {
		return pc;
	}
	public void setPc(int pc) {
		this.pc = pc;
	}
	public int getTr() {
		return tr;
	}
	public void setTr(int tr) {
		this.tr = tr;
	}
	public int getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	public List<Map<String, Object>> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<Map<String, Object>> beanList) {
		this.beanList = beanList;
	}
	
	
}
