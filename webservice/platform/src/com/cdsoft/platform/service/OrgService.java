package com.cdsoft.platform.service;

import java.util.List;
import java.util.Map;

import com.cdsoft.platform.entity.JsonTreeData;
import com.cdsoft.platform.entity.Org;
import com.cdsoft.platform.util.DataGrid;

public interface OrgService {
	
	List<Map<String,Object>> selOrgComboBox() throws Exception;
	
	DataGrid queryOrgUserPage(Map<String, Object> param) throws Exception;
	
	List<JsonTreeData> selOrgTree();
	
	Org selNewOrgTree(Map<String,Object> param);
	
	int updateOrgName(Map<String,Object> param);
	
	int delOrgTree(String orgCode);
	
	List<Org> selectOrg();
	
	Org currentOrg(String currentUser);

	void updateUserOrg(Map<String, Object> param);
	
}
