package com.inc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.BookDao;
import com.inc.vo.BookVo;

@WebServlet("/book/modify")
public class BookModifyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		BookVo bvo = BookDao.getInstance().selectOne(id);
		request.setAttribute("bvo", bvo);
		request.getRequestDispatcher("/book/modify.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String writer = request.getParameter("writer");
		String msg = request.getParameter("msg");
		String password = request.getParameter("password");
		
		BookVo bvo = new BookVo();
		bvo.setId(id);
		bvo.setWriter(writer);
		bvo.setMsg(msg);
		bvo.setPassword(password);
		
		BookDao.getInstance().modify(bvo);
		response.sendRedirect(request.getContextPath() + "/book/list");
		
		
	}
	
	

}
