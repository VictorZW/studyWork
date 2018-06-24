package com.cdsoft.platform.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.cdsoft.platform.entity.Resource;
import com.cdsoft.platform.entity.Role;
import com.cdsoft.platform.entity.User;

@Repository
public interface UserMapper {

	User selectUserByUserCode(String userCode);
	
	List<Role> selectRolesByUserCode(String userCode);
	
	List<Resource> selectResourceByUserCode(String userCode);
	
	/**
	 * 查询所有用户信息
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>>queryOrg();
	
	public List<Map<String, Object>> queryPage(Map<String, Object> param);
	
	public Long queryPageCount(Map<String, Object> param);
	
	int delete(List<String> ids);
	
	User check(String userCode);
	
	int checks(String userCode);
	
	int insert(Map<String,Object> param);
	
	int update(Map<String,Object> param);
	
	int resetPassWord(Map<String,Object> param);
	
	List<Map<String,Object>> queryStation(String orgCode);
	
	List<Map<String,Object>> queryStations();
	
	User selectUserInfo(@Param("userName")String userName,@Param("password")String password);

	int selectUserIsAdminOrCompany(String userCode);
	
	int insertRelation(Map<String,Object> param);
	
	String getOrgCode(Map<String,Object> param);
	
	int updateRelation(Map<String,Object> param);
	
	String selectUserNameByUserCode(String useCode);

	List<User> list();
}
