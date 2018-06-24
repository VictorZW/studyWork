package com.cdsoft.platform.service;

import java.util.List;
import java.util.Map;

/**
 * 
* @author cd_zhaomr
* @date 2015-11-20 下午4:48:19 
*
 */
public interface LoginService {

	/**
	 * 登录时检查用户是否合法
	* @param @param param
	* @param @return
	* @param @throws Exception
	* @return List<Map<String,Object>>
	* @throws 
	* @author cd_zhaomr
	* @date 2015-11-20 下午4:48:34
	 */
	public Map<String,Object> checkUserExits(Map<String, Object> param) throws Exception;

	/**
	 * 获取最新的版本号
	* @param @return
	* @param @throws Exception
	* @return List<Map<String,Object>>
	* @throws 
	* @author cd_zhaomr
	* @date 2015-11-20 下午4:58:44
	 */
	public List<Map<String, Object>> getVersionInfo()throws Exception;
	/**
	 * Android通过角色查询所有用户
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>>selectAllUser()throws Exception;
}