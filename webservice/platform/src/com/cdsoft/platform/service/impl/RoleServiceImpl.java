package com.cdsoft.platform.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cdsoft.platform.entity.JsonTreeData;
import com.cdsoft.platform.entity.Menu;
import com.cdsoft.platform.mapper.ResourceMapper;
import com.cdsoft.platform.mapper.RoleMapper;
import com.cdsoft.platform.service.RoleService;
import com.cdsoft.platform.util.DataGrid;
import com.cdsoft.platform.util.TreeNodeUtil;
@Service
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleMapper roleMapper;
	
	@Resource
	private ResourceMapper resourceMapper;
	@Override
	public DataGrid queryPage(Map<String, Object> param) throws Exception {
		Long count = roleMapper.queryPageCount(param);
		List<Map<String, Object>> list = roleMapper.queryPage(param);
		DataGrid data = new DataGrid();
		data.setTotal(count);
		data.setRows(list);
		return data;
	}
	@Override
	public int delete(String ids) {
		List<String> list =new ArrayList<String>();
		if(ids!=null){
			String [] idstr= ids.split(",");
			for (int i = 0; i < idstr.length; i++) {
				list.add(i, idstr[i]);
			}
		}
		int count = roleMapper.delete(list);
		return count;
	}
	
	@Override
	public int insert(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return roleMapper.insert(param);
	}
	@Override
	public int update(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return roleMapper.update(param);
	}
	@Override
	public int checkName(String roleName) {
		// TODO Auto-generated method stub
		return roleMapper.checkName(roleName);
	}
	@Override
	public DataGrid queryRoleUserPage(Map<String, Object> param) {
		Long count = roleMapper.queryRoleUserCount(param);
		List<Map<String, Object>> list = roleMapper.queryRoleUserPage(param);
		DataGrid data = new DataGrid();
		data.setTotal(count);
		data.setRows(list);
		return data;
	}
	@Override
	public int insertRoleUsers(Map<String,Object> param) {
		return roleMapper.insertRoleUsers(param);
	}
	@Override
	public List<Map<String, Object>> queryRoleUserNOTIN(Map<String,Object> param) {
		// TODO Auto-generated method stub
		return roleMapper.queryRoleUserNOTIN(param);
	}
	@Override
	public int deleteRoleUsers(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return roleMapper.deleteRoleUsers(param);
	}
	@Override
	public List<JsonTreeData> selectMenuTree() {
		List<Menu> list = roleMapper.selectMenuTree();
		List<JsonTreeData> treeDataList = new ArrayList<JsonTreeData>();
		List<com.cdsoft.platform.entity.Resource> listResource = resourceMapper.selectResource();
		for(Menu menu : list){
			JsonTreeData treeData = new JsonTreeData();
			treeData.setId(menu.getMenuCode());
			treeData.setPid(menu.getParentId());
			treeData.setState("open");
			treeData.setText(menu.getName());
			treeDataList.add(treeData);
		}
		for (com.cdsoft.platform.entity.Resource resource : listResource) {
			JsonTreeData treeData = new JsonTreeData();
			treeData.setId(resource.getResCode());
			treeData.setPid(resource.getMenuCode());
			treeData.setState("open");
			treeData.setText(resource.getName());
			treeDataList.add(treeData);
		}
		List<JsonTreeData> newTreeDataList = TreeNodeUtil.getfatherNode(treeDataList);
		return newTreeDataList;
	}
	@Override
	public List<Map<String, Object>> selectRoleMenu(String roleCode) {
		
		return roleMapper.selectRoleMenu(roleCode);
	}
	@Override
	public int deleteRoleMenu(String roleCode) {
		return roleMapper.deleteRoleMenu(roleCode);
	}
	@Override
	public int addRoleMenu(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return roleMapper.addRoleMenu(param);
	}
	@Override
	public int judge(Map<String,Object> param) {		
		return roleMapper.judge(param);
	}
	@Override
	public String selectRoleCode(String roleId) {
		return roleMapper.selectRoleCode(roleId);
	}
	@Override
	public int judgeRM(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return roleMapper.judgeRM(param);
	}

}
