package com.cdsoft.platform.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cdsoft.platform.entity.Menu;

@Repository
public interface RoleMapper {
	
	public List<Map<String, Object>> queryPage(Map<String, Object> param);
	
	public Long queryPageCount(Map<String, Object> param);
	
	int delete(List<String> ids);
	
	int deleteRoleUser(List<String> ids);
	
	//添加角色
	int insert(Map<String, Object> param);
	
	int update(Map<String, Object> param);
	
	int checkName(String roleName);
	
	List<Map<String, Object>> queryRoleUserPage(Map<String, Object> param);
	
	Long queryRoleUserCount(Map<String, Object> param);
	
	int insertRoleUsers(Map<String,Object> param);
	
	List<Map<String, Object>> queryRoleUserNOTIN(Map<String,Object> param);
	
	int deleteRoleUsers(Map<String,Object> param);
	
	List<Menu> selectMenuTree();
	
	List<Map<String, Object>> selectRoleMenu(String roleid);
	
	int deleteRoleMenu(String roleid);
	
	int addRoleMenu(Map<String,Object> param);
	
	int judge(Map<String,Object> param);
	
	int judgeRM(Map<String,Object> param);
	
	String selectRoleCode(String roleId);
}
