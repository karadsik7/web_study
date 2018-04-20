package com.inc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/signout")
public class SignOutServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//이 방법은 좋지 않음
		//request.getSession().setAttribute("id", null);
		
		//세션 무효화
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath() + "/main");
	}
}
