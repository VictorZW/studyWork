package com.cdsoft.platform.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cdsoft.platform.entity.FileBean;
import com.cdsoft.platform.mapper.FileUploadMapper;
import com.cdsoft.platform.service.FileUploadService;
import com.cdsoft.platform.util.DataGrid;

@Service
public class FileUploadServiceImpl implements FileUploadService {

	@Resource
	private FileUploadMapper fileUploadMapper;
	
	@Override
	public DataGrid queryPage(Map<String, Object> param) {
		Long count = fileUploadMapper.queryPageCount(param);
		List<Map<String, Object>> list = fileUploadMapper.queryPage(param);
		DataGrid data = new DataGrid();
		data.setTotal(count);
		data.setRows(list);
		return data;
	}

	@Override
	public int insertFile(Map<String, Object> param) {
		
		return fileUploadMapper.insertFile(param);
	}

	@Override
	public FileBean download(Map<String,Object> param) {
		
		return fileUploadMapper.download(param);
	}

}
