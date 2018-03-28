package com.inc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/parameter")
public class ParameterServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//서블릿에서 메서드는 자바 메서드가 아니라 '요청방식'을 뜻한다.
		/*String method = request.getMethod();
		System.out.println(method);
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String[] hobby = request.getParameterValues("hobby");
		System.out.println(id);
		System.out.println(password);
		System.out.println(hobby[0]);
		System.out.println(hobby[1]);*/
		
		
		//GET방식으로 요청하면 doGet으로 POST방식으로 요청하면 doPost로
		if(request.getMethod().equals("GET")) {
			doGet(request, response);
		}else {
			doPost(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
