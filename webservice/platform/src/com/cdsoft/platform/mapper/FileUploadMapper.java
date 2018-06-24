package com.cdsoft.platform.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.cdsoft.platform.entity.FileBean;

@Repository
public interface FileUploadMapper {
	
	List<Map<String,Object>> queryPage(Map<String,Object> param);
	
	Long queryPageCount(Map<String,Object> param);
	
	int insertFile(Map<String,Object> param);
	
	FileBean download(Map<String,Object> param);
}
