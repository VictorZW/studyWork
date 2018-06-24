package com.cdsoft.platform.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdsoft.platform.entity.JsonTreeData;
import com.cdsoft.platform.entity.RoleResource;
import com.cdsoft.platform.service.RoleResourceService;
import com.cdsoft.platform.service.RoleService;
import com.cdsoft.platform.util.DataGrid;

@Controller
@RequestMapping( value = "web/roleController")
public class RoleController {
	@Resource
	private RoleService roleService;
	
	@Resource
	private RoleResourceService roleResourceService;
	
	
	/*
	 * 角色管理首页信息查询
	 */
	@RequestMapping(value= "queryRoleNeed")
	@ResponseBody
	@RequiresPermissions("RoleController:queryRoleNeed")
	public DataGrid queryRoleNeed(HttpServletRequest request) throws Exception {
		String pages = request.getParameter("page")==null ? "1":request.getParameter("page");
		String rows = request.getParameter("rows")==null ? "10":request.getParameter("rows");
		String roleName = request.getParameter("roleName");
		Map<String,Object> param = new HashMap<String,Object>();
		int page = Integer.parseInt(pages);
		int pageSize = Integer.parseInt(rows);
		param.put("pageStart", (page-1)*pageSize+1);
		param.put("pageEnd", (page-1)*pageSize+pageSize);
		param.put("roleName", roleName);
		DataGrid data = roleService.queryPage(param);
		return data;
	}
	
	/*
	 * 添加角色
	 */
	@RequestMapping("insert")
	@ResponseBody
	@RequiresPermissions("RoleController:insert")
	public Map<String,Object> insert(HttpServletRequest request){
		Map<String,Object> jsonObj = new HashMap<String,Object>();
		String roleName = request.getParameter("roleName");
		String describe = request.getParameter("describe");
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("roleName", roleName);
		param.put("describe", describe);
		int count = roleService.insert(param);
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
	 * 修改角色
	 */
	@RequestMapping("update")
	@ResponseBody
	public Map<String,Object> update(HttpServletRequest request) {
		Map<String,Object> jsonObj = new HashMap<String,Object>();
		String roleCode = request.getParameter("roleCode");
		String roleName = request.getParameter("roleName");
		String describe = request.getParameter("describe");
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("roleCode", roleCode);
		param.put("roleName", roleName);
		param.put("describe", describe);
		int count = roleService.update(param);
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
	 * 删除角色
	 */
	@RequestMapping("delete")
	@ResponseBody
	public Map<String,Object> delete(String ids) {
		Map<String,Object> jsonObj =new HashMap<String,Object>();
		int count = roleService.delete(ids);
		if(count>0){
			jsonObj.put("success", true);
			jsonObj.put("message", "共有"+count+"条记录被删除");
		}else{
			jsonObj.put("success", false);
			jsonObj.put("message", "删除失败！");
		}
		return jsonObj;
	}
	
	
	@RequestMapping("checkName")
	@ResponseBody
	public Map<String,Object> check(String roleName) {
		int count = roleService.checkName(roleName);
		Map<String,Object> jsonObj = new HashMap<String,Object>();
		if(count > 0){
			jsonObj.put("success", false);
		}else{
			jsonObj.put("success", true);
		}
		return jsonObj;
	}
	
	/*
	 * 查询人员分配页面信息
	 */
	@RequestMapping(value= "queryRoleUserPage")
	@ResponseBody
	@RequiresPermissions("RoleController:queryRoleUserPage")
	public DataGrid queryRoleUserPage(HttpServletRequest request) throws Exception {
		String roleCode = request.getParameter("id");
		String pages = request.getParameter("page")==null ? "1":request.getParameter("page");
		String rows = request.getParameter("rows")==null ? "10":request.getParameter("rows");
		Map<String,Object> param = new HashMap<String,Object>();
		int page = Integer.parseInt(pages);
		int pageSize = Integer.parseInt(rows);
		param.put("pageStart", (page-1)*pageSize+1);
		param.put("pageEnd", (page-1)*pageSize+pageSize);
		param.put("roleCode", roleCode);
		DataGrid data = roleService.queryRoleUserPage(param);
		return data;
	}
	
	/*
	 * 人员分配角色
	 */
	@RequestMapping(value="insertRoleUser")
	@ResponseBody
	public Map<String,Object> insertRoleUser(String id, String ids){
		Map<String,Object> josnObj = new HashMap<String,Object>();
		Map<String,Object> param = new HashMap<String,Object>();
		 int count = 0;
		if(ids!=null){
			String [] idstr= ids.split(",");
			for(int i=0;i<idstr.length;i++){
				param.put("roleCode", id);
				param.put("userCode", idstr[i]);
				count = roleService.insertRoleUsers(param);
			}
		}
		if(count>0){
			josnObj.put("success", true);
			josnObj.put("message", "人员添加成功");
		}else{
			josnObj.put("success", false);
			josnObj.put("message", "人员添加失败");
		}
		return josnObj;
	}
	
	/*
	 * 查询没有当前角色的所有用户
	 */
	@RequestMapping(value = "queryRoleUserNOTIN")
	@ResponseBody
	@RequiresPermissions("RoleController:queryRoleUserNOTIN")
	public List<Map<String, Object>> queryRoleUserNOTIN(HttpServletRequest req){
		String roleCode = req.getParameter("id");
		String userCode = req.getParameter("userCode");
		String userName = req.getParameter("userName");
		Map<String,Object> param = new HashMap<>();
		param.put("roleCode", roleCode);
		param.put("userCode", userCode);
		param.put("userName", userName);
		List<Map<String, Object>> data = roleService.queryRoleUserNOTIN(param);
		return data;
	}
	
	/*
	 * 收回用户的当前角色
	 */
	@RequestMapping(value = "deleteRoleUsers")
	@ResponseBody
	public Map<String,Object> deleteRoleUsers(String id,String ids){
		Map<String,Object> param = new HashMap<String,Object>();
		Map<String,Object> result = new HashMap<String,Object>();
		int count = 0;
		if(ids != null){
			String [] idstr = ids.split(",");
			for(int i=0;i<idstr.length;i++){
				param.put("roleCode", id);
				param.put("userCode", idstr[i]);
				count = roleService.deleteRoleUsers(param);
			}
		}
		if(count>0){
			result.put("success", true);
			result.put("message", "删除成功");
		}else{
			result.put("success", false);
			result.put("message", "删除失败");
		}
		return result;
	}
	
	/**
	 * 菜单树查询
	 */
	@RequestMapping(value = "selectMenuTree")
	@ResponseBody
	@RequiresPermissions("RoleController:selectMenuTree")
	public List<JsonTreeData> selectMenuTree(String roleCode){
		List<JsonTreeData> tree = roleService.selectMenuTree();
		return tree;
	}
	
	/**
	 * 查询角色菜单
	 * @param roleCode
	 * @return
	 */
	@RequestMapping(value = "selectRoleMenu")
	@ResponseBody
	public Map<String,Object> selectRoleMenu(String roleCode){
		List<Map<String, Object>> ids = roleService.selectRoleMenu(roleCode);
		List<Map<String,Object>> roleRes=roleResourceService.selectResCode(roleCode);
		for (Map<String, Object> map : roleRes) {
			ids.add(map);
		}
		Map<String, Object> data = new HashMap<String,Object>();
		if(ids != null){
			data.put("success", true);
			data.put("ids", ids);
			data.put("message", "chenggong");
		}else{
			data.put("success", false);
		}
		return data;
	}
	
	@RequestMapping(value = "deleteRoleMenu")
	@ResponseBody
	public Map<String,Object> deleteRoleMenu(String roleCode){
		roleService.deleteRoleMenu(roleCode);
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("success", true);
		return data;
	}
	
	@RequestMapping(value = "deleteroleResource")
	@ResponseBody
	public Map<String,Object> deleteroleResource(String roleCode){
		roleResourceService.delete(roleCode);
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("success", true);
		return data;
	}
	
	
	@RequestMapping(value = "addRoleMenu")
	@ResponseBody
	public Map<String,Object> addRoleMenu(String roleCode,String menuids){
		Map<String,Object> param = new HashMap<String,Object>();
		Map<String,Object> data = new HashMap<String,Object>();
		roleResourceService.delete(roleCode);
		int counts = 0;
		String [] menustr = menuids.split(",");
		for(int i=0;i<menustr.length;i++){
			if(menustr[i].length()>8){
				RoleResource resource =new RoleResource();
				resource.setResCode(menustr[i]);
				resource.setRoleCode(roleCode);
				resource.setCreateTime(new Date());
				resource.setStatus("0");
				counts +=roleResourceService.insert(resource);
				continue;
			}
			param.put("roleCode", roleCode);
			param.put("menuCode", menustr[i]); 
			int count = roleService.addRoleMenu(param);
			counts +=count; 
		}
		if(counts == menustr.length){
			data.put("success", true);
			data.put("message", "添加成功");
		}else{
			data.put("success", false);
			data.put("message", "添加失败");
		}
		return data;
	}
	
	
	@RequestMapping(value = "judge")
	@ResponseBody
	public Map<String,Object> judge(String roleids){
		Map<String,Object> data = new HashMap<>();
		Map<String,Object> param = new HashMap<>();
		String [] ids = roleids.split(",");
		int count = 0;
		for(int i = 0; i < ids.length; i++){
			param.put("roleCode", ids[i]);
			count = roleService.judge(param);
		}
		if(count > 0){
			data.put("success", true);
		}else{
			data.put("success", false);
		}
		return data;
	}
	
	@RequestMapping(value = "judgeRM")
	@ResponseBody
	public Map<String,Object> judgeRM(String roleids){
		Map<String,Object> data = new HashMap<>();
		Map<String,Object> param = new HashMap<>();
		String [] ids = roleids.split(",");
		int count = 0;
		for(int i = 0; i < ids.length; i++){
			param.put("roleCode", ids[i]);
			count = roleService.judgeRM(param);
		}
		if(count > 0){
			data.put("success", true);
		}else{
			data.put("success", false);
		}
		return data;
	}
	
}
