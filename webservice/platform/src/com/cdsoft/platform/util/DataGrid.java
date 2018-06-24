package com.cdsoft.platform.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * EasyUI DataGrid模型
 * @author yujb
 * @see
 * @since 
 * @date 2016年4月19日下午10:38:50
 */
public class DataGrid implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long total = 0L;
	@SuppressWarnings("rawtypes")
	private List rows = new ArrayList();

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	@SuppressWarnings("rawtypes")
	public List getRows() {
		return rows;
	}

	@SuppressWarnings("rawtypes")
	public void setRows(List rows) {
		this.rows = rows;
	}

}

