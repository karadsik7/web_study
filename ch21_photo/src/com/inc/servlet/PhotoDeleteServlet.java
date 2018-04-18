package com.inc.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.PhotoDao;

@WebServlet("/photo/delete")
public class PhotoDeleteServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String filename = request.getParameter("filename");
		//1. 서버에 저장된 파일 지우기 2. db에서도 지우기
		
		//파일의 실제 경로 반환
		String realPath = request.getServletContext().getRealPath("/upload/");
		//C:/~~~~~/!@#!@$/upload/ + image.jpg가 되는 것
		realPath = realPath + filename;
		//file객체에 삭제할 파일의 실제경로를 파라미터로 넣고 delete() 메서드 실행 
		File file = new File(realPath);
		file.delete();
		
		//db에서 로우 삭제
		PhotoDao.getInstance().delete(id);
		response.sendRedirect("list");
		
	}

}
