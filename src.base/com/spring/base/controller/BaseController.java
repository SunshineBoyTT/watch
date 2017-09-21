package com.spring.base.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.base.utils.BaseLogger;

public class BaseController extends BaseLogger{
	
	public static int PAGE_SIZE = 10;
	public static String PREFIX = "";
	@Value("#{config['base_url']}")
	public String baseUrl;
	@ExceptionHandler
	public String exp(HttpServletRequest request,Exception e){
		e.printStackTrace();
		request.setAttribute("e", e);
		logger.error(e.getMessage(),e);
		return "/error";
	}
	
	@RequestMapping(value="/view/{view}")
	public String index(@PathVariable String view) {
		return PREFIX+"/"+view;
	}

	/**
	 * 公共下载方法
	 * 
	 * @param response
	 * @param file
	 *            
	 * @param fileName
	 *            
	 * @return
	 * @throws Exception
	 */
	public HttpServletResponse downFile(HttpServletResponse response,
			File file, String fileName,boolean delFile) throws Exception {
		response.setContentType("application/x-download");
		response.setHeader("Pragma", "public");
		response.setHeader("Cache-Control",
				"must-revalidate, post-check=0, pre-check=0");
		OutputStream out = null;
		InputStream in = null;
		fileName = new String(fileName.getBytes("GBK"), "ISO-8859-1");
		response.addHeader("Content-disposition", "attachment;filename="
				+ fileName);// 

		try {
			out = response.getOutputStream();
			in = new FileInputStream(file);
			int len = in.available();
			byte[] b = new byte[len];
			in.read(b);
			out.write(b);
			out.flush();

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new Exception("!");
		} finally {
			if(in!=null){  
			   in.close(); 
			}
			if(out!=null){
			    out.close();
			}
			if(delFile){
				file.delete(); 
			}
		}
		return response;
	}
	
}
