package com.cdsoft.platform.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdsoft.platform.entity.Menu;
import com.cdsoft.platform.entity.Resource;
import com.cdsoft.platform.mapper.MenusMapper;
import com.cdsoft.platform.mapper.ResourceMapper;
import com.cdsoft.platform.service.ResourceService;
import com.cdsoft.platform.util.DataGrid;

@Service(value = "resourceService")
@Transactional(rollbackFor = { Exception.class, Error.class })
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private ResourceMapper resourceMapper;

	@Autowired
	private MenusMapper menusMapper;

	public List<Map<String, Object>> frontList() {

		Subject subject = SecurityUtils.getSubject();
		List<Map<String, Object>> resources = resourceMapper
				.findFrontList((String) subject.getPrincipal());

		List<Map<String, Object>> resources2 = new ArrayList<Map<String, Object>>();
		Set<String> set = new HashSet<String>();
		for (Map<String, Object> map : resources) {
			while (!set.contains(String.valueOf(map.get("MENU_CODE")))) {
				set.add(String.valueOf(map.get("MENU_CODE")));
				List<Map<String, Object>> children = new ArrayList<Map<String, Object>>();
				for (Map<String, Object> map2 : resources) {
					if (!String.valueOf(map2.get("PARENT_ID")).equals("null")
							&& String.valueOf(map2.get("PARENT_ID")).equals(
									String.valueOf(map.get("MENU_CODE")))) {
						children.add(map2);
					}
				}
				map.put("children", children);
			}
			if ("0".equals(map.get("PARENT_ID"))) {
				resources2.add(map);
			}
		}
		return resources2;
	}

	@Override
	public int insert(com.cdsoft.platform.entity.Resource resource) {

		int i = resourceMapper.insert(resource);
		return i;
	}

	@Override
	public int delete(String ids) {
		List<String> list = new ArrayList<String>();
		if (ids != null) {
			String[] idstr = ids.split(",");
			for (int i = 0; i < idstr.length; i++) {
				list.add(i, idstr[i]);
			}
		}
		int i = resourceMapper.delete(list);
		return i;
	}

	@Override
	public int update(com.cdsoft.platform.entity.Resource resource) {
		int ui = resourceMapper.updateByPrimaryKeySelective(resource);
		return ui;
	}

	@Override
	public List<com.cdsoft.platform.entity.Resource> select() {
		List<com.cdsoft.platform.entity.Resource> resources = resourceMapper
				.selectResource();
		return resources;
	}

	@Override
	public int insert(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 查询重复
	@Override
	public int checkName(String name) {
		int i = resourceMapper.checkName(name);
		return i;
	}

	// 带条件的分页查询
	public DataGrid queryPage(Map<String, Object> param) throws Exception {
		Long count = resourceMapper.queryPageCount(param);
		//List<Map<String, Object>> list = resourceMapper.queryPage(param);
		List<Resource> list = resourceMapper.queryPage(param);
		List<Menu> menu = menusMapper.selectMenu();
		for (Resource resource : list) {
			for (Menu menu2 : menu) {
				if(resource.getMenuCode().equals(menu2.getMenuCode())){
					resource.setMenuCode(menu2.getName());
				}
			}
		}
		DataGrid data = new DataGrid();
		data.setTotal(count);
		data.setRows(list);
		return data;
	}

	@Override
	public int checkMenu(String menuCode) {

		return 0;
	}

}
