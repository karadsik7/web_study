package com.inc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.UserDao;
import com.inc.vo.UserVo;

@WebServlet("/user/modify")
public class UserModifyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao userDao = UserDao.getInstance();
		String id = request.getParameter("id");
		UserVo uvo = userDao.oneView(id);
		
		request.setAttribute("uvo", uvo);
		request.getRequestDispatcher("/views/user_modify_view.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		UserVo uvo = new UserVo();
		uvo.setId(id);
		uvo.setName(name);
		
		UserDao userDao = UserDao.getInstance();
		userDao.modify(uvo);
		
		response.sendRedirect("/ch18_userModel2/user/list");
	}

}
