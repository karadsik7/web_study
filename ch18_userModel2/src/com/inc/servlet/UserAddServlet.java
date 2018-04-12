package com.inc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.UserDao;
import com.inc.vo.UserVo;

@WebServlet("/user/add")
public class UserAddServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		UserVo uvo = new UserVo();
		uvo.setId(id);
		uvo.setName(name);
		
		UserDao userDao = UserDao.getInstance();
		userDao.insert(uvo);
		
		response.sendRedirect("/ch18_userModel2/user/list");
		
	}

	
}

