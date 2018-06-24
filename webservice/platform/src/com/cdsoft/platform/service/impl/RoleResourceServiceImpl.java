package com.cdsoft.platform.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cdsoft.platform.entity.RoleResource;
import com.cdsoft.platform.mapper.RoleResourceMapper;
import com.cdsoft.platform.service.RoleResourceService;
@Service
public class RoleResourceServiceImpl implements RoleResourceService{

	@Resource
	private RoleResourceMapper roleResourceMapper;
	
	@Override
	public int insert(RoleResource roleResource) {
		return roleResourceMapper.insert(roleResource);
	}

	@Override
	public int delete(String roleCode) {
		return roleResourceMapper.delete(roleCode);
	}

	@Override
	public List<Map<String,Object>> selectResCode(String roleCode) {
		return roleResourceMapper.selectResCode(roleCode);
	}

}
