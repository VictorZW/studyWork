package com.cdsoft.platform.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.cdsoft.platform.entity.FileBean;
import com.cdsoft.platform.service.FileUploadService;
import com.cdsoft.platform.util.DataGrid;
import com.cdsoft.platform.util.PropsUtil;

@Controller
@RequestMapping(value="web/fileUploadController")
public class FileUploadController {
	
	@Resource
	private FileUploadService fileUploadService;  
	
	@RequestMapping("list")
	@ResponseBody
	public DataGrid list(HttpServletRequest request) throws Exception {
		String pages = request.getParameter("page")==null ? "1":request.getParameter("page");
		String rows = request.getParameter("rows")==null ? "10":request.getParameter("rows");
		
		String fileName = request.getParameter("fileName");
		String status = request.getParameter("sfileStatus");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		Map<String,Object> param = new HashMap<String,Object>();
		int page = Integer.parseInt(pages);
		int pageSize = Integer.parseInt(rows);
		param.put("pageStart", (page-1)*pageSize+1);
		param.put("pageEnd", (page-1)*pageSize+pageSize);
		param.put("fileName", fileName);
		param.put("status",status);
		param.put("startTime",startTime);
		param.put("endTime",endTime);
		
		DataGrid data = fileUploadService.queryPage(param);
		return data;
	}
	
	
	@RequestMapping("upload")
	@ResponseBody
	public Map<String,Object> upload(HttpServletRequest request){
		Map<String,Object> map=new HashMap<>();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
		MultipartFile file = multipartRequest.getFile("file");
		long fileSize = 0L;
		try {
			fileSize = file.getSize();

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		String dec = request.getParameter("dec");
		String status = request.getParameter("fileStatus");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");  
		String str=sdf.format(new Date());
		String filename = str+"_"+file.getOriginalFilename();
		Map<String,Object> param = new HashMap<>();
		param.put("fileName", file.getOriginalFilename());
		param.put("fileCode", str);
		param.put("status", status);
		param.put("fileDesc", dec);
		param.put("fileSize", fileSize);
		param.put("createUser", SecurityUtils.getSubject().getPrincipal().toString());
		param.put("updateUser", SecurityUtils.getSubject().getPrincipal().toString());
		param.put("fileUrl", PropsUtil.getProperty("file_path")+file.getOriginalFilename());
		int count = fileUploadService.insertFile(param);
		if(count >0){
			try {
				String path = PropsUtil.getProperty("file_path")+"file";// 文件保存在硬盘的相对路径
				File source = new File(path,filename);  
				if  (!source .exists()  && !source .isDirectory())      
				{       
				    source .mkdir();    
				}
				file.transferTo(source);   
				} catch (IOException e) {
					map.put("success", false);
					e.printStackTrace();
				} 
				map.put("success", true);
		}else{
			map.put("success", false);
		}
		
		return map;
	}
	
	@RequestMapping(value="download")
	public ModelAndView download(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		Map<String,Object> param = new HashMap<>();
		String fileid = request.getParameter("fileid");
		param.put("fileid", fileid);
		FileBean fileBean = fileUploadService.download(param);
		String fileName = fileBean.getFileName();
		String fileCode = fileBean.getFileCode();
		String downloadName = fileCode+"_"+fileName;
		response.reset();
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
		return null;
	}

}
