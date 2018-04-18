package com.inc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.PhotoDao;

@WebServlet("/photo/passwordCheck")
public class PasswordCheckServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		String password = PhotoDao.getInstance().getPassword(id);
		System.out.println(password);
		response.setContentType("text/plain; utf-8");
		response.getWriter().print(password);
		
	}
}
