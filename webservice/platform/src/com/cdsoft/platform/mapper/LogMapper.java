package com.cdsoft.platform.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cdsoft.platform.entity.Log;

@Repository(value = "logMapper")  
public interface LogMapper {
	
	public List<Map<String, Object>> queryPage(Map<String, Object> param);
	
	public Long queryPageCount(Map<String, Object> param);

	public void insertLog(Log log);
}
