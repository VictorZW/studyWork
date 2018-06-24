package com.cdsoft.platform.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cdsoft.platform.entity.JsonTreeData;
import com.cdsoft.platform.entity.Menu;
import com.cdsoft.platform.mapper.MenusMapper;
import com.cdsoft.platform.service.MenusService;
import com.cdsoft.platform.util.TreeNodeUtil;

@Service
public class MenusServiceImpl implements MenusService {

	@Resource
	private MenusMapper menusMapper;
	
	@Override
	public List<JsonTreeData> selMenuTree() {
		List<Menu> menus = menusMapper.selMenuTree();
		List<JsonTreeData> treeDataList = new ArrayList<JsonTreeData>();
		for(Menu menu : menus){
			JsonTreeData treeData = new JsonTreeData();
			treeData.setId(menu.getMenuCode());
			treeData.setPid(menu.getParentId());
			treeData.setState("open");
			treeData.setText(menu.getName());
			treeData.setUrl(menu.getUrl());
			treeData.setOrderId(menu.getOrderId());
			treeDataList.add(treeData);
		}
		List<JsonTreeData> newTreeDataList = TreeNodeUtil.getfatherNode(treeDataList);
		return newTreeDataList;
	}

	@Override
	public int updateMenuTreeChild(Map<String, Object> param) {
		
		return menusMapper.updateMenuTreeChild(param);
	}

	@Override
	public Menu insertParent(Map<String, Object> param) {
		int count = menusMapper.insertParent(param);
		Menu menu = null; 
		if(count == 1){
			menu = menusMapper.selNewParent(param);
		}else{
			menu = null;
		}
		return menu;
	}

	@Override
	public Menu insertChild(Map<String, Object> param) {
		
		int count = menusMapper.insertChild(param);
		Menu menu = null; 
		if(count >=0){
			menu = menusMapper.selNewParent(param);
		}
		return menu;
	}

	@Override
	public int deleteMenuParent(Map<String, Object> param) {
		int count = menusMapper.selectMenuChild(param);
		if(count > 0){
			count = 0;
		}else{
			count = menusMapper.deleteMenuParent(param);
		}
		return count;
	}

	@Override
	public List<Menu> selMenu() {
		List<Menu> list=menusMapper.selMenu();
		return list;
	}
}
