package com.cdsoft.platform.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cdsoft.platform.entity.JsonTreeData;
import com.cdsoft.platform.entity.Org;
import com.cdsoft.platform.mapper.OrgMapper;
import com.cdsoft.platform.service.OrgService;
import com.cdsoft.platform.util.DataGrid;
import com.cdsoft.platform.util.TreeNodeUtil;
@Service
public class OrgServiceImpl implements OrgService {

	@Resource
	private OrgMapper orgMapper;
	
	@Override
	public DataGrid queryOrgUserPage(Map<String, Object> param)
			throws Exception {
		Long count = orgMapper.queryOrgUserPageCount(param);
		List<Map<String, Object>> list = orgMapper.queryOrgUserPage(param);
		DataGrid data = new DataGrid();
		data.setTotal(count);
		data.setRows(list);
		return data;
	}
	
	@Override
	public List<JsonTreeData> selOrgTree() {
		List<Org> orgList = orgMapper.selOrgTree();
		List<JsonTreeData> treeDataList = new ArrayList<JsonTreeData>(); 
		for(Org org : orgList){
			JsonTreeData treeData = new JsonTreeData();
			treeData.setId(org.getOrgCode());
			treeData.setPid(org.getParentId());
			treeData.setState("open");
			treeData.setText(org.getOrgName());
			treeDataList.add(treeData);	
		}
		List<JsonTreeData> newTreeDataList = TreeNodeUtil.getfatherNode(treeDataList);
		return newTreeDataList;
	}

	@Override
	public Org selNewOrgTree(Map<String, Object> param) {
		int count = orgMapper.insertOrgTreeChild(param);
		Org orgCode = null;
		if(count == 1){
			orgCode = orgMapper.selNewOrgTree(param);
		}else{
			orgCode = null ;
		}
		return orgCode;
	}

	@Override
	public int updateOrgName(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return orgMapper.updateOrgName(param);
	}

	@Override
	public int delOrgTree(String orgCode) {
		int count = orgMapper.selectOrgTreeChild(orgCode);
		if(count > 0){
			count = 0;
		}else{
			count = orgMapper.delOrgTree(orgCode);
		}
		return count;
	}

	@Override
	public List<Org> selectOrg() {
		return orgMapper.selectOrg();
	}

	@Override
	public Org currentOrg(String currentUser) {
		return orgMapper.currentOrg(currentUser);
	}

	@Override
	public void updateUserOrg(Map<String, Object> param) {
		orgMapper.updateUserOrg(param);
		
	}

	@Override
	public List<Map<String, Object>> selOrgComboBox() throws Exception {
		// TODO Auto-generated method stub
		return orgMapper.selOrgComboBox();
	}

}
