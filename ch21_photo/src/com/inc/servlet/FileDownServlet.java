package com.inc.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class FileDownServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String filename = request.getParameter("filename");
		String realpath = 
			request.getServletContext().getRealPath("/upload/");
		realpath += filename;
		//브라우저
		String strAgent = request.getHeader("User-Agent");
		//인코딩
		String charset = request.getCharacterEncoding();
		File file = new File(realpath);
		String value = "";
		if (strAgent.indexOf("MSIE") > -1) {
		   // IE 5.5 일 경우
		   if (strAgent.indexOf("MSIE 5.5") > -1)
		   {
		       value = "filename=" + filename ;
		   }
		   // 그밖에
		   else if (strAgent.indexOf("MSIE 7.0") > -1){
		       if (charset.equalsIgnoreCase("UTF-8") ){
		         filename = URLEncoder.encode(filename,charset);
		         filename = filename.replaceAll("\\+", " ");
		           value = "attachment; filename=\"" + filename + "\"";

		       }else{
		           value = "attachment; filename=" + new String(filename.getBytes(charset), "ISO-8859-1");

		       }
		   }else{
		     //IE 8.0이상에서는 2회 호출됨..
		     if ( charset.equalsIgnoreCase("UTF-8")){
		         filename = URLEncoder.encode(filename,"utf-8");
		         filename = filename.replaceAll("\\+", " ");
		         value = "attachment; filename=\"" + filename + "\"";
		     }else{
		         value = "attachment; filename=" + new String(filename.getBytes(charset), "ISO-8859-1");
		     }
		   }
		}else{
		   // IE 를 제외한 브라우저
		   value = "attachment; filename=" + new String(filename.getBytes(), "ISO-8859-1");
		}
		
		
		response.setContentType("Pragma: no-cache");
		//전송데이터가 stream 처리되도록 문자셋 변경
		response.setContentType(
				"application/octet-stream;charset=8859_1;");
		
		//다운로드 창이 열리게 설정
		response.setHeader("Content-Disposition", value);
		
		//전송타입 : binary
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		BufferedInputStream bis = new BufferedInputStream(
									new FileInputStream(file));
		BufferedOutputStream bos = new BufferedOutputStream(
										response.getOutputStream());
		
		int i = 0;
		while((i = bis.read()) != -1) {
			bos.write(i);
		}
		bos.close();
		bis.close();
		
	}


}




