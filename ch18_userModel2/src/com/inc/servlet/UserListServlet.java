package com.inc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.UserDao;
import com.inc.vo.UserVo;

@WebServlet("/user/list")
public class UserListServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao userDao = UserDao.getInstance();
		ArrayList<UserVo> userList = userDao.selectList();
		//자료를 다시 list로 넘겨줘야 하므로 forward방식으로 보냄
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/views/user_list.jsp").forward(request, response);
		
	}

}

