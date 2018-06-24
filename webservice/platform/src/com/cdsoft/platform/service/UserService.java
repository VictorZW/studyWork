package com.cdsoft.platform.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.cdsoft.platform.entity.Resource;
import com.cdsoft.platform.entity.Role;
import com.cdsoft.platform.entity.User;
import com.cdsoft.platform.util.DataGrid;

public interface UserService {

	User selectUserByUserCode(String userCode);
	
	List<Role> selectRolesByUserCode(String userCode);
	
	List<Resource> selectResourceByUserCode(String userCode);
	
	int delete(String ids);
	
	DataGrid queryUserInfo(Map<String, Object> param);
	
	User check(String userCode);
	
	int checks(String userCode);
	
	int insert(Map<String,Object> param);
	
	int update(Map<String,Object> param);
	
	int resetPassWord(Map<String,Object> param);
	
	List<Map<String,Object>> queryStation(String orgCode);
	
	List<Map<String,Object>> queryStations();
	
	User selectUserInfo(String userName,String password);
	
	int selectUserIsAdminOrCompany(String userCode);
	
	String selectUserNameByUserCode(String useCode);

	Map<String, Object> importExel(File source, String isRepeat) throws Exception;

	List<User> list();
	
}
