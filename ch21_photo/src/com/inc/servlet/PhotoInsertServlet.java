package com.inc.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.PhotoDao;
import com.inc.vo.PhotoVo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/photo/insert")
public class PhotoInsertServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//인설트 폼을 보여주는 요청
		request.getRequestDispatcher("insert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//서버에 파일저장
		String webPath = "/upload/";
		String realPath = request.getServletContext().getRealPath(webPath);
		MultipartRequest mr = new MultipartRequest(request, realPath, 10*1024*1024, 
				"utf-8", new DefaultFileRenamePolicy());
		
		//이제 포스트방식으로 받아온 데이터를 꺼내서 dao에게 db 처리 부탁
		
		String title = mr.getParameter("title");
		String password = mr.getParameter("password");
		String filename = mr.getFile("photo").getName();
	
		//vo로 묶어서 보내준다
		
		PhotoVo pvo = new PhotoVo();
		pvo.setTitle(title);
		pvo.setPassword(password);
		pvo.setFilename(filename);
		
		PhotoDao.getInstance().insert(pvo);
		response.sendRedirect("list");
	}
}

