package com.cdsoft.platform.service;

import java.util.List;
import java.util.Map;

import com.cdsoft.platform.util.DataGrid;

/**
 * 安全专项活动Service
 *
 * @author yujb
 * @see
 * @since 
 * @date 2016年5月4日上午11:45:21
 */
public interface SafeActivityService {
	
	/**
	 * 根据PNO查询字典信息数据
	 * @param PNO 文件类型/文件状态
	 * @return
	 */
	public List<Map<String, Object>> getDictForPno(String PNO);
	
	public DataGrid queryPagesFileList(Map<String, Object> param);

	public Map<String, Object> getFileDetail(String fileID);
}
