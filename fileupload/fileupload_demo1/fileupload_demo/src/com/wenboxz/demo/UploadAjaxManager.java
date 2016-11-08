package com.wenboxz.demo;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 * 
 * @author http://www.wenboxz.com
 *
 */
public class UploadAjaxManager extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int startIndex = uri.lastIndexOf("/") + 1;
		int endIndex = uri.lastIndexOf(".");
		String action = uri.substring(startIndex, endIndex);
		if (action.equals("upload")) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			DiskFileItemFactory fac = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fac);
			upload.setHeaderEncoding("UTF-8");
			List<FileItem> fileList = new ArrayList<FileItem>();
			try {
				fileList = upload.parseRequest(request);
			} catch (FileUploadException ex) {
				ex.printStackTrace();
			}
			String targetPath = request.getSession().getServletContext()
					.getRealPath("jsp/upload")
					+ "/";
			String fileName = "blank.doc";
			for (FileItem item : fileList) {
				if (!item.isFormField()) {
					fileName = item.getName();
					File saveFile = new File(targetPath + fileName);
					try {
						item.write(saveFile);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
