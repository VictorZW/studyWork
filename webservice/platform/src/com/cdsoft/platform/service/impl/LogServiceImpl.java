package com.cdsoft.platform.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdsoft.platform.entity.Log;
import com.cdsoft.platform.mapper.LogMapper;
import com.cdsoft.platform.service.LogService;
import com.cdsoft.platform.util.DataGrid;

@Service(value = "logService")
@Transactional(rollbackFor={Exception.class,Error.class})
public class LogServiceImpl implements LogService {
		
	@Resource
	private LogMapper logMapper;
		
	@Override
	public DataGrid queryPage(Map<String, Object> param) {
		Long count = logMapper.queryPageCount(param);
		List<Map<String, Object>> list = logMapper.queryPage(param);
		DataGrid data = new DataGrid();
		data.setTotal(count);
		data.setRows(list);
		return data;
	}

	@Override
	public void insertLog(Log log) {
		try{
		logMapper.insertLog(log);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
