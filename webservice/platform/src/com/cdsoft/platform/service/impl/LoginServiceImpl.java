/** 
 * 
 * @author chengxt
 * @date 2012-5-5 上午10:29:22 
 */
package com.cdsoft.platform.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdsoft.platform.mapper.LoginMapper;
import com.cdsoft.platform.service.LoginService;


/**
 * 
* @author cd_zhaomr
* @date 2015-11-20 下午4:48:16 
*
 */
@Service(value = "loginService")
@Transactional(rollbackFor={Exception.class,Error.class})
public class LoginServiceImpl implements LoginService {

	@Resource(name = "loginMapper")
	private LoginMapper loginMapper;

	

	@Override
	public Map<String,Object> checkUserExits(Map<String, Object> param)throws Exception {
		return loginMapper.checkUserExits(param);
	}

	@Override
	public List<Map<String, Object>> getVersionInfo() throws Exception{
		return loginMapper.getVersionInfo();
	}

	@Override
	public List<Map<String, Object>> selectAllUser() throws Exception {
		// TODO Auto-generated method stub
		return loginMapper.selectAllUser();
	}

	

}