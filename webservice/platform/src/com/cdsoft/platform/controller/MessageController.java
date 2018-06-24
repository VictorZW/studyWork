package com.cdsoft.platform.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdsoft.platform.entity.Message;
import com.cdsoft.platform.service.MessageService;
import com.cdsoft.platform.util.DataGrid;

@Controller
@RequestMapping(value="web/messageController")
public class MessageController {

	@Resource
	private MessageService messageService;
	
	@RequestMapping(value="querymessage")
	@ResponseBody
	@RequiresPermissions("MessageController:querymessage")
	public DataGrid querymessage(HttpServletRequest request){
		String pages = request.getParameter("page")==null ? "1":request.getParameter("page");
		String rows = request.getParameter("rows")==null ? "10":request.getParameter("rows");
		String type = request.getParameter("type");
		String sender = request.getParameter("sender");
		String time = request.getParameter("time");
		int page = Integer.parseInt(pages);
		int pageSize = Integer.parseInt(rows);
		Map<String,Object> param = new HashMap<>();
		param.put("pageStart", (page-1)*pageSize+1);
		param.put("pageEnd", (page-1)*pageSize+pageSize);
		param.put("type", type);
		param.put("sender", sender);
		param.put("time", time);
		DataGrid data = messageService.queryPage(param);
		return data;
	}
	/*
	 * 添加消息
	 */
	@RequestMapping("insert")
	@ResponseBody
	@RequiresPermissions("MessageController:insert")
	public Map<String,Object> insert(HttpServletRequest request){
		Map<String,Object> jsonObj = new HashMap<String,Object>();
		String title = request.getParameter("TITLE");
		String type = request.getParameter("TYPE");
		String sender = request.getParameter("SENDER");
		String recipient = request.getParameter("RECIPIENT");
		String content = request.getParameter("CONTENT");
		Message message = new Message();
		message.setTitle(title);
		message.setType(type);
		message.setSender(sender);
		message.setContent(content);
		message.setRecipient(recipient);
		int count = messageService.insert(message);
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
	 * 修改消息
	 */
	@RequestMapping("update")
	@ResponseBody
	@RequiresPermissions("MessageController:update")
	public Map<String,Object> update(HttpServletRequest request) {
		Map<String,Object> jsonObj = new HashMap<String,Object>();
		String id = request.getParameter("ID");
		String title = request.getParameter("TITLE");
		String type = request.getParameter("TYPE");
		String sender = request.getParameter("SENDER");
		String recipient = request.getParameter("RECIPIENT");
		String content = request.getParameter("CONTENT");
		Message message = new Message();
		message.setId(id);
		message.setTitle(title);
		message.setType(type);
		message.setSender(sender);
		message.setContent(content);
		message.setRecipient(recipient);
		int count = messageService.update(message);
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
	 * 删除消息
	 */
	@RequestMapping("delete")
	@ResponseBody
	@RequiresPermissions("MessageController:remove")
	public Map<String,Object> delete(String ids) {
		Map<String,Object> jsonObj =new HashMap<String,Object>();
		int count = messageService.delete(ids);
		if(count>0){
			jsonObj.put("success", true);
			jsonObj.put("message", "共有"+count+"条记录被删除");
		}else{
			jsonObj.put("success", false);
			jsonObj.put("message", "删除失败！");
		}
		return jsonObj;
	}
}
