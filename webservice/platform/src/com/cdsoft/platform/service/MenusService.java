package com.cdsoft.platform.service;

import java.util.List;
import java.util.Map;

import com.cdsoft.platform.entity.JsonTreeData;
import com.cdsoft.platform.entity.Menu;

public interface MenusService {
	
	List<JsonTreeData> selMenuTree();   
	
	int updateMenuTreeChild(Map<String,Object> param);
	
	Menu insertParent(Map<String,Object> param);
	
	Menu insertChild(Map<String,Object> param);
	
	int deleteMenuParent(Map<String,Object> param);

	List<Menu> selMenu();
	
	
}
