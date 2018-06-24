package com.cdsoft.platform.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository(value="safeActivityMapper")
public interface SafeActivityMapper {

	public List<Map<String, Object>> getDictForPno(String PNO);

	public List<Map<String,Object>> queryPagesFileList(Map<String, Object> param);
	
	public long queryPagesFileCount(Map<String, Object> param);

	public Map<String, Object> getFileDetail(String fileID);
}
