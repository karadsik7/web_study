package com.inc.serlvet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/cookie/add")
public class CookieAddServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//쿠키 생성
		Cookie idCookie = new Cookie("id", "rrb");
		//쿠키 수명 설정 (단위 : 초)
		idCookie.setMaxAge(10);
		//쿠키는 response로 보내고 request로 읽어옴
		response.addCookie(idCookie);
		
		//실습 : 이름을 저장할 수 있는 쿠키를 생성하고 response객체에 저장
		Cookie nameCookie = new Cookie("name", URLEncoder.encode("홍길동", "utf-8"));
		nameCookie.setMaxAge(20);
		response.addCookie(nameCookie);
		request.getRequestDispatcher("add.jsp").forward(request, response);
		
		
		
		
	}

}
