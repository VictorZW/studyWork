package com.cdsoft.platform.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.cdsoft.platform.service.DictService;
import com.cdsoft.platform.util.Constants;
import com.cdsoft.platform.util.PropsUtil;

public class SysInitListener implements ServletContextListener {

	private DictService dictServiceImpl;


	private ApplicationContext app;
	public static Logger log = LoggerFactory.getLogger(SysInitListener.class);

	@Override
	public void contextInitialized(ServletContextEvent event) {
		//读取dict配置
		initDict(event);
		//读取配置文件config.properties
		initConfig();
	}
	
	private void initConfig() {
		System.out.println(PropsUtil.getProperty("file_path"));
	}

	private void initDict(ServletContextEvent event) {
		// 获取spring上下文！
		app = WebApplicationContextUtils.getWebApplicationContext(event
				.getServletContext()); 
		dictServiceImpl = app.getBean(DictService.class);
		List<Map<String, Object>> dicts = dictServiceImpl.list(new HashMap<String,Object>());
		Map<String,String> inits = new HashMap<String, String>();
		for(Map<String, Object> dict:dicts){
			String value = (String) dict.get("VALUE");
			String type =(String) dict.get("TYPE");
			String no = (String) dict.get("NO");
			inits.put(type+no, value);
		}
		Constants.cache.put("dict", inits);
		System.out.println(inits.toString());
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

}