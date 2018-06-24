package com.cdsoft.platform.util;

import java.util.HashMap;
import java.util.Map;


/**
 * $.ajax后需要接受的JSON
 * 
 * @author
 * 
 */
public class AjaxJson {

	private boolean success = true;// 是否成功
	private String msg = "false";// 提示信息
	private String version = "";// 提示信息
	private String url = "";// 提示信息
	private String USERCODE = "";//
	private String ERROR_CODE = "";//
	private String VERSIONCODE = "";

	private boolean flag = true;

	public String getERROR_CODE() {
		return ERROR_CODE;
	}

	public void setERROR_CODE(String eRROR_CODE) {
		ERROR_CODE = eRROR_CODE;
	}

	private Object obj = null;// 其他信息
	private Map<String, Object> attributes;// 其他参数

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public String getUSERCODE() {
		return USERCODE;
	}

	public void setUSERCODE(String uSERCODE) {
		USERCODE = uSERCODE;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getVERSIONCODE() {
		return VERSIONCODE;
	}

	public void setVERSIONCODE(String versioncode) {
		this.VERSIONCODE = versioncode;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Map<String, Object> getJsonStr() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", this.isSuccess());
		map.put("flag", this.isFlag());
		map.put("msg", this.getMsg());
		map.put("version", this.getVersion());
		map.put("url", this.getUrl());
		map.put("Content", this.obj);
		map.put("USERCODE", this.USERCODE);
		map.put("attributes", this.attributes);
		map.put("ERROR_CODE", ERROR_CODE);
		map.put("VERSIONCODE", this.getVERSIONCODE());
		return map;
	}
}
