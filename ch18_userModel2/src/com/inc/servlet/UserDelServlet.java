package com.inc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.UserDao;
import com.inc.vo.UserVo;

@WebServlet("/user/del")
public class UserDelServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		UserVo uvo = new UserVo();
		uvo.setId(id);
		
		UserDao userDao = UserDao.getInstance();
		userDao.del(uvo);
		
		response.sendRedirect("/ch18_userModel2/user/list");
		
	}


}
