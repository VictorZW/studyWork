package com.cdsoft.platform.service;

import java.util.List;
import java.util.Map;

import com.cdsoft.platform.entity.JsonTreeData;
import com.cdsoft.platform.util.DataGrid;

public interface RoleService {
	
	public DataGrid queryPage(Map<String, Object> param) throws Exception;
	
	int delete(String ids);
	
	int insert(Map<String, Object> param);
	
	int update(Map<String, Object> param);
	
	int checkName(String roleName);
	
	DataGrid queryRoleUserPage(Map<String, Object> param);
	
	int insertRoleUsers(Map<String,Object> param);
	
	List<Map<String, Object>> queryRoleUserNOTIN(Map<String,Object> param);
	
	int deleteRoleUsers(Map<String,Object> param);
	
	List<JsonTreeData> selectMenuTree();
	
	//菜单树查询
	List<Map<String, Object>> selectRoleMenu(String roleid);
	
	int deleteRoleMenu(String roleid);
	
	int addRoleMenu(Map<String,Object> param);
	
	int judge(Map<String,Object> param);
	
	int judgeRM(Map<String,Object> param);
	
	String selectRoleCode(String roleId);
}
