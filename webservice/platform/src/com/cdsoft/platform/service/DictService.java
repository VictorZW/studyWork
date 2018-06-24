package com.cdsoft.platform.service;

import java.util.List;
import java.util.Map;

import com.cdsoft.platform.entity.Dict;
import com.cdsoft.platform.entity.JsonTreeData;
import com.cdsoft.platform.util.DataGrid;


public interface DictService {
	
	DataGrid queryPage(Map<String, Object> param);
	
	List<Map<String,Object>>queryDictType();
	
	Dict insertDictType(Map<String, Object> param);
	
	int addDict(Map<String, Object> param);
	
	int updateDictByNo(Map<String, Object> param);
	
	int updateDict(Map<String, Object> param);
	
	int deleteRow(Map<String, Object> param);
	
	int deleteDictType(Map<String, Object> param);
	
	int check1(String dictType);
	
	int check2(String no,String dictName,String parentNo);

	List<Map<String, Object>> list(Map<String, Object> param);
	
	String queryNoByValue(String type,String value);
	
	List<Map<String, Object>> queryByType(String type);
	List<JsonTreeData> selDictTree();

	List<Dict> queryType();
}
