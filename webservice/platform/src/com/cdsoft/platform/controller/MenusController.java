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

import com.cdsoft.platform.entity.JsonTreeData;
import com.cdsoft.platform.entity.Menu;
import com.cdsoft.platform.service.MenusService;

@Controller
@RequestMapping( value = "web/menusController")
public class MenusController {
	
	@Resource
	private MenusService menusService;
	
	/**
	 * 菜单树
	 * @return
	 */
	@RequestMapping(value = "selMenuTree")
	@ResponseBody
	@RequiresPermissions("MenusController:selMenuTree")
	public List<JsonTreeData> selMenuTree() {
		List<JsonTreeData>tree = menusService.selMenuTree();	
		return tree;
	}
	
	/**
	 * 添加和修改树
	 * @param menuId
	 * @return
	 */
	@RequestMapping(value = "updateMenuTreeChild")
	@ResponseBody
	public Map<String,Object> updateMenuTreeChild(HttpServletRequest request) {
		Map<String,Object> data = new HashMap<String,Object>();
		String menuId = request.getParameter("menuId");
		String menuName = request.getParameter("menuName");
		String menuUrl = request.getParameter("menuUrl");
		String orderId = request.getParameter("orderId");
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("menuId", menuId);
		param.put("menuName", menuName);
		param.put("menuUrl", menuUrl);
		param.put("orderId", orderId);
		Date updateTime = new Date();
		param.put("updateTime", updateTime);
		int conut = menusService.updateMenuTreeChild(param);
		
		if(conut > 0){
			data.put("success", true);
			data.put("message", "保存成功");
		}else{
			data.put("success", false);
			data.put("message", "保存失败");
		}
		return data;
	}
	
	/**
	 * 添加根节点
	 * @return
	 */
	@RequestMapping(value = "insertParent")
	@ResponseBody
	@RequiresPermissions("MenusController:insertParent")
	public Map<String,Object> insertParent(){
		Map<String,Object> param = new HashMap<String,Object>();
		Date createTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(createTime);
		Subject subject = SecurityUtils.getSubject();
		String createUser = (String)subject.getPrincipal();
		param.put("dateString", dateString);
		param.put("createUser", createUser);
		Menu menu = menusService.insertParent(param);
		Map<String,Object> data = new HashMap<String,Object>();
		if(menu != null){
			data.put("success", true);
			data.put("menuId", menu.getMenuCode());
		}else{
			data.put("success", false);
			data.put("message", "添加失败");
		}
		return data;
	}
	
	/**
	 * 添加子节点
	 * @return
	 */
	@RequestMapping(value = "insertChild")
	@ResponseBody
	@RequiresPermissions("MenusController:insertChild")
	public Map<String,Object> insertChild(String menuId){
		Map<String,Object> param = new HashMap<String,Object>();
		Date createTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(createTime);
		Subject subject = SecurityUtils.getSubject();
		String createUser = (String)subject.getPrincipal();
		param.put("pid", menuId);
		param.put("dateString", dateString);
		param.put("createUser", createUser);
		Menu menu = menusService.insertChild(param);
		Map<String,Object> data = new HashMap<String,Object>();
		if(menu != null){
			data.put("success", true);
			data.put("menuId", menu.getMenuCode());
			data.put("pid", menu.getParentId());
		}else{
			data.put("success", false);
			data.put("message", "添加失败");
		}
		return data;
	}
	
	
	@RequestMapping(value = "deleteMenu")
	@ResponseBody
	public Map<String,Object> deleteMenu(HttpServletRequest request) {
		String menuId = request.getParameter("menuId");
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("menuId", menuId);
		int count = menusService.deleteMenuParent(param);
		Map<String,Object> data = new HashMap<String,Object>();
		if(count > 0){
			data.put("success", true);
		}else{
			data.put("success", false);
		}
		return data;
	}
}
