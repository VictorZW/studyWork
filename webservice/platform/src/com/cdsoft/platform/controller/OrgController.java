package com.cdsoft.platform.controller;

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
import com.cdsoft.platform.entity.Org;
import com.cdsoft.platform.service.OrgService;
import com.cdsoft.platform.util.DataGrid;
import com.cdsoft.platform.util.RandomUtil;

@Controller
@RequestMapping( value = "web/orgController")
public class OrgController {
	
	@Resource
	private OrgService orgService;
	
	/**
	 * 查询所有用户
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "selOrgComboBox")
	@ResponseBody
	public List<Map<String,Object>> selOrgComboBox(HttpServletRequest request) throws Exception {
		List<Map<String,Object>> data = orgService.selOrgComboBox();
		return data;
	}
	
	/**
	 * 查询当前部门下所有用户
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "selOrgUser")
	@ResponseBody
	@RequiresPermissions("OrgController:selOrgUser")
	public DataGrid selOrgUser(HttpServletRequest request) throws Exception {
		
		String pages = request.getParameter("page")==null ? "1":request.getParameter("page");
		String rows = request.getParameter("rows")==null ? "10":request.getParameter("rows");
		String orgCode = request.getParameter("orgCode");
		Map<String,Object> param = new HashMap<String,Object>();
		int page = Integer.parseInt(pages);
		int pageSize = Integer.parseInt(rows);
		param.put("pageStart", (page-1)*pageSize+1);
		param.put("pageEnd", (page-1)*pageSize+pageSize);
		param.put("orgCode",orgCode);
		DataGrid data = orgService.queryOrgUserPage(param);
		return data;
	}
	
	/**
	 * 为当前部门分配人员
	 * @param data
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "updateOrgUser")
	@ResponseBody
	public Map<String,Object> updateOrgUser(HttpServletRequest request) throws Exception {
		String ids = request.getParameter("userCode");
		String orgCode = request.getParameter("orgCode");
		String[] usercode = ids.split(",");
		Map<String,Object> param = new HashMap<String,Object>();
		for(int i=0;i<usercode.length;i++){
			param.put("userCode", usercode[i]);
			param.put("orgCode", orgCode);
			orgService.updateUserOrg(param);
		}
		Map<String,Object> s = new HashMap<String,Object>();
		s.put("success", true);
		return s;
	}
	/**
	 * 查询部门树
	 */
	@RequestMapping(value = "selOrgTree")
	@ResponseBody
	@RequiresPermissions("OrgController:selOrgTree")
	public List<JsonTreeData> selOrgTree() {
		List<JsonTreeData> tree = orgService.selOrgTree();
		return tree;
	}
	
	/**
	 * 新增空节点
	 */
	@RequestMapping(value = "insertOrgTreeChild")
	@ResponseBody
	public Map<String,Object> insertOrgTreeChild(String orgCode) {
		String orgid = RandomUtil.UUID();
		Date creDate = new Date();
		Subject subject = SecurityUtils.getSubject();
		String creUser = (String)subject.getPrincipal();
		
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("orgid", orgid);
		param.put("orgpid", orgCode);
		param.put("creDate", creDate);
		param.put("creUser", creUser);		
		Org orgNewCode = orgService.selNewOrgTree(param);
		Map<String,Object> data = new HashMap<String,Object>();
		if(orgNewCode != null){
			data.put("success", true);
			data.put("orgNewCode", orgNewCode.getOrgCode());
		}else{
			data.put("success", false);
		}
		return data;
	}
	
	@RequestMapping(value = "updateOrgName")
	@ResponseBody
	public void updateOrgName(HttpServletRequest request) {
		String orgName = request.getParameter("orgName");
		String orgCode = request.getParameter("orgCode");
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("orgName", orgName);
		param.put("orgCode", orgCode);
		orgService.updateOrgName(param);
	}
	
	@RequestMapping(value = "delOrgTree")
	@ResponseBody
	public Map<String,Object> delOrgTree(String orgCode) {
		int count = orgService.delOrgTree(orgCode);
		Map<String,Object> data = new HashMap<String,Object>();
		if(count > 0){
			data.put("success", true);
		}else{
			data.put("success", false);
		}
		return data;
	}
	@RequestMapping("selectOrg")
	@ResponseBody
	public List<Org> selectOrg(){
		return orgService.selectOrg();
	}
}
