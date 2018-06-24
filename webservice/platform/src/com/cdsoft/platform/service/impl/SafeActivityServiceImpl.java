package com.cdsoft.platform.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdsoft.platform.mapper.SafeActivityMapper;
import com.cdsoft.platform.service.SafeActivityService;
import com.cdsoft.platform.util.DataGrid;
import com.cdsoft.platform.util.PropsUtil;
import com.cdsoft.platform.util.StringUtil;

@Service(value="safeActivityService")
@Transactional(rollbackFor={Exception.class,Error.class})
public class SafeActivityServiceImpl implements SafeActivityService {

	@Resource(name="safeActivityMapper")
	private SafeActivityMapper safeActivityMapper;
	@Override
	public List<Map<String, Object>> getDictForPno(String PNO) {
		return safeActivityMapper.getDictForPno(PNO);
	}
	@Override
	public DataGrid queryPagesFileList(Map<String, Object> param) {
		
		
		List<Map<String, Object>> fileList = safeActivityMapper.queryPagesFileList(param);
		String httpUrl = String.valueOf(PropsUtil.getProperty("safe_file_path"));
		//System.out.println(httpUrl);
		if(StringUtil.isNotEmptyList(fileList)){
			for(Map<String, Object> result:fileList){
				result.put("F_URL", httpUrl+result.get("F_URL"));
			}
		}
		
		DataGrid data = new DataGrid();
		data.setRows(fileList);
		data.setTotal(safeActivityMapper.queryPagesFileCount(param));
		
		return data;
	}
	@Override
	public Map<String, Object> getFileDetail(String fileID) {
		return safeActivityMapper.getFileDetail(fileID);
	}

}
