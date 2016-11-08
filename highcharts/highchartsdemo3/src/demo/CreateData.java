package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
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
		List<Object> list = new ArrayList<Object>();
		for(int i = 0;i<10;i++){
			list.add(Math.random()*10+1);
		}
		System.out.println("2--------"+list.get(1));
		JSONArray result = JSONArray.fromObject(list);
		out.print(result);

	}
}
