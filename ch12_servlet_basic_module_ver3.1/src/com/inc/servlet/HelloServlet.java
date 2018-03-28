package com.inc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//톰캣 3.x번대 버전부터는 web.xml이 아닌 자동화로 애너테이션(@)을 이용해 서블릿을 생성할 수 있다.

@WebServlet("/hello")
public class HelloServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int age = Integer.parseInt(request.getParameter("age"));
		response.setContentType("text/html; charSet = UTF-8");
		response.getWriter().print("<h1>당신의 나이는 " + age + " 군요?</h1>");
		
	}

	
	
}
