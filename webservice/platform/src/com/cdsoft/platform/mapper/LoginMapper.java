package com.cdsoft.platform.mapper;  
  
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
  
/**
 * 
* @author cd_zhaomr
* @date 2015-11-20 下午4:48:07 
*
 */
@Repository(value = "loginMapper")  
public interface LoginMapper {  

	/**
	 * 登录时检查用户是否合法
	* @param @param param
	* @param @return
	* @param @throws Exception
	* @return List<Map<String,Object>>
	* @throws 
	* @author cd_zhaomr
	* @date 2015-11-20 下午4:48:55
	 */
	public Map<String,Object> checkUserExits(Map<String, Object> param)throws Exception;

	/**
	 * 获取最新的版本号
	* @param @return
	* @return List<Map<String,Object>>
	* @throws 
	* @author cd_zhaomr
	* @date 2015-11-20 下午4:59:16
	 */
	public List<Map<String, Object>> getVersionInfo()throws Exception;
	
	/**
	 * 获取角色
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectRoleByCode(Map<String, Object> param)throws Exception;
	/**
	 * Android通过角色查询所有用户
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>>selectAllUser()throws Exception;
}  