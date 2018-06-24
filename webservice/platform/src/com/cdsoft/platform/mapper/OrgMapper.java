package com.cdsoft.platform.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cdsoft.platform.entity.Org;

@Repository
public interface OrgMapper {
	
    List<Map<String, Object>> queryPage(Map<String, Object> param);
    
    List<Map<String, Object>> queryOrgUserPage(Map<String, Object> param);
	
	Long queryPageCount(Map<String, Object> param);
	
	Long queryOrgUserPageCount(Map<String, Object> param);
	
	List<Org> selOrgTree();
	
	int insertOrgTreeChild(Map<String,Object> param);
	
	Org selNewOrgTree(Map<String,Object> param);
	
	int updateOrgName(Map<String,Object> param);
	
	int delOrgTree(String orgCode);
	
	int delOrgTrees(String orgCode);
	
	int selectOrgTreeChild(String orgCode);
	
	List<Org> selectOrg();
	
	Org currentOrg(String currentUser);

	void updateUserOrg(Map<String, Object> param);
	List<Map<String,Object>> selOrgComboBox();
}
