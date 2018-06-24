package com.cdsoft.platform.service;

import java.util.List;
import java.util.Map;

import com.cdsoft.platform.entity.Resource;
import com.cdsoft.platform.util.DataGrid;

public interface ResourceService {

	public List<Map<String, Object>> frontList();
	
	//添加资源
	int insert(Map<String, Object> param);
	
	//删除资源
	public int delete(String ids);
	//修改资源
	public int update(Resource resource);

	//添加资源
	int insert(Resource resource);

	//查询资源
	public List<Resource> select();

	//查询资源名是否重复
	public int checkName(String name);

	//带条件分页查询
	public DataGrid queryPage(Map<String, Object> param) throws Exception;

	public int checkMenu(String menuCode);
}
