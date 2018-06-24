package com.cdsoft.platform.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdsoft.platform.entity.Dict;
import com.cdsoft.platform.entity.JsonTreeData;
import com.cdsoft.platform.service.DictService;
import com.cdsoft.platform.util.DataGrid;
import com.cdsoft.platform.util.RandomUtil;

@Controller
@RequestMapping("web/dictController")
public class DictController {
	
	@Resource
	private DictService dictService;
	
	/**
	 *系统字典管理
	 */
	@RequestMapping("querydict")
	@ResponseBody
	@RequiresPermissions("DictController:querydict")
	public DataGrid querydict(HttpServletRequest request) throws Exception {
		String pages = request.getParameter("page")==null ? "1":request.getParameter("page");
		String rows = request.getParameter("rows")==null ? "10":request.getParameter("rows");
		
		String dictName = request.getParameter("dictName");
		String parentNo = request.getParameter("parentNo");
		Map<String,Object> param = new HashMap<String,Object>();
		int page = Integer.parseInt(pages);
		int pageSize = Integer.parseInt(rows);
		param.put("pageStart", (page-1)*pageSize+1);
		param.put("pageEnd", (page-1)*pageSize+pageSize);
		param.put("dictName", dictName);
		param.put("parentNo", parentNo);		
		DataGrid data = dictService.queryPage(param);
		return data;
	}
	
	@RequestMapping("updateDictByNo")
	@ResponseBody
	public Map<String,Object> updateDictByNo(HttpServletRequest request){
		String no = request.getParameter("no");
		String value = request.getParameter("value");
		String type = request.getParameter("type");
		Map<String,Object> param = new HashMap<>();
		param.put("no", no);
		param.put("value", value);
		param.put("type", type);
		Map<String,Object> data = new HashMap<String,Object>();
		int conut = dictService.updateDictByNo(param);
		if(conut > 0){
			data.put("success", true);
			data.put("message", "保存成功");
		}else{
			data.put("success", false);
			data.put("message", "保存失败");
		}
		return data;
	}
	
	@RequestMapping("updateDict")
	@ResponseBody
	public Map<String,Object> updateDict(HttpServletRequest request){
		String no = request.getParameter("dictCode");
		String value = request.getParameter("dictName");
		String id = request.getParameter("dictId");
		Map<String,Object> param = new HashMap<>();
		param.put("no", no);
		param.put("value", value);
		param.put("id", id);
		Map<String,Object> data = new HashMap<String,Object>();
		int conut = dictService.updateDict(param);
		if(conut > 0){
			data.put("success", true);
			data.put("message", "保存成功");
		}else{
			data.put("success", false);
			data.put("message", "保存失败");
		}
		return data;
	}
	
	@RequestMapping("queryDictType")
	@ResponseBody
	public List<Map<String,Object>> queryDictType(){
		List<Map<String,Object>> data = dictService.queryDictType();	
		return data;
	}
	
	@RequestMapping("insertDictType")
	@ResponseBody
//	@RequiresPermissions("DictController:insertDictType")
	public Map<String,Object> insertDictType(String addDictType){
		Map<String,Object> param = new HashMap<String,Object>();
		String id = RandomUtil.UUID();
		Date createTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(createTime);
		Subject subject = SecurityUtils.getSubject();
		String createUser = (String)subject.getPrincipal();
		param.put("createTime", dateString);
		param.put("createUser", createUser);
		param.put("dictId", id);
		param.put("parentNo", "0");
		param.put("dictName", "新增类型");
		Dict dict = dictService.insertDictType(param);
		Map<String,Object> data = new HashMap<String,Object>();
		if(dict != null){
			data.put("success", true);
			data.put("no", dict.getNo());
		}else{
			data.put("success", false);
			data.put("message", "添加失败");
		}
		return data;
	}
	
	@RequestMapping("addDict")
	@ResponseBody
	@RequiresPermissions("DictController:addDict")
	public Map<String,Object> addDict(HttpServletRequest request){
		String dictName = request.getParameter("dictName");
		String parentNo = request.getParameter("parentNo");
		String no = request.getParameter("no");
		String dictId = RandomUtil.UUID();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("dictId", dictId);
		param.put("dictName", dictName);
		param.put("no", no);
		param.put("parentNo", parentNo);
		int count = dictService.addDict(param);
		Map<String,Object> data = new HashMap<>();
		if(count > 0){
			data.put("success", true);
		}else{
			data.put("success", false);
		}
		return data;
	}
	
	@RequestMapping("deleteRow")
	@ResponseBody
	public Map<String,Object> deleteRow(String dictid){
		Map<String,Object> param = new HashMap<>();
		param.put("dictId", dictid);
		int count = dictService.deleteRow(param);
		Map<String,Object> data = new HashMap<>();
		if(count > 0){
			data.put("success", true);
		}else{
			data.put("success", false);
		}
		return data;
	}
	
	@RequestMapping("deleteDictType")
	@ResponseBody
	public Map<String,Object> deleteDictType(String no){
		Map<String,Object> param = new HashMap<>();
		param.put("no", no);
		int count = dictService.deleteDictType(param);
		Map<String,Object> data = new HashMap<>();
		if(count > 0){
			data.put("success", true);
		}else{
			data.put("success", false);
		}
		return data;
	}
	
	@RequestMapping("check1")
	@ResponseBody
	public Map<String,Object> check1(String dictType){
		Map<String,Object> data = new HashMap<>();
		int count = dictService.check1(dictType);
		if(count > 0){
			data.put("success", true);
		}else{
			data.put("success", false);
		}
		return data;
	}
	
	@RequestMapping("check2")
	@ResponseBody
	public Map<String,Object> check2(String no,String dictName,String parentNo){
		Map<String,Object> data = new HashMap<>();
		int count = dictService.check2(no, dictName,parentNo);
		if(count > 0){
			data.put("success", true);
		}else{
			data.put("success", false);
		}
		return data;
	}
	/**
	 * 菜单树
	 * @return
	 */
	@RequestMapping(value = "selDictTree")
	@ResponseBody
	public List<JsonTreeData> selDictTree() {
		List<JsonTreeData>tree = dictService.selDictTree();	
		return tree;
	}
	
	@RequestMapping("list")
	@ResponseBody
	public List<Map<String, Object>> list(String type){
		Map<String,Object> param = new HashMap<>();
		param.put("dictType", type);
		return dictService.list(param);
	}
	/**
	 * 下拉框调用方法
	 * @return
	 */
	@RequestMapping(value = "queryByType")
	@ResponseBody
	public List<Map<String,Object>> queryByType(String type) {
		List<Map<String,Object>> dictList = dictService.queryByType(type);	
		return dictList;
	}
	
}

