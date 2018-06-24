package com.cdsoft.platform.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdsoft.platform.entity.Log;
import com.cdsoft.platform.service.LogService;
import com.cdsoft.platform.util.DataGrid;

@Controller
@RequestMapping(value="web/logController")
public class LogController {
	
	@Resource
	private LogService logService;
	
	@RequestMapping(value="sellogs")
	@ResponseBody
	@RequiresPermissions("LogController:sellogs")
	public DataGrid sellogs(HttpServletRequest request) throws Exception {
		String pages = request.getParameter("page")==null ? "1":request.getParameter("page");
		String rows = request.getParameter("rows")==null ? "10":request.getParameter("rows");
		String userName = request.getParameter("userName");
		String time = request.getParameter("time");
		Map<String,Object> param = new HashMap<String,Object>();
		int page = Integer.parseInt(pages);
		int pageSize = Integer.parseInt(rows);
		param.put("pageStart", (page-1)*pageSize+1);
		param.put("pageEnd", (page-1)*pageSize+pageSize);
		param.put("userName", userName);
		param.put("logTime", time);
		DataGrid data = logService.queryPage(param);
		return data;
	} 
	
	/**
	 *日志插入接口
	 */
	public void insertLogin(Log log){
		logService.insertLog(log);
	}
}
