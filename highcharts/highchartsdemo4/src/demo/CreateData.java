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

import util.InsertDataToDb;

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
		InsertDataToDb idt = new InsertDataToDb();
		idt.insertData();
		Double last = idt.getLast();
		List list = new ArrayList();
		list.add(last);
		System.out.println(last+"-----------------last------"+list.get(0));
		JSONArray result = JSONArray.fromObject(list);
		out.print(result);

	}
}
