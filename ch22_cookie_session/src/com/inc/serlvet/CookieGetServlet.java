package com.inc.serlvet;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/get")
public class CookieGetServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//쿠키의 배열로 가져와서 forEach로 하나씩 키값을 통해 데이터를 받을 수 있음
		Cookie[] cookies = null;
		if(request.getCookies() != null) {
			cookies = request.getCookies();
			for(Cookie i : cookies) {
				if(i.getName().equals("id")) {
					request.setAttribute("id", i.getValue());
				}
				if(i.getName().equals("name")) {
					request.setAttribute("name", 
							URLDecoder.decode(i.getValue(), "utf-8"));
				}
			}
			request.getRequestDispatcher("get.jsp").forward(request, response);
		}
		
		
	}
}
