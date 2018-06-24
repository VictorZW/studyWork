package com.cdsoft.platform.service;

import java.util.Map;

import com.cdsoft.platform.entity.Log;
import com.cdsoft.platform.util.DataGrid;

public interface LogService {
	public DataGrid queryPage(Map<String, Object> param);

	public void insertLog(Log log);
}
