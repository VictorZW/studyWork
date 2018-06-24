package com.cdsoft.platform.service;

import java.util.Map;

import com.cdsoft.platform.entity.FileBean;
import com.cdsoft.platform.util.DataGrid;


public interface FileUploadService {
	
	public DataGrid queryPage(Map<String, Object> param);
	
	int insertFile(Map<String,Object> param);
	
	FileBean download(Map<String,Object> param);
}
