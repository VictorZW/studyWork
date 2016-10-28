package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * 功能:highcharts示例中用于后台产生数据
 * 
 * @author Administrator
 * 
 */
public class CreateData extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charsest=utf-8");
		PrintWriter out = response.getWriter();
		/*
		 * 1.首先定义一个map集合用户存放要展现数据
		 */
		Map<String,Object> map = new HashMap<String,Object>();
		//对应的y轴数据
		map.put("y",Math.random()*10+1);
		//对应的x轴数据
		map.put("x", new Date().getTime());
		//将map集合转化为json对象
		JSONObject jsonObject = JSONObject.fromObject(map);
		out.print(jsonObject);

	}
}
