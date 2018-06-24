package com.cdsoft.platform.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cdsoft.platform.entity.Dict;
import com.cdsoft.platform.entity.JsonTreeData;
import com.cdsoft.platform.mapper.DictMapper;
import com.cdsoft.platform.service.DictService;
import com.cdsoft.platform.util.DataGrid;
import com.cdsoft.platform.util.TreeNodeUtil;
@Service
public class DictServiceImpl implements DictService{

	@Resource
	private DictMapper dictMapper;
	
	@Override
	public DataGrid queryPage(Map<String, Object> param) {
		Long count = dictMapper.queryPageCount(param);
		List<Map<String, Object>> list = dictMapper.queryPage(param);
		DataGrid data = new DataGrid();
		data.setTotal(count);
		data.setRows(list);
		return data;
	}

	@Override
	public List<Map<String, Object>> queryDictType() {
		
		return dictMapper.queryDictType();
	}

	@Override
	public Dict insertDictType(Map<String, Object> param) {
		int count = dictMapper.addDict(param);
		Dict dict = null; 
		if(count == 1){
			dict = dictMapper.selNewType(param);
		}else{
			dict = null;
		}
		return dict;
	}

	@Override
	public int addDict(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return dictMapper.addDict(param);
	}
	
	@Override
	public int deleteRow(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return dictMapper.deleteRow(param);
	}

	@Override
	public int check1(String dictType) {
		int count = dictMapper.check1(dictType);
		return count;
	}

	@Override
	public int check2(String no, String dictName,String parentNo) {
		int count = dictMapper.check2(no,dictName,parentNo);
		return count;
	}

	@Override
	public List<Map<String, Object>> list(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return dictMapper.list(param);
	}

	@Override
	public String queryNoByValue(String type, String value) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("type", type);
		map.put("value",value);
		return dictMapper.queryNoByValue(map);
	}

	public List<Map<String, Object>> queryByType(String type)
	{
		return dictMapper.queryByType(type);
	}

	@Override
	public List<JsonTreeData> selDictTree() {
		List<Dict> dicts = dictMapper.selDictTree();
		
		List<JsonTreeData> treeDataList = new ArrayList<JsonTreeData>();
		for(Dict dict : dicts){
			JsonTreeData treeData = new JsonTreeData();
			treeData.setId(dict.getNo());
			treeData.setPid(dict.getParentNo());
			treeData.setState("open");
			treeData.setText(dict.getValue());
			treeData.setType(dict.getType());
			treeDataList.add(treeData);
		}
		List<JsonTreeData> newTreeDataList = TreeNodeUtil.getfatherNode(treeDataList);
		return newTreeDataList;
	}

	@Override
	public int updateDictByNo(Map<String, Object> param) {
		return dictMapper.updateDictByNo(param);
	}

	@Override
	public int deleteDictType(Map<String, Object> param) {
		return dictMapper.deleteDictType(param);
	}

	@Override
	public int updateDict(Map<String, Object> param) {
		return dictMapper.updateDict(param);
	}

	@Override
	public List<Dict> queryType() {
		
		return dictMapper.queryType();
	}
	
}
