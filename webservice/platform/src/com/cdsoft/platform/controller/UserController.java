package com.cdsoft.platform.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cdsoft.platform.entity.User;
import com.cdsoft.platform.service.UserService;
import com.cdsoft.platform.util.Constants;
import com.cdsoft.platform.util.DataGrid;
import com.cdsoft.platform.util.DateUtils;
import com.cdsoft.platform.util.ExportByFreeMarker;
import com.cdsoft.platform.util.MD5Util;
import com.cdsoft.platform.util.PropsUtil;
import com.cdsoft.platform.util.UtilValidator;

@Controller
@RequestMapping("web/userController")
public class UserController {
	
	@Resource
	private UserService userService;
	
	/**
	 * 查询所有人员信息
	 */
	@RequestMapping("queryUserInfo")
	@ResponseBody
	@RequiresPermissions("UserController:queryUserNeed")
	public DataGrid queryUserInfo(HttpServletRequest request) throws Exception {
		Map<String,Object> param = new HashMap<String,Object>();
		
		String pages = request.getParameter("page")==null ? "1":request.getParameter("page");
		String rows = request.getParameter("rows")==null ? "10":request.getParameter("rows");
		String userCode = request.getParameter("userCode");
		String userName = request.getParameter("userName");
		String orgName = request.getParameter("orgName");	
		String orgCode = request.getParameter("orgCode");
		int page = Integer.parseInt(pages);
		int pageSize = Integer.parseInt(rows);
		
		param.put("pageStart", (page-1)*pageSize+1);
		param.put("pageEnd", (page-1)*pageSize+pageSize);
		param.put("userCode", userCode);
		param.put("userName", userName);
		param.put("orgName",orgName);
		param.put("orgCode",orgCode);
		DataGrid data = userService.queryUserInfo(param);
		System.out.println(Constants.cache.toString());
		return data;
	}
	
	/**
	 * 确认用户唯一性
	 */
	@RequestMapping("check")
	@ResponseBody
	public Map<String,Object> check(String userCode) {
		Map<String,Object> jsonObj = new HashMap<String,Object>(); 
		User code = userService.check(userCode);
		if(code.getUserName() == userCode){
			jsonObj.put("success", true);
		}else{
			jsonObj.put("success", false);
		}
		return jsonObj;
	}
	
	
	@RequestMapping("checks")
	@ResponseBody
	public Map<String,Object> checks(String userCode) {
		Map<String,Object> jsonObj = new HashMap<String,Object>(); 
		int count = userService.checks(userCode);
		if(count > 0){
			jsonObj.put("success", true);
		}else{
			jsonObj.put("success", false);
		}
		return jsonObj;
	}
	
	/**
	 * 人员新增
	 */
	@RequestMapping("insert")
	@ResponseBody
	@RequiresPermissions("UserController:insert")
	public Map<String,Object> insert(HttpServletRequest request){
		
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String,Object> param = new HashMap<String,Object>();
		Subject subject = SecurityUtils.getSubject();
		
		String userCode = request.getParameter("userCode");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String orgName = request.getParameter("orgName");
		String jobNum = request.getParameter("jobNum");
		String cellPhone =request.getParameter("cellPhone");
		String loginTime =request.getParameter("loginTime");
		String endloginTime =request.getParameter("endloginTime");
		String isVerifyvt =request.getParameter("isVerifyvt");
		
		String createUser = (String)subject.getPrincipal();

		param.put("userCode", userCode);
		param.put("userName", userName);
		if(!UtilValidator.isEmpty(password)) {			
			param.put("password", MD5Util.MD5(password));
		}
		param.put("orgName", orgName);
		param.put("createUser", createUser);
		
		param.put("jobNum",jobNum);
		param.put("cellPhone", cellPhone);
		param.put("loginTime",loginTime);
		param.put("endloginTime", endloginTime);
		param.put("isVerifyvt", isVerifyvt);
		
		int count = userService.insert(param);
		if(count>=1){
			result.put("success", true);
			result.put("message", "添加用户成功");
		}else{
			result.put("success", false);
			result.put("message", "添加用户失败");
		}
		return result;
	} 
	
	
	/**
	 * 删除用户
	 */
	@RequestMapping("delete")
	@ResponseBody
	@RequiresPermissions("UserController:delete")
	public Map<String,Object> delete(String ids){		
		Map<String,Object> jsonObj =new HashMap<String,Object>();
		int count = userService.delete(ids);
		if(count>0){
			jsonObj.put("success", true);
			jsonObj.put("message", "共有"+count+"条记录被删除");
		}else{
			jsonObj.put("success", false);
			jsonObj.put("message", "删除失败！");
		}
		return jsonObj;
	}
	
	/**
	 * 修改用户信息
	 */
	@RequestMapping("update")
	@ResponseBody
	@RequiresPermissions("UserController:update")
	public Map<String,Object> update(HttpServletRequest request){
		
		Map<String,Object> jsonObj = new HashMap<String,Object>();
		String userCode = request.getParameter("userCode");
		String userName = request.getParameter("userName");
		String orgName = request.getParameter("orgName");
		String jobNum = request.getParameter("jobNum");
		String cellPhone = request.getParameter("cellPhone");
		String loginTime =request.getParameter("loginTime");
		String endloginTime =request.getParameter("endloginTime");
		String isVerifyvt =request.getParameter("isVerifyvt");
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("userCode", userCode);
		param.put("userName", userName);
		param.put("orgName", orgName);
		param.put("jobNum", jobNum);
		param.put("cellPhone", cellPhone);
		param.put("loginTime",loginTime);
		param.put("endloginTime", endloginTime);
		param.put("isVerifyvt", isVerifyvt);
		int count = userService.update(param);
		if(count >= 1){
			jsonObj.put("success", true);
			jsonObj.put("message", "修改成功");
		}else{
			jsonObj.put("success", false);
			jsonObj.put("message", "修改失败");
		}
		return jsonObj;
	}
	
	/**
	 * 重置密码
	 */
	@RequestMapping("reset")
	@ResponseBody
	@RequiresPermissions("UserController:resetPassWord")
	public Map<String,Object> resetPassWord(HttpServletRequest request){
		Map<String,Object> jsonObj = new HashMap<String,Object>();
		String userCode = request.getParameter("userCode");
		String password = request.getParameter("alterPassword");
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("userCode", userCode);
		if(!UtilValidator.isEmpty(password)) {			
			param.put("password", MD5Util.MD5(password));
		}
//		param.put("password", password);
		int count =userService.resetPassWord(param);
		if(count >= 1){
			jsonObj.put("success", true);
			jsonObj.put("message", "修改成功");
		}else{
			jsonObj.put("success", false);
			jsonObj.put("message", "修改失败");
		 }
		return jsonObj;
	}
	
	/**
	 * combobox按部门查询驻地
	 */
	@RequestMapping(value = "queryStation")
	@ResponseBody
	public List<Map<String,Object>> queryStation(String orgCode) {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list = userService.queryStation(orgCode);
 		return list;
	}
	
	/**
	 * combobox查询所有驻地
	 */
	@RequestMapping(value = "queryStations")
	@ResponseBody
	public List<Map<String,Object>> queryStations() {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list = userService.queryStations();
 		return list;
	}
	/**
	 * 显示首页登录人姓名
	 */
	@RequestMapping("getUserName")
	@ResponseBody
	public Map<String, Object> getUserName(HttpServletRequest request) {
		Map<String, Object> map = (Map<String, Object>)request.getSession().getAttribute("user");		
		return map;
	}	
	/**
	 * 修改密码
	 */
	@RequestMapping("updatePassword")
	@ResponseBody
	public Map<String,Object> updatePassword(String curentPassword,String newPassword){
		Map<String,Object> map = new HashMap<String,Object>();
		String subject  = (String)SecurityUtils.getSubject().getPrincipal();
		User user = userService.selectUserInfo(subject, curentPassword);
		if(user == null){
			map.put("success", false);
			map.put("massage", "当前密码错误，修改失败");
			return map;
		}
	    Map<String,Object> param = new HashMap<String,Object>();
		param.put("password", newPassword);
		param.put("userCode", subject);
	    if(userService.resetPassWord(param)>0){
	    	map.put("success", true);
			map.put("massage", "修改成功");
			return map;
	    }else{
	    	map.put("success", false);
			map.put("massage", "服务异常，修改失败");
			return map;
	    }
	}
	
	/**
	 * 用户批量上传
	 */
	@RequestMapping("upload")
	@ResponseBody
	public Map<String, Object> upload(HttpServletRequest request, String isRepeat) {
		Map<String, Object> map = new HashMap<>();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("file");
		String filename = file.getOriginalFilename();
		int status = 0;
		String message = "";
		try {
			String path = PropsUtil.getProperty("file_path") + "user/";// 文件保存在硬盘的相对路径
			File source = new File(path, filename);
			if (!source.exists() && !source.isDirectory()) {
				source.mkdirs();
			}
			file.transferTo(source);
			try {
				map = userService.importExel(source, isRepeat);
				status = Integer.parseInt(map.get("status").toString());
				message = map.get("message").toString();
			} catch (Exception e) {
				map.put("status", 1);
				map.put("message", "数据格式不正确,上传失败,请检查导入文件或者联系管理员!");
				e.printStackTrace();
				return map;
			}
				map.put("status", status);
				map.put("message",message);
		} catch (IOException e) {
			map.put("status", status);
			map.put("message", "数据格式不正确,上传失败,请检查导入文件或者联系管理员!");
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value="download")
	public void download(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.reset();
		String downloadName="用户导入模板.xls";
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(downloadName.getBytes(),"ISO-8859-1"));
        String  dlfile = PropsUtil.getProperty("file_path") + "file/"+downloadName;
        InputStream inputStream = new FileInputStream(dlfile);
        ServletOutputStream out = response.getOutputStream();

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {

            bis = new BufferedInputStream(inputStream);
            bos = new BufferedOutputStream(out);

            byte[] buff = new byte[2048];
            int bytesRead;

            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }

        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
	}
	@RequestMapping("/export")
	public void exportGwgs(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map = new HashMap<String,Object>();
		List<User> userList = userService.list();
		map.put("rows",userList);
		ExportByFreeMarker ebm = new ExportByFreeMarker();
		ebm.setData(map);
		ebm.setFtlName("user.ftl");
		ebm.setOutFileName("用户信息表"+DateUtils.getCurrentDate()+".xls");
	
		ebm.exportToExcel(request, response);
	}
}
