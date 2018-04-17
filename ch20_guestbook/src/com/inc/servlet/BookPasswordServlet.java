package com.inc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.BookDao;

@WebServlet("/book/password")
public class BookPasswordServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		//id값 유효성검사 (해킹 등으로 값이 누락될 경우 상정)
		int intId = 0;
		if(id != null) {
			intId = Integer.parseInt(id);
		}
		
		String password = BookDao.getInstance().getPassword(intId);
		response.setContentType("text/plain; charset=utf-8");
		response.getWriter().print(password);
	}


}

