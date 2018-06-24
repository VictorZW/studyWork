package com.cdsoft.platform.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdsoft.platform.entity.Dict;
import com.cdsoft.platform.entity.Menu;
import com.cdsoft.platform.entity.Resource;
import com.cdsoft.platform.mapper.MenusMapper;
import com.cdsoft.platform.service.DictService;
import com.cdsoft.platform.service.MenusService;
import com.cdsoft.platform.service.ResourceService;
import com.cdsoft.platform.util.DataGrid;

@Scope("prototype")
@Controller
@RequestMapping("web/resource")
public class ResourceController {

	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	private MenusService menusService;
	
	@Autowired
	private DictService dictService;
	
	@Autowired
	private MenusMapper menusMapper;
	
	@RequestMapping("/frontList")
	public @ResponseBody List<Map<String,Object>> frontList(){
		//System.out.println(SecurityUtils.getSubject().getPrincipal().toString()+"############################");
		List<Map<String,Object>> resources = resourceService.frontList();
		return resources;
	}
	

	/*
	 * 资源管理首页信息查询
	 */
	@RequestMapping(value= "selResource")
	@ResponseBody
	@RequiresPermissions("ResourceController:selResource")
	public DataGrid selResource(HttpServletRequest request) throws Exception {
		String pages = request.getParameter("page")==null ? "1":request.getParameter("page");
		String rows = request.getParameter("rows")==null ? "10":request.getParameter("rows");
		String name = request.getParameter("name");
		String menuCode = request.getParameter("menuCode");
		//String menuCode2 = menusMapper.selectMenuCode(menuCode);
		String permission = request.getParameter("permission");
		Map<String,Object> param = new HashMap<String,Object>();
		int page = Integer.parseInt(pages);
		int pageSize = Integer.parseInt(rows);
		param.put("pageStart", (page-1)*pageSize+1);
		param.put("pageEnd", (page-1)*pageSize+pageSize);
		param.put("name", name);
		ArrayList<String> menuCode3 = new ArrayList<String>();
		if(null !=menuCode && !"".equals(menuCode) ){
			List<Menu> menuCode2 = menusMapper.selectMenuCode(menuCode);
			for (Menu menu : menuCode2) {
				menuCode3.add(menu.getMenuCode());
			}
			
			param.put("menuCode", menuCode3);
		}else{
			param.put("menuCode", menuCode);			
		}
		param.put("permission",permission );
		DataGrid data = resourceService.queryPage(param);
		return data;
	}
	
	/*
	 * 添加资源
	 */
	@RequestMapping("insert")
	@ResponseBody
	@RequiresPermissions("ResourceController:insert")
	public Map<String,Object> insert(HttpServletRequest request){
		Map<String,Object> jsonObj = new HashMap<String,Object>();
		String name = request.getParameter("name");
		String permission = request.getParameter("permission");
		String type = request.getParameter("type");
		String url = request.getParameter("url");
		String menuCode = request.getParameter("menuCode");
		String resCode = request.getParameter("resCode");
		String resType = request.getParameter("resType");
		Resource resource = new Resource();
		resource.setName(name);
		resource.setPermission(permission);
		resource.setType(type);
		resource.setUrl(url);
		resource.setMenuCode(menuCode);
		resource.setResCode(resCode);
		resource.setResType(resType);
		int count = resourceService.insert(resource);
		if(count > 0){
			jsonObj.put("success",true );
			jsonObj.put("message","添加成功" );
		}else{
			jsonObj.put("success",false );
			jsonObj.put("message","添加失败" );
		}
		return jsonObj;
	}
	
	/*
	 * 修改资源
	 */
	@RequestMapping("update")
	@ResponseBody
	@RequiresPermissions("ResourceController:edit")
	public Map<String,Object> update(HttpServletRequest request) {
		Map<String,Object> jsonObj = new HashMap<String,Object>();
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String permission = request.getParameter("permission");
		String type = request.getParameter("type");
		String url = request.getParameter("url");
		String menuCode = request.getParameter("menuCode");
		String resCode = request.getParameter("resCode");
		String resType = request.getParameter("resType");
		Resource resource = new Resource();
		resource.setId(id);
		resource.setName(name);
		resource.setPermission(permission);
		resource.setType(type);
		resource.setUrl(url);
		resource.setMenuCode(menuCode);
		resource.setResCode(resCode);
		resource.setResType(resType);
		int count = resourceService.update(resource);
		if(count >=1){
			jsonObj.put("success",true );
			jsonObj.put("message","修改成功" );
		}else{
			jsonObj.put("success",false );
			jsonObj.put("message","修改失败" );
		}
		return jsonObj;
	}
	
	/*
	 * 删除资源
	 */
	@RequestMapping("delete")
	@ResponseBody
	@RequiresPermissions("ResourceController:remove")
	public Map<String,Object> delete(String ids) {
		Map<String,Object> jsonObj =new HashMap<String,Object>();
		int count = resourceService.delete(ids);
		if(count>0){
			jsonObj.put("success", true);
			jsonObj.put("message", "共有"+count+"条记录被删除");
		}else{
			jsonObj.put("success", false);
			jsonObj.put("message", "删除失败！");
		}
		return jsonObj;
	}
	
	//查询重复
	@RequestMapping("checkName")
	@ResponseBody
	public Map<String,Object> check(String name) {
		int count = resourceService.checkName(name);
		Map<String,Object> jsonObj = new HashMap<String,Object>();
		if(count > 0){
			jsonObj.put("success", false);
		}else{
			jsonObj.put("success", true);
		}
		return jsonObj;
	}
	
	//查询菜单
	@RequestMapping("queryMenu")
	public @ResponseBody List<Menu> queryMenu(){
		List<Menu> list = menusService.selMenu();
		return list;
	}
	//查询类型
	@RequestMapping("queryType")
	public @ResponseBody List<Dict> queryType(){
		List<Dict> list=dictService.queryType();
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
