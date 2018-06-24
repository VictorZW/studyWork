package com.cdsoft.platform.service;

import java.util.Map;

import com.cdsoft.platform.entity.Message;
import com.cdsoft.platform.util.DataGrid;

public interface MessageService {
	
	public DataGrid queryPage(Map<String, Object> param);
	
	int addMessage(Map<String, Object> param);

	public int insert(Message message);

	public int update(Message message);

	public int delete(String ids);
}
