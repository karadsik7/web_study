package com.inc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.BookDao;
import com.inc.vo.BookVo;

@WebServlet("/book/add")
public class BookAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String msg = request.getParameter("msg");
		
		BookVo bvo = new BookVo();
		bvo.setWriter(name);
		bvo.setPassword(password);
		bvo.setMsg(msg);
		bvo.setIp(request.getRemoteAddr());
		
		BookDao.getInstance().add(bvo);
		response.sendRedirect(request.getContextPath()+"/book/list");
	}
	
	
	
}
