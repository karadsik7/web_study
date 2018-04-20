package com.inc.serlvet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.vo.UserVo;

@WebServlet("/session/add")
public class SessionAddServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//세션가져오기 & 만료 기간 설정
		request.getSession().setMaxInactiveInterval(60*10);
		//문자열 보내기 키값+밸류
		request.getSession().setAttribute("msg", "ㅎㅇ");
		//객체도 보낼 수 있음 키값+밸류
		UserVo uvo = new UserVo("brb", "1234", "홍길동");
		request.getSession().setAttribute("uvo", uvo);
		
		System.out.println(request.getSession().getId());
		request.getRequestDispatcher("add.jsp").forward(request, response);
		
	}
}
