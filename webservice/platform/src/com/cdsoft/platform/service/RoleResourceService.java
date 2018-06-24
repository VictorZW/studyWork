package com.cdsoft.platform.service;

import java.util.List;
import java.util.Map;

import com.cdsoft.platform.entity.RoleResource;

public interface RoleResourceService {

	int  insert(RoleResource roleResource);
	
	int delete(String roleCode);
	
	List<Map<String,Object>> selectResCode(String roleCode);
}
